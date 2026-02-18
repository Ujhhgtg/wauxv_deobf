package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bwq extends bwr implements bul {
    public final bup b;
    public final /* synthetic */ chv c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bwq(chv chvVar, bdj bdjVar, bet betVar) {
        super(chvVar, betVar);
        this.c = chvVar;
        this.b = bdjVar;
    }

    @Override // me.hd.wauxv.obf.bwr
    public final boolean a() {
        return this.b.ap().c.compareTo(buh.d) >= 0;
    }

    @Override // me.hd.wauxv.obf.bwr
    public final void d() {
        this.b.ap().o(this);
    }

    @Override // me.hd.wauxv.obf.bul
    public final void e(bup bupVar, bug bugVar) {
        bup bupVar2 = this.b;
        buh buhVar = bupVar2.ap().c;
        if (buhVar != buh.a) {
            buh buhVar2 = null;
            while (buhVar2 != buhVar) {
                k(a());
                buhVar2 = buhVar;
                buhVar = bupVar2.ap().c;
            }
            return;
        }
        chv chvVar = this.c;
        chvVar.getClass();
        chv.k("removeObserver");
        bwr bwrVar = (bwr) chvVar.c.c(this.g);
        if (bwrVar == null) {
            return;
        }
        bwrVar.d();
        bwrVar.k(false);
    }

    @Override // me.hd.wauxv.obf.bwr
    public final boolean f(bdj bdjVar) {
        return this.b == bdjVar;
    }
}
