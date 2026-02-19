package me.hd.wauxv.obf;

import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cvh extends bws implements IDexFind {
    public static final cvh a = new cvh();

    public final Class b() {
        return ajn.tryGetClassByClassName("com.tencent.mm.ui.base.preference.Preference" /* "com.tencent.mm.ui.base.preference.Preference" /* "com.tencent.mm.ui.base.preference.Preference" /* "com.tencent.mm.ui.base.preference.Preference" /* cnb.z(-101992588376874L)   */);
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        emn.aj(cvd.a, dexKitBridge, new AnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(24));
        emn.aj(cvf.a, dexKitBridge, new AnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(25));
        emn.aj(cve.a, dexKitBridge, new AnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(26));
    }
}
