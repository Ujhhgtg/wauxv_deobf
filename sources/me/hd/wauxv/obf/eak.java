package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eak {
    public static final eaj Companion = new eaj();
    public static final IHasGetValue[] a;
    public final Long b;
    public final Long c;
    public final Integer d;
    public final Integer e;
    public final List f;
    public final List g;
    public final Boolean h;
    public final Boolean i;
    public final Integer j;
    public final Integer k;
    public final Integer l;
    public final String m;

    static {
        dtr dtrVar = new dtr(16);
        btx btxVar = btx.a;
        a = new IHasGetValue[] { null, null, null, null, ewz.am(btxVar, dtrVar), ewz.am(btxVar, new dtr(17)), null,
                null, null,
                null, null, null };
    }

    public /* synthetic */ eak(int i, Long l, Long l2, Integer num, Integer num2, List list, List list2, Boolean bool,
            Boolean bool2, Integer num3, Integer num4, Integer num5, String str) {
        if (4095 != (i & 4095)) {
            bht.ah(i, 4095, eai.b.getDescriptor());
            throw null;
        }
        this.b = l;
        this.c = l2;
        this.d = num;
        this.e = num2;
        this.f = list;
        this.g = list2;
        this.h = bool;
        this.i = bool2;
        this.j = num3;
        this.k = num4;
        this.l = num5;
        this.m = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof eak)) {
            return false;
        }
        eak eakVar = (eak) obj;
        return nullSafeIsEqual(this.b, eakVar.b) && nullSafeIsEqual(this.c, eakVar.c)
                && nullSafeIsEqual(this.d, eakVar.d) && nullSafeIsEqual(this.e, eakVar.e)
                && nullSafeIsEqual(this.f, eakVar.f) && nullSafeIsEqual(this.g, eakVar.g)
                && nullSafeIsEqual(this.h, eakVar.h)
                && nullSafeIsEqual(this.i, eakVar.i) && nullSafeIsEqual(this.j, eakVar.j)
                && nullSafeIsEqual(this.k, eakVar.k)
                && nullSafeIsEqual(this.l, eakVar.l) && nullSafeIsEqual(this.m, eakVar.m);
    }

    public final int hashCode() {
        Long l = this.b;
        int iHashCode = (l == null ? 0 : l.hashCode()) * 31;
        Long l2 = this.c;
        int iHashCode2 = (iHashCode + (l2 == null ? 0 : l2.hashCode())) * 31;
        Integer num = this.d;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.e;
        int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        List list = this.f;
        int iHashCode5 = (iHashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        List list2 = this.g;
        int iHashCode6 = (iHashCode5 + (list2 == null ? 0 : list2.hashCode())) * 31;
        Boolean bool = this.h;
        int iHashCode7 = (iHashCode6 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.i;
        int iHashCode8 = (iHashCode7 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Integer num3 = this.j;
        int iHashCode9 = (iHashCode8 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.k;
        int iHashCode10 = (iHashCode9 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.l;
        int iHashCode11 = (iHashCode10 + (num5 == null ? 0 : num5.hashCode())) * 31;
        String str = this.m;
        return iHashCode11 + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("m40Proto(start_time=" /* "m40Proto(start_time=" /* "m40Proto(start_time=" /* cnb.z(-213605903498026L)  */);
        dkz.ad(sb, this.b, -215130616888106L);
        dkz.ad(sb, this.c, -215113437018922L);
        bjs.w(sb, this.d, -215053307476778L);
        bjs.w(sb, this.e, -215457034402602L);
        yg.v(sb, this.f, -215371135056682L);
        yg.v(sb, this.g, -215345365252906L);
        dts.g(sb, this.h, -215246581005098L);
        dts.g(sb, this.i, -214550796303146L);
        bjs.w(sb, this.j, -214477781859114L);
        bjs.w(sb, this.k, -214430537218858L);
        bjs.w(sb, this.l, -214885803752234L);
        return concat(sb, this.m, ')');
    }
}
