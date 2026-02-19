package me.hd.wauxv.obf;

import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class exf {
    public static final boolean a;
    public static final String b;
    public static final tw c;
    public static final int d;
    public static final int e;
    public static exf f;
    public Application h;
    public final ConcurrentHashMap g = new ConcurrentHashMap();
    public final byx i = new byx(this, 3);

    static {
        Object objX;
        boolean z = exm.a;
        a = exm.l();
        try {
            objX = 1771232894858L;
        } catch (Throwable th) {
            objX = bhu.x(th);
        }
        if (objX instanceof dcx) {
            objX = null;
        }
        Long l = (Long) objX;
        b = String.valueOf(l != null ? l.longValue() : 0L);
        c = new tw("yuki_logger_inmemory_data_result", null);
        d = 512000;
        e = 3;
    }

    public static String j(String str) {
        return concatVar2Var1(dnj.ba(str).toString().hashCode(), "yuki_hook_host_data_channel_");
    }

    public static String k(Context context) {
        String packageName;
        String str = exm.h;
        if (dnj.ak(str)) {
            if (context == null || (packageName = context.getPackageName()) == null) {
                packageName = "";
            }
            str = packageName;
        }
        return concatVar2Var1(dnj.ba(str).toString().hashCode(), "yuki_hook_module_data_channel_");
    }

    public final boolean l(Context context) {
        Object objX;
        boolean z;
        int size;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        ComponentName componentName;
        try {
            if (!(context instanceof Application) && !a) {
                Context context2 = context == null ? this.h : context;
                Object systemService = context2 != null ? context2.getSystemService("activity") : null;
                ActivityManager activityManager = systemService instanceof ActivityManager
                        ? (ActivityManager) systemService
                        : null;
                if (activityManager == null || (runningTasks = activityManager.getRunningTasks(9999)) == null) {
                    size = 0;
                } else {
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : runningTasks) {
                        ActivityManager.RunningTaskInfo runningTaskInfo = (ActivityManager.RunningTaskInfo) obj;
                        if (nullSafeIsEqual(context != null ? context.getClass().getName() : null,
                                (runningTaskInfo == null || (componentName = runningTaskInfo.topActivity) == null)
                                        ? null
                                        : componentName.getClassName())) {
                            arrayList.add(obj);
                        }
                    }
                    size = arrayList.size();
                }
                z = size > 0;
            }
            objX = Boolean.valueOf(z);
        } catch (Throwable th) {
            objX = bhu.x(th);
        }
        Boolean bool = (Boolean) (objX instanceof dcx ? null : objX);
        if (bool != null) {
            return bool.booleanValue();
        }
        ewq.h("Couldn't got current Activity status because a SecurityException blocked it");
        return false;
    }

    public final chm m(Application application, String str) {
        if (a && dnj.ak(exm.h)) {
            throw new IllegalStateException("Xposed modulePackageName load failed, please reset and rebuild it");
        }
        chm chmVar = new chm();
        chmVar.f = this;
        chmVar.c = application;
        chmVar.d = str;
        chmVar.e = new ConcurrentHashMap();
        return chmVar;
    }

    public final void n(final Application application, String str) {
        if (cnb.k) {
            this.h = application;
            IntentFilter intentFilter = new IntentFilter();
            boolean z = a;
            intentFilter.addAction(z ? j(str) : k(application));
            hy hyVar = new hy(this.i, 1);
            if (eu.b(26)) {
                application.registerReceiver(hyVar, intentFilter, 2);
            } else {
                application.registerReceiver(hyVar, intentFilter);
            }
            if (z) {
                chm chmVarM = m(application, str);
                final int i = 0;
                chm.n(chmVarM, "module_generated_version_get", new IInvokable(this) { // from class: me.hd.wauxv.obf.exc
                    public final /* synthetic */ exf b;

                    {
                        this.b = this;
                    }

                    @Override // me.hd.wauxv.obf.bgf
                    public final Object invoke(Object obj) {
                        switch (i) {
                            case 0:
                                this.b.m(application, (String) obj).trimStackTraceToClass(
                                        chm.l(new tw("module_generated_version_result", exf.b), arj.s(), -1, -1));
                                break;
                            default:
                                chm chmVarM2 = this.b.m(application, (String) obj);
                                tw twVar = exf.c;
                                chmVarM2.ao(chm.l(new tw(twVar.a, ewq.a), arj.s(), -1, -1));
                                break;
                        }
                        return KotlinUnit.INSTANCE;
                    }
                });
                final int i2 = 1;
                chm.n(chmVarM, "yuki_logger_inmemory_data_get", new IInvokable(this) { // from class: me.hd.wauxv.obf.exc
                    public final /* synthetic */ exf b;

                    {
                        this.b = this;
                    }

                    @Override // me.hd.wauxv.obf.bgf
                    public final Object invoke(Object obj) {
                        switch (i2) {
                            case 0:
                                this.b.m(application, (String) obj).trimStackTraceToClass(
                                        chm.l(new tw("module_generated_version_result", exf.b), arj.s(), -1, -1));
                                break;
                            default:
                                chm chmVarM2 = this.b.m(application, (String) obj);
                                tw twVar = exf.c;
                                chmVarM2.ao(chm.l(new tw(twVar.a, ewq.a), arj.s(), -1, -1));
                                break;
                        }
                        return KotlinUnit.INSTANCE;
                    }
                });
            }
        }
    }
}
