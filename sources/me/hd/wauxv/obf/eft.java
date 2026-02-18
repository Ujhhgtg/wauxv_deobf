package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eft {
    public static final efs Companion = new efs();
    public static final btt[] a = { null, ewz.am(btx.a, new efq(0)) };
    public final Integer b;
    public final List c;

    public /* synthetic */ eft(int i, Integer num, List list) {
        if (3 != (i & 3)) {
            bht.ah(i, 3, efr.b.getDescriptor());
            throw null;
        }
        this.b = num;
        this.c = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof eft)) {
            return false;
        }
        eft eftVar = (eft) obj;
        return nullSafeIsEqual(this.b, eftVar.b) && nullSafeIsEqual(this.c, eftVar.c);
    }

    public final int hashCode() {
        Integer num = this.b;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        List list = this.c;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("u51Proto(current_extra_times_multi_100=" /* cnb.z(-290223825091370L) */);
        bjs.w(sb, this.b, -290052026399530L);
        sb.append(this.c);
        sb.append(')');
        return sb.toString();
    }
}
