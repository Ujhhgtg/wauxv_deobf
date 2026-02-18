package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bsf extends bsp {
    public final boolean a;
    public final String b;

    public bsf(String str, boolean z) {
        bzo.q(str, "body");
        this.a = z;
        this.b = str.toString();
    }

    @Override // me.hd.wauxv.obf.bsp
    public final String c() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || bsf.class != obj.getClass()) {
            return false;
        }
        bsf bsfVar = (bsf) obj;
        return this.a == bsfVar.a && bzo.f(this.b, bsfVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (Boolean.hashCode(this.a) * 31);
    }

    @Override // me.hd.wauxv.obf.bsp
    public final String toString() {
        boolean z = this.a;
        String str = this.b;
        if (!z) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        dng.c(sb, str);
        return sb.toString();
    }
}
