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
        List listBf = dqc.toSingletonList(StaticHelpers7.bb(cew.a));
        cey ceyVar = a;
        aki akiVarAb = PackageParam.ab(ceyVar, listBf);
        akiVarAb.n(new EvenAnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(7));
        akiVarAb.o();
        aki akiVarAb2 = PackageParam.ab(ceyVar, dqc.toSingletonList(StaticHelpers7.bb(cex.a)));
        akiVarAb2.m(new EvenAnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(6));
        akiVarAb2.o();
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(cew.a, dexKitBridge, new EvenAnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(10));
        StaticHelpers7.resolveDexAndCache(cex.a, dexKitBridge, new EvenAnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(11));
    }
}
