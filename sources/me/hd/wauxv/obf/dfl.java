package me.hd.wauxv.obf;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class dfl {
    public static final dfj a = new dfj(new byte[0], 0, 0, false, false);
    public static final int b;
    public static final AtomicReference[] c;

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        b = iHighestOneBit;
        AtomicReference[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i = 0; i < iHighestOneBit; i++) {
            atomicReferenceArr[i] = new AtomicReference();
        }
        c = atomicReferenceArr;
    }

    public static final void d(dfj dfjVar) {
        bzo.q(dfjVar, "segment");
        if (dfjVar.f != null || dfjVar.g != null) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (dfjVar.d) {
            return;
        }
        AtomicReference atomicReference = c[(int) (Thread.currentThread().getId() & (((long) b) - 1))];
        dfj dfjVar2 = a;
        dfj dfjVar3 = (dfj) atomicReference.getAndSet(dfjVar2);
        if (dfjVar3 == dfjVar2) {
            return;
        }
        int i = dfjVar3 != null ? dfjVar3.c : 0;
        if (i >= 65536) {
            atomicReference.set(dfjVar3);
            return;
        }
        dfjVar.f = dfjVar3;
        dfjVar.b = 0;
        dfjVar.c = i + 8192;
        atomicReference.set(dfjVar);
    }

    public static final dfj e() {
        AtomicReference atomicReference = c[(int) (Thread.currentThread().getId() & (((long) b) - 1))];
        dfj dfjVar = a;
        dfj dfjVar2 = (dfj) atomicReference.getAndSet(dfjVar);
        if (dfjVar2 == dfjVar) {
            return new dfj();
        }
        if (dfjVar2 == null) {
            atomicReference.set(null);
            return new dfj();
        }
        atomicReference.set(dfjVar2.f);
        dfjVar2.f = null;
        dfjVar2.c = 0;
        return dfjVar2;
    }
}
