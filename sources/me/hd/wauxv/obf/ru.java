package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ru {
    public final int a;
    public int b;
    public final byte[] c;

    public ru(byte[] bArr, int i) {
        throwIfVar1IsNull(bArr, "array");
        this.c = bArr;
        this.a = i;
    }

    public void d(int i) {
        int i2 = this.b;
        int i3 = this.a;
        if (i <= i3 - i2) {
            return;
        }
        throw new dgb("Unexpected EOF, available " + (i3 - this.b) + " bytes, requested: " + i);
    }

    public int e() {
        int i = this.b;
        if (i >= this.a) {
            return -1;
        }
        this.b = i + 1;
        return this.c[i] & 255;
    }

    public String f(int i) {
        int i2 = this.b;
        int i3 = i2 + i;
        byte[] bArr = this.c;
        throwIfVar1IsNull(bArr, "<this>");
        cnh.j(i2, i3, bArr.length);
        String str = new String(bArr, i2, i3 - i2, uj.a);
        this.b += i;
        return str;
    }

    public long g(boolean z) {
        int i = this.b;
        int i2 = this.a;
        if (i == i2) {
            if (z) {
                return -1L;
            }
            throw new dgb("Unexpected EOF");
        }
        int i3 = i + 1;
        byte[] bArr = this.c;
        long j = bArr[i];
        long j2 = 0;
        if (j >= 0) {
            this.b = i3;
            return j;
        }
        if (i2 - i > 1) {
            int i4 = i + 2;
            long j3 = (((long) bArr[i3]) << 7) ^ j;
            if (j3 < 0) {
                this.b = i4;
                return j3 ^ (-128);
            }
        }
        for (int i5 = 0; i5 < 64; i5 += 7) {
            int iE = e();
            j2 |= ((long) (iE & 127)) << i5;
            if ((iE & 128) == 0) {
                return j2;
            }
        }
        throw new dgb("Input stream is malformed: Varint too long (exceeded 64 bits)");
    }

    public ru(byte[] bArr, int i, int i2) {
        this.c = bArr;
        this.a = i;
        this.b = i2;
    }
}
