package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dwy {
    public static final dwx Companion = new dwx();
    public final String a;
    public final dwj b;
    public final dwj c;
    public final dwj d;
    public final dwj e;
    public final Float f;
    public final String g;
    public final Boolean h;
    public final Boolean i;
    public final String j;
    public final String k;
    public final String l;
    public final Integer m;
    public final dwj n;
    public final dwj o;
    public final dwj p;
    public final dwj q;
    public final dwj r;

    public /* synthetic */ dwy(int i, String str, dwj dwjVar, dwj dwjVar2, dwj dwjVar3, dwj dwjVar4, Float f, String str2, Boolean bool, Boolean bool2, String str3, String str4, String str5, Integer num, dwj dwjVar5, dwj dwjVar6, dwj dwjVar7, dwj dwjVar8, dwj dwjVar9) {
        if (262143 != (i & 262143)) {
            bht.ah(i, 262143, dww.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = dwjVar;
        this.c = dwjVar2;
        this.d = dwjVar3;
        this.e = dwjVar4;
        this.f = f;
        this.g = str2;
        this.h = bool;
        this.i = bool2;
        this.j = str3;
        this.k = str4;
        this.l = str5;
        this.m = num;
        this.n = dwjVar5;
        this.o = dwjVar6;
        this.p = dwjVar7;
        this.q = dwjVar8;
        this.r = dwjVar9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dwy)) {
            return false;
        }
        dwy dwyVar = (dwy) obj;
        return bzo.f(this.a, dwyVar.a) && bzo.f(this.b, dwyVar.b) && bzo.f(this.c, dwyVar.c) && bzo.f(this.d, dwyVar.d) && bzo.f(this.e, dwyVar.e) && bzo.f(this.f, dwyVar.f) && bzo.f(this.g, dwyVar.g) && bzo.f(this.h, dwyVar.h) && bzo.f(this.i, dwyVar.i) && bzo.f(this.j, dwyVar.j) && bzo.f(this.k, dwyVar.k) && bzo.f(this.l, dwyVar.l) && bzo.f(this.m, dwyVar.m) && bzo.f(this.n, dwyVar.n) && bzo.f(this.o, dwyVar.o) && bzo.f(this.p, dwyVar.p) && bzo.f(this.q, dwyVar.q) && bzo.f(this.r, dwyVar.r);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        dwj dwjVar = this.b;
        int iHashCode2 = (iHashCode + (dwjVar == null ? 0 : dwjVar.hashCode())) * 31;
        dwj dwjVar2 = this.c;
        int iHashCode3 = (iHashCode2 + (dwjVar2 == null ? 0 : dwjVar2.hashCode())) * 31;
        dwj dwjVar3 = this.d;
        int iHashCode4 = (iHashCode3 + (dwjVar3 == null ? 0 : dwjVar3.hashCode())) * 31;
        dwj dwjVar4 = this.e;
        int iHashCode5 = (iHashCode4 + (dwjVar4 == null ? 0 : dwjVar4.hashCode())) * 31;
        Float f = this.f;
        int iHashCode6 = (iHashCode5 + (f == null ? 0 : f.hashCode())) * 31;
        String str2 = this.g;
        int iHashCode7 = (iHashCode6 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.h;
        int iHashCode8 = (iHashCode7 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.i;
        int iHashCode9 = (iHashCode8 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str3 = this.j;
        int iHashCode10 = (iHashCode9 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.k;
        int iHashCode11 = (iHashCode10 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.l;
        int iHashCode12 = (iHashCode11 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num = this.m;
        int iHashCode13 = (iHashCode12 + (num == null ? 0 : num.hashCode())) * 31;
        dwj dwjVar5 = this.n;
        int iHashCode14 = (iHashCode13 + (dwjVar5 == null ? 0 : dwjVar5.hashCode())) * 31;
        dwj dwjVar6 = this.o;
        int iHashCode15 = (iHashCode14 + (dwjVar6 == null ? 0 : dwjVar6.hashCode())) * 31;
        dwj dwjVar7 = this.p;
        int iHashCode16 = (iHashCode15 + (dwjVar7 == null ? 0 : dwjVar7.hashCode())) * 31;
        dwj dwjVar8 = this.q;
        int iHashCode17 = (iHashCode16 + (dwjVar8 == null ? 0 : dwjVar8.hashCode())) * 31;
        dwj dwjVar9 = this.r;
        return iHashCode17 + (dwjVar9 != null ? dwjVar9.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(cnb.z(-188523294489386L));
        yg.u(sb, this.a, -188368675666730L);
        dts.h(sb, this.b, -188295661222698L);
        dts.h(sb, this.c, -185503932480298L);
        dts.h(sb, this.d, -185387968363306L);
        dts.h(sb, this.e, -185332133788458L);
        bjs.v(sb, this.f, -185770220452650L);
        yg.u(sb, this.g, -185654256335658L);
        dts.g(sb, this.h, -185598421760810L);
        dts.g(sb, this.i, -185564062022442L);
        yg.u(sb, this.j, -184992831372074L);
        yg.u(sb, this.k, -184902637058858L);
        yg.u(sb, this.l, -184812442745642L);
        bjs.w(sb, this.m, -184778083007274L);
        dts.h(sb, this.n, -185177514965802L);
        dts.h(sb, this.o, -185044370979626L);
        dts.h(sb, this.p, -186612034042666L);
        dts.h(sb, this.q, -186534724631338L);
        sb.append(this.r);
        sb.append(')');
        return sb.toString();
    }
}
