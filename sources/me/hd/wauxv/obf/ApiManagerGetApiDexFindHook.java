package me.hd.wauxv.obf;

import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ApiManagerGetApiDexFindHook extends ApiHookItem implements IDexFind {
    public static final ApiManagerGetApiDexFindHook a = new ApiManagerGetApiDexFindHook();

    public static Object getApi(Class cls, Object obj) {
        return StaticHelpers7.toDexMethod(ApiManager$MethodGetApi.INSTANCE).invoke(obj, cls);
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(ApiManager$MethodGetApi.INSTANCE, dexKitBridge, (obj -> {
            ((FindDexClassMethodDslWrapper) obj).onMethodCallback = (obj1 -> {
                DexMethodQueryBuilder dexMethodQueryBuilderVar4 = (DexMethodQueryBuilder) obj1;
                String[] strArr = { "com.tencent.mm.ui.chatting.manager" };
                dexMethodQueryBuilderVar4.searchedPackages = SomeStaticHelpers.arrayToList(strArr);
                DexFinder cdjVar4 = new DexFinder();
                cdjVar4.usingStrings("[get] ", " is not a interface!");
                dexMethodQueryBuilderVar4.dexFinder = cdjVar4;
            })
        }));
    }
}
