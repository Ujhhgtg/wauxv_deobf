package me.hd.wauxv.obf;

import java.util.LinkedHashSet;
import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bmb extends bws implements IDexFind {
    public static final bmb a = new bmb();
    public static final LinkedHashSet b = new LinkedHashSet();

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        List listBf = dqc.bf(emn.bb(blz.a));
        bmb bmbVar = a;
        aki akiVarAb = csb.ab(bmbVar, listBf);
        akiVarAb.m(new bep(27));
        akiVarAb.o();
        aki akiVarAb2 = csb.ab(bmbVar, dqc.bf(emn.bb(bma.a)));
        akiVarAb2.m(new bep(26));
        akiVarAb2.o();
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        emn.aj(blz.a, dexKitBridge, new bep(29));
        emn.aj(bma.a, dexKitBridge, new blx(0));
    }
}
