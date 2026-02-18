package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class efw {
    public static final efv Companion = new efv();
    public final Boolean a;
    public final String b;
    public final Long c;
    public final Long d;
    public final Boolean e;
    public final Integer f;

    public /* synthetic */ efw(int i, Boolean bool, String str, Long l, Long l2, Boolean bool2, Integer num) {
        if (63 != (i & 63)) {
            bht.ah(i, 63, efu.b.getDescriptor());
            throw null;
        }
        this.a = bool;
        this.b = str;
        this.c = l;
        this.d = l2;
        this.e = bool2;
        this.f = num;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof efw)) {
            return false;
        }
        efw efwVar = (efw) obj;
        return nullSafeIsEqual(this.a, efwVar.a) && nullSafeIsEqual(this.b, efwVar.b)
                && nullSafeIsEqual(this.c, efwVar.c) && nullSafeIsEqual(this.d, efwVar.d)
                && nullSafeIsEqual(this.e, efwVar.e) && nullSafeIsEqual(this.f, efwVar.f);
    }

    public final int hashCode() {
        Boolean bool = this.a;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Long l = this.c;
        int iHashCode3 = (iHashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.d;
        int iHashCode4 = (iHashCode3 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Boolean bool2 = this.e;
        int iHashCode5 = (iHashCode4 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Integer num = this.f;
        return iHashCode5 + (num != null ? num.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("u93Proto(is_concert_live=" /* cnb.z(-286573102889770L) */);
        dts.g(sb, this.a, -286478613609258L);
        yg.u(sb, this.b, -286963944913706L);
        dkz.ad(sb, this.c, -286878045567786L);
        dkz.ad(sb, this.d, -286869455633194L);
        dts.g(sb, this.e, -286800736156458L);
        return concat(sb, this.f, ')');
    }
}
