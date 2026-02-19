package me.hd.wauxv.obf;

import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aec extends bws implements IDexFind {
    public static final aec a = new aec();

    public static Object b() {
        int i = 0;
        cde cdeVarT = dqc.bh(emn.az(aea.a)).t();
        aeg.a.getClass();
        cdeVarT.a = emn.bb(aee.a).getDeclaringClass();
        Object objE = ((MethodHookWrapper) bjs.h(cdeVarT)).e(new Object[0]);
        throwIfVar1IsNull(objE);
        return objE;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        emn.aj(aeb.a, dexKitBridge, new act(6));
        emn.aj(aea.a, dexKitBridge, new act(7));
    }
}
