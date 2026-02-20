package me.hd.wauxv.obf;

import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class EmojiFeatureServiceDexFinder extends bws implements IDexFind {
    public static final EmojiFeatureServiceDexFinder INSTANCE = new EmojiFeatureServiceDexFinder();

    public static Object getEmojiFeatureService() {
        MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(ServiceManagerDexFinder.getServiceByClass(StaticHelpers7.toDexClass(EmojiFeatureService$ClassEmojiFeatureService.INSTANCE))).getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT.returnType = StaticHelpers7.toDexClass(EmojiMgrImpl$ClassEmojiMgrImpl.INSTANCE);
        Object objE = ((MethodHookWrapper) bjs.resolveFirstMethodWithoutParams(methodResolverVarT)).invokeAndThrowIfFailed();
        throwIfVar1IsNull(objE);
        return objE;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(EmojiFeatureService$ClassEmojiFeatureService.INSTANCE, dexKitBridge, (obj) -> {
            ((FindDexClassMethodDslWrapper) obj).onClassCallback = (obj2) -> {
                DexClassQueryBuilder dexClassQueryBuilderVar4 = (DexClassQueryBuilder) obj2;
                String[] strArr3 = { "com.tencent.mm.feature.emoji" };
                dexClassQueryBuilderVar4.strings = SomeStaticHelpers.arrayToList(strArr3);
                DexMethodGroupMatcher zbVar4 = new DexMethodGroupMatcher();
                zbVar4.usingEqStrings("MicroMsg.EmojiFeatureService", "[onAccountInitialized]", "onAccountRelease: ");
                dexClassQueryBuilderVar4.methodGroupMatcher = zbVar4;
            };
        });
    }
}
