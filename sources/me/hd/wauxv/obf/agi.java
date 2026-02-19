package me.hd.wauxv.obf;

import java.util.LinkedHashSet;
import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class agi extends bws implements IDexFind {
    public static final agi a = new agi();
    public static final LinkedHashSet b = new LinkedHashSet();

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        List listBf = dqc.toSingletonList(emn.bb(agg.a));
        agi agiVar = a;
        aki akiVarAb = csb.ab(agiVar, listBf);
        akiVarAb.n(new age(1));
        akiVarAb.o();
        aki akiVarAb2 = csb.ab(agiVar, dqc.toSingletonList(emn.bb(agh.a)));
        akiVarAb2.n(new age(0));
        akiVarAb2.o();
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        emn.aj(agg.a, dexKitBridge, new age(2));
        emn.aj(agh.a, dexKitBridge, new age(3));
    }
}
