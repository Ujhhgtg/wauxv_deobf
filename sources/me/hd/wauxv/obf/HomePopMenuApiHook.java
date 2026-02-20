package me.hd.wauxv.obf;

import java.util.LinkedHashSet;
import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class HomePopMenuApiHook extends bws implements IDexFind {
    public static final HomePopMenuApiHook INSTANCE = new HomePopMenuApiHook();
    public static final LinkedHashSet allHomePopMenuHooks = new LinkedHashSet();

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        List listBf = dqc.toSingletonList(StaticHelpers7.toDexMethod(HomePopMenuApi$MethodAddItem.INSTANCE));
        HomePopMenuApiHook bmbVar = INSTANCE;
        HookManager hookManagerVarAb = PackageParam.createHook(bmbVar, listBf);
        hookManagerVarAb.m(new bep(27));
        hookManagerVarAb.initInstantCollectionAndApplyHooks();
        HookManager hookManagerVarAb2 = PackageParam.createHook(bmbVar, dqc.toSingletonList(StaticHelpers7.toDexMethod(HomePopMenuApi$MethodClickItem.INSTANCE)));
        hookManagerVarAb2.m(new bep(26));
        hookManagerVarAb2.initInstantCollectionAndApplyHooks();
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(HomePopMenuApi$MethodAddItem.INSTANCE, dexKitBridge, (obj) -> {
            final DexMethodQueryBuilder bah4 = (DexMethodQueryBuilder)obj;
            bah4.a = SomeStaticHelpers.arrayToList(new String[] { "com.tencent.mm.ui" });
            final Object d4 = new Object();
            ((DexFinder)d4).t(new String[] { "MicroMsg.PlusSubMenuHelper", "dyna plus config is null, we use default one" });
            bah4.d = (DexFinder)d4;
        });
        StaticHelpers7.resolveDexAndCache(HomePopMenuApi$MethodClickItem.INSTANCE, dexKitBridge, (key) -> {
            final DexMethodQueryBuilder bah3 = (DexMethodQueryBuilder)key;
            final String z5 = "com.tencent.mm.ui";
            bah3.a = SomeStaticHelpers.arrayToList(new String[] { z5 });
            final Object d3 = new Object();
            ((cdj)d3).t(new String[] { "MicroMsg.PlusSubMenuHelper", "processOnItemClick" });
            bah3.d = (cdj)d3;
        });
    }
}
