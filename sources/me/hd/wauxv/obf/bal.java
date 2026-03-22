package me.hd.wauxv.obf;

import java.util.LinkedHashSet;
import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bal extends ApiHookItem implements IDexFind {
    public static final bal a = new bal();
    public static final LinkedHashSet b = new LinkedHashSet();

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        List listBf = dqc.toSingletonList(StaticHelpers7.toDexMethod(FinderChatShareMenuApi$MethodCreateMenuInvoke.a));
        bal balVar = a;
        HookManager hookManagerVarAb = PackageParam.createHook(balVar, listBf);
        hookManagerVarAb.hookBefore(new ayz(12));
        hookManagerVarAb.initInstantCollectionAndApplyHooks();
        HookManager hookManagerVarAb2 = PackageParam.createHook(balVar, dqc.toSingletonList(StaticHelpers7.toDexMethod(FinderChatShareMenuApi$MethodSelectMenuInvoke.a)));
        hookManagerVarAb2.hookBefore(new ayz(11));
        hookManagerVarAb2.initInstantCollectionAndApplyHooks();
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(FinderChatShareMenuApi$MethodCreateMenuInvoke.a, dexKitBridge, new ayz(13));
        StaticHelpers7.resolveDexAndCache(FinderChatShareMenuApi$MethodSelectMenuInvoke.a, dexKitBridge, new ayz(14));
    }
}
