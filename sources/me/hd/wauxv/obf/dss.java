package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dss {
    public static final dsr Companion = new dsr();
    public static final IHasGetValue[] a = { null, null, null, null, StaticAndroidHelpers.am(btx.a, new Function1$VarIsInt$2(27)), null, null, null, null,
            null,
            null, null, null, null, null, null, null, null, null, null, null };
    public final String b;
    public final Integer c;
    public final String d;
    public final String e;
    public final List f;
    public final Integer g;
    public final String h;
    public final dty i;
    public final dtb j;
    public final dvo k;
    public final dzj l;
    public final egc m;
    public final duh n;
    public final edz o;
    public final Integer p;
    public final dvo q;
    public final eiq r;
    public final duz s;
    public final ebo t;
    public final dvo u;
    public final eaz v;

    public /* synthetic */ dss(int i, String str, Integer num, String str2, String str3, List list, Integer num2,
            String str4, dty dtyVar, dtb dtbVar, dvo dvoVar, dzj dzjVar, egc egcVar, duh duhVar, edz edzVar,
            Integer num3, dvo dvoVar2, eiq eiqVar, duz duzVar, ebo eboVar, dvo dvoVar3, eaz eazVar) {
        if (2097151 != (i & 2097151)) {
            ResourcesCompat.ah(i, 2097151, dsq.b.getDescriptor());
            throw null;
        }
        this.b = str;
        this.c = num;
        this.d = str2;
        this.e = str3;
        this.f = list;
        this.g = num2;
        this.h = str4;
        this.i = dtyVar;
        this.j = dtbVar;
        this.k = dvoVar;
        this.l = dzjVar;
        this.m = egcVar;
        this.n = duhVar;
        this.o = edzVar;
        this.p = num3;
        this.q = dvoVar2;
        this.r = eiqVar;
        this.s = duzVar;
        this.t = eboVar;
        this.u = dvoVar3;
        this.v = eazVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dss)) {
            return false;
        }
        dss dssVar = (dss) obj;
        return nullSafeIsEqual(this.b, dssVar.b) && nullSafeIsEqual(this.c, dssVar.c)
                && nullSafeIsEqual(this.d, dssVar.d) && nullSafeIsEqual(this.e, dssVar.e)
                && nullSafeIsEqual(this.f, dssVar.f) && nullSafeIsEqual(this.g, dssVar.g)
                && nullSafeIsEqual(this.h, dssVar.h) && nullSafeIsEqual(this.i, dssVar.i)
                && nullSafeIsEqual(this.j, dssVar.j) && nullSafeIsEqual(this.k, dssVar.k)
                && nullSafeIsEqual(this.l, dssVar.l) && nullSafeIsEqual(this.m, dssVar.m)
                && nullSafeIsEqual(this.n, dssVar.n) && nullSafeIsEqual(this.o, dssVar.o)
                && nullSafeIsEqual(this.p, dssVar.p) && nullSafeIsEqual(this.q, dssVar.q)
                && nullSafeIsEqual(this.r, dssVar.r) && nullSafeIsEqual(this.s, dssVar.s)
                && nullSafeIsEqual(this.t, dssVar.t) && nullSafeIsEqual(this.u, dssVar.u)
                && nullSafeIsEqual(this.v, dssVar.v);
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
        List list = this.f;
        int iHashCode5 = (iHashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        Integer num2 = this.g;
        int iHashCode6 = (iHashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str4 = this.h;
        int iHashCode7 = (iHashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        dty dtyVar = this.i;
        int iHashCode8 = (iHashCode7 + (dtyVar == null ? 0 : dtyVar.hashCode())) * 31;
        dtb dtbVar = this.j;
        int iHashCode9 = (iHashCode8 + (dtbVar == null ? 0 : dtbVar.hashCode())) * 31;
        dvo dvoVar = this.k;
        int iHashCode10 = (iHashCode9 + (dvoVar == null ? 0 : dvoVar.hashCode())) * 31;
        dzj dzjVar = this.l;
        int iHashCode11 = (iHashCode10 + (dzjVar == null ? 0 : dzjVar.hashCode())) * 31;
        egc egcVar = this.m;
        int iHashCode12 = (iHashCode11 + (egcVar == null ? 0 : egcVar.hashCode())) * 31;
        duh duhVar = this.n;
        int iHashCode13 = (iHashCode12 + (duhVar == null ? 0 : duhVar.hashCode())) * 31;
        edz edzVar = this.o;
        int iHashCode14 = (iHashCode13 + (edzVar == null ? 0 : edzVar.hashCode())) * 31;
        Integer num3 = this.p;
        int iHashCode15 = (iHashCode14 + (num3 == null ? 0 : num3.hashCode())) * 31;
        dvo dvoVar2 = this.q;
        int iHashCode16 = (iHashCode15 + (dvoVar2 == null ? 0 : dvoVar2.hashCode())) * 31;
        eiq eiqVar = this.r;
        int iHashCode17 = (iHashCode16 + (eiqVar == null ? 0 : eiqVar.hashCode())) * 31;
        duz duzVar = this.s;
        int iHashCode18 = (iHashCode17 + (duzVar == null ? 0 : duzVar.hashCode())) * 31;
        ebo eboVar = this.t;
        int iHashCode19 = (iHashCode18 + (eboVar == null ? 0 : eboVar.hashCode())) * 31;
        dvo dvoVar3 = this.u;
        int iHashCode20 = (iHashCode19 + (dvoVar3 == null ? 0 : dvoVar3.hashCode())) * 31;
        eaz eazVar = this.v;
        return iHashCode20 + (eazVar != null ? eazVar.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ContentObjProto(description=" /* "ContentObjProto(description=" /* "ContentObjProto(description=" /* cnb.z(-173508088822570L)  */);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.b, -172799419218730L);
        bjs.w(sb, this.c, -172730699741994L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.d, -172709224905514L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.e, -172631915494186L);
        yg.v(sb, this.f, -173160196471594L);
        bjs.w(sb, this.g, -173044232354602L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.h, -173031347452714L);
        sb.append(this.i);
        sb.append(", finderFeed=" /* ", finderFeed=" /* ", finderFeed=" /* cnb.z(-172966922943274L)  */);
        sb.append(this.j);
        sb.append(", shareFinderTopic=" /* ", shareFinderTopic=" /* ", shareFinderTopic=" /* cnb.z(-161344741440298L)  */);
        sb.append(this.k);
        sb.append(", brandmpvideo=" /* ", brandmpvideo=" /* ", brandmpvideo=" /* cnb.z(-161224482356010L)  */);
        sb.append(this.l);
        sb.append(", finderColumn=" /* ", finderColumn=" /* ", finderColumn=" /* cnb.z(-161155762879274L)  */);
        sb.append(this.m);
        sb.append(", springFinderLive=" /* ", springFinderLive=" /* ", springFinderLive=" /* cnb.z(-161087043402538L)  */);
        sb.append(this.n);
        sb.append(", finderMegaVideo=" /* ", finderMegaVideo=" /* ", finderMegaVideo=" /* cnb.z(-161585259608874L)  */);
        sb.append(this.o);
        sb.append(", finderType=" /* ", finderType=" /* ", finderType=" /* cnb.z(-161520835099434L)  */);
        bjs.w(sb, this.p, -161443525688106L);
        sb.append(this.q);
        sb.append(", shareMusic=" /* ", shareMusic=" /* ", shareMusic=" /* cnb.z(-161379101178666L)  */);
        sb.append(this.r);
        sb.append(", sharePoi=" /* ", sharePoi=" /* ", sharePoi=" /* cnb.z(-160752035953450L)  */);
        sb.append(this.s);
        sb.append(", linkEnabled=" /* ", linkEnabled=" /* ", linkEnabled=" /* cnb.z(-160734856084266L)  */);
        sb.append(this.t);
        sb.append(", shareMusicTopic=" /* ", shareMusicTopic=" /* ", shareMusicTopic=" /* cnb.z(-160653251705642L)  */);
        sb.append(this.u);
        sb.append(", rabbit2023=" /* ", rabbit2023=" /* ", rabbit2023=" /* cnb.z(-160537287588650L)  */);
        sb.append(this.v);
        sb.append(')');
        return sb.toString();
    }
}
