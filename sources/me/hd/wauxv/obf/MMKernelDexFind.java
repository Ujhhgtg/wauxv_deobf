package me.hd.wauxv.obf;

import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class MMKernelDexFind extends bws implements IDexFind {
    public static final MMKernelDexFind INSTANCE = new MMKernelDexFind();

    public static Object getCoreStorage() {
        MethodResolver methodResolverVarT = dqc.bh(StaticHelpers7.toDexClass(MMKernel$ClassMMKernel.INSTANCE)).getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT.returnType = StaticHelpers7.toDexClass(CoreStorage$ClassCoreStorage.INSTANCE);
        Object objE = ((MethodHookWrapper) bjs.resolveFirstMethodWithoutParams(methodResolverVarT)).invokeAndThrowIfFailed();
        throwIfVar1IsNull(objE);
        return objE;
    }

    public static Object c() {
        MethodResolver methodResolverVarT = dqc.bh(StaticHelpers7.toDexClass(MMKernel$ClassMMKernel.INSTANCE)).getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT.returnType = StaticHelpers7.toDexMethod(NetSceneQueue$MethodAddNetSceneToQueue.INSTANCE).getDeclaringClass();
        Object objE = ((MethodHookWrapper) bjs.resolveFirstMethodWithoutParams(methodResolverVarT)).invokeAndThrowIfFailed();
        throwIfVar1IsNull(objE);
        return objE;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(MMKernel$ClassMMKernel.INSTANCE, dexKitBridge, (obj) -> {
            ((FindDexClassMethodDslWrapper) obj).onClassCallback = (obj2) -> {
                DexClassQueryBuilder dexClassQueryBuilderVar2 = (DexClassQueryBuilder) obj2;
                DexMethodGroupMatcher zbVar2 = new DexMethodGroupMatcher();
                zbVar2.usingEqStrings("MicroMsg.MMKernel", "Kernel not null, has initialized.");
                dexClassQueryBuilderVar2.methodGroupMatcher = zbVar2;
            };
        });
        StaticHelpers7.resolveDexAndCache(MMKernel$MethodGetServiceImpl.INSTANCE, dexKitBridge, (obj) -> {
            ((FindDexClassMethodDslWrapper) obj).onMethodCallback = (obj2) -> {
                DexMethodQueryBuilder dexMethodQueryBuilderVar7 = (DexMethodQueryBuilder) obj2;
                DexFinder cdjVar7 = new DexFinder();
                cdjVar7.setDeclaredClassName(StaticHelpers7.toDexClass(MMKernel$ClassMMKernel.INSTANCE));
                cdjVar7.q(Class.class);
                dexMethodQueryBuilderVar7.dexFinder = cdjVar7;
            };
        });
    }
}
