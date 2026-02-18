package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class asx {
    public static final long[] a = new long[0];
    public final dfx b;
    public final bgr c;
    public long d;
    public final long[] e;

    /* JADX WARN: Multi-variable type inference failed */
    public asx(dfx dfxVar, bgj bgjVar) {
        bzo.q(dfxVar, "descriptor");
        this.b = dfxVar;
        this.c = (bgr) bgjVar;
        int i = dfxVar.i();
        if (i <= 64) {
            this.d = i != 64 ? (-1) << i : 0L;
            this.e = a;
            return;
        }
        this.d = 0L;
        int i2 = (i - 1) >>> 6;
        long[] jArr = new long[i2];
        if ((i & 63) != 0) {
            jArr[i2 - 1] = (-1) << i;
        }
        this.e = jArr;
    }

    public final void f(int i) {
        if (i < 64) {
            this.d = (1 << i) | this.d;
        } else {
            int i2 = (i >>> 6) - 1;
            long[] jArr = this.e;
            jArr[i2] = (1 << (i & 63)) | jArr[i2];
        }
    }

    /* JADX WARN: Type inference failed for: r8v0, types: [me.hd.wauxv.obf.bgj, me.hd.wauxv.obf.bgr] */
    public final int g() {
        ?? r8;
        int iNumberOfTrailingZeros;
        dfx dfxVar = this.b;
        int i = dfxVar.i();
        do {
            long j = this.d;
            r8 = this.c;
            if (j == -1) {
                if (i <= 64) {
                    return -1;
                }
                long[] jArr = this.e;
                int length = jArr.length;
                int i2 = 0;
                while (i2 < length) {
                    int i3 = i2 + 1;
                    int i4 = i3 * 64;
                    long j2 = jArr[i2];
                    while (j2 != -1) {
                        int iNumberOfTrailingZeros2 = Long.numberOfTrailingZeros(~j2);
                        j2 |= 1 << iNumberOfTrailingZeros2;
                        int i5 = iNumberOfTrailingZeros2 + i4;
                        if (((Boolean) r8.g(dfxVar, Integer.valueOf(i5))).booleanValue()) {
                            jArr[i2] = j2;
                            return i5;
                        }
                    }
                    jArr[i2] = j2;
                    i2 = i3;
                }
                return -1;
            }
            iNumberOfTrailingZeros = Long.numberOfTrailingZeros(~j);
            this.d |= 1 << iNumberOfTrailingZeros;
        } while (!((Boolean) r8.g(dfxVar, Integer.valueOf(iNumberOfTrailingZeros))).booleanValue());
        return iNumberOfTrailingZeros;
    }
}
