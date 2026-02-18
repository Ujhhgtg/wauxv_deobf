package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dtk {
    public static final dtj Companion = new dtj();
    public final String a;
    public final String b;
    public final Integer c;
    public final Integer d;
    public final String e;
    public final Integer f;

    public /* synthetic */ dtk(int i, Integer num, Integer num2, Integer num3, String str, String str2, String str3) {
        if (63 != (i & 63)) {
            bht.ah(i, 63, dti.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = str2;
        this.c = num;
        this.d = num2;
        this.e = str3;
        this.f = num3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dtk)) {
            return false;
        }
        dtk dtkVar = (dtk) obj;
        return nullSafeIsEqual(this.a, dtkVar.a) && nullSafeIsEqual(this.b, dtkVar.b)
                && nullSafeIsEqual(this.c, dtkVar.c) && nullSafeIsEqual(this.d, dtkVar.d)
                && nullSafeIsEqual(this.e, dtkVar.e) && nullSafeIsEqual(this.f, dtkVar.f);
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
        return iHashCode5 + (num3 != null ? num3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GameShareCardObjectProto(sharedata=" /* cnb.z(-182158152956714L) */);
        yg.u(sb, this.a, -182037893872426L);
        yg.u(sb, this.b, -182506045307690L);
        bjs.w(sb, this.c, -182424440929066L);
        bjs.w(sb, this.d, -182407261059882L);
        yg.u(sb, this.e, -182347131517738L);
        return concat(sb, this.f, ')');
    }
}
