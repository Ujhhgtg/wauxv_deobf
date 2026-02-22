package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class AppBrandVideoRewardHook extends SwitchHook {
    public static final AppBrandVideoRewardHook INSTANCE = new AppBrandVideoRewardHook("AppBrandVideoRewardHook");
    public static final String c = "程序视频奖励";
    public static final String d = "跳过小程序视频广告等待时长领取奖励";
    public static final String[] h = { APP_BRAND_ID_ENUM.APP_BRAND_0.strValue, APP_BRAND_ID_ENUM.APP_BRAND_1.strValue };
    public static final boolean i = true;

    @Override // me.hd.wauxv.obf.SwitchHook, me.hd.wauxv.obf.SwitchHook
    public final String[] _aa() {
        return h;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        MethodResolver methodResolverVarT = dqc.bh(ajn.tryGetClassByClassName("com.tencent.mm.appbrand.commonjni.AppBrandJsBridgeBinding")).getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT.name = "subscribeHandler";
        MethodHookWrapper methodHookWrapperVar = (MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT.findMethods());
        HookPriorityEnum hookPriorityEnumVar = HookPriorityEnum.ENUM_DEFAULT;
        AppBrandVideoRewardHook gyVar = INSTANCE;
        HookManager hookManagerVarAd = gyVar.createImmediateHook(methodHookWrapperVar, hookPriorityEnumVar);
        gyVar.hookBefore(hookManagerVarAd, (obj -> {
            HookParam hookParam = (HookParam) obj;
            Object args0 = hookParam.getArgs()[0];
            String args0Str = (String) args0;
            String args0StrNullSafe = args0Str == null ? "" : args0Str;
            Object args1 = hookParam.getArgs()[1];
            String args1Str = (String) args1;
            String args1StrNullSafe = args1Str != null ? args1Str : "";
            if (args0StrNullSafe.equals("onVideoTimeUpdate")) {
                JSONObject jSONObject3 = new JSONObject(args1StrNullSafe);
                jSONObject3.put("position", 60);
                jSONObject3.put("duration", 1);
                Object[] objArrI = hookParam.b.getArgs();
                if (objArrI != null) {
                    objArrI[1] = jSONObject3.toString();
                }
            }
        }));
        hookManagerVarAd.initInstantCollectionAndApplyHooks();
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
