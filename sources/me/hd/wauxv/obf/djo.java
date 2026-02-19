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
        List listBf = dqc.toSingletonList(StaticHelpers7.toDexMethod(djm.a));
        djo djoVar = a;
        HookManager hookManagerVarAb = PackageParam.createHook(djoVar, listBf);
        hookManagerVarAb.n(new dhg(27));
        hookManagerVarAb.initInstantCollectionAndApplyHooks();
        HookManager hookManagerVarAb2 = PackageParam.createHook(djoVar, dqc.toSingletonList(StaticHelpers7.toDexMethod(djn.a)));
        hookManagerVarAb2.n(new dhg(28));
        hookManagerVarAb2.initInstantCollectionAndApplyHooks();
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(djm.a, dexKitBridge, new dhg(29));
        StaticHelpers7.resolveDexAndCache(djn.a, dexKitBridge, new djk(0));
    }
}
