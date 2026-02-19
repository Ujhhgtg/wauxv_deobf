package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class abq implements kotlinx$coroutines$internal$DispatchedContinuation {
    public static final abq a = new abq();

    @Override // me.hd.wauxv.obf.afw
    public final void _bn(Object obj) {
        throw new IllegalStateException("This continuation is already complete");
    }

    @Override // me.hd.wauxv.obf.afw
    public final ahh c() {
        throw new IllegalStateException("This continuation is already complete");
    }

    public final String toString() {
        return "This continuation is already complete";
    }
}
