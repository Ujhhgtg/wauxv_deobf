package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ecy {
    public static final ecx Companion = new ecx();
    public final Boolean a;
    public final String b;

    public /* synthetic */ ecy(int i, Boolean bool, String str) {
        if (3 != (i & 3)) {
            bht.ah(i, 3, ecw.b.getDescriptor());
            throw null;
        }
        this.a = bool;
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ecy)) {
            return false;
        }
        ecy ecyVar = (ecy) obj;
        return nullSafeIsEqual(this.a, ecyVar.a) && nullSafeIsEqual(this.b, ecyVar.b);
    }

    public final int hashCode() {
        Boolean bool = this.a;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        String str = this.b;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("p11Proto(need_replace_nickname=" /* cnb.z(-250065880873770L) */);
        dts.g(sb, this.a, -249928441920298L);
        return concat(sb, this.b, ')');
    }
}
