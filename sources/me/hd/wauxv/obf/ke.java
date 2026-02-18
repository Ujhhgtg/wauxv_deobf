package me.hd.wauxv.obf;

import android.app.Activity;
import android.app.Notification;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Insets;
import android.os.Trace;
import me.hd.wauxv.obf.cvs;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ke {
    public static String a(Context context) {
        return context.getOpPackageName();
    }

    public static boolean b() {
        return Trace.isEnabled();
    }

    public static Insets c(int i, int i2, int i3, int i4) {
        return Insets.of(i, i2, i3, i4);
    }

    public static void d(Resources.Theme theme) {
        theme.rebase();
    }

    public static final void e(Activity activity, cvs.a aVar) {
        activity.registerActivityLifecycleCallbacks(aVar);
    }

    public static void f(Notification.Builder builder) {
        builder.setAllowSystemGeneratedContextualActions(true);
    }

    public static void g(Notification.Builder builder) {
        builder.setBubbleMetadata(null);
    }
}
