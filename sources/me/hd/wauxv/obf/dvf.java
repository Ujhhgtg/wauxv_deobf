package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dvf {
    public static final dve Companion = new dve();
    public final eei a;
    public final Long b;
    public final Long c;

    public /* synthetic */ dvf(int i, eei eeiVar, Long l, Long l2) {
        if (7 != (i & 7)) {
            bht.ah(i, 7, dvd.b.getDescriptor());
            throw null;
        }
        this.a = eeiVar;
        this.b = l;
        this.c = l2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dvf)) {
            return false;
        }
        dvf dvfVar = (dvf) obj;
        return nullSafeIsEqual(this.a, dvfVar.a) && nullSafeIsEqual(this.b, dvfVar.b)
                && nullSafeIsEqual(this.c, dvfVar.c);
    }

    public final int hashCode() {
        eei eeiVar = this.a;
        int iHashCode = (eeiVar == null ? 0 : eeiVar.hashCode()) * 31;
        Long l = this.b;
        int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.c;
        return iHashCode2 + (l2 != null ? l2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ab3Proto(gift=" /* cnb.z(-144748987808554L) */);
        sb.append(this.a);
        sb.append(", product_target_count=" /* cnb.z(-144667383429930L) */);
        dkz.ad(sb, this.b, -145114060028714L);
        sb.append(this.c);
        sb.append(')');
        return sb.toString();
    }
}
