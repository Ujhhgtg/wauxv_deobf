package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dsf {
    public static final dse Companion = new dse();
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final Integer f;
    public final Integer g;

    public /* synthetic */ dsf(int i, String str, String str2, String str3, String str4, String str5, Integer num,
            Integer num2) {
        if (127 != (i & 127)) {
            ResourcesCompat.ah(i, 127, dsd.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = num;
        this.g = num2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dsf)) {
            return false;
        }
        dsf dsfVar = (dsf) obj;
        return nullSafeIsEqual(this.a, dsfVar.a) && nullSafeIsEqual(this.b, dsfVar.b)
                && nullSafeIsEqual(this.c, dsfVar.c) && nullSafeIsEqual(this.d, dsfVar.d)
                && nullSafeIsEqual(this.e, dsfVar.e) && nullSafeIsEqual(this.f, dsfVar.f)
                && nullSafeIsEqual(this.g, dsfVar.g);
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
        String str5 = this.e;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num = this.f;
        int iHashCode6 = (iHashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.g;
        return iHashCode6 + (num2 != null ? num2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AppInfoProto(id=" /* "AppInfoProto(id=" /* "AppInfoProto(id=" /* "AppInfoProto(id=" /* cnb.z(-149147034319658L)   */);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.a, -149074019875626L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.b, -148992415497002L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.c, -149512106539818L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.d, -149434797128490L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.e, -149421912226602L);
        bjs.w(sb, this.f, -149331717913386L);
        return concat(sb, this.g, ')');
    }
}
