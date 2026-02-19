package me.hd.wauxv.obf;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ge extends SwitchHook {
    public static final ge a = new ge("AntiSnsAdInfo" /* "AntiSnsAdInfo" /* "AntiSnsAdInfo" /* "AntiSnsAdInfo" /* cnb.z(-543888888560426L)   */);
    public static final String b = "朋友圈" /* "朋友圈" /* "朋友圈" /* "朋友圈" /* cnb.z(-544198126205738L)   */;
    public static final String c = "拦截朋友圈广告" /* "拦截朋友圈广告" /* "拦截朋友圈广告" /* "拦截朋友圈广告" /* cnb.z(-544215306074922L)   */;
    public static final String d = "拦截浏览朋友圈出现各种碍眼广告项目" /* "拦截浏览朋友圈出现各种碍眼广告项目" /* "拦截浏览朋友圈出现各种碍眼广告项目" /* "拦截浏览朋友圈出现各种碍眼广告项目" /* cnb.z(-544180946336554L)   */;
    public static final boolean h = true;

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        int i = 0;
        adt adtVarM = yg.s(-543880298625834L).m();
        adtVarM.setParams(Arrays.copyOf(new Object[] { dal.getKClassFromClass(String.class) }, 1));
        ConstructorHookWrapper constructorHookWrapperVar = (ConstructorHookWrapper) StaticHelpers5.safeGetFirstInList(adtVarM.a());
        HookPriorityEnum hookPriorityEnumVar = HookPriorityEnum.ENUM_DEFAULT;
        ge geVar = a;
        HookManager hookManagerVarAd = geVar.createImmediateHook(constructorHookWrapperVar, hookPriorityEnumVar);
        geVar.y(hookManagerVarAd, new bn(26));
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
        return h;
    }
}
