package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eih {
    public static final eig Companion = new eig();
    public final Integer a;
    public final String b;
    public final String c;
    public final Float d;
    public final Float e;
    public final Integer f;
    public final String g;
    public final String h;
    public final String i;

    public /* synthetic */ eih(int i, Integer num, String str, String str2, Float f, Float f2, Integer num2,
            String str3, String str4, String str5) {
        if (511 != (i & 511)) {
            bht.ah(i, 511, eif.b.getDescriptor());
            throw null;
        }
        this.a = num;
        this.b = str;
        this.c = str2;
        this.d = f;
        this.e = f2;
        this.f = num2;
        this.g = str3;
        this.h = str4;
        this.i = str5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof eih)) {
            return false;
        }
        eih eihVar = (eih) obj;
        return nullSafeIsEqual(this.a, eihVar.a) && nullSafeIsEqual(this.b, eihVar.b)
                && nullSafeIsEqual(this.c, eihVar.c) && nullSafeIsEqual(this.d, eihVar.d)
                && nullSafeIsEqual(this.e, eihVar.e) && nullSafeIsEqual(this.f, eihVar.f)
                && nullSafeIsEqual(this.g, eihVar.g)
                && nullSafeIsEqual(this.h, eihVar.h) && nullSafeIsEqual(this.i, eihVar.i);
    }

    public final int hashCode() {
        Integer num = this.a;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Float f = this.d;
        int iHashCode4 = (iHashCode3 + (f == null ? 0 : f.hashCode())) * 31;
        Float f2 = this.e;
        int iHashCode5 = (iHashCode4 + (f2 == null ? 0 : f2.hashCode())) * 31;
        Integer num2 = this.f;
        int iHashCode6 = (iHashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str3 = this.g;
        int iHashCode7 = (iHashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.h;
        int iHashCode8 = (iHashCode7 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.i;
        return iHashCode8 + (str5 != null ? str5.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("x12Proto(mediaType=" /* "x12Proto(mediaType=" /* "x12Proto(mediaType=" /* cnb.z(-330910050286378L)  */);
        bjs.w(sb, this.a, -330789791202090L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.b, -330811266038570L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.c, -330725366692650L);
        bjs.v(sb, this.d, -330703891856170L);
        bjs.v(sb, this.e, -330128366238506L);
        bjs.w(sb, this.f, -330003812186922L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.g, -329935092710186L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.h, -329879258135338L);
        return concat(sb, this.i, ')');
    }
}
