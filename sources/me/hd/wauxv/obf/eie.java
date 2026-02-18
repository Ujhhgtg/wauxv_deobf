package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eie {
    public static final eid Companion = new eid();
    public final Integer a;
    public final String b;
    public final Integer c;
    public final String d;
    public final Integer e;
    public final Integer f;
    public final Integer g;
    public final String h;
    public final Integer i;
    public final String j;
    public final Integer k;

    public /* synthetic */ eie(int i, Integer num, String str, Integer num2, String str2, Integer num3, Integer num4, Integer num5, String str3, Integer num6, String str4, Integer num7) {
        if (2047 != (i & 2047)) {
            bht.ah(i, 2047, eic.b.getDescriptor());
            throw null;
        }
        this.a = num;
        this.b = str;
        this.c = num2;
        this.d = str2;
        this.e = num3;
        this.f = num4;
        this.g = num5;
        this.h = str3;
        this.i = num6;
        this.j = str4;
        this.k = num7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof eie)) {
            return false;
        }
        eie eieVar = (eie) obj;
        return bzo.f(this.a, eieVar.a) && bzo.f(this.b, eieVar.b) && bzo.f(this.c, eieVar.c) && bzo.f(this.d, eieVar.d) && bzo.f(this.e, eieVar.e) && bzo.f(this.f, eieVar.f) && bzo.f(this.g, eieVar.g) && bzo.f(this.h, eieVar.h) && bzo.f(this.i, eieVar.i) && bzo.f(this.j, eieVar.j) && bzo.f(this.k, eieVar.k);
    }

    public final int hashCode() {
        Integer num = this.a;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num2 = this.c;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str2 = this.d;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num3 = this.e;
        int iHashCode5 = (iHashCode4 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.f;
        int iHashCode6 = (iHashCode5 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.g;
        int iHashCode7 = (iHashCode6 + (num5 == null ? 0 : num5.hashCode())) * 31;
        String str3 = this.h;
        int iHashCode8 = (iHashCode7 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num6 = this.i;
        int iHashCode9 = (iHashCode8 + (num6 == null ? 0 : num6.hashCode())) * 31;
        String str4 = this.j;
        int iHashCode10 = (iHashCode9 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num7 = this.k;
        return iHashCode10 + (num7 != null ? num7.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("wqProto(d=" /* cnb.z(-334114095889194L) */);
        bjs.w(sb, this.a, -334015311641386L);
        yg.u(sb, this.b, -334045376412458L);
        bjs.w(sb, this.c, -333989541837610L);
        yg.u(sb, this.d, -333401131318058L);
        bjs.w(sb, this.e, -333414016219946L);
        bjs.w(sb, this.f, -333375361514282L);
        bjs.w(sb, this.g, -333388246416170L);
        yg.u(sb, this.h, -333349591710506L);
        bjs.w(sb, this.i, -333293757135658L);
        yg.u(sb, this.j, -333323821906730L);
        return bjs.p(sb, this.k, ')');
    }
}
