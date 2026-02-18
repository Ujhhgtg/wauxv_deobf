package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eik {
    public static final eij Companion = new eij();
    public static final IHasGetValue[] a;
    public final Integer b;
    public final Integer c;
    public final List d;
    public final String e;
    public final Integer f;
    public final String g;
    public final String h;
    public final List i;
    public final Boolean j;
    public final List k;
    public final String l;
    public final List m;
    public final List n;

    static {
        efq efqVar = new efq(6);
        btx btxVar = btx.a;
        a = new IHasGetValue[] { null, null, ewz.am(btxVar, efqVar), null, null, null, null, ewz.am(btxVar, new efq(7)),
                null,
                ewz.am(btxVar, new efq(8)), null, ewz.am(btxVar, new efq(9)), ewz.am(btxVar, new efq(10)) };
    }

    public /* synthetic */ eik(int i, Integer num, Integer num2, List list, String str, Integer num3, String str2,
            String str3, List list2, Boolean bool, List list3, String str4, List list4, List list5) {
        if (8191 != (i & 8191)) {
            bht.ah(i, 8191, eii.b.getDescriptor());
            throw null;
        }
        this.b = num;
        this.c = num2;
        this.d = list;
        this.e = str;
        this.f = num3;
        this.g = str2;
        this.h = str3;
        this.i = list2;
        this.j = bool;
        this.k = list3;
        this.l = str4;
        this.m = list4;
        this.n = list5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof eik)) {
            return false;
        }
        eik eikVar = (eik) obj;
        return nullSafeIsEqual(this.b, eikVar.b) && nullSafeIsEqual(this.c, eikVar.c)
                && nullSafeIsEqual(this.d, eikVar.d) && nullSafeIsEqual(this.e, eikVar.e)
                && nullSafeIsEqual(this.f, eikVar.f) && nullSafeIsEqual(this.g, eikVar.g)
                && nullSafeIsEqual(this.h, eikVar.h) && nullSafeIsEqual(this.i, eikVar.i)
                && nullSafeIsEqual(this.j, eikVar.j) && nullSafeIsEqual(this.k, eikVar.k)
                && nullSafeIsEqual(this.l, eikVar.l) && nullSafeIsEqual(this.m, eikVar.m)
                && nullSafeIsEqual(this.n, eikVar.n);
    }

    public final int hashCode() {
        Integer num = this.b;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.c;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        List list = this.d;
        int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.e;
        int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num3 = this.f;
        int iHashCode5 = (iHashCode4 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str2 = this.g;
        int iHashCode6 = (iHashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.h;
        int iHashCode7 = (iHashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List list2 = this.i;
        int iHashCode8 = (iHashCode7 + (list2 == null ? 0 : list2.hashCode())) * 31;
        Boolean bool = this.j;
        int iHashCode9 = (iHashCode8 + (bool == null ? 0 : bool.hashCode())) * 31;
        List list3 = this.k;
        int iHashCode10 = (iHashCode9 + (list3 == null ? 0 : list3.hashCode())) * 31;
        String str4 = this.l;
        int iHashCode11 = (iHashCode10 + (str4 == null ? 0 : str4.hashCode())) * 31;
        List list4 = this.m;
        int iHashCode12 = (iHashCode11 + (list4 == null ? 0 : list4.hashCode())) * 31;
        List list5 = this.n;
        return iHashCode12 + (list5 != null ? list5.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("x93Proto(start_timestamp=" /* cnb.z(-331288007408426L) */);
        bjs.w(sb, this.b, -319648646036266L);
        bjs.w(sb, this.c, -319575631592234L);
        yg.v(sb, this.d, -319502617148202L);
        yg.u(sb, this.e, -319433897671466L);
        bjs.w(sb, this.f, -319910639041322L);
        yg.u(sb, this.g, -319829034662698L);
        yg.u(sb, this.h, -319781790022442L);
        yg.v(sb, this.i, -319103185189674L);
        dts.g(sb, this.j, -319077415385898L);
        yg.v(sb, this.k, -318991516039978L);
        yg.u(sb, this.l, -318888436824874L);
        yg.v(sb, this.m, -319287868783402L);
        sb.append(this.n);
        sb.append(')');
        return sb.toString();
    }
}
