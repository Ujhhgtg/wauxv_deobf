package com.umeng.analytics.pro;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.umeng.commonsdk.debug.UMRTLog;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class o implements Application.ActivityLifecycleCallbacks {
    private static o a = new o();
    private final int b = 3000;
    private boolean c = false;
    private boolean d = true;
    private Handler e = new Handler(Looper.getMainLooper());
    private ArrayList<p> f = new ArrayList<>();
    private a g = new a();

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!o.this.c || !o.this.d) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> still foreground.");
                return;
            }
            o.this.c = false;
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> went background.");
            for (int i = 0; i < o.this.f.size(); i++) {
                ((p) o.this.f.get(i)).n();
            }
        }
    }

    private o() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        this.d = true;
        a aVar = this.g;
        if (aVar != null) {
            this.e.removeCallbacks(aVar);
            this.e.postDelayed(this.g, 3000L);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.d = false;
        this.c = true;
        a aVar = this.g;
        if (aVar != null) {
            this.e.removeCallbacks(aVar);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    public synchronized void b(p pVar) {
        if (pVar != null) {
            for (int i = 0; i < this.f.size(); i++) {
                try {
                    if (this.f.get(i) == pVar) {
                        this.f.remove(i);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static void a(Context context) {
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(a);
        }
    }

    public static o a() {
        return a;
    }

    public synchronized void a(p pVar) {
        if (pVar != null) {
            this.f.add(pVar);
        }
    }
}
