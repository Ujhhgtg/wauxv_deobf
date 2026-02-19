package me.hd.wauxv.obf;

import java.util.LinkedHashSet;
import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class djo extends bws implements IDexFind {
    public static final djo a = new djo();
    public static final LinkedHashSet b = new LinkedHashSet();

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        List listBf = dqc.toSingletonList(emn.bb(djm.a));
        djo djoVar = a;
        aki akiVarAb = csb.ab(djoVar, listBf);
        akiVarAb.n(new dhg(27));
        akiVarAb.o();
        aki akiVarAb2 = csb.ab(djoVar, dqc.toSingletonList(emn.bb(djn.a)));
        akiVarAb2.n(new dhg(28));
        akiVarAb2.o();
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        emn.aj(djm.a, dexKitBridge, new dhg(29));
        emn.aj(djn.a, dexKitBridge, new djk(0));
    }
}
