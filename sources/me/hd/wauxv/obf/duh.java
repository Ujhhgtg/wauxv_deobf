package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class duh {
    public static final dug Companion = new dug();
    public final String a;
    public final String aa;
    public final String ab;
    public final String ac;
    public final String ad;
    public final String ae;
    public final String af;
    public final String ag;
    public final String ah;
    public final Integer ai;
    public final String aj;
    public final String ak;
    public final Integer al;
    public final Integer am;
    public final String an;
    public final String ao;
    public final String ap;
    public final eat aq;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final Float g;
    public final Float h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final Integer n;
    public final Integer o;
    public final Integer p;
    public final String q;
    public final String r;
    public final Integer s;
    public final Integer t;
    public final String u;
    public final String v;
    public final Integer w;
    public final String x;
    public final String y;
    public final String z;

    public /* synthetic */ duh(int i, int i2, String str, String str2, String str3, String str4, String str5,
            String str6, Float f, Float f2, String str7, String str8, String str9, String str10, String str11,
            Integer num, Integer num2, Integer num3, String str12, String str13, Integer num4, Integer num5,
            String str14, String str15, Integer num6, String str16, String str17, String str18, String str19,
            String str20, String str21, String str22, String str23, String str24, String str25, String str26,
            Integer num7, String str27, String str28, Integer num8, Integer num9, String str29, String str30,
            String str31, eat eatVar) {
        if ((2047 != (i2 & 2047)) || (-1 != i)) {
            ResourcesCompat.ag(new int[] { i, i2 }, new int[] { -1, 2047 }, duf.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = f;
        this.h = f2;
        this.i = str7;
        this.j = str8;
        this.k = str9;
        this.l = str10;
        this.m = str11;
        this.n = num;
        this.o = num2;
        this.p = num3;
        this.q = str12;
        this.r = str13;
        this.s = num4;
        this.t = num5;
        this.u = str14;
        this.v = str15;
        this.w = num6;
        this.x = str16;
        this.y = str17;
        this.z = str18;
        this.aa = str19;
        this.ab = str20;
        this.ac = str21;
        this.ad = str22;
        this.ae = str23;
        this.af = str24;
        this.ag = str25;
        this.ah = str26;
        this.ai = num7;
        this.aj = str27;
        this.ak = str28;
        this.al = num8;
        this.am = num9;
        this.an = str29;
        this.ao = str30;
        this.ap = str31;
        this.aq = eatVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof duh)) {
            return false;
        }
        duh duhVar = (duh) obj;
        return nullSafeIsEqual(this.a, duhVar.a) && nullSafeIsEqual(this.b, duhVar.b)
                && nullSafeIsEqual(this.c, duhVar.c) && nullSafeIsEqual(this.d, duhVar.d)
                && nullSafeIsEqual(this.e, duhVar.e) && nullSafeIsEqual(this.f, duhVar.f)
                && nullSafeIsEqual(this.g, duhVar.g) && nullSafeIsEqual(this.h, duhVar.h)
                && nullSafeIsEqual(this.i, duhVar.i) && nullSafeIsEqual(this.j, duhVar.j)
                && nullSafeIsEqual(this.k, duhVar.k) && nullSafeIsEqual(this.l, duhVar.l)
                && nullSafeIsEqual(this.m, duhVar.m) && nullSafeIsEqual(this.n, duhVar.n)
                && nullSafeIsEqual(this.o, duhVar.o) && nullSafeIsEqual(this.p, duhVar.p)
                && nullSafeIsEqual(this.q, duhVar.q) && nullSafeIsEqual(this.r, duhVar.r)
                && nullSafeIsEqual(this.s, duhVar.s) && nullSafeIsEqual(this.t, duhVar.t)
                && nullSafeIsEqual(this.u, duhVar.u) && nullSafeIsEqual(this.v, duhVar.v)
                && nullSafeIsEqual(this.w, duhVar.w) && nullSafeIsEqual(this.x, duhVar.x)
                && nullSafeIsEqual(this.y, duhVar.y) && nullSafeIsEqual(this.z, duhVar.z)
                && nullSafeIsEqual(this.aa, duhVar.aa) && nullSafeIsEqual(this.ab, duhVar.ab)
                && nullSafeIsEqual(this.ac, duhVar.ac) && nullSafeIsEqual(this.ad, duhVar.ad)
                && nullSafeIsEqual(this.ae, duhVar.ae) && nullSafeIsEqual(this.af, duhVar.af)
                && nullSafeIsEqual(this.ag, duhVar.ag) && nullSafeIsEqual(this.ah, duhVar.ah)
                && nullSafeIsEqual(this.ai, duhVar.ai) && nullSafeIsEqual(this.aj, duhVar.aj)
                && nullSafeIsEqual(this.ak, duhVar.ak) && nullSafeIsEqual(this.al, duhVar.al)
                && nullSafeIsEqual(this.am, duhVar.am) && nullSafeIsEqual(this.an, duhVar.an)
                && nullSafeIsEqual(this.ao, duhVar.ao) && nullSafeIsEqual(this.ap, duhVar.ap)
                && nullSafeIsEqual(this.aq, duhVar.aq);
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
        Float f = this.g;
        int iHashCode7 = (iHashCode6 + (f == null ? 0 : f.hashCode())) * 31;
        Float f2 = this.h;
        int iHashCode8 = (iHashCode7 + (f2 == null ? 0 : f2.hashCode())) * 31;
        String str7 = this.i;
        int iHashCode9 = (iHashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.j;
        int iHashCode10 = (iHashCode9 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.k;
        int iHashCode11 = (iHashCode10 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.l;
        int iHashCode12 = (iHashCode11 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.m;
        int iHashCode13 = (iHashCode12 + (str11 == null ? 0 : str11.hashCode())) * 31;
        Integer num = this.n;
        int iHashCode14 = (iHashCode13 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.o;
        int iHashCode15 = (iHashCode14 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.p;
        int iHashCode16 = (iHashCode15 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str12 = this.q;
        int iHashCode17 = (iHashCode16 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.r;
        int iHashCode18 = (iHashCode17 + (str13 == null ? 0 : str13.hashCode())) * 31;
        Integer num4 = this.s;
        int iHashCode19 = (iHashCode18 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.t;
        int iHashCode20 = (iHashCode19 + (num5 == null ? 0 : num5.hashCode())) * 31;
        String str14 = this.u;
        int iHashCode21 = (iHashCode20 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.v;
        int iHashCode22 = (iHashCode21 + (str15 == null ? 0 : str15.hashCode())) * 31;
        Integer num6 = this.w;
        int iHashCode23 = (iHashCode22 + (num6 == null ? 0 : num6.hashCode())) * 31;
        String str16 = this.x;
        int iHashCode24 = (iHashCode23 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.y;
        int iHashCode25 = (iHashCode24 + (str17 == null ? 0 : str17.hashCode())) * 31;
        String str18 = this.z;
        int iHashCode26 = (iHashCode25 + (str18 == null ? 0 : str18.hashCode())) * 31;
        String str19 = this.aa;
        int iHashCode27 = (iHashCode26 + (str19 == null ? 0 : str19.hashCode())) * 31;
        String str20 = this.ab;
        int iHashCode28 = (iHashCode27 + (str20 == null ? 0 : str20.hashCode())) * 31;
        String str21 = this.ac;
        int iHashCode29 = (iHashCode28 + (str21 == null ? 0 : str21.hashCode())) * 31;
        String str22 = this.ad;
        int iHashCode30 = (iHashCode29 + (str22 == null ? 0 : str22.hashCode())) * 31;
        String str23 = this.ae;
        int iHashCode31 = (iHashCode30 + (str23 == null ? 0 : str23.hashCode())) * 31;
        String str24 = this.af;
        int iHashCode32 = (iHashCode31 + (str24 == null ? 0 : str24.hashCode())) * 31;
        String str25 = this.ag;
        int iHashCode33 = (iHashCode32 + (str25 == null ? 0 : str25.hashCode())) * 31;
        String str26 = this.ah;
        int iHashCode34 = (iHashCode33 + (str26 == null ? 0 : str26.hashCode())) * 31;
        Integer num7 = this.ai;
        int iHashCode35 = (iHashCode34 + (num7 == null ? 0 : num7.hashCode())) * 31;
        String str27 = this.aj;
        int iHashCode36 = (iHashCode35 + (str27 == null ? 0 : str27.hashCode())) * 31;
        String str28 = this.ak;
        int iHashCode37 = (iHashCode36 + (str28 == null ? 0 : str28.hashCode())) * 31;
        Integer num8 = this.al;
        int iHashCode38 = (iHashCode37 + (num8 == null ? 0 : num8.hashCode())) * 31;
        Integer num9 = this.am;
        int iHashCode39 = (iHashCode38 + (num9 == null ? 0 : num9.hashCode())) * 31;
        String str29 = this.an;
        int iHashCode40 = (iHashCode39 + (str29 == null ? 0 : str29.hashCode())) * 31;
        String str30 = this.ao;
        int iHashCode41 = (iHashCode40 + (str30 == null ? 0 : str30.hashCode())) * 31;
        String str31 = this.ap;
        int iHashCode42 = (iHashCode41 + (str31 == null ? 0 : str31.hashCode())) * 31;
        eat eatVar = this.aq;
        return iHashCode42 + (eatVar != null ? eatVar.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SpringFinderLiveProto(liveId=" /* "SpringFinderLiveProto(liveId=" /* "SpringFinderLiveProto(liveId=" /* "SpringFinderLiveProto(liveId=" /* cnb.z(-294067820821290L)   */);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.a, -293921791933226L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.b, -293904612064042L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.c, -293878842260266L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.d, -291044163844906L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.e, -291009804106538L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.f, -290992624237354L);
        bjs.v(sb, this.g, -290953969531690L);
        bjs.v(sb, this.h, -290859480251178L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.i, -291353401490218L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.j, -291331926653738L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.k, -291211667569450L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.l, -291198782667562L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.m, -291125768223530L);
        bjs.w(sb, this.n, -290498702998314L);
        bjs.w(sb, this.o, -290417098619690L);
        bjs.w(sb, this.p, -290408508685098L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.q, -290322609339178L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.r, -290807940643626L);
        bjs.w(sb, this.s, -290739221166890L);
        bjs.w(sb, this.t, -290653321820970L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.u, -290588897311530L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.v, -290576012409642L);
        bjs.w(sb, this.w, -292147970439978L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.x, -292074955995946L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.y, -292006236519210L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.z, -291937517042474L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.aa, -292435733248810L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.ab, -292358423837482L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.ac, -292285409393450L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.ad, -292216689916714L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.ae, -291585329724202L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.af, -291538085083946L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.ag, -291473660574506L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.ah, -291404941097770L);
        bjs.w(sb, this.ai, -291821552925482L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.aj, -291774308285226L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.ak, -291696998873898L);
        bjs.w(sb, this.al, -291679819004714L);
        bjs.w(sb, this.am, -297658413480746L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.an, -297581104069418L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.ao, -297503794658090L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.ap, -297443665115946L);
        sb.append(this.aq);
        sb.append(')');
        return sb.toString();
    }
}
