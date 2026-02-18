package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class efj {
    public static final efi Companion = new efi();
    public final dsy a;

    public /* synthetic */ efj(int i, dsy dsyVar) {
        if (1 == (i & 1)) {
            this.a = dsyVar;
        } else {
            bht.ah(i, 1, efh.b.getDescriptor());
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof efj) && bzo.f(this.a, ((efj) obj).a);
    }

    public final int hashCode() {
        dsy dsyVar = this.a;
        if (dsyVar == null) {
            return 0;
        }
        return dsyVar.hashCode();
    }

    public final String toString() {
        return cnb.z(-281595235793706L) + this.a + ')';
    }
}
