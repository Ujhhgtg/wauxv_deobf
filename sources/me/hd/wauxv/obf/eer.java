package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eer {
    public static final eeq Companion = new eeq();
    public static final IHasGetValue[] a = { null, null, null, null, null, null, null, null, null, null, null, null,
            null, null,
            null, StaticAndroidHelpers.am(btx.a, new dtr(27)), null };
    public final Float b;
    public final Float c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final Integer h;
    public final String i;
    public final String j;
    public final String k;
    public final Integer l;
    public final String m;
    public final String n;
    public final String o;
    public final Long p;
    public final List q;
    public final Integer r;

    public /* synthetic */ eer(int i, Float f, Float f2, String str, String str2, String str3, String str4, Integer num,
            String str5, String str6, String str7, Integer num2, String str8, String str9, String str10, Long l,
            List list, Integer num3) {
        if (131071 != (i & 131071)) {
            ResourcesCompat.ah(i, 131071, eep.b.getDescriptor());
            throw null;
        }
        this.b = f;
        this.c = f2;
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = str4;
        this.h = num;
        this.i = str5;
        this.j = str6;
        this.k = str7;
        this.l = num2;
        this.m = str8;
        this.n = str9;
        this.o = str10;
        this.p = l;
        this.q = list;
        this.r = num3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof eer)) {
            return false;
        }
        eer eerVar = (eer) obj;
        return nullSafeIsEqual(this.b, eerVar.b) && nullSafeIsEqual(this.c, eerVar.c)
                && nullSafeIsEqual(this.d, eerVar.d) && nullSafeIsEqual(this.e, eerVar.e)
                && nullSafeIsEqual(this.f, eerVar.f) && nullSafeIsEqual(this.g, eerVar.g)
                && nullSafeIsEqual(this.h, eerVar.h)
                && nullSafeIsEqual(this.i, eerVar.i) && nullSafeIsEqual(this.j, eerVar.j)
                && nullSafeIsEqual(this.k, eerVar.k)
                && nullSafeIsEqual(this.l, eerVar.l) && nullSafeIsEqual(this.m, eerVar.m)
                && nullSafeIsEqual(this.n, eerVar.n)
                && nullSafeIsEqual(this.o, eerVar.o) && nullSafeIsEqual(this.p, eerVar.p)
                && nullSafeIsEqual(this.q, eerVar.q)
                && nullSafeIsEqual(this.r, eerVar.r);
    }

    public final int hashCode() {
        Float f = this.b;
        int iHashCode = (f == null ? 0 : f.hashCode()) * 31;
        Float f2 = this.c;
        int iHashCode2 = (iHashCode + (f2 == null ? 0 : f2.hashCode())) * 31;
        String str = this.d;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.e;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.g;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.h;
        int iHashCode7 = (iHashCode6 + (num == null ? 0 : num.hashCode())) * 31;
        String str5 = this.i;
        int iHashCode8 = (iHashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.j;
        int iHashCode9 = (iHashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.k;
        int iHashCode10 = (iHashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Integer num2 = this.l;
        int iHashCode11 = (iHashCode10 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str8 = this.m;
        int iHashCode12 = (iHashCode11 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.n;
        int iHashCode13 = (iHashCode12 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.o;
        int iHashCode14 = (iHashCode13 + (str10 == null ? 0 : str10.hashCode())) * 31;
        Long l = this.p;
        int iHashCode15 = (iHashCode14 + (l == null ? 0 : l.hashCode())) * 31;
        List list = this.q;
        int iHashCode16 = (iHashCode15 + (list == null ? 0 : list.hashCode())) * 31;
        Integer num3 = this.r;
        return iHashCode16 + (num3 != null ? num3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("sp1Proto(longitude=" /* "sp1Proto(longitude=" /* "sp1Proto(longitude=" /* cnb.z(-268456930835242L)  */);
        bjs.v(sb, this.b, -268405391227690L);
        bjs.v(sb, this.c, -268319491881770L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.d, -268285132143402L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.e, -268822003055402L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.f, -268744693644074L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.g, -268671679200042L);
        bjs.w(sb, this.h, -268624434559786L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.i, -270187802655530L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.j, -270162032851754L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.k, -270131968080682L);
        bjs.w(sb, this.l, -270037478800170L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.m, -270028888865578L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.n, -269955874421546L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.o, -270424025856810L);
        StaticHelpers6.ad(sb, this.p, -270389666118442L);
        yg.v(sb, this.q, -270312356707114L);
        return concat(sb, this.r, ')');
    }
}
