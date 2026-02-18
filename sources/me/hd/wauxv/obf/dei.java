package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dei implements bul, AutoCloseable {
    public final String a;
    public final deh b;
    public boolean c;

    public dei(String str, deh dehVar) {
        this.a = str;
        this.b = dehVar;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
    }

    public final void d(but butVar, bur burVar) {
        throwIfVar1IsNull(butVar, "registry");
        throwIfVar1IsNull(burVar, "lifecycle");
        if (this.c) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        this.c = true;
        burVar.j(this);
        butVar.ad(this.a, (bdv) this.b.a.e);
    }

    @Override // me.hd.wauxv.obf.bul
    public final void e(bup bupVar, bug bugVar) {
        if (bugVar == bug.ON_DESTROY) {
            this.c = false;
            bupVar.ap().o(this);
        }
    }
}
