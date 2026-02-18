package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ebc {
    public static final ebb Companion = new ebb();
    public final Integer a;
    public final Long b;
    public final Integer c;
    public final Integer d;
    public final String e;
    public final ebu f;
    public final ecp g;
    public final ehs h;
    public final ehs i;
    public final String j;
    public final String k;
    public final String l;
    public final Long m;
    public final Long n;

    public /* synthetic */ ebc(int i, Integer num, Long l, Integer num2, Integer num3, String str, ebu ebuVar,
            ecp ecpVar, ehs ehsVar, ehs ehsVar2, String str2, String str3, String str4, Long l2, Long l3) {
        if (16383 != (i & 16383)) {
            bht.ah(i, 16383, eba.b.getDescriptor());
            throw null;
        }
        this.a = num;
        this.b = l;
        this.c = num2;
        this.d = num3;
        this.e = str;
        this.f = ebuVar;
        this.g = ecpVar;
        this.h = ehsVar;
        this.i = ehsVar2;
        this.j = str2;
        this.k = str3;
        this.l = str4;
        this.m = l2;
        this.n = l3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ebc)) {
            return false;
        }
        ebc ebcVar = (ebc) obj;
        return nullSafeIsEqual(this.a, ebcVar.a) && nullSafeIsEqual(this.b, ebcVar.b)
                && nullSafeIsEqual(this.c, ebcVar.c) && nullSafeIsEqual(this.d, ebcVar.d)
                && nullSafeIsEqual(this.e, ebcVar.e) && nullSafeIsEqual(this.f, ebcVar.f)
                && nullSafeIsEqual(this.g, ebcVar.g) && nullSafeIsEqual(this.h, ebcVar.h)
                && nullSafeIsEqual(this.i, ebcVar.i) && nullSafeIsEqual(this.j, ebcVar.j)
                && nullSafeIsEqual(this.k, ebcVar.k) && nullSafeIsEqual(this.l, ebcVar.l)
                && nullSafeIsEqual(this.m, ebcVar.m) && nullSafeIsEqual(this.n, ebcVar.n);
    }

    public final int hashCode() {
        Integer num = this.a;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Long l = this.b;
        int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
        Integer num2 = this.c;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.d;
        int iHashCode4 = (iHashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str = this.e;
        int iHashCode5 = (iHashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        ebu ebuVar = this.f;
        int iHashCode6 = (iHashCode5 + (ebuVar == null ? 0 : ebuVar.hashCode())) * 31;
        ecp ecpVar = this.g;
        int iHashCode7 = (iHashCode6 + (ecpVar == null ? 0 : ecpVar.hashCode())) * 31;
        ehs ehsVar = this.h;
        int iHashCode8 = (iHashCode7 + (ehsVar == null ? 0 : ehsVar.hashCode())) * 31;
        ehs ehsVar2 = this.i;
        int iHashCode9 = (iHashCode8 + (ehsVar2 == null ? 0 : ehsVar2.hashCode())) * 31;
        String str2 = this.j;
        int iHashCode10 = (iHashCode9 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.k;
        int iHashCode11 = (iHashCode10 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.l;
        int iHashCode12 = (iHashCode11 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Long l2 = this.m;
        int iHashCode13 = (iHashCode12 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.n;
        return iHashCode13 + (l3 != null ? l3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("mk1Proto(support_screen_rotate=" /* cnb.z(-237112259509034L) */);
        bjs.w(sb, this.a, -236974820555562L);
        dkz.ad(sb, this.b, -237438677023530L);
        bjs.w(sb, this.c, -237382842448682L);
        bjs.w(sb, this.d, -237279763233578L);
        yg.u(sb, this.e, -236622633237290L);
        sb.append(this.f);
        sb.append(", replay_transition_preload_info=" /* cnb.z(-236485194283818L) */);
        sb.append(this.g);
        sb.append(", anchor_specified=" /* cnb.z(-236906101078826L) */);
        sb.append(this.h);
        sb.append(", automatic_detection=" /* cnb.z(-236785841994538L) */);
        sb.append(this.i);
        sb.append(", replay_guide_page_url=" /* cnb.z(-236687057746730L) */);
        yg.u(sb, this.j, -233830904494890L);
        yg.u(sb, this.k, -233766479985450L);
        yg.u(sb, this.l, -233693465541418L);
        dkz.ad(sb, this.m, -234140142140202L);
        sb.append(this.n);
        sb.append(')');
        return sb.toString();
    }
}
