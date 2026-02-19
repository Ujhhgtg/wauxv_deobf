package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dzy {
    public static final dzx Companion = new dzx();
    public final String a;
    public final String b;
    public final String c;
    public final Integer d;
    public final Long e;
    public final String f;

    public /* synthetic */ dzy(int i, String str, String str2, String str3, Integer num, Long l, String str4) {
        if (63 != (i & 63)) {
            bht.ah(i, 63, dzw.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = num;
        this.e = l;
        this.f = str4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dzy)) {
            return false;
        }
        dzy dzyVar = (dzy) obj;
        return nullSafeIsEqual(this.a, dzyVar.a) && nullSafeIsEqual(this.b, dzyVar.b)
                && nullSafeIsEqual(this.c, dzyVar.c) && nullSafeIsEqual(this.d, dzyVar.d)
                && nullSafeIsEqual(this.e, dzyVar.e) && nullSafeIsEqual(this.f, dzyVar.f);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.c;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.d;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Long l = this.e;
        int iHashCode5 = (iHashCode4 + (l == null ? 0 : l.hashCode())) * 31;
        String str4 = this.f;
        return iHashCode5 + (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("lk0Proto(topicEventId=" /* "lk0Proto(topicEventId=" /* "lk0Proto(topicEventId=" /* cnb.z(-220576635419434L)  */);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.a, -220477851171626L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.b, -220967477443370L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.c, -220842923391786L);
        bjs.w(sb, this.d, -220791383784234L);
        dkz.ad(sb, this.e, -220177203460906L);
        return concat(sb, this.f, ')');
    }
}
