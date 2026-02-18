package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bsj implements btd {
    public static final bsj b = new bsj();
    public static final dfz d = dqc.ax("kotlinx.serialization.json.JsonNull", dga.b, new dfx[0]);

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        cnb.n(ajtVar);
        if (ajtVar.x()) {
            throw new brv("Expected 'null' literal");
        }
        return bsi.INSTANCE;
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        bzo.q((bsi) obj, "value");
        cnb.l(avtVar);
        avtVar.q();
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return d;
    }
}
