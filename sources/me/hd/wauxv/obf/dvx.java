package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dvx {
    public static final dvw Companion = new dvw();
    public final dyu a;
    public final Integer b;
    public final String c;
    public final String d;
    public final Long e;

    public /* synthetic */ dvx(int i, dyu dyuVar, Integer num, String str, String str2, Long l) {
        if (31 != (i & 31)) {
            ResourcesCompat.ah(i, 31, dvv.b.getDescriptor());
            throw null;
        }
        this.a = dyuVar;
        this.b = num;
        this.c = str;
        this.d = str2;
        this.e = l;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dvx)) {
            return false;
        }
        dvx dvxVar = (dvx) obj;
        return nullSafeIsEqual(this.a, dvxVar.a) && nullSafeIsEqual(this.b, dvxVar.b)
                && nullSafeIsEqual(this.c, dvxVar.c) && nullSafeIsEqual(this.d, dvxVar.d)
                && nullSafeIsEqual(this.e, dvxVar.e);
    }

    public final int hashCode() {
        dyu dyuVar = this.a;
        int iHashCode = (dyuVar == null ? 0 : dyuVar.hashCode()) * 31;
        Integer num = this.b;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.c;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.d;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l = this.e;
        return iHashCode4 + (l != null ? l.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("bf1Proto(mic_contact=" /* "bf1Proto(mic_contact=" /* "bf1Proto(mic_contact=" /* cnb.z(-174113679211306L)  */);
        sb.append(this.a);
        sb.append(", mic_type=" /* ", mic_type=" /* ", mic_type=" /* cnb.z(-174002010061610L)  */);
        bjs.w(sb, this.b, -175634097634090L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.c, -175518133517098L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.d, -175505248615210L);
        sb.append(this.e);
        sb.append(')');
        return sb.toString();
    }
}
