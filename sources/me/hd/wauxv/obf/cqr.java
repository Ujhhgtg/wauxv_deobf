package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cqr implements tb {
    public final bdx a;
    public final /* synthetic */ cqt b;

    public cqr(cqt cqtVar, bdx bdxVar) {
        bzo.q(bdxVar, "onBackPressedCallback");
        this.b = cqtVar;
        this.a = bdxVar;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [me.hd.wauxv.obf.bfu, me.hd.wauxv.obf.bgr] */
    @Override // me.hd.wauxv.obf.tb
    public final void cancel() {
        cqt cqtVar = this.b;
        km kmVar = cqtVar.b;
        bdx bdxVar = this.a;
        kmVar.remove(bdxVar);
        if (bzo.f(cqtVar.c, bdxVar)) {
            bdxVar.f();
            cqtVar.c = null;
        }
        bdxVar.b.remove(this);
        ?? r0 = bdxVar.c;
        if (r0 != 0) {
            r0.invoke();
        }
        bdxVar.c = null;
    }
}
