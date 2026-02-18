package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dyo {
    public static final dyn Companion = new dyn();
    public final Integer a;
    public final dsy b;
    public final Integer c;
    public final String d;
    public final String e;

    public /* synthetic */ dyo(int i, Integer num, dsy dsyVar, Integer num2, String str, String str2) {
        if (31 != (i & 31)) {
            bht.ah(i, 31, dym.b.getDescriptor());
            throw null;
        }
        this.a = num;
        this.b = dsyVar;
        this.c = num2;
        this.d = str;
        this.e = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dyo)) {
            return false;
        }
        dyo dyoVar = (dyo) obj;
        return nullSafeIsEqual(this.a, dyoVar.a) && nullSafeIsEqual(this.b, dyoVar.b)
                && nullSafeIsEqual(this.c, dyoVar.c) && nullSafeIsEqual(this.d, dyoVar.d)
                && nullSafeIsEqual(this.e, dyoVar.e);
    }

    public final int hashCode() {
        Integer num = this.a;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        dsy dsyVar = this.b;
        int iHashCode2 = (iHashCode + (dsyVar == null ? 0 : dsyVar.hashCode())) * 31;
        Integer num2 = this.c;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.d;
        int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.e;
        return iHashCode4 + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ht1Proto(music_mv_topic_id=" /* cnb.z(-208546432023338L) */);
        bjs.w(sb, this.a, -208460532677418L);
        sb.append(this.b);
        sb.append(", object_id=" /* cnb.z(-208361748429610L) */);
        bjs.w(sb, this.c, -208907209276202L);
        yg.u(sb, this.d, -208774065290026L);
        return concat(sb, this.e, ')');
    }
}
