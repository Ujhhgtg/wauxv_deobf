package me.hd.wauxv.obf;

import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class xp extends bws implements IDexFind {
    public static final xp a = new xp();

    public static Object b(String str) {
        int i = 0;
        xn.a.getClass();
        MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(xn.b()).getMethodResolverBasedOnPreviouslyProvidedConfig();
        wv.a.getClass();
        methodResolverVarT.returnType = StaticHelpers7.az(wt.a);
        return ((MethodHookWrapper) StaticHelpers6.n(new Object[] { dal.getKClassFromClass(String.class) }, 1, methodResolverVarT)).e(str);
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(xo.a, dexKitBridge, new ws(12));
    }
}
