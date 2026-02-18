package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dyu {
    public static final dyt Companion = new dyt();
    public static final btt[] a = {null, null, null, null, null, null, null, null, null, null, ewz.am(btx.a, new dtr(9)), null, null, null, null, null};
    public final dsy b;
    public final Integer c;
    public final Integer d;
    public final Integer e;
    public final Integer f;
    public final ecg g;
    public final String h;
    public final Integer i;
    public final String j;
    public final Boolean k;
    public final List l;
    public final Integer m;
    public final Long n;
    public final Boolean o;
    public final Long p;
    public final dvr q;

    public /* synthetic */ dyu(int i, dsy dsyVar, Integer num, Integer num2, Integer num3, Integer num4, ecg ecgVar, String str, Integer num5, String str2, Boolean bool, List list, Integer num6, Long l, Boolean bool2, Long l2, dvr dvrVar) {
        if (65535 != (i & 65535)) {
            bht.ah(i, 65535, dys.b.getDescriptor());
            throw null;
        }
        this.b = dsyVar;
        this.c = num;
        this.d = num2;
        this.e = num3;
        this.f = num4;
        this.g = ecgVar;
        this.h = str;
        this.i = num5;
        this.j = str2;
        this.k = bool;
        this.l = list;
        this.m = num6;
        this.n = l;
        this.o = bool2;
        this.p = l2;
        this.q = dvrVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dyu)) {
            return false;
        }
        dyu dyuVar = (dyu) obj;
        return bzo.f(this.b, dyuVar.b) && bzo.f(this.c, dyuVar.c) && bzo.f(this.d, dyuVar.d) && bzo.f(this.e, dyuVar.e) && bzo.f(this.f, dyuVar.f) && bzo.f(this.g, dyuVar.g) && bzo.f(this.h, dyuVar.h) && bzo.f(this.i, dyuVar.i) && bzo.f(this.j, dyuVar.j) && bzo.f(this.k, dyuVar.k) && bzo.f(this.l, dyuVar.l) && bzo.f(this.m, dyuVar.m) && bzo.f(this.n, dyuVar.n) && bzo.f(this.o, dyuVar.o) && bzo.f(this.p, dyuVar.p) && bzo.f(this.q, dyuVar.q);
    }

    public final int hashCode() {
        dsy dsyVar = this.b;
        int iHashCode = (dsyVar == null ? 0 : dsyVar.hashCode()) * 31;
        Integer num = this.c;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.d;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.e;
        int iHashCode4 = (iHashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.f;
        int iHashCode5 = (iHashCode4 + (num4 == null ? 0 : num4.hashCode())) * 31;
        ecg ecgVar = this.g;
        int iHashCode6 = (iHashCode5 + (ecgVar == null ? 0 : ecgVar.hashCode())) * 31;
        String str = this.h;
        int iHashCode7 = (iHashCode6 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num5 = this.i;
        int iHashCode8 = (iHashCode7 + (num5 == null ? 0 : num5.hashCode())) * 31;
        String str2 = this.j;
        int iHashCode9 = (iHashCode8 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.k;
        int iHashCode10 = (iHashCode9 + (bool == null ? 0 : bool.hashCode())) * 31;
        List list = this.l;
        int iHashCode11 = (iHashCode10 + (list == null ? 0 : list.hashCode())) * 31;
        Integer num6 = this.m;
        int iHashCode12 = (iHashCode11 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Long l = this.n;
        int iHashCode13 = (iHashCode12 + (l == null ? 0 : l.hashCode())) * 31;
        Boolean bool2 = this.o;
        int iHashCode14 = (iHashCode13 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Long l2 = this.p;
        int iHashCode15 = (iHashCode14 + (l2 == null ? 0 : l2.hashCode())) * 31;
        dvr dvrVar = this.q;
        return iHashCode15 + (dvrVar != null ? dvrVar.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("j71Proto(contact=" /* cnb.z(-197761769143082L) */);
        sb.append(this.b);
        sb.append(", enableComment=" /* cnb.z(-197701639600938L) */);
        bjs.w(sb, this.c, -197027329735466L);
        bjs.w(sb, this.d, -196967200193322L);
        bjs.w(sb, this.e, -196859826010922L);
        bjs.w(sb, this.f, -197302207642410L);
        sb.append(this.g);
        sb.append(", display_nickname=" /* cnb.z(-197293617707818L) */);
        yg.u(sb, this.h, -197173358623530L);
        bjs.w(sb, this.i, -197100344179498L);
        yg.u(sb, this.j, -194304320469802L);
        dts.g(sb, this.k, -194201241254698L);
        yg.v(sb, this.l, -194119636876074L);
        bjs.w(sb, this.m, -194570608442154L);
        dkz.ad(sb, this.n, -194484709096234L);
        dts.g(sb, this.o, -194420284586794L);
        dkz.ad(sb, this.p, -194373039946538L);
        sb.append(this.q);
        sb.append(')');
        return sb.toString();
    }
}
