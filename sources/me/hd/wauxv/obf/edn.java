package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class edn {
    public static final edm Companion = new edm();
    public final dsy a;
    public final Integer b;

    public /* synthetic */ edn(int i, dsy dsyVar, Integer num) {
        if (3 != (i & 3)) {
            bht.ah(i, 3, edl.b.getDescriptor());
            throw null;
        }
        this.a = dsyVar;
        this.b = num;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof edn)) {
            return false;
        }
        edn ednVar = (edn) obj;
        return bzo.f(this.a, ednVar.a) && bzo.f(this.b, ednVar.b);
    }

    public final int hashCode() {
        dsy dsyVar = this.a;
        int iHashCode = (dsyVar == null ? 0 : dsyVar.hashCode()) * 31;
        Integer num = this.b;
        return iHashCode + (num != null ? num.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("q72Proto(contact=" /* cnb.z(-275702540663594L) */);
        sb.append(this.a);
        sb.append(", friend_follow_num=" /* cnb.z(-275573691644714L) */);
        return bjs.p(sb, this.b, ')');
    }
}
