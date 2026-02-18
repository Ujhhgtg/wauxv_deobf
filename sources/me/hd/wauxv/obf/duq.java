package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class duq {
    public static final dup Companion = new dup();
    public final String a;
    public final String b;
    public final String c;
    public final Long d;
    public final Long e;

    public /* synthetic */ duq(int i, String str, String str2, String str3, Long l, Long l2) {
        if (31 != (i & 31)) {
            bht.ah(i, 31, duo.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = l;
        this.e = l2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof duq)) {
            return false;
        }
        duq duqVar = (duq) obj;
        return nullSafeIsEqual(this.a, duqVar.a) && nullSafeIsEqual(this.b, duqVar.b)
                && nullSafeIsEqual(this.c, duqVar.c) && nullSafeIsEqual(this.d, duqVar.d)
                && nullSafeIsEqual(this.e, duqVar.e);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.c;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Long l = this.d;
        int iHashCode4 = (iHashCode3 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.e;
        return iHashCode4 + (l2 != null ? l2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VideoTemplateProto(type=" /* cnb.z(-301571128687402L) */);
        yg.u(sb, this.a, -303061482339114L);
        yg.u(sb, this.b, -303052892404522L);
        yg.u(sb, this.c, -302954108156714L);
        dkz.ad(sb, this.d, -303400784755498L);
        sb.append(this.e);
        sb.append(')');
        return sb.toString();
    }
}
