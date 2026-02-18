package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dzj {
    public static final dzi Companion = new dzi();
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final Integer f;
    public final Integer g;
    public final Integer h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;

    public /* synthetic */ dzj(int i, String str, String str2, String str3, String str4, String str5, Integer num,
            Integer num2, Integer num3, String str6, String str7, String str8, String str9, String str10,
            String str11) {
        if (16383 != (i & 16383)) {
            bht.ah(i, 16383, dzh.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = num;
        this.g = num2;
        this.h = num3;
        this.i = str6;
        this.j = str7;
        this.k = str8;
        this.l = str9;
        this.m = str10;
        this.n = str11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dzj)) {
            return false;
        }
        dzj dzjVar = (dzj) obj;
        return nullSafeIsEqual(this.a, dzjVar.a) && nullSafeIsEqual(this.b, dzjVar.b)
                && nullSafeIsEqual(this.c, dzjVar.c) && nullSafeIsEqual(this.d, dzjVar.d)
                && nullSafeIsEqual(this.e, dzjVar.e) && nullSafeIsEqual(this.f, dzjVar.f)
                && nullSafeIsEqual(this.g, dzjVar.g)
                && nullSafeIsEqual(this.h, dzjVar.h) && nullSafeIsEqual(this.i, dzjVar.i)
                && nullSafeIsEqual(this.j, dzjVar.j)
                && nullSafeIsEqual(this.k, dzjVar.k) && nullSafeIsEqual(this.l, dzjVar.l)
                && nullSafeIsEqual(this.m, dzjVar.m)
                && nullSafeIsEqual(this.n, dzjVar.n);
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
        int iHashCode6 = (iHashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.g;
        int iHashCode7 = (iHashCode6 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.h;
        int iHashCode8 = (iHashCode7 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str6 = this.i;
        int iHashCode9 = (iHashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.j;
        int iHashCode10 = (iHashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.k;
        int iHashCode11 = (iHashCode10 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.l;
        int iHashCode12 = (iHashCode11 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.m;
        int iHashCode13 = (iHashCode12 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.n;
        return iHashCode13 + (str11 != null ? str11.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("kbProto(d=" /* cnb.z(-201339476900650L) */);
        yg.u(sb, this.a, -201309412129578L);
        yg.u(sb, this.b, -201270757423914L);
        yg.u(sb, this.c, -201214922849066L);
        yg.u(sb, this.d, -201244987620138L);
        yg.u(sb, this.e, -201738908859178L);
        bjs.w(sb, this.f, -201700254153514L);
        bjs.w(sb, this.g, -201713139055402L);
        bjs.w(sb, this.h, -201674484349738L);
        yg.u(sb, this.i, -201687369251626L);
        yg.u(sb, this.j, -201648714545962L);
        yg.u(sb, this.k, -201592879971114L);
        yg.u(sb, this.l, -201622944742186L);
        yg.u(sb, this.m, -201567110167338L);
        return concat(sb, this.n, ')');
    }
}
