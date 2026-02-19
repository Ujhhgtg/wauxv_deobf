package me.hd.wauxv.obf;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class DispatchedContinuation extends aot implements ahr, afw {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater
            .newUpdater(DispatchedContinuation.class, Object.class, "_reusableCancellableContinuation$volatile");
    private volatile /* synthetic */ Object _reusableCancellableContinuation$volatile;
    public final Dispatcher d;
    public final afx e;
    public Object f;
    public final Object g;

    public DispatchedContinuation(Dispatcher dispatcherVar, afx afxVar) {
        super(-1);
        this.d = dispatcherVar;
        this.e = afxVar;
        this.f = HugeSyntheticPileOfHelpers.ae;
        ahh ahhVar = afxVar.m;
        throwIfVar1IsNull(ahhVar);
        Object obj_u = ahhVar._u(0, bhv.r);
        throwIfVar1IsNull(obj_u);
        this.g = obj_u;
    }

    @Override // me.hd.wauxv.obf.afw
    public final void _bn(Object obj) throws aoq {
        Object objAl;
        Throwable thB = Success.exceptionOrNull(obj);
        Object abrVar = thB == null ? obj : new abr(thB, false);
        Dispatcher dispatcherVar = this.d;
        afx afxVar = this.e;
        ahh ahhVar = afxVar.m;
        throwIfVar1IsNull(ahhVar);
        try {
            if (dispatcherVar.j(ahhVar)) {
                this.f = abrVar;
                this.z = 0;
                throwIfVar1IsNull(ahhVar);
                HugeSyntheticPileOfHelpers.bl(dispatcherVar, ahhVar, this);
                return;
            }
            awv awvVarB = dro.b();
            if (awvVarB.x >= 4294967296L) {
                this.f = abrVar;
                this.z = 0;
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
                throwIfVar1IsNull(ahhVar);
                objAl = bhv.al(ahhVar, this.g);
            } catch (Throwable th) {
                try {
                    aa(th);
                } finally {
                    awvVarB.aa();
                }
            }
            try {
                afxVar._bn(obj);
                bhv.ag(ahhVar, objAl);
                while (awvVarB.ac()) {
                }
            } catch (Throwable th2) {
                bhv.ag(ahhVar, objAl);
                throw th2;
            }
        } catch (Throwable th3) {
            throw new aoq(th3, dispatcherVar, ahhVar);
        }
    }

    @Override // me.hd.wauxv.obf.afw
    public final ahh c() {
        ahh ahhVar = this.e.m;
        throwIfVar1IsNull(ahhVar);
        return ahhVar;
    }

    @Override // me.hd.wauxv.obf.ahr
    public final ahr k() {
        return this.e;
    }

    @Override // me.hd.wauxv.obf.aot
    public final afw l() {
        return this;
    }

    @Override // me.hd.wauxv.obf.aot
    public final Object o() {
        Object obj = this.f;
        this.f = HugeSyntheticPileOfHelpers.ae;
        return obj;
    }

    public final String toString() {
        return "DispatchedContinuation[" + this.d + ", " + ajn.ah(this.e) + ']';
    }
}
