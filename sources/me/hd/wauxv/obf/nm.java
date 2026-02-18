package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class nm {
    public static final nl Companion = new nl();
    public final int a;
    public final ddv b;

    public /* synthetic */ nm(int i, int i2, ddv ddvVar) {
        if (3 != (i & 3)) {
            bht.ah(i, 3, nk.b.getDescriptor());
            throw null;
        }
        this.a = i2;
        this.b = ddvVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof nm)) {
            return false;
        }
        nm nmVar = (nm) obj;
        return this.a == nmVar.a && bzo.f(this.b, nmVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (Integer.hashCode(this.a) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BaseResponse(ret=" /* cnb.z(-123725122894634L) */);
        dkz.ac(sb, this.a, -124146029689642L);
        sb.append(this.b);
        sb.append(')');
        return sb.toString();
    }
}
