package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dzp {
    public static final dzo Companion = new dzo();
    public static final btt[] a = {null, null, null, null, null, null, ewz.am(btx.a, new dtr(11)), null, null, null, null};
    public final Integer b;
    public final String c;
    public final Boolean d;
    public final Boolean e;
    public final Boolean f;
    public final Boolean g;
    public final List h;
    public final Integer i;
    public final Long j;
    public final String k;
    public final String l;

    public /* synthetic */ dzp(int i, Integer num, String str, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, List list, Integer num2, Long l, String str2, String str3) {
        if (2047 != (i & 2047)) {
            bht.ah(i, 2047, dzn.b.getDescriptor());
            throw null;
        }
        this.b = num;
        this.c = str;
        this.d = bool;
        this.e = bool2;
        this.f = bool3;
        this.g = bool4;
        this.h = list;
        this.i = num2;
        this.j = l;
        this.k = str2;
        this.l = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dzp)) {
            return false;
        }
        dzp dzpVar = (dzp) obj;
        return bzo.f(this.b, dzpVar.b) && bzo.f(this.c, dzpVar.c) && bzo.f(this.d, dzpVar.d) && bzo.f(this.e, dzpVar.e) && bzo.f(this.f, dzpVar.f) && bzo.f(this.g, dzpVar.g) && bzo.f(this.h, dzpVar.h) && bzo.f(this.i, dzpVar.i) && bzo.f(this.j, dzpVar.j) && bzo.f(this.k, dzpVar.k) && bzo.f(this.l, dzpVar.l);
    }

    public final int hashCode() {
        Integer num = this.b;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.c;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.d;
        int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.e;
        int iHashCode4 = (iHashCode3 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.f;
        int iHashCode5 = (iHashCode4 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.g;
        int iHashCode6 = (iHashCode5 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        List list = this.h;
        int iHashCode7 = (iHashCode6 + (list == null ? 0 : list.hashCode())) * 31;
        Integer num2 = this.i;
        int iHashCode8 = (iHashCode7 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l = this.j;
        int iHashCode9 = (iHashCode8 + (l == null ? 0 : l.hashCode())) * 31;
        String str2 = this.k;
        int iHashCode10 = (iHashCode9 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.l;
        return iHashCode10 + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(cnb.z(-199638669851434L));
        bjs.w(sb, this.b, -199565655407402L);
        yg.u(sb, this.c, -200098231352106L);
        dts.g(sb, this.d, -199977972267818L);
        dts.g(sb, this.e, -199926432660266L);
        dts.g(sb, this.f, -199260712729386L);
        dts.g(sb, this.g, -199252122794794L);
        yg.v(sb, this.h, -199183403318058L);
        bjs.w(sb, this.i, -199093209004842L);
        dkz.ad(sb, this.j, -199020194560810L);
        yg.u(sb, this.k, -199552770505514L);
        return bjs.q(sb, this.l, ')');
    }
}
