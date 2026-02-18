package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aux implements bou {
    public final boolean a;

    public aux(boolean z) {
        this.a = z;
    }

    @Override // me.hd.wauxv.obf.bou
    public final boolean b() {
        return this.a;
    }

    @Override // me.hd.wauxv.obf.bou
    public final cok c() {
        return null;
    }

    public final String toString() {
        return bjs.q(new StringBuilder("Empty{"), this.a ? "Active" : "New", '}');
    }
}
