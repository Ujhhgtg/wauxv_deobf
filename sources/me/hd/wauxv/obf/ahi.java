package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ahi implements ahg {
    public final IHasInvokeMethod a;
    public final ahg b;

    public ahi(ahg ahgVar, IHasInvokeMethod bgfVar) {
        throwIfVar1IsNull(ahgVar, "baseKey");
        this.a = bgfVar;
        this.b = ahgVar instanceof ahi ? ((ahi) ahgVar).b : ahgVar;
    }
}
