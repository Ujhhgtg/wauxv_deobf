package me.hd.wauxv.obf;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class bxl {
    public static final /* synthetic */ AtomicReferenceFieldUpdater k = AtomicReferenceFieldUpdater
            .newUpdater(bxl.class, Object.class, "_next$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater l = AtomicReferenceFieldUpdater
            .newUpdater(bxl.class, Object.class, "_prev$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater m = AtomicReferenceFieldUpdater
            .newUpdater(bxl.class, Object.class, "_removedRef$volatile");
    private volatile /* synthetic */ Object _next$volatile = this;
    private volatile /* synthetic */ Object _prev$volatile = this;
    private volatile /* synthetic */ Object _removedRef$volatile;

    public final boolean n(bxl bxlVar, int i) {
        while (true) {
            bxl bxlVarO = o();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = l;
            if (bxlVarO == null) {
                Object obj = atomicReferenceFieldUpdater.get(this);
                while (true) {
                    bxlVarO = (bxl) obj;
                    if (!bxlVarO.r()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(bxlVarO);
                }
            }
            if (bxlVarO instanceof bwa) {
                return (((bwa) bxlVarO).a & i) == 0 && bxlVarO.n(bxlVar, i);
            }
            atomicReferenceFieldUpdater.set(bxlVar, bxlVarO);
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = k;
            atomicReferenceFieldUpdater2.set(bxlVar, this);
            do {
                if (atomicReferenceFieldUpdater2.compareAndSet(bxlVarO, this, bxlVar)) {
                    bxlVar.p(this);
                    return true;
                }
            } while (atomicReferenceFieldUpdater2.get(bxlVarO) == this);
        }
    }

    public final bxl o() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Object obj;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = l;
            bxl bxlVar = (bxl) atomicReferenceFieldUpdater2.get(this);
            bxl bxlVar2 = bxlVar;
            while (true) {
                bxl bxlVar3 = null;
                while (true) {
                    atomicReferenceFieldUpdater = k;
                    obj = atomicReferenceFieldUpdater.get(bxlVar2);
                    if (obj == this) {
                        if (bxlVar == bxlVar2) {
                            return bxlVar2;
                        }
                        while (!atomicReferenceFieldUpdater2.compareAndSet(this, bxlVar, bxlVar2)) {
                            if (atomicReferenceFieldUpdater2.get(this) != bxlVar) {
                                break;
                            }
                        }
                        return bxlVar2;
                    }
                    if (r()) {
                        return null;
                    }
                    if (!(obj instanceof dbf)) {
                        throwIfVar1IsNull(obj,
                                "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
                        bxlVar3 = bxlVar2;
                        bxlVar2 = (bxl) obj;
                    } else {
                        if (bxlVar3 != null) {
                            break;
                        }
                        bxlVar2 = (bxl) atomicReferenceFieldUpdater2.get(bxlVar2);
                    }
                }
                bxl bxlVar4 = ((dbf) obj).a;
                while (!atomicReferenceFieldUpdater.compareAndSet(bxlVar3, bxlVar2, bxlVar4)) {
                    if (atomicReferenceFieldUpdater.get(bxlVar3) != bxlVar2) {
                        break;
                    }
                }
                bxlVar2 = bxlVar3;
            }
        }
    }

    public final void p(bxl bxlVar) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = l;
            bxl bxlVar2 = (bxl) atomicReferenceFieldUpdater.get(bxlVar);
            if (k.get(this) != bxlVar) {
                return;
            }
            do {
                if (atomicReferenceFieldUpdater.compareAndSet(bxlVar, bxlVar2, this)) {
                    if (r()) {
                        bxlVar.o();
                        return;
                    }
                    return;
                }
            } while (atomicReferenceFieldUpdater.get(bxlVar) == bxlVar2);
        }
    }

    public final bxl q() {
        bxl bxlVar;
        Object obj = k.get(this);
        dbf dbfVar = obj instanceof dbf ? (dbf) obj : null;
        if (dbfVar != null && (bxlVar = dbfVar.a) != null) {
            return bxlVar;
        }
        throwIfVar1IsNull(obj,
                "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        return (bxl) obj;
    }

    public boolean r() {
        return k.get(this) instanceof dbf;
    }

    public String toString() {
        return new bxk(this, ajn.class, "classSimpleName", "getClassSimpleName(Ljava/lang/Object;)Ljava/lang/String;",
                1) + '@' + ajn.toHexHashCode(this);
    }
}
