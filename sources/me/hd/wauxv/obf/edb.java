package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class edb {
    public static final eda Companion = new eda();
    public final Integer a;
    public final Float b;
    public final Integer c;
    public final Integer d;
    public final Float e;
    public final Integer f;
    public final Integer g;
    public final Long h;
    public final String i;

    public /* synthetic */ edb(int i, Integer num, Float f, Integer num2, Integer num3, Float f2, Integer num4,
            Integer num5, Long l, String str) {
        if (511 != (i & 511)) {
            bht.ah(i, 511, ecz.b.getDescriptor());
            throw null;
        }
        this.a = num;
        this.b = f;
        this.c = num2;
        this.d = num3;
        this.e = f2;
        this.f = num4;
        this.g = num5;
        this.h = l;
        this.i = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof edb)) {
            return false;
        }
        edb edbVar = (edb) obj;
        return nullSafeIsEqual(this.a, edbVar.a) && nullSafeIsEqual(this.b, edbVar.b)
                && nullSafeIsEqual(this.c, edbVar.c) && nullSafeIsEqual(this.d, edbVar.d)
                && nullSafeIsEqual(this.e, edbVar.e) && nullSafeIsEqual(this.f, edbVar.f)
                && nullSafeIsEqual(this.g, edbVar.g)
                && nullSafeIsEqual(this.h, edbVar.h) && nullSafeIsEqual(this.i, edbVar.i);
    }

    public final int hashCode() {
        Integer num = this.a;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Float f = this.b;
        int iHashCode2 = (iHashCode + (f == null ? 0 : f.hashCode())) * 31;
        Integer num2 = this.c;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.d;
        int iHashCode4 = (iHashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Float f2 = this.e;
        int iHashCode5 = (iHashCode4 + (f2 == null ? 0 : f2.hashCode())) * 31;
        Integer num4 = this.f;
        int iHashCode6 = (iHashCode5 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.g;
        int iHashCode7 = (iHashCode6 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Long l = this.h;
        int iHashCode8 = (iHashCode7 + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.i;
        return iHashCode8 + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("p61Proto(video_quality_level=" /* cnb.z(-248085900950314L) */);
        bjs.w(sb, this.a, -248008591538986L);
        bjs.v(sb, this.b, -248399433562922L);
        bjs.w(sb, this.c, -248287764413226L);
        bjs.w(sb, this.d, -248236224805674L);
        bjs.v(sb, this.e, -247561914940202L);
        bjs.w(sb, this.f, -247454540757802L);
        bjs.w(sb, this.g, -247871152585514L);
        dkz.ad(sb, this.h, -247759483435818L);
        return concat(sb, this.i, ')');
    }
}
