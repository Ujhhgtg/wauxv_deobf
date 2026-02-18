package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class si implements btd {
    public static final si b = new si();
    public static final cvo d = new cvo("kotlin.Byte", cvm.b);

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        return Byte.valueOf(ajtVar.y());
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        avtVar.u(((Number) obj).byteValue());
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return d;
    }
}
