package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bzt {
    public final String a;
    public final bqi b;

    public bzt(String str, bqi bqiVar) {
        this.a = str;
        this.b = bqiVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bzt)) {
            return false;
        }
        bzt bztVar = (bzt) obj;
        return bzo.f(this.a, bztVar.a) && bzo.f(this.b, bztVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "MatchGroup(value=" + this.a + ", range=" + this.b + ')';
    }
}
