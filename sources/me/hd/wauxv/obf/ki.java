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
    public static final /* synthetic */ IEmpty7[] b;
    public static boolean c;
    public static final LinkedHashMap d;
    public static final FactoryPools e;
    public static Application f;

    static {
        cwb cwbVar = new cwb(ki.class, "ActivityThreadClass", "getActivityThreadClass()Ljava/lang/Class;");
        dal.a.getClass();
        b = new IEmpty7[]{cwbVar, new cwb(ki.class, "ContextImplClass", "getContextImplClass()Ljava/lang/Class;"), new cwb(ki.class, "ActivityManagerNativeClass", "getActivityManagerNativeClass()Ljava/lang/Class;"), new cwb(ki.class, "SingletonClass", "getSingletonClass()Ljava/lang/Class;"), new cwb(ki.class, "IActivityManagerClass", "getIActivityManagerClass()Ljava/lang/Class;"), new cwb(ki.class, "ActivityTaskManagerClass", "getActivityTaskManagerClass()Ljava/lang/Class;"), new cwb(ki.class, "IActivityTaskManagerClass", "getIActivityTaskManagerClass()Ljava/lang/Class;")};
        a = new ki();
        new LinkedHashMap();
        d = new LinkedHashMap();
        e = ReflectionWrapper.h("android.app.ActivityThread", null, 6);
    }

    public static ClassLoader getHostClassLoader() {
        Class cls;
        cls = StaticAndroidHelpers.class;
        Class<StaticAndroidHelpers> clsBf = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls));
        ClassLoader classLoader = (clsBf != null ? clsBf : StaticAndroidHelpers.class).getClassLoader();
        if (classLoader != null) {
            return classLoader;
        }
        throw new IllegalStateException("Operating system not supported");
    }

    public static Application tryGetApplication() {
        Object objX;
        try {
            objX = AndroidAppHelper.currentApplication();
        } catch (Throwable th) {
            objX = FastKV.getFailureFromException(th);
        }
        if (objX instanceof Failure) {
            objX = null;
        }
        Application application = (Application) objX;
        if (application != null) {
            return application;
        }
        int i = 0;
        IEmpty7 btcVar = b[0];
        SyntheticPileOfMess bmuVarBh = dqc.bh(e.w());
        Kotlin$Lazy kotlin$LazyVar = ep.a;
        ((Configuration) bmuVarBh.obj).processorResolver = FastKV.aa();
        bmuVarBh.setHookOptional(true);
        MethodResolver methodResolverVarT = bmuVarBh.getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT.name = "currentApplication";
        MethodHookWrapper methodHookWrapperVar = (MethodHookWrapper) StaticHelpers5.g(methodResolverVarT.findMethods());
        if (methodHookWrapperVar != null) {
            return (Application) methodHookWrapperVar.invoke(new Object[0]);
        }
        return null;
    }

    /* JADX WARN: Found duplicated region for block: B:22:0x007f  */
    public static String i() {
        Object objX;
        String str;
        SyntheticPileOfMess bmuVarBi;
        Object objD;
        SyntheticPileOfMess bmuVarBi2;
        try {
            objX = AndroidAppHelper.currentApplicationInfo();
        } catch (Throwable th) {
            objX = FastKV.getFailureFromException(th);
        }
        ApplicationInfo applicationInfo = null;
        if (objX instanceof Failure) {
            objX = null;
        }
        ApplicationInfo applicationInfo2 = (ApplicationInfo) objX;
        if (applicationInfo2 == null) {
            int i = 0;
            a.getClass();
            IEmpty7 btcVar = b[0];
            SyntheticPileOfMess bmuVarBh = dqc.bh(e.w());
            Kotlin$Lazy kotlin$LazyVar = ep.a;
            ((Configuration) bmuVarBh.obj).processorResolver = FastKV.aa();
            bmuVarBh.setHookOptional(true);
            MethodResolver methodResolverVarT = bmuVarBh.getMethodResolverBasedOnPreviouslyProvidedConfig();
            methodResolverVarT.name = "currentActivityThread";
            methodResolverVarT.setParamCountTo0();
            MethodHookWrapper methodHookWrapperVar = (MethodHookWrapper) StaticHelpers5.g(methodResolverVarT.findMethods());
            Object objE = methodHookWrapperVar != null ? methodHookWrapperVar.invokeAndThrowIfFailed(new Object[0]) : null;
            if (objE != null) {
                bmuVarBi = dqc.getWrapperConfiguration(objE);
                bmuVarBi.setHookOptional(true);
            } else {
                bmuVarBi = null;
            }
            if (bmuVarBi != null) {
                FieldResolver fieldResolverVarR = bmuVarBi.r();
                fieldResolverVarR.name = "mBoundApplication";
                BoundField boundFieldVar = (BoundField) StaticHelpers5.g(fieldResolverVarR.resolve());
                objD = boundFieldVar != null ? boundFieldVar.getValue() : null;
            }
            if (objD != null) {
                bmuVarBi2 = dqc.getWrapperConfiguration(objD);
                bmuVarBi2.setHookOptional(true);
            } else {
                bmuVarBi2 = null;
            }
            if (bmuVarBi2 != null) {
                FieldResolver fieldResolverVarR2 = bmuVarBi2.r();
                fieldResolverVarR2.name = "appInfo";
                BoundField boundFieldVar2 = (BoundField) StaticHelpers5.g(fieldResolverVarR2.resolve());
                if (boundFieldVar2 != null) {
                    applicationInfo = (ApplicationInfo) boundFieldVar2.getValue_();
                }
            }
            applicationInfo2 = applicationInfo;
        }
        return (applicationInfo2 == null || (str = applicationInfo2.packageName) == null) ? "android" : str;
    }

    public static void j(ClassLoader classLoader, HookScopeEnum hookScopeEnumVar) {
        Method method;
        String str = "com.highcapable.yukihookapi.hook.xposed.bridge.status.YukiXposedModuleStatus_Impl_Impl_me_hd_wauxv" instanceof Failure ? null : "com.highcapable.yukihookapi.hook.xposed.bridge.status.YukiXposedModuleStatus_Impl_Impl_me_hd_wauxv";
        if (str == null) {
            str = "";
        }
        Class clsF = ReflectionWrapper.f(str, 2, classLoader);
        if (clsF != null) {
            int i = 0;
            SyntheticPileOfMess bmuVarBh = dqc.bh(clsF);
            bmuVarBh.setHookOptional(true);
            if (hookScopeEnumVar == HookScopeEnum.RESOURCES) {
                MethodResolver methodResolverVarT = bmuVarBh.getMethodResolverBasedOnPreviouslyProvidedConfig();
                methodResolverVarT.name = "_--_";
                MethodHookWrapper methodHookWrapperVar = (MethodHookWrapper) StaticHelpers5.g(methodResolverVarT.findMethods());
                kf kfVar = new kf(1);
                if (methodHookWrapperVar == null || (method = methodHookWrapperVar.method) == null) {
                    return;
                }
                cnh.z(method, kfVar);
                return;
            }
            MethodResolver methodResolverVarT2 = bmuVarBh.getMethodResolverBasedOnPreviouslyProvidedConfig();
            methodResolverVarT2.name = "__--";
            cnh.y((MethodHookWrapper) StaticHelpers5.g(methodResolverVarT2.findMethods()), new kf(2));
            MethodResolver methodResolverVarT3 = bmuVarBh.getMethodResolverBasedOnPreviouslyProvidedConfig();
            methodResolverVarT3.name = "_-_-";
            cnh.y((MethodHookWrapper) StaticHelpers5.g(methodResolverVarT3.findMethods()), new kf(3));
            MethodResolver methodResolverVarT4 = bmuVarBh.getMethodResolverBasedOnPreviouslyProvidedConfig();
            methodResolverVarT4.name = "-__-";
            cnh.y((MethodHookWrapper) StaticHelpers5.g(methodResolverVarT4.findMethods()), new kf(4));
            MethodResolver methodResolverVarT5 = bmuVarBh.getMethodResolverBasedOnPreviouslyProvidedConfig();
            methodResolverVarT5.name = "-_-_";
            cnh.y((MethodHookWrapper) StaticHelpers5.g(methodResolverVarT5.findMethods()), new kf(5));
            MethodResolver methodResolverVarT6 = bmuVarBh.getMethodResolverBasedOnPreviouslyProvidedConfig();
            methodResolverVarT6.name = "___-";
            cnh.y((MethodHookWrapper) StaticHelpers5.g(methodResolverVarT6.findMethods()), new kf(0));
        }
    }

    public final void k(String str) {
        Method method;
        try {
            LinkedHashMap linkedHashMap = d;
            int i = 1;
            if (!linkedHashMap.isEmpty()) {
                int i2 = 0;
                SyntheticPileOfMess bmuVarBg = dqc.bg(dal.getKClassFromClass(Application.class));
                bmuVarBg.setHookOptional(true);
                MethodResolver methodResolverVarT = bmuVarBg.getMethodResolverBasedOnPreviouslyProvidedConfig();
                methodResolverVarT.name = "attach";
                methodResolverVarT.setParams(Arrays.copyOf(new Object[]{dal.getKClassFromClass(Context.class)}, 1));
                cnh.y((MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT.findMethods()), new kg(i));
                MethodResolver methodResolverVarT2 = bmuVarBg.getMethodResolverBasedOnPreviouslyProvidedConfig();
                methodResolverVarT2.name = "onTerminate";
                cnh.y((MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT2.findMethods()), new kg(2));
                MethodResolver methodResolverVarT3 = bmuVarBg.getMethodResolverBasedOnPreviouslyProvidedConfig();
                methodResolverVarT3.name = "onLowMemory";
                cnh.y((MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT3.findMethods()), new kg(3));
                MethodResolver methodResolverVarT4 = bmuVarBg.getMethodResolverBasedOnPreviouslyProvidedConfig();
                methodResolverVarT4.name = "onTrimMemory";
                methodResolverVarT4.setParams(Arrays.copyOf(new Object[]{dal.getKClassFromClass(Integer.TYPE)}, 1));
                cnh.y((MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT4.findMethods()), new kg(4));
                MethodResolver methodResolverVarT5 = bmuVarBg.getMethodResolverBasedOnPreviouslyProvidedConfig();
                methodResolverVarT5.name = "onConfigurationChanged";
                cnh.y((MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT5.findMethods()), new kg(0));
            }
            if (cnb.k || !linkedHashMap.isEmpty()) {
                int i3 = 0;
                SyntheticPileOfMess bmuVarBg2 = dqc.bg(dal.getKClassFromClass(Instrumentation.class));
                bmuVarBg2.setHookOptional(true);
                MethodResolver methodResolverVarT6 = bmuVarBg2.getMethodResolverBasedOnPreviouslyProvidedConfig();
                methodResolverVarT6.name = "callApplicationOnCreate";
                MethodHookWrapper methodHookWrapperVar = (MethodHookWrapper) StaticHelpers5.g(methodResolverVarT6.findMethods());
                kh khVar = new kh(this, str);
                if (methodHookWrapperVar == null || (method = methodHookWrapperVar.method) == null) {
                    return;
                }
                cnh.z(method, khVar);
            }
        } catch (Throwable th) {
            FastKV.getFailureFromException(th);
        }
    }
}
