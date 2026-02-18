package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class brj extends tc {
    public final alq ab;

    public brj(afw afwVar, alq alqVar) {
        super(afwVar);
        this.ab = alqVar;
    }

    @Override // me.hd.wauxv.obf.tc
    public final Throwable s(brm brmVar) {
        Throwable thH;
        alq alqVar = this.ab;
        alqVar.getClass();
        Object obj = brm.r.get(alqVar);
        return (!(obj instanceof brl) || (thH = ((brl) obj).h()) == null) ? obj instanceof abr ? ((abr) obj).c : brmVar.n() : thH;
    }

    @Override // me.hd.wauxv.obf.tc
    public final String w() {
        return "AwaitContinuation";
    }
}
