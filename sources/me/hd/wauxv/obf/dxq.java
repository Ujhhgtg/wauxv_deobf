package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dxq {
    public static final dxp Companion = new dxp();
    public final Integer a;
    public final Integer b;

    public /* synthetic */ dxq(int i, Integer num, Integer num2) {
        if (3 != (i & 3)) {
            bht.ah(i, 3, dxo.b.getDescriptor());
            throw null;
        }
        this.a = num;
        this.b = num2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dxq)) {
            return false;
        }
        dxq dxqVar = (dxq) obj;
        return nullSafeIsEqual(this.a, dxqVar.a) && nullSafeIsEqual(this.b, dxqVar.b);
    }

    public final int hashCode() {
        Integer num = this.a;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.b;
        return iHashCode + (num2 != null ? num2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ft1Proto(follow_num=" /* cnb.z(-184614874250026L) */);
        bjs.w(sb, this.a, -184490320198442L);
        return concat(sb, this.b, ')');
    }
}
