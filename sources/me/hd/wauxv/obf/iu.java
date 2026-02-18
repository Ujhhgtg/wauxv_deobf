package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class iu extends bcy {
    public final /* synthetic */ jb a;
    public final /* synthetic */ je b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public iu(je jeVar, je jeVar2, jb jbVar) {
        super(jeVar2);
        this.b = jeVar;
        this.a = jbVar;
    }

    @Override // me.hd.wauxv.obf.bcy
    public final dho c() {
        return this.a;
    }

    @Override // me.hd.wauxv.obf.bcy
    public final boolean d() {
        je jeVar = this.b;
        if (jeVar.getInternalPopup().e()) {
            return true;
        }
        jeVar.g.n(jeVar.getTextDirection(), jeVar.getTextAlignment());
        return true;
    }
}
