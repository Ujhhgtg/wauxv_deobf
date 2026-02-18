package okhttp3.internal.http2;

import com.android.dx.io.Opcodes;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.hd.wauxv.obf.akd;
import me.hd.wauxv.obf.bjs;
import me.hd.wauxv.obf.bzo;
import me.hd.wauxv.obf.rh;
import me.hd.wauxv.obf.rl;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class Http2Writer implements Closeable {
    public static final Companion Companion = new Companion(null);
    private static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private boolean closed;
    private final rh hpackBuffer;
    private final Hpack.Writer hpackWriter;
    private int maxFrameSize;
    private final rl sink;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static final class Companion {
        public /* synthetic */ Companion(akd akdVar) {
            this();
        }

        private Companion() {
        }
    }

    public Http2Writer(rl rlVar, boolean z) {
        bzo.q(rlVar, "sink");
        this.sink = rlVar;
        this.client = z;
        rh rhVar = new rh();
        this.hpackBuffer = rhVar;
        this.maxFrameSize = 16384;
        this.hpackWriter = new Hpack.Writer(0, false, rhVar, 3, null);
    }

    private final void writeContinuationFrames(int i, long j) {
        while (j > 0) {
            long jMin = Math.min(this.maxFrameSize, j);
            j -= jMin;
            frameHeader(i, (int) jMin, 9, j == 0 ? 4 : 0);
            this.sink.write(this.hpackBuffer, jMin);
        }
    }

    public final synchronized void applyAndAckSettings(Settings settings) {
        try {
            bzo.q(settings, "peerSettings");
            if (this.closed) {
                throw new IOException("closed");
            }
            this.maxFrameSize = settings.getMaxFrameSize(this.maxFrameSize);
            if (settings.getHeaderTableSize() != -1) {
                this.hpackWriter.resizeHeaderTable(settings.getHeaderTableSize());
            }
            frameHeader(0, 0, 4, 1);
            this.sink.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.closed = true;
        this.sink.close();
    }

    public final synchronized void connectionPreface() {
        try {
            if (this.closed) {
                throw new IOException("closed");
            }
            if (this.client) {
                Logger logger2 = logger;
                if (logger2.isLoggable(Level.FINE)) {
                    logger2.fine(Util.format(">> CONNECTION " + Http2.CONNECTION_PREFACE.h(), new Object[0]));
                }
                this.sink.ae(Http2.CONNECTION_PREFACE);
                this.sink.flush();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void data(boolean z, int i, rh rhVar, int i2) {
        if (this.closed) {
            throw new IOException("closed");
        }
        dataFrame(i, z ? 1 : 0, rhVar, i2);
    }

    public final void dataFrame(int i, int i2, rh rhVar, int i3) {
        frameHeader(i, i3, 0, i2);
        if (i3 > 0) {
            rl rlVar = this.sink;
            bzo.n(rhVar);
            rlVar.write(rhVar, i3);
        }
    }

    public final synchronized void flush() {
        if (this.closed) {
            throw new IOException("closed");
        }
        this.sink.flush();
    }

    public final void frameHeader(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        Logger logger2 = logger;
        if (logger2.isLoggable(Level.FINE)) {
            i5 = i;
            i6 = i2;
            i7 = i3;
            i8 = i4;
            logger2.fine(Http2.INSTANCE.frameLog(false, i5, i6, i7, i8));
        } else {
            i5 = i;
            i6 = i2;
            i7 = i3;
            i8 = i4;
        }
        if (i6 > this.maxFrameSize) {
            throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.maxFrameSize + ": " + i6).toString());
        }
        if ((Integer.MIN_VALUE & i5) != 0) {
            throw new IllegalArgumentException(bjs.i(i5, "reserved bit set: ").toString());
        }
        Util.writeMedium(this.sink, i6);
        this.sink.writeByte(i7 & Opcodes.CONST_METHOD_TYPE);
        this.sink.writeByte(i8 & Opcodes.CONST_METHOD_TYPE);
        this.sink.writeInt(Integer.MAX_VALUE & i5);
    }

    public final Hpack.Writer getHpackWriter() {
        return this.hpackWriter;
    }

    public final synchronized void goAway(int i, ErrorCode errorCode, byte[] bArr) {
        bzo.q(errorCode, "errorCode");
        bzo.q(bArr, "debugData");
        if (this.closed) {
            throw new IOException("closed");
        }
        if (errorCode.getHttpCode() == -1) {
            throw new IllegalArgumentException("errorCode.httpCode == -1");
        }
        frameHeader(0, bArr.length + 8, 7, 0);
        this.sink.writeInt(i);
        this.sink.writeInt(errorCode.getHttpCode());
        if (bArr.length != 0) {
            this.sink.write(bArr);
        }
        this.sink.flush();
    }

    public final synchronized void headers(boolean z, int i, List<Header> list) {
        bzo.q(list, "headerBlock");
        if (this.closed) {
            throw new IOException("closed");
        }
        this.hpackWriter.writeHeaders(list);
        long j = this.hpackBuffer.b;
        long jMin = Math.min(this.maxFrameSize, j);
        int i2 = j == jMin ? 4 : 0;
        if (z) {
            i2 |= 1;
        }
        frameHeader(i, (int) jMin, 1, i2);
        this.sink.write(this.hpackBuffer, jMin);
        if (j > jMin) {
            writeContinuationFrames(i, j - jMin);
        }
    }

    public final int maxDataLength() {
        return this.maxFrameSize;
    }

    public final synchronized void ping(boolean z, int i, int i2) {
        if (this.closed) {
            throw new IOException("closed");
        }
        frameHeader(0, 8, 6, z ? 1 : 0);
        this.sink.writeInt(i);
        this.sink.writeInt(i2);
        this.sink.flush();
    }

    public final synchronized void pushPromise(int i, int i2, List<Header> list) {
        bzo.q(list, "requestHeaders");
        if (this.closed) {
            throw new IOException("closed");
        }
        this.hpackWriter.writeHeaders(list);
        long j = this.hpackBuffer.b;
        int iMin = (int) Math.min(((long) this.maxFrameSize) - 4, j);
        long j2 = iMin;
        frameHeader(i, iMin + 4, 5, j == j2 ? 4 : 0);
        this.sink.writeInt(i2 & Integer.MAX_VALUE);
        this.sink.write(this.hpackBuffer, j2);
        if (j > j2) {
            writeContinuationFrames(i, j - j2);
        }
    }

    public final synchronized void rstStream(int i, ErrorCode errorCode) {
        bzo.q(errorCode, "errorCode");
        if (this.closed) {
            throw new IOException("closed");
        }
        if (errorCode.getHttpCode() == -1) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        frameHeader(i, 4, 3, 0);
        this.sink.writeInt(errorCode.getHttpCode());
        this.sink.flush();
    }

    public final synchronized void settings(Settings settings) {
        try {
            bzo.q(settings, "settings");
            if (this.closed) {
                throw new IOException("closed");
            }
            int i = 0;
            frameHeader(0, settings.size() * 6, 4, 0);
            while (i < 10) {
                if (settings.isSet(i)) {
                    this.sink.writeShort(i != 4 ? i != 7 ? i : 4 : 3);
                    this.sink.writeInt(settings.get(i));
                }
                i++;
            }
            this.sink.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void windowUpdate(int i, long j) {
        if (this.closed) {
            throw new IOException("closed");
        }
        if (j == 0 || j > 2147483647L) {
            throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j).toString());
        }
        frameHeader(i, 4, 8, 0);
        this.sink.writeInt((int) j);
        this.sink.flush();
    }
}
