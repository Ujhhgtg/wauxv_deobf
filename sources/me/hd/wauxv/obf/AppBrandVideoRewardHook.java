package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class AppBrandVideoRewardHook extends SwitchHook {
    public static final AppBrandVideoRewardHook a = new AppBrandVideoRewardHook("AppBrandVideoRewardHook" /*
                                                                                                           * cnb.z(-
                                                                                                           * 410461434542890L)
                                                                                                           */);
    public static final String b = "小程序" /* "小程序" /* "小程序" /* "小程序" /* cnb.z(-434053689899818L)   */;
    public static final String c = "程序视频奖励" /* "程序视频奖励" /* "程序视频奖励" /* "程序视频奖励" /* cnb.z(-433452394478378L)   */;
    public static final String d = "跳过小程序视频广告等待时长领取奖励" /* "跳过小程序视频广告等待时长领取奖励" /* "跳过小程序视频广告等待时长领取奖励" /* "跳过小程序视频广告等待时长领取奖励" /* cnb.z(-433422329707306L)   */;
    public static final String[] h = { ewi.b.e, ewi.c.e };
    public static final boolean i = true;

    @Override // me.hd.wauxv.obf.SwitchHook, me.hd.wauxv.obf.SwitchHook
    public final String[] _aa() {
        return h;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        int i2 = 0;
        MethodResolver methodResolverVarT = yg.s(-433997855324970L).getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT.name = "subscribeHandler" /* "subscribeHandler" /* "subscribeHandler" /* "subscribeHandler" /* cnb.z(-434246963428138L)   */;
        MethodHookWrapper methodHookWrapperVar = (MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT.findMethods());
        HookPriorityEnum hookPriorityEnumVar = HookPriorityEnum.ENUM_DEFAULT;
        AppBrandVideoRewardHook gyVar = a;
        aki akiVarAd = gyVar.ad(methodHookWrapperVar, hookPriorityEnumVar);
        gyVar.y(akiVarAd, new gi(17));
        akiVarAd.o();
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getName() {
        return c;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getCategory() {
        return b;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return d;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final boolean q() {
        return i;
    }
}
