package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eib {
    public static final eia Companion = new eia();
    public final Boolean a;

    public /* synthetic */ eib(Boolean bool, int i) {
        if (1 == (i & 1)) {
            this.a = bool;
        } else {
            ResourcesCompat.ah(i, 1, ehz.b.getDescriptor());
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof eib) && nullSafeIsEqual(this.a, ((eib) obj).a);
    }

    public final int hashCode() {
        Boolean bool = this.a;
        if (bool == null) {
            return 0;
        }
        return bool.hashCode();
    }

    public final String toString() {
        return "wq1Proto(audience_is_member=" /* "wq1Proto(audience_is_member=" /* "wq1Proto(audience_is_member=" /* "wq1Proto(audience_is_member=" /* cnb.z(-332451943545642L)   */ + this.a + ')';
    }
}
