package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ean {
    public static final eam Companion = new eam();
    public final Integer a;
    public final Integer b;
    public final Integer c;
    public final Integer d;
    public final dxn e;

    public /* synthetic */ ean(int i, Integer num, Integer num2, Integer num3, Integer num4, dxn dxnVar) {
        if (31 != (i & 31)) {
            bht.ah(i, 31, eal.b.getDescriptor());
            throw null;
        }
        this.a = num;
        this.b = num2;
        this.c = num3;
        this.d = num4;
        this.e = dxnVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ean)) {
            return false;
        }
        ean eanVar = (ean) obj;
        return nullSafeIsEqual(this.a, eanVar.a) && nullSafeIsEqual(this.b, eanVar.b)
                && nullSafeIsEqual(this.c, eanVar.c) && nullSafeIsEqual(this.d, eanVar.d)
                && nullSafeIsEqual(this.e, eanVar.e);
    }

    public final int hashCode() {
        Integer num = this.a;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.b;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.c;
        int iHashCode3 = (iHashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.d;
        int iHashCode4 = (iHashCode3 + (num4 == null ? 0 : num4.hashCode())) * 31;
        dxn dxnVar = this.e;
        return iHashCode4 + (dxnVar != null ? dxnVar.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("m81Proto(event_id=" /* cnb.z(-211965225990954L) */);
        bjs.w(sb, this.a, -211282326190890L);
        bjs.w(sb, this.b, -211179246975786L);
        bjs.w(sb, this.c, -211110527499050L);
        bjs.w(sb, this.d, -211604448738090L);
        sb.append(this.e);
        sb.append(')');
        return sb.toString();
    }
}
