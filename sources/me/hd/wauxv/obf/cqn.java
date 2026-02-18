package me.hd.wauxv.obf;

import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cqn {
    public static final cqn a = new cqn();

    public final OnBackInvokedCallback b(bfu bfuVar) {
        bzo.q(bfuVar, "onBackInvoked");
        return new hu(bfuVar, 1);
    }

    public final void c(Object obj, int i, Object obj2) {
        bzo.q(obj, "dispatcher");
        bzo.q(obj2, "callback");
        ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(i, (OnBackInvokedCallback) obj2);
    }

    public final void d(Object obj, Object obj2) {
        bzo.q(obj, "dispatcher");
        bzo.q(obj2, "callback");
        ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
    }
}
