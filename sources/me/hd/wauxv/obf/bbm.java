package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bbm implements btd {
    public static final bbm b = new bbm();
    public static final cvo d = new cvo("kotlin.Float", cvm.o);

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        return Float.valueOf(ajtVar.aa());
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        avtVar.y(((Number) obj).floatValue());
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return d;
    }
}
