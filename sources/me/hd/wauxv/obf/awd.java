package me.hd.wauxv.obf;

import android.os.SystemClock;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class awd implements awi, awk {
    public static final boolean a = Log.isLoggable("Engine", 2);
    public final aji b;
    public final nu c;
    public final byk d;
    public final awc e;
    public final cxc f;
    public final ik g;
    public final FactoryPools h;

    public awd(byk bykVar, SyntheticPileOfMess bmuVar, bia biaVar, bia biaVar2, bia biaVar3, bia biaVar4) {
        this.d = bykVar;
        afr afrVar = new afr(bmuVar);
        FactoryPools factoryPoolsVar = new FactoryPools(1);
        this.h = factoryPoolsVar;
        synchronized (this) {
            synchronized (factoryPoolsVar) {
                factoryPoolsVar.h = this;
            }
        }
        this.c = new nu(29);
        this.b = new aji(2);
        awc awcVar = new awc();
        awcVar.g = StaticAndroidHelpers.aw(150, new erp(awcVar, 22));
        awcVar.a = biaVar;
        awcVar.b = biaVar2;
        awcVar.c = biaVar3;
        awcVar.d = biaVar4;
        awcVar.e = this;
        awcVar.f = this;
        this.e = awcVar;
        this.g = new ik(afrVar);
        this.f = new cxc();
        bykVar.i = this;
    }

    public static void i(String str, long j, awj awjVar) {
        StringBuilder sbR = concat(str, " in ");
        sbR.append(bxq.c(j));
        sbR.append("ms, key: ");
        sbR.append(awjVar);
        Log.v("Engine", sbR.toString());
    }

    public static void j(dcg dcgVar) {
        if (!(dcgVar instanceof awl)) {
            throw new IllegalArgumentException("Cannot release anything but an EngineResource");
        }
        ((awl) dcgVar).l();
    }

    public final FactoryPools k(bhw bhwVar, Object obj, btj btjVar, int i, int i2, Class cls, Class cls2, cvq cvqVar, aoi aoiVar, sp spVar, boolean z, boolean z2, crw crwVar, boolean z3, boolean z4, dht dhtVar, hn hnVar) {
        long jElapsedRealtimeNanos;
        if (a) {
            int i3 = bxq.b;
            jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        } else {
            jElapsedRealtimeNanos = 0;
        }
        this.c.getClass();
        awj awjVar = new awj(obj, btjVar, i, i2, spVar, cls, cls2, crwVar);
        synchronized (this) {
            try {
                awl awlVarL = l(awjVar, z3, jElapsedRealtimeNanos);
                if (awlVarL == null) {
                    return o(bhwVar, obj, btjVar, i, i2, cls, cls2, cvqVar, aoiVar, spVar, z, z2, crwVar, z3, z4, dhtVar, hnVar, awjVar, jElapsedRealtimeNanos);
                }
                dhtVar.am(awlVarL, 5, false);
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getPredecessors()" because "start" is null
    	at jadx.core.utils.BlockUtils.followEmptyUpPathWithinSet(BlockUtils.java:1223)
    	at jadx.core.utils.BlockUtils.followEmptyUpPathWithinSet(BlockUtils.java:1217)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.cutHandlerBlocks(MarkFinallyVisitor.java:249)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:123)
     */
    public final awl l(awj awjVar, boolean z, long j) throws Throwable {
        Throwable th;
        awl awlVar;
        Object obj;
        awd awdVar;
        awj awjVar2;
        awl awlVar2;
        if (z) {
            FactoryPools factoryPoolsVar = this.h;
            synchronized (factoryPoolsVar) {
                try {
                    de deVar = (de) ((HashMap) factoryPoolsVar.e).get(awjVar);
                    if (deVar == null) {
                        awlVar = null;
                    } else {
                        awlVar = (awl) deVar.get();
                        if (awlVar == null) {
                            try {
                                factoryPoolsVar.n(deVar);
                            } catch (Throwable th2) {
                                th = th2;
                                while (true) {
                                    try {
                                        throw th;
                                    } catch (Throwable th3) {
                                        th = th3;
                                    }
                                    th = th3;
                                }
                            }
                        }
                    }
                    if (awlVar != null) {
                        awlVar.k();
                    }
                    if (awlVar != null) {
                        if (a) {
                            i("Loaded resource from active resources", j, awjVar);
                        }
                        return awlVar;
                    }
                    byk bykVar = this.d;
                    synchronized (bykVar) {
                        try {
                            byh byhVar = (byh) bykVar.a.remove(awjVar);
                            if (byhVar == null) {
                                obj = null;
                            } else {
                                bykVar.c -= (long) byhVar.b;
                                obj = byhVar.a;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            while (true) {
                                try {
                                    throw th;
                                } catch (Throwable th5) {
                                    th = th5;
                                }
                            }
                        }
                    }
                    dcg dcgVar = (dcg) obj;
                    if (dcgVar == null) {
                        awdVar = this;
                        awjVar2 = awjVar;
                        awlVar2 = null;
                    } else if (dcgVar instanceof awl) {
                        awlVar2 = (awl) dcgVar;
                        awdVar = this;
                        awjVar2 = awjVar;
                    } else {
                        awdVar = this;
                        awjVar2 = awjVar;
                        awlVar2 = new awl(dcgVar, true, true, awjVar2, awdVar);
                    }
                    if (awlVar2 != null) {
                        awlVar2.k();
                        awdVar.h.m(awjVar2, awlVar2);
                    }
                    if (awlVar2 != null) {
                        if (a) {
                            i("Loaded resource from cache", j, awjVar2);
                        }
                        return awlVar2;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            }
        }
        return null;
    }

    public final synchronized void m(awh awhVar, btj btjVar, awl awlVar) {
        if (awlVar != null) {
            try {
                if (awlVar.a) {
                    this.h.m(btjVar, awlVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        aji ajiVar = this.b;
        ajiVar.getClass();
        awhVar.getClass();
        HashMap map = ajiVar.b;
        if (awhVar.equals(map.get(btjVar))) {
            map.remove(btjVar);
        }
    }

    public final void n(btj btjVar, awl awlVar) {
        FactoryPools factoryPoolsVar = this.h;
        synchronized (factoryPoolsVar) {
            de deVar = (de) ((HashMap) factoryPoolsVar.e).remove(btjVar);
            if (deVar != null) {
                deVar.c = null;
                deVar.clear();
            }
        }
        if (awlVar.a) {
        } else {
            this.f.o(awlVar, false);
        }
    }

    public final FactoryPools o(bhw bhwVar, Object obj, btj btjVar, int i, int i2, Class cls, Class cls2, cvq cvqVar, aoi aoiVar, Map map, boolean z, boolean z2, crw crwVar, boolean z3, boolean z4, dht dhtVar, Executor executor, awj awjVar, long j) {
        awh awhVar = (awh) this.b.b.get(awjVar);
        if (awhVar != null) {
            awhVar.x(dhtVar, executor);
            if (a) {
                i("Added to existing load", j, awjVar);
            }
            return new FactoryPools(this, dhtVar, awhVar);
        }
        awh awhVar2 = (awh) ((FactoryPools) this.e.g).acquire();
        synchronized (awhVar2) {
            awhVar2.l = awjVar;
            awhVar2.m = z3;
            awhVar2.n = z4;
        }
        ik ikVar = this.g;
        ajr ajrVar = (ajr) ((FactoryPools) ikVar.d).acquire();
        int i3 = ikVar.b;
        ikVar.b = i3 + 1;
        ajp ajpVar = ajrVar.d;
        afr afrVar = ajrVar.g;
        ajpVar.c = bhwVar;
        ajpVar.d = obj;
        ajpVar.n = btjVar;
        ajpVar.e = i;
        ajpVar.f = i2;
        ajpVar.p = aoiVar;
        ajpVar.g = cls;
        ajpVar.h = afrVar;
        ajpVar.k = cls2;
        ajpVar.o = cvqVar;
        ajpVar.i = crwVar;
        ajpVar.j = map;
        ajpVar.q = z;
        ajpVar.r = z2;
        ajrVar.k = bhwVar;
        ajrVar.l = btjVar;
        ajrVar.m = cvqVar;
        ajrVar.n = awjVar;
        ajrVar.o = i;
        ajrVar.p = i2;
        ajrVar.q = aoiVar;
        ajrVar.r = crwVar;
        ajrVar.s = awhVar2;
        ajrVar.t = i3;
        ajrVar.ai = 1;
        ajrVar.v = obj;
        ajrVar.w = bhwVar.i;
        ajrVar.x = (Supplier) crwVar.b(ajr.c);
        aji ajiVar = this.b;
        ajiVar.getClass();
        ajiVar.b.put(awjVar, awhVar2);
        awhVar2.x(dhtVar, executor);
        synchronized (awhVar2) {
            awhVar2.u = ajrVar;
            int iAp = ajrVar.ap(1);
            ((iAp == 2 || iAp == 3) ? awhVar2.h : awhVar2.n ? awhVar2.j : awhVar2.i).execute(ajrVar);
        }
        if (a) {
            i("Started new load", j, awjVar);
        }
        return new FactoryPools(this, dhtVar, awhVar2);
    }
}
