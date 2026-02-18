package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.Random;
import me.hd.wauxv.obf.bzo;
import me.hd.wauxv.obf.rf;
import me.hd.wauxv.obf.rh;
import me.hd.wauxv.obf.rl;
import me.hd.wauxv.obf.sj;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class WebSocketWriter implements Closeable {
    private final boolean isClient;
    private final rf maskCursor;
    private final byte[] maskKey;
    private final rh messageBuffer;
    private MessageDeflater messageDeflater;
    private final long minimumDeflateSize;
    private final boolean noContextTakeover;
    private final boolean perMessageDeflate;
    private final Random random;
    private final rl sink;
    private final rh sinkBuffer;
    private boolean writerClosed;

    public WebSocketWriter(boolean z, rl rlVar, Random random, boolean z2, boolean z3, long j) {
        bzo.q(rlVar, "sink");
        bzo.q(random, "random");
        this.isClient = z;
        this.sink = rlVar;
        this.random = random;
        this.perMessageDeflate = z2;
        this.noContextTakeover = z3;
        this.minimumDeflateSize = j;
        this.messageBuffer = new rh();
        this.sinkBuffer = rlVar.c();
        this.maskKey = z ? new byte[4] : null;
        this.maskCursor = z ? new rf() : null;
    }

    private final void writeControlFrame(int i, sj sjVar) throws IOException {
        if (this.writerClosed) {
            throw new IOException("closed");
        }
        int iG = sjVar.g();
        if (iG > 125) {
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        this.sinkBuffer.am(i | 128);
        if (this.isClient) {
            this.sinkBuffer.am(iG | 128);
            Random random = this.random;
            byte[] bArr = this.maskKey;
            bzo.n(bArr);
            random.nextBytes(bArr);
            this.sinkBuffer.m12write(this.maskKey);
            if (iG > 0) {
                rh rhVar = this.sinkBuffer;
                long j = rhVar.b;
                rhVar.al(sjVar);
                rh rhVar2 = this.sinkBuffer;
                rf rfVar = this.maskCursor;
                bzo.n(rfVar);
                rhVar2.v(rfVar);
                this.maskCursor.i(j);
                WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        } else {
            this.sinkBuffer.am(iG);
            this.sinkBuffer.al(sjVar);
        }
        this.sink.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        MessageDeflater messageDeflater = this.messageDeflater;
        if (messageDeflater != null) {
            messageDeflater.close();
        }
    }

    public final Random getRandom() {
        return this.random;
    }

    public final rl getSink() {
        return this.sink;
    }

    public final void writeClose(int i, sj sjVar) throws EOFException {
        sj sjVarE = sj.a;
        if (i != 0 || sjVar != null) {
            if (i != 0) {
                WebSocketProtocol.INSTANCE.validateCloseCode(i);
            }
            rh rhVar = new rh();
            rhVar.ar(i);
            if (sjVar != null) {
                rhVar.al(sjVar);
            }
            sjVarE = rhVar.e(rhVar.b);
        }
        try {
            writeControlFrame(8, sjVarE);
        } finally {
            this.writerClosed = true;
        }
    }

    public final void writeMessageFrame(int i, sj sjVar) throws IOException {
        bzo.q(sjVar, "data");
        if (this.writerClosed) {
            throw new IOException("closed");
        }
        this.messageBuffer.al(sjVar);
        int i2 = i | 128;
        if (this.perMessageDeflate && sjVar.g() >= this.minimumDeflateSize) {
            MessageDeflater messageDeflater = this.messageDeflater;
            if (messageDeflater == null) {
                messageDeflater = new MessageDeflater(this.noContextTakeover);
                this.messageDeflater = messageDeflater;
            }
            messageDeflater.deflate(this.messageBuffer);
            i2 = i | 192;
        }
        long j = this.messageBuffer.b;
        this.sinkBuffer.am(i2);
        int i3 = this.isClient ? 128 : 0;
        if (j <= 125) {
            this.sinkBuffer.am(i3 | ((int) j));
        } else if (j <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            this.sinkBuffer.am(i3 | 126);
            this.sinkBuffer.ar((int) j);
        } else {
            this.sinkBuffer.am(i3 | 127);
            this.sinkBuffer.aq(j);
        }
        if (this.isClient) {
            Random random = this.random;
            byte[] bArr = this.maskKey;
            bzo.n(bArr);
            random.nextBytes(bArr);
            this.sinkBuffer.m12write(this.maskKey);
            if (j > 0) {
                rh rhVar = this.messageBuffer;
                rf rfVar = this.maskCursor;
                bzo.n(rfVar);
                rhVar.v(rfVar);
                this.maskCursor.i(0L);
                WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        }
        this.sinkBuffer.write(this.messageBuffer, j);
        this.sink.g();
    }

    public final void writePing(sj sjVar) {
        bzo.q(sjVar, "payload");
        writeControlFrame(9, sjVar);
    }

    public final void writePong(sj sjVar) throws IOException {
        bzo.q(sjVar, "payload");
        writeControlFrame(10, sjVar);
    }
}
