package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class egx {
    public static final egw Companion = new egw();
    public final dyi a;
    public final dsy b;

    public /* synthetic */ egx(int i, dyi dyiVar, dsy dsyVar) {
        if (3 != (i & 3)) {
            bht.ah(i, 3, egv.b.getDescriptor());
            throw null;
        }
        this.a = dyiVar;
        this.b = dsyVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof egx)) {
            return false;
        }
        egx egxVar = (egx) obj;
        return bzo.f(this.a, egxVar.a) && bzo.f(this.b, egxVar.b);
    }

    public final int hashCode() {
        dyi dyiVar = this.a;
        int iHashCode = (dyiVar == null ? 0 : dyiVar.hashCode()) * 31;
        dsy dsyVar = this.b;
        return iHashCode + (dsyVar != null ? dsyVar.hashCode() : 0);
    }

    public final String toString() {
        return cnb.z(-299956220984106L) + this.a + cnb.z(-299299090987818L) + this.b + ')';
    }
}
