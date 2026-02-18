package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cnj {
    public final eme a;

    public final boolean equals(Object obj) {
        if (obj instanceof cnj) {
            return bzo.f(this.a, ((cnj) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "RequestKType(value=" + this.a + ')';
    }
}
