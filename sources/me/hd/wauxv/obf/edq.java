package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class edq {
    public static final edp Companion = new edp();
    public final Integer a;
    public final Integer b;

    public /* synthetic */ edq(int i, Integer num, Integer num2) {
        if (3 != (i & 3)) {
            bht.ah(i, 3, edo.b.getDescriptor());
            throw null;
        }
        this.a = num;
        this.b = num2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof edq)) {
            return false;
        }
        edq edqVar = (edq) obj;
        return bzo.f(this.a, edqVar.a) && bzo.f(this.b, edqVar.b);
    }

    public final int hashCode() {
        Integer num = this.a;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.b;
        return iHashCode + (num2 != null ? num2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("qg1Proto(live_mode=" /* cnb.z(-275075475438378L) */);
        bjs.w(sb, this.a, -274955216354090L);
        return bjs.p(sb, this.b, ')');
    }
}
