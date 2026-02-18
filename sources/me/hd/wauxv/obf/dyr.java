package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dyr {
    public static final dyq Companion = new dyq();
    public final Integer a;
    public final Integer b;
    public final Long c;

    public /* synthetic */ dyr(int i, Integer num, Integer num2, Long l) {
        if (7 != (i & 7)) {
            bht.ah(i, 7, dyp.b.getDescriptor());
            throw null;
        }
        this.a = num;
        this.b = num2;
        this.c = l;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dyr)) {
            return false;
        }
        dyr dyrVar = (dyr) obj;
        return nullSafeIsEqual(this.a, dyrVar.a) && nullSafeIsEqual(this.b, dyrVar.b)
                && nullSafeIsEqual(this.c, dyrVar.c);
    }

    public final int hashCode() {
        Integer num = this.a;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.b;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l = this.c;
        return iHashCode2 + (l != null ? l.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("il1Proto(online_member_count=" /* cnb.z(-208215719541546L) */);
        bjs.w(sb, this.a, -196524818561834L);
        bjs.w(sb, this.b, -196447509150506L);
        sb.append(this.c);
        sb.append(')');
        return sb.toString();
    }
}
