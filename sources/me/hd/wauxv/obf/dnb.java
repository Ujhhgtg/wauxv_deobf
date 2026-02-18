package me.hd.wauxv.obf;

import java.io.Closeable;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dnb implements Closeable {
    public final FileInputStream a;
    public final Charset b;
    public byte[] c;
    public int d;
    public int e;

    public dnb(FileInputStream fileInputStream, Charset charset) {
        if (charset == null) {
            throw null;
        }
        if (!charset.equals(eou.a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.a = fileInputStream;
        this.b = charset;
        this.c = new byte[8192];
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this.a) {
            try {
                if (this.c != null) {
                    this.c = null;
                    this.a.close();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Found duplicated region for block: B:25:0x0040  */
    public final String f() {
        int i;
        synchronized (this.a) {
            try {
                byte[] bArr = this.c;
                if (bArr == null) {
                    throw new IOException("LineReader is closed");
                }
                if (this.d >= this.e) {
                    int i2 = this.a.read(bArr, 0, bArr.length);
                    if (i2 == -1) {
                        throw new EOFException();
                    }
                    this.d = 0;
                    this.e = i2;
                }
                for (int i3 = this.d; i3 != this.e; i3++) {
                    byte[] bArr2 = this.c;
                    if (bArr2[i3] == 10) {
                        int i4 = this.d;
                        if (i3 != i4) {
                            i = i3 - 1;
                            if (bArr2[i] != 13) {
                                i = i3;
                            }
                        } else {
                            i = i3;
                        }
                        String str = new String(bArr2, i4, i - i4, this.b.name());
                        this.d = i3 + 1;
                        return str;
                    }
                }
                dna dnaVar = new dna(this, (this.e - this.d) + 80);
                while (true) {
                    byte[] bArr3 = this.c;
                    int i5 = this.d;
                    dnaVar.write(bArr3, i5, this.e - i5);
                    this.e = -1;
                    FileInputStream fileInputStream = this.a;
                    byte[] bArr4 = this.c;
                    int i6 = fileInputStream.read(bArr4, 0, bArr4.length);
                    if (i6 == -1) {
                        throw new EOFException();
                    }
                    this.d = 0;
                    this.e = i6;
                    for (int i7 = 0; i7 != this.e; i7++) {
                        byte[] bArr5 = this.c;
                        if (bArr5[i7] == 10) {
                            int i8 = this.d;
                            if (i7 != i8) {
                                dnaVar.write(bArr5, i8, i7 - i8);
                            }
                            this.d = i7 + 1;
                            return dnaVar.toString();
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
