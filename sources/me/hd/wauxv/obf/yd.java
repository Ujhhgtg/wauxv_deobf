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
                tc tcVar = (tc) this._az;
                Throwable thS = tcVar.s(h());
                if (tcVar.v()) {
                    aor aorVar = (aor) tcVar.f;
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = aor.a;
                    while (true) {
                        Object obj = atomicReferenceFieldUpdater.get(aorVar);
                        auj aujVar = cnf.af;
                        if (nullSafeIsEqual(obj, aujVar)) {
                            while (!atomicReferenceFieldUpdater.compareAndSet(aorVar, aujVar, thS)) {
                                if (atomicReferenceFieldUpdater.get(aorVar) != aujVar) {
                                }
                            }
                            break;
                        } else if (obj instanceof Throwable) {
                            break;
                        } else {
                            while (true) {
                                if (!atomicReferenceFieldUpdater.compareAndSet(aorVar, obj, null)) {
                                    if (atomicReferenceFieldUpdater.get(aorVar) != obj) {
                                    }
                                }
                            }
                        }
                    }
                }
                tcVar.q(thS);
                if (!tcVar.v()) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = tc.e;
                    aox aoxVar = (aox) atomicReferenceFieldUpdater2.get(tcVar);
                    if (aoxVar != null) {
                        aoxVar.e();
                        atomicReferenceFieldUpdater2.set(tcVar, con.b);
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
                    brjVar._bn(bhu.x(((abr) obj2).c));
                }
                break;
        }
    }
}
