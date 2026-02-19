package me.hd.wauxv.obf;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class bri extends bxl implements aox, bou {
    public brm g;

    public abstract boolean _ba();

    @Override // me.hd.wauxv.obf.bou
    public final boolean b() {
        return true;
    }

    @Override // me.hd.wauxv.obf.bou
    public final cok c() {
        return null;
    }

    public abstract void d(Throwable th);

    @Override // me.hd.wauxv.obf.aox
    public final void e() {
        brm brmVarH = h();
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = brm.r;
            Object obj = atomicReferenceFieldUpdater.get(brmVarH);
            if (obj instanceof bri) {
                if (obj != this) {
                    return;
                }
                aux auxVar = bhv.p;
                while (!atomicReferenceFieldUpdater.compareAndSet(brmVarH, obj, auxVar)) {
                    if (atomicReferenceFieldUpdater.get(brmVarH) != obj) {
                    }
                }
                return;
            }
            if (!(obj instanceof bou) || ((bou) obj).c() == null) {
                return;
            }
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = bxl.k;
                Object obj2 = atomicReferenceFieldUpdater2.get(this);
                if (obj2 instanceof dbf) {
                    return;
                }
                if (obj2 == this) {
                    return;
                }
                throwIfVar1IsNull(obj2,
                        "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
                bxl bxlVar = (bxl) obj2;
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = bxl.m;
                dbf dbfVar = (dbf) atomicReferenceFieldUpdater3.get(bxlVar);
                if (dbfVar == null) {
                    dbfVar = new dbf(bxlVar);
                    atomicReferenceFieldUpdater3.set(bxlVar, dbfVar);
                }
                do {
                    if (atomicReferenceFieldUpdater2.compareAndSet(this, obj2, dbfVar)) {
                        bxlVar.o();
                        return;
                    }
                } while (atomicReferenceFieldUpdater2.get(this) == obj2);
            }
        }
    }

    public final brm h() {
        brm brmVar = this.g;
        if (brmVar != null) {
            return brmVar;
        }
        throwLateinitPropNotInitYet("job");
        throw null;
    }

    @Override // me.hd.wauxv.obf.bxl
    public final String toString() {
        return getClass().getSimpleName() + '@' + ajn.toHexHashCode(this) + "[job@" + ajn.toHexHashCode(h()) + ']';
    }
}
