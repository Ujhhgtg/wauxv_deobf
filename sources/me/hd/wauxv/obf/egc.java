package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class egc {
    public static final egb Companion = new egb();
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;

    public /* synthetic */ egc(int i, String str, String str2, String str3, String str4, String str5) {
        if (31 != (i & 31)) {
            bht.ah(i, 31, ega.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof egc)) {
            return false;
        }
        egc egcVar = (egc) obj;
        return nullSafeIsEqual(this.a, egcVar.a) && nullSafeIsEqual(this.b, egcVar.b)
                && nullSafeIsEqual(this.c, egcVar.c) && nullSafeIsEqual(this.d, egcVar.d)
                && nullSafeIsEqual(this.e, egcVar.e);
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
        return iHashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("v12Proto(cardId=" /* cnb.z(-307876140677930L) */);
        yg.u(sb, this.a, -308370061916970L);
        yg.u(sb, this.b, -308331407211306L);
        yg.u(sb, this.c, -308245507865386L);
        yg.u(sb, this.d, -308241212898090L);
        return concat(sb, this.e, ')');
    }
}
