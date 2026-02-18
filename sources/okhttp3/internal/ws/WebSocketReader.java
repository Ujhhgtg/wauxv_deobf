package okhttp3.internal.ws;

import com.android.dx.io.Opcodes;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import me.hd.wauxv.obf.bzo;
import me.hd.wauxv.obf.rf;
import me.hd.wauxv.obf.rh;
import me.hd.wauxv.obf.rm;
import me.hd.wauxv.obf.sj;
import okhttp3.internal.Util;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class WebSocketReader implements Closeable {
    private boolean closed;
    private final rh controlFrameBuffer;
    private final FrameCallback frameCallback;
    private long frameLength;
    private final boolean isClient;
    private boolean isControlFrame;
    private boolean isFinalFrame;
    private final rf maskCursor;
    private final byte[] maskKey;
    private final rh messageFrameBuffer;
    private MessageInflater messageInflater;
    private final boolean noContextTakeover;
    private int opcode;
    private final boolean perMessageDeflate;
    private boolean readingCompressedMessage;
    private final rm source;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface FrameCallback {
        void onReadClose(int i, String str);

        void onReadMessage(String str);

        void onReadMessage(sj sjVar);

        void onReadPing(sj sjVar);

        void onReadPong(sj sjVar);
    }

    public WebSocketReader(boolean z, rm rmVar, FrameCallback frameCallback, boolean z2, boolean z3) {
        bzo.q(rmVar, "source");
        bzo.q(frameCallback, "frameCallback");
        this.isClient = z;
        this.source = rmVar;
        this.frameCallback = frameCallback;
        this.perMessageDeflate = z2;
        this.noContextTakeover = z3;
        this.controlFrameBuffer = new rh();
        this.messageFrameBuffer = new rh();
        this.maskKey = z ? null : new byte[4];
        this.maskCursor = z ? null : new rf();
    }

    private final void readControlFrame() throws ProtocolException, EOFException {
        short s;
        String strAc;
        long j = this.frameLength;
        if (j > 0) {
            this.source.p(this.controlFrameBuffer, j);
            if (!this.isClient) {
                rh rhVar = this.controlFrameBuffer;
                rf rfVar = this.maskCursor;
                bzo.n(rfVar);
                rhVar.v(rfVar);
                this.maskCursor.i(0L);
                WebSocketProtocol webSocketProtocol = WebSocketProtocol.INSTANCE;
                rf rfVar2 = this.maskCursor;
                byte[] bArr = this.maskKey;
                bzo.n(bArr);
                webSocketProtocol.toggleMask(rfVar2, bArr);
                this.maskCursor.close();
            }
        }
        switch (this.opcode) {
            case 8:
                rh rhVar2 = this.controlFrameBuffer;
                long j2 = rhVar2.b;
                if (j2 == 1) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                if (j2 != 0) {
                    s = rhVar2.readShort();
                    strAc = this.controlFrameBuffer.ac();
                    String strCloseCodeExceptionMessage = WebSocketProtocol.INSTANCE.closeCodeExceptionMessage(s);
                    if (strCloseCodeExceptionMessage != null) {
                        throw new ProtocolException(strCloseCodeExceptionMessage);
                    }
                } else {
                    s = 1005;
                    strAc = "";
                }
                this.frameCallback.onReadClose(s, strAc);
                this.closed = true;
                return;
            case 9:
                FrameCallback frameCallback = this.frameCallback;
                rh rhVar3 = this.controlFrameBuffer;
                frameCallback.onReadPing(rhVar3.e(rhVar3.b));
                return;
            case 10:
                FrameCallback frameCallback2 = this.frameCallback;
                rh rhVar4 = this.controlFrameBuffer;
                frameCallback2.onReadPong(rhVar4.e(rhVar4.b));
                return;
            default:
                throw new ProtocolException("Unknown control opcode: " + Util.toHexString(this.opcode));
        }
    }

    private final void readHeader() throws IOException {
        boolean z;
        if (this.closed) {
            throw new IOException("closed");
        }
        long jTimeoutNanos = this.source.timeout().timeoutNanos();
        this.source.timeout().clearTimeout();
        try {
            int iAnd = Util.and(this.source.readByte(), Opcodes.CONST_METHOD_TYPE);
            this.source.timeout().timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
            int i = iAnd & 15;
            this.opcode = i;
            boolean z2 = (iAnd & 128) != 0;
            this.isFinalFrame = z2;
            boolean z3 = (iAnd & 8) != 0;
            this.isControlFrame = z3;
            if (z3 && !z2) {
                throw new ProtocolException("Control frames must be final.");
            }
            boolean z4 = (iAnd & 64) != 0;
            if (i == 1 || i == 2) {
                if (!z4) {
                    z = false;
                } else {
                    if (!this.perMessageDeflate) {
                        throw new ProtocolException("Unexpected rsv1 flag");
                    }
                    z = true;
                }
                this.readingCompressedMessage = z;
            } else if (z4) {
                throw new ProtocolException("Unexpected rsv1 flag");
            }
            if ((iAnd & 32) != 0) {
                throw new ProtocolException("Unexpected rsv2 flag");
            }
            if ((iAnd & 16) != 0) {
                throw new ProtocolException("Unexpected rsv3 flag");
            }
            int iAnd2 = Util.and(this.source.readByte(), Opcodes.CONST_METHOD_TYPE);
            boolean z5 = (iAnd2 & 128) != 0;
            if (z5 == this.isClient) {
                throw new ProtocolException(this.isClient ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
            }
            long j = iAnd2 & 127;
            this.frameLength = j;
            if (j == 126) {
                this.frameLength = Util.and(this.source.readShort(), 65535);
            } else if (j == 127) {
                long j2 = this.source.readLong();
                this.frameLength = j2;
                if (j2 < 0) {
                    throw new ProtocolException("Frame length 0x" + Util.toHexString(this.frameLength) + " > 0x7FFFFFFFFFFFFFFF");
                }
            }
            if (this.isControlFrame && this.frameLength > 125) {
                throw new ProtocolException("Control frame must be less than 125B.");
            }
            if (z5) {
                rm rmVar = this.source;
                byte[] bArr = this.maskKey;
                bzo.n(bArr);
                rmVar.readFully(bArr);
            }
        } catch (Throwable th) {
            this.source.timeout().timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
            throw th;
        }
    }

    private final void readMessage() throws IOException {
        while (!this.closed) {
            long j = this.frameLength;
            if (j > 0) {
                this.source.p(this.messageFrameBuffer, j);
                if (!this.isClient) {
                    rh rhVar = this.messageFrameBuffer;
                    rf rfVar = this.maskCursor;
                    bzo.n(rfVar);
                    rhVar.v(rfVar);
                    this.maskCursor.i(this.messageFrameBuffer.b - this.frameLength);
                    WebSocketProtocol webSocketProtocol = WebSocketProtocol.INSTANCE;
                    rf rfVar2 = this.maskCursor;
                    byte[] bArr = this.maskKey;
                    bzo.n(bArr);
                    webSocketProtocol.toggleMask(rfVar2, bArr);
                    this.maskCursor.close();
                }
            }
            if (this.isFinalFrame) {
                return;
            }
            readUntilNonControlFrame();
            if (this.opcode != 0) {
                throw new ProtocolException("Expected continuation opcode. Got: " + Util.toHexString(this.opcode));
            }
        }
        throw new IOException("closed");
    }

    private final void readMessageFrame() throws IOException {
        int i = this.opcode;
        if (i != 1 && i != 2) {
            throw new ProtocolException("Unknown opcode: " + Util.toHexString(i));
        }
        readMessage();
        if (this.readingCompressedMessage) {
            MessageInflater messageInflater = this.messageInflater;
            if (messageInflater == null) {
                messageInflater = new MessageInflater(this.noContextTakeover);
                this.messageInflater = messageInflater;
            }
            messageInflater.inflate(this.messageFrameBuffer);
        }
        if (i == 1) {
            this.frameCallback.onReadMessage(this.messageFrameBuffer.ac());
            return;
        }
        FrameCallback frameCallback = this.frameCallback;
        rh rhVar = this.messageFrameBuffer;
        frameCallback.onReadMessage(rhVar.e(rhVar.b));
    }

    private final void readUntilNonControlFrame() throws IOException {
        while (!this.closed) {
            readHeader();
            if (!this.isControlFrame) {
                return;
            } else {
                readControlFrame();
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        MessageInflater messageInflater = this.messageInflater;
        if (messageInflater != null) {
            messageInflater.close();
        }
    }

    public final rm getSource() {
        return this.source;
    }

    public final void processNextFrame() {
        readHeader();
        if (this.isControlFrame) {
            readControlFrame();
        } else {
            readMessageFrame();
        }
    }
}
