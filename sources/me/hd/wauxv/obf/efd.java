package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class efd {
    public static final efc Companion = new efc();
    public static final IHasGetValue[] a;
    public final List b;
    public final egf c;
    public final List d;
    public final dwj e;
    public final dwj f;
    public final dwj g;
    public final dwj h;
    public final String i;
    public final dwj j;
    public final String k;
    public final Boolean l;

    static {
        dtr dtrVar = new dtr(28);
        btx btxVar = btx.a;
        a = new IHasGetValue[] { StaticAndroidHelpers.am(btxVar, dtrVar), null, StaticAndroidHelpers.am(btxVar, new dtr(29)), null, null, null, null,
                null, null,
                null, null };
    }

    public /* synthetic */ efd(int i, List list, egf egfVar, List list2, dwj dwjVar, dwj dwjVar2, dwj dwjVar3,
            dwj dwjVar4, String str, dwj dwjVar5, String str2, Boolean bool) {
        if (2047 != (i & 2047)) {
            ResourcesCompat.ah(i, 2047, efb.b.getDescriptor());
            throw null;
        }
        this.b = list;
        this.c = egfVar;
        this.d = list2;
        this.e = dwjVar;
        this.f = dwjVar2;
        this.g = dwjVar3;
        this.h = dwjVar4;
        this.i = str;
        this.j = dwjVar5;
        this.k = str2;
        this.l = bool;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof efd)) {
            return false;
        }
        efd efdVar = (efd) obj;
        return nullSafeIsEqual(this.b, efdVar.b) && nullSafeIsEqual(this.c, efdVar.c)
                && nullSafeIsEqual(this.d, efdVar.d) && nullSafeIsEqual(this.e, efdVar.e)
                && nullSafeIsEqual(this.f, efdVar.f) && nullSafeIsEqual(this.g, efdVar.g)
                && nullSafeIsEqual(this.h, efdVar.h) && nullSafeIsEqual(this.i, efdVar.i)
                && nullSafeIsEqual(this.j, efdVar.j) && nullSafeIsEqual(this.k, efdVar.k)
                && nullSafeIsEqual(this.l, efdVar.l);
    }

    public final int hashCode() {
        List list = this.b;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        egf egfVar = this.c;
        int iHashCode2 = (iHashCode + (egfVar == null ? 0 : egfVar.hashCode())) * 31;
        List list2 = this.d;
        int iHashCode3 = (iHashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31;
        dwj dwjVar = this.e;
        int iHashCode4 = (iHashCode3 + (dwjVar == null ? 0 : dwjVar.hashCode())) * 31;
        dwj dwjVar2 = this.f;
        int iHashCode5 = (iHashCode4 + (dwjVar2 == null ? 0 : dwjVar2.hashCode())) * 31;
        dwj dwjVar3 = this.g;
        int iHashCode6 = (iHashCode5 + (dwjVar3 == null ? 0 : dwjVar3.hashCode())) * 31;
        dwj dwjVar4 = this.h;
        int iHashCode7 = (iHashCode6 + (dwjVar4 == null ? 0 : dwjVar4.hashCode())) * 31;
        String str = this.i;
        int iHashCode8 = (iHashCode7 + (str == null ? 0 : str.hashCode())) * 31;
        dwj dwjVar5 = this.j;
        int iHashCode9 = (iHashCode8 + (dwjVar5 == null ? 0 : dwjVar5.hashCode())) * 31;
        String str2 = this.k;
        int iHashCode10 = (iHashCode9 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.l;
        return iHashCode10 + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("t40Proto(reward_product_id=" /* "t40Proto(reward_product_id=" /* "t40Proto(reward_product_id=" /* "t40Proto(reward_product_id=" /* cnb.z(-285400576817962L)   */);
        yg.v(sb, this.b, -285864433285930L);
        sb.append(this.c);
        sb.append(", thumbnail_file_url=" /* ", thumbnail_file_url=" /* ", thumbnail_file_url=" /* ", thumbnail_file_url=" /* cnb.z(-285791418841898L)   */);
        yg.v(sb, this.d, -285679749692202L);
        dts.h(sb, this.e, -285632505051946L);
        dts.h(sb, this.f, -284958195186474L);
        dts.h(sb, this.g, -284846526036778L);
        dts.h(sb, this.h, -284799281396522L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.i, -285224483158826L);
        dts.h(sb, this.j, -285190123420458L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.k, -285168648583978L);
        sb.append(this.l);
        sb.append(')');
        return sb.toString();
    }
}
