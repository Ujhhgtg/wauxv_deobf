package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class edw {
    public static final edv Companion = new edv();
    public final String a;
    public final String b;
    public final Float c;
    public final Float d;
    public final String e;
    public final Integer f;

    public /* synthetic */ edw(int i, String str, String str2, Float f, Float f2, String str3, Integer num) {
        if (63 != (i & 63)) {
            ResourcesCompat.ah(i, 63, edu.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = str2;
        this.c = f;
        this.d = f2;
        this.e = str3;
        this.f = num;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof edw)) {
            return false;
        }
        edw edwVar = (edw) obj;
        return nullSafeIsEqual(this.a, edwVar.a) && nullSafeIsEqual(this.b, edwVar.b)
                && nullSafeIsEqual(this.c, edwVar.c) && nullSafeIsEqual(this.d, edwVar.d)
                && nullSafeIsEqual(this.e, edwVar.e) && nullSafeIsEqual(this.f, edwVar.f);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Float f = this.c;
        int iHashCode3 = (iHashCode2 + (f == null ? 0 : f.hashCode())) * 31;
        Float f2 = this.d;
        int iHashCode4 = (iHashCode3 + (f2 == null ? 0 : f2.hashCode())) * 31;
        String str3 = this.e;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.f;
        return iHashCode5 + (num != null ? num.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("qj3Proto(url=" /* "qj3Proto(url=" /* "qj3Proto(url=" /* "qj3Proto(url=" /* cnb.z(-276389735430954L)   */);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.a, -276312426019626L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.b, -273477747604266L);
        bjs.v(sb, this.c, -273439092898602L);
        bjs.v(sb, this.d, -273413323094826L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.e, -273396143225642L);
        return concat(sb, this.f, ')');
    }
}
