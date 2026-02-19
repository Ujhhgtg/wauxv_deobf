package me.hd.wauxv.obf;

import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class acv extends bws implements IDexFind {
    public static final acv a = new acv();

    public static Object b(acv acvVar, int i) {
        acvVar.getClass();
        int i2 = 0;
        ahd.a.getClass();
        byr.a.getClass();
        MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(byr.b()).getMethodResolverBasedOnPreviouslyProvidedConfig();
        a.getClass();
        methodResolverVarT.returnType = StaticHelpers7.az(acu.a);
        Object objE = ((MethodHookWrapper) bjs.h(methodResolverVarT)).e(new Object[0]);
        throwIfVar1IsNull(objE);
        MethodResolver methodResolverVarT2 = dqc.getWrapperConfiguration(objE).getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT2.returnType = dal.getKClassFromClass(Object.class);
        return ((MethodHookWrapper) StaticHelpers6.n(new Object[] { dal.getKClassFromClass(Integer.TYPE), dal.getKClassFromClass(Object.class) }, 2, methodResolverVarT2))
                .e(Integer.valueOf(i), null);
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(acu.a, dexKitBridge, new act(0));
    }
}
