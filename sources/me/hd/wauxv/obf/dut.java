package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dut {
    public static final dus Companion = new dus();
    public final String a;
    public final String b;
    public final Integer c;
    public final Integer d;
    public final String e;
    public final Integer f;
    public final String g;
    public final Integer h;
    public final String i;

    public /* synthetic */ dut(int i, String str, String str2, Integer num, Integer num2, String str3, Integer num3, String str4, Integer num4, String str5) {
        if (511 != (i & 511)) {
            bht.ah(i, 511, dur.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = str2;
        this.c = num;
        this.d = num2;
        this.e = str3;
        this.f = num3;
        this.g = str4;
        this.h = num4;
        this.i = str5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dut)) {
            return false;
        }
        dut dutVar = (dut) obj;
        return bzo.f(this.a, dutVar.a) && bzo.f(this.b, dutVar.b) && bzo.f(this.c, dutVar.c) && bzo.f(this.d, dutVar.d) && bzo.f(this.e, dutVar.e) && bzo.f(this.f, dutVar.f) && bzo.f(this.g, dutVar.g) && bzo.f(this.h, dutVar.h) && bzo.f(this.i, dutVar.i);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.c;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.d;
        int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str3 = this.e;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num3 = this.f;
        int iHashCode6 = (iHashCode5 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str4 = this.g;
        int iHashCode7 = (iHashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num4 = this.h;
        int iHashCode8 = (iHashCode7 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str5 = this.i;
        return iHashCode8 + (str5 != null ? str5.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WeappInfoProto(appUserName=" /* cnb.z(-328569293110058L) */);
        yg.u(sb, this.a, -327864918473514L);
        yg.u(sb, this.b, -327847738604330L);
        bjs.w(sb, this.c, -327766134225706L);
        bjs.w(sb, this.d, -327744659389226L);
        yg.u(sb, this.e, -327688824814378L);
        bjs.w(sb, this.f, -328144091347754L);
        yg.u(sb, this.g, -328092551740202L);
        bjs.w(sb, this.h, -328062486969130L);
        return bjs.q(sb, this.i, ')');
    }
}
