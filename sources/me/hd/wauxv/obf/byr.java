package me.hd.wauxv.obf;

import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class byr extends bws implements IDexFind {
    public static final byr a = new byr();

    public static Object b() {
        int i = 0;
        MethodResolver methodResolverVarT = dqc.bh(StaticHelpers7.az(byp.a)).getMethodResolverBasedOnPreviouslyProvidedConfig();
        ahd.a.getClass();
        methodResolverVarT.returnType = StaticHelpers7.az(ahc.a);
        Object objE = ((MethodHookWrapper) bjs.h(methodResolverVarT)).e(new Object[0]);
        throwIfVar1IsNull(objE);
        return objE;
    }

    public static Object c() {
        int i = 0;
        MethodResolver methodResolverVarT = dqc.bh(StaticHelpers7.az(byp.a)).getMethodResolverBasedOnPreviouslyProvidedConfig();
        cme.a.getClass();
        methodResolverVarT.returnType = StaticHelpers7.toDexMethod(cmc.a).getDeclaringClass();
        Object objE = ((MethodHookWrapper) bjs.h(methodResolverVarT)).e(new Object[0]);
        throwIfVar1IsNull(objE);
        return objE;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(byp.a, dexKitBridge, new bty(20));
        StaticHelpers7.resolveDexAndCache(byq.a, dexKitBridge, new bty(21));
    }
}
