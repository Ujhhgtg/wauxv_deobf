package me.hd.wauxv.obf;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class axb extends InputStream {
    public static final ArrayDeque a;
    public cyp b;
    public IOException c;

    static {
        char[] cArr = eot.a;
        a = new ArrayDeque(0);
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.b.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.b.close();
    }

    @Override // java.io.InputStream
    public final void mark(int i) {
        this.b.mark(i);
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        this.b.getClass();
        return true;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        try {
            return this.b.read();
        } catch (IOException e) {
            this.c = e;
            throw e;
        }
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        this.b.reset();
    }

    @Override // java.io.InputStream
    public final long skip(long j) throws IOException {
        try {
            return this.b.skip(j);
        } catch (IOException e) {
            this.c = e;
            throw e;
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        try {
            return this.b.read(bArr);
        } catch (IOException e) {
            this.c = e;
            throw e;
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        try {
            return this.b.read(bArr, i, i2);
        } catch (IOException e) {
            this.c = e;
            throw e;
        }
    }
}
