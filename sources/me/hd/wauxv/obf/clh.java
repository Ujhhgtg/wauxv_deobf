package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class clh extends btp implements IFunction0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ clj b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ clh(clj cljVar, int i) {
        super(0);
        this.a = i;
        this.b = cljVar;
    }

    @Override // me.hd.wauxv.obf.bfu
    public final Object invoke() {
        switch (this.a) {
            case 0:
                clj cljVar = this.b;
                return emc.ah(new cli(cljVar.a.source(), cljVar));
            default:
                return Long.valueOf(this.b.a.contentLength());
        }
    }
}
