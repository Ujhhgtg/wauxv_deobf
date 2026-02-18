package me.hd.wauxv.obf;

import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cvs extends auy {
    final /* synthetic */ cvt this$0;

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static final class a extends auy {
        final /* synthetic */ cvt this$0;

        public a(cvt cvtVar) {
            this.this$0 = cvtVar;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            throwIfVar1IsNull(activity, "activity");
            this.this$0.j();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            throwIfVar1IsNull(activity, "activity");
            cvt cvtVar = this.this$0;
            int i = cvtVar.b + 1;
            cvtVar.b = i;
            if (i == 1 && cvtVar.e) {
                cvtVar.g.m(bug.ON_START);
                cvtVar.e = false;
            }
        }
    }

    public cvs(cvt cvtVar) {
        this.this$0 = cvtVar;
    }

    @Override // me.hd.wauxv.obf.auy, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        throwIfVar1IsNull(activity, "activity");
        if (Build.VERSION.SDK_INT < 29) {
            int i = dbq.a;
            Fragment fragmentFindFragmentByTag = activity.getFragmentManager()
                    .findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
            throwIfVar1IsNull(fragmentFindFragmentByTag,
                    "null cannot be cast to non-null type androidx.lifecycle.ReportFragment");
            ((dbq) fragmentFindFragmentByTag).b = this.this$0.i;
        }
    }

    @Override // me.hd.wauxv.obf.auy, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        throwIfVar1IsNull(activity, "activity");
        cvt cvtVar = this.this$0;
        int i = cvtVar.c - 1;
        cvtVar.c = i;
        if (i == 0) {
            Handler handler = cvtVar.f;
            throwIfVar1IsNull(handler);
            handler.postDelayed(cvtVar.h, 700L);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(Activity activity, Bundle bundle) {
        throwIfVar1IsNull(activity, "activity");
        ke.e(activity, new a(this.this$0));
    }

    @Override // me.hd.wauxv.obf.auy, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        throwIfVar1IsNull(activity, "activity");
        cvt cvtVar = this.this$0;
        int i = cvtVar.b - 1;
        cvtVar.b = i;
        if (i == 0 && cvtVar.d) {
            cvtVar.g.m(bug.ON_STOP);
            cvtVar.e = true;
        }
    }
}
