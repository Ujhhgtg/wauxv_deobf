package me.hd.wauxv.obf;

import java.util.LinkedHashSet;
import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cey extends bws implements IDexFind {
    public static final cey a = new cey();
    public static final LinkedHashSet b = new LinkedHashSet();

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        List listBf = dqc.bf(emn.bb(cew.a));
        cey ceyVar = a;
        aki akiVarAb = csb.ab(ceyVar, listBf);
        akiVarAb.n(new bzk(7));
        akiVarAb.o();
        aki akiVarAb2 = csb.ab(ceyVar, dqc.bf(emn.bb(cex.a)));
        akiVarAb2.m(new bzk(6));
        akiVarAb2.o();
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        emn.aj(cew.a, dexKitBridge, new bzk(10));
        emn.aj(cex.a, dexKitBridge, new bzk(11));
    }
}
