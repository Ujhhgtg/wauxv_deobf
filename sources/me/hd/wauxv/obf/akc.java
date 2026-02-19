package me.hd.wauxv.obf;

import android.content.Context;
import android.net.ConnectivityManager;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class akc implements acz {
    public final Context a;
    public final dbz b;

    public akc(Context context, dbz dbzVar) {
        this.a = context.getApplicationContext();
        this.b = dbzVar;
    }

    @Override // me.hd.wauxv.obf.bun
    public final void j() {
    }

    @Override // me.hd.wauxv.obf.bun
    public final void m() {
        ConnectivityMonitor connectivityMonitorVarF = ConnectivityMonitor.f(this.a);
        dbz dbzVar = this.b;
        synchronized (connectivityMonitorVarF) {
            ((HashSet) connectivityMonitorVarF.e).remove(dbzVar);
            if (connectivityMonitorVarF.c && ((HashSet) connectivityMonitorVarF.e).isEmpty()) {
                aom aomVar = (aom) connectivityMonitorVarF.d;
                ((ConnectivityManager) ((afr) aomVar.c).get()).unregisterNetworkCallback((dhw) aomVar.d);
                connectivityMonitorVarF.c = false;
            }
        }
    }

    @Override // me.hd.wauxv.obf.bun
    public final void q() {
        ConnectivityMonitor connectivityMonitorVarF = ConnectivityMonitor.f(this.a);
        dbz dbzVar = this.b;
        synchronized (connectivityMonitorVarF) {
            ((HashSet) connectivityMonitorVarF.e).add(dbzVar);
            connectivityMonitorVarF.h();
        }
    }
}
