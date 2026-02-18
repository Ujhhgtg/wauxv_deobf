package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dil {
    public final int a;
    public final aao b;

    public dil(int i, aao aaoVar) {
        bzo.q(aaoVar, "snippet");
        this.a = i;
        this.b = aaoVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dil)) {
            return false;
        }
        dil dilVar = (dil) obj;
        return this.a == dilVar.a && bzo.f(this.b, dilVar.b);
    }

    public final int hashCode() {
        return Boolean.hashCode(true) + ((this.b.hashCode() + (Integer.hashCode(this.a) * 31)) * 31);
    }

    public final String toString() {
        return "SnippetDescription(selectedLength=" + this.a + ", snippet=" + this.b + ", deleteSelected=true)";
    }
}
