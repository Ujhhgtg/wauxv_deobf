package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class AppBrandAntiSplashAdHook extends SwitchHook implements IDexFind {
    public static final AppBrandAntiSplashAdHook INSTANCE = new AppBrandAntiSplashAdHook("AppBrandAntiSplashAdHook");
    public static final String b = "小程序";
    public static final String c = "禁止开屏广告";
    public static final String d = "阻止小程序启动时加载的五秒全屏广告";
    public static final String[] i = { APP_BRAND_ID_ENUM.APP_BRAND_0.strValue, APP_BRAND_ID_ENUM.APP_BRAND_1.strValue};
    public static final boolean j = true;

    @Override // me.hd.wauxv.obf.SwitchHook, me.hd.wauxv.obf.bmf
    public final String[] _aa() {
        return i;
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void initOnce() {
        List listBf = dqc.toSingletonList(StaticHelpers7.toDexMethod(AppBrandAntiSplashAdHook$MethodAdDataCallback.a));
        AppBrandAntiSplashAdHook gwVar = INSTANCE;
        HookManager hookManagerVarAb = PackageParam.createHook(gwVar, listBf);
        gwVar.hookBefore(hookManagerVarAb, (obj -> {
            ((HookParam) obj).setResult(null);
        }));
        hookManagerVarAb.initInstantCollectionAndApplyHooks();
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getName() {
        return c;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getCategory() {
        return b;
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(AppBrandAntiSplashAdHook$MethodAdDataCallback.a, dexKitBridge, (obj -> {
            ((FindDexClassMethodDslWrapper) obj).onMethodCallback = (obj2 -> {
                DexMethodQueryBuilder dexMethodQueryBuilderVar6 = (DexMethodQueryBuilder) obj2;
                String[] strArr2 = {"com.tencent.mm.plugin.appbrand.jsapi.auth"};
                dexMethodQueryBuilderVar6.searchedPackages = SomeStaticHelpers.arrayToList(strArr2);
                DexFinder cdjVar6 = new DexFinder();
                cdjVar6.usingStrings("MicroMsg.AppBrand.JsApiAdOperateWXData[AppBrandSplashAd]", "cgi callback, callbackId:%s, service not running or preloaded");
                dexMethodQueryBuilderVar6.dexFinder = cdjVar6;
            })
        }));
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return d;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final boolean q() {
        return j;
    }
}
