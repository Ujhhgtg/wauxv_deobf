package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bye implements cut {
    public final byf a;
    public int b;
    public Class c;

    public bye(byf byfVar) {
        this.a = byfVar;
    }

    @Override // me.hd.wauxv.obf.cut
    public final void d() {
        this.a.i(this);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof bye) {
            bye byeVar = (bye) obj;
            if (this.b == byeVar.b && this.c == byeVar.c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.b * 31;
        Class cls = this.c;
        return i + (cls != null ? cls.hashCode() : 0);
    }

    public final String toString() {
        return "Key{size=" + this.b + "array=" + this.c + '}';
    }
}
