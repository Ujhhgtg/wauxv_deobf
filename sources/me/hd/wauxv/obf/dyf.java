package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dyf {
    public static final dye Companion = new dye();
    public final Integer a;
    public final String b;
    public final dxh c;

    public /* synthetic */ dyf(int i, Integer num, String str, dxh dxhVar) {
        if (7 != (i & 7)) {
            ResourcesCompat.ah(i, 7, dyd.b.getDescriptor());
            throw null;
        }
        this.a = num;
        this.b = str;
        this.c = dxhVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dyf)) {
            return false;
        }
        dyf dyfVar = (dyf) obj;
        return nullSafeIsEqual(this.a, dyfVar.a) && nullSafeIsEqual(this.b, dyfVar.b)
                && nullSafeIsEqual(this.c, dyfVar.c);
    }

    public final int hashCode() {
        Integer num = this.a;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        dxh dxhVar = this.c;
        return iHashCode2 + (dxhVar != null ? dxhVar.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("gm1Proto(anchor_shop_tag=" /* "gm1Proto(anchor_shop_tag=" /* "gm1Proto(anchor_shop_tag=" /* "gm1Proto(anchor_shop_tag=" /* cnb.z(-203963701918506L)   */);
        bjs.w(sb, this.a, -204418968451882L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.b, -204320184204074L);
        sb.append(this.c);
        sb.append(')');
        return sb.toString();
    }
}
