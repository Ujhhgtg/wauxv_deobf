package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class pv implements btd {
    public static final pv b = new pv();
    public static final cvo d = new cvo("kotlin.Boolean", cvm.a);

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        return Boolean.valueOf(ajtVar.q());
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        avtVar.w(((Boolean) obj).booleanValue());
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return d;
    }
}
