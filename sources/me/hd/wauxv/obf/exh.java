package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class exh {
    public final exa a;

    public exh(exa exaVar) {
        this.a = exaVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof exh) && bzo.f(this.a, ((exh) obj).a);
    }

    public final int hashCode() {
        exa exaVar = this.a;
        if (exaVar == null) {
            return 0;
        }
        return exaVar.hashCode();
    }

    public final String toString() {
        return "YukiHookResult(hookedMember=" + this.a + ")";
    }
}
