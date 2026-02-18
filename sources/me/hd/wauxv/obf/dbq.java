package me.hd.wauxv.obf;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class dbq extends Fragment {
    public static final /* synthetic */ int a = 0;
    public bmu b;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static final class a implements Application.ActivityLifecycleCallbacks {
        public static final dbp Companion = new dbp();

        public static final void registerIn(Activity activity) {
            Companion.getClass();
            bzo.q(activity, "activity");
            activity.registerActivityLifecycleCallbacks(new a());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            bzo.q(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            bzo.q(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            bzo.q(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            bzo.q(activity, "activity");
            int i = dbq.a;
            dbo.a(activity, bug.ON_CREATE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            bzo.q(activity, "activity");
            int i = dbq.a;
            dbo.a(activity, bug.ON_RESUME);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            bzo.q(activity, "activity");
            int i = dbq.a;
            dbo.a(activity, bug.ON_START);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(Activity activity) {
            bzo.q(activity, "activity");
            int i = dbq.a;
            dbo.a(activity, bug.ON_DESTROY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPrePaused(Activity activity) {
            bzo.q(activity, "activity");
            int i = dbq.a;
            dbo.a(activity, bug.ON_PAUSE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreStopped(Activity activity) {
            bzo.q(activity, "activity");
            int i = dbq.a;
            dbo.a(activity, bug.ON_STOP);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            bzo.q(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            bzo.q(activity, "activity");
            bzo.q(bundle, "bundle");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            bzo.q(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            bzo.q(activity, "activity");
        }
    }

    public final void c(bug bugVar) {
        if (Build.VERSION.SDK_INT < 29) {
            Activity activity = getActivity();
            bzo.p(activity, "getActivity(...)");
            dbo.a(activity, bugVar);
        }
    }

    @Override // android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        c(bug.ON_CREATE);
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        c(bug.ON_DESTROY);
        this.b = null;
    }

    @Override // android.app.Fragment
    public final void onPause() {
        super.onPause();
        c(bug.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        bmu bmuVar = this.b;
        if (bmuVar != null) {
            ((cvt) bmuVar.h).j();
        }
        c(bug.ON_RESUME);
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        bmu bmuVar = this.b;
        if (bmuVar != null) {
            cvt cvtVar = (cvt) bmuVar.h;
            int i = cvtVar.b + 1;
            cvtVar.b = i;
            if (i == 1 && cvtVar.e) {
                cvtVar.g.m(bug.ON_START);
                cvtVar.e = false;
            }
        }
        c(bug.ON_START);
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        c(bug.ON_STOP);
    }
}
