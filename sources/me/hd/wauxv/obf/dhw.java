package me.hd.wauxv.obf;

import android.net.ConnectivityManager;
import android.net.Network;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dhw extends ConnectivityManager.NetworkCallback {
    public final /* synthetic */ aom a;

    public dhw(aom aomVar) {
        this.a = aomVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        eot.i().post(new dhv(this, true));
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        eot.i().post(new dhv(this, false));
    }
}
