package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class aul implements bfu {
    public final /* synthetic */ int a;
    public final /* synthetic */ cee b;

    public /* synthetic */ aul(cee ceeVar, int i) {
        this.a = i;
        this.b = ceeVar;
    }

    @Override // me.hd.wauxv.obf.bfu
    public final Object invoke() {
        switch (this.a) {
            case 0:
                aum.a.u(String.valueOf(this.b.c.getText()));
                break;
            case 1:
                azq.a.u(String.valueOf(this.b.c.getText()));
                break;
            case 2:
                dip.a.u(String.valueOf(this.b.c.getText()));
                break;
            case 3:
                eta.a.u(String.valueOf(this.b.c.getText()));
                break;
            case 4:
                etf.a.u(String.valueOf(this.b.c.getText()));
                break;
            default:
                etv.a.u(String.valueOf(this.b.c.getText()));
                break;
        }
        return ens.a;
    }
}
