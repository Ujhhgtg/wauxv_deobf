package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dtb {
    public static final dta Companion = new dta();
    public static final IHasGetValue[] a = { null, null, null, null, null, null, null, ewz.am(btx.a, new Function1$VarIsInt$2(28)), null,
            null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null };
    public final Integer aa;
    public final String ab;
    public final dxt ac;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final Integer g;
    public final Integer h;
    public final List i;
    public final String j;
    public final Long k;
    public final String l;
    public final String m;
    public final String n;
    public final Integer o;
    public final String p;
    public final String q;
    public final String r;
    public final String s;
    public final Integer t;
    public final String u;
    public final Integer v;
    public final String w;
    public final String x;
    public final String y;
    public final String z;

    public /* synthetic */ dtb(int i, String str, String str2, String str3, String str4, String str5, Integer num,
            Integer num2, List list, String str6, Long l, String str7, String str8, String str9, Integer num3,
            String str10, String str11, String str12, String str13, Integer num4, String str14, Integer num5,
            String str15, String str16, String str17, String str18, Integer num6, String str19, dxt dxtVar) {
        if (268435455 != (i & 268435455)) {
            ResourcesCompat.ah(i, 268435455, dsz.b.getDescriptor());
            throw null;
        }
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = num;
        this.h = num2;
        this.i = list;
        this.j = str6;
        this.k = l;
        this.l = str7;
        this.m = str8;
        this.n = str9;
        this.o = num3;
        this.p = str10;
        this.q = str11;
        this.r = str12;
        this.s = str13;
        this.t = num4;
        this.u = str14;
        this.v = num5;
        this.w = str15;
        this.x = str16;
        this.y = str17;
        this.z = str18;
        this.aa = num6;
        this.ab = str19;
        this.ac = dxtVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dtb)) {
            return false;
        }
        dtb dtbVar = (dtb) obj;
        return nullSafeIsEqual(this.b, dtbVar.b) && nullSafeIsEqual(this.c, dtbVar.c)
                && nullSafeIsEqual(this.d, dtbVar.d) && nullSafeIsEqual(this.e, dtbVar.e)
                && nullSafeIsEqual(this.f, dtbVar.f) && nullSafeIsEqual(this.g, dtbVar.g)
                && nullSafeIsEqual(this.h, dtbVar.h) && nullSafeIsEqual(this.i, dtbVar.i)
                && nullSafeIsEqual(this.j, dtbVar.j) && nullSafeIsEqual(this.k, dtbVar.k)
                && nullSafeIsEqual(this.l, dtbVar.l) && nullSafeIsEqual(this.m, dtbVar.m)
                && nullSafeIsEqual(this.n, dtbVar.n) && nullSafeIsEqual(this.o, dtbVar.o)
                && nullSafeIsEqual(this.p, dtbVar.p) && nullSafeIsEqual(this.q, dtbVar.q)
                && nullSafeIsEqual(this.r, dtbVar.r) && nullSafeIsEqual(this.s, dtbVar.s)
                && nullSafeIsEqual(this.t, dtbVar.t) && nullSafeIsEqual(this.u, dtbVar.u)
                && nullSafeIsEqual(this.v, dtbVar.v) && nullSafeIsEqual(this.w, dtbVar.w)
                && nullSafeIsEqual(this.x, dtbVar.x) && nullSafeIsEqual(this.y, dtbVar.y)
                && nullSafeIsEqual(this.z, dtbVar.z) && nullSafeIsEqual(this.aa, dtbVar.aa)
                && nullSafeIsEqual(this.ab, dtbVar.ab) && nullSafeIsEqual(this.ac, dtbVar.ac);
    }

    public final int hashCode() {
        String str = this.b;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.c;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.d;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.e;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num = this.g;
        int iHashCode6 = (iHashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.h;
        int iHashCode7 = (iHashCode6 + (num2 == null ? 0 : num2.hashCode())) * 31;
        List list = this.i;
        int iHashCode8 = (iHashCode7 + (list == null ? 0 : list.hashCode())) * 31;
        String str6 = this.j;
        int iHashCode9 = (iHashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Long l = this.k;
        int iHashCode10 = (iHashCode9 + (l == null ? 0 : l.hashCode())) * 31;
        String str7 = this.l;
        int iHashCode11 = (iHashCode10 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.m;
        int iHashCode12 = (iHashCode11 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.n;
        int iHashCode13 = (iHashCode12 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Integer num3 = this.o;
        int iHashCode14 = (iHashCode13 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str10 = this.p;
        int iHashCode15 = (iHashCode14 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.q;
        int iHashCode16 = (iHashCode15 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.r;
        int iHashCode17 = (iHashCode16 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.s;
        int iHashCode18 = (iHashCode17 + (str13 == null ? 0 : str13.hashCode())) * 31;
        Integer num4 = this.t;
        int iHashCode19 = (iHashCode18 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str14 = this.u;
        int iHashCode20 = (iHashCode19 + (str14 == null ? 0 : str14.hashCode())) * 31;
        Integer num5 = this.v;
        int iHashCode21 = (iHashCode20 + (num5 == null ? 0 : num5.hashCode())) * 31;
        String str15 = this.w;
        int iHashCode22 = (iHashCode21 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.x;
        int iHashCode23 = (iHashCode22 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.y;
        int iHashCode24 = (iHashCode23 + (str17 == null ? 0 : str17.hashCode())) * 31;
        String str18 = this.z;
        int iHashCode25 = (iHashCode24 + (str18 == null ? 0 : str18.hashCode())) * 31;
        Integer num6 = this.aa;
        int iHashCode26 = (iHashCode25 + (num6 == null ? 0 : num6.hashCode())) * 31;
        String str19 = this.ab;
        int iHashCode27 = (iHashCode26 + (str19 == null ? 0 : str19.hashCode())) * 31;
        dxt dxtVar = this.ac;
        return iHashCode27 + (dxtVar != null ? dxtVar.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FinderFeedProto(objectId=" /* "FinderFeedProto(objectId=" /* "FinderFeedProto(objectId=" /* cnb.z(-179422258789162L)  */);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.b, -179259050031914L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.c, -179241870162730L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.d, -179705726630698L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.e, -179679956826922L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.f, -179645597088554L);
        bjs.w(sb, this.g, -179628417219370L);
        bjs.w(sb, this.h, -179551107808042L);
        yg.v(sb, this.i, -176729314294570L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.j, -176656299850538L);
        StaticHelpers6.ad(sb, this.k, -176643414948650L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.l, -176561810570026L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.m, -177017077103402L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.n, -176952652593962L);
        bjs.w(sb, this.o, -176883933117226L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.p, -176802328738602L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.q, -176188148415274L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.r, -176097954102058L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.s, -176042119527210L);
        bjs.w(sb, this.t, -175977695017770L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.u, -176467321289514L);
        bjs.w(sb, this.v, -176351357172522L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.w, -176286932663082L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.x, -177837415856938L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.y, -177725746707242L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.z, -177708566838058L);
        bjs.w(sb, this.aa, -177631257426730L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.ab, -178103703829290L);
        sb.append(this.ac);
        sb.append(')');
        return sb.toString();
    }
}
