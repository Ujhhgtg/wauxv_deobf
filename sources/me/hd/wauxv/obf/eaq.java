package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eaq {
    public static final eap Companion = new eap();
    public final Integer a;
    public final Integer b;
    public final Integer c;
    public final Integer d;
    public final Integer e;
    public final Integer f;
    public final Integer g;
    public final Integer h;
    public final Integer i;
    public final Integer j;
    public final Integer k;
    public final Integer l;
    public final Integer m;
    public final Integer n;
    public final Integer o;
    public final Integer p;
    public final ebf q;
    public final ebf r;
    public final ebf s;
    public final Integer t;
    public final ebf u;

    public /* synthetic */ eaq(int i, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, Integer num13, Integer num14, Integer num15, Integer num16, ebf ebfVar, ebf ebfVar2, ebf ebfVar3, Integer num17, ebf ebfVar4) {
        if (2097151 != (i & 2097151)) {
            bht.ah(i, 2097151, eao.b.getDescriptor());
            throw null;
        }
        this.a = num;
        this.b = num2;
        this.c = num3;
        this.d = num4;
        this.e = num5;
        this.f = num6;
        this.g = num7;
        this.h = num8;
        this.i = num9;
        this.j = num10;
        this.k = num11;
        this.l = num12;
        this.m = num13;
        this.n = num14;
        this.o = num15;
        this.p = num16;
        this.q = ebfVar;
        this.r = ebfVar2;
        this.s = ebfVar3;
        this.t = num17;
        this.u = ebfVar4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof eaq)) {
            return false;
        }
        eaq eaqVar = (eaq) obj;
        return bzo.f(this.a, eaqVar.a) && bzo.f(this.b, eaqVar.b) && bzo.f(this.c, eaqVar.c) && bzo.f(this.d, eaqVar.d) && bzo.f(this.e, eaqVar.e) && bzo.f(this.f, eaqVar.f) && bzo.f(this.g, eaqVar.g) && bzo.f(this.h, eaqVar.h) && bzo.f(this.i, eaqVar.i) && bzo.f(this.j, eaqVar.j) && bzo.f(this.k, eaqVar.k) && bzo.f(this.l, eaqVar.l) && bzo.f(this.m, eaqVar.m) && bzo.f(this.n, eaqVar.n) && bzo.f(this.o, eaqVar.o) && bzo.f(this.p, eaqVar.p) && bzo.f(this.q, eaqVar.q) && bzo.f(this.r, eaqVar.r) && bzo.f(this.s, eaqVar.s) && bzo.f(this.t, eaqVar.t) && bzo.f(this.u, eaqVar.u);
    }

    public final int hashCode() {
        Integer num = this.a;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.b;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.c;
        int iHashCode3 = (iHashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.d;
        int iHashCode4 = (iHashCode3 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.e;
        int iHashCode5 = (iHashCode4 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.f;
        int iHashCode6 = (iHashCode5 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Integer num7 = this.g;
        int iHashCode7 = (iHashCode6 + (num7 == null ? 0 : num7.hashCode())) * 31;
        Integer num8 = this.h;
        int iHashCode8 = (iHashCode7 + (num8 == null ? 0 : num8.hashCode())) * 31;
        Integer num9 = this.i;
        int iHashCode9 = (iHashCode8 + (num9 == null ? 0 : num9.hashCode())) * 31;
        Integer num10 = this.j;
        int iHashCode10 = (iHashCode9 + (num10 == null ? 0 : num10.hashCode())) * 31;
        Integer num11 = this.k;
        int iHashCode11 = (iHashCode10 + (num11 == null ? 0 : num11.hashCode())) * 31;
        Integer num12 = this.l;
        int iHashCode12 = (iHashCode11 + (num12 == null ? 0 : num12.hashCode())) * 31;
        Integer num13 = this.m;
        int iHashCode13 = (iHashCode12 + (num13 == null ? 0 : num13.hashCode())) * 31;
        Integer num14 = this.n;
        int iHashCode14 = (iHashCode13 + (num14 == null ? 0 : num14.hashCode())) * 31;
        Integer num15 = this.o;
        int iHashCode15 = (iHashCode14 + (num15 == null ? 0 : num15.hashCode())) * 31;
        Integer num16 = this.p;
        int iHashCode16 = (iHashCode15 + (num16 == null ? 0 : num16.hashCode())) * 31;
        ebf ebfVar = this.q;
        int iHashCode17 = (iHashCode16 + (ebfVar == null ? 0 : ebfVar.hashCode())) * 31;
        ebf ebfVar2 = this.r;
        int iHashCode18 = (iHashCode17 + (ebfVar2 == null ? 0 : ebfVar2.hashCode())) * 31;
        ebf ebfVar3 = this.s;
        int iHashCode19 = (iHashCode18 + (ebfVar3 == null ? 0 : ebfVar3.hashCode())) * 31;
        Integer num17 = this.t;
        int iHashCode20 = (iHashCode19 + (num17 == null ? 0 : num17.hashCode())) * 31;
        ebf ebfVar4 = this.u;
        return iHashCode20 + (ebfVar4 != null ? ebfVar4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(cnb.z(-213236536310570L));
        bjs.w(sb, this.a, -213150636964650L);
        bjs.w(sb, this.b, -213163521866538L);
        bjs.w(sb, this.c, -213124867160874L);
        bjs.w(sb, this.d, -213069032586026L);
        bjs.w(sb, this.e, -213099097357098L);
        bjs.w(sb, this.f, -213043262782250L);
        bjs.w(sb, this.g, -212454852262698L);
        bjs.w(sb, this.h, -212467737164586L);
        bjs.w(sb, this.i, -212429082458922L);
        bjs.w(sb, this.j, -212441967360810L);
        bjs.w(sb, this.k, -212403312655146L);
        bjs.w(sb, this.l, -212347478080298L);
        bjs.w(sb, this.m, -212377542851370L);
        bjs.w(sb, this.n, -212321708276522L);
        bjs.w(sb, this.o, -212283053570858L);
        bjs.w(sb, this.p, -212295938472746L);
        sb.append(this.q);
        sb.append(cnb.z(-212257283767082L));
        sb.append(this.r);
        sb.append(cnb.z(-212270168668970L));
        sb.append(this.s);
        sb.append(cnb.z(-212231513963306L));
        bjs.w(sb, this.t, -212725435202346L);
        sb.append(this.u);
        sb.append(')');
        return sb.toString();
    }
}
