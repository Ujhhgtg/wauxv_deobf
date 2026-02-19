package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class duw {
    public static final duv Companion = new duv();
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final Long e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final String o;
    public final String p;
    public final String q;
    public final Long r;
    public final String s;
    public final String t;

    public /* synthetic */ duw(int i, String str, String str2, String str3, String str4, Long l, String str5,
            String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13,
            String str14, String str15, String str16, Long l2, String str17, String str18) {
        if (1048575 != (i & 1048575)) {
            bht.ah(i, 1048575, duu.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = l;
        this.f = str5;
        this.g = str6;
        this.h = str7;
        this.i = str8;
        this.j = str9;
        this.k = str10;
        this.l = str11;
        this.m = str12;
        this.n = str13;
        this.o = str14;
        this.p = str15;
        this.q = str16;
        this.r = l2;
        this.s = str17;
        this.t = str18;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof duw)) {
            return false;
        }
        duw duwVar = (duw) obj;
        return nullSafeIsEqual(this.a, duwVar.a) && nullSafeIsEqual(this.b, duwVar.b)
                && nullSafeIsEqual(this.c, duwVar.c) && nullSafeIsEqual(this.d, duwVar.d)
                && nullSafeIsEqual(this.e, duwVar.e) && nullSafeIsEqual(this.f, duwVar.f)
                && nullSafeIsEqual(this.g, duwVar.g)
                && nullSafeIsEqual(this.h, duwVar.h) && nullSafeIsEqual(this.i, duwVar.i)
                && nullSafeIsEqual(this.j, duwVar.j)
                && nullSafeIsEqual(this.k, duwVar.k) && nullSafeIsEqual(this.l, duwVar.l)
                && nullSafeIsEqual(this.m, duwVar.m)
                && nullSafeIsEqual(this.n, duwVar.n) && nullSafeIsEqual(this.o, duwVar.o)
                && nullSafeIsEqual(this.p, duwVar.p)
                && nullSafeIsEqual(this.q, duwVar.q) && nullSafeIsEqual(this.r, duwVar.r)
                && nullSafeIsEqual(this.s, duwVar.s)
                && nullSafeIsEqual(this.t, duwVar.t);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.c;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.d;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Long l = this.e;
        int iHashCode5 = (iHashCode4 + (l == null ? 0 : l.hashCode())) * 31;
        String str5 = this.f;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.g;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.h;
        int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.i;
        int iHashCode9 = (iHashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.j;
        int iHashCode10 = (iHashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.k;
        int iHashCode11 = (iHashCode10 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.l;
        int iHashCode12 = (iHashCode11 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.m;
        int iHashCode13 = (iHashCode12 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.n;
        int iHashCode14 = (iHashCode13 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.o;
        int iHashCode15 = (iHashCode14 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.p;
        int iHashCode16 = (iHashCode15 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.q;
        int iHashCode17 = (iHashCode16 + (str16 == null ? 0 : str16.hashCode())) * 31;
        Long l2 = this.r;
        int iHashCode18 = (iHashCode17 + (l2 == null ? 0 : l2.hashCode())) * 31;
        String str17 = this.s;
        int iHashCode19 = (iHashCode18 + (str17 == null ? 0 : str17.hashCode())) * 31;
        String str18 = this.t;
        return iHashCode19 + (str18 != null ? str18.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WebSearchInfoProto(relevant_vid=" /* "WebSearchInfoProto(relevant_vid=" /* "WebSearchInfoProto(relevant_vid=" /* "WebSearchInfoProto(relevant_vid=" /* cnb.z(-326494823906090L)   */);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.a, -326353089985322L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.b, -326305845345066L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.c, -325648715348778L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.d, -325554226068266L);
        dkz.ad(sb, this.e, -325485506591530L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.f, -325966542928682L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.g, -325880643582762L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.h, -325803334171434L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.i, -325799039204138L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.j, -327366702267178L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.k, -327302277757738L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.l, -327242148215594L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.m, -327147658935082L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.n, -327126184098602L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.o, -327590040566570L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.p, -327521321089834L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.q, -327508436187946L);
        dkz.ad(sb, this.r, -327418241874730L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.s, -327401062005546L);
        return concat(sb, this.t, ')');
    }
}
