package me.hd.wauxv.obf;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class afx extends nc {
    public final ahh m;
    public transient afw n;

    /*
     * JADX WARN: 'super' call moved to the top of the method (can break code
     * semantics)
     */
    public afx(afw afwVar) {
        super(afwVar);
        ahh ahhVarC = afwVar != null ? afwVar.c() : null;
        this.m = ahhVarC;
    }

    @Override // me.hd.wauxv.obf.afw
    public final ahh c() {
        ahh ahhVar = this.m;
        throwIfVar1IsNull(ahhVar);
        return ahhVar;
    }

    @Override // me.hd.wauxv.obf.nc
    public final void l() {
        afw afwVar = this.n;
        if (afwVar != null && afwVar != this) {
            ahh ahhVar = this.m;
            throwIfVar1IsNull(ahhVar);
            ahf ahfVar_w = ahhVar._w(arj.a);
            throwIfVar1IsNull(ahfVar_w);
            DispatchedContinuation dispatchedContinuationVar = (DispatchedContinuation) afwVar;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = DispatchedContinuation.a;
            while (atomicReferenceFieldUpdater.get(dispatchedContinuationVar) == HugeSyntheticPileOfHelpers.af) {
            }
            Object obj = atomicReferenceFieldUpdater.get(dispatchedContinuationVar);
            CancellableContinuation cancellableContinuationVar = obj instanceof CancellableContinuation ? (CancellableContinuation) obj : null;
            if (cancellableContinuationVar != null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = CancellableContinuation.e;
                aox aoxVar = (aox) atomicReferenceFieldUpdater2.get(cancellableContinuationVar);
                if (aoxVar != null) {
                    aoxVar.e();
                    atomicReferenceFieldUpdater2.set(cancellableContinuationVar, con.b);
                }
            }
        }
        this.n = abq.a;
    }
}
