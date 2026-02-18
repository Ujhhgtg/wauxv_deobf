package me.hd.wauxv.obf;

import android.app.AndroidAppHelper;
import android.app.Application;
import android.app.Instrumentation;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ki {
    public static final ki a;
    public static final /* synthetic */ btc[] b;
    public static boolean c;
    public static final LinkedHashMap d;
    public static final jx e;
    public static Application f;

    static {
        cwb cwbVar = new cwb(ki.class, "ActivityThreadClass", "getActivityThreadClass()Ljava/lang/Class;");
        dal.a.getClass();
        b = new btc[]{cwbVar, new cwb(ki.class, "ContextImplClass", "getContextImplClass()Ljava/lang/Class;"), new cwb(ki.class, "ActivityManagerNativeClass", "getActivityManagerNativeClass()Ljava/lang/Class;"), new cwb(ki.class, "SingletonClass", "getSingletonClass()Ljava/lang/Class;"), new cwb(ki.class, "IActivityManagerClass", "getIActivityManagerClass()Ljava/lang/Class;"), new cwb(ki.class, "ActivityTaskManagerClass", "getActivityTaskManagerClass()Ljava/lang/Class;"), new cwb(ki.class, "IActivityTaskManagerClass", "getIActivityTaskManagerClass()Ljava/lang/Class;")};
        a = new ki();
        new LinkedHashMap();
        d = new LinkedHashMap();
        e = zf.h("android.app.ActivityThread", null, 6);
    }

    public static ClassLoader g() {
        Class cls;
        cls = ewz.class;
        Class<ewz> clsBf = cnf.bf(dal.b(cls));
        ClassLoader classLoader = (clsBf != null ? clsBf : ewz.class).getClassLoader();
        if (classLoader != null) {
            return classLoader;
        }
        throw new IllegalStateException("Operating system not supported");
    }

    public static Application h() {
        Object objX;
        try {
            objX = AndroidAppHelper.currentApplication();
        } catch (Throwable th) {
            objX = bhu.x(th);
        }
        if (objX instanceof dcx) {
            objX = null;
        }
        Application application = (Application) objX;
        if (application != null) {
            return application;
        }
        int i = bte.a;
        btc btcVar = b[0];
        bmu bmuVarBh = dqc.bh(e.w());
        dov dovVar = ep.a;
        ((cbg) bmuVarBh.h).c = bhu.aa();
        bmuVarBh.v(true);
        cde cdeVarT = bmuVarBh.t();
        cdeVarT.ab = "currentApplication";
        cdk cdkVar = (cdk) aaz.g(cdeVarT.aj());
        if (cdkVar != null) {
            return (Application) cdkVar.j(new Object[0]);
        }
        return null;
    }

    /* JADX WARN: Found duplicated region for block: B:22:0x007f  */
    public static String i() {
        Object objX;
        String str;
        bmu bmuVarBi;
        Object objD;
        bmu bmuVarBi2;
        try {
            objX = AndroidAppHelper.currentApplicationInfo();
        } catch (Throwable th) {
            objX = bhu.x(th);
        }
        ApplicationInfo applicationInfo = null;
        if (objX instanceof dcx) {
            objX = null;
        }
        ApplicationInfo applicationInfo2 = (ApplicationInfo) objX;
        if (applicationInfo2 == null) {
            int i = bte.a;
            a.getClass();
            btc btcVar = b[0];
            bmu bmuVarBh = dqc.bh(e.w());
            dov dovVar = ep.a;
            ((cbg) bmuVarBh.h).c = bhu.aa();
            bmuVarBh.v(true);
            cde cdeVarT = bmuVarBh.t();
            cdeVarT.ab = "currentActivityThread";
            cdeVarT.y();
            cdk cdkVar = (cdk) aaz.g(cdeVarT.aj());
            Object objE = cdkVar != null ? cdkVar.e(new Object[0]) : null;
            if (objE != null) {
                bmuVarBi = dqc.bi(objE);
                bmuVarBi.v(true);
            } else {
                bmuVarBi = null;
            }
            if (bmuVarBi != null) {
                azg azgVarR = bmuVarBi.r();
                azgVarR.ab = "mBoundApplication";
                azk azkVar = (azk) aaz.g(azgVarR.c());
                objD = azkVar != null ? azkVar.d() : null;
            }
            if (objD != null) {
                bmuVarBi2 = dqc.bi(objD);
                bmuVarBi2.v(true);
            } else {
                bmuVarBi2 = null;
            }
            if (bmuVarBi2 != null) {
                azg azgVarR2 = bmuVarBi2.r();
                azgVarR2.ab = "appInfo";
                azk azkVar2 = (azk) aaz.g(azgVarR2.c());
                if (azkVar2 != null) {
                    applicationInfo = (ApplicationInfo) azkVar2.e();
                }
            }
            applicationInfo2 = applicationInfo;
        }
        return (applicationInfo2 == null || (str = applicationInfo2.packageName) == null) ? "android" : str;
    }

    public static void j(ClassLoader classLoader, bmk bmkVar) {
        Method method;
        String str = "com.highcapable.yukihookapi.hook.xposed.bridge.status.YukiXposedModuleStatus_Impl_Impl_me_hd_wauxv" instanceof dcx ? null : "com.highcapable.yukihookapi.hook.xposed.bridge.status.YukiXposedModuleStatus_Impl_Impl_me_hd_wauxv";
        if (str == null) {
            str = "";
        }
        Class clsF = zf.f(str, 2, classLoader);
        if (clsF != null) {
            int i = bte.a;
            bmu bmuVarBh = dqc.bh(clsF);
            bmuVarBh.v(true);
            if (bmkVar == bmk.c) {
                cde cdeVarT = bmuVarBh.t();
                cdeVarT.ab = "_--_";
                cdk cdkVar = (cdk) aaz.g(cdeVarT.aj());
                kf kfVar = new kf(1);
                if (cdkVar == null || (method = cdkVar.a) == null) {
                    return;
                }
                cnh.z(method, kfVar);
                return;
            }
            cde cdeVarT2 = bmuVarBh.t();
            cdeVarT2.ab = "__--";
            cnh.y((cdk) aaz.g(cdeVarT2.aj()), new kf(2));
            cde cdeVarT3 = bmuVarBh.t();
            cdeVarT3.ab = "_-_-";
            cnh.y((cdk) aaz.g(cdeVarT3.aj()), new kf(3));
            cde cdeVarT4 = bmuVarBh.t();
            cdeVarT4.ab = "-__-";
            cnh.y((cdk) aaz.g(cdeVarT4.aj()), new kf(4));
            cde cdeVarT5 = bmuVarBh.t();
            cdeVarT5.ab = "-_-_";
            cnh.y((cdk) aaz.g(cdeVarT5.aj()), new kf(5));
            cde cdeVarT6 = bmuVarBh.t();
            cdeVarT6.ab = "___-";
            cnh.y((cdk) aaz.g(cdeVarT6.aj()), new kf(0));
        }
    }

    public final void k(String str) {
        Method method;
        try {
            LinkedHashMap linkedHashMap = d;
            int i = 1;
            if (!linkedHashMap.isEmpty()) {
                int i2 = bte.a;
                bmu bmuVarBg = dqc.bg(dal.b(Application.class));
                bmuVarBg.v(true);
                cde cdeVarT = bmuVarBg.t();
                cdeVarT.ab = "attach";
                cdeVarT.z(Arrays.copyOf(new Object[]{dal.b(Context.class)}, 1));
                cnh.y((cdk) aaz.e(cdeVarT.aj()), new kg(i));
                cde cdeVarT2 = bmuVarBg.t();
                cdeVarT2.ab = "onTerminate";
                cnh.y((cdk) aaz.e(cdeVarT2.aj()), new kg(2));
                cde cdeVarT3 = bmuVarBg.t();
                cdeVarT3.ab = "onLowMemory";
                cnh.y((cdk) aaz.e(cdeVarT3.aj()), new kg(3));
                cde cdeVarT4 = bmuVarBg.t();
                cdeVarT4.ab = "onTrimMemory";
                cdeVarT4.z(Arrays.copyOf(new Object[]{dal.b(Integer.TYPE)}, 1));
                cnh.y((cdk) aaz.e(cdeVarT4.aj()), new kg(4));
                cde cdeVarT5 = bmuVarBg.t();
                cdeVarT5.ab = "onConfigurationChanged";
                cnh.y((cdk) aaz.e(cdeVarT5.aj()), new kg(0));
            }
            if (cnb.k || !linkedHashMap.isEmpty()) {
                int i3 = bte.a;
                bmu bmuVarBg2 = dqc.bg(dal.b(Instrumentation.class));
                bmuVarBg2.v(true);
                cde cdeVarT6 = bmuVarBg2.t();
                cdeVarT6.ab = "callApplicationOnCreate";
                cdk cdkVar = (cdk) aaz.g(cdeVarT6.aj());
                kh khVar = new kh(this, str);
                if (cdkVar == null || (method = cdkVar.a) == null) {
                    return;
                }
                cnh.z(method, khVar);
            }
        } catch (Throwable th) {
            bhu.x(th);
        }
    }
}
