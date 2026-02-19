package me.hd.wauxv.obf;

import com.android.dx.io.Opcodes;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dvo {
    public static final dvn Companion = new dvn();
    public final String a;
    public final Integer b;
    public final String c;
    public final String d;
    public final ehg e;
    public final String f;
    public final dzy g;
    public final String h;

    public /* synthetic */ dvo(int i, String str, Integer num, String str2, String str3, ehg ehgVar, String str4,
            dzy dzyVar, String str5) {
        if (255 != (i & Opcodes.CONST_METHOD_TYPE)) {
            bht.ah(i, Opcodes.CONST_METHOD_TYPE, dvm.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = num;
        this.c = str2;
        this.d = str3;
        this.e = ehgVar;
        this.f = str4;
        this.g = dzyVar;
        this.h = str5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dvo)) {
            return false;
        }
        dvo dvoVar = (dvo) obj;
        return nullSafeIsEqual(this.a, dvoVar.a) && nullSafeIsEqual(this.b, dvoVar.b)
                && nullSafeIsEqual(this.c, dvoVar.c) && nullSafeIsEqual(this.d, dvoVar.d)
                && nullSafeIsEqual(this.e, dvoVar.e) && nullSafeIsEqual(this.f, dvoVar.f)
                && nullSafeIsEqual(this.g, dvoVar.g)
                && nullSafeIsEqual(this.h, dvoVar.h);
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
        ehg ehgVar = this.e;
        int iHashCode5 = (iHashCode4 + (ehgVar == null ? 0 : ehgVar.hashCode())) * 31;
        String str4 = this.f;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        dzy dzyVar = this.g;
        int iHashCode7 = (iHashCode6 + (dzyVar == null ? 0 : dzyVar.hashCode())) * 31;
        String str5 = this.h;
        return iHashCode7 + (str5 != null ? str5.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("b22Proto(topic=" /* "b22Proto(topic=" /* "b22Proto(topic=" /* cnb.z(-167890271599402L)  */);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.a, -167821552122666L);
        bjs.w(sb, this.b, -167800077286186L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.c, -167718472907562L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.d, -167684113169194L);
        sb.append(this.e);
        sb.append(", patMusicId=" /* ", patMusicId=" /* ", patMusicId=" /* cnb.z(-168216689113898L)  */);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.f, -168139379702570L);
        sb.append(this.g);
        sb.append(", feedId=" /* ", feedId=" /* ", feedId=" /* cnb.z(-168100724996906L)  */);
        return concat(sb, this.h, ')');
    }
}
