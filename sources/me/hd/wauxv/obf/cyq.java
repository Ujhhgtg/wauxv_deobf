package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cyq implements IFunction0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ ea b;
    public final /* synthetic */ dab c;

    public /* synthetic */ cyq(ea eaVar, dab dabVar, int i) {
        this.a = i;
        this.b = eaVar;
        this.c = dabVar;
    }

    @Override // me.hd.wauxv.obf.bfu
    public final Object invoke() {
        int iZ;
        switch (this.a) {
            case 0:
                iZ = this.c.z();
                this.b.p();
                break;
            case 1:
                iZ = this.c.y();
                this.b.p();
                break;
            default:
                iZ = this.c.x();
                this.b.p();
                break;
        }
        return Integer.valueOf(iZ);
    }
}
