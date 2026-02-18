package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eju {
    public static final ejt Companion = new ejt();
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final Boolean f;
    public final Boolean g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;

    public /* synthetic */ eju(int i, String str, String str2, String str3, String str4, String str5, Boolean bool, Boolean bool2, String str6, String str7, String str8, String str9, String str10) {
        if (4095 != (i & 4095)) {
            bht.ah(i, 4095, ejs.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = bool;
        this.g = bool2;
        this.h = str6;
        this.i = str7;
        this.j = str8;
        this.k = str9;
        this.l = str10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof eju)) {
            return false;
        }
        eju ejuVar = (eju) obj;
        return bzo.f(this.a, ejuVar.a) && bzo.f(this.b, ejuVar.b) && bzo.f(this.c, ejuVar.c) && bzo.f(this.d, ejuVar.d) && bzo.f(this.e, ejuVar.e) && bzo.f(this.f, ejuVar.f) && bzo.f(this.g, ejuVar.g) && bzo.f(this.h, ejuVar.h) && bzo.f(this.i, ejuVar.i) && bzo.f(this.j, ejuVar.j) && bzo.f(this.k, ejuVar.k) && bzo.f(this.l, ejuVar.l);
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
        Boolean bool = this.f;
        int iHashCode6 = (iHashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.g;
        int iHashCode7 = (iHashCode6 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str6 = this.h;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.i;
        int iHashCode9 = (iHashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.j;
        int iHashCode10 = (iHashCode9 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.k;
        int iHashCode11 = (iHashCode10 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.l;
        return iHashCode11 + (str10 != null ? str10.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(cnb.z(-351371274484522L));
        yg.u(sb, this.a, -351315439909674L);
        yg.u(sb, this.b, -351805066181418L);
        yg.u(sb, this.c, -351740641671978L);
        yg.u(sb, this.d, -351671922195242L);
        yg.u(sb, this.e, -351603202718506L);
        dts.g(sb, this.f, -350933187820330L);
        dts.g(sb, this.g, -350873058278186L);
        yg.u(sb, this.h, -350782863964970L);
        yg.u(sb, this.i, -350778568997674L);
        yg.u(sb, this.j, -351251015400234L);
        yg.u(sb, this.k, -351165116054314L);
        return bjs.q(sb, this.l, ')');
    }
}
