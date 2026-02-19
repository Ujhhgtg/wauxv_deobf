package me.hd.wauxv.obf;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class yd extends bri {
    public final Object _az;
    public final /* synthetic */ int a;

    public /* synthetic */ yd(Object obj, int i) {
        this.a = i;
        this._az = obj;
    }

    @Override // me.hd.wauxv.obf.bri
    public final boolean _ba() {
        switch (this.a) {
            case 0:
                return true;
            case 1:
                return false;
            default:
                return false;
        }
    }

    /*
     * JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object,
     * me.hd.wauxv.obf.bgf]
     */
    @Override // me.hd.wauxv.obf.bri
    public final void d(Throwable th) throws aoq {
        switch (this.a) {
            case 0:
                CancellableContinuation cancellableContinuationVar = (CancellableContinuation) this._az;
                Throwable thS = cancellableContinuationVar.s(h());
                if (cancellableContinuationVar.v()) {
                    DispatchedContinuation dispatchedContinuationVar = (DispatchedContinuation) cancellableContinuationVar.f;
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = DispatchedContinuation.a;
                    while (true) {
                        Object obj = atomicReferenceFieldUpdater.get(dispatchedContinuationVar);
                        SpecificEmojiMatcher specificEmojiMatcherVar = HugeSyntheticPileOfHelpers.af;
                        if (nullSafeIsEqual(obj, specificEmojiMatcherVar)) {
                            while (!atomicReferenceFieldUpdater.compareAndSet(dispatchedContinuationVar, specificEmojiMatcherVar, thS)) {
                                if (atomicReferenceFieldUpdater.get(dispatchedContinuationVar) != specificEmojiMatcherVar) {
                                }
                            }
                            break;
                        } else if (obj instanceof Throwable) {
                            break;
                        } else {
                            while (true) {
                                if (!atomicReferenceFieldUpdater.compareAndSet(dispatchedContinuationVar, obj, null)) {
                                    if (atomicReferenceFieldUpdater.get(dispatchedContinuationVar) != obj) {
                                    }
                                }
                            }
                        }
                    }
                }
                cancellableContinuationVar.q(thS);
                if (!cancellableContinuationVar.v()) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = CancellableContinuation.e;
                    aox aoxVar = (aox) atomicReferenceFieldUpdater2.get(cancellableContinuationVar);
                    if (aoxVar != null) {
                        aoxVar.e();
                        atomicReferenceFieldUpdater2.set(cancellableContinuationVar, con.b);
                        break;
                    }
                }
                break;
            case 1:
                this._az.invoke(th);
                break;
            default:
                brj brjVar = (brj) this._az;
                Object obj2 = brm.r.get(h());
                if (!(obj2 instanceof abr)) {
                    brjVar._bn(bhv.ak(obj2));
                } else {
                    brjVar._bn(FastKV.getFailureFromException(((abr) obj2).c));
                }
                break;
        }
    }
}
