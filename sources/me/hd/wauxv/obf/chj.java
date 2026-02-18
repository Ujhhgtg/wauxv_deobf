package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class chj {
    public Class a;
    public Class b;
    public Class c;

    public chj(Class cls, Class cls2, Class cls3) {
        this.a = cls;
        this.b = cls2;
        this.c = cls3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || chj.class != obj.getClass()) {
            return false;
        }
        chj chjVar = (chj) obj;
        return this.a.equals(chjVar.a) && this.b.equals(chjVar.b) && eot.e(this.c, chjVar.c);
    }

    public final int hashCode() {
        int iD = bjs.d(this.a.hashCode() * 31, 31, this.b);
        Class cls = this.c;
        return iD + (cls != null ? cls.hashCode() : 0);
    }

    public final String toString() {
        return "MultiClassKey{first=" + this.a + ", second=" + this.b + '}';
    }
}
