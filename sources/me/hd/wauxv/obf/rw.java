package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class rw {
    public static final int[] a;
    public byte[] b = new byte[32];
    public int c;

    static {
        int[] iArr = new int[65];
        for (int i = 0; i < 65; i++) {
            iArr[i] = (63 - i) / 7;
        }
        a = iArr;
    }

    public final void d(int i, long j) {
        for (int i2 = 0; i2 < i; i2++) {
            this.b[this.c + i2] = (byte) ((127 & j) | 128);
            j >>>= 7;
        }
        byte[] bArr = this.b;
        int i3 = this.c;
        bArr[i3 + i] = (byte) j;
        this.c = i + 1 + i3;
    }

    public final void e(int i) {
        int i2 = this.c + i;
        if (i2 <= this.b.length) {
            return;
        }
        byte[] bArr = new byte[Integer.highestOneBit(i2) << 1];
        SomeStaticHelpers._an(this.b, 0, 0, bArr, 14);
        this.b = bArr;
    }

    public final void f(int i) {
        e(4);
        for (int i2 = 3; -1 < i2; i2--) {
            byte[] bArr = this.b;
            int i3 = this.c;
            this.c = i3 + 1;
            bArr[i3] = (byte) (i >> (i2 * 8));
        }
    }

    public final void g(long j) {
        e(8);
        for (int i = 7; -1 < i; i--) {
            byte[] bArr = this.b;
            int i2 = this.c;
            this.c = i2 + 1;
            bArr[i2] = (byte) (j >> (i * 8));
        }
    }
}
