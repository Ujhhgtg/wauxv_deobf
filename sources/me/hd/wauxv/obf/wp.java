package me.hd.wauxv.obf;

import java.util.LinkedHashSet;
import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class wp extends bws implements IDexFind {
    public static final wp a = new wp();
    public static final LinkedHashSet b = new LinkedHashSet();

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        List listBf = dqc.toSingletonList(StaticHelpers7.bb(wo.a));
        wp wpVar = a;
        aki akiVarAb = PackageParam.ab(wpVar, listBf);
        akiVarAb.m(new us(17));
        akiVarAb.o();
        aki akiVarAb2 = PackageParam.ab(wpVar, dqc.toSingletonList(StaticHelpers7.bb(wn.a)));
        akiVarAb2.m(new us(18));
        akiVarAb2.o();
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(wo.a, dexKitBridge, new us(19));
        StaticHelpers7.resolveDexAndCache(wn.a, dexKitBridge, new us(20));
    }
}
