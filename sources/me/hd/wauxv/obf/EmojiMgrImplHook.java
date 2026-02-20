package me.hd.wauxv.obf;

import android.content.Context;
import org.luckypray.dexkit.DexKitBridge;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class EmojiMgrImplHook extends bws implements IDexFind {
    public static final EmojiMgrImplHook INSTANCE = new EmojiMgrImplHook();

    public static String getMd5FromPath(String str) {
        MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(EmojiFeatureServiceDexFinder.getEmojiFeatureService()).getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT.returnType = dal.getKClassFromClass(String.class);
        Object objJ = ((MethodHookWrapper) StaticHelpers6.setParamsBasedOnVar1Var2AndResolveFirstMethod(new Object[] { dal.getKClassFromClass(Context.class), dal.getKClassFromClass(String.class) }, 2, methodResolverVarT)).invoke(null,
                str);
        throwIfVar1IsNull(objJ);
        return (String) objJ;
    }

    public static void sendEmoji(String str, Object obj) {
        MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(EmojiFeatureServiceDexFinder.getEmojiFeatureService()).getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT.returnType = Void.TYPE;
        methodResolverVarT.parametersCondition = (obj2) -> {
            boolean z;
            List list = (List) obj2;
            Object list0 = list.get(0);
            if (nullSafeIsEqual(list0, String.class)) {
                Object list1 = list.get(1);
                if (nullSafeIsEqual(list1, StaticHelpers7.toDexMethod(EmojiInfo$MethodSaveEmojiThumb.INSTANCE).getDeclaringClass())) {
                    Object list2 = list.get(2);
                    z = nullSafeIsEqual(list2, StaticHelpers7.toDexClass(MsgInfo$ClassMsgInfo.INSTANCE));
                }
            }
            return Boolean.valueOf(z);
        };
        MethodHookWrapper methodHookWrapperVar = (MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT.findMethods());
        int parameterCount = methodHookWrapperVar.method.getParameterCount();
        if (parameterCount == 4) {
            methodHookWrapperVar.invokeAndThrowIfFailed(str, obj, null, null);
        } else if (parameterCount != 5) {
            methodHookWrapperVar.invokeAndThrowIfFailed(str, obj, null);
        } else {
            methodHookWrapperVar.invokeAndThrowIfFailed(str, obj, null, null, 0);
        }
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(EmojiMgrImpl$ClassEmojiMgrImpl.INSTANCE, dexKitBridge, (obj) -> {
            ((FindDexClassMethodDslWrapper) obj).onClassCallback = (obj2) -> {
                DexClassQueryBuilder dexClassQueryBuilderVar3 = (DexClassQueryBuilder) obj2;
                DexMethodGroupMatcher zbVar3 = new DexMethodGroupMatcher();
                zbVar3.usingEqStrings("MicroMsg.emoji.EmojiMgrImpl", "sendEmoji: context is null");
                dexClassQueryBuilderVar3.methodGroupMatcher = zbVar3;
            };
        });
    }
}
