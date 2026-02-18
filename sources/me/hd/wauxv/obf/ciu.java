package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ciu implements IHasInvokeMethod {
    public final /* synthetic */ dag a;
    public final /* synthetic */ dag b;
    public final /* synthetic */ cix c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ km e;

    public /* synthetic */ ciu(dag dagVar, dag dagVar2, cix cixVar, boolean z, km kmVar) {
        this.a = dagVar;
        this.b = dagVar2;
        this.c = cixVar;
        this.d = z;
        this.e = kmVar;
    }

    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) {
        cio cioVar = (cio) obj;
        throwIfVar1IsNull(cioVar, "entry");
        this.a.a = true;
        this.b.a = true;
        this.c.am(cioVar, this.d, this.e);
        return ens.a;
    }
}
