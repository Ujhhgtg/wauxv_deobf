package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class edz {
    public static final edy Companion = new edy();
    public static final IHasGetValue[] a = { null, null, null, null, null, null, ewz.am(btx.a, new dtr(24)), null, null,
            null };
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final Integer g;
    public final List h;
    public final String i;
    public final String j;
    public final String k;

    public /* synthetic */ edz(int i, String str, String str2, String str3, String str4, String str5, Integer num,
            List list, String str6, String str7, String str8) {
        if (1023 != (i & 1023)) {
            bht.ah(i, 1023, edx.b.getDescriptor());
            throw null;
        }
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = num;
        this.h = list;
        this.i = str6;
        this.j = str7;
        this.k = str8;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof edz)) {
            return false;
        }
        edz edzVar = (edz) obj;
        return nullSafeIsEqual(this.b, edzVar.b) && nullSafeIsEqual(this.c, edzVar.c)
                && nullSafeIsEqual(this.d, edzVar.d) && nullSafeIsEqual(this.e, edzVar.e)
                && nullSafeIsEqual(this.f, edzVar.f) && nullSafeIsEqual(this.g, edzVar.g)
                && nullSafeIsEqual(this.h, edzVar.h)
                && nullSafeIsEqual(this.i, edzVar.i) && nullSafeIsEqual(this.j, edzVar.j)
                && nullSafeIsEqual(this.k, edzVar.k);
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
        List list = this.h;
        int iHashCode7 = (iHashCode6 + (list == null ? 0 : list.hashCode())) * 31;
        String str6 = this.i;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.j;
        int iHashCode9 = (iHashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.k;
        return iHashCode9 + (str8 != null ? str8.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("rj3Proto(objectId=" /* cnb.z(-279924493515562L) */);
        yg.u(sb, this.b, -280358285212458L);
        yg.u(sb, this.c, -280341105343274L);
        yg.u(sb, this.d, -280255205997354L);
        yg.u(sb, this.e, -280229436193578L);
        yg.u(sb, this.f, -280195076455210L);
        bjs.w(sb, this.g, -280117767043882L);
        yg.v(sb, this.h, -279546536393514L);
        yg.u(sb, this.i, -279421982341930L);
        yg.u(sb, this.j, -279404802472746L);
        return concat(sb, this.k, ')');
    }
}
