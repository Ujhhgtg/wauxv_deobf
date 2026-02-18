package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cqh extends arj {
    public final bzq aq;
    public final float ar;

    public cqh(bzq bzqVar, float f) {
        this.aq = bzqVar;
        this.ar = f;
    }

    @Override // me.hd.wauxv.obf.arj
    public final boolean ao() {
        return true;
    }

    @Override // me.hd.wauxv.obf.arj
    public final void ap(float f, float f2, float f3, dgw dgwVar) {
        this.aq.ap(f, f2 - this.ar, f3, dgwVar);
    }
}
