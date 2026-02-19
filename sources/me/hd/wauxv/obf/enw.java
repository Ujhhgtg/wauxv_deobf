package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class enw extends Dispatcher {
    public static final enw f = new enw();

    @Override // me.hd.wauxv.obf.ahj
    public final void i(ahh ahhVar, Runnable runnable) {
        alc.f.g.m(runnable, true);
    }

    @Override // me.hd.wauxv.obf.ahj
    public final Dispatcher k(int i) {
        bhs.n(i);
        return i >= dqb.d ? this : super.k(i);
    }

    @Override // me.hd.wauxv.obf.ahj
    public final String toString() {
        return "Dispatchers.IO";
    }
}
