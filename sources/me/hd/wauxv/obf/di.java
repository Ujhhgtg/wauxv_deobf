package me.hd.wauxv.obf;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.ArrayMap;
import android.util.Log;
import android.view.View;
import com.kongzue.dialogx.util.views.DialogXBaseRelativeLayout;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.concurrent.CopyOnWriteArrayList;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class di implements Application.ActivityLifecycleCallbacks {
    public static di a;
    public static Application b;
    public arj c;

    public static Activity d() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object objInvoke = cls.getMethod("currentActivityThread", null).invoke(null, null);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            ArrayMap arrayMap = (ArrayMap) declaredField.get(objInvoke);
            if (arrayMap.size() < 1) {
                return null;
            }
            for (Object obj : arrayMap.values()) {
                Class<?> cls2 = obj.getClass();
                Field declaredField2 = cls2.getDeclaredField("paused");
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(obj)) {
                    Field declaredField3 = cls2.getDeclaredField("activity");
                    declaredField3.setAccessible(true);
                    return (Activity) declaredField3.get(obj);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void e(Context context, arj arjVar) {
        if (context == null) {
            Application application = b;
            if (application != null) {
                e(application, arjVar);
                return;
            }
            return;
        }
        Application application2 = (Application) context.getApplicationContext();
        if (application2 == null) {
            ResourcesCompat resourcesCompatVar = anj.a;
            Log.e(">>>", "DialogX 未初始化(E1)。\n请检查是否在启动对话框前进行初始化操作，使用以下代码进行初始化：\nDialogX.init(context);\n\n另外建议您前往查看 DialogX 的文档进行使用：https://github.com/kongzue/DialogX");
            return;
        }
        b = application2;
        di diVar = a;
        if (diVar != null) {
            application2.unregisterActivityLifecycleCallbacks(diVar);
        }
        di diVar2 = new di();
        diVar2.c = arjVar;
        a = diVar2;
        application2.registerActivityLifecycleCallbacks(diVar2);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        arj arjVar = this.c;
        if (arjVar != null) {
            arjVar.getClass();
            ng.ag(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        if (ng.ae() == activity) {
            WeakReference weakReference = ng.b;
            if (weakReference != null) {
                weakReference.clear();
            }
            ng.b = null;
            ResourcesCompat resourcesCompatVar = anj.a;
        }
        if (Build.VERSION.SDK_INT < 29) {
            ng.ai(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPreDestroyed(Activity activity) {
        if (Build.VERSION.SDK_INT >= 29) {
            ng.ai(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPreResumed(Activity activity) {
        if (Build.VERSION.SDK_INT < 29 || activity.isDestroyed() || activity.isFinishing()) {
            return;
        }
        ng.ag(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        if (activity.isDestroyed() || activity.isFinishing()) {
            return;
        }
        if (Build.VERSION.SDK_INT < 29 && !activity.isDestroyed() && !activity.isFinishing()) {
            ng.ag(activity);
        }
        if (ng.c != null) {
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(ng.c);
            for (int size = copyOnWriteArrayList.size() - 1; size >= 0; size--) {
                ng ngVar = (ng) copyOnWriteArrayList.get(size);
                if (ngVar.as() == activity && ngVar.n && ngVar.ar() != null) {
                    View viewFindViewById = ngVar.ar().findViewById(R.id.box_root);
                    if (viewFindViewById instanceof DialogXBaseRelativeLayout) {
                        DialogXBaseRelativeLayout dialogXBaseRelativeLayout = (DialogXBaseRelativeLayout) viewFindViewById;
                        if (dialogXBaseRelativeLayout.e) {
                            View viewFindFocus = dialogXBaseRelativeLayout.findFocus();
                            if (viewFindFocus == null || viewFindFocus == dialogXBaseRelativeLayout) {
                                dialogXBaseRelativeLayout.requestFocus();
                                return;
                            } else {
                                viewFindFocus.requestFocus();
                                return;
                            }
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        if (b == null) {
            ng.af(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
