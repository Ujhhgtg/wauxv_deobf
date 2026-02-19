package me.hd.wauxv.obf;

import android.content.Context;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class auh extends bws implements IDexFind {
    public static final auh a = new auh();

    public static String b(String str) {
        int i = 0;
        atm.a.getClass();
        MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(atm.b()).getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT.returnType = dal.b(String.class);
        Object objJ = ((MethodHookWrapper) StaticHelpers6.n(new Object[] { dal.b(Context.class), dal.b(String.class) }, 2, methodResolverVarT)).j(null,
                str);
        throwIfVar1IsNull(objJ);
        return (String) objJ;
    }

    public static void c(auh auhVar, String str, Object obj) {
        auhVar.getClass();
        int i = 0;
        atm.a.getClass();
        MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(atm.b()).getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT.returnType = Void.TYPE;
        methodResolverVarT.d = new atn(13);
        MethodHookWrapper methodHookWrapperVar = (MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT.findMethods());
        int parameterCount = methodHookWrapperVar.method.getParameterCount();
        if (parameterCount == 4) {
            methodHookWrapperVar.e(str, obj, null, null);
        } else if (parameterCount != 5) {
            methodHookWrapperVar.e(str, obj, null);
        } else {
            methodHookWrapperVar.e(str, obj, null, null, 0);
        }
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(aug.a, dexKitBridge, new atn(14));
    }
}
