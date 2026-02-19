package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dwj {
    public static final dwi Companion = new dwi();
    public final String a;
    public final String b;

    public /* synthetic */ dwj(int i, String str, String str2) {
        if (3 != (i & 3)) {
            bht.ah(i, 3, dwh.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dwj)) {
            return false;
        }
        dwj dwjVar = (dwj) obj;
        return nullSafeIsEqual(this.a, dwjVar.a) && nullSafeIsEqual(this.b, dwjVar.b);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("cq4Proto(pag_url=" /* "cq4Proto(pag_url=" /* "cq4Proto(pag_url=" /* cnb.z(-158832185572138L)  */);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.a, -158772056029994L);
        return concat(sb, this.b, ')');
    }
}
