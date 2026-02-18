package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class brm implements brf, csx {
    public static final /* synthetic */ AtomicReferenceFieldUpdater r = AtomicReferenceFieldUpdater
            .newUpdater(brm.class, Object.class, "_state$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater s = AtomicReferenceFieldUpdater
            .newUpdater(brm.class, Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    public brm(boolean z) {
        this._state$volatile = z ? bhv.p : bhv.o;
    }

    public static yf t(bxl bxlVar) {
        while (bxlVar.r()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = bxl.l;
            bxl bxlVarO = bxlVar.o();
            if (bxlVarO == null) {
                Object obj = atomicReferenceFieldUpdater.get(bxlVar);
                while (true) {
                    bxlVar = (bxl) obj;
                    if (!bxlVar.r()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(bxlVar);
                }
            } else {
                bxlVar = bxlVarO;
            }
        }
        while (true) {
            bxlVar = bxlVar.q();
            if (!bxlVar.r()) {
                if (bxlVar instanceof yf) {
                    return (yf) bxlVar;
                }
                if (bxlVar instanceof cok) {
                    return null;
                }
            }
        }
    }

    public static String u(Object obj) {
        if (!(obj instanceof brl)) {
            return obj instanceof bou ? ((bou) obj).b() ? "Active" : "New"
                    : obj instanceof abr ? "Cancelled" : "Completed";
        }
        brl brlVar = (brl) obj;
        return brlVar.i() ? "Cancelling" : brl.a.get(brlVar) == 1 ? "Completing" : "Active";
    }

    @Override // me.hd.wauxv.obf.ahh
    public final ahh _t(ahg ahgVar) {
        return bmy.x(this, ahgVar);
    }

    @Override // me.hd.wauxv.obf.ahh
    public final Object _u(Object obj, bgj bgjVar) {
        return bgjVar.g(obj, this);
    }

    @Override // me.hd.wauxv.obf.ahh
    public final ahh _v(ahh ahhVar) {
        return bmy.aa(this, ahhVar);
    }

    @Override // me.hd.wauxv.obf.ahh
    public final ahf _w(ahg ahgVar) {
        throwIfVar1IsNull(ahgVar, "key");
        if (nullSafeIsEqual(arj.i, ahgVar)) {
            return this;
        }
        return null;
    }

    public final Object aa(brl brlVar, Object obj) {
        Object obj2 = null;
        Throwable brgVar = null;
        abr abrVar = obj instanceof abr ? (abr) obj : null;
        Throwable th = abrVar != null ? abrVar.c : null;
        synchronized (brlVar) {
            brlVar.i();
            ArrayList<Throwable> arrayListJ = brlVar.j(th);
            if (!arrayListJ.isEmpty()) {
                for (Object obj3 : arrayListJ) {
                    if (!(((Throwable) obj3) instanceof CancellationException)) {
                        obj2 = obj3;
                        break;
                    }
                }
                brgVar = (Throwable) obj2;
                if (brgVar == null) {
                    brgVar = (Throwable) arrayListJ.get(0);
                }
            } else if (brlVar.i()) {
                brgVar = new brg(d(), null, this);
            }
            if (brgVar != null && arrayListJ.size() > 1) {
                Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(arrayListJ.size()));
                for (Throwable th2 : arrayListJ) {
                    if (th2 != brgVar && th2 != brgVar && !(th2 instanceof CancellationException)
                            && setNewSetFromMap.add(th2)) {
                        aye.j(brgVar, th2);
                    }
                }
            }
        }
        if (brgVar != null && brgVar != th) {
            obj = new abr(brgVar, false);
        }
        if (brgVar != null && (w(brgVar) || ad(brgVar))) {
            throwIfVar1IsNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            abr.b.compareAndSet((abr) obj, 0, 1);
        }
        g(obj);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = r;
        Object bovVar = obj instanceof bou ? new bov((bou) obj) : obj;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, brlVar, bovVar)
                && atomicReferenceFieldUpdater.get(this) == brlVar) {
        }
        y(brlVar, obj);
        return obj;
    }

    public boolean ab() {
        return true;
    }

    public final cok ac(bou bouVar) {
        cok cokVarC = bouVar.c();
        if (cokVarC != null) {
            return cokVarC;
        }
        if (bouVar instanceof aux) {
            return new cok();
        }
        if (bouVar instanceof bri) {
            am((bri) bouVar);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + bouVar).toString());
    }

    public boolean ad(Throwable th) {
        return false;
    }

    public final void ae(brf brfVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = s;
        con conVar = con.b;
        if (brfVar == null) {
            atomicReferenceFieldUpdater.set(this, conVar);
            return;
        }
        brfVar.start();
        ye yeVarO = brfVar.o(this);
        atomicReferenceFieldUpdater.set(this, yeVarO);
        if (r.get(this) instanceof bou) {
            return;
        }
        yeVarO.e();
        atomicReferenceFieldUpdater.set(this, conVar);
    }

    public final aox af(IHasInvokeMethod bgfVar) {
        return ag(true, new yd(bgfVar, 1));
    }

    public final aox ag(boolean z, bri briVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        boolean z2;
        boolean zN;
        briVar.g = this;
        loop0: while (true) {
            atomicReferenceFieldUpdater = r;
            Object obj = atomicReferenceFieldUpdater.get(this);
            boolean z3 = obj instanceof aux;
            con conVar = con.b;
            z2 = true;
            if (!z3) {
                if (!(obj instanceof bou)) {
                    z2 = false;
                    break;
                }
                bou bouVar = (bou) obj;
                cok cokVarC = bouVar.c();
                if (cokVarC == null) {
                    am((bri) obj);
                } else {
                    if (briVar._ba()) {
                        brl brlVar = bouVar instanceof brl ? (brl) bouVar : null;
                        Throwable thH = brlVar != null ? brlVar.h() : null;
                        if (thH == null) {
                            zN = cokVarC.n(briVar, 5);
                        } else if (z) {
                            briVar.d(thH);
                            return conVar;
                        }
                    } else {
                        zN = cokVarC.n(briVar, 1);
                    }
                    if (zN) {
                        break;
                    }
                }
            } else {
                aux auxVar = (aux) obj;
                if (auxVar.a) {
                    do {
                        if (atomicReferenceFieldUpdater.compareAndSet(this, obj, briVar)) {
                            break loop0;
                        }
                    } while (atomicReferenceFieldUpdater.get(this) == obj);
                } else {
                    al(auxVar);
                }
            }
            return conVar;
        }
        if (z2) {
            return briVar;
        }
        if (z) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            abr abrVar = obj2 instanceof abr ? (abr) obj2 : null;
            briVar.d(abrVar != null ? abrVar.c : null);
        }
        return conVar;
    }

    public boolean ah() {
        return false;
    }

    public final Object ai(Object obj) {
        Object objAo;
        do {
            objAo = ao(r.get(this), obj);
            if (objAo == bhv.j) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                abr abrVar = obj instanceof abr ? (abr) obj : null;
                throw new IllegalStateException(str, abrVar != null ? abrVar.c : null);
            }
        } while (objAo == bhv.l);
        return objAo;
    }

    public final void aj(cok cokVar, Throwable th) {
        cokVar.n(new bwa(4), 4);
        Object obj = bxl.k.get(cokVar);
        throwIfVar1IsNull(obj,
                "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        QueryDidNotReturnUniqueResultRuntimeException abtVar = null;
        for (bxl bxlVarQ = (bxl) obj; !bxlVarQ.equals(cokVar); bxlVarQ = bxlVarQ.q()) {
            if ((bxlVarQ instanceof bri) && ((bri) bxlVarQ)._ba()) {
                try {
                    ((bri) bxlVarQ).d(th);
                } catch (Throwable th2) {
                    if (abtVar != null) {
                        aye.j(abtVar, th2);
                    } else {
                        abtVar = new QueryDidNotReturnUniqueResultRuntimeException(
                                "Exception in completion handler " + bxlVarQ + " for " + this, th2);
                    }
                }
            }
        }
        if (abtVar != null) {
            f(abtVar);
        }
        w(th);
    }

    public void ak() {
    }

    public final void al(aux auxVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        cok cokVar = new cok();
        Object botVar = cokVar;
        if (!auxVar.a) {
            botVar = new bot(cokVar);
        }
        do {
            atomicReferenceFieldUpdater = r;
            if (atomicReferenceFieldUpdater.compareAndSet(this, auxVar, botVar)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == auxVar);
    }

    public final void am(bri briVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        cok cokVar = new cok();
        briVar.getClass();
        bxl.l.set(cokVar, briVar);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = bxl.k;
        atomicReferenceFieldUpdater2.set(cokVar, briVar);
        loop0: while (atomicReferenceFieldUpdater2.get(briVar) == briVar) {
            do {
                if (atomicReferenceFieldUpdater2.compareAndSet(briVar, briVar, cokVar)) {
                    cokVar.p(briVar);
                    break loop0;
                }
            } while (atomicReferenceFieldUpdater2.get(briVar) == briVar);
        }
        bxl bxlVarQ = briVar.q();
        do {
            atomicReferenceFieldUpdater = r;
            if (atomicReferenceFieldUpdater.compareAndSet(this, briVar, bxlVarQ)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == briVar);
    }

    public final int an(Object obj) {
        boolean z = obj instanceof aux;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = r;
        if (z) {
            if (((aux) obj).a) {
                return 0;
            }
            aux auxVar = bhv.p;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, auxVar)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    return -1;
                }
            }
            return 1;
        }
        if (!(obj instanceof bot)) {
            return 0;
        }
        cok cokVar = ((bot) obj).a;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, cokVar)) {
            if (atomicReferenceFieldUpdater.get(this) != obj) {
                return -1;
            }
        }
        return 1;
    }

    public final Object ao(Object obj, Object obj2) {
        if (!(obj instanceof bou)) {
            return bhv.j;
        }
        if (((obj instanceof aux) || (obj instanceof bri)) && !(obj instanceof yf) && !(obj2 instanceof abr)) {
            bou bouVar = (bou) obj;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = r;
            Object bovVar = obj2 instanceof bou ? new bov((bou) obj2) : obj2;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, bouVar, bovVar)) {
                if (atomicReferenceFieldUpdater.get(this) != bouVar) {
                    return bhv.l;
                }
            }
            g(obj2);
            y(bouVar, obj2);
            return obj2;
        }
        bou bouVar2 = (bou) obj;
        cok cokVarAc = ac(bouVar2);
        if (cokVarAc == null) {
            return bhv.l;
        }
        brl brlVar = bouVar2 instanceof brl ? (brl) bouVar2 : null;
        if (brlVar == null) {
            brlVar = new brl(cokVarAc, null);
        }
        synchronized (brlVar) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = brl.a;
            if (atomicIntegerFieldUpdater.get(brlVar) == 1) {
                return bhv.j;
            }
            atomicIntegerFieldUpdater.set(brlVar, 1);
            if (brlVar != bouVar2) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = r;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, bouVar2, brlVar)) {
                    if (atomicReferenceFieldUpdater2.get(this) != bouVar2) {
                        return bhv.l;
                    }
                }
            }
            boolean zI = brlVar.i();
            abr abrVar = obj2 instanceof abr ? (abr) obj2 : null;
            if (abrVar != null) {
                brlVar.g(abrVar.c);
            }
            Throwable thH = zI ? null : brlVar.h();
            if (thH != null) {
                aj(cokVarAc, thH);
            }
            yf yfVarT = t(cokVarAc);
            if (yfVarT != null && ap(brlVar, yfVarT, obj2)) {
                return bhv.k;
            }
            cokVarAc.n(new bwa(2), 2);
            yf yfVarT2 = t(cokVarAc);
            return (yfVarT2 == null || !ap(brlVar, yfVarT2, obj2)) ? aa(brlVar, obj2) : bhv.k;
        }
    }

    public final boolean ap(brl brlVar, yf yfVar, Object obj) {
        while (cna.aa(yfVar._bb, false, new brk(this, brlVar, yfVar, obj)) == con.b) {
            yfVar = t(yfVar);
            if (yfVar == null) {
                return false;
            }
        }
        return true;
    }

    public String d() {
        return "Job was cancelled";
    }

    public void f(QueryDidNotReturnUniqueResultRuntimeException abtVar) {
        throw abtVar;
    }

    public void g(Object obj) {
    }

    @Override // me.hd.wauxv.obf.ahf
    public final ahg getKey() {
        return arj.i;
    }

    public void j(Object obj) {
    }

    public void l(Object obj) {
        j(obj);
    }

    @Override // me.hd.wauxv.obf.brf
    public boolean m() {
        Object obj = r.get(this);
        return (obj instanceof bou) && ((bou) obj).b();
    }

    @Override // me.hd.wauxv.obf.brf
    public final CancellationException n() {
        CancellationException cancellationException;
        Object obj = r.get(this);
        if (!(obj instanceof brl)) {
            if (obj instanceof bou) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            if (!(obj instanceof abr)) {
                return new brg(getClass().getSimpleName().concat(" has completed normally"), null, this);
            }
            Throwable th = ((abr) obj).c;
            cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
            return cancellationException == null ? new brg(d(), th, this) : cancellationException;
        }
        Throwable thH = ((brl) obj).h();
        if (thH == null) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        String strConcat = getClass().getSimpleName().concat(" is cancelling");
        cancellationException = thH instanceof CancellationException ? (CancellationException) thH : null;
        if (cancellationException != null) {
            return cancellationException;
        }
        if (strConcat == null) {
            strConcat = d();
        }
        return new brg(strConcat, thH, this);
    }

    @Override // me.hd.wauxv.obf.brf
    public final ye o(brm brmVar) {
        yf yfVar = new yf(brmVar);
        yfVar.g = this;
        loop0: while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = r;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof aux) {
                aux auxVar = (aux) obj;
                if (auxVar.a) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, yfVar)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj) {
                        }
                    }
                    break loop0;
                }
                al(auxVar);
            } else {
                boolean z = obj instanceof bou;
                con conVar = con.b;
                if (!z) {
                    Object obj2 = atomicReferenceFieldUpdater.get(this);
                    abr abrVar = obj2 instanceof abr ? (abr) obj2 : null;
                    yfVar.d(abrVar != null ? abrVar.c : null);
                    return conVar;
                }
                cok cokVarC = ((bou) obj).c();
                if (cokVarC != null) {
                    if (cokVarC.n(yfVar, 7)) {
                        break;
                    }
                    boolean zN = cokVarC.n(yfVar, 3);
                    Object obj3 = atomicReferenceFieldUpdater.get(this);
                    if (obj3 instanceof brl) {
                        thH = ((brl) obj3).h();
                    } else {
                        abr abrVar2 = obj3 instanceof abr ? (abr) obj3 : null;
                        if (abrVar2 != null) {
                            thH = abrVar2.c;
                        }
                    }
                    yfVar.d(thH);
                    if (zN) {
                        break;
                    }
                    return conVar;
                }
                am((bri) obj);
            }
        }
        return yfVar;
    }

    @Override // me.hd.wauxv.obf.brf
    public final aox p(boolean z, boolean z2, brh brhVar) {
        return ag(z2, z ? new bqp(brhVar) : new yd(brhVar, 1));
    }

    @Override // me.hd.wauxv.obf.brf
    public final void q(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new brg(d(), null, this);
        }
        v(cancellationException);
    }

    @Override // me.hd.wauxv.obf.brf
    public final boolean start() {
        int iAn;
        do {
            iAn = an(r.get(this));
            if (iAn == 0) {
                return false;
            }
        } while (iAn != 1);
        return true;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName() + '{' + u(r.get(this)) + '}');
        sb.append('@');
        sb.append(ajn.q(this));
        return sb.toString();
    }

    /*
     * JADX WARN: Found duplicated region for block: B:18:0x003c A[PHI: r0
     * 0x003c: PHI (r0v1 java.lang.Object) = (r0v0 java.lang.Object), (r0v13
     * java.lang.Object) binds: [B:3:0x0006, B:16:0x0038] A[DONT_GENERATE,
     * DONT_INLINE]]
     */
    /* JADX WARN: Found duplicated region for block: B:20:0x0040 */
    /* JADX WARN: Found duplicated region for block: B:26:0x005a */
    /* JADX WARN: Found duplicated region for block: B:27:0x005c */
    /*
     * JADX WARN: Found duplicated region for block: B:29:0x005f A[Catch: all ->
     * 0x0065, TRY_LEAVE, TryCatch #0 {, blocks: (B:24:0x004d, B:29:0x005f,
     * B:34:0x0067, B:36:0x0070, B:37:0x0074), top: B:81:0x004d }]
     */
    /*
     * JADX WARN: Found duplicated region for block: B:34:0x0067 A[Catch: all ->
     * 0x0065, MOVE_INLINED, TRY_ENTER, TryCatch #0 {, blocks: (B:24:0x004d,
     * B:29:0x005f, B:34:0x0067, B:36:0x0070, B:37:0x0074), top: B:81:0x004d }]
     */
    /*
     * JADX WARN: Found duplicated region for block: B:36:0x0070 A[Catch: all ->
     * 0x0065, TryCatch #0 {, blocks: (B:24:0x004d, B:29:0x005f, B:34:0x0067,
     * B:36:0x0070, B:37:0x0074), top: B:81:0x004d }]
     */
    /* JADX WARN: Found duplicated region for block: B:39:0x0083 */
    /* JADX WARN: Found duplicated region for block: B:42:0x0087 */
    /* JADX WARN: Found duplicated region for block: B:46:0x0093 */
    /* JADX WARN: Found duplicated region for block: B:48:0x0097 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:49:0x0099 */
    /* JADX WARN: Found duplicated region for block: B:59:0x00be */
    /* JADX WARN: Found duplicated region for block: B:64:0x00d3 */
    /* JADX WARN: Found duplicated region for block: B:78:0x0103 A[RETURN] */
    /* JADX WARN: Found duplicated region for block: B:79:0x0104 */
    /*
     * JADX WARN: Found duplicated region for block: B:81:0x004d A[EXC_TOP_SPLITTER,
     * SYNTHETIC]
     */
    /* JADX WARN: Found duplicated region for block: B:86:0x00c6 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:87:0x00ad A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:88:0x004c A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:89:0x00f1 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:90:0x00b8 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:91:0x00d7 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:92:0x00a6 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:93:0x00d9 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:95:0x0042 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:96:0x0042 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:97:0x0042 A[SYNTHETIC] */
    /*
     * JADX WARN: Found duplicated region for block: B:98:? A[LOOP:2:
     * B:56:0x00b2->B:98:?, LOOP_END, SYNTHETIC]
     */
    public final boolean v(Object obj) {
        Throwable thZ;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Object obj2;
        Throwable thH;
        auj aujVar;
        bou bouVar;
        cok cokVarAc;
        brl brlVar;
        Object objAo;
        Object objAo2 = bhv.j;
        if (this instanceof dob) {
            do {
                Object obj3 = r.get(this);
                if (obj3 instanceof bou) {
                    if (obj3 instanceof brl) {
                        if (brl.a.get((brl) obj3) == 1) {
                        }
                    }
                    objAo2 = ao(obj3, new abr(z(obj), false));
                }
                objAo2 = bhv.j;
                break;
            } while (objAo2 == bhv.l);
            if (objAo2 != bhv.k) {
                if (objAo2 == bhv.j) {
                    thZ = null;
                    loop1: while (true) {
                        atomicReferenceFieldUpdater = r;
                        obj2 = atomicReferenceFieldUpdater.get(this);
                        if (obj2 instanceof brl) {
                            synchronized (obj2) {
                                if (brl.e.get((brl) obj2) == bhv.n) {
                                    aujVar = bhv.m;
                                } else {
                                    boolean zI = ((brl) obj2).i();
                                    if (thZ == null) {
                                        thZ = z(obj);
                                    }
                                    ((brl) obj2).g(thZ);
                                    thH = zI ? null : ((brl) obj2).h();
                                    if (thH != null) {
                                        aj(((brl) obj2).f, thH);
                                    }
                                    aujVar = bhv.j;
                                }
                            }
                        } else if (obj2 instanceof bou) {
                            if (thZ == null) {
                                thZ = z(obj);
                            }
                            bouVar = (bou) obj2;
                            if (bouVar.b()) {
                                cokVarAc = ac(bouVar);
                                if (cokVarAc == null) {
                                    continue;
                                } else {
                                    brlVar = new brl(cokVarAc, thZ);
                                    while (true) {
                                        if (atomicReferenceFieldUpdater.compareAndSet(this, bouVar, brlVar)) {
                                            aj(cokVarAc, thZ);
                                            aujVar = bhv.j;
                                        } else if (atomicReferenceFieldUpdater.get(this) != bouVar) {
                                        }
                                    }
                                }
                            } else {
                                objAo = ao(obj2, new abr(thZ, false));
                                if (objAo != bhv.j) {
                                    throw new IllegalStateException(("Cannot happen in " + obj2).toString());
                                }
                                if (objAo != bhv.l) {
                                    objAo2 = objAo;
                                    break;
                                }
                            }
                        } else {
                            aujVar = bhv.m;
                        }
                        objAo2 = aujVar;
                        break;
                    }
                }
                if (objAo2 != bhv.j && objAo2 != bhv.k) {
                    if (objAo2 == bhv.m) {
                        return false;
                    }
                    j(objAo2);
                    return true;
                }
            }
        } else {
            if (objAo2 == bhv.j) {
                thZ = null;
                loop1: while (true) {
                    atomicReferenceFieldUpdater = r;
                    obj2 = atomicReferenceFieldUpdater.get(this);
                    if (obj2 instanceof brl) {
                        synchronized (obj2) {
                            if (brl.e.get((brl) obj2) == bhv.n) {
                                aujVar = bhv.m;
                            } else {
                                boolean zI2 = ((brl) obj2).i();
                                if (thZ == null) {
                                    thZ = z(obj);
                                }
                                ((brl) obj2).g(thZ);
                                if (zI2) {
                                }
                                if (thH != null) {
                                    aj(((brl) obj2).f, thH);
                                }
                                aujVar = bhv.j;
                            }
                        }
                    } else if (obj2 instanceof bou) {
                        if (thZ == null) {
                            thZ = z(obj);
                        }
                        bouVar = (bou) obj2;
                        if (bouVar.b()) {
                            cokVarAc = ac(bouVar);
                            if (cokVarAc == null) {
                                continue;
                            } else {
                                brlVar = new brl(cokVarAc, thZ);
                                while (true) {
                                    if (atomicReferenceFieldUpdater.compareAndSet(this, bouVar, brlVar)) {
                                        aj(cokVarAc, thZ);
                                        aujVar = bhv.j;
                                    } else if (atomicReferenceFieldUpdater.get(this) != bouVar) {
                                    }
                                }
                            }
                        } else {
                            objAo = ao(obj2, new abr(thZ, false));
                            if (objAo != bhv.j) {
                                throw new IllegalStateException(("Cannot happen in " + obj2).toString());
                            }
                            if (objAo != bhv.l) {
                                objAo2 = objAo;
                                break;
                            }
                        }
                    } else {
                        aujVar = bhv.m;
                    }
                    objAo2 = aujVar;
                    break;
                }
            }
            if (objAo2 != bhv.j) {
                if (objAo2 == bhv.m) {
                    return false;
                }
                j(objAo2);
                return true;
            }
        }
        return true;
    }

    public final boolean w(Throwable th) {
        if (ah()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        ye yeVar = (ye) s.get(this);
        return (yeVar == null || yeVar == con.b) ? z : yeVar.a(th) || z;
    }

    public boolean x(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return v(th) && ab();
    }

    public final void y(bou bouVar, Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = s;
        ye yeVar = (ye) atomicReferenceFieldUpdater.get(this);
        if (yeVar != null) {
            yeVar.e();
            atomicReferenceFieldUpdater.set(this, con.b);
        }
        QueryDidNotReturnUniqueResultRuntimeException abtVar = null;
        abr abrVar = obj instanceof abr ? (abr) obj : null;
        Throwable th = abrVar != null ? abrVar.c : null;
        if (bouVar instanceof bri) {
            try {
                ((bri) bouVar).d(th);
                return;
            } catch (Throwable th2) {
                f(new QueryDidNotReturnUniqueResultRuntimeException(
                        "Exception in completion handler " + bouVar + " for " + this, th2));
                return;
            }
        }
        cok cokVarC = bouVar.c();
        if (cokVarC != null) {
            cokVarC.n(new bwa(1), 1);
            Object obj2 = bxl.k.get(cokVarC);
            throwIfVar1IsNull(obj2,
                    "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
            for (bxl bxlVarQ = (bxl) obj2; !bxlVarQ.equals(cokVarC); bxlVarQ = bxlVarQ.q()) {
                if (bxlVarQ instanceof bri) {
                    try {
                        ((bri) bxlVarQ).d(th);
                    } catch (Throwable th3) {
                        if (abtVar != null) {
                            aye.j(abtVar, th3);
                        } else {
                            abtVar = new QueryDidNotReturnUniqueResultRuntimeException(
                                    "Exception in completion handler " + bxlVarQ + " for " + this, th3);
                        }
                    }
                }
            }
            if (abtVar != null) {
                f(abtVar);
            }
        }
    }

    public final Throwable z(Object obj) {
        Throwable thH;
        if (obj instanceof Throwable) {
            return (Throwable) obj;
        }
        brm brmVar = (brm) ((csx) obj);
        Object obj2 = r.get(brmVar);
        if (obj2 instanceof brl) {
            thH = ((brl) obj2).h();
        } else if (obj2 instanceof abr) {
            thH = ((abr) obj2).c;
        } else {
            if (obj2 instanceof bou) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + obj2).toString());
            }
            thH = null;
        }
        CancellationException cancellationException = thH instanceof CancellationException ? (CancellationException) thH
                : null;
        return cancellationException == null ? new brg("Parent job is ".concat(u(obj2)), thH, brmVar)
                : cancellationException;
    }
}
