package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cbg {
    public final Class a;
    public final Object b;
    public cbm c = null;
    public boolean d = false;
    public cbf e = cbf.a;

    public cbg(Class cls, Object obj) {
        this.a = cls;
        this.b = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof cbg)) {
            return false;
        }
        cbg cbgVar = (cbg) obj;
        return nullSafeIsEqual(this.a, cbgVar.a) && nullSafeIsEqual(this.b, cbgVar.b)
                && nullSafeIsEqual(this.c, cbgVar.c) && this.d == cbgVar.d && this.e == cbgVar.e;
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        Object obj = this.b;
        int iHashCode2 = (iHashCode + (obj == null ? 0 : obj.hashCode())) * 31;
        cbm cbmVar = this.c;
        return this.e.hashCode()
                + ((Boolean.hashCode(this.d) + ((iHashCode2 + (cbmVar != null ? cbmVar.hashCode() : 0)) * 31)) * 31);
    }

    public final String toString() {
        return "Configuration(declaringClass=" + this.a + ", memberInstance=" + this.b + ", processorResolver=" + this.c
                + ", superclass=" + this.d + ", optional=" + this.e + ")";
    }
}
