package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ehd {
    public static final ehc Companion = new ehc();
    public final String a;
    public final String b;
    public final Float c;
    public final Boolean d;
    public final dwj e;
    public final Boolean f;

    public /* synthetic */ ehd(int i, String str, String str2, Float f, Boolean bool, dwj dwjVar, Boolean bool2) {
        if (63 != (i & 63)) {
            ResourcesCompat.ah(i, 63, ehb.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = str2;
        this.c = f;
        this.d = bool;
        this.e = dwjVar;
        this.f = bool2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ehd)) {
            return false;
        }
        ehd ehdVar = (ehd) obj;
        return nullSafeIsEqual(this.a, ehdVar.a) && nullSafeIsEqual(this.b, ehdVar.b)
                && nullSafeIsEqual(this.c, ehdVar.c) && nullSafeIsEqual(this.d, ehdVar.d)
                && nullSafeIsEqual(this.e, ehdVar.e) && nullSafeIsEqual(this.f, ehdVar.f);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Float f = this.c;
        int iHashCode3 = (iHashCode2 + (f == null ? 0 : f.hashCode())) * 31;
        Boolean bool = this.d;
        int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        dwj dwjVar = this.e;
        int iHashCode5 = (iHashCode4 + (dwjVar == null ? 0 : dwjVar.hashCode())) * 31;
        Boolean bool2 = this.f;
        return iHashCode5 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("w10Proto(key=" /* "w10Proto(key=" /* "w10Proto(key=" /* cnb.z(-300407192550186L)  */);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.a, -300329883138858L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.b, -300295523400490L);
        bjs.v(sb, this.c, -300256868694826L);
        dts.g(sb, this.d, -300703545293610L);
        dts.h(sb, this.e, -300630530849578L);
        sb.append(this.f);
        sb.append(')');
        return sb.toString();
    }
}
