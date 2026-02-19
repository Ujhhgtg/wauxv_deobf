package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ebl {
    public static final ebk Companion = new ebk();
    public final String a;
    public final Long b;
    public final Integer c;
    public final Boolean d;
    public final eak e;
    public final Long f;
    public final Boolean g;
    public final Long h;
    public final Long i;

    public /* synthetic */ ebl(int i, String str, Long l, Integer num, Boolean bool, eak eakVar, Long l2, Boolean bool2,
            Long l3, Long l4) {
        if (511 != (i & 511)) {
            ResourcesCompat.ah(i, 511, ebj.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = l;
        this.c = num;
        this.d = bool;
        this.e = eakVar;
        this.f = l2;
        this.g = bool2;
        this.h = l3;
        this.i = l4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ebl)) {
            return false;
        }
        ebl eblVar = (ebl) obj;
        return nullSafeIsEqual(this.a, eblVar.a) && nullSafeIsEqual(this.b, eblVar.b)
                && nullSafeIsEqual(this.c, eblVar.c) && nullSafeIsEqual(this.d, eblVar.d)
                && nullSafeIsEqual(this.e, eblVar.e) && nullSafeIsEqual(this.f, eblVar.f)
                && nullSafeIsEqual(this.g, eblVar.g) && nullSafeIsEqual(this.h, eblVar.h)
                && nullSafeIsEqual(this.i, eblVar.i);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l = this.b;
        int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
        Integer num = this.c;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Boolean bool = this.d;
        int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        eak eakVar = this.e;
        int iHashCode5 = (iHashCode4 + (eakVar == null ? 0 : eakVar.hashCode())) * 31;
        Long l2 = this.f;
        int iHashCode6 = (iHashCode5 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Boolean bool2 = this.g;
        int iHashCode7 = (iHashCode6 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Long l3 = this.h;
        int iHashCode8 = (iHashCode7 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Long l4 = this.i;
        return iHashCode8 + (l4 != null ? l4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("n84Proto(finder_username=" /* "n84Proto(finder_username=" /* "n84Proto(finder_username=" /* cnb.z(-258050225077034L)  */);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.a, -257955735796522L);
        StaticHelpers6.ad(sb, this.b, -257882721352490L);
        bjs.w(sb, this.c, -258329397951274L);
        dts.g(sb, this.d, -258264973441834L);
        sb.append(this.e);
        sb.append(", extra_reward_wecoin=" /* ", extra_reward_wecoin=" /* ", extra_reward_wecoin=" /* cnb.z(-258200548932394L)  */);
        StaticHelpers6.ad(sb, this.f, -257552008870698L);
        dts.g(sb, this.g, -257483289393962L);
        StaticHelpers6.ad(sb, this.h, -257444634688298L);
        sb.append(this.i);
        sb.append(')');
        return sb.toString();
    }
}
