package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class yf extends bri implements ye {
    public final brm _bb;

    public yf(brm brmVar) {
        this._bb = brmVar;
    }

    @Override // me.hd.wauxv.obf.bri
    public final boolean _ba() {
        return true;
    }

    @Override // me.hd.wauxv.obf.ye
    public final boolean a(Throwable th) {
        return h().x(th);
    }

    @Override // me.hd.wauxv.obf.bri
    public final void d(Throwable th) {
        this._bb.v(h());
    }
}
