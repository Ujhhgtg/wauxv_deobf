package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class wz {
    public final int a;
    public final String b;
    public final bfu c;

    public wz(int i, String str, bfu bfuVar) {
        this.a = i;
        this.b = str;
        this.c = bfuVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof wz)) {
            return false;
        }
        wz wzVar = (wz) obj;
        return this.a == wzVar.a && nullSafeIsEqual(this.b, wzVar.b) && nullSafeIsEqual(this.c, wzVar.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + bjs.e(this.b, Integer.hashCode(this.a) * 31, 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MenuBean(iconId=" /* cnb.z(-549291957418794L) */);
        dkz.ac(sb, this.a, -549218942974762L);
        yg.u(sb, this.b, -549747223952170L);
        sb.append(this.c);
        sb.append(')');
        return sb.toString();
    }
}
