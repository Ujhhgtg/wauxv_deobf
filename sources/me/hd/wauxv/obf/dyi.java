package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dyi {
    public static final dyh Companion = new dyh();
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final Integer j;
    public final String k;
    public final Integer l;
    public final String m;
    public final Integer n;
    public final String o;
    public final String p;
    public final String q;
    public final dyx r;

    public /* synthetic */ dyi(int i, String str, String str2, String str3, String str4, String str5, String str6,
            String str7, String str8, String str9, Integer num, String str10, Integer num2, String str11, Integer num3,
            String str12, String str13, String str14, dyx dyxVar) {
        if (262143 != (i & 262143)) {
            bht.ah(i, 262143, dyg.b.getDescriptor());
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
        this.i = str9;
        this.j = num;
        this.k = str10;
        this.l = num2;
        this.m = str11;
        this.n = num3;
        this.o = str12;
        this.p = str13;
        this.q = str14;
        this.r = dyxVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dyi)) {
            return false;
        }
        dyi dyiVar = (dyi) obj;
        return nullSafeIsEqual(this.a, dyiVar.a) && nullSafeIsEqual(this.b, dyiVar.b)
                && nullSafeIsEqual(this.c, dyiVar.c) && nullSafeIsEqual(this.d, dyiVar.d)
                && nullSafeIsEqual(this.e, dyiVar.e) && nullSafeIsEqual(this.f, dyiVar.f)
                && nullSafeIsEqual(this.g, dyiVar.g) && nullSafeIsEqual(this.h, dyiVar.h)
                && nullSafeIsEqual(this.i, dyiVar.i) && nullSafeIsEqual(this.j, dyiVar.j)
                && nullSafeIsEqual(this.k, dyiVar.k) && nullSafeIsEqual(this.l, dyiVar.l)
                && nullSafeIsEqual(this.m, dyiVar.m) && nullSafeIsEqual(this.n, dyiVar.n)
                && nullSafeIsEqual(this.o, dyiVar.o) && nullSafeIsEqual(this.p, dyiVar.p)
                && nullSafeIsEqual(this.q, dyiVar.q) && nullSafeIsEqual(this.r, dyiVar.r);
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
        String str9 = this.i;
        int iHashCode9 = (iHashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Integer num = this.j;
        int iHashCode10 = (iHashCode9 + (num == null ? 0 : num.hashCode())) * 31;
        String str10 = this.k;
        int iHashCode11 = (iHashCode10 + (str10 == null ? 0 : str10.hashCode())) * 31;
        Integer num2 = this.l;
        int iHashCode12 = (iHashCode11 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str11 = this.m;
        int iHashCode13 = (iHashCode12 + (str11 == null ? 0 : str11.hashCode())) * 31;
        Integer num3 = this.n;
        int iHashCode14 = (iHashCode13 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str12 = this.o;
        int iHashCode15 = (iHashCode14 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.p;
        int iHashCode16 = (iHashCode15 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.q;
        int iHashCode17 = (iHashCode16 + (str14 == null ? 0 : str14.hashCode())) * 31;
        dyx dyxVar = this.r;
        return iHashCode17 + (dyxVar != null ? dyxVar.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("gt1Proto(docId=" /* cnb.z(-209100482804522L) */);
        yg.u(sb, this.a, -209031763327786L);
        yg.u(sb, this.b, -208975928752938L);
        yg.u(sb, this.c, -208941569014570L);
        yg.u(sb, this.d, -209396835547946L);
        yg.u(sb, this.e, -209375360711466L);
        yg.u(sb, this.f, -209267986529066L);
        yg.u(sb, this.g, -209186382150442L);
        yg.u(sb, this.h, -210809879788330L);
        yg.u(sb, this.i, -210754045213482L);
        bjs.w(sb, this.j, -210685325736746L);
        yg.u(sb, this.k, -210599426390826L);
        bjs.w(sb, this.l, -210582246521642L);
        yg.u(sb, this.m, -211101937564458L);
        bjs.w(sb, this.n, -211037513055018L);
        yg.u(sb, this.o, -210955908676394L);
        yg.u(sb, this.p, -210895779134250L);
        yg.u(sb, this.q, -210281598810922L);
        sb.append(this.r);
        sb.append(')');
        return sb.toString();
    }
}
