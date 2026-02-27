package me.hd.wauxv.obf;

import java.util.LinkedHashSet;
import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bap extends ApiHookItem implements IDexFind {
    public static final bap a = new bap();
    public static final LinkedHashSet b = new LinkedHashSet();

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        List listBf = dqc.toSingletonList(StaticHelpers7.toDexMethod(ban.a));
        bap bapVar = a;
        HookManager hookManagerVarAb = PackageParam.createHook(bapVar, listBf);
        hookManagerVarAb.hookBefore(new ayz(18));
        hookManagerVarAb.initInstantCollectionAndApplyHooks();
        HookManager hookManagerVarAb2 = PackageParam.createHook(bapVar, dqc.toSingletonList(StaticHelpers7.toDexMethod(bao.a)));
        hookManagerVarAb2.hookBefore(new ayz(19));
        hookManagerVarAb2.initInstantCollectionAndApplyHooks();
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(ban.a, dexKitBridge, (obj -> {
            searchPackages("com.tencent.mm.plugin.finder.feed");
            methodName("onCreateMMMenu");
            usingEqStrings("pos is error ");
        }));
        StaticHelpers7.resolveDexAndCache(bao.a, dexKitBridge, (obj -> {
            searchPackages("com.tencent.mm.plugin.finder.feed");
            methodName("onMMMenuItemSelected");
            usingEqStrings("[getMoreMenuItemSelectedListener] feed ");
        }));
    }
}
