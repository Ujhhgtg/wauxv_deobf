package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dxn {
    public static final dxm Companion = new dxm();
    public final Integer a;
    public final String b;

    public /* synthetic */ dxn(int i, Integer num, String str) {
        if (3 != (i & 3)) {
            bht.ah(i, 3, dxl.b.getDescriptor());
            throw null;
        }
        this.a = num;
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dxn)) {
            return false;
        }
        dxn dxnVar = (dxn) obj;
        return bzo.f(this.a, dxnVar.a) && bzo.f(this.b, dxnVar.b);
    }

    public final int hashCode() {
        Integer num = this.a;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.b;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("fm4Proto(related_event_type=" /* cnb.z(-183008556481322L) */);
        bjs.w(sb, this.a, -182918362168106L);
        return bjs.q(sb, this.b, ')');
    }
}
