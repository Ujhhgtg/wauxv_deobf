package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dlb {
    public final dhr a;
    public bgs b;

    public dlb(dhr dhrVar, bgs bgsVar) {
        bzo.q(bgsVar, "score");
        this.a = dhrVar;
        this.b = bgsVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dlb)) {
            return false;
        }
        dlb dlbVar = (dlb) obj;
        return bzo.f(this.a, dlbVar.a) && bzo.f(this.b, dlbVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "SortedCompletionItem(completionItem=" + this.a + ", score=" + this.b + ")";
    }
}
