package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class elq extends elm {
    public final /* synthetic */ int a;
    public ell b;

    public /* synthetic */ elq() {
        this.a = 1;
    }

    @Override // me.hd.wauxv.obf.elm, me.hd.wauxv.obf.elk
    public void c(ell ellVar) {
        switch (this.a) {
            case 0:
                mi miVar = (mi) this.b;
                miVar.a.remove(ellVar);
                if (!miVar.k()) {
                    miVar.bq(miVar, df.c, false);
                    miVar.ax = true;
                    miVar.bq(miVar, df.b, false);
                }
                break;
        }
    }

    @Override // me.hd.wauxv.obf.elm, me.hd.wauxv.obf.elk
    public void e(ell ellVar) {
        switch (this.a) {
            case 1:
                mi miVar = (mi) this.b;
                int i = miVar.c - 1;
                miVar.c = i;
                if (i == 0) {
                    miVar.d = false;
                    miVar.bl();
                }
                ellVar.n(this);
                break;
            case 2:
                this.b.p();
                ellVar.n(this);
                break;
        }
    }

    @Override // me.hd.wauxv.obf.elm, me.hd.wauxv.obf.elk
    public void g(ell ellVar) {
        switch (this.a) {
            case 1:
                mi miVar = (mi) this.b;
                if (!miVar.d) {
                    miVar.br();
                    miVar.d = true;
                }
                break;
        }
    }

    public /* synthetic */ elq(ell ellVar, int i) {
        this.a = i;
        this.b = ellVar;
    }
}
