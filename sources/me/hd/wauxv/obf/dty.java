package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dty {
    public static final dtx Companion = new dtx();
    public final Integer a;
    public final Integer b;
    public final String c;
    public final Integer d;
    public final Integer e;
    public final Integer f;
    public final Integer g;
    public final String h;
    public final Integer i;
    public final String j;
    public final Integer k;

    public /* synthetic */ dty(int i, Integer num, Integer num2, String str, Integer num3, Integer num4, Integer num5,
            Integer num6, String str2, Integer num7, String str3, Integer num8) {
        if (2047 != (i & 2047)) {
            ResourcesCompat.ah(i, 2047, dtw.b.getDescriptor());
            throw null;
        }
        this.a = num;
        this.b = num2;
        this.c = str;
        this.d = num3;
        this.e = num4;
        this.f = num5;
        this.g = num6;
        this.h = str2;
        this.i = num7;
        this.j = str3;
        this.k = num8;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dty)) {
            return false;
        }
        dty dtyVar = (dty) obj;
        return nullSafeIsEqual(this.a, dtyVar.a) && nullSafeIsEqual(this.b, dtyVar.b)
                && nullSafeIsEqual(this.c, dtyVar.c) && nullSafeIsEqual(this.d, dtyVar.d)
                && nullSafeIsEqual(this.e, dtyVar.e) && nullSafeIsEqual(this.f, dtyVar.f)
                && nullSafeIsEqual(this.g, dtyVar.g)
                && nullSafeIsEqual(this.h, dtyVar.h) && nullSafeIsEqual(this.i, dtyVar.i)
                && nullSafeIsEqual(this.j, dtyVar.j)
                && nullSafeIsEqual(this.k, dtyVar.k);
    }

    public final int hashCode() {
        Integer num = this.a;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.b;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.c;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num3 = this.d;
        int iHashCode4 = (iHashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.e;
        int iHashCode5 = (iHashCode4 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.f;
        int iHashCode6 = (iHashCode5 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.g;
        int iHashCode7 = (iHashCode6 + (num6 == null ? 0 : num6.hashCode())) * 31;
        String str2 = this.h;
        int iHashCode8 = (iHashCode7 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num7 = this.i;
        int iHashCode9 = (iHashCode8 + (num7 == null ? 0 : num7.hashCode())) * 31;
        String str3 = this.j;
        int iHashCode10 = (iHashCode9 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num8 = this.k;
        return iHashCode10 + (num8 != null ? num8.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ReadershareProto(itemshowtype=" /* "ReadershareProto(itemshowtype=" /* "ReadershareProto(itemshowtype=" /* cnb.z(-273039660940074L)  */);
        bjs.w(sb, this.a, -274538604526378L);
        bjs.w(sb, this.b, -274530014591786L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.c, -274435525311274L);
        bjs.w(sb, this.d, -274414050474794L);
        bjs.w(sb, this.e, -274388280671018L);
        bjs.w(sb, this.f, -274358215899946L);
        bjs.w(sb, this.g, -274822072367914L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.h, -274792007596842L);
        bjs.w(sb, this.i, -274774827727658L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.j, -274736173021994L);
        return concat(sb, this.k, ')');
    }
}
