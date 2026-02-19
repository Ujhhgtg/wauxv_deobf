package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eiz {
    public static final eiy Companion = new eiy();
    public static final IHasGetValue[] a = { ewz.am(btx.a, new efq(11)), null, null };
    public final List b;
    public final Integer c;
    public final eju d;

    public /* synthetic */ eiz(int i, List list, Integer num, eju ejuVar) {
        if (7 != (i & 7)) {
            ResourcesCompat.ah(i, 7, eix.b.getDescriptor());
            throw null;
        }
        this.b = list;
        this.c = num;
        this.d = ejuVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof eiz)) {
            return false;
        }
        eiz eizVar = (eiz) obj;
        return nullSafeIsEqual(this.b, eizVar.b) && nullSafeIsEqual(this.c, eizVar.c)
                && nullSafeIsEqual(this.d, eizVar.d);
    }

    public final int hashCode() {
        List list = this.b;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        Integer num = this.c;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        eju ejuVar = this.d;
        return iHashCode2 + (ejuVar != null ? ejuVar.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("y52Proto(list=" /* "y52Proto(list=" /* "y52Proto(list=" /* "y52Proto(list=" /* cnb.z(-324772542020394L)   */);
        yg.v(sb, this.b, -324708117510954L);
        bjs.w(sb, this.c, -324656577903402L);
        sb.append(this.d);
        sb.append(')');
        return sb.toString();
    }
}
