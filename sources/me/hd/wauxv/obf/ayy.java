package me.hd.wauxv.obf;

import java.util.LinkedHashSet;
import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ayy extends bws implements IDexFind {
    public static final ayy a = new ayy();
    public static final LinkedHashSet b = new LinkedHashSet();

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        List listBf = dqc.toSingletonList(emn.bb(ayw.a));
        ayy ayyVar = a;
        aki akiVarAb = csb.ab(ayyVar, listBf);
        akiVarAb.n(new atn(22));
        akiVarAb.o();
        aki akiVarAb2 = csb.ab(ayyVar, dqc.toSingletonList(emn.bb(ayx.a)));
        akiVarAb2.n(new atn(23));
        akiVarAb2.o();
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        emn.aj(ayw.a, dexKitBridge, new atn(24));
        emn.aj(ayx.a, dexKitBridge, new atn(25));
    }
}
