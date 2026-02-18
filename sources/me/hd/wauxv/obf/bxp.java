package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bxp implements dcg, axw {
    public static final jx a = ewz.aw(20, new awp(26));
    public final dmn b = new dmn();
    public dcg f;
    public boolean g;
    public boolean h;

    @Override // me.hd.wauxv.obf.axw
    public final dmn al() {
        return this.b;
    }

    @Override // me.hd.wauxv.obf.dcg
    public final synchronized void c() {
        this.b.b();
        this.h = true;
        if (!this.g) {
            this.f.c();
            this.f = null;
            a.l(this);
        }
    }

    @Override // me.hd.wauxv.obf.dcg
    public final int d() {
        return this.f.d();
    }

    @Override // me.hd.wauxv.obf.dcg
    public final Class e() {
        return this.f.e();
    }

    @Override // me.hd.wauxv.obf.dcg
    public final Object get() {
        return this.f.get();
    }

    public final synchronized void i() {
        this.b.b();
        if (!this.g) {
            throw new IllegalStateException("Already unlocked");
        }
        this.g = false;
        if (this.h) {
            c();
        }
    }
}
