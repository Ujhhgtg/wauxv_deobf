package me.hd.wauxv.obf;

import android.app.Activity;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class hv {
    public static OnBackInvokedDispatcher a(Activity activity) {
        return activity.getOnBackInvokedDispatcher();
    }

    public static OnBackInvokedCallback b(Object obj, AppCompatDelegate appCompatDelegateVar) {
        Objects.requireNonNull(appCompatDelegateVar);
        hu huVar = new hu(appCompatDelegateVar, 0);
        av.e(obj).registerOnBackInvokedCallback(1000000, huVar);
        return huVar;
    }

    public static void c(Object obj, Object obj2) {
        av.e(obj).unregisterOnBackInvokedCallback(av.c(obj2));
    }
}
