package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eel {
    public static final eek Companion = new eek();
    public final Long a;
    public final Long b;
    public final Integer c;
    public final Boolean d;

    public /* synthetic */ eel(int i, Long l, Long l2, Integer num, Boolean bool) {
        if (15 != (i & 15)) {
            bht.ah(i, 15, eej.b.getDescriptor());
            throw null;
        }
        this.a = l;
        this.b = l2;
        this.c = num;
        this.d = bool;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof eel)) {
            return false;
        }
        eel eelVar = (eel) obj;
        return nullSafeIsEqual(this.a, eelVar.a) && nullSafeIsEqual(this.b, eelVar.b)
                && nullSafeIsEqual(this.c, eelVar.c) && nullSafeIsEqual(this.d, eelVar.d);
    }

    public final int hashCode() {
        Long l = this.a;
        int iHashCode = (l == null ? 0 : l.hashCode()) * 31;
        Long l2 = this.b;
        int iHashCode2 = (iHashCode + (l2 == null ? 0 : l2.hashCode())) * 31;
        Integer num = this.c;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Boolean bool = this.d;
        return iHashCode3 + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("sf0Proto(diff_extra_count=" /* cnb.z(-265304424839978L) */);
        dkz.ad(sb, this.a, -271270134414122L);
        dkz.ad(sb, this.b, -271145580362538L);
        bjs.w(sb, this.c, -271111220624170L);
        sb.append(this.d);
        sb.append(')');
        return sb.toString();
    }
}
