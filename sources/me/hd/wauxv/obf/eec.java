package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eec {
    public static final eeb Companion = new eeb();
    public static final IHasGetValue[] a = { null, ewz.am(btx.a, new dtr(25)) };
    public final Integer b;
    public final List c;

    public /* synthetic */ eec(int i, Integer num, List list) {
        if (3 != (i & 3)) {
            bht.ah(i, 3, eea.b.getDescriptor());
            throw null;
        }
        this.b = num;
        this.c = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof eec)) {
            return false;
        }
        eec eecVar = (eec) obj;
        return nullSafeIsEqual(this.b, eecVar.b) && nullSafeIsEqual(this.c, eecVar.c);
    }

    public final int hashCode() {
        Integer num = this.b;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        List list = this.c;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("rn3Proto(live_mode=" /* cnb.z(-281041185012522L) */);
        bjs.w(sb, this.b, -280989645404970L);
        sb.append(this.c);
        sb.append(')');
        return sb.toString();
    }
}
