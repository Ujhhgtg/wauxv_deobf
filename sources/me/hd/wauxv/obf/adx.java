package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class adx {
    public final String a;
    public final String b;
    public final String c;
    public boolean d;

    public adx(String str, String str2, String str3, boolean z) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof adx)) {
            return false;
        }
        adx adxVar = (adx) obj;
        return nullSafeIsEqual(this.a, adxVar.a) && nullSafeIsEqual(this.b, adxVar.b)
                && nullSafeIsEqual(this.c, adxVar.c) && this.d == adxVar.d;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.d) + bjs.e(this.c, bjs.e(this.b, this.a.hashCode() * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ContactInfo(id=" /* cnb.z(-394230753131306L) */);
        yg.u(sb, this.a, -394711789468458L);
        yg.u(sb, this.b, -394677429730090L);
        yg.u(sb, this.c, -394643069991722L);
        sb.append(this.d);
        sb.append(')');
        return sb.toString();
    }
}
