package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class enu implements btd {
    public static final enu b = new enu();
    public final /* synthetic */ bzm d = new bzm(1);

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        this.d.a(ajtVar);
        return KotlinUnit.INSTANCE;
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        KotlinUnit kotlinUnitVar = (KotlinUnit) obj;
        throwIfVar1IsNull(kotlinUnitVar, "value");
        this.d.c(avtVar, kotlinUnitVar);
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return this.d.getDescriptor();
    }
}
