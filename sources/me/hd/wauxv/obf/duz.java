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

    public /* synthetic */ duz(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        if (255 != (i & Opcodes.CONST_METHOD_TYPE)) {
            bht.ah(i, Opcodes.CONST_METHOD_TYPE, dux.b.getDescriptor());
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
        return bzo.f(this.a, duzVar.a) && bzo.f(this.b, duzVar.b) && bzo.f(this.c, duzVar.c) && bzo.f(this.d, duzVar.d) && bzo.f(this.e, duzVar.e) && bzo.f(this.f, duzVar.f) && bzo.f(this.g, duzVar.g) && bzo.f(this.h, duzVar.h);
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
        sb.append(cnb.z(-155941672581930L));
        yg.u(sb, this.a, -155284542585642L);
        yg.u(sb, this.b, -155237297945386L);
        yg.u(sb, this.c, -155138513697578L);
        yg.u(sb, this.d, -155078384155434L);
        yg.u(sb, this.e, -155065499253546L);
        yg.u(sb, this.f, -155516470819626L);
        yg.u(sb, this.g, -155460636244778L);
        return bjs.q(sb, this.h, ')');
    }
}
