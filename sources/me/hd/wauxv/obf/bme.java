package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class bme implements bgf {
    public final /* synthetic */ int a;
    public final /* synthetic */ bgf b;
    public final /* synthetic */ bmf c;

    public /* synthetic */ bme(bgf bgfVar, bmf bmfVar, int i) {
        this.a = i;
        this.b = bgfVar;
        this.c = bmfVar;
    }

    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) {
        bmm bmmVar = (bmm) obj;
        switch (this.a) {
            case 0:
                if (!this.c.z()) {
                    bmmVar = null;
                }
                if (bmmVar != null) {
                    this.b.invoke(bmmVar);
                }
                break;
            default:
                if (!this.c.z()) {
                    bmmVar = null;
                }
                if (bmmVar != null) {
                    this.b.invoke(bmmVar);
                }
                break;
        }
        return ens.a;
    }
}
