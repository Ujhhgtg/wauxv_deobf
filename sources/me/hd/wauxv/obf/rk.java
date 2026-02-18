package me.hd.wauxv.obf;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class rk extends OutputStream {
    public final FileOutputStream a;
    public byte[] b;
    public final bva c;
    public int d;

    public rk(FileOutputStream fileOutputStream, bva bvaVar) {
        this.a = fileOutputStream;
        this.c = bvaVar;
        this.b = (byte[]) bvaVar.i(65536, byte[].class);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        FileOutputStream fileOutputStream = this.a;
        try {
            flush();
            fileOutputStream.close();
            byte[] bArr = this.b;
            if (bArr != null) {
                this.c.m(bArr);
                this.b = null;
            }
        } catch (Throwable th) {
            fileOutputStream.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() throws IOException {
        int i = this.d;
        FileOutputStream fileOutputStream = this.a;
        if (i > 0) {
            fileOutputStream.write(this.b, 0, i);
            this.d = 0;
        }
        fileOutputStream.flush();
    }

    @Override // java.io.OutputStream
    public final void write(int i) throws IOException {
        byte[] bArr = this.b;
        int i2 = this.d;
        int i3 = i2 + 1;
        this.d = i3;
        bArr[i2] = (byte) i;
        if (i3 != bArr.length || i3 <= 0) {
            return;
        }
        this.a.write(bArr, 0, i3);
        this.d = 0;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        do {
            int i4 = i2 - i3;
            int i5 = i + i3;
            int i6 = this.d;
            FileOutputStream fileOutputStream = this.a;
            if (i6 == 0 && i4 >= this.b.length) {
                fileOutputStream.write(bArr, i5, i4);
                return;
            }
            int iMin = Math.min(i4, this.b.length - i6);
            System.arraycopy(bArr, i5, this.b, this.d, iMin);
            int i7 = this.d + iMin;
            this.d = i7;
            i3 += iMin;
            byte[] bArr2 = this.b;
            if (i7 == bArr2.length && i7 > 0) {
                fileOutputStream.write(bArr2, 0, i7);
                this.d = 0;
            }
        } while (i3 < i2);
    }
}
