package me.hd.wauxv.obf;

import com.alibaba.fastjson2.JSONB;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class axp extends FilterInputStream {
    public static final byte[] a = { -1, -31, 0, 28, 69, JSONB.Constants.BC_STR_ASCII_FIX_MAX,
            JSONB.Constants.BC_STR_ASCII_FIX_32, 102, 0, 0, JSONB.Constants.BC_STR_ASCII_FIX_4,
            JSONB.Constants.BC_STR_ASCII_FIX_4, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0 };
    public static final int b = 31;
    public final byte c;
    public int d;

    public axp(InputStream inputStream, int i) {
        super(inputStream);
        if (i < -1 || i > 8) {
            throw new IllegalArgumentException(concatVar2Var1(i, "Cannot add invalid orientation: "));
        }
        this.c = (byte) i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final void mark(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() {
        int i;
        int i2 = this.d;
        int i3 = (i2 < 2 || i2 > (i = b)) ? super.read() : i2 == i ? this.c : a[i2 - 2] & 255;
        if (i3 != -1) {
            this.d++;
        }
        return i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final void reset() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j) throws IOException {
        long jSkip = super.skip(j);
        if (jSkip > 0) {
            this.d = (int) (((long) this.d) + jSkip);
        }
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        int i4 = this.d;
        int i5 = b;
        if (i4 > i5) {
            i3 = super.read(bArr, i, i2);
        } else if (i4 == i5) {
            bArr[i] = this.c;
            i3 = 1;
        } else if (i4 < 2) {
            i3 = super.read(bArr, i, 2 - i4);
        } else {
            int iMin = Math.min(i5 - i4, i2);
            System.arraycopy(a, this.d - 2, bArr, i, iMin);
            i3 = iMin;
        }
        if (i3 > 0) {
            this.d += i3;
        }
        return i3;
    }
}
