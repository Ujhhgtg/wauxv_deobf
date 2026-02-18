package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eei {
    public static final eeh Companion = new eeh();
    public final String a;
    public final Boolean aa;
    public final ein ab;
    public final dws ac;
    public final efd ad;
    public final Integer b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final Float j;
    public final Integer k;
    public final Integer l;
    public final Integer m;
    public final String n;
    public final String o;
    public final Integer p;
    public final String q;
    public final String r;
    public final Integer s;
    public final String t;
    public final String u;
    public final Long v;
    public final ehv w;
    public final String x;
    public final dte y;
    public final Boolean z;

    public /* synthetic */ eei(int i, String str, Integer num, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Float f, Integer num2, Integer num3, Integer num4, String str9, String str10, Integer num5, String str11, String str12, Integer num6, String str13, String str14, Long l, ehv ehvVar, String str15, dte dteVar, Boolean bool, Boolean bool2, ein einVar, dws dwsVar, efd efdVar) {
        if (1073741823 != (i & 1073741823)) {
            bht.ah(i, 1073741823, eeg.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = num;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = str6;
        this.h = str7;
        this.i = str8;
        this.j = f;
        this.k = num2;
        this.l = num3;
        this.m = num4;
        this.n = str9;
        this.o = str10;
        this.p = num5;
        this.q = str11;
        this.r = str12;
        this.s = num6;
        this.t = str13;
        this.u = str14;
        this.v = l;
        this.w = ehvVar;
        this.x = str15;
        this.y = dteVar;
        this.z = bool;
        this.aa = bool2;
        this.ab = einVar;
        this.ac = dwsVar;
        this.ad = efdVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof eei)) {
            return false;
        }
        eei eeiVar = (eei) obj;
        return bzo.f(this.a, eeiVar.a) && bzo.f(this.b, eeiVar.b) && bzo.f(this.c, eeiVar.c) && bzo.f(this.d, eeiVar.d) && bzo.f(this.e, eeiVar.e) && bzo.f(this.f, eeiVar.f) && bzo.f(this.g, eeiVar.g) && bzo.f(this.h, eeiVar.h) && bzo.f(this.i, eeiVar.i) && bzo.f(this.j, eeiVar.j) && bzo.f(this.k, eeiVar.k) && bzo.f(this.l, eeiVar.l) && bzo.f(this.m, eeiVar.m) && bzo.f(this.n, eeiVar.n) && bzo.f(this.o, eeiVar.o) && bzo.f(this.p, eeiVar.p) && bzo.f(this.q, eeiVar.q) && bzo.f(this.r, eeiVar.r) && bzo.f(this.s, eeiVar.s) && bzo.f(this.t, eeiVar.t) && bzo.f(this.u, eeiVar.u) && bzo.f(this.v, eeiVar.v) && bzo.f(this.w, eeiVar.w) && bzo.f(this.x, eeiVar.x) && bzo.f(this.y, eeiVar.y) && bzo.f(this.z, eeiVar.z) && bzo.f(this.aa, eeiVar.aa) && bzo.f(this.ab, eeiVar.ab) && bzo.f(this.ac, eeiVar.ac) && bzo.f(this.ad, eeiVar.ad);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.b;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.c;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.d;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.e;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.g;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.h;
        int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.i;
        int iHashCode9 = (iHashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Float f = this.j;
        int iHashCode10 = (iHashCode9 + (f == null ? 0 : f.hashCode())) * 31;
        Integer num2 = this.k;
        int iHashCode11 = (iHashCode10 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.l;
        int iHashCode12 = (iHashCode11 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.m;
        int iHashCode13 = (iHashCode12 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str9 = this.n;
        int iHashCode14 = (iHashCode13 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.o;
        int iHashCode15 = (iHashCode14 + (str10 == null ? 0 : str10.hashCode())) * 31;
        Integer num5 = this.p;
        int iHashCode16 = (iHashCode15 + (num5 == null ? 0 : num5.hashCode())) * 31;
        String str11 = this.q;
        int iHashCode17 = (iHashCode16 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.r;
        int iHashCode18 = (iHashCode17 + (str12 == null ? 0 : str12.hashCode())) * 31;
        Integer num6 = this.s;
        int iHashCode19 = (iHashCode18 + (num6 == null ? 0 : num6.hashCode())) * 31;
        String str13 = this.t;
        int iHashCode20 = (iHashCode19 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.u;
        int iHashCode21 = (iHashCode20 + (str14 == null ? 0 : str14.hashCode())) * 31;
        Long l = this.v;
        int iHashCode22 = (iHashCode21 + (l == null ? 0 : l.hashCode())) * 31;
        ehv ehvVar = this.w;
        int iHashCode23 = (iHashCode22 + (ehvVar == null ? 0 : ehvVar.hashCode())) * 31;
        String str15 = this.x;
        int iHashCode24 = (iHashCode23 + (str15 == null ? 0 : str15.hashCode())) * 31;
        dte dteVar = this.y;
        int iHashCode25 = (iHashCode24 + (dteVar == null ? 0 : dteVar.hashCode())) * 31;
        Boolean bool = this.z;
        int iHashCode26 = (iHashCode25 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.aa;
        int iHashCode27 = (iHashCode26 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        ein einVar = this.ab;
        int iHashCode28 = (iHashCode27 + (einVar == null ? 0 : einVar.hashCode())) * 31;
        dws dwsVar = this.ac;
        int iHashCode29 = (iHashCode28 + (dwsVar == null ? 0 : dwsVar.hashCode())) * 31;
        efd efdVar = this.ad;
        return iHashCode29 + (efdVar != null ? efdVar.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(cnb.z(-266927922477866L));
        yg.u(sb, this.a, -266223547841322L);
        bjs.w(sb, this.b, -266167713266474L);
        yg.u(sb, this.c, -266605799930666L);
        yg.u(sb, this.d, -266541375421226L);
        yg.u(sb, this.e, -266434001238826L);
        yg.u(sb, this.f, -266391051565866L);
        yg.u(sb, this.g, -267907175021354L);
        yg.u(sb, this.h, -267868520315690L);
        yg.u(sb, this.i, -267834160577322L);
        bjs.v(sb, this.j, -267795505871658L);
        bjs.w(sb, this.k, -268272247241514L);
        bjs.w(sb, this.l, -268164873059114L);
        bjs.w(sb, this.m, -268130513320746L);
        yg.u(sb, this.n, -267447613520682L);
        yg.u(sb, this.o, -267297289665322L);
        bjs.w(sb, this.p, -267701016591146L);
        yg.u(sb, this.q, -267696721623850L);
        yg.u(sb, this.r, -267610822277930L);
        bjs.w(sb, this.s, -267494858160938L);
        yg.u(sb, this.t, -264642999876394L);
        yg.u(sb, this.u, -264539920661290L);
        dkz.ad(sb, this.v, -264484086086442L);
        sb.append(this.w);
        sb.append(cnb.z(-264939352619818L));
        yg.u(sb, this.x, -264857748241194L);
        sb.append(this.y);
        sb.append(cnb.z(-264784733797162L));
        dts.g(sb, this.z, -264771848895274L);
        dts.g(sb, this.aa, -264097539029802L);
        sb.append(this.ab);
        sb.append(cnb.z(-263994459814698L));
        sb.append(this.ac);
        sb.append(cnb.z(-263942920207146L));
        sb.append(this.ad);
        sb.append(')');
        return sb.toString();
    }
}
