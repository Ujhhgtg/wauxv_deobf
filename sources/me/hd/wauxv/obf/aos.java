package me.hd.wauxv.obf;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aos extends dex {
    public static final /* synthetic */ AtomicIntegerFieldUpdater i = AtomicIntegerFieldUpdater.newUpdater(aos.class, "_decision$volatile");
    private volatile /* synthetic */ int _decision$volatile;

    @Override // me.hd.wauxv.obf.dex, me.hd.wauxv.obf.brm
    public final void j(Object obj) throws aoq {
        l(obj);
    }

    @Override // me.hd.wauxv.obf.dex, me.hd.wauxv.obf.brm
    public final void l(Object obj) throws aoq {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        do {
            atomicIntegerFieldUpdater = i;
            int i2 = atomicIntegerFieldUpdater.get(this);
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("Already resumed");
                }
                cnf.bk(aye.x(obj), cmz.ab(this.aq));
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, 0, 2));
    }
}
