package me.hd.wauxv.obf;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Looper;
import android.util.Log;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dca implements ComponentCallbacks2, bun {
    public static final dcd a;
    public final com.bumptech.glide.a b;
    public final Context c;
    public final bui d;
    public final dhx e;
    public final dcc f;
    public final dpx g;
    public final dc h;
    public final acz i;
    public final CopyOnWriteArrayList k;
    public final dcd l;

    static {
        dcd dcdVar = (dcd) new dcd().s(Bitmap.class);
        dcdVar.l = true;
        a = dcdVar;
        ((dcd) new dcd().s(bha.class)).l = true;
    }

    public dca(com.bumptech.glide.a aVar, bui buiVar, dcc dccVar, Context context) {
        dcd dcdVar;
        dhx dhxVar = new dhx(2);
        nu nuVar = aVar.h;
        this.g = new dpx();
        dc dcVar = new dc(this, 14);
        this.h = dcVar;
        this.b = aVar;
        this.d = buiVar;
        this.f = dccVar;
        this.e = dhxVar;
        this.c = context;
        Context applicationContext = context.getApplicationContext();
        dbz dbzVar = new dbz(this, dhxVar);
        nuVar.getClass();
        boolean z = bht.s(applicationContext, "android.permission.ACCESS_NETWORK_STATE") == 0;
        if (Log.isLoggable("ConnectivityMonitor", 3)) {
            Log.d("ConnectivityMonitor", z ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor");
        }
        acz akcVar = z ? new akc(applicationContext, dbzVar) : new cpd();
        this.i = akcVar;
        synchronized (aVar.i) {
            if (aVar.i.contains(this)) {
                throw new IllegalStateException("Cannot register already registered manager");
            }
            aVar.i.add(this);
        }
        char[] cArr = eot.a;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            buiVar.al(this);
        } else {
            eot.i().post(dcVar);
        }
        buiVar.al(akcVar);
        this.k = new CopyOnWriteArrayList(aVar.e.f);
        bhw bhwVar = aVar.e;
        synchronized (bhwVar) {
            try {
                if (bhwVar.k == null) {
                    bhwVar.e.getClass();
                    dcd dcdVar2 = new dcd();
                    dcdVar2.l = true;
                    bhwVar.k = dcdVar2;
                }
                dcdVar = bhwVar.k;
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this) {
            dcd dcdVar3 = (dcd) dcdVar.clone();
            if (dcdVar3.l && !dcdVar3.m) {
                throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
            }
            dcdVar3.m = true;
            dcdVar3.l = true;
            this.l = dcdVar3;
        }
    }

    @Override // me.hd.wauxv.obf.bun
    public final synchronized void j() {
        this.g.j();
        o();
        dhx dhxVar = this.e;
        Iterator it = eot.h((Set) dhxVar.d).iterator();
        while (it.hasNext()) {
            dhxVar.g((dbs) it.next());
        }
        ((HashSet) dhxVar.e).clear();
        this.d.an(this);
        this.d.an(this.i);
        eot.i().removeCallbacks(this.h);
        com.bumptech.glide.a aVar = this.b;
        synchronized (aVar.i) {
            if (!aVar.i.contains(this)) {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
            aVar.i.remove(this);
        }
    }

    @Override // me.hd.wauxv.obf.bun
    public final synchronized void m() {
        this.g.m();
        p();
    }

    public final void n(dpw dpwVar) {
        if (dpwVar == null) {
            return;
        }
        boolean zS = s(dpwVar);
        dbs dbsVarO = dpwVar.o();
        if (zS) {
            return;
        }
        com.bumptech.glide.a aVar = this.b;
        synchronized (aVar.i) {
            try {
                Iterator it = aVar.i.iterator();
                while (it.hasNext()) {
                    if (((dca) it.next()).s(dpwVar)) {
                        return;
                    }
                }
                if (dbsVarO != null) {
                    dpwVar.h(null);
                    dbsVarO.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized void o() {
        try {
            Iterator it = eot.h(this.g.a).iterator();
            while (it.hasNext()) {
                n((dpw) it.next());
            }
            this.g.a.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
    }

    public final synchronized void p() {
        dhx dhxVar = this.e;
        dhxVar.c = true;
        for (dbs dbsVar : eot.h((Set) dhxVar.d)) {
            if (dbsVar.isRunning()) {
                dbsVar.j();
                ((HashSet) dhxVar.e).add(dbsVar);
            }
        }
    }

    @Override // me.hd.wauxv.obf.bun
    public final synchronized void q() {
        r();
        this.g.q();
    }

    public final synchronized void r() {
        dhx dhxVar = this.e;
        dhxVar.c = false;
        for (dbs dbsVar : eot.h((Set) dhxVar.d)) {
            if (!dbsVar.q() && !dbsVar.isRunning()) {
                dbsVar.n();
            }
        }
        ((HashSet) dhxVar.e).clear();
    }

    public final synchronized boolean s(dpw dpwVar) {
        dbs dbsVarO = dpwVar.o();
        if (dbsVarO == null) {
            return true;
        }
        if (!this.e.g(dbsVarO)) {
            return false;
        }
        this.g.a.remove(dpwVar);
        dpwVar.h(null);
        return true;
    }

    public final synchronized String toString() {
        return super.toString() + "{tracker=" + this.e + ", treeNode=" + this.f + "}";
    }
}
