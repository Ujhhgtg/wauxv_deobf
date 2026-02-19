package me.hd.wauxv.obf;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.view.View;
import android.view.ViewGroup;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class blu {
    public static final LinkedHashMap a = new LinkedHashMap();
    public static final AtomicInteger b = new AtomicInteger(133169152);
    public static final boolean c = true;
    public final List d;
    public final LinkedHashSet e = new LinkedHashSet();
    public final LinkedHashMap f = new LinkedHashMap();
    public final LinkedHashMap g = new LinkedHashMap();

    public blu(List list) {
        this.d = list;
    }

    /*
     * JADX WARN: Code restructure failed: missing block: B:12:0x0046, code lost:
     * 
     * if (r4 != null) goto L19;
     */
    /*
     * Code decompiled incorrectly, please refer to instructions dump.
     * To view partially-correct add '--show-bad-code' argument
     */
    public static final android.view.View h(me.hd.wauxv.obf.blu r18, java.lang.Class r19, java.lang.String r20,
            android.content.Context r21) throws me.hd.wauxv.obf.cth {
        /*
         * Method dump skipped, instruction units count: 661
         * To view this dump add '--comments-level debug' option
         */
        throw new UnsupportedOperationException(
                "Method not decompiled: me.hd.wauxv.obf.blu.h(me.hd.wauxv.obf.blu, java.lang.Class, java.lang.String, android.content.Context):android.view.View");
    }

    /* JADX WARN: Found duplicated region for block: B:18:0x00bf */
    public static final blr i(blu bluVar, Class cls, ViewGroup viewGroup, boolean z, Context context) {
        Object objF;
        blr blrVar = new blr(bluVar, cls, viewGroup, z, context);
        if (context != null) {
            ewm.a.getClass();
            if (!dnr.ifVar1EndsWithVar2(context.getClass().getName(), "BridgeContext")) {
                ApplicationInfo applicationInfo = context.getApplicationContext().getApplicationInfo();
                ewl ewlVar = ewm.h;
                if (((Number) eu.a.getValue()).intValue() > 28 && !ewm.g) {
                    String str = applicationInfo.sourceDir;
                    boolean zB = eu.b(30);
                    AccessModifierEnum accessModifierEnumVar = AccessModifierEnum.NATIVE;
                    Class cls2 = Boolean.TYPE;
                    if (zB) {
                        int i = 0;
                        FactoryPools factoryPoolsVar = ewm.c;
                        IEmpty7 btcVar = ewm.b[0];
                        SyntheticPileOfMess bmuVarBh = dqc.bh(factoryPoolsVar.w());
                        ((Configuration) bmuVarBh.obj).processorResolver = ewlVar;
                        bmuVarBh.setHookOptional(false);
                        MethodResolver methodResolverVarT = bmuVarBh.getMethodResolverBasedOnPreviouslyProvidedConfig();
                        methodResolverVarT.name = "nativeLoad";
                        Class cls3 = Integer.TYPE;
                        methodResolverVarT.setParams(Arrays.copyOf(
                                new Object[] { dal.getKClassFromClass(cls3), dal.getKClassFromClass(String.class), dal.getKClassFromClass(cls3), dal.getKClassFromClass(evt.b()) }, 4));
                        methodResolverVarT.addAccessModifiers(accessModifierEnumVar);
                        MethodHookWrapper methodHookWrapperVar = (MethodHookWrapper) StaticHelpers5.g(methodResolverVarT.findMethods());
                        objF = methodHookWrapperVar != null ? methodHookWrapperVar.f(0, str, 1, null) : null;
                    } else {
                        if (!eu.b(28)) {
                            throw new IllegalStateException("Unsupported Android version.");
                        }
                        int i2 = 0;
                        FactoryPools factoryPoolsVar2 = ewm.c;
                        IEmpty7 btcVar2 = ewm.b[0];
                        SyntheticPileOfMess bmuVarBh2 = dqc.bh(factoryPoolsVar2.w());
                        ((Configuration) bmuVarBh2.obj).processorResolver = ewlVar;
                        bmuVarBh2.setHookOptional(false);
                        MethodResolver methodResolverVarT2 = bmuVarBh2.getMethodResolverBasedOnPreviouslyProvidedConfig();
                        methodResolverVarT2.name = "nativeLoad";
                        methodResolverVarT2.setParams(Arrays.copyOf(
                                new Object[] { dal.getKClassFromClass(String.class), dal.getKClassFromClass(cls2), dal.getKClassFromClass(cls2), dal.getKClassFromClass(cls2) }, 4));
                        methodResolverVarT2.addAccessModifiers(accessModifierEnumVar);
                        MethodHookWrapper methodHookWrapperVar2 = (MethodHookWrapper) StaticHelpers5.g(methodResolverVarT2.findMethods());
                        if (methodHookWrapperVar2 != null) {
                            Boolean bool = Boolean.FALSE;
                            objF = methodHookWrapperVar2.f(str, bool, bool, bool);
                        }
                    }
                    Long l = objF instanceof Long ? (Long) objF : null;
                    if (l == null) {
                        throw new IllegalStateException("Failed to create ApkAssets.");
                    }
                    ewm.e = l;
                    FactoryPools factoryPoolsVar3 = ewm.d;
                    IEmpty7 btcVar3 = ewm.b[1];
                    SyntheticPileOfMess bmuVarBh3 = dqc.bh(factoryPoolsVar3.w());
                    ((Configuration) bmuVarBh3.obj).processorResolver = ewlVar;
                    bmuVarBh3.setHookOptional(false);
                    adt adtVarM = bmuVarBh3.m();
                    boolean zB2 = eu.b(36);
                    Class cls4 = Long.TYPE;
                    if (zB2) {
                        adtVarM.setParams(
                                Arrays.copyOf(new Object[] { dal.getKClassFromClass(AssetManager.class), dal.getKClassFromClass(cls4), dal.getKClassFromClass(cls2) }, 3));
                    } else {
                        adtVarM.setParams(Arrays.copyOf(new Object[] { dal.getKClassFromClass(AssetManager.class), dal.getKClassFromClass(cls4) }, 2));
                    }
                    ConstructorHookWrapper constructorHookWrapperVar = (ConstructorHookWrapper) StaticHelpers5.g(adtVarM.a());
                    if (constructorHookWrapperVar != null) {
                        AutoCloseable autoCloseable = eu.b(36) ? (AutoCloseable) constructorHookWrapperVar.c(null, ewm.e, Boolean.FALSE)
                                : (AutoCloseable) constructorHookWrapperVar.c(null, ewm.e);
                        if (autoCloseable != null) {
                            ewm.f = autoCloseable;
                            ewm.g = true;
                        }
                    }
                    throw new IllegalStateException("Failed to create XmlBlock$Parser.");
                }
            }
        }
        bluVar.e.add(blrVar);
        return blrVar;
    }

    public final View j(String str) throws cth {
        View view = (View) this.f.get(str);
        if (view != null) {
            return view;
        }
        throw new cth(concat("View with id \"", str, "\" not found."));
    }

    public final View k() throws cth {
        View view = (View) StaticHelpers5.f(this.f.values());
        if (view != null) {
            return view;
        }
        throw new cth("No root view found, are you sure you have provided any view?");
    }
}
