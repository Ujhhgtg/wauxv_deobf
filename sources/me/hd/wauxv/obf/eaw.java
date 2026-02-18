package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eaw {
    public static final eav Companion = new eav();
    public final String a;
    public final Integer b;
    public final Long c;

    public /* synthetic */ eaw(int i, String str, Integer num, Long l) {
        if (7 != (i & 7)) {
            bht.ah(i, 7, eau.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = num;
        this.c = l;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof eaw)) {
            return false;
        }
        eaw eawVar = (eaw) obj;
        return bzo.f(this.a, eawVar.a) && bzo.f(this.b, eawVar.b) && bzo.f(this.c, eawVar.c);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.b;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Long l = this.c;
        return iHashCode2 + (l != null ? l.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("mg5Proto(name=" /* cnb.z(-230412110527274L) */);
        yg.u(sb, this.a, -230897441831722L);
        bjs.w(sb, this.b, -230828722354986L);
        sb.append(this.c);
        sb.append(')');
        return sb.toString();
    }
}
