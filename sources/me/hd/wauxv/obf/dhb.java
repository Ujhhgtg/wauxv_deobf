package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dhb extends emn {
    public Object[] a;
    public long b;
    public long c;
    public int g;

    public final long h() {
        return Math.min(this.c, this.b);
    }

    public final Object[] i(Object[] objArr, int i, int i2) {
        if (i2 <= 0) {
            throw new IllegalStateException("Buffer size overflow");
        }
        Object[] objArr2 = new Object[i2];
        this.a = objArr2;
        if (objArr != null) {
            long jH = h();
            for (int i3 = 0; i3 < i; i3++) {
                int i4 = (int) (((long) i3) + jH);
                objArr2[i4 & (i2 - 1)] = objArr[(objArr.length - 1) & i4];
            }
        }
        return objArr2;
    }
}
