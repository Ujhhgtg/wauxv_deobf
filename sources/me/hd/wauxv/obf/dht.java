package me.hd.wauxv.obf;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dht implements dbs, dic {
    public static final boolean a = Log.isLoggable("GlideRequest", 2);
    public Drawable aa;
    public Drawable ab;
    public Drawable ac;
    public int ad;
    public int ae;
    public boolean af;
    public final RuntimeException ag;
    public int ah;
    public final String b;
    public final dmn c;
    public final Object d;
    public final dbw e;
    public final bhw f;
    public final Object h;
    public final Class i;
    public final nj k;
    public final int o;
    public final int p;
    public final cvq r;
    public final dpw s;
    public final List t;
    public final cbm u;
    public final hn v;
    public dcg w;
    public jx x;
    public long y;
    public volatile awd z;

    public dht(Context context, bhw bhwVar, Object obj, Object obj2, Class cls, nj njVar, int i, int i2, cvq cvqVar, dpw dpwVar, ArrayList arrayList, dbw dbwVar, awd awdVar, cbm cbmVar) {
        hn hnVar = emn.z;
        this.b = a ? String.valueOf(hashCode()) : null;
        this.c = new dmn();
        this.d = obj;
        this.f = bhwVar;
        this.h = obj2;
        this.i = cls;
        this.k = njVar;
        this.o = i;
        this.p = i2;
        this.r = cvqVar;
        this.s = dpwVar;
        this.t = arrayList;
        this.e = dbwVar;
        this.z = awdVar;
        this.u = cbmVar;
        this.v = hnVar;
        this.ah = 1;
        if (this.ag == null && bhwVar.i.a.containsKey(bht.class)) {
            this.ag = new RuntimeException("Glide request origin trace");
        }
    }

    public final void ai() {
        if (this.af) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
        this.c.b();
        this.s.k(this);
        jx jxVar = this.x;
        if (jxVar != null) {
            synchronized (((awd) jxVar.h)) {
                ((awh) jxVar.e).ad((dht) jxVar.f);
            }
            this.x = null;
        }
    }

    public final Drawable aj() {
        if (this.ab == null) {
            this.k.getClass();
            this.ab = null;
        }
        return this.ab;
    }

    public final void ak(String str) {
        StringBuilder sbR = concat(str, " this: ");
        sbR.append(this.b);
        Log.v("GlideRequest", sbR.toString());
    }

    public final void al(bhy bhyVar, int i) {
        Drawable drawableAj;
        this.c.b();
        synchronized (this.d) {
            try {
                bhyVar.getClass();
                int i2 = this.f.j;
                if (i2 <= i) {
                    Log.w("Glide", "Load failed for [" + this.h + "] with dimensions [" + this.ad + "x" + this.ae + "]", bhyVar);
                    if (i2 <= 4) {
                        bhyVar.j();
                    }
                }
                this.x = null;
                this.ah = 5;
                dbw dbwVar = this.e;
                if (dbwVar != null) {
                    dbwVar.k(this);
                }
                boolean z = true;
                this.af = true;
                try {
                    List list = this.t;
                    if (list != null) {
                        Iterator it = list.iterator();
                        if (it.hasNext()) {
                            if (it.next() != null) {
                                throw new ClassCastException();
                            }
                            dbw dbwVar2 = this.e;
                            if (dbwVar2 == null) {
                                throw null;
                            }
                            dbwVar2.getRoot().g();
                            throw null;
                        }
                    }
                    dbw dbwVar3 = this.e;
                    if (dbwVar3 != null && !dbwVar3.i(this)) {
                        z = false;
                    }
                    if (z) {
                        if (this.h == null) {
                            if (this.ac == null) {
                                this.k.getClass();
                                this.ac = null;
                            }
                            drawableAj = this.ac;
                        } else {
                            drawableAj = null;
                        }
                        if (drawableAj == null) {
                            if (this.aa == null) {
                                this.k.getClass();
                                this.aa = null;
                            }
                            drawableAj = this.aa;
                        }
                        if (drawableAj == null) {
                            drawableAj = aj();
                        }
                        this.s.l(drawableAj);
                    }
                    this.af = false;
                } catch (Throwable th) {
                    this.af = false;
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getSuccessors()" because "blk" is null
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.exploreTryPath(TryCatchBlockAttr.java:210)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:196)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:180)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getTryEdges(TryCatchBlockAttr.java:201)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getEdgeBlockMap(TryCatchBlockAttr.java:347)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getExecutionScopeGroups(TryCatchBlockAttr.java:356)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:119)
     */
    public final void am(dcg dcgVar, int i, boolean z) {
        this.c.b();
        dcg dcgVar2 = null;
        try {
            synchronized (this.d) {
                try {
                    this.x = null;
                    if (dcgVar == null) {
                        al(new bhy("Expected to receive a Resource<R> with an object of " + this.i + " inside, but instead got null."), 5);
                        return;
                    }
                    Object obj = dcgVar.get();
                    try {
                        if (obj == null || !this.i.isAssignableFrom(obj.getClass())) {
                            this.w = null;
                            StringBuilder sb = new StringBuilder("Expected to receive an object of ");
                            sb.append(this.i);
                            sb.append(" but instead got ");
                            sb.append(obj != null ? obj.getClass() : "");
                            sb.append("{");
                            sb.append(obj);
                            sb.append("} inside Resource{");
                            sb.append(dcgVar);
                            sb.append("}.");
                            sb.append(obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
                            al(new bhy(sb.toString()), 5);
                        } else {
                            dbw dbwVar = this.e;
                            if (dbwVar == null || dbwVar.p(this)) {
                                an(dcgVar, obj, i);
                                return;
                            } else {
                                this.w = null;
                                this.ah = 4;
                            }
                        }
                        this.z.getClass();
                        awd.j(dcgVar);
                    } catch (Throwable th) {
                        dcgVar2 = dcgVar;
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            if (dcgVar2 != null) {
                this.z.getClass();
                awd.j(dcgVar2);
            }
            throw th3;
        }
    }

    public final void an(dcg dcgVar, Object obj, int i) {
        dbw dbwVar = this.e;
        if (dbwVar != null) {
            dbwVar.getRoot().g();
        }
        this.ah = 4;
        this.w = dcgVar;
        if (this.f.j <= 3) {
            Log.d("Glide", "Finished loading " + obj.getClass().getSimpleName() + " from " + yg.x(i) + " for " + this.h + " with size [" + this.ad + "x" + this.ae + "] in " + bxq.c(this.y) + " ms");
        }
        if (dbwVar != null) {
            dbwVar.o(this);
        }
        this.af = true;
        try {
            List list = this.t;
            if (list != null) {
                Iterator it = list.iterator();
                if (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    throw null;
                }
            }
            this.u.getClass();
            this.s.i(obj);
            this.af = false;
        } catch (Throwable th) {
            this.af = false;
            throw th;
        }
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getSuccessors()" because "blk" is null
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.exploreTryPath(TryCatchBlockAttr.java:210)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:196)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:180)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getTryEdges(TryCatchBlockAttr.java:201)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getEdgeBlockMap(TryCatchBlockAttr.java:347)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getExecutionScopeGroups(TryCatchBlockAttr.java:356)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:119)
     */
    public final void ao(int i, int i2) throws Throwable {
        Object obj;
        dht dhtVar = this;
        int iRound = i;
        dhtVar.c.b();
        Object obj2 = dhtVar.d;
        synchronized (obj2) {
            try {
                try {
                    boolean z = a;
                    if (z) {
                        dhtVar.ak("Got onSizeReady in " + bxq.c(dhtVar.y));
                    }
                    if (dhtVar.ah == 3) {
                        dhtVar.ah = 2;
                        dhtVar.k.getClass();
                        if (iRound != Integer.MIN_VALUE) {
                            iRound = Math.round(iRound * 1.0f);
                        }
                        dhtVar.ad = iRound;
                        dhtVar.ae = i2 == Integer.MIN_VALUE ? i2 : Math.round(1.0f * i2);
                        if (z) {
                            dhtVar.ak("finished setup for calling load in " + bxq.c(dhtVar.y));
                        }
                        awd awdVar = dhtVar.z;
                        bhw bhwVar = dhtVar.f;
                        Object obj3 = dhtVar.h;
                        nj njVar = dhtVar.k;
                        btj btjVar = njVar.g;
                        try {
                            int i3 = dhtVar.ad;
                            int i4 = dhtVar.ae;
                            Class cls = njVar.k;
                            try {
                                Class cls2 = dhtVar.i;
                                cvq cvqVar = dhtVar.r;
                                aoi aoiVar = njVar.b;
                                try {
                                    sp spVar = njVar.j;
                                    boolean z2 = njVar.h;
                                    boolean z3 = njVar.n;
                                    try {
                                        crw crwVar = njVar.i;
                                        boolean z4 = njVar.d;
                                        boolean z5 = njVar.o;
                                        hn hnVar = dhtVar.v;
                                        Object obj4 = obj2;
                                        try {
                                            dhtVar.x = awdVar.k(bhwVar, obj3, btjVar, i3, i4, cls, cls2, cvqVar, aoiVar, spVar, z2, z3, crwVar, z4, z5, dhtVar, hnVar);
                                            if (dhtVar.ah != 2) {
                                                dhtVar.x = null;
                                            }
                                            if (z) {
                                                dhtVar.ak("finished onSizeReady in " + bxq.c(dhtVar.y));
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            obj = obj4;
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        obj = obj2;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    obj = obj2;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                obj = obj2;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            obj = obj2;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    obj = dhtVar;
                }
            } catch (Throwable th7) {
                th = th7;
                obj = obj2;
            }
        }
    }

    @Override // me.hd.wauxv.obf.dbs
    public final void clear() {
        synchronized (this.d) {
            try {
                if (this.af) {
                    throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
                }
                this.c.b();
                if (this.ah == 6) {
                    return;
                }
                ai();
                dcg dcgVar = this.w;
                if (dcgVar != null) {
                    this.w = null;
                } else {
                    dcgVar = null;
                }
                dbw dbwVar = this.e;
                if (dbwVar == null || dbwVar.h(this)) {
                    this.s.p(aj());
                }
                this.ah = 6;
                if (dcgVar != null) {
                    this.z.getClass();
                    awd.j(dcgVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // me.hd.wauxv.obf.dbs
    public final boolean g() {
        boolean z;
        synchronized (this.d) {
            z = this.ah == 4;
        }
        return z;
    }

    @Override // me.hd.wauxv.obf.dbs
    public final boolean isRunning() {
        boolean z;
        synchronized (this.d) {
            int i = this.ah;
            z = i == 2 || i == 3;
        }
        return z;
    }

    @Override // me.hd.wauxv.obf.dbs
    public final void j() {
        synchronized (this.d) {
            try {
                if (isRunning()) {
                    clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // me.hd.wauxv.obf.dbs
    public final boolean l(dbs dbsVar) {
        int i;
        int i2;
        Object obj;
        Class cls;
        nj njVar;
        cvq cvqVar;
        int size;
        int i3;
        int i4;
        Object obj2;
        Class cls2;
        nj njVar2;
        cvq cvqVar2;
        int size2;
        if (!(dbsVar instanceof dht)) {
            return false;
        }
        synchronized (this.d) {
            try {
                i = this.o;
                i2 = this.p;
                obj = this.h;
                cls = this.i;
                njVar = this.k;
                cvqVar = this.r;
                List list = this.t;
                size = list != null ? list.size() : 0;
            } catch (Throwable th) {
                throw th;
            }
        }
        dht dhtVar = (dht) dbsVar;
        synchronized (dhtVar.d) {
            try {
                i3 = dhtVar.o;
                i4 = dhtVar.p;
                obj2 = dhtVar.h;
                cls2 = dhtVar.i;
                njVar2 = dhtVar.k;
                cvqVar2 = dhtVar.r;
                List list2 = dhtVar.t;
                size2 = list2 != null ? list2.size() : 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (i == i3 && i2 == i4) {
            char[] cArr = eot.a;
            if ((obj == null ? obj2 == null : obj.equals(obj2)) && cls.equals(cls2)) {
                if ((njVar == null ? njVar2 == null : njVar.u(njVar2)) && cvqVar == cvqVar2 && size == size2) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // me.hd.wauxv.obf.dbs
    public final boolean m() {
        boolean z;
        synchronized (this.d) {
            z = this.ah == 6;
        }
        return z;
    }

    @Override // me.hd.wauxv.obf.dbs
    public final void n() {
        synchronized (this.d) {
            try {
                if (this.af) {
                    throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
                }
                this.c.b();
                int i = bxq.b;
                this.y = SystemClock.elapsedRealtimeNanos();
                if (this.h == null) {
                    if (eot.l(this.o, this.p)) {
                        this.ad = this.o;
                        this.ae = this.p;
                    }
                    if (this.ac == null) {
                        this.k.getClass();
                        this.ac = null;
                    }
                    al(new bhy("Received null model"), this.ac == null ? 5 : 3);
                    return;
                }
                int i2 = this.ah;
                if (i2 == 2) {
                    throw new IllegalArgumentException("Cannot restart a running request");
                }
                if (i2 == 4) {
                    am(this.w, 5, false);
                    return;
                }
                List list = this.t;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        if (it.next() != null) {
                            throw new ClassCastException();
                        }
                    }
                }
                this.ah = 3;
                if (eot.l(this.o, this.p)) {
                    ao(this.o, this.p);
                } else {
                    this.s.r(this);
                }
                int i3 = this.ah;
                if (i3 == 2 || i3 == 3) {
                    dbw dbwVar = this.e;
                    if (dbwVar == null || dbwVar.i(this)) {
                        this.s.n(aj());
                    }
                }
                if (a) {
                    ak("finished run method in " + bxq.c(this.y));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // me.hd.wauxv.obf.dbs
    public final boolean q() {
        boolean z;
        synchronized (this.d) {
            z = this.ah == 4;
        }
        return z;
    }

    public final String toString() {
        Object obj;
        Class cls;
        synchronized (this.d) {
            obj = this.h;
            cls = this.i;
        }
        return super.toString() + "[model=" + obj + ", transcodeClass=" + cls + "]";
    }
}
