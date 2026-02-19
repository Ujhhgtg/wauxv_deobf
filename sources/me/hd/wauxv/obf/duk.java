package me.hd.wauxv.obf;

import com.android.dx.io.Opcodes;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class duk {
    public static final duj Companion = new duj();
    public final String a;
    public final Integer b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;

    public /* synthetic */ duk(int i, String str, Integer num, String str2, String str3, String str4, String str5,
            String str6, String str7) {
        if (255 != (i & Opcodes.CONST_METHOD_TYPE)) {
            ResourcesCompat.ah(i, Opcodes.CONST_METHOD_TYPE, dui.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = num;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = str6;
        this.h = str7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof duk)) {
            return false;
        }
        duk dukVar = (duk) obj;
        return nullSafeIsEqual(this.a, dukVar.a) && nullSafeIsEqual(this.b, dukVar.b)
                && nullSafeIsEqual(this.c, dukVar.c) && nullSafeIsEqual(this.d, dukVar.d)
                && nullSafeIsEqual(this.e, dukVar.e) && nullSafeIsEqual(this.f, dukVar.f)
                && nullSafeIsEqual(this.g, dukVar.g)
                && nullSafeIsEqual(this.h, dukVar.h);
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
        String str6 = this.g;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.h;
        return iHashCode7 + (str7 != null ? str7.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StreamvideoProto(streamvideourl=" /* "StreamvideoProto(streamvideourl=" /* "StreamvideoProto(streamvideourl=" /* cnb.z(-299041392950058L)  */);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.a, -298899659029290L);
        bjs.w(sb, this.b, -298796579814186L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.c, -298203874327338L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.d, -298096500144938L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.e, -297976241060650L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.f, -298478752234282L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.g, -298379967986474L);
        return concat(sb, this.h, ')');
    }
}
