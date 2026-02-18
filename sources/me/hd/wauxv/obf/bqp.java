package me.hd.wauxv.obf;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bqp extends bri {
    public static final /* synthetic */ AtomicIntegerFieldUpdater a = AtomicIntegerFieldUpdater.newUpdater(bqp.class, "_invoked$volatile");
    private volatile /* synthetic */ int _invoked$volatile;
    public final brh f;

    public bqp(brh brhVar) {
        this.f = brhVar;
    }

    @Override // me.hd.wauxv.obf.bri
    public final boolean _ba() {
        return true;
    }

    @Override // me.hd.wauxv.obf.bri
    public final void d(Throwable th) {
        if (a.compareAndSet(this, 0, 1)) {
            this.f.invoke(th);
        }
    }
}
