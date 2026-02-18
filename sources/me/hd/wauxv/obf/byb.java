package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class byb {
    public static final long[] a;

    static {
        long[] jArr = dev.a;
        int iD = dev.d(0);
        int iMax = iD > 0 ? Math.max(7, dev.c(iD)) : 0;
        if (iMax != 0) {
            jArr = new long[((iMax + 15) & (-8)) >> 3];
            la.n(jArr);
        }
        int i = iMax >> 3;
        long j = 255 << ((iMax & 7) << 3);
        jArr[i] = (jArr[i] & (~j)) | j;
        long[] jArr2 = new long[iMax];
        a = new long[0];
    }
}
