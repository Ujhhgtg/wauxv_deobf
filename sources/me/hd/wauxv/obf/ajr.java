package me.hd.wauxv.obf;

import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ajr implements ajc, Runnable, Comparable, axw {
    public static final cru c = new cru("glide_thread_priority_override", null, cru.a);
    public btj aa;
    public Object ab;
    public ajb ac;
    public volatile ajd ad;
    public volatile boolean ae;
    public volatile boolean af;
    public boolean ag;
    public int ah;
    public int ai;
    public int aj;
    public final afr g;
    public final cuv h;
    public bhw k;
    public btj l;
    public cvq m;
    public awj n;
    public int o;
    public int p;
    public aoi q;
    public crw r;
    public awh s;
    public int t;
    public long u;
    public Object v;
    public bib w;
    public Supplier x;
    public Thread y;
    public btj z;
    public final ajp d = new ajp();
    public final ArrayList e = new ArrayList();
    public final dmn f = new dmn();
    public final FactoryPools i = new FactoryPools(5, false);
    public final ajq j = new ajq();

    public ajr(afr afrVar, FactoryPools factoryPoolsVar) {
        this.g = afrVar;
        this.h = factoryPoolsVar;
    }

    @Override // me.hd.wauxv.obf.ajc
    public final void a(btj btjVar, Object obj, ajb ajbVar, int i, btj btjVar2) {
        this.z = btjVar;
        this.ab = obj;
        this.ac = ajbVar;
        this.aj = i;
        this.aa = btjVar2;
        this.ag = btjVar != this.d.s().get(0);
        if (Thread.currentThread() != this.y) {
            at(3);
        } else {
            an();
        }
    }

    public final dcg ak(ajb ajbVar, Object obj, int i) {
        if (obj == null) {
            ajbVar.d();
            return null;
        }
        try {
            int i2 = bxq.b;
            long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            dcg dcgVarAm = am(i, obj);
            if (Log.isLoggable("DecodeJob", 2)) {
                aq("Decoded result " + dcgVarAm, jElapsedRealtimeNanos, null);
            }
            return dcgVarAm;
        } finally {
            ajbVar.d();
        }
    }

    @Override // me.hd.wauxv.obf.axw
    public final dmn al() {
        return this.f;
    }

    public final dcg am(int i, Object obj) {
        Class<?> cls = obj.getClass();
        ajp ajpVar = this.d;
        bwt bwtVarU = ajpVar.u(cls);
        crw crwVar = this.r;
        boolean z = i == 4 || ajpVar.r;
        cru cruVar = apq.d;
        Boolean bool = (Boolean) crwVar.b(cruVar);
        if (bool == null || (bool.booleanValue() && !z)) {
            crwVar = new crw();
            sp spVar = this.r.a;
            sp spVar2 = crwVar.a;
            spVar2.g(spVar);
            spVar2.put(cruVar, Boolean.valueOf(z));
        }
        crw crwVar2 = crwVar;
        ajh ajhVarQ = this.k.l().q(obj);
        try {
            return bwtVarU.d(this.o, this.p, new ek(this, i, 5), ajhVarQ, crwVar2);
        } finally {
            ajhVarQ.c();
        }
    }

    /* JADX WARN: Undo finally extract visitor
    jadx.core.utils.exceptions.JadxRuntimeException: Expected to find fallthrough terminus for handler TryEdge: [PREMATURE_EXIT B:99:0x0166 -> B:67:0x0190] - Handler: None
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.findCommonInsns(MarkFinallyVisitor.java:419)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.extractFinally(MarkFinallyVisitor.java:302)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.processTryBlock(MarkFinallyVisitor.java:222)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:150)
     */
    public final void an() {
        dcg dcgVarAk;
        boolean zD;
        Supplier supplier;
        if (Log.isLoggable("DecodeJob", 2)) {
            aq("Retrieved data", this.u, "data: " + this.ab + ", cache key: " + this.z + ", fetcher: " + this.ac);
        }
        bxp bxpVar = null;
        if (this.w.a.containsKey(FastKV.class) && (supplier = this.x) != null && supplier.get() != null) {
            try {
                Process.setThreadPriority(Process.myTid(), ((Integer) this.x.get()).intValue());
            } catch (IllegalArgumentException | SecurityException e) {
                this.x = null;
                if (Log.isLoggable("DecodeJob", 2)) {
                    Log.v("DecodeJob", "Failed to set thread priority; using default priority for any subsequent jobs.", e);
                }
            }
        }
        try {
            dcgVarAk = ak(this.ac, this.ab, this.aj);
        } catch (bhy e2) {
            btj btjVar = this.aa;
            int i = this.aj;
            e2.c = btjVar;
            e2.d = i;
            e2.e = null;
            this.e.add(e2);
            dcgVarAk = null;
        }
        if (dcgVarAk == null) {
            av();
            return;
        }
        int i2 = this.aj;
        boolean z = this.ag;
        if (dcgVarAk instanceof bpe) {
            ((bpe) dcgVarAk).initialize();
        }
        if (((bxp) this.i.h) != null) {
            bxpVar = (bxp) bxp.a.acquire();
            bxpVar.h = false;
            bxpVar.g = true;
            bxpVar.f = dcgVarAk;
            dcgVarAk = bxpVar;
        }
        if (this.w.a.containsKey(FastKV.class)) {
            au();
        }
        ax();
        awh awhVar = this.s;
        synchronized (awhVar) {
            try {
                awhVar.o = dcgVarAk;
                awhVar.p = i2;
                awhVar.w = z;
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (awhVar) {
            try {
                awhVar.c.b();
                if (awhVar.v) {
                    awhVar.o.c();
                    awhVar.ac();
                } else {
                    if (awhVar.b.a.isEmpty()) {
                        throw new IllegalStateException("Received a resource without any callbacks to notify");
                    }
                    if (awhVar.q) {
                        throw new IllegalStateException("Already have resource");
                    }
                    nu nuVar = awhVar.f;
                    dcg dcgVar = awhVar.o;
                    boolean z2 = awhVar.m;
                    awj awjVar = awhVar.l;
                    awk awkVar = awhVar.d;
                    nuVar.getClass();
                    awhVar.t = new awl(dcgVar, z2, true, awjVar, awkVar);
                    awhVar.q = true;
                    awg awgVar = awhVar.b;
                    awgVar.getClass();
                    ArrayList<awf> arrayList = new ArrayList(awgVar.a);
                    awhVar.aa(arrayList.size() + 1);
                    ((awd) awhVar.g).m(awhVar, awhVar.l, awhVar.t);
                    for (awf awfVar : arrayList) {
                        awfVar.b.execute(new awe(awhVar, awfVar.a, 1));
                    }
                    awhVar.z();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        this.ah = 5;
        try {
            FactoryPools factoryPoolsVar = this.i;
            if (((bxp) factoryPoolsVar.h) != null) {
                afr afrVar = this.g;
                crw crwVar = this.r;
                factoryPoolsVar.getClass();
                try {
                    afrVar.c().y((btj) factoryPoolsVar.e, new FactoryPools((dcm) factoryPoolsVar.f, (bxp) factoryPoolsVar.h, crwVar, 4));
                    ((bxp) factoryPoolsVar.h).i();
                } catch (Throwable th3) {
                    ((bxp) factoryPoolsVar.h).i();
                    throw th3;
                }
            }
            if (bxpVar != null) {
                bxpVar.i();
            }
            ajq ajqVar = this.j;
            synchronized (ajqVar) {
                try {
                    ajqVar.b = true;
                    zD = ajqVar.d();
                } catch (Throwable th4) {
                    throw th4;
                }
            }
            if (zD) {
                as();
            }
        } catch (Throwable th5) {
            if (bxpVar != null) {
                bxpVar.i();
            }
            throw th5;
        }
    }

    public final ajd ao() {
        int iAe = StaticHelpers6.ae(this.ah);
        ajp ajpVar = this.d;
        if (iAe == 1) {
            return new dch(ajpVar, this);
        }
        if (iAe == 2) {
            return new aiy(ajpVar.s(), ajpVar, this);
        }
        if (iAe == 3) {
            return new dld(ajpVar, this);
        }
        if (iAe == 5) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: ".concat(yg.y(this.ah)));
    }

    public final int ap(int i) {
        boolean z;
        boolean z2;
        int iAe = StaticHelpers6.ae(i);
        if (iAe == 0) {
            switch (this.q.d) {
                case 0:
                case 1:
                    z = false;
                    break;
                default:
                    z = true;
                    break;
            }
            if (z) {
                return 2;
            }
            return ap(2);
        }
        if (iAe != 1) {
            if (iAe == 2) {
                return 4;
            }
            if (iAe == 3 || iAe == 5) {
                return 6;
            }
            throw new IllegalArgumentException("Unrecognized stage: ".concat(yg.y(i)));
        }
        switch (this.q.d) {
            case 0:
                z2 = false;
                break;
            case 1:
            default:
                z2 = true;
                break;
        }
        if (z2) {
            return 3;
        }
        return ap(3);
    }

    public final void aq(String str, long j, String str2) {
        StringBuilder sbR = concat(str, " in ");
        sbR.append(bxq.c(j));
        sbR.append(", load key: ");
        sbR.append(this.n);
        sbR.append(str2 != null ? ", ".concat(str2) : "");
        sbR.append(", thread: ");
        sbR.append(Thread.currentThread().getName());
        Log.v("DecodeJob", sbR.toString());
    }

    public final void ar() {
        boolean zD;
        if (this.w.a.containsKey(FastKV.class)) {
            au();
        }
        ax();
        bhy bhyVar = new bhy("Failed to load resource", new ArrayList(this.e));
        awh awhVar = this.s;
        synchronized (awhVar) {
            awhVar.r = bhyVar;
        }
        synchronized (awhVar) {
            try {
                awhVar.c.b();
                if (awhVar.v) {
                    awhVar.ac();
                } else {
                    if (awhVar.b.a.isEmpty()) {
                        throw new IllegalStateException("Received an exception without any callbacks to notify");
                    }
                    if (awhVar.s) {
                        throw new IllegalStateException("Already failed once");
                    }
                    awhVar.s = true;
                    awj awjVar = awhVar.l;
                    awg awgVar = awhVar.b;
                    awgVar.getClass();
                    ArrayList<awf> arrayList = new ArrayList(awgVar.a);
                    awhVar.aa(arrayList.size() + 1);
                    ((awd) awhVar.g).m(awhVar, awjVar, null);
                    for (awf awfVar : arrayList) {
                        awfVar.b.execute(new awe(awhVar, awfVar.a, 0));
                    }
                    awhVar.z();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        ajq ajqVar = this.j;
        synchronized (ajqVar) {
            ajqVar.c = true;
            zD = ajqVar.d();
        }
        if (zD) {
            as();
        }
    }

    public final void as() {
        ajq ajqVar = this.j;
        synchronized (ajqVar) {
            ajqVar.b = false;
            ajqVar.a = false;
            ajqVar.c = false;
        }
        FactoryPools factoryPoolsVar = this.i;
        factoryPoolsVar.e = null;
        factoryPoolsVar.f = null;
        factoryPoolsVar.h = null;
        ajp ajpVar = this.d;
        ajpVar.c = null;
        ajpVar.d = null;
        ajpVar.n = null;
        ajpVar.g = null;
        ajpVar.k = null;
        ajpVar.i = null;
        ajpVar.o = null;
        ajpVar.j = null;
        ajpVar.p = null;
        ajpVar.a.clear();
        ajpVar.l = false;
        ajpVar.b.clear();
        ajpVar.m = false;
        this.ae = false;
        this.k = null;
        this.l = null;
        this.r = null;
        this.m = null;
        this.n = null;
        this.s = null;
        this.ah = 0;
        this.ad = null;
        this.y = null;
        this.z = null;
        this.ab = null;
        this.aj = 0;
        this.ac = null;
        this.u = 0L;
        this.af = false;
        this.v = null;
        this.e.clear();
        this.h.l(this);
    }

    public final void at(int i) {
        this.ai = i;
        awh awhVar = this.s;
        (awhVar.n ? awhVar.j : awhVar.i).execute(this);
    }

    public final void au() {
        if (!this.w.a.containsKey(FastKV.class)) {
            throw new IllegalStateException("OverrideGlideThreadPriority experiment is not enabled.");
        }
        Supplier supplier = this.x;
        if (supplier == null || supplier.get() == null) {
            return;
        }
        try {
            Process.setThreadPriority(Process.myTid(), 9);
        } catch (IllegalArgumentException | SecurityException e) {
            this.x = null;
            if (Log.isLoggable("DecodeJob", 2)) {
                Log.v("DecodeJob", "Failed to set thread priority; using default priority for any subsequent jobs.", e);
            }
        }
    }

    public final void av() {
        this.y = Thread.currentThread();
        int i = bxq.b;
        this.u = SystemClock.elapsedRealtimeNanos();
        boolean zJ = false;
        while (!this.af && this.ad != null && !(zJ = this.ad.j())) {
            this.ah = ap(this.ah);
            this.ad = ao();
            if (this.ah == 4) {
                at(2);
                return;
            }
        }
        if ((this.ah == 6 || this.af) && !zJ) {
            ar();
        }
    }

    public final void aw() {
        int iAe = StaticHelpers6.ae(this.ai);
        if (iAe == 0) {
            this.ah = ap(1);
            this.ad = ao();
            av();
        } else if (iAe == 1) {
            av();
        } else if (iAe == 2) {
            an();
        } else {
            int i = this.ai;
            throw new IllegalStateException("Unrecognized run reason: ".concat(i != 1 ? i != 2 ? i != 3 ? "null" : "DECODE_DATA" : "SWITCH_TO_SOURCE_SERVICE" : "INITIALIZE"));
        }
    }

    public final void ax() {
        this.f.b();
        if (this.ae) {
            throw new IllegalStateException("Already notified", this.e.isEmpty() ? null : (Throwable) StaticHelpers6.getLastNElem(1, this.e));
        }
        this.ae = true;
    }

    @Override // me.hd.wauxv.obf.ajc
    public final void b(btj btjVar, Exception exc, ajb ajbVar, int i) {
        ajbVar.d();
        bhy bhyVar = new bhy("Fetching data failed", Collections.singletonList(exc));
        Class clsB = ajbVar.b();
        bhyVar.c = btjVar;
        bhyVar.d = i;
        bhyVar.e = clsB;
        this.e.add(bhyVar);
        if (Thread.currentThread() != this.y) {
            at(2);
        } else {
            av();
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        ajr ajrVar = (ajr) obj;
        int iOrdinal = this.m.ordinal() - ajrVar.m.ordinal();
        return iOrdinal == 0 ? this.t - ajrVar.t : iOrdinal;
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException
     */
    @Override // java.lang.Runnable
    public final void run() {
        ajb ajbVar = this.ac;
        try {
            try {
                if (this.af) {
                    ar();
                    if (ajbVar != null) {
                        ajbVar.d();
                        return;
                    }
                    return;
                }
                aw();
                if (ajbVar != null) {
                    ajbVar.d();
                }
            } catch (Throwable th) {
                if (ajbVar != null) {
                    ajbVar.d();
                }
                throw th;
            }
        } catch (sx e) {
            throw e;
        } catch (Throwable th2) {
            if (Log.isLoggable("DecodeJob", 3)) {
                Log.d("DecodeJob", "DecodeJob threw unexpectedly, isCancelled: " + this.af + ", stage: " + yg.y(this.ah), th2);
            }
            if (this.ah != 5) {
                this.e.add(th2);
                ar();
            }
            if (!this.af) {
                throw th2;
            }
            throw th2;
        }
    }
}
