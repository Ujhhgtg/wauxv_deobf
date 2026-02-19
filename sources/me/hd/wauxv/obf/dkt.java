package me.hd.wauxv.obf;

import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dkt extends bws implements IDexFind {
    public static final dkt a = new dkt();

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(dkr.a, dexKitBridge, new djk(24));
        StaticHelpers7.resolveDexAndCache(dkq.a, dexKitBridge, new djk(25));
        StaticHelpers7.resolveDexAndCache(dkp.a, dexKitBridge, new djk(26));
        StaticHelpers7.resolveDexAndCache(dks.a, dexKitBridge, new djk(27));
    }
}
