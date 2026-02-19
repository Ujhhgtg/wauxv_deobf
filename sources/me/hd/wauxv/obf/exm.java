package me.hd.wauxv.obf;

import android.content.pm.ApplicationInfo;
import dalvik.system.PathClassLoader;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class exm {
    public static boolean a;
    public static boolean b;
    public static boolean c;
    public static blx g;
    public static final LinkedHashMap d = new LinkedHashMap();
    public static final LinkedHashSet e = new LinkedHashSet();
    public static final LinkedHashMap f = new LinkedHashMap();
    public static String h = "";
    public static String i = "";

    public static csc j(HookScopeEnum hookScopeEnumVar, String str, String str2, ClassLoader classLoader, ApplicationInfo applicationInfo, dcv dcvVar, int i2) {
        if ((i2 & 4) != 0) {
            str2 = "";
        }
        if ((i2 & 8) != 0) {
            classLoader = null;
        }
        if ((i2 & 16) != 0) {
            applicationInfo = null;
        }
        HookScopeEnum hookScopeEnumVar2 = HookScopeEnum.ZYGOTE;
        c = hookScopeEnumVar == hookScopeEnumVar2;
        LinkedHashMap linkedHashMap = f;
        if (linkedHashMap.get(str) != null) {
            csc cscVar = (csc) linkedHashMap.get(str);
            if (cscVar != null) {
                cscVar.hookScope = hookScopeEnumVar;
                if (str != null) {
                    if (dnj.ak(str)) {
                        str = null;
                    }
                    if (str != null) {
                        cscVar.packageName = str;
                    }
                }
                if (str2 != null) {
                    if (dnj.ak(str2)) {
                        str2 = null;
                    }
                    if (str2 != null) {
                        cscVar.processName = str2;
                    }
                }
                if (classLoader != null) {
                    ClassLoader classLoader2 = (hookScopeEnumVar == hookScopeEnumVar2 || (classLoader instanceof PathClassLoader)) ? classLoader : null;
                    if (classLoader2 != null) {
                        cscVar.appClassLoader = classLoader2;
                    }
                }
                if (applicationInfo != null) {
                    cscVar.appInfo = applicationInfo;
                }
                return cscVar;
            }
        } else if (hookScopeEnumVar == hookScopeEnumVar2 || classLoader != null) {
            String str3 = str == null ? "android" : str;
            if (str2 == null) {
                str2 = "android";
            }
            if (classLoader == null) {
                classLoader = ClassLoader.getSystemClassLoader();
            }
            csc cscVar2 = new csc();
            cscVar2.hookScope = hookScopeEnumVar;
            cscVar2.packageName = str3;
            cscVar2.processName = str2;
            cscVar2.appClassLoader = classLoader;
            cscVar2.appInfo = applicationInfo;
            if (str == null) {
                str = "android";
            }
            linkedHashMap.put(str, cscVar2);
            return cscVar2;
        }
        return null;
    }

    public static boolean k(String str, HookScopeEnum hookScopeEnumVar) {
        if (str == null) {
            return false;
        }
        String str2 = str + ":" + hookScopeEnumVar;
        LinkedHashSet linkedHashSet = e;
        if (linkedHashSet.contains(str2)) {
            return true;
        }
        linkedHashSet.add(str + ":" + hookScopeEnumVar);
        return false;
    }

    public static boolean l() {
        return bhs.r() != bmc.b && a;
    }
}
