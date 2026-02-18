package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eit {
    public static final eis Companion = new eis();
    public final Long a;
    public final Long b;

    public /* synthetic */ eit(int i, Long l, Long l2) {
        if (3 != (i & 3)) {
            bht.ah(i, 3, eir.b.getDescriptor());
            throw null;
        }
        this.a = l;
        this.b = l2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof eit)) {
            return false;
        }
        eit eitVar = (eit) obj;
        return bzo.f(this.a, eitVar.a) && bzo.f(this.b, eitVar.b);
    }

    public final int hashCode() {
        Long l = this.a;
        int iHashCode = (l == null ? 0 : l.hashCode()) * 31;
        Long l2 = this.b;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(cnb.z(-323801879411498L));
        dkz.ad(sb, this.a, -323574246144810L);
        sb.append(this.b);
        sb.append(')');
        return sb.toString();
    }
}
