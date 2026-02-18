package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ecv {
    public static final ecu Companion = new ecu();
    public final dvu a;
    public final Integer b;
    public final String c;
    public final Integer d;
    public final Integer e;

    public /* synthetic */ ecv(int i, dvu dvuVar, Integer num, String str, Integer num2, Integer num3) {
        if (31 != (i & 31)) {
            bht.ah(i, 31, ect.b.getDescriptor());
            throw null;
        }
        this.a = dvuVar;
        this.b = num;
        this.c = str;
        this.d = num2;
        this.e = num3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ecv)) {
            return false;
        }
        ecv ecvVar = (ecv) obj;
        return bzo.f(this.a, ecvVar.a) && bzo.f(this.b, ecvVar.b) && bzo.f(this.c, ecvVar.c) && bzo.f(this.d, ecvVar.d) && bzo.f(this.e, ecvVar.e);
    }

    public final int hashCode() {
        dvu dvuVar = this.a;
        int iHashCode = (dvuVar == null ? 0 : dvuVar.hashCode()) * 31;
        Integer num = this.b;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.c;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num2 = this.d;
        int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.e;
        return iHashCode4 + (num3 != null ? num3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("or5Proto(tmpl_version_info=" /* cnb.z(-248816045390634L) */);
        sb.append(this.a);
        sb.append(", tmpl_type=" /* cnb.z(-250379413486378L) */);
        bjs.w(sb, this.b, -250289219173162L);
        yg.u(sb, this.c, -250229089631018L);
        bjs.w(sb, this.d, -250654291393322L);
        return bjs.p(sb, this.e, ')');
    }
}
