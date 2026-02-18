package me.hd.wauxv.obf;

import com.android.dx.io.Opcodes;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dxz {
    public static final dxy Companion = new dxy();
    public final Integer a;
    public final Boolean b;
    public final Integer c;
    public final Long d;
    public final Integer e;
    public final Integer f;
    public final String g;
    public final Integer h;

    public /* synthetic */ dxz(int i, Integer num, Boolean bool, Integer num2, Long l, Integer num3, Integer num4,
            String str, Integer num5) {
        if (255 != (i & Opcodes.CONST_METHOD_TYPE)) {
            bht.ah(i, Opcodes.CONST_METHOD_TYPE, dxx.b.getDescriptor());
            throw null;
        }
        this.a = num;
        this.b = bool;
        this.c = num2;
        this.d = l;
        this.e = num3;
        this.f = num4;
        this.g = str;
        this.h = num5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dxz)) {
            return false;
        }
        dxz dxzVar = (dxz) obj;
        return nullSafeIsEqual(this.a, dxzVar.a) && nullSafeIsEqual(this.b, dxzVar.b)
                && nullSafeIsEqual(this.c, dxzVar.c) && nullSafeIsEqual(this.d, dxzVar.d)
                && nullSafeIsEqual(this.e, dxzVar.e) && nullSafeIsEqual(this.f, dxzVar.f)
                && nullSafeIsEqual(this.g, dxzVar.g)
                && nullSafeIsEqual(this.h, dxzVar.h);
    }

    public final int hashCode() {
        Integer num = this.a;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Boolean bool = this.b;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num2 = this.c;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l = this.d;
        int iHashCode4 = (iHashCode3 + (l == null ? 0 : l.hashCode())) * 31;
        Integer num3 = this.e;
        int iHashCode5 = (iHashCode4 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.f;
        int iHashCode6 = (iHashCode5 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str = this.g;
        int iHashCode7 = (iHashCode6 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num5 = this.h;
        return iHashCode7 + (num5 != null ? num5.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("gj1Proto(charge_flag=" /* cnb.z(-204947249429290L) */);
        bjs.w(sb, this.a, -204835580279594L);
        dts.g(sb, this.b, -206416128244522L);
        bjs.w(sb, this.c, -206300164127530L);
        dkz.ad(sb, this.d, -206244329552682L);
        bjs.w(sb, this.e, -206691006151466L);
        bjs.w(sb, this.f, -206596516870954L);
        yg.u(sb, this.g, -206536387328810L);
        return concat(sb, this.h, ')');
    }
}
