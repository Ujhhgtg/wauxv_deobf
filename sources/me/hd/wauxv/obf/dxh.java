package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dxh {
    public static final dxg Companion = new dxg();
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final Integer e;
    public final Float f;
    public final Integer g;
    public final Boolean h;
    public final Boolean i;
    public final String j;
    public final Integer k;

    public /* synthetic */ dxh(int i, String str, String str2, String str3, String str4, Integer num, Float f,
            Integer num2, Boolean bool, Boolean bool2, String str5, Integer num3) {
        if (2047 != (i & 2047)) {
            bht.ah(i, 2047, dxf.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = num;
        this.f = f;
        this.g = num2;
        this.h = bool;
        this.i = bool2;
        this.j = str5;
        this.k = num3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dxh)) {
            return false;
        }
        dxh dxhVar = (dxh) obj;
        return nullSafeIsEqual(this.a, dxhVar.a) && nullSafeIsEqual(this.b, dxhVar.b)
                && nullSafeIsEqual(this.c, dxhVar.c) && nullSafeIsEqual(this.d, dxhVar.d)
                && nullSafeIsEqual(this.e, dxhVar.e) && nullSafeIsEqual(this.f, dxhVar.f)
                && nullSafeIsEqual(this.g, dxhVar.g)
                && nullSafeIsEqual(this.h, dxhVar.h) && nullSafeIsEqual(this.i, dxhVar.i)
                && nullSafeIsEqual(this.j, dxhVar.j)
                && nullSafeIsEqual(this.k, dxhVar.k);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.c;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.d;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.e;
        int iHashCode5 = (iHashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        Float f = this.f;
        int iHashCode6 = (iHashCode5 + (f == null ? 0 : f.hashCode())) * 31;
        Integer num2 = this.g;
        int iHashCode7 = (iHashCode6 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Boolean bool = this.h;
        int iHashCode8 = (iHashCode7 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.i;
        int iHashCode9 = (iHashCode8 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str5 = this.j;
        int iHashCode10 = (iHashCode9 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num3 = this.k;
        return iHashCode10 + (num3 != null ? num3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("f93Proto(app_id=" /* "f93Proto(app_id=" /* "f93Proto(app_id=" /* cnb.z(-192586333551402L)  */);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.a, -192513319107370L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.b, -192478959369002L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.c, -192938520869674L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.d, -192925635967786L);
        bjs.w(sb, this.e, -192796786948906L);
        bjs.v(sb, this.f, -192732362439466L);
        bjs.w(sb, this.g, -192710887602986L);
        dts.g(sb, this.h, -189901978991402L);
        dts.g(sb, this.i, -189738770234154L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.j, -189670050757418L);
        return concat(sb, this.k, ')');
    }
}
