package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dxb {
    public static final dxa Companion = new dxa();
    public final String a;
    public final Long b;

    public /* synthetic */ dxb(int i, String str, Long l) {
        if (3 != (i & 3)) {
            bht.ah(i, 3, dwz.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = l;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dxb)) {
            return false;
        }
        dxb dxbVar = (dxb) obj;
        return nullSafeIsEqual(this.a, dxbVar.a) && nullSafeIsEqual(this.b, dxbVar.b);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l = this.b;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ef1Proto(live_meet_id=" /* "ef1Proto(live_meet_id=" /* "ef1Proto(live_meet_id=" /* cnb.z(-185959199013674L)  */);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.a, -185860414765866L);
        sb.append(this.b);
        sb.append(')');
        return sb.toString();
    }
}
