package me.hd.wauxv.obf;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cpc {
    public static String b;
    public static cpb e;
    public final Context f;
    public final NotificationManager g;
    public static final Object a = new Object();
    public static HashSet c = new HashSet();
    public static final Object d = new Object();

    public cpc(Context context) {
        this.f = context;
        this.g = (NotificationManager) context.getSystemService("notification");
    }

    public final void h(String str, Notification notification) {
        NotificationManager notificationManager = this.g;
        Bundle bundle = notification.extras;
        if (bundle == null || !bundle.getBoolean("android.support.useSideChannel")) {
            notificationManager.notify(str, 0, notification);
            return;
        }
        coy coyVar = new coy(this.f.getPackageName(), str, notification);
        synchronized (d) {
            try {
                if (e == null) {
                    e = new cpb(this.f.getApplicationContext());
                }
                e.b.obtainMessage(0, coyVar).sendToTarget();
            } catch (Throwable th) {
                throw th;
            }
        }
        notificationManager.cancel(str, 0);
    }
}
