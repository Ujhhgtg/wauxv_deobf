package me.hd.wauxv.obf;

import java.util.LinkedHashSet;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aqw extends bws implements IDexFind {
    public static final aqw a = new aqw();
    public static final LinkedHashSet b = new LinkedHashSet();

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() throws NoSuchMethodException {
        aki akiVarAb = csb.ab(a, dqc.bf(emn.bb(aqv.a)));
        akiVarAb.n(new amb(21));
        akiVarAb.o();
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        emn.aj(aqv.a, dexKitBridge, new amb(22));
    }
}
