package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ejy {
    public static final dsp Companion = new dsp();
    public final String a;
    public final Boolean aa;
    public final dtk ab;
    public final String b;
    public final Integer c;
    public final Integer d;
    public final String e;
    public final dtq f;
    public final dsf g;
    public final dss h;
    public final String i;
    public final String j;
    public final String k;
    public final Integer l;
    public final Integer m;
    public final String n;
    public final drz o;
    public final Integer p;
    public final duk q;
    public final String r;
    public final String s;
    public final dut t;
    public final Integer u;
    public final duw v;
    public final Integer w;
    public final dtn x;
    public final duq y;
    public final String z;

    public /* synthetic */ ejy(int i, String str, String str2, Integer num, Integer num2, String str3, dtq dtqVar,
            dsf dsfVar, dss dssVar, String str4, String str5, String str6, Integer num3, Integer num4, String str7,
            drz drzVar, Integer num5, duk dukVar, String str8, String str9, dut dutVar, Integer num6, duw duwVar,
            Integer num7, dtn dtnVar, duq duqVar, String str10, Boolean bool, dtk dtkVar) {
        if (268435455 != (i & 268435455)) {
            ResourcesCompat.ah(i, 268435455, drw.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = str2;
        this.c = num;
        this.d = num2;
        this.e = str3;
        this.f = dtqVar;
        this.g = dsfVar;
        this.h = dssVar;
        this.i = str4;
        this.j = str5;
        this.k = str6;
        this.l = num3;
        this.m = num4;
        this.n = str7;
        this.o = drzVar;
        this.p = num5;
        this.q = dukVar;
        this.r = str8;
        this.s = str9;
        this.t = dutVar;
        this.u = num6;
        this.v = duwVar;
        this.w = num7;
        this.x = dtnVar;
        this.y = duqVar;
        this.z = str10;
        this.aa = bool;
        this.ab = dtkVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ejy)) {
            return false;
        }
        ejy ejyVar = (ejy) obj;
        return nullSafeIsEqual(this.a, ejyVar.a) && nullSafeIsEqual(this.b, ejyVar.b)
                && nullSafeIsEqual(this.c, ejyVar.c) && nullSafeIsEqual(this.d, ejyVar.d)
                && nullSafeIsEqual(this.e, ejyVar.e) && nullSafeIsEqual(this.f, ejyVar.f)
                && nullSafeIsEqual(this.g, ejyVar.g) && nullSafeIsEqual(this.h, ejyVar.h)
                && nullSafeIsEqual(this.i, ejyVar.i) && nullSafeIsEqual(this.j, ejyVar.j)
                && nullSafeIsEqual(this.k, ejyVar.k) && nullSafeIsEqual(this.l, ejyVar.l)
                && nullSafeIsEqual(this.m, ejyVar.m) && nullSafeIsEqual(this.n, ejyVar.n)
                && nullSafeIsEqual(this.o, ejyVar.o) && nullSafeIsEqual(this.p, ejyVar.p)
                && nullSafeIsEqual(this.q, ejyVar.q) && nullSafeIsEqual(this.r, ejyVar.r)
                && nullSafeIsEqual(this.s, ejyVar.s) && nullSafeIsEqual(this.t, ejyVar.t)
                && nullSafeIsEqual(this.u, ejyVar.u) && nullSafeIsEqual(this.v, ejyVar.v)
                && nullSafeIsEqual(this.w, ejyVar.w) && nullSafeIsEqual(this.x, ejyVar.x)
                && nullSafeIsEqual(this.y, ejyVar.y) && nullSafeIsEqual(this.z, ejyVar.z)
                && nullSafeIsEqual(this.aa, ejyVar.aa) && nullSafeIsEqual(this.ab, ejyVar.ab);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.c;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.d;
        int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str3 = this.e;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        dtq dtqVar = this.f;
        int iHashCode6 = (iHashCode5 + (dtqVar == null ? 0 : dtqVar.hashCode())) * 31;
        dsf dsfVar = this.g;
        int iHashCode7 = (iHashCode6 + (dsfVar == null ? 0 : dsfVar.hashCode())) * 31;
        dss dssVar = this.h;
        int iHashCode8 = (iHashCode7 + (dssVar == null ? 0 : dssVar.hashCode())) * 31;
        String str4 = this.i;
        int iHashCode9 = (iHashCode8 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.j;
        int iHashCode10 = (iHashCode9 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.k;
        int iHashCode11 = (iHashCode10 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Integer num3 = this.l;
        int iHashCode12 = (iHashCode11 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.m;
        int iHashCode13 = (iHashCode12 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str7 = this.n;
        int iHashCode14 = (iHashCode13 + (str7 == null ? 0 : str7.hashCode())) * 31;
        drz drzVar = this.o;
        int iHashCode15 = (iHashCode14 + (drzVar == null ? 0 : drzVar.hashCode())) * 31;
        Integer num5 = this.p;
        int iHashCode16 = (iHashCode15 + (num5 == null ? 0 : num5.hashCode())) * 31;
        duk dukVar = this.q;
        int iHashCode17 = (iHashCode16 + (dukVar == null ? 0 : dukVar.hashCode())) * 31;
        String str8 = this.r;
        int iHashCode18 = (iHashCode17 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.s;
        int iHashCode19 = (iHashCode18 + (str9 == null ? 0 : str9.hashCode())) * 31;
        dut dutVar = this.t;
        int iHashCode20 = (iHashCode19 + (dutVar == null ? 0 : dutVar.hashCode())) * 31;
        Integer num6 = this.u;
        int iHashCode21 = (iHashCode20 + (num6 == null ? 0 : num6.hashCode())) * 31;
        duw duwVar = this.v;
        int iHashCode22 = (iHashCode21 + (duwVar == null ? 0 : duwVar.hashCode())) * 31;
        Integer num7 = this.w;
        int iHashCode23 = (iHashCode22 + (num7 == null ? 0 : num7.hashCode())) * 31;
        dtn dtnVar = this.x;
        int iHashCode24 = (iHashCode23 + (dtnVar == null ? 0 : dtnVar.hashCode())) * 31;
        duq duqVar = this.y;
        int iHashCode25 = (iHashCode24 + (duqVar == null ? 0 : duqVar.hashCode())) * 31;
        String str10 = this.z;
        int iHashCode26 = (iHashCode25 + (str10 == null ? 0 : str10.hashCode())) * 31;
        Boolean bool = this.aa;
        int iHashCode27 = (iHashCode26 + (bool == null ? 0 : bool.hashCode())) * 31;
        dtk dtkVar = this.ab;
        return iHashCode27 + (dtkVar != null ? dtkVar.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TimeLineObjectProto(id=" /* "TimeLineObjectProto(id=" /* "TimeLineObjectProto(id=" /* cnb.z(-348794294106922L)  */);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.a, -348691214891818L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.b, -348674035022634L);
        bjs.w(sb, this.c, -348588135676714L);
        bjs.w(sb, this.d, -348579545742122L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.e, -349047697177386L);
        sb.append(this.f);
        sb.append(", appInfo=" /* ", appInfo=" /* ", appInfo=" /* cnb.z(-348961797831466L)  */);
        sb.append(this.g);
        sb.append(", contentObj=" /* ", contentObj=" /* ", contentObj=" /* cnb.z(-348948912929578L)  */);
        sb.append(this.h);
        sb.append(", sourceUserName=" /* ", sourceUserName=" /* ", sourceUserName=" /* cnb.z(-348871603518250L)  */);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.i, -337266601884458L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.j, -337206472342314L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.k, -337077623323434L);
        bjs.w(sb, this.l, -337030378683178L);
        bjs.w(sb, this.m, -337459875412778L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.n, -337399745870634L);
        sb.append(this.o);
        sb.append(", contentattr=" /* ", contentattr=" /* ", contentattr=" /* cnb.z(-337322436459306L)  */);
        bjs.w(sb, this.p, -336708256135978L);
        sb.append(this.q);
        sb.append(", statExtStr=" /* ", statExtStr=" /* ", statExtStr=" /* cnb.z(-336626651757354L)  */);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.r, -336618061822762L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.s, -336540752411434L);
        sb.append(this.t);
        sb.append(", sightFolded=" /* ", sightFolded=" /* ", sightFolded=" /* cnb.z(-336467737967402L)  */);
        bjs.w(sb, this.u, -336935889402666L);
        sb.append(this.v);
        sb.append(", showFlag=" /* ", showFlag=" /* ", showFlag=" /* cnb.z(-336880054827818L)  */);
        bjs.w(sb, this.w, -336862874958634L);
        sb.append(this.x);
        sb.append(", videoTemplate=" /* ", videoTemplate=" /* ", videoTemplate=" /* cnb.z(-336781270580010L)  */);
        sb.append(this.y);
        sb.append(", snsExcerptUrl=" /* ", snsExcerptUrl=" /* ", snsExcerptUrl=" /* cnb.z(-338374703446826L)  */);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.z, -338301689002794L);
        dts.g(sb, this.aa, -338228674558762L);
        sb.append(this.ab);
        sb.append(')');
        return sb.toString();
    }
}
