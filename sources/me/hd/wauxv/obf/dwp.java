package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dwp {
    public static final dwo Companion = new dwo();
    public final Boolean a;
    public final Integer b;

    public /* synthetic */ dwp(int i, Boolean bool, Integer num) {
        if (3 != (i & 3)) {
            bht.ah(i, 3, dwn.b.getDescriptor());
            throw null;
        }
        this.a = bool;
        this.b = num;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dwp)) {
            return false;
        }
        dwp dwpVar = (dwp) obj;
        return bzo.f(this.a, dwpVar.a) && bzo.f(this.b, dwpVar.b);
    }

    public final int hashCode() {
        Boolean bool = this.a;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Integer num = this.b;
        return iHashCode + (num != null ? num.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(cnb.z(-166021960825642L));
        dts.g(sb, this.a, -165828687297322L);
        return bjs.p(sb, this.b, ')');
    }
}
