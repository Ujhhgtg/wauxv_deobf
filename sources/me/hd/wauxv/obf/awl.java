package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class awl implements dcg {
    public final boolean a;
    public final boolean b;
    public final dcg f;
    public final awk g;
    public final btj h;
    public int i;
    public boolean j;

    public awl(dcg dcgVar, boolean z, boolean z2, btj btjVar, awk awkVar) {
        cmz.n(dcgVar, "Argument must not be null");
        this.f = dcgVar;
        this.a = z;
        this.b = z2;
        this.h = btjVar;
        cmz.n(awkVar, "Argument must not be null");
        this.g = awkVar;
    }

    @Override // me.hd.wauxv.obf.dcg
    public final synchronized void c() {
        if (this.i > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.j) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.j = true;
        if (this.b) {
            this.f.c();
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

    public final synchronized void k() {
        if (this.j) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.i++;
    }

    public final void l() {
        boolean z;
        synchronized (this) {
            int i = this.i;
            if (i <= 0) {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
            z = true;
            int i2 = i - 1;
            this.i = i2;
            if (i2 != 0) {
                z = false;
            }
        }
        if (z) {
            ((awd) this.g).n(this.h, this);
        }
    }

    public final synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.a + ", listener=" + this.g + ", key=" + this.h + ", acquired=" + this.i + ", isRecycled=" + this.j + ", resource=" + this.f + '}';
    }
}
