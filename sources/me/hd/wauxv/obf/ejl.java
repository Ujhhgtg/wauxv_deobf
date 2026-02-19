package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ejl {
    public static final ejk Companion = new ejk();
    public final String a;
    public final String b;

    public /* synthetic */ ejl(int i, String str, String str2) {
        if (3 != (i & 3)) {
            ResourcesCompat.ah(i, 3, ejj.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ejl)) {
            return false;
        }
        ejl ejlVar = (ejl) obj;
        return nullSafeIsEqual(this.a, ejlVar.a) && nullSafeIsEqual(this.b, ejlVar.b);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("zd0Proto(d=" /* "zd0Proto(d=" /* "zd0Proto(d=" /* cnb.z(-344001110604586L)  */);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.a, -343915211258666L);
        return concat(sb, this.b, ')');
    }
}
