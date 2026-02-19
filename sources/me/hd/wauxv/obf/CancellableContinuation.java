package me.hd.wauxv.obf;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class CancellableContinuation extends aot implements afw, ahr {
    public static final /* synthetic */ AtomicIntegerFieldUpdater a = AtomicIntegerFieldUpdater.newUpdater(CancellableContinuation.class,
            "_decisionAndIndex$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater d = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuation.class,
            Object.class, "_state$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuation.class,
            Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ int _decisionAndIndex$volatile;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;
    public final afw f;
    public final ahh g;

    public CancellableContinuation(afw afwVar) {
        super(1);
        this.f = afwVar;
        this.g = afwVar.c();
        this._decisionAndIndex$volatile = 536870911;
        this._state$volatile = db.a;
    }

    public static void h(sz szVar, Object obj) {
        throw new IllegalStateException(
                ("It's prohibited to register multiple handlers, tried to register " + szVar + ", already has " + obj)
                        .toString());
    }

    public static void i(CancellableContinuation cancellableContinuationVar, Object obj, int i) throws aoq {
        Object abpVar;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = d;
            Object obj2 = atomicReferenceFieldUpdater.get(cancellableContinuationVar);
            if (!(obj2 instanceof coo)) {
                if (obj2 instanceof td) {
                    if (td.a.compareAndSet((td) obj2, 0, 1)) {
                        return;
                    }
                }
                throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
            }
            coo cooVar = (coo) obj2;
            if (!(obj instanceof abr) && ((i == 1 || i == 2) && (cooVar instanceof sz))) {
                abpVar = new abp(obj, cooVar instanceof sz ? (sz) cooVar : null, null, 16);
            } else {
                abpVar = obj;
            }
            do {
                if (atomicReferenceFieldUpdater.compareAndSet(cancellableContinuationVar, obj2, abpVar)) {
                    if (!cancellableContinuationVar.v()) {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = e;
                        aox aoxVar = (aox) atomicReferenceFieldUpdater2.get(cancellableContinuationVar);
                        if (aoxVar != null) {
                            aoxVar.e();
                            atomicReferenceFieldUpdater2.set(cancellableContinuationVar, con.b);
                        }
                    }
                    cancellableContinuationVar.r(i);
                    return;
                }
            } while (atomicReferenceFieldUpdater.get(cancellableContinuationVar) == obj2);
        }
    }

    @Override // me.hd.wauxv.obf.afw
    public final void _bn(Object obj) throws aoq {
        Throwable thB = Success.exceptionOrNull(obj);
        if (thB != null) {
            obj = new abr(thB, false);
        }
        i(this, obj, this.z);
    }

    @Override // me.hd.wauxv.obf.afw
    public final ahh c() {
        return this.g;
    }

    @Override // me.hd.wauxv.obf.aot
    public final void j(CancellationException cancellationException) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = d;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof coo) {
                throw new IllegalStateException("Not completed");
            }
            if (obj instanceof abr) {
                return;
            }
            sz szVar = null;
            if (!(obj instanceof abp)) {
                abp abpVar = new abp(obj, szVar, cancellationException, 14);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, abpVar)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                    }
                }
                return;
            }
            abp abpVar2 = (abp) obj;
            if (abpVar2.e != null) {
                throw new IllegalStateException("Must be called at most once");
            }
            abp abpVarF = abp.f(abpVar2, null, cancellationException, 15);
            do {
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj, abpVarF)) {
                    sz szVar2 = abpVar2.b;
                    if (szVar2 != null) {
                        p(szVar2, cancellationException);
                    }
                    bgk bgkVar = abpVar2.c;
                    if (bgkVar != null) {
                        Object obj2 = abpVar2.a;
                        ahh ahhVar = this.g;
                        try {
                            bgkVar.b(cancellationException, obj2, ahhVar);
                            return;
                        } catch (Throwable th) {
                            cna.z(ahhVar, new QueryDidNotReturnUniqueResultRuntimeException(
                                    "Exception in resume onCancellation handler for " + this, th));
                            return;
                        }
                    }
                    return;
                }
            } while (atomicReferenceFieldUpdater.get(this) == obj);
        }
    }

    @Override // me.hd.wauxv.obf.ahr
    public final ahr k() {
        afw afwVar = this.f;
        if (afwVar instanceof ahr) {
            return (ahr) afwVar;
        }
        return null;
    }

    @Override // me.hd.wauxv.obf.aot
    public final afw l() {
        return this.f;
    }

    @Override // me.hd.wauxv.obf.aot
    public final Throwable m(Object obj) {
        Throwable thM = super.m(obj);
        if (thM != null) {
            return thM;
        }
        return null;
    }

    @Override // me.hd.wauxv.obf.aot
    public final Object n(Object obj) {
        return obj instanceof abp ? ((abp) obj).a : obj;
    }

    @Override // me.hd.wauxv.obf.aot
    public final Object o() {
        return d.get(this);
    }

    public final void p(sz szVar, Throwable th) {
        try {
            switch (szVar.a) {
                case 0:
                    ((bka) szVar.b).invoke(th);
                    break;
                default:
                    ((aox) szVar.b).e();
                    break;
            }
        } catch (Throwable th2) {
            cna.z(this.g, new QueryDidNotReturnUniqueResultRuntimeException(
                    "Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void q(Throwable th) throws aoq {
        Throwable cancellationException;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = d;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof coo)) {
                return;
            }
            boolean z = obj instanceof sz;
            if (th == null) {
                cancellationException = new CancellationException("Continuation " + this + " was cancelled normally");
            } else {
                cancellationException = th;
            }
            td tdVar = new td(cancellationException, z);
            do {
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj, tdVar)) {
                    if (((coo) obj) instanceof sz) {
                        p((sz) obj, th);
                    }
                    if (!v()) {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = e;
                        aox aoxVar = (aox) atomicReferenceFieldUpdater2.get(this);
                        if (aoxVar != null) {
                            aoxVar.e();
                            atomicReferenceFieldUpdater2.set(this, con.b);
                        }
                    }
                    r(this.z);
                    return;
                }
            } while (atomicReferenceFieldUpdater.get(this) == obj);
        }
    }

    public final void r(int i) throws aoq {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i2;
        do {
            atomicIntegerFieldUpdater = a;
            i2 = atomicIntegerFieldUpdater.get(this);
            int i3 = i2 >> 29;
            if (i3 != 0) {
                if (i3 != 1) {
                    throw new IllegalStateException("Already resumed");
                }
                boolean z = i == 4;
                afw afwVar = this.f;
                if (!z && (afwVar instanceof DispatchedContinuation)) {
                    boolean z2 = i == 1 || i == 2;
                    int i4 = this.z;
                    if (z2 == (i4 == 1 || i4 == 2)) {
                        DispatchedContinuation dispatchedContinuationVar = (DispatchedContinuation) afwVar;
                        Dispatcher dispatcherVar = dispatchedContinuationVar.d;
                        ahh ahhVar = dispatchedContinuationVar.e.m;
                        throwIfVar1IsNull(ahhVar);
                        try {
                            if (dispatcherVar.j(ahhVar)) {
                                HugeSyntheticPileOfHelpers.bl(dispatcherVar, ahhVar, this);
                                return;
                            }
                            awv awvVarB = dro.b();
                            if (awvVarB.x >= 4294967296L) {
                                km kmVar = awvVarB.z;
                                if (kmVar == null) {
                                    kmVar = new km();
                                    awvVarB.z = kmVar;
                                }
                                kmVar.addLast(this);
                                return;
                            }
                            awvVarB.ab(true);
                            try {
                                bhv.ah(this, afwVar, true);
                                do {
                                } while (awvVarB.ac());
                            } catch (Throwable th) {
                                try {
                                    aa(th);
                                } finally {
                                    awvVarB.aa();
                                }
                            }
                            return;
                        } catch (Throwable th2) {
                            throw new aoq(th2, dispatcherVar, ahhVar);
                        }
                    }
                }
                bhv.ah(this, afwVar, z);
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i2, 1073741824 + (536870911 & i2)));
    }

    public Throwable s(brm brmVar) {
        return brmVar.n();
    }

    public final Object t() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i;
        brf brfVar;
        boolean zV = v();
        do {
            atomicIntegerFieldUpdater = a;
            i = atomicIntegerFieldUpdater.get(this);
            int i2 = i >> 29;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new IllegalStateException("Already suspended");
                }
                if (zV) {
                    x();
                }
                Object obj = d.get(this);
                if (obj instanceof abr) {
                    throw ((abr) obj).c;
                }
                int i3 = this.z;
                if ((i3 != 1 && i3 != 2) || (brfVar = (brf) this.g._w(arj.i)) == null || brfVar.m()) {
                    return n(obj);
                }
                CancellationException cancellationExceptionN = brfVar.n();
                j(cancellationExceptionN);
                throw cancellationExceptionN;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, 536870912 + (536870911 & i)));
        if (((aox) e.get(this)) == null) {
            u();
        }
        if (zV) {
            x();
        }
        return ahq.a;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(w());
        sb.append('(');
        sb.append(ajn.ah(this.f));
        sb.append("){");
        Object obj = d.get(this);
        sb.append(obj instanceof coo ? "Active" : obj instanceof td ? "Cancelled" : "Completed");
        sb.append("}@");
        sb.append(ajn.toHexHashCode(this));
        return sb.toString();
    }

    public final aox u() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        brf brfVar = (brf) this.g._w(arj.i);
        if (brfVar == null) {
            return null;
        }
        aox aoxVarAa = cna.aa(brfVar, true, new yd(this, 0));
        do {
            atomicReferenceFieldUpdater = e;
            if (atomicReferenceFieldUpdater.compareAndSet(this, null, aoxVarAa)) {
                break;
            }
        } while (atomicReferenceFieldUpdater.get(this) == null);
        return aoxVarAa;
    }

    public final boolean v() {
        if (this.z != 2) {
            return false;
        }
        afw afwVar = this.f;
        throwIfVar1IsNull(afwVar,
                "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return DispatchedContinuation.a.get((DispatchedContinuation) afwVar) != null;
    }

    public String w() {
        return "CancellableContinuation";
    }

    public final void x() throws aoq {
        afw afwVar = this.f;
        Throwable th = null;
        DispatchedContinuation dispatchedContinuationVar = afwVar instanceof DispatchedContinuation ? (DispatchedContinuation) afwVar : null;
        if (dispatchedContinuationVar != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = DispatchedContinuation.a;
            loop0: while (true) {
                Object obj = atomicReferenceFieldUpdater.get(dispatchedContinuationVar);
                SpecificEmojiMatcher specificEmojiMatcherVar = HugeSyntheticPileOfHelpers.af;
                if (obj != specificEmojiMatcherVar) {
                    if (!(obj instanceof Throwable)) {
                        throw new IllegalStateException(("Inconsistent state " + obj).toString());
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(dispatchedContinuationVar, obj, null)) {
                        if (atomicReferenceFieldUpdater.get(dispatchedContinuationVar) != obj) {
                            throw new IllegalArgumentException("Failed requirement.");
                        }
                    }
                    th = (Throwable) obj;
                    break;
                }
                do {
                    if (atomicReferenceFieldUpdater.compareAndSet(dispatchedContinuationVar, specificEmojiMatcherVar, this)) {
                        break loop0;
                    }
                } while (atomicReferenceFieldUpdater.get(dispatchedContinuationVar) == specificEmojiMatcherVar);
            }
            if (th == null) {
                return;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = e;
            aox aoxVar = (aox) atomicReferenceFieldUpdater2.get(this);
            if (aoxVar != null) {
                aoxVar.e();
                atomicReferenceFieldUpdater2.set(this, con.b);
            }
            q(th);
        }
    }

    public final void y(Dispatcher dispatcherVar) throws aoq {
        afw afwVar = this.f;
        DispatchedContinuation dispatchedContinuationVar = afwVar instanceof DispatchedContinuation ? (DispatchedContinuation) afwVar : null;
        i(this, Kotlin$Unit.INSTANCE, (dispatchedContinuationVar != null ? dispatchedContinuationVar.d : null) == dispatcherVar ? 4 : this.z);
    }
}
