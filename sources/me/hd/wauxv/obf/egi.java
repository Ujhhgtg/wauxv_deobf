package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class egi {
    public static final egh Companion = new egh();
    public static final IHasGetValue[] a;
    public final String b;
    public final Long c;
    public final Integer d;
    public final Integer e;
    public final List f;
    public final Integer g;
    public final Long h;
    public final Integer i;
    public final Integer j;
    public final List k;
    public final Integer l;
    public final eft m;
    public final Integer n;
    public final Boolean o;

    static {
        efq efqVar = new efq(2);
        btx btxVar = btx.a;
        a = new IHasGetValue[] { null, null, null, null, StaticAndroidHelpers.am(btxVar, efqVar), null, null, null, null,
                StaticAndroidHelpers.am(btxVar, new efq(3)), null, null, null, null };
    }

    public /* synthetic */ egi(int i, String str, Long l, Integer num, Integer num2, List list, Integer num3, Long l2,
            Integer num4, Integer num5, List list2, Integer num6, eft eftVar, Integer num7, Boolean bool) {
        if (16383 != (i & 16383)) {
            ResourcesCompat.ah(i, 16383, egg.b.getDescriptor());
            throw null;
        }
        this.b = str;
        this.c = l;
        this.d = num;
        this.e = num2;
        this.f = list;
        this.g = num3;
        this.h = l2;
        this.i = num4;
        this.j = num5;
        this.k = list2;
        this.l = num6;
        this.m = eftVar;
        this.n = num7;
        this.o = bool;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof egi)) {
            return false;
        }
        egi egiVar = (egi) obj;
        return nullSafeIsEqual(this.b, egiVar.b) && nullSafeIsEqual(this.c, egiVar.c)
                && nullSafeIsEqual(this.d, egiVar.d) && nullSafeIsEqual(this.e, egiVar.e)
                && nullSafeIsEqual(this.f, egiVar.f) && nullSafeIsEqual(this.g, egiVar.g)
                && nullSafeIsEqual(this.h, egiVar.h) && nullSafeIsEqual(this.i, egiVar.i)
                && nullSafeIsEqual(this.j, egiVar.j) && nullSafeIsEqual(this.k, egiVar.k)
                && nullSafeIsEqual(this.l, egiVar.l) && nullSafeIsEqual(this.m, egiVar.m)
                && nullSafeIsEqual(this.n, egiVar.n) && nullSafeIsEqual(this.o, egiVar.o);
    }

    public final int hashCode() {
        String str = this.b;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l = this.c;
        int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
        Integer num = this.d;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.e;
        int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        List list = this.f;
        int iHashCode5 = (iHashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        Integer num3 = this.g;
        int iHashCode6 = (iHashCode5 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Long l2 = this.h;
        int iHashCode7 = (iHashCode6 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Integer num4 = this.i;
        int iHashCode8 = (iHashCode7 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.j;
        int iHashCode9 = (iHashCode8 + (num5 == null ? 0 : num5.hashCode())) * 31;
        List list2 = this.k;
        int iHashCode10 = (iHashCode9 + (list2 == null ? 0 : list2.hashCode())) * 31;
        Integer num6 = this.l;
        int iHashCode11 = (iHashCode10 + (num6 == null ? 0 : num6.hashCode())) * 31;
        eft eftVar = this.m;
        int iHashCode12 = (iHashCode11 + (eftVar == null ? 0 : eftVar.hashCode())) * 31;
        Integer num7 = this.n;
        int iHashCode13 = (iHashCode12 + (num7 == null ? 0 : num7.hashCode())) * 31;
        Boolean bool = this.o;
        return iHashCode13 + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("v51Proto(battle_id=" /* "v51Proto(battle_id=" /* "v51Proto(battle_id=" /* cnb.z(-316637873961770L)  */);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.b, -316586334354218L);
        StaticHelpers6.ad(sb, this.c, -316509024942890L);
        bjs.w(sb, this.d, -316483255139114L);
        bjs.w(sb, this.e, -316410240695082L);
        yg.v(sb, this.f, -315778880502570L);
        bjs.w(sb, this.g, -315753110698794L);
        StaticHelpers6.ad(sb, this.h, -315667211352874L);
        bjs.w(sb, this.i, -315602786843434L);
        bjs.w(sb, this.j, -315589901941546L);
        yg.v(sb, this.k, -316070938278698L);
        bjs.w(sb, this.l, -315942089259818L);
        sb.append(this.m);
        sb.append(", battle_scope=" /* ", battle_scope=" /* ", battle_scope=" /* cnb.z(-315933499325226L)  */);
        bjs.w(sb, this.n, -315864779848490L);
        sb.append(this.o);
        sb.append(')');
        return sb.toString();
    }
}
