package me.hd.wauxv.obf;

import com.android.dx.io.Opcodes;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class duz {
    public static final duy Companion = new duy();
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;

    public /* synthetic */ duz(int i, String str, String str2, String str3, String str4, String str5, String str6,
            String str7, String str8) {
        if (255 != (i & Opcodes.CONST_METHOD_TYPE)) {
            ResourcesCompat.ah(i, Opcodes.CONST_METHOD_TYPE, dux.b.getDescriptor());
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
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof duz)) {
            return false;
        }
        duz duzVar = (duz) obj;
        return nullSafeIsEqual(this.a, duzVar.a) && nullSafeIsEqual(this.b, duzVar.b)
                && nullSafeIsEqual(this.c, duzVar.c) && nullSafeIsEqual(this.d, duzVar.d)
                && nullSafeIsEqual(this.e, duzVar.e) && nullSafeIsEqual(this.f, duzVar.f)
                && nullSafeIsEqual(this.g, duzVar.g)
                && nullSafeIsEqual(this.h, duzVar.h);
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
        return iHashCode7 + (str8 != null ? str8.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("a22Proto(latitudeString=" /* "a22Proto(latitudeString=" /* "a22Proto(latitudeString=" /* "a22Proto(latitudeString=" /* cnb.z(-155941672581930L)   */);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.a, -155284542585642L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.b, -155237297945386L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.c, -155138513697578L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.d, -155078384155434L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.e, -155065499253546L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.f, -155516470819626L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.g, -155460636244778L);
        return concat(sb, this.h, ')');
    }
}
