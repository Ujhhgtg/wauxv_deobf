package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cqq implements bul, tb {
    public final bur a;
    public final bdx b;
    public cqr c;
    public final /* synthetic */ cqt d;

    public cqq(cqt cqtVar, bur burVar, bdx bdxVar) {
        throwIfVar1IsNull(burVar, "lifecycle");
        throwIfVar1IsNull(bdxVar, "onBackPressedCallback");
        this.d = cqtVar;
        this.a = burVar;
        this.b = bdxVar;
        burVar.j(this);
    }

    @Override // me.hd.wauxv.obf.tb
    public final void cancel() {
        this.a.o(this);
        this.b.b.remove(this);
        cqr cqrVar = this.c;
        if (cqrVar != null) {
            cqrVar.cancel();
        }
        this.c = null;
    }

    @Override // me.hd.wauxv.obf.bul
    public final void e(bup bupVar, LifeEventEnum lifeEventEnumVar) {
        if (lifeEventEnumVar == LifeEventEnum.ON_START) {
            bdx bdxVar = this.b;
            throwIfVar1IsNull(bdxVar, "onBackPressedCallback");
            cqt cqtVar = this.d;
            cqtVar.b.addLast(bdxVar);
            cqr cqrVar = new cqr(cqtVar, bdxVar);
            bdxVar.b.add(cqrVar);
            cqtVar.k();
            bdxVar.c = new cqs(0, cqtVar, cqt.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0, 0, 1);
            this.c = cqrVar;
            return;
        }
        if (lifeEventEnumVar != LifeEventEnum.ON_STOP) {
            if (lifeEventEnumVar == LifeEventEnum.ON_DESTROY) {
                cancel();
            }
        } else {
            cqr cqrVar2 = this.c;
            if (cqrVar2 != null) {
                cqrVar2.cancel();
            }
        }
    }
}
