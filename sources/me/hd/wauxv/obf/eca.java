package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eca {
    public static final ebz Companion = new ebz();
    public final String a;
    public final Integer b;
    public final Integer c;
    public final efa d;
    public final edk e;
    public final eiw f;
    public final efg g;
    public final Integer h;
    public final Integer i;
    public final Integer j;
    public final eha k;
    public final ejl l;
    public final String m;

    public /* synthetic */ eca(int i, String str, Integer num, Integer num2, efa efaVar, edk edkVar, eiw eiwVar,
            efg efgVar, Integer num3, Integer num4, Integer num5, eha ehaVar, ejl ejlVar, String str2) {
        if (8191 != (i & 8191)) {
            bht.ah(i, 8191, eby.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = num;
        this.c = num2;
        this.d = efaVar;
        this.e = edkVar;
        this.f = eiwVar;
        this.g = efgVar;
        this.h = num3;
        this.i = num4;
        this.j = num5;
        this.k = ehaVar;
        this.l = ejlVar;
        this.m = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof eca)) {
            return false;
        }
        eca ecaVar = (eca) obj;
        return nullSafeIsEqual(this.a, ecaVar.a) && nullSafeIsEqual(this.b, ecaVar.b)
                && nullSafeIsEqual(this.c, ecaVar.c) && nullSafeIsEqual(this.d, ecaVar.d)
                && nullSafeIsEqual(this.e, ecaVar.e) && nullSafeIsEqual(this.f, ecaVar.f)
                && nullSafeIsEqual(this.g, ecaVar.g)
                && nullSafeIsEqual(this.h, ecaVar.h) && nullSafeIsEqual(this.i, ecaVar.i)
                && nullSafeIsEqual(this.j, ecaVar.j)
                && nullSafeIsEqual(this.k, ecaVar.k) && nullSafeIsEqual(this.l, ecaVar.l)
                && nullSafeIsEqual(this.m, ecaVar.m);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.b;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.c;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        efa efaVar = this.d;
        int iHashCode4 = (iHashCode3 + (efaVar == null ? 0 : efaVar.hashCode())) * 31;
        edk edkVar = this.e;
        int iHashCode5 = (iHashCode4 + (edkVar == null ? 0 : edkVar.hashCode())) * 31;
        eiw eiwVar = this.f;
        int iHashCode6 = (iHashCode5 + (eiwVar == null ? 0 : eiwVar.hashCode())) * 31;
        efg efgVar = this.g;
        int iHashCode7 = (iHashCode6 + (efgVar == null ? 0 : efgVar.hashCode())) * 31;
        Integer num3 = this.h;
        int iHashCode8 = (iHashCode7 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.i;
        int iHashCode9 = (iHashCode8 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.j;
        int iHashCode10 = (iHashCode9 + (num5 == null ? 0 : num5.hashCode())) * 31;
        eha ehaVar = this.k;
        int iHashCode11 = (iHashCode10 + (ehaVar == null ? 0 : ehaVar.hashCode())) * 31;
        ejl ejlVar = this.l;
        int iHashCode12 = (iHashCode11 + (ejlVar == null ? 0 : ejlVar.hashCode())) * 31;
        String str2 = this.m;
        return iHashCode12 + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("nr5Proto(d=" /* "nr5Proto(d=" /* "nr5Proto(d=" /* cnb.z(-256486856981290L)  */);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.a, -262448271588138L);
        bjs.w(sb, this.b, -262461156490026L);
        bjs.w(sb, this.c, -262422501784362L);
        sb.append(this.d);
        sb.append(", h=" /* ", h=" /* ", h=" /* cnb.z(-262435386686250L)  */);
        sb.append(this.e);
        sb.append(", i=" /* ", i=" /* ", i=" /* cnb.z(-262396731980586L)  */);
        sb.append(this.f);
        sb.append(", j=" /* ", j=" /* ", j=" /* cnb.z(-262340897405738L)  */);
        sb.append(this.g);
        sb.append(", n=" /* ", n=" /* ", n=" /* cnb.z(-262370962176810L)  */);
        bjs.w(sb, this.h, -262315127601962L);
        bjs.w(sb, this.i, -262276472896298L);
        bjs.w(sb, this.j, -262289357798186L);
        sb.append(this.k);
        sb.append(", r=" /* ", r=" /* ", r=" /* cnb.z(-262250703092522L)  */);
        sb.append(this.l);
        sb.append(", s=" /* ", s=" /* ", s=" /* cnb.z(-262263587994410L)  */);
        return concat(sb, this.m, ')');
    }
}
