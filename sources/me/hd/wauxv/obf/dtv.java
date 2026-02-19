package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dtv {
    public static final dtu Companion = new dtu();
    public static final IHasGetValue[] a;
    public final String aa;
    public final String ab;
    public final Integer ac;
    public final String ad;
    public final String ae;
    public final Integer af;
    public final String ag;
    public final String ah;
    public final Boolean ai;
    public final String aj;
    public final String ak;
    public final Float al;
    public final Integer am;
    public final List an;
    public final String ao;
    public final List ap;
    public final dub aq;
    public final String b;
    public final Integer c;
    public final String d;
    public final String e;
    public final Integer f;
    public final String g;
    public final Integer h;
    public final Integer i;
    public final String j;
    public final due k;
    public final String l;
    public final Integer m;
    public final Integer n;
    public final Integer o;
    public final String p;
    public final Integer q;
    public final String r;
    public final String s;
    public final String t;
    public final String u;
    public final Integer v;
    public final String w;
    public final String x;
    public final Integer y;
    public final Long z;

    static {
        cfh cfhVar = new cfh(29);
        btx btxVar = btx.a;
        a = new IHasGetValue[] { null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, ewz.am(btxVar, cfhVar), null, ewz.am(btxVar, new dtr(0)), null };
    }

    public /* synthetic */ dtv(int i, int i2, String str, Integer num, String str2, String str3, Integer num2,
            String str4, Integer num3, Integer num4, String str5, due dueVar, String str6, Integer num5, Integer num6,
            Integer num7, String str7, Integer num8, String str8, String str9, String str10, String str11, Integer num9,
            String str12, String str13, Integer num10, Long l, String str14, String str15, Integer num11, String str16,
            String str17, Integer num12, String str18, String str19, Boolean bool, String str20, String str21, Float f,
            Integer num13, List list, String str22, List list2, dub dubVar) {
        if ((1023 != (i2 & 1023)) || (-1 != i)) {
            bht.ag(new int[] { i, i2 }, new int[] { -1, 1023 }, dtt.b.getDescriptor());
            throw null;
        }
        this.b = str;
        this.c = num;
        this.d = str2;
        this.e = str3;
        this.f = num2;
        this.g = str4;
        this.h = num3;
        this.i = num4;
        this.j = str5;
        this.k = dueVar;
        this.l = str6;
        this.m = num5;
        this.n = num6;
        this.o = num7;
        this.p = str7;
        this.q = num8;
        this.r = str8;
        this.s = str9;
        this.t = str10;
        this.u = str11;
        this.v = num9;
        this.w = str12;
        this.x = str13;
        this.y = num10;
        this.z = l;
        this.aa = str14;
        this.ab = str15;
        this.ac = num11;
        this.ad = str16;
        this.ae = str17;
        this.af = num12;
        this.ag = str18;
        this.ah = str19;
        this.ai = bool;
        this.aj = str20;
        this.ak = str21;
        this.al = f;
        this.am = num13;
        this.an = list;
        this.ao = str22;
        this.ap = list2;
        this.aq = dubVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dtv)) {
            return false;
        }
        dtv dtvVar = (dtv) obj;
        return nullSafeIsEqual(this.b, dtvVar.b) && nullSafeIsEqual(this.c, dtvVar.c)
                && nullSafeIsEqual(this.d, dtvVar.d) && nullSafeIsEqual(this.e, dtvVar.e)
                && nullSafeIsEqual(this.f, dtvVar.f) && nullSafeIsEqual(this.g, dtvVar.g)
                && nullSafeIsEqual(this.h, dtvVar.h) && nullSafeIsEqual(this.i, dtvVar.i)
                && nullSafeIsEqual(this.j, dtvVar.j) && nullSafeIsEqual(this.k, dtvVar.k)
                && nullSafeIsEqual(this.l, dtvVar.l) && nullSafeIsEqual(this.m, dtvVar.m)
                && nullSafeIsEqual(this.n, dtvVar.n) && nullSafeIsEqual(this.o, dtvVar.o)
                && nullSafeIsEqual(this.p, dtvVar.p) && nullSafeIsEqual(this.q, dtvVar.q)
                && nullSafeIsEqual(this.r, dtvVar.r) && nullSafeIsEqual(this.s, dtvVar.s)
                && nullSafeIsEqual(this.t, dtvVar.t) && nullSafeIsEqual(this.u, dtvVar.u)
                && nullSafeIsEqual(this.v, dtvVar.v) && nullSafeIsEqual(this.w, dtvVar.w)
                && nullSafeIsEqual(this.x, dtvVar.x) && nullSafeIsEqual(this.y, dtvVar.y)
                && nullSafeIsEqual(this.z, dtvVar.z) && nullSafeIsEqual(this.aa, dtvVar.aa)
                && nullSafeIsEqual(this.ab, dtvVar.ab) && nullSafeIsEqual(this.ac, dtvVar.ac)
                && nullSafeIsEqual(this.ad, dtvVar.ad) && nullSafeIsEqual(this.ae, dtvVar.ae)
                && nullSafeIsEqual(this.af, dtvVar.af) && nullSafeIsEqual(this.ag, dtvVar.ag)
                && nullSafeIsEqual(this.ah, dtvVar.ah) && nullSafeIsEqual(this.ai, dtvVar.ai)
                && nullSafeIsEqual(this.aj, dtvVar.aj) && nullSafeIsEqual(this.ak, dtvVar.ak)
                && nullSafeIsEqual(this.al, dtvVar.al) && nullSafeIsEqual(this.am, dtvVar.am)
                && nullSafeIsEqual(this.an, dtvVar.an) && nullSafeIsEqual(this.ao, dtvVar.ao)
                && nullSafeIsEqual(this.ap, dtvVar.ap) && nullSafeIsEqual(this.aq, dtvVar.aq);
    }

    public final int hashCode() {
        String str = this.b;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.c;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.d;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.e;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num2 = this.f;
        int iHashCode5 = (iHashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str4 = this.g;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num3 = this.h;
        int iHashCode7 = (iHashCode6 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.i;
        int iHashCode8 = (iHashCode7 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str5 = this.j;
        int iHashCode9 = (iHashCode8 + (str5 == null ? 0 : str5.hashCode())) * 31;
        due dueVar = this.k;
        int iHashCode10 = (iHashCode9 + (dueVar == null ? 0 : dueVar.hashCode())) * 31;
        String str6 = this.l;
        int iHashCode11 = (iHashCode10 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Integer num5 = this.m;
        int iHashCode12 = (iHashCode11 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.n;
        int iHashCode13 = (iHashCode12 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Integer num7 = this.o;
        int iHashCode14 = (iHashCode13 + (num7 == null ? 0 : num7.hashCode())) * 31;
        String str7 = this.p;
        int iHashCode15 = (iHashCode14 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Integer num8 = this.q;
        int iHashCode16 = (iHashCode15 + (num8 == null ? 0 : num8.hashCode())) * 31;
        String str8 = this.r;
        int iHashCode17 = (iHashCode16 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.s;
        int iHashCode18 = (iHashCode17 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.t;
        int iHashCode19 = (iHashCode18 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.u;
        int iHashCode20 = (iHashCode19 + (str11 == null ? 0 : str11.hashCode())) * 31;
        Integer num9 = this.v;
        int iHashCode21 = (iHashCode20 + (num9 == null ? 0 : num9.hashCode())) * 31;
        String str12 = this.w;
        int iHashCode22 = (iHashCode21 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.x;
        int iHashCode23 = (iHashCode22 + (str13 == null ? 0 : str13.hashCode())) * 31;
        Integer num10 = this.y;
        int iHashCode24 = (iHashCode23 + (num10 == null ? 0 : num10.hashCode())) * 31;
        Long l = this.z;
        int iHashCode25 = (iHashCode24 + (l == null ? 0 : l.hashCode())) * 31;
        String str14 = this.aa;
        int iHashCode26 = (iHashCode25 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.ab;
        int iHashCode27 = (iHashCode26 + (str15 == null ? 0 : str15.hashCode())) * 31;
        Integer num11 = this.ac;
        int iHashCode28 = (iHashCode27 + (num11 == null ? 0 : num11.hashCode())) * 31;
        String str16 = this.ad;
        int iHashCode29 = (iHashCode28 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.ae;
        int iHashCode30 = (iHashCode29 + (str17 == null ? 0 : str17.hashCode())) * 31;
        Integer num12 = this.af;
        int iHashCode31 = (iHashCode30 + (num12 == null ? 0 : num12.hashCode())) * 31;
        String str18 = this.ag;
        int iHashCode32 = (iHashCode31 + (str18 == null ? 0 : str18.hashCode())) * 31;
        String str19 = this.ah;
        int iHashCode33 = (iHashCode32 + (str19 == null ? 0 : str19.hashCode())) * 31;
        Boolean bool = this.ai;
        int iHashCode34 = (iHashCode33 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str20 = this.aj;
        int iHashCode35 = (iHashCode34 + (str20 == null ? 0 : str20.hashCode())) * 31;
        String str21 = this.ak;
        int iHashCode36 = (iHashCode35 + (str21 == null ? 0 : str21.hashCode())) * 31;
        Float f = this.al;
        int iHashCode37 = (iHashCode36 + (f == null ? 0 : f.hashCode())) * 31;
        Integer num13 = this.am;
        int iHashCode38 = (iHashCode37 + (num13 == null ? 0 : num13.hashCode())) * 31;
        List list = this.an;
        int iHashCode39 = (iHashCode38 + (list == null ? 0 : list.hashCode())) * 31;
        String str22 = this.ao;
        int iHashCode40 = (iHashCode39 + (str22 == null ? 0 : str22.hashCode())) * 31;
        List list2 = this.ap;
        int iHashCode41 = (iHashCode40 + (list2 == null ? 0 : list2.hashCode())) * 31;
        dub dubVar = this.aq;
        return iHashCode41 + (dubVar != null ? dubVar.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MediaProto(id=" /* "MediaProto(id=" /* "MediaProto(id=" /* cnb.z(-230983341177642L)  */);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.b, -230901736799018L);
        bjs.w(sb, this.c, -231417132874538L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.d, -231352708365098L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.e, -231374183201578L);
        bjs.w(sb, this.f, -231288283855658L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.g, -231266809019178L);
        bjs.w(sb, this.h, -231189499607850L);
        bjs.w(sb, this.i, -232821587180330L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.j, -232782932474666L);
        sb.append(this.k);
        sb.append(", lowBandUrl=" /* ", lowBandUrl=" /* ", lowBandUrl=" /* cnb.z(-232748572736298L)  */);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.l, -232671263324970L);
        bjs.w(sb, this.m, -232555299207978L);
        bjs.w(sb, this.n, -232568184109866L);
        bjs.w(sb, this.o, -233079285218090L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.p, -233062105348906L);
        bjs.w(sb, this.q, -232963321101098L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.r, -232946141231914L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.s, -232873126787882L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.t, -232843062016810L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.u, -232237471628074L);
        bjs.w(sb, this.v, -232104327641898L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.w, -232044198099754L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.x, -232542414306090L);
        bjs.w(sb, this.y, -232512349535018L);
        dkz.ad(sb, this.z, -232413565287210L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.aa, -232400680385322L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.ab, -232310486072106L);
        bjs.w(sb, this.ac, -229497282493226L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.ad, -229467217722154L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.ae, -229402793212714L);
        bjs.w(sb, this.af, -229329778768682L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.ag, -229256764324650L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.ah, -229737800661802L);
        dts.g(sb, this.ai, -229703440923434L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.aj, -229634721446698L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.ak, -229613246610218L);
        bjs.v(sb, this.al, -229557412035370L);
        bjs.w(sb, this.am, -228917461908266L);
        yg.v(sb, this.an, -228818677660458L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.ao, -228797202823978L);
        yg.v(sb, this.ap, -228732778314538L);
        sb.append(this.aq);
        sb.append(')');
        return sb.toString();
    }
}
