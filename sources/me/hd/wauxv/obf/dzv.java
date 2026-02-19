package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dzv {
    public static final dzu Companion = new dzu();
    public static final IHasGetValue[] a = { ewz.am(btx.a, new dtr(13)), null, null, null };
    public final List b;
    public final Long c;
    public final Integer d;
    public final Long e;

    public /* synthetic */ dzv(int i, List list, Long l, Integer num, Long l2) {
        if (15 != (i & 15)) {
            ResourcesCompat.ah(i, 15, dzt.b.getDescriptor());
            throw null;
        }
        this.b = list;
        this.c = l;
        this.d = num;
        this.e = l2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dzv)) {
            return false;
        }
        dzv dzvVar = (dzv) obj;
        return nullSafeIsEqual(this.b, dzvVar.b) && nullSafeIsEqual(this.c, dzvVar.c)
                && nullSafeIsEqual(this.d, dzvVar.d) && nullSafeIsEqual(this.e, dzvVar.e);
    }

    public final int hashCode() {
        List list = this.b;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        Long l = this.c;
        int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
        Integer num = this.d;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Long l2 = this.e;
        return iHashCode3 + (l2 != null ? l2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("lh1Proto(members=" /* "lh1Proto(members=" /* "lh1Proto(members=" /* cnb.z(-222105643776810L)  */);
        yg.v(sb, this.b, -222595270048554L);
        StaticHelpers6.ad(sb, this.c, -222539435473706L);
        bjs.w(sb, this.d, -222513665669930L);
        sb.append(this.e);
        sb.append(')');
        return sb.toString();
    }
}
