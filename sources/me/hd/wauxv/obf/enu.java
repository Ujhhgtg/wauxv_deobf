package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class enu implements btd {
    public static final enu b = new enu();
    public final /* synthetic */ bzm d = new bzm(1);

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        this.d.a(ajtVar);
        return ens.a;
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        ens ensVar = (ens) obj;
        throwIfVar1IsNull(ensVar, "value");
        this.d.c(avtVar, ensVar);
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return this.d.getDescriptor();
    }
}
