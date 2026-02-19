package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dyc {
    public static final dyb Companion = new dyb();
    public final Boolean a;
    public final Long b;
    public final Long c;
    public final String d;
    public final String e;
    public final dvf f;
    public final String g;

    public /* synthetic */ dyc(int i, Boolean bool, Long l, Long l2, String str, String str2, dvf dvfVar, String str3) {
        if (127 != (i & 127)) {
            ResourcesCompat.ah(i, 127, dya.b.getDescriptor());
            throw null;
        }
        this.a = bool;
        this.b = l;
        this.c = l2;
        this.d = str;
        this.e = str2;
        this.f = dvfVar;
        this.g = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dyc)) {
            return false;
        }
        dyc dycVar = (dyc) obj;
        return nullSafeIsEqual(this.a, dycVar.a) && nullSafeIsEqual(this.b, dycVar.b)
                && nullSafeIsEqual(this.c, dycVar.c) && nullSafeIsEqual(this.d, dycVar.d)
                && nullSafeIsEqual(this.e, dycVar.e) && nullSafeIsEqual(this.f, dycVar.f)
                && nullSafeIsEqual(this.g, dycVar.g);
    }

    public final int hashCode() {
        Boolean bool = this.a;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Long l = this.b;
        int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.c;
        int iHashCode3 = (iHashCode2 + (l2 == null ? 0 : l2.hashCode())) * 31;
        String str = this.d;
        int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.e;
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        dvf dvfVar = this.f;
        int iHashCode6 = (iHashCode5 + (dvfVar == null ? 0 : dvfVar.hashCode())) * 31;
        String str3 = this.g;
        return iHashCode6 + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("gl1Proto(enable_flag=" /* "gl1Proto(enable_flag=" /* "gl1Proto(enable_flag=" /* cnb.z(-202864190290730L)  */);
        dts.g(sb, this.a, -203370996431658L);
        StaticHelpers6.ad(sb, this.b, -203259327281962L);
        StaticHelpers6.ad(sb, this.c, -203143363164970L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.d, -202524887874346L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.e, -202460463364906L);
        sb.append(this.f);
        sb.append(", wish_list_id=" /* ", wish_list_id=" /* ", wish_list_id=" /* cnb.z(-202387448920874L)  */);
        return concat(sb, this.g, ')');
    }
}
