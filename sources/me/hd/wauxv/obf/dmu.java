package me.hd.wauxv.obf;

import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dmu extends bws implements IDexFind {
    public static final dmu a = new dmu();

    public static Object b() {
        int i = bte.a;
        dgf.a.getClass();
        a.getClass();
        cde cdeVarT = dqc.bi(dgf.b(emn.az(dmt.a))).t();
        agp.a.getClass();
        cdeVarT.a = emn.az(agl.a);
        Object objE = ((cdk) bjs.h(cdeVarT)).e(new Object[0]);
        throwIfVar1IsNull(objE);
        return objE;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        emn.aj(dmq.a, dexKitBridge, new dko(17));
        emn.aj(dms.a, dexKitBridge, new dko(18));
        emn.aj(dmr.a, dexKitBridge, new dko(19));
        emn.aj(dmt.a, dexKitBridge, new dko(20));
    }
}
