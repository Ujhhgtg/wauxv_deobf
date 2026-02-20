package me.hd.wauxv.obf;

import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class EmojiInfoStorageDexFind extends bws implements IDexFind {
    public static final EmojiInfoStorageDexFind a = new EmojiInfoStorageDexFind();

    public static Object getEmojiInfoByMd5(String str) {
        EmojiStorageMgr$ClassEmojiStorageMgr auoVar = EmojiStorageMgr$ClassEmojiStorageMgr.INSTANCE;
        MethodResolver methodResolverVarT = dqc.bh(StaticHelpers7.toDexClass(auoVar)).getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT.addAccessModifiers(AccessModifierEnum.STATIC);
        methodResolverVarT.returnType = StaticHelpers7.toDexClass(auoVar);
        Object objE = ((MethodHookWrapper) bjs.resolveFirstMethodWithoutParams(methodResolverVarT)).invokeAndThrowIfFailed();
        throwIfVar1IsNull(objE);
        MethodResolver methodResolverVarT2 = dqc.getWrapperConfiguration(objE).getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT2.returnType = StaticHelpers7.toDexClass(EmojiInfoStorage$ClassEmojiInfoStorage.INSTANCE);
        Object objE2 = ((MethodHookWrapper) bjs.resolveFirstMethodWithoutParams(methodResolverVarT2)).invokeAndThrowIfFailed();
        throwIfVar1IsNull(objE2);
        MethodResolver methodResolverVarT3 = dqc.getWrapperConfiguration(objE2).getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT3.returnType = StaticHelpers7.toDexMethod(EmojiInfo$MethodSaveEmojiThumb.INSTANCE).getDeclaringClass();
        Object objE3 = ((MethodHookWrapper) StaticHelpers6.setParamsBasedOnVar1Var2AndResolveFirstMethod(new Object[] { dal.getKClassFromClass(String.class) }, 1, methodResolverVarT3)).invokeAndThrowIfFailed(str);
        throwIfVar1IsNull(objE3);
        return objE3;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(EmojiInfoStorage$ClassEmojiInfoStorage.INSTANCE, dexKitBridge, (obj) -> {
            ((FindDexClassMethodDslWrapper) obj).onClassCallback = (obj2) -> {
                DexClassQueryBuilder dexClassQueryBuilderVar2 = (DexClassQueryBuilder) obj2;
                DexMethodGroupMatcher zbVar2 = new DexMethodGroupMatcher();
                zbVar2.usingEqStrings("MicroMsg.emoji.EmojiInfoStorage", "md5 is null or invalue. md5:%s");
                dexClassQueryBuilderVar2.methodGroupMatcher = zbVar2;
            }
        });
    }
}
