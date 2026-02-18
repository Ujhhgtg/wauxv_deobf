package me.hd.wauxv.obf;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class bxm {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(bxm.class, Object.class, "_cur$volatile");
    private volatile /* synthetic */ Object _cur$volatile = new bxo(8, false);

    public final boolean b(Runnable runnable) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
            bxo bxoVar = (bxo) atomicReferenceFieldUpdater.get(this);
            int iH = bxoVar.h(runnable);
            if (iH == 0) {
                return true;
            }
            if (iH == 1) {
                bxo bxoVarJ = bxoVar.j();
                while (!atomicReferenceFieldUpdater.compareAndSet(this, bxoVar, bxoVarJ) && atomicReferenceFieldUpdater.get(this) == bxoVar) {
                }
            } else if (iH == 2) {
                return false;
            }
        }
    }

    public final void c() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
            bxo bxoVar = (bxo) atomicReferenceFieldUpdater.get(this);
            if (bxoVar.i()) {
                return;
            }
            bxo bxoVarJ = bxoVar.j();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, bxoVar, bxoVarJ) && atomicReferenceFieldUpdater.get(this) == bxoVar) {
            }
        }
    }

    public final int d() {
        bxo bxoVar = (bxo) a.get(this);
        bxoVar.getClass();
        long j = bxo.b.get(bxoVar);
        return (((int) ((j & 1152921503533105152L) >> 30)) - ((int) (1073741823 & j))) & 1073741823;
    }

    public final Object e() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
            bxo bxoVar = (bxo) atomicReferenceFieldUpdater.get(this);
            Object objK = bxoVar.k();
            if (objK != bxo.c) {
                return objK;
            }
            bxo bxoVarJ = bxoVar.j();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, bxoVar, bxoVarJ) && atomicReferenceFieldUpdater.get(this) == bxoVar) {
            }
        }
    }
}
