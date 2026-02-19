package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ejx {
    public static final ejw Companion = new ejw();
    public static final IHasGetValue[] a;
    public final String b;
    public final String c;
    public final Double d;
    public final Integer e;
    public final List f;
    public final List g;
    public final Double h;

    static {
        efq efqVar = new efq(13);
        btx btxVar = btx.a;
        a = new IHasGetValue[] { null, null, null, null, StaticAndroidHelpers.am(btxVar, efqVar), StaticAndroidHelpers.am(btxVar, new efq(14)), null };
    }

    public /* synthetic */ ejx(int i, String str, String str2, Double d, Integer num, List list, List list2,
            Double d2) {
        if (127 != (i & 127)) {
            ResourcesCompat.ah(i, 127, ejv.b.getDescriptor());
            throw null;
        }
        this.b = str;
        this.c = str2;
        this.d = d;
        this.e = num;
        this.f = list;
        this.g = list2;
        this.h = d2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ejx)) {
            return false;
        }
        ejx ejxVar = (ejx) obj;
        return nullSafeIsEqual(this.b, ejxVar.b) && nullSafeIsEqual(this.c, ejxVar.c)
                && nullSafeIsEqual(this.d, ejxVar.d) && nullSafeIsEqual(this.e, ejxVar.e)
                && nullSafeIsEqual(this.f, ejxVar.f) && nullSafeIsEqual(this.g, ejxVar.g)
                && nullSafeIsEqual(this.h, ejxVar.h);
    }

    public final int hashCode() {
        String str = this.b;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.c;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Double d = this.d;
        int iHashCode3 = (iHashCode2 + (d == null ? 0 : d.hashCode())) * 31;
        Integer num = this.e;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        List list = this.f;
        int iHashCode5 = (iHashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        List list2 = this.g;
        int iHashCode6 = (iHashCode5 + (list2 == null ? 0 : list2.hashCode())) * 31;
        Double d2 = this.h;
        return iHashCode6 + (d2 != null ? d2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("zt1Proto(rich_text_json=" /* "zt1Proto(rich_text_json=" /* "zt1Proto(rich_text_json=" /* "zt1Proto(rich_text_json=" /* cnb.z(-347913825811242L)   */);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.b, -347823631498026L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.c, -349339754953514L);
        sb.append(this.d);
        sb.append(", from_rich_publisher=" /* ", from_rich_publisher=" /* ", from_rich_publisher=" /* ", from_rich_publisher=" /* cnb.z(-349301100247850L)   */);
        bjs.w(sb, this.e, -349185136130858L);
        yg.v(sb, this.f, -349601747958570L);
        yg.v(sb, this.g, -349481488874282L);
        sb.append(this.h);
        sb.append(')');
        return sb.toString();
    }
}
