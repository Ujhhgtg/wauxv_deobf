package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bwc extends p {
    public final bwb h = new bwb();
    public final int i;
    public boolean j;

    public bwc(int i) {
        this.i = i;
    }

    @Override // me.hd.wauxv.obf.p
    public final boolean b(pd pdVar) {
        if (!this.j) {
            return true;
        }
        pd pdVar2 = (pd) this.h.i;
        if (!(pdVar2 instanceof bvu)) {
            return true;
        }
        ((bvu) pdVar2).e = false;
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
            if (this.h.j == null) {
                return null;
            }
            pd pdVarD = aphVar.y().d();
            this.j = (pdVarD instanceof csr) || (pdVarD instanceof bwb);
            return pf.d(aphVar.g);
        }
        int i = aphVar.i;
        int i2 = this.i;
        if (i >= i2) {
            return new pf(-1, aphVar.e + i2, false);
        }
        return null;
    }
}
