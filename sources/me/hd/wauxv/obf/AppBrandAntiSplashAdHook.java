package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class AppBrandAntiSplashAdHook extends SwitchHook implements IDexFind {
    public static final AppBrandAntiSplashAdHook a = new AppBrandAntiSplashAdHook("AppBrandAntiSplashAdHook" /*
                                                                                                              * cnb.z(-
                                                                                                              * 409065570171690L)
                                                                                                              */);
    public static final String b = "小程序" /* "小程序" /* "小程序" /* "小程序" /* cnb.z(-411032665193258L)   */;
    public static final String c = "禁止开屏广告" /* "禁止开屏广告" /* "禁止开屏广告" /* "禁止开屏广告" /* cnb.z(-410981125585706L)   */;
    public static final String d = "阻止小程序启动时加载的五秒全屏广告" /* "阻止小程序启动时加载的五秒全屏广告" /* "阻止小程序启动时加载的五秒全屏广告" /* "阻止小程序启动时加载的五秒全屏广告" /* cnb.z(-410951060814634L)   */;
    public static final String[] i = { ewi.b.e, ewi.c.e };
    public static final boolean j = true;

    @Override // me.hd.wauxv.obf.SwitchHook, me.hd.wauxv.obf.bmf
    public final String[] _aa() {
        return i;
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void initOnce() {
        List listBf = dqc.toSingletonList(StaticHelpers7.bb(gv.a));
        AppBrandAntiSplashAdHook gwVar = a;
        aki akiVarAb = PackageParam.ab(gwVar, listBf);
        gwVar.y(akiVarAb, new gi(14));
        akiVarAb.o();
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
        StaticHelpers7.resolveDexAndCache(gv.a, dexKitBridge, new gi(15));
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
