package me.hd.wauxv.obf;

import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class VideoServiceDexFindHook extends ApiHookItem implements IDexFind {
    public static final VideoServiceDexFindHook INSTANCE = new VideoServiceDexFindHook();

    public static Object b() {
        MethodResolver methodResolverVarT = dqc.bh(StaticHelpers7.toDexClass(VideoFeatureService$ClassVideoFeatureService.INSTANCE)).getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT.addAccessModifiers(AccessModifierEnum.STATIC);
        methodResolverVarT.returnType = StaticHelpers7.toDexMethod(VideoInfoStorage$MethodGetRestoreMp4Path.INSTANCE).getDeclaringClass();
        Object objE = ((MethodHookWrapper) bjs.resolveFirstMethodWithoutParams(methodResolverVarT)).invokeAndThrowIfFailed();
        throwIfVar1IsNull(objE);
        return objE;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(VideoFeatureService$ClassVideoFeatureService.INSTANCE, dexKitBridge, (obj -> {
            ((FindDexClassMethodDslWrapper) obj).onClassCallback = (obj1 -> {
                DexClassQueryBuilder dexClassQueryBuilderVar4 = (DexClassQueryBuilder) obj1;
                DexMethodGroupMatcher zbVar4 = new DexMethodGroupMatcher();
                zbVar4.usingEqStrings("MicroMsg.VideoService", "MicroMsg.SubCoreVideo", "quitVideoSendThread");
                dexClassQueryBuilderVar4.methodGroupMatcher = zbVar4;
            });
        }));
    }
}
