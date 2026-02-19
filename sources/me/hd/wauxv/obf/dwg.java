package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dwg {
    public static final dwf Companion = new dwf();
    public static final IHasGetValue[] a = { null, null, null, null, null, null, null, null, null,
            StaticAndroidHelpers.am(btx.a, new dtr(3)) };
    public final String b;
    public final Long c;
    public final Long d;
    public final String e;
    public final String f;
    public final Long g;
    public final Boolean h;
    public final Boolean i;
    public final Integer j;
    public final List k;

    public /* synthetic */ dwg(int i, String str, Long l, Long l2, String str2, String str3, Long l3, Boolean bool,
            Boolean bool2, Integer num, List list) {
        if (1023 != (i & 1023)) {
            ResourcesCompat.ah(i, 1023, dwe.b.getDescriptor());
            throw null;
        }
        this.b = str;
        this.c = l;
        this.d = l2;
        this.e = str2;
        this.f = str3;
        this.g = l3;
        this.h = bool;
        this.i = bool2;
        this.j = num;
        this.k = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dwg)) {
            return false;
        }
        dwg dwgVar = (dwg) obj;
        return nullSafeIsEqual(this.b, dwgVar.b) && nullSafeIsEqual(this.c, dwgVar.c)
                && nullSafeIsEqual(this.d, dwgVar.d) && nullSafeIsEqual(this.e, dwgVar.e)
                && nullSafeIsEqual(this.f, dwgVar.f) && nullSafeIsEqual(this.g, dwgVar.g)
                && nullSafeIsEqual(this.h, dwgVar.h) && nullSafeIsEqual(this.i, dwgVar.i)
                && nullSafeIsEqual(this.j, dwgVar.j) && nullSafeIsEqual(this.k, dwgVar.k);
    }

    public final int hashCode() {
        String str = this.b;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l = this.c;
        int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.d;
        int iHashCode3 = (iHashCode2 + (l2 == null ? 0 : l2.hashCode())) * 31;
        String str2 = this.e;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Long l3 = this.g;
        int iHashCode6 = (iHashCode5 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Boolean bool = this.h;
        int iHashCode7 = (iHashCode6 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.i;
        int iHashCode8 = (iHashCode7 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Integer num = this.j;
        int iHashCode9 = (iHashCode8 + (num == null ? 0 : num.hashCode())) * 31;
        List list = this.k;
        return iHashCode9 + (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("cp1Proto(live_ad_id=" /* "cp1Proto(live_ad_id=" /* "cp1Proto(live_ad_id=" /* cnb.z(-161726993529642L)  */);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.b, -162169375161130L);
        StaticHelpers6.ad(sb, this.c, -162096360717098L);
        StaticHelpers6.ad(sb, this.d, -161988986534698L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.e, -161967511698218L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.f, -159141423217450L);
        StaticHelpers6.ad(sb, this.g, -159076998708010L);
        dts.g(sb, this.h, -158939559754538L);
        dts.g(sb, this.i, -159420596091690L);
        bjs.w(sb, this.j, -159356171582250L);
        sb.append(this.k);
        sb.append(')');
        return sb.toString();
    }
}
