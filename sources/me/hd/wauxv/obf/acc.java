package me.hd.wauxv.obf;

import android.app.Activity;
import android.window.OnBackInvokedDispatcher;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class acc {
    public static final acc a = new acc();

    public final OnBackInvokedDispatcher b(Activity activity) {
        throwIfVar1IsNull(activity, "activity");
        OnBackInvokedDispatcher onBackInvokedDispatcher = activity.getOnBackInvokedDispatcher();
        throwIfVar1IsNull(onBackInvokedDispatcher, "activity.getOnBackInvokedDispatcher()");
        return onBackInvokedDispatcher;
    }
}
