package me.hd.wauxv.obf;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class com extends u implements brf {
    public static final com f = new com(arj.i);

    @Override // me.hd.wauxv.obf.brf
    public final boolean m() {
        return true;
    }

    @Override // me.hd.wauxv.obf.brf
    public final CancellationException n() {
        throw new IllegalStateException("This job is always active");
    }

    @Override // me.hd.wauxv.obf.brf
    public final ye o(brm brmVar) {
        return con.b;
    }

    @Override // me.hd.wauxv.obf.brf
    public final aox p(boolean z, boolean z2, brh brhVar) {
        return con.b;
    }

    @Override // me.hd.wauxv.obf.brf
    public final void q(CancellationException cancellationException) {
    }

    @Override // me.hd.wauxv.obf.brf
    public final boolean start() {
        return false;
    }

    public final String toString() {
        return "NonCancellable";
    }
}
