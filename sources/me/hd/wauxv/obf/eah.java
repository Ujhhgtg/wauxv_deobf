package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eah {
    public static final eag Companion = new eag();
    public static final btt[] a = {null, null, ewz.am(btx.a, new dtr(15)), null, null, null, null, null, null, null, null, null, null, null, null, null};
    public final Long b;
    public final String c;
    public final List d;
    public final dyi e;
    public final Integer f;
    public final Integer g;
    public final ebi h;
    public final String i;
    public final Integer j;
    public final Integer k;
    public final String l;
    public final Long m;
    public final Integer n;
    public final Integer o;
    public final Integer p;
    public final String q;

    public /* synthetic */ eah(int i, Long l, String str, List list, dyi dyiVar, Integer num, Integer num2, ebi ebiVar, String str2, Integer num3, Integer num4, String str3, Long l2, Integer num5, Integer num6, Integer num7, String str4) {
        if (65535 != (i & 65535)) {
            bht.ah(i, 65535, eaf.b.getDescriptor());
            throw null;
        }
        this.b = l;
        this.c = str;
        this.d = list;
        this.e = dyiVar;
        this.f = num;
        this.g = num2;
        this.h = ebiVar;
        this.i = str2;
        this.j = num3;
        this.k = num4;
        this.l = str3;
        this.m = l2;
        this.n = num5;
        this.o = num6;
        this.p = num7;
        this.q = str4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof eah)) {
            return false;
        }
        eah eahVar = (eah) obj;
        return bzo.f(this.b, eahVar.b) && bzo.f(this.c, eahVar.c) && bzo.f(this.d, eahVar.d) && bzo.f(this.e, eahVar.e) && bzo.f(this.f, eahVar.f) && bzo.f(this.g, eahVar.g) && bzo.f(this.h, eahVar.h) && bzo.f(this.i, eahVar.i) && bzo.f(this.j, eahVar.j) && bzo.f(this.k, eahVar.k) && bzo.f(this.l, eahVar.l) && bzo.f(this.m, eahVar.m) && bzo.f(this.n, eahVar.n) && bzo.f(this.o, eahVar.o) && bzo.f(this.p, eahVar.p) && bzo.f(this.q, eahVar.q);
    }

    public final int hashCode() {
        Long l = this.b;
        int iHashCode = (l == null ? 0 : l.hashCode()) * 31;
        String str = this.c;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        List list = this.d;
        int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        dyi dyiVar = this.e;
        int iHashCode4 = (iHashCode3 + (dyiVar == null ? 0 : dyiVar.hashCode())) * 31;
        Integer num = this.f;
        int iHashCode5 = (iHashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.g;
        int iHashCode6 = (iHashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
        ebi ebiVar = this.h;
        int iHashCode7 = (iHashCode6 + (ebiVar == null ? 0 : ebiVar.hashCode())) * 31;
        String str2 = this.i;
        int iHashCode8 = (iHashCode7 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num3 = this.j;
        int iHashCode9 = (iHashCode8 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.k;
        int iHashCode10 = (iHashCode9 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str3 = this.l;
        int iHashCode11 = (iHashCode10 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Long l2 = this.m;
        int iHashCode12 = (iHashCode11 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Integer num5 = this.n;
        int iHashCode13 = (iHashCode12 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.o;
        int iHashCode14 = (iHashCode13 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Integer num7 = this.p;
        int iHashCode15 = (iHashCode14 + (num7 == null ? 0 : num7.hashCode())) * 31;
        String str4 = this.q;
        return iHashCode15 + (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(cnb.z(-224751343631146L));
        dkz.ad(sb, this.b, -224661149317930L);
        yg.u(sb, this.c, -224609609710378L);
        yg.v(sb, this.d, -226160092904234L);
        sb.append(this.e);
        sb.append(cnb.z(-226151502969642L));
        bjs.w(sb, this.f, -226074193558314L);
        bjs.w(sb, this.g, -225996884146986L);
        sb.append(this.h);
        sb.append(cnb.z(-225979704277802L));
        yg.u(sb, this.i, -226404906040106L);
        bjs.w(sb, this.j, -226361956367146L);
        bjs.w(sb, this.k, -226276057021226L);
        yg.u(sb, this.l, -225610337090346L);
        dkz.ad(sb, this.m, -225550207548202L);
        bjs.w(sb, this.n, -225460013234986L);
        bjs.w(sb, this.o, -225949639506730L);
        bjs.w(sb, this.p, -225825085455146L);
        return bjs.q(sb, this.q, ')');
    }
}
