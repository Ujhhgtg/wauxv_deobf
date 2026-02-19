package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ehg {
    public static final ehf Companion = new ehf();
    public final String a;
    public final Float b;
    public final Float c;

    public /* synthetic */ ehg(int i, String str, Float f, Float f2) {
        if (7 != (i & 7)) {
            ResourcesCompat.ah(i, 7, ehe.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = f;
        this.c = f2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ehg)) {
            return false;
        }
        ehg ehgVar = (ehg) obj;
        return nullSafeIsEqual(this.a, ehgVar.a) && nullSafeIsEqual(this.b, ehgVar.b)
                && nullSafeIsEqual(this.c, ehgVar.c);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Float f = this.b;
        int iHashCode2 = (iHashCode + (f == null ? 0 : f.hashCode())) * 31;
        Float f2 = this.c;
        return iHashCode2 + (f2 != null ? f2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("w12Proto(poiClassifyId=" /* "w12Proto(poiClassifyId=" /* "w12Proto(poiClassifyId=" /* "w12Proto(poiClassifyId=" /* cnb.z(-306716499508010L)   */);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.a, -306613420292906L);
        bjs.v(sb, this.b, -306540405848874L);
        sb.append(this.c);
        sb.append(')');
        return sb.toString();
    }
}
