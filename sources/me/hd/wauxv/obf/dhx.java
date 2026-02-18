package me.hd.wauxv.obf;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Trace;
import android.util.Log;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dhx implements bic {
    public static volatile dhx a;
    public final /* synthetic */ int b;
    public boolean c;
    public Object d;
    public AbstractCollection e;

    public dhx(int i) {
        this.b = i;
        switch (i) {
            case 3:
                break;
            default:
                this.d = Collections.newSetFromMap(new WeakHashMap());
                this.e = new HashSet();
                break;
        }
    }

    public static dhx f(Context context) {
        if (a == null) {
            synchronized (dhx.class) {
                try {
                    if (a == null) {
                        a = new dhx(context.getApplicationContext());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return a;
    }

    public boolean g(dbs dbsVar) {
        boolean z = true;
        if (dbsVar == null) {
            return true;
        }
        boolean zRemove = ((Set) this.d).remove(dbsVar);
        if (!((HashSet) this.e).remove(dbsVar) && !zRemove) {
            z = false;
        }
        if (z) {
            dbsVar.clear();
        }
        return z;
    }

    @Override // me.hd.wauxv.obf.bic
    public Object get() {
        if (this.c) {
            throw new IllegalStateException("Recursive Registry initialization! In your AppGlideModule and LibraryGlideModules, Make sure you're using the provided Registry rather calling glide.getRegistry()!");
        }
        cnf.an("Glide registry");
        this.c = true;
        try {
            return aye.p((com.bumptech.glide.a) this.d, (ArrayList) this.e);
        } finally {
            this.c = false;
            Trace.endSection();
        }
    }

    public void h() {
        if (this.c || ((HashSet) this.e).isEmpty()) {
            return;
        }
        aom aomVar = (aom) this.d;
        afr afrVar = (afr) aomVar.c;
        boolean z = false;
        aomVar.a = ((ConnectivityManager) afrVar.get()).getActiveNetwork() != null;
        try {
            ((ConnectivityManager) afrVar.get()).registerDefaultNetworkCallback((dhw) aomVar.d);
            z = true;
        } catch (RuntimeException e) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to register callback", e);
            }
        }
        this.c = z;
    }

    public String toString() {
        switch (this.b) {
            case 2:
                return super.toString() + "{numRequests=" + ((Set) this.d).size() + ", isPaused=" + this.c + "}";
            default:
                return super.toString();
        }
    }

    public dhx(Context context) {
        this.b = 0;
        this.e = new HashSet();
        this.d = new aom(new afr(new anr(context, 11)), new dhu(this));
    }

    public dhx(com.bumptech.glide.a aVar, ArrayList arrayList, cna cnaVar) {
        this.b = 1;
        this.d = aVar;
        this.e = arrayList;
    }
}
