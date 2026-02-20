package me.hd.wauxv.obf;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class md extends SwitchHook {
    public static final md a = new md("AutoLoginWinHook" /* "AutoLoginWinHook" /* "AutoLoginWinHook" /* "AutoLoginWinHook" /* cnb.z(-510529877572394L)   */);
    public static final String b = "杂项" /* "杂项" /* "杂项" /* "杂项" /* cnb.z(-512265044359978L)   */;
    public static final String c = "自动点击登录" /* "自动点击登录" /* "自动点击登录" /* "自动点击登录" /* cnb.z(-512217799719722L)   */;
    public static final String d = "微信请求登录时自动勾选项及点击按钮" /* "微信请求登录时自动勾选项及点击按钮" /* "微信请求登录时自动勾选项及点击按钮" /* "微信请求登录时自动勾选项及点击按钮" /* cnb.z(-512170555079466L)   */;
    public static final gi h = new gi(27);

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        int i = 0;
        SyntheticPileOfMess bmuVarS = yg.s(-510474042997546L);
        MethodResolver methodResolverVarT = bmuVarS.getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT.name = "onCreate" /* "onCreate" /* "onCreate" /* "onCreate" /* cnb.z(-511925741943594L)   */;
        MethodHookWrapper methodHookWrapperVar = (MethodHookWrapper) StaticHelpers6.setParamsBasedOnVar1Var2AndResolveFirstMethod(new Object[] { dal.getKClassFromClass(Bundle.class) }, 1, methodResolverVarT);
        md mdVar = a;
        HookPriorityEnum hookPriorityEnumVar = HookPriorityEnum.ENUM_DEFAULT;
        HookManager hookManagerVarAd = mdVar.createImmediateHook(methodHookWrapperVar, hookPriorityEnumVar);
        mdVar.hookBefore(hookManagerVarAd, new gi(28));
        hookManagerVarAd.initInstantCollectionAndApplyHooks();
        MethodResolver methodResolverVarT2 = bmuVarS.getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT2.name = "initView" /* "initView" /* "initView" /* "initView" /* cnb.z(-511887087237930L)   */;
        HookManager hookManagerVarAd2 = mdVar.createImmediateHook((MethodHookWrapper) bjs.resolveFirstMethodWithoutParams(methodResolverVarT2), hookPriorityEnumVar);
        mdVar.hookAfter(hookManagerVarAd2, new gi(29));
        hookManagerVarAd2.initInstantCollectionAndApplyHooks();
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
    public final IInvokable getOnClick() {
        return h;
    }
}
