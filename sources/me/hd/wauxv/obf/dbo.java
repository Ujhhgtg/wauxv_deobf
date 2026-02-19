package me.hd.wauxv.obf;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class dbo {
    /* JADX WARN: Multi-variable type inference failed */
    public static void a(Activity activity, LifeEventEnum lifeEventEnumVar) {
        bur burVarAp;
        throwIfVar1IsNull(lifeEventEnumVar, "event");
        if (!(activity instanceof bup) || (burVarAp = ((bup) activity).ap()) == null) {
            return;
        }
        burVarAp.m(lifeEventEnumVar);
    }

    public static void b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 29) {
            dbq.a.Companion.getClass();
            activity.registerActivityLifecycleCallbacks(new dbq.a());
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction()
                    .add(new dbq(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }
}
