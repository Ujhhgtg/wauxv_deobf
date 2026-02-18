package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class edh {
    public static final edg Companion = new edg();
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;

    public /* synthetic */ edh(int i, String str, String str2, String str3, String str4, String str5, String str6,
            String str7, String str8, String str9) {
        if (511 != (i & 511)) {
            bht.ah(i, 511, edf.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
        this.h = str8;
        this.i = str9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof edh)) {
            return false;
        }
        edh edhVar = (edh) obj;
        return nullSafeIsEqual(this.a, edhVar.a) && nullSafeIsEqual(this.b, edhVar.b)
                && nullSafeIsEqual(this.c, edhVar.c) && nullSafeIsEqual(this.d, edhVar.d)
                && nullSafeIsEqual(this.e, edhVar.e) && nullSafeIsEqual(this.f, edhVar.f)
                && nullSafeIsEqual(this.g, edhVar.g)
                && nullSafeIsEqual(this.h, edhVar.h) && nullSafeIsEqual(this.i, edhVar.i);
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
        String str6 = this.f;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.g;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.h;
        int iHashCode8 = (iHashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.i;
        return iHashCode8 + (str9 != null ? str9.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("pk3Proto(adaptive_pattern_wording=" /* cnb.z(-251504694917930L) */);
        yg.u(sb, this.a, -251371550931754L);
        yg.u(sb, this.b, -251268471716650L);
        yg.u(sb, this.c, -251655018773290L);
        yg.u(sb, this.d, -251569119427370L);
        yg.u(sb, this.e, -250873334725418L);
        yg.u(sb, this.f, -250701536033578L);
        yg.u(sb, this.g, -251036543482666L);
        yg.u(sb, this.h, -252514012232490L);
        return concat(sb, this.i, ')');
    }
}
