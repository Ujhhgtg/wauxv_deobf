package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ehp {
    public static final eho Companion = new eho();
    public final String a;
    public final String b;

    public /* synthetic */ ehp(int i, String str, String str2) {
        if (3 != (i & 3)) {
            bht.ah(i, 3, ehn.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ehp)) {
            return false;
        }
        ehp ehpVar = (ehp) obj;
        return bzo.f(this.a, ehpVar.a) && bzo.f(this.b, ehpVar.b);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(cnb.z(-304440166841130L));
        yg.u(sb, this.a, -303714317368106L);
        return bjs.q(sb, this.b, ')');
    }
}
