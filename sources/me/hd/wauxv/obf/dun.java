package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dun {
    public static final dum Companion = new dum();
    public final String a;
    public final String b;

    public /* synthetic */ dun(int i, String str, String str2) {
        if (3 != (i & 3)) {
            bht.ah(i, 3, dul.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dun)) {
            return false;
        }
        dun dunVar = (dun) obj;
        return bzo.f(this.a, dunVar.a) && bzo.f(this.b, dunVar.b);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(cnb.z(-302357107702570L));
        yg.u(sb, this.a, -302258323454762L);
        return bjs.q(sb, this.b, ')');
    }
}
