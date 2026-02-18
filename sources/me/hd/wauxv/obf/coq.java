package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class coq implements btd {
    public static final coq b = new coq();
    public static final cop d = cop.a;

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        throw new dgb("'kotlin.Nothing' does not have instances");
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        bzo.q((Void) obj, "value");
        throw new dgb("'kotlin.Nothing' cannot be serialized");
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return d;
    }
}
