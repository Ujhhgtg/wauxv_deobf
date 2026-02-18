package me.hd.wauxv.obf;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ai extends emc {
    public final AtomicReferenceFieldUpdater a;
    public final AtomicReferenceFieldUpdater b;
    public final AtomicReferenceFieldUpdater c;
    public final AtomicReferenceFieldUpdater d;
    public final AtomicReferenceFieldUpdater e;

    public ai(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
        super(3);
        this.a = atomicReferenceFieldUpdater;
        this.b = atomicReferenceFieldUpdater2;
        this.c = atomicReferenceFieldUpdater3;
        this.d = atomicReferenceFieldUpdater4;
        this.e = atomicReferenceFieldUpdater5;
    }

    @Override // me.hd.wauxv.obf.emc
    public final boolean f(al alVar, ah ahVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.d;
            if (atomicReferenceFieldUpdater.compareAndSet(alVar, ahVar, ah.a)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(alVar) == ahVar);
        return false;
    }

    @Override // me.hd.wauxv.obf.emc
    public final boolean g(al alVar, Object obj, Object obj2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.e;
            if (atomicReferenceFieldUpdater.compareAndSet(alVar, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(alVar) == obj);
        return false;
    }

    @Override // me.hd.wauxv.obf.emc
    public final boolean h(al alVar, ak akVar, ak akVar2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.c;
            if (atomicReferenceFieldUpdater.compareAndSet(alVar, akVar, akVar2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(alVar) == akVar);
        return false;
    }

    @Override // me.hd.wauxv.obf.emc
    public final void i(ak akVar, ak akVar2) {
        this.b.lazySet(akVar, akVar2);
    }

    @Override // me.hd.wauxv.obf.emc
    public final void j(ak akVar, Thread thread) {
        this.a.lazySet(akVar, thread);
    }
}
