package me.hd.wauxv.obf;

import com.android.dx.io.Opcodes;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class egf {
    public static final ege Companion = new ege();
    public final Boolean a;
    public final Integer b;
    public final Float c;
    public final String d;
    public final Boolean e;
    public final String f;
    public final String g;
    public final String h;

    public /* synthetic */ egf(int i, Boolean bool, Integer num, Float f, String str, Boolean bool2, String str2, String str3, String str4) {
        if (255 != (i & Opcodes.CONST_METHOD_TYPE)) {
            bht.ah(i, Opcodes.CONST_METHOD_TYPE, egd.b.getDescriptor());
            throw null;
        }
        this.a = bool;
        this.b = num;
        this.c = f;
        this.d = str;
        this.e = bool2;
        this.f = str2;
        this.g = str3;
        this.h = str4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof egf)) {
            return false;
        }
        egf egfVar = (egf) obj;
        return bzo.f(this.a, egfVar.a) && bzo.f(this.b, egfVar.b) && bzo.f(this.c, egfVar.c) && bzo.f(this.d, egfVar.d) && bzo.f(this.e, egfVar.e) && bzo.f(this.f, egfVar.f) && bzo.f(this.g, egfVar.g) && bzo.f(this.h, egfVar.h);
    }

    public final int hashCode() {
        Boolean bool = this.a;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Integer num = this.b;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Float f = this.c;
        int iHashCode3 = (iHashCode2 + (f == null ? 0 : f.hashCode())) * 31;
        String str = this.d;
        int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool2 = this.e;
        int iHashCode5 = (iHashCode4 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str2 = this.f;
        int iHashCode6 = (iHashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.g;
        int iHashCode7 = (iHashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.h;
        return iHashCode7 + (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("v40Proto(support_custom_text=" /* cnb.z(-308997127142186L) */);
        dts.g(sb, this.a, -309400854068010L);
        bjs.w(sb, this.b, -309340724525866L);
        bjs.v(sb, this.c, -309302069820202L);
        yg.u(sb, this.d, -315284959263530L);
        dts.g(sb, this.e, -315181880048426L);
        yg.u(sb, this.f, -315078800833322L);
        yg.u(sb, this.g, -315044441094954L);
        return bjs.q(sb, this.h, ')');
    }
}
