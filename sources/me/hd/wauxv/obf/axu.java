package me.hd.wauxv.obf;

import java.util.LinkedHashSet;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class axu extends bws implements IDexFind {
    public static final axu a = new axu();
    public static final LinkedHashSet b = new LinkedHashSet();

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() throws NoSuchMethodException {
        HookManager hookManagerVarAb = PackageParam.createHook(a, dqc.toSingletonList(StaticHelpers7.toDexMethod(axt.a)));
        hookManagerVarAb.m(new atn(19));
        hookManagerVarAb.initInstantCollectionAndApplyHooks();
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(axt.a, dexKitBridge, new atn(20));
    }
}
