package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eiq {
    public static final eip Companion = new eip();
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final Long i;
    public final String j;
    public final Integer k;
    public final String l;
    public final String m;
    public final String n;
    public final String o;
    public final String p;
    public final String q;
    public final String r;
    public final Integer s;
    public final String t;
    public final String u;

    public /* synthetic */ eiq(int i, String str, String str2, String str3, String str4, String str5, String str6,
            String str7, String str8, Long l, String str9, Integer num, String str10, String str11, String str12,
            String str13, String str14, String str15, String str16, Integer num2, String str17, String str18) {
        if (2097151 != (i & 2097151)) {
            bht.ah(i, 2097151, eio.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
        this.h = str8;
        this.i = l;
        this.j = str9;
        this.k = num;
        this.l = str10;
        this.m = str11;
        this.n = str12;
        this.o = str13;
        this.p = str14;
        this.q = str15;
        this.r = str16;
        this.s = num2;
        this.t = str17;
        this.u = str18;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof eiq)) {
            return false;
        }
        eiq eiqVar = (eiq) obj;
        return nullSafeIsEqual(this.a, eiqVar.a) && nullSafeIsEqual(this.b, eiqVar.b)
                && nullSafeIsEqual(this.c, eiqVar.c) && nullSafeIsEqual(this.d, eiqVar.d)
                && nullSafeIsEqual(this.e, eiqVar.e) && nullSafeIsEqual(this.f, eiqVar.f)
                && nullSafeIsEqual(this.g, eiqVar.g)
                && nullSafeIsEqual(this.h, eiqVar.h) && nullSafeIsEqual(this.i, eiqVar.i)
                && nullSafeIsEqual(this.j, eiqVar.j)
                && nullSafeIsEqual(this.k, eiqVar.k) && nullSafeIsEqual(this.l, eiqVar.l)
                && nullSafeIsEqual(this.m, eiqVar.m)
                && nullSafeIsEqual(this.n, eiqVar.n) && nullSafeIsEqual(this.o, eiqVar.o)
                && nullSafeIsEqual(this.p, eiqVar.p)
                && nullSafeIsEqual(this.q, eiqVar.q) && nullSafeIsEqual(this.r, eiqVar.r)
                && nullSafeIsEqual(this.s, eiqVar.s)
                && nullSafeIsEqual(this.t, eiqVar.t) && nullSafeIsEqual(this.u, eiqVar.u);
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
        String str5 = this.e;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.f;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.g;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.h;
        int iHashCode8 = (iHashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Long l = this.i;
        int iHashCode9 = (iHashCode8 + (l == null ? 0 : l.hashCode())) * 31;
        String str9 = this.j;
        int iHashCode10 = (iHashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Integer num = this.k;
        int iHashCode11 = (iHashCode10 + (num == null ? 0 : num.hashCode())) * 31;
        String str10 = this.l;
        int iHashCode12 = (iHashCode11 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.m;
        int iHashCode13 = (iHashCode12 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.n;
        int iHashCode14 = (iHashCode13 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.o;
        int iHashCode15 = (iHashCode14 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.p;
        int iHashCode16 = (iHashCode15 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.q;
        int iHashCode17 = (iHashCode16 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.r;
        int iHashCode18 = (iHashCode17 + (str16 == null ? 0 : str16.hashCode())) * 31;
        Integer num2 = this.s;
        int iHashCode19 = (iHashCode18 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str17 = this.t;
        int iHashCode20 = (iHashCode19 + (str17 == null ? 0 : str17.hashCode())) * 31;
        String str18 = this.u;
        return iHashCode20 + (str18 != null ? str18.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("xq3Proto(mvObjectId=" /* cnb.z(-318570609244970L) */);
        yg.u(sb, this.a, -318463235062570L);
        yg.u(sb, this.b, -318441760226090L);
        yg.u(sb, this.c, -318364450814762L);
        yg.u(sb, this.d, -318824012315434L);
        yg.u(sb, this.e, -318746702904106L);
        yg.u(sb, this.f, -318656508590890L);
        yg.u(sb, this.g, -318652213623594L);
        yg.u(sb, this.h, -318025148398378L);
        dkz.ad(sb, this.i, -317934954085162L);
        yg.u(sb, this.j, -317874824543018L);
        bjs.w(sb, this.k, -317818989968170L);
        yg.u(sb, this.l, -317771745327914L);
        yg.u(sb, this.m, -318214126959402L);
        yg.u(sb, this.n, -318153997417258L);
        yg.u(sb, this.o, -318136817548074L);
        yg.u(sb, this.p, -318046623234858L);
        yg.u(sb, this.q, -324038102612778L);
        yg.u(sb, this.r, -323930728430378L);
        bjs.w(sb, this.s, -323853419019050L);
        yg.u(sb, this.t, -324325865421610L);
        return concat(sb, this.u, ')');
    }
}
