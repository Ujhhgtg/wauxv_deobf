package me.hd.wauxv.obf;

import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class epx extends bws implements IDexFind {
    public static final epx a = new epx();

    public static Object b() {
        int i = 0;
        MethodResolver methodResolverVarT = dqc.bh(StaticHelpers7.toDexClass(epw.a)).getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT.addAccessModifiers(AccessModifierEnum.STATIC);
        eqb.a.getClass();
        methodResolverVarT.returnType = StaticHelpers7.toDexMethod(eqa.a).getDeclaringClass();
        Object objE = ((MethodHookWrapper) bjs.resolveFirstMethodWithoutParams(methodResolverVarT)).invokeAndThrowIfFailed(new Object[0]);
        throwIfVar1IsNull(objE);
        return objE;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(epw.a, dexKitBridge, new dos(26));
    }
}
