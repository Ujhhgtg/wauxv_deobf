package me.hd.wauxv.obf;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cyp extends FilterInputStream {
    public volatile byte[] a;
    public int b;
    public int c;
    public int d;
    public int e;
    public final bva f;

    public cyp(InputStream inputStream, bva bvaVar) {
        super(inputStream);
        this.d = -1;
        this.f = bvaVar;
        this.a = (byte[]) bvaVar.i(65536, byte[].class);
    }

    public static void g() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int available() {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.a == null || inputStream == null) {
            g();
            throw null;
        }
        return (this.b - this.e) + inputStream.available();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.a != null) {
            this.f.m(this.a);
            this.a = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public final int h(InputStream inputStream, byte[] bArr) throws IOException {
        int i = this.d;
        if (i != -1) {
            int i2 = this.e - i;
            int i3 = this.c;
            if (i2 < i3) {
                if (i == 0 && i3 > bArr.length && this.b == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i3) {
                        i3 = length;
                    }
                    byte[] bArr2 = (byte[]) this.f.i(i3, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.a = bArr2;
                    this.f.m(bArr);
                    bArr = bArr2;
                } else if (i > 0) {
                    System.arraycopy(bArr, i, bArr, 0, bArr.length - i);
                }
                int i4 = this.e - this.d;
                this.e = i4;
                this.d = 0;
                this.b = 0;
                int i5 = inputStream.read(bArr, i4, bArr.length - i4);
                int i6 = this.e;
                if (i5 > 0) {
                    i6 += i5;
                }
                this.b = i6;
                return i5;
            }
        }
        int i7 = inputStream.read(bArr);
        if (i7 > 0) {
            this.d = -1;
            this.e = 0;
            this.b = i7;
        }
        return i7;
    }

    public final synchronized void i() {
        if (this.a != null) {
            this.f.m(this.a);
            this.a = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i) {
        this.c = Math.max(this.c, i);
        this.d = this.e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read() {
        byte[] bArr = this.a;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            g();
            throw null;
        }
        if (this.e >= this.b && h(inputStream, bArr) == -1) {
            return -1;
        }
        if (bArr != this.a && (bArr = this.a) == null) {
            g();
            throw null;
        }
        int i = this.b;
        int i2 = this.e;
        if (i - i2 <= 0) {
            return -1;
        }
        this.e = i2 + 1;
        return bArr[i2] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() {
        if (this.a == null) {
            throw new IOException("Stream is closed");
        }
        int i = this.d;
        if (-1 == i) {
            throw new azv("Mark has been invalidated, pos: " + this.e + " markLimit: " + this.c);
        }
        this.e = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized long skip(long j) {
        if (j < 1) {
            return 0L;
        }
        byte[] bArr = this.a;
        if (bArr == null) {
            g();
            throw null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream == null) {
            g();
            throw null;
        }
        int i = this.b;
        int i2 = this.e;
        if (i - i2 >= j) {
            this.e = (int) (((long) i2) + j);
            return j;
        }
        long j2 = ((long) i) - ((long) i2);
        this.e = i;
        if (this.d == -1 || j > this.c) {
            long jSkip = inputStream.skip(j - j2);
            if (jSkip > 0) {
                this.d = -1;
            }
            return j2 + jSkip;
        }
        if (h(inputStream, bArr) == -1) {
            return j2;
        }
        int i3 = this.b;
        int i4 = this.e;
        if (i3 - i4 >= j - j2) {
            this.e = (int) ((((long) i4) + j) - j2);
            return j;
        }
        long j3 = (j2 + ((long) i3)) - ((long) i4);
        this.e = i3;
        return j3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        byte[] bArr2 = this.a;
        if (bArr2 == null) {
            g();
            throw null;
        }
        if (i2 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream != null) {
            int i5 = this.e;
            int i6 = this.b;
            if (i5 < i6) {
                int i7 = i6 - i5;
                if (i7 >= i2) {
                    i7 = i2;
                }
                System.arraycopy(bArr2, i5, bArr, i, i7);
                this.e += i7;
                if (i7 == i2 || inputStream.available() == 0) {
                    return i7;
                }
                i += i7;
                i3 = i2 - i7;
            } else {
                i3 = i2;
            }
            while (true) {
                if (this.d == -1 && i3 >= bArr2.length) {
                    i4 = inputStream.read(bArr, i, i3);
                    if (i4 == -1) {
                        return i3 != i2 ? i2 - i3 : -1;
                    }
                } else {
                    if (h(inputStream, bArr2) == -1) {
                        return i3 != i2 ? i2 - i3 : -1;
                    }
                    if (bArr2 != this.a && (bArr2 = this.a) == null) {
                        g();
                        throw null;
                    }
                    int i8 = this.b;
                    int i9 = this.e;
                    i4 = i8 - i9;
                    if (i4 >= i3) {
                        i4 = i3;
                    }
                    System.arraycopy(bArr2, i9, bArr, i, i4);
                    this.e += i4;
                }
                i3 -= i4;
                if (i3 == 0) {
                    return i2;
                }
                if (inputStream.available() == 0) {
                    return i2 - i3;
                }
                i += i4;
            }
        } else {
            g();
            throw null;
        }
    }
}
