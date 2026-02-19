package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class gf extends SwitchHook {
    public static final gf a = new gf("AntiSnsAutoPlayHook" /* "AntiSnsAutoPlayHook" /* "AntiSnsAutoPlayHook" /* cnb.z(-544120816794410L)  */);
    public static final String b = "朋友圈" /* "朋友圈" /* "朋友圈" /* cnb.z(-543618305620778L)  */;
    public static final String c = "拦截朋友圈播放" /* "拦截朋友圈播放" /* "拦截朋友圈播放" /* cnb.z(-543635485489962L)  */;
    public static final String d = "拦截朋友圈上下滑动时会自动播放视频" /* "拦截朋友圈上下滑动时会自动播放视频" /* "拦截朋友圈上下滑动时会自动播放视频" /* cnb.z(-543601125751594L)  */;

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        int i = 0;
        MethodResolver methodResolverVarT = yg.s(-544000557710122L).getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT.name = "onScrollStateChangedInMain" /* "onScrollStateChangedInMain" /* "onScrollStateChangedInMain" /* cnb.z(-543167334054698L)  */;
        methodResolverVarT.paramCount = 3;
        MethodHookWrapper methodHookWrapperVar = (MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT.findMethods());
        HookPriorityEnum hookPriorityEnumVar = HookPriorityEnum.ENUM_DEFAULT;
        gf gfVar = a;
        aki akiVarAd = gfVar.ad(methodHookWrapperVar, hookPriorityEnumVar);
        gfVar.y(akiVarAd, new bn(27));
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
}
