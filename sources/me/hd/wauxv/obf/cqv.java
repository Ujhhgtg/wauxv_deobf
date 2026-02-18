package me.hd.wauxv.obf;

import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cqv extends bws implements IDexFind {
    public static final cqv a = new cqv();

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() throws NoSuchMethodException {
        aki akiVarAb = csb.ab(a, dqc.bf(emn.bb(cqu.a)));
        akiVarAb.n(new cml(23));
        akiVarAb.o();
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        emn.aj(cqu.a, dexKitBridge, new cml(25));
    }
}
