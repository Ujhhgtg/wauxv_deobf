package me.hd.wauxv.obf;

import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bol extends bws implements IDexFind {
    public static final bol a = new bol();

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        emn.aj(bok.a, dexKitBridge, new blx(5));
        emn.aj(boi.a, dexKitBridge, new blx(6));
        emn.aj(boj.a, dexKitBridge, new blx(7));
    }
}
