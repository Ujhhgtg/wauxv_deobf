package me.hd.wauxv.obf;

import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bop extends bws implements IDexFind {
    public static final bop a = new bop();

    public static String b(Object obj) {
        int i = 0;
        bol.a.getClass();
        MethodResolver methodResolverVarT = dqc.bh(StaticHelpers7.toDexClass(boj.a)).getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT.addAccessModifiers(AccessModifierEnum.STATIC);
        a.getClass();
        methodResolverVarT.returnType = StaticHelpers7.toDexClass(boo.a);
        Object objE = ((MethodHookWrapper) bjs.resolveFirstMethodWithoutParams(methodResolverVarT)).invokeAndThrowIfFailed(new Object[0]);
        throwIfVar1IsNull(objE);
        MethodResolver methodResolverVarT2 = dqc.getWrapperConfiguration(objE).getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT2.returnType = dal.getKClassFromClass(String.class);
        MicroMsgMsgInfoDexClassFind.INSTANCE.getClass();
        Object objJ = ((MethodHookWrapper) StaticHelpers6.setParamsBasedOnVar1Var2AndResolveFirstMethod(new Object[] { StaticHelpers7.toDexClass(MsgInfo$ClassMsgInfo.INSTANCE) }, 1, methodResolverVarT2)).invoke(obj);
        throwIfVar1IsNull(objJ);
        return (String) objJ;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(boo.a, dexKitBridge, new blx(13));
    }
}
