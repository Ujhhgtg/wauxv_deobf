package me.hd.wauxv.obf;

import java.util.LinkedHashSet;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bzc extends ApiHookItem implements IDexFind {
    public static final bzc a = new bzc();
    public static final LinkedHashSet b = new LinkedHashSet();

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        HookManager hookManagerVarAb = PackageParam.createHook(a, dqc.toSingletonList(StaticHelpers7.toDexMethod(MainTabUiApi$MethodDoOnCreate.INSTANCE)));
        hookManagerVarAb.hookAfter(new bty(27));
        hookManagerVarAb.initInstantCollectionAndApplyHooks();
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(MainTabUiApi$MethodDoOnCreate.INSTANCE, dexKitBridge, (obj -> {
            ((FindDexClassMethodDslWrapper) obj).onMethodCallback = (obj1 -> {
                DexMethodQueryBuilder dexMethodQueryBuilderVar9 = (DexMethodQueryBuilder) obj1;
                DexFinder cdjVar10 = new DexFinder();
                DexFinder.setClassEquals(cdjVar10, "com.tencent.mm.ui.MainTabUI");
                cdjVar10.usingStrings("MicroMsg.LauncherUI.MainTabUI", "doOnCreate");
                dexMethodQueryBuilderVar9.getClass();
                dexMethodQueryBuilderVar9.dexFinder = cdjVar10;
            })
        }));
    }
}
