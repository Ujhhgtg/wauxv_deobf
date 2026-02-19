package me.hd.wauxv.obf;

import java.util.LinkedHashSet;
import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class wm extends bws implements IDexFind {
    public static final wm a = new wm();
    public static final LinkedHashSet b = new LinkedHashSet();

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        List listBf = dqc.toSingletonList(StaticHelpers7.toDexMethod(wk.a));
        wm wmVar = a;
        HookManager hookManagerVarAb = PackageParam.createHook(wmVar, listBf);
        hookManagerVarAb.n(new us(11));
        hookManagerVarAb.initInstantCollectionAndApplyHooks();
        HookManager hookManagerVarAb2 = PackageParam.createHook(wmVar, dqc.toSingletonList(StaticHelpers7.toDexMethod(wl.a)));
        hookManagerVarAb2.n(new us(12));
        hookManagerVarAb2.initInstantCollectionAndApplyHooks();
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(wk.a, dexKitBridge, new us(14));
        StaticHelpers7.resolveDexAndCache(wl.a, dexKitBridge, new us(15));
    }
}
