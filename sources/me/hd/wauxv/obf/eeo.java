package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eeo {
    public static final een Companion = new een();
    public final String a;
    public final String b;
    public final Integer c;

    public /* synthetic */ eeo(int i, Integer num, String str, String str2) {
        if (7 != (i & 7)) {
            bht.ah(i, 7, eem.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = str2;
        this.c = num;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof eeo)) {
            return false;
        }
        eeo eeoVar = (eeo) obj;
        return nullSafeIsEqual(this.a, eeoVar.a) && nullSafeIsEqual(this.b, eeoVar.b)
                && nullSafeIsEqual(this.c, eeoVar.c);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.c;
        return iHashCode2 + (num != null ? num.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("sm0Proto(biz_nickname=" /* "sm0Proto(biz_nickname=" /* "sm0Proto(biz_nickname=" /* "sm0Proto(biz_nickname=" /* cnb.z(-272584394406698L)   */);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.a, -272537149766442L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.b, -272468430289706L);
        return concat(sb, this.c, ')');
    }
}
