package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class drz {
    public static final dry Companion = new dry();
    public final Integer a;
    public final String b;
    public final Integer c;
    public final String d;
    public final String e;
    public final String f;
    public final dso g;
    public final String h;
    public final dsc i;
    public final dsi j;
    public final dsl k;
    public final dsl l;

    public /* synthetic */ drz(int i, Integer num, String str, Integer num2, String str2, String str3, String str4,
            dso dsoVar, String str5, dsc dscVar, dsi dsiVar, dsl dslVar, dsl dslVar2) {
        if (4095 != (i & 4095)) {
            bht.ah(i, 4095, drx.b.getDescriptor());
            throw null;
        }
        this.a = num;
        this.b = str;
        this.c = num2;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = dsoVar;
        this.h = str5;
        this.i = dscVar;
        this.j = dsiVar;
        this.k = dslVar;
        this.l = dslVar2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof drz)) {
            return false;
        }
        drz drzVar = (drz) obj;
        return nullSafeIsEqual(this.a, drzVar.a) && nullSafeIsEqual(this.b, drzVar.b)
                && nullSafeIsEqual(this.c, drzVar.c) && nullSafeIsEqual(this.d, drzVar.d)
                && nullSafeIsEqual(this.e, drzVar.e) && nullSafeIsEqual(this.f, drzVar.f)
                && nullSafeIsEqual(this.g, drzVar.g) && nullSafeIsEqual(this.h, drzVar.h)
                && nullSafeIsEqual(this.i, drzVar.i) && nullSafeIsEqual(this.j, drzVar.j)
                && nullSafeIsEqual(this.k, drzVar.k) && nullSafeIsEqual(this.l, drzVar.l);
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
        String str3 = this.e;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        dso dsoVar = this.g;
        int iHashCode7 = (iHashCode6 + (dsoVar == null ? 0 : dsoVar.hashCode())) * 31;
        String str5 = this.h;
        int iHashCode8 = (iHashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        dsc dscVar = this.i;
        int iHashCode9 = (iHashCode8 + (dscVar == null ? 0 : dscVar.hashCode())) * 31;
        dsi dsiVar = this.j;
        int iHashCode10 = (iHashCode9 + (dsiVar == null ? 0 : dsiVar.hashCode())) * 31;
        dsl dslVar = this.k;
        int iHashCode11 = (iHashCode10 + (dslVar == null ? 0 : dslVar.hashCode())) * 31;
        dsl dslVar2 = this.l;
        return iHashCode11 + (dslVar2 != null ? dslVar2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ActionInfoProto(type=" /* "ActionInfoProto(type=" /* "ActionInfoProto(type=" /* "ActionInfoProto(type=" /* cnb.z(-141343078742826L)   */);
        bjs.w(sb, this.a, -141781165407018L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.b, -141751100635946L);
        bjs.w(sb, this.c, -141712445930282L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.d, -141690971093802L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.e, -141622251617066L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.f, -140995186391850L);
        sb.append(this.g);
        sb.append(", newWordingKey=" /* ", newWordingKey=" /* ", newWordingKey=" /* ", newWordingKey=" /* cnb.z(-140969416588074L)   */);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.h, -140896402144042L);
        sb.append(this.i);
        sb.append(", appJumpWordingKey=" /* ", appJumpWordingKey=" /* ", appJumpWordingKey=" /* ", appJumpWordingKey=" /* cnb.z(-140836272601898L)   */);
        sb.append(this.j);
        sb.append(", installedWording=" /* ", installedWording=" /* ", installedWording=" /* ", installedWording=" /* cnb.z(-141278654233386L)   */);
        sb.append(this.k);
        sb.append(", uninstalledWording=" /* ", uninstalledWording=" /* ", uninstalledWording=" /* ", uninstalledWording=" /* cnb.z(-141158395149098L)   */);
        sb.append(this.l);
        sb.append(')');
        return sb.toString();
    }
}
