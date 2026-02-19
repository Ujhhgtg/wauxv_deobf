package me.hd.wauxv.obf;

import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class gp extends bws implements IDexFind {
    public static final gp a = new gp();

    public static Object b(Class cls, Object obj) {
        Object objInvoke = StaticHelpers7.bb(go.a).invoke(obj, cls);
        throwIfVar1IsNull(objInvoke);
        return objInvoke;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(go.a, dexKitBridge, new gi(9));
    }
}
