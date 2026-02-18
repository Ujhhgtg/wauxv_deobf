package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bvw extends p {
    public final bvu h;
    public boolean i;
    public int j;

    public bvw(bvu bvuVar) {
        this.h = bvuVar;
    }

    @Override // me.hd.wauxv.obf.p
    public final boolean b(pd pdVar) {
        if (!(pdVar instanceof bwb)) {
            return false;
        }
        if (this.i && this.j == 1) {
            this.h.e = false;
            this.i = false;
        }
        return true;
    }

    @Override // me.hd.wauxv.obf.p
    public final pd d() {
        return this.h;
    }

    @Override // me.hd.wauxv.obf.p
    public final boolean e() {
        return true;
    }

    @Override // me.hd.wauxv.obf.p
    public final pf g(aph aphVar) {
        if (aphVar.j) {
            this.i = true;
            this.j = 0;
        } else if (this.i) {
            this.j++;
        }
        return pf.d(aphVar.d);
    }
}
