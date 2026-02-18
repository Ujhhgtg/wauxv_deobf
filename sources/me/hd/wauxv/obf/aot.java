package me.hd.wauxv.obf;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class aot extends dpy {
    public int z;

    public aot(int i) {
        super(false, 0L);
        this.z = i;
    }

    public final void aa(Throwable th) {
        cna.z(l().c(), new aht("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public void j(CancellationException cancellationException) {
    }

    public abstract afw l();

    public Throwable m(Object obj) {
        abr abrVar = obj instanceof abr ? (abr) obj : null;
        if (abrVar != null) {
            return abrVar.c;
        }
        return null;
    }

    public Object n(Object obj) {
        return obj;
    }

    public abstract Object o();

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException
    	at java.base/java.util.Objects.requireNonNull(Objects.java:209)
    	at java.base/java.util.ArrayList.batchRemove(ArrayList.java:816)
    	at java.base/java.util.ArrayList.removeAll(ArrayList.java:791)
    	at jadx.core.dex.visitors.finaly.TryCatchEdgeBlockMap.getAllInScope(TryCatchEdgeBlockMap.java:91)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(MarkFinallyVisitor.java:204)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:119)
     */
    @Override // java.lang.Runnable
    public final void run() {
        try {
            afw afwVarL = l();
            bzo.o(afwVarL, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");
            aor aorVar = (aor) afwVarL;
            afx afxVar = aorVar.e;
            ahh ahhVar = afxVar.m;
            Object obj = aorVar.g;
            bzo.n(ahhVar);
            Object objAl = bhv.al(ahhVar, obj);
            brf brfVar = null;
            enk enkVarAu = objAl != bhv.q ? bzo.au(afxVar, ahhVar, objAl) : null;
            try {
                bzo.n(ahhVar);
                Object objO = o();
                Throwable thM = m(objO);
                if (thM == null) {
                    int i = this.z;
                    boolean z = true;
                    if (i != 1 && i != 2) {
                        z = false;
                    }
                    if (z) {
                        brfVar = (brf) ahhVar._w(arj.i);
                    }
                }
                if (brfVar != null && !brfVar.m()) {
                    CancellationException cancellationExceptionN = brfVar.n();
                    j(cancellationExceptionN);
                    afxVar._bn(bhu.x(cancellationExceptionN));
                } else if (thM != null) {
                    afxVar._bn(bhu.x(thM));
                } else {
                    afxVar._bn(n(objO));
                }
                if (enkVarAu == null || enkVarAu.as()) {
                    bhv.ag(ahhVar, objAl);
                }
            } catch (Throwable th) {
                if (enkVarAu == null || enkVarAu.as()) {
                    bhv.ag(ahhVar, objAl);
                }
                throw th;
            }
        } catch (aoq e) {
            cna.z(l().c(), e.a);
        } catch (Throwable th2) {
            aa(th2);
        }
    }
}
