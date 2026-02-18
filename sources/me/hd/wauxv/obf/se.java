package me.hd.wauxv.obf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class se extends InputStream {
    public final ByteBuffer a;
    public int b = -1;

    public se(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.a.remaining();
    }

    @Override // java.io.InputStream
    public final synchronized void mark(int i) {
        this.b = this.a.position();
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public final int read() {
        ByteBuffer byteBuffer = this.a;
        if (byteBuffer.hasRemaining()) {
            return byteBuffer.get() & 255;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        int i = this.b;
        if (i == -1) {
            throw new IOException("Cannot reset to unset mark position");
        }
        this.a.position(i);
    }

    @Override // java.io.InputStream
    public final long skip(long j) {
        ByteBuffer byteBuffer = this.a;
        if (!byteBuffer.hasRemaining()) {
            return -1L;
        }
        long jMin = Math.min(j, byteBuffer.remaining());
        byteBuffer.position((int) (((long) byteBuffer.position()) + jMin));
        return jMin;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) {
        ByteBuffer byteBuffer = this.a;
        if (!byteBuffer.hasRemaining()) {
            return -1;
        }
        int iMin = Math.min(i2, byteBuffer.remaining());
        byteBuffer.get(bArr, i, iMin);
        return iMin;
    }
}
