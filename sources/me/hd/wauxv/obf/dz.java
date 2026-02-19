package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dz {
    public int a;
    public int b;
    public int c;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof dz)) {
                return false;
            }
            dz dzVar = (dz) obj;
            int i = this.a;
            if (i != dzVar.a) {
                return false;
            }
            if (i != 8 || Math.abs(this.c - this.b) != 1 || this.c != dzVar.b || this.b != dzVar.c) {
                return this.c == dzVar.c && this.b == dzVar.b;
            }
        }
        return true;
    }

    public final int hashCode() {
        return (((this.a * 31) + this.b) * 31) + this.c;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[");
        int i = this.a;
        sb.append(i != 1 ? i != 2 ? i != 4 ? i != 8 ? "??" : "mv" : com.umeng.analytics.pro.f.R : "rm" : "add");
        sb.append(",s:");
        sb.append(this.b);
        sb.append("c:");
        return yg.concatToVar1(sb, ",p:null]", this.c);
    }
}
