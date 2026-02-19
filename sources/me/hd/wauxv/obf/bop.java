package me.hd.wauxv.obf;

import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bop extends bws implements IDexFind {
    public static final bop a = new bop();

    public static String b(Object obj) {
        int i = 0;
        bol.a.getClass();
        cde cdeVarT = dqc.bh(emn.az(boj.a)).t();
        cdeVarT.ak(cdy.c);
        a.getClass();
        cdeVarT.a = emn.az(boo.a);
        Object objE = ((MethodHookWrapper) bjs.h(cdeVarT)).e(new Object[0]);
        throwIfVar1IsNull(objE);
        cde cdeVarT2 = dqc.bi(objE).t();
        cdeVarT2.a = dal.b(String.class);
        cge.a.getClass();
        Object objJ = ((MethodHookWrapper) dkz.n(new Object[] { emn.az(cgd.a) }, 1, cdeVarT2)).j(obj);
        throwIfVar1IsNull(objJ);
        return (String) objJ;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        emn.aj(boo.a, dexKitBridge, new blx(13));
    }
}
