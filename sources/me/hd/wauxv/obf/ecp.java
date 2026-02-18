package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ecp {
    public static final eco Companion = new eco();
    public final edb a;

    public /* synthetic */ ecp(int i, edb edbVar) {
        if (1 == (i & 1)) {
            this.a = edbVar;
        } else {
            bht.ah(i, 1, ecn.b.getDescriptor());
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ecp) && bzo.f(this.a, ((ecp) obj).a);
    }

    public final int hashCode() {
        edb edbVar = this.a;
        if (edbVar == null) {
            return 0;
        }
        return edbVar.hashCode();
    }

    public final String toString() {
        return "ok1Proto(preload_infos=" /* cnb.z(-260614320552746L) */ + this.a + ')';
    }
}
