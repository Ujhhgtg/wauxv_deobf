package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class abp {
    public final Object a;
    public final sz b;
    public final bgk c;
    public final Object d;
    public final Throwable e;

    public /* synthetic */ abp(Object obj, sz szVar, Throwable th, int i) {
        this(obj, (i & 2) != 0 ? null : szVar, null, null, (i & 16) != 0 ? null : th);
    }

    public static abp f(abp abpVar, sz szVar, Throwable th, int i) {
        Object obj = abpVar.a;
        if ((i & 2) != 0) {
            szVar = abpVar.b;
        }
        sz szVar2 = szVar;
        bgk bgkVar = abpVar.c;
        Object obj2 = abpVar.d;
        if ((i & 16) != 0) {
            th = abpVar.e;
        }
        return new abp(obj, szVar2, bgkVar, obj2, th);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof abp)) {
            return false;
        }
        abp abpVar = (abp) obj;
        return bzo.f(this.a, abpVar.a) && bzo.f(this.b, abpVar.b) && bzo.f(this.c, abpVar.c) && bzo.f(this.d, abpVar.d) && bzo.f(this.e, abpVar.e);
    }

    public final int hashCode() {
        Object obj = this.a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        sz szVar = this.b;
        int iHashCode2 = (iHashCode + (szVar == null ? 0 : szVar.hashCode())) * 31;
        bgk bgkVar = this.c;
        int iHashCode3 = (iHashCode2 + (bgkVar == null ? 0 : bgkVar.hashCode())) * 31;
        Object obj2 = this.d;
        int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.e;
        return iHashCode4 + (th != null ? th.hashCode() : 0);
    }

    public final String toString() {
        return "CompletedContinuation(result=" + this.a + ", cancelHandler=" + this.b + ", onCancellation=" + this.c + ", idempotentResume=" + this.d + ", cancelCause=" + this.e + ')';
    }

    public abp(Object obj, sz szVar, bgk bgkVar, Object obj2, Throwable th) {
        this.a = obj;
        this.b = szVar;
        this.c = bgkVar;
        this.d = obj2;
        this.e = th;
    }
}
