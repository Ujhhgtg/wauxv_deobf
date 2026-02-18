package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dzg {
    public static final dzf Companion = new dzf();
    public final Integer a;
    public final String b;
    public final Integer c;
    public final Integer d;
    public final String e;
    public final Long f;
    public final Long g;
    public final Long h;
    public final String i;

    public /* synthetic */ dzg(int i, Integer num, String str, Integer num2, Integer num3, String str2, Long l, Long l2,
            Long l3, String str3) {
        if (511 != (i & 511)) {
            bht.ah(i, 511, dze.b.getDescriptor());
            throw null;
        }
        this.a = num;
        this.b = str;
        this.c = num2;
        this.d = num3;
        this.e = str2;
        this.f = l;
        this.g = l2;
        this.h = l3;
        this.i = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dzg)) {
            return false;
        }
        dzg dzgVar = (dzg) obj;
        return nullSafeIsEqual(this.a, dzgVar.a) && nullSafeIsEqual(this.b, dzgVar.b)
                && nullSafeIsEqual(this.c, dzgVar.c) && nullSafeIsEqual(this.d, dzgVar.d)
                && nullSafeIsEqual(this.e, dzgVar.e) && nullSafeIsEqual(this.f, dzgVar.f)
                && nullSafeIsEqual(this.g, dzgVar.g)
                && nullSafeIsEqual(this.h, dzgVar.h) && nullSafeIsEqual(this.i, dzgVar.i);
    }

    public final int hashCode() {
        Integer num = this.a;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num2 = this.c;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.d;
        int iHashCode4 = (iHashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str2 = this.e;
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l = this.f;
        int iHashCode6 = (iHashCode5 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.g;
        int iHashCode7 = (iHashCode6 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.h;
        int iHashCode8 = (iHashCode7 + (l3 == null ? 0 : l3.hashCode())) * 31;
        String str3 = this.i;
        return iHashCode8 + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("kb3Proto(d=" /* cnb.z(-202035261602602L) */);
        bjs.w(sb, this.a, -201949362256682L);
        yg.u(sb, this.b, -201962247158570L);
        bjs.w(sb, this.c, -201923592452906L);
        bjs.w(sb, this.d, -201867757878058L);
        yg.u(sb, this.e, -201897822649130L);
        dkz.ad(sb, this.f, -201841988074282L);
        dkz.ad(sb, this.g, -201803333368618L);
        dkz.ad(sb, this.h, -201816218270506L);
        return concat(sb, this.i, ')');
    }
}
