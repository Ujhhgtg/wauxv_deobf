package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bfl extends aye {
    public final /* synthetic */ int ab;
    public final /* synthetic */ Object ac;

    public /* synthetic */ bfl(Object obj, int i) {
        this.ab = i;
        this.ac = obj;
    }

    @Override // me.hd.wauxv.obf.aye
    public final void aa() {
        int i = this.ab;
        buh buhVar = buh.c;
        Object obj = this.ac;
        int i2 = 1;
        switch (i) {
            case 0:
                bfp bfpVar = ((bfo) obj).l;
                bfpVar.n = true;
                bfpVar.az(buhVar);
                qp qpVar = bfpVar.j;
                if (qpVar != null) {
                    qpVar.f(bfpVar);
                }
                try {
                    bur burVar = new bfi().a;
                    if (burVar.c != buhVar) {
                        burVar.p(buhVar);
                    }
                    break;
                } catch (Exception unused) {
                }
                ResourcesCompat resourcesCompatVar = anj.a;
                break;
            default:
                cct cctVar = (cct) obj;
                ccu ccuVar = cctVar.o;
                ccuVar.n = true;
                ccuVar.az(buhVar);
                qp qpVar2 = ccuVar.j;
                if (qpVar2 != null) {
                    qpVar2.f(ccuVar);
                }
                ccuVar.getClass();
                bfi bfiVar = new bfi();
                ccu ccuVar2 = ccuVar.bd;
                try {
                    bur burVar2 = bfiVar.a;
                    if (burVar2.c != buhVar) {
                        burVar2.p(buhVar);
                    }
                    break;
                } catch (Exception unused2) {
                }
                ResourcesCompat resourcesCompatVar2 = anj.a;
                ccu ccuVar3 = ccuVar.bd;
                if (ccuVar.be == null) {
                    ccuVar.be = new bfk(cctVar, i2);
                }
                ccuVar.be.aq(ccuVar3);
                ccuVar.o.getClass();
                if (ccuVar.p) {
                    cctVar.h.postDelayed(new dc(this, 12), 300L);
                }
                break;
        }
    }

    @Override // me.hd.wauxv.obf.aye
    public final void z() {
        int i = this.ab;
        Object obj = this.ac;
        buh buhVar = buh.a;
        switch (i) {
            case 0:
                bfo bfoVar = (bfo) obj;
                bfp bfpVar = bfoVar.l;
                bfpVar.n = false;
                try {
                    bur burVar = new bfi().a;
                    if (burVar.c != buhVar) {
                        burVar.p(buhVar);
                    }
                    break;
                } catch (Exception unused) {
                }
                ResourcesCompat resourcesCompatVar = anj.a;
                bfpVar.az(buhVar);
                bfoVar.a = null;
                bfpVar.bg = null;
                break;
            default:
                ccu ccuVar = ((cct) obj).o;
                ccuVar.n = false;
                bfi bfiVar = new bfi();
                ccu ccuVar2 = ccuVar.bd;
                try {
                    bur burVar2 = bfiVar.a;
                    if (burVar2.c != buhVar) {
                        burVar2.p(buhVar);
                    }
                    break;
                } catch (Exception unused2) {
                }
                ResourcesCompat resourcesCompatVar2 = anj.a;
                ccu ccuVar3 = ccuVar.bd;
                ccuVar.az(buhVar);
                ccuVar.getClass();
                break;
        }
    }
}
