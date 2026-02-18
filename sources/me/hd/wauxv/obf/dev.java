package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class dev {
    public static final long[] a = {-9187201950435737345L, -1};

    static {
        int iD = d(0);
        int iMax = iD > 0 ? Math.max(7, c(iD)) : 0;
        if (iMax != 0) {
            long[] jArr = new long[((iMax + 15) & (-8)) >> 3];
            la.n(jArr);
            int i = iMax >> 3;
            long j = 255 << ((iMax & 7) << 3);
            jArr[i] = (jArr[i] & (~j)) | j;
        }
        if (iMax != 0) {
            Object[] objArr = new Object[iMax];
        }
        if (iMax == 0) {
            return;
        }
        Object[] objArr2 = new Object[iMax];
    }

    public static final int b(int i) {
        if (i == 7) {
            return 6;
        }
        return i - (i / 8);
    }

    public static final int c(int i) {
        if (i > 0) {
            return (-1) >>> Integer.numberOfLeadingZeros(i);
        }
        return 0;
    }

    public static final int d(int i) {
        if (i == 7) {
            return 8;
        }
        return ((i - 1) / 7) + i;
    }
}
