package me.hd.wauxv.obf;

import android.content.pm.ApplicationInfo;
import dalvik.system.PathClassLoader;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import java.util.LinkedHashMap;
import me.hd.wauxv.hook.HookEntry;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bml {
    public static final bml a;
    public static boolean b;
    public static final HookEntry c;

    static {
        "me.hd.wauxv" /* "me.hd.wauxv" /* "me.hd.wauxv" /* cnb.z(-77412490541866L)  */;
        a = new bml();
        c = HookEntry.a;
    }

    public static void d(bml bmlVar, XC_LoadPackage.LoadPackageParam loadPackageParam, int i) {
        Object objX;
        Object objX2;
        ClassLoader classLoader;
        ClassLoader classLoader2;
        HookScopeEnum hookScopeEnumVar;
        blx blxVar;
        String str;
        boolean z = (i & 1) == 0;
        csc cscVarJ = null;
        XC_LoadPackage.LoadPackageParam loadPackageParam2 = (i & 2) != 0 ? null : loadPackageParam;
        bmlVar.getClass();
        boolean z2 = b;
        Object objX3 = Kotlin$Unit.INSTANCE;
        if (!z2) {
            try {
                c.getClass();
                cna.d = "WAuxiliary" /* "WAuxiliary" /* "WAuxiliary" /* cnb.z(-71829033057066L)  */;
                cnb.k = false;
            } catch (Throwable th) {
                objX = FastKV.getFailureFromException(th);
            }
            if (!exm.b && exm.g != null) {
                Logger.logException(4, "You cannot load a hooker in \"onInit\" or \"onXposedEvent\" method! Aborted" /*
                                                                                                        * cnb.z(-
                                                                                                        * 77674483546922L)
                                                                                                        */, null);
                return;
            }
            blx blxVar2 = new blx(4);
            boolean z3 = exm.a;
            if (exm.l()) {
                exm.g = blxVar2;
            } else {
                Logger.logException(2, "Could not found any available Hook APIs in current environment! Aborted", null);
            }
            exm.b = true;
            objX = objX3;
            Throwable thB = Success.exceptionOrNull(objX);
            if (thB != null) {
                Logger.logException(4, "YukiHookAPI try to load hook entry class failed" /* "YukiHookAPI try to load hook entry class failed" /* "YukiHookAPI try to load hook entry class failed" /* cnb.z(-77915001715498L)  */, thB);
            }
        }
        HookScopeEnum hookScopeEnumVar2 = HookScopeEnum.PACKAGE;
        HookScopeEnum hookScopeEnumVar3 = HookScopeEnum.ZYGOTE;
        HookScopeEnum hookScopeEnumVar4 = (z || loadPackageParam2 == null) ? hookScopeEnumVar3 : hookScopeEnumVar2;
        String str2 = (loadPackageParam2 == null || (str = loadPackageParam2.packageName) == null) ? null : str;
        String str3 = loadPackageParam2 != null ? loadPackageParam2.processName : null;
        if (loadPackageParam2 == null || (classLoader = loadPackageParam2.classLoader) == null) {
            try {
                objX2 = XposedBridge.BOOTCLASSLOADER;
            } catch (Throwable th2) {
                objX2 = FastKV.getFailureFromException(th2);
            }
            if (objX2 instanceof Failure) {
                objX2 = null;
            }
            classLoader = (ClassLoader) objX2;
        }
        ClassLoader classLoader3 = classLoader;
        ApplicationInfo applicationInfo = loadPackageParam2 != null ? loadPackageParam2.appInfo : null;
        boolean z4 = exm.a;
        if ((nullSafeIsEqual(str2, "com.miui.contentcatcher") || nullSafeIsEqual(str2, "com.miui.catcherpatch"))
                && (classLoader2 = exm.class.getClassLoader()) != null && zf.g(classLoader2, "android.miui.R")) {
            return;
        }
        int iOrdinal = hookScopeEnumVar4.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                if (iOrdinal != 2) {
                    throw new abt();
                }
                HookScopeEnum hookScopeEnumVar5 = HookScopeEnum.RESOURCES;
                if (!exm.k(str2, hookScopeEnumVar5)) {
                    ki.a.getClass();
                    if (nullSafeIsEqual(str2, ki.i())) {
                        cscVarJ = exm.j(hookScopeEnumVar5, str2, null, null, null, null, 28);
                    }
                }
            } else if (!exm.k(str2, hookScopeEnumVar2)) {
                cscVarJ = exm.j(hookScopeEnumVar2, str2, str3, classLoader3, applicationInfo, null, 32);
            }
            hookScopeEnumVar = hookScopeEnumVar3;
        } else {
            hookScopeEnumVar = hookScopeEnumVar3;
            cscVarJ = exm.j(hookScopeEnumVar, "android", "android", classLoader3, null, null, 48);
        }
        if (cscVarJ != null) {
            try {
                HookScopeEnum hookScopeEnumVar6 = cscVarJ.hookScope;
                if ((hookScopeEnumVar6 == hookScopeEnumVar || (hookScopeEnumVar6 != hookScopeEnumVar && (cscVarJ.appClassLoader instanceof PathClassLoader)))
                        && (blxVar = exm.g) != null) {
                    LinkedHashMap linkedHashMap = exm.d;
                    String str4 = "android-zygote";
                    PackageParam packageParamVar = (PackageParam) linkedHashMap.get(hookScopeEnumVar6 == hookScopeEnumVar ? "android-zygote" : cscVarJ.packageName);
                    if (packageParamVar == null) {
                        packageParamVar = new PackageParam();
                        if (cscVarJ.hookScope != hookScopeEnumVar) {
                            str4 = cscVarJ.packageName;
                        }
                        linkedHashMap.put(str4, packageParamVar);
                    }
                    packageParamVar.processInfo = cscVarJ;
                    blxVar.invoke(packageParamVar);
                }
                if (cscVarJ.hookScope != hookScopeEnumVar && cscVarJ.packageName.equals(exm.h)) {
                    ki kiVar = ki.a;
                    ClassLoader classLoader4 = cscVarJ.appClassLoader;
                    HookScopeEnum hookScopeEnumVar7 = cscVarJ.hookScope;
                    kiVar.getClass();
                    ki.j(classLoader4, hookScopeEnumVar7);
                }
                if (cscVarJ.hookScope == hookScopeEnumVar2) {
                    ki.a.k(cscVarJ.packageName);
                }
            } catch (Throwable th3) {
                objX3 = FastKV.getFailureFromException(th3);
            }
            Throwable thB2 = Success.exceptionOrNull(objX3);
            if (thB2 != null) {
                Logger.logException(4, "An exception occurred in the Hooking Process of YukiHookAPI", thB2);
            }
        }
    }
}
