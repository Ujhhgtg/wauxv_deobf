package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ehj {
    public static final ehi Companion = new ehi();
    public static final btt[] a = {ewz.am(btx.a, new efq(4)), null};
    public final List b;
    public final Integer c;

    public /* synthetic */ ehj(int i, Integer num, List list) {
        if (3 != (i & 3)) {
            bht.ah(i, 3, ehh.b.getDescriptor());
            throw null;
        }
        this.b = list;
        this.c = num;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ehj)) {
            return false;
        }
        ehj ehjVar = (ehj) obj;
        return bzo.f(this.b, ehjVar.b) && bzo.f(this.c, ehjVar.c);
    }

    public final int hashCode() {
        List list = this.b;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        Integer num = this.c;
        return iHashCode + (num != null ? num.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(cnb.z(-305994945002282L));
        yg.v(sb, this.b, -307549723163434L);
        return bjs.p(sb, this.c, ')');
    }
}
