package me.hd.wauxv.obf;

import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aub extends bws implements IDexFind {
    public static final aub a = new aub();

    public static Object b(String str) {
        int i = 0;
        aup.a.getClass();
        auo auoVar = auo.a;
        MethodResolver methodResolverVarT = dqc.bh(StaticHelpers7.az(auoVar)).getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT.ak(cdy.c);
        methodResolverVarT.returnType = StaticHelpers7.az(auoVar);
        Object objE = ((MethodHookWrapper) bjs.h(methodResolverVarT)).e(new Object[0]);
        throwIfVar1IsNull(objE);
        MethodResolver methodResolverVarT2 = dqc.getWrapperConfiguration(objE).getMethodResolverBasedOnPreviouslyProvidedConfig();
        a.getClass();
        methodResolverVarT2.returnType = StaticHelpers7.az(aua.a);
        Object objE2 = ((MethodHookWrapper) bjs.h(methodResolverVarT2)).e(new Object[0]);
        throwIfVar1IsNull(objE2);
        MethodResolver methodResolverVarT3 = dqc.getWrapperConfiguration(objE2).getMethodResolverBasedOnPreviouslyProvidedConfig();
        atz.a.getClass();
        methodResolverVarT3.returnType = StaticHelpers7.bb(aty.a).getDeclaringClass();
        Object objE3 = ((MethodHookWrapper) StaticHelpers6.n(new Object[] { dal.b(String.class) }, 1, methodResolverVarT3)).e(str);
        throwIfVar1IsNull(objE3);
        return objE3;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(aua.a, dexKitBridge, new atn(11));
    }
}
