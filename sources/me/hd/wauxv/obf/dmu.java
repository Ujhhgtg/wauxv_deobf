package me.hd.wauxv.obf;

import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dmu extends bws implements IDexFind {
    public static final dmu a = new dmu();

    public static Object b() {
        int i = 0;
        ServiceManagerDexFinder.INSTANCE.getClass();
        a.getClass();
        MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(ServiceManagerDexFinder.getServiceByClass(StaticHelpers7.toDexClass(dmt.a))).getMethodResolverBasedOnPreviouslyProvidedConfig();
        agp.a.getClass();
        methodResolverVarT.returnType = StaticHelpers7.toDexClass(agl.a);
        Object objE = ((MethodHookWrapper) bjs.resolveFirstMethodWithoutParams(methodResolverVarT)).invokeAndThrowIfFailed(new Object[0]);
        throwIfVar1IsNull(objE);
        return objE;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(dmq.a, dexKitBridge, new SyntheticMessOfLambdas(17));
        StaticHelpers7.resolveDexAndCache(dms.a, dexKitBridge, new SyntheticMessOfLambdas(18));
        StaticHelpers7.resolveDexAndCache(dmr.a, dexKitBridge, new SyntheticMessOfLambdas(19));
        StaticHelpers7.resolveDexAndCache(dmt.a, dexKitBridge, new SyntheticMessOfLambdas(20));
    }
}
