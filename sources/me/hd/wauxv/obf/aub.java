package me.hd.wauxv.obf;

import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aub extends bws implements IDexFind {
    public static final aub a = new aub();

    public static Object b(String str) {
        int i = bte.a;
        aup.a.getClass();
        auo auoVar = auo.a;
        cde cdeVarT = dqc.bh(emn.az(auoVar)).t();
        cdeVarT.ak(cdy.c);
        cdeVarT.a = emn.az(auoVar);
        Object objE = ((cdk) bjs.h(cdeVarT)).e(new Object[0]);
        throwIfVar1IsNull(objE);
        cde cdeVarT2 = dqc.bi(objE).t();
        a.getClass();
        cdeVarT2.a = emn.az(aua.a);
        Object objE2 = ((cdk) bjs.h(cdeVarT2)).e(new Object[0]);
        throwIfVar1IsNull(objE2);
        cde cdeVarT3 = dqc.bi(objE2).t();
        atz.a.getClass();
        cdeVarT3.a = emn.bb(aty.a).getDeclaringClass();
        Object objE3 = ((cdk) dkz.n(new Object[] { dal.b(String.class) }, 1, cdeVarT3)).e(str);
        throwIfVar1IsNull(objE3);
        return objE3;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        emn.aj(aua.a, dexKitBridge, new atn(11));
    }
}
