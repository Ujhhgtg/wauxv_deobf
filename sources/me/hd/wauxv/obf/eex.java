package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eex {
    public static final eew Companion = new eew();
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final Integer f;

    public /* synthetic */ eex(int i, String str, String str2, String str3, String str4, String str5, Integer num) {
        if (63 != (i & 63)) {
            bht.ah(i, 63, eev.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = num;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof eex)) {
            return false;
        }
        eex eexVar = (eex) obj;
        return nullSafeIsEqual(this.a, eexVar.a) && nullSafeIsEqual(this.b, eexVar.b)
                && nullSafeIsEqual(this.c, eexVar.c) && nullSafeIsEqual(this.d, eexVar.d)
                && nullSafeIsEqual(this.e, eexVar.e) && nullSafeIsEqual(this.f, eexVar.f);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.c;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.d;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.e;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num = this.f;
        return iHashCode5 + (num != null ? num.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("sz0Proto(appid=" /* cnb.z(-296868139498282L) */);
        yg.u(sb, this.a, -296799420021546L);
        yg.u(sb, this.b, -296765060283178L);
        yg.u(sb, this.c, -296726405577514L);
        yg.u(sb, this.d, -296661981068074L);
        yg.u(sb, this.e, -296030620875562L);
        return concat(sb, this.f, ')');
    }
}
