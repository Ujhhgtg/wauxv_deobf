package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eae {
    public static final ead Companion = new ead();
    public static final IHasGetValue[] a = { null, ewz.am(btx.a, new dtr(14)), null };
    public final Integer b;
    public final List c;
    public final String d;

    public /* synthetic */ eae(int i, Integer num, List list, String str) {
        if (7 != (i & 7)) {
            bht.ah(i, 7, eac.b.getDescriptor());
            throw null;
        }
        this.b = num;
        this.c = list;
        this.d = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof eae)) {
            return false;
        }
        eae eaeVar = (eae) obj;
        return nullSafeIsEqual(this.b, eaeVar.b) && nullSafeIsEqual(this.c, eaeVar.c)
                && nullSafeIsEqual(this.d, eaeVar.d);
    }

    public final int hashCode() {
        Integer num = this.b;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        List list = this.c;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.d;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ls3Proto(index=" /* cnb.z(-228509440015146L) */);
        bjs.w(sb, this.b, -228440720538410L);
        yg.v(sb, this.c, -227852310018858L);
        return concat(sb, this.d, ')');
    }
}
