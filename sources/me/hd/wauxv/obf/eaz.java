package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eaz {
    public static final eay Companion = new eay();
    public final duh a;

    public /* synthetic */ eaz(int i, duh duhVar) {
        if (1 == (i & 1)) {
            this.a = duhVar;
        } else {
            ResourcesCompat.ah(i, 1, eax.b.getDescriptor());
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof eaz) && nullSafeIsEqual(this.a, ((eaz) obj).a);
    }

    public final int hashCode() {
        duh duhVar = this.a;
        if (duhVar == null) {
            return 0;
        }
        return duhVar.hashCode();
    }

    public final String toString() {
        return "mh4Proto(d=" /* "mh4Proto(d=" /* "mh4Proto(d=" /* cnb.z(-229849469811498L)  */ + this.a + ')';
    }
}
