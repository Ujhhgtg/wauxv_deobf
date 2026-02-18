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
        dhx dhxVarF = dhx.f(this.a);
        dbz dbzVar = this.b;
        synchronized (dhxVarF) {
            ((HashSet) dhxVarF.e).remove(dbzVar);
            if (dhxVarF.c && ((HashSet) dhxVarF.e).isEmpty()) {
                aom aomVar = (aom) dhxVarF.d;
                ((ConnectivityManager) ((afr) aomVar.c).get()).unregisterNetworkCallback((dhw) aomVar.d);
                dhxVarF.c = false;
            }
        }
    }

    @Override // me.hd.wauxv.obf.bun
    public final void q() {
        dhx dhxVarF = dhx.f(this.a);
        dbz dbzVar = this.b;
        synchronized (dhxVarF) {
            ((HashSet) dhxVarF.e).add(dbzVar);
            dhxVarF.h();
        }
    }
}
