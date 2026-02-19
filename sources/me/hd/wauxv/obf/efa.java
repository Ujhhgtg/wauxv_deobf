package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class efa {
    public static final eez Companion = new eez();
    public final String a;
    public final Integer b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final Integer g;
    public final String h;
    public final String i;
    public final Integer j;
    public final Integer k;

    public /* synthetic */ efa(int i, String str, Integer num, String str2, String str3, String str4, String str5,
            Integer num2, String str6, String str7, Integer num3, Integer num4) {
        if (2047 != (i & 2047)) {
            bht.ah(i, 2047, eey.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = num;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = num2;
        this.h = str6;
        this.i = str7;
        this.j = num3;
        this.k = num4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof efa)) {
            return false;
        }
        efa efaVar = (efa) obj;
        return nullSafeIsEqual(this.a, efaVar.a) && nullSafeIsEqual(this.b, efaVar.b)
                && nullSafeIsEqual(this.c, efaVar.c) && nullSafeIsEqual(this.d, efaVar.d)
                && nullSafeIsEqual(this.e, efaVar.e) && nullSafeIsEqual(this.f, efaVar.f)
                && nullSafeIsEqual(this.g, efaVar.g)
                && nullSafeIsEqual(this.h, efaVar.h) && nullSafeIsEqual(this.i, efaVar.i)
                && nullSafeIsEqual(this.j, efaVar.j)
                && nullSafeIsEqual(this.k, efaVar.k);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.b;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.c;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.d;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.e;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num2 = this.g;
        int iHashCode7 = (iHashCode6 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str6 = this.h;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.i;
        int iHashCode9 = (iHashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Integer num3 = this.j;
        int iHashCode10 = (iHashCode9 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.k;
        return iHashCode10 + (num4 != null ? num4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("t10Proto(d=" /* "t10Proto(d=" /* "t10Proto(d=" /* "t10Proto(d=" /* cnb.z(-296069275581226L)   */);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.a, -284438504143658L);
        bjs.w(sb, this.b, -284451389045546L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.c, -284412734339882L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.d, -284425619241770L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.e, -284386964536106L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.f, -284331129961258L);
        bjs.w(sb, this.g, -284361194732330L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.h, -284305360157482L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.i, -284266705451818L);
        bjs.w(sb, this.j, -284279590353706L);
        return concat(sb, this.k, ')');
    }
}
