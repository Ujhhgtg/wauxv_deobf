package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class brk extends bri {
    public final brm a;
    public final brl f;
    public final yf i;
    public final Object j;

    public brk(brm brmVar, brl brlVar, yf yfVar, Object obj) {
        this.a = brmVar;
        this.f = brlVar;
        this.i = yfVar;
        this.j = obj;
    }

    @Override // me.hd.wauxv.obf.bri
    public final boolean _ba() {
        return false;
    }

    @Override // me.hd.wauxv.obf.bri
    public final void d(Throwable th) {
        yf yfVar = this.i;
        yf yfVarT = brm.t(yfVar);
        brm brmVar = this.a;
        brl brlVar = this.f;
        Object obj = this.j;
        if (yfVarT == null || !brmVar.ap(brlVar, yfVarT, obj)) {
            brlVar.f.n(new bwa(2), 2);
            yf yfVarT2 = brm.t(yfVar);
            if (yfVarT2 == null || !brmVar.ap(brlVar, yfVarT2, obj)) {
                brmVar.j(brmVar.aa(brlVar, obj));
            }
        }
    }
}
