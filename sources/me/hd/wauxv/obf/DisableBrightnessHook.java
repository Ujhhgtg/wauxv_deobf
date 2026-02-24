package me.hd.wauxv.obf;

import android.view.WindowManager;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class DisableBrightnessHook extends SwitchHook {
    public static final DisableBrightnessHook a = new DisableBrightnessHook("DisableBrightnessHook");
    public static final String b = "杂项";
    public static final String c = "禁止屏幕高亮";
    public static final String h = "屏蔽深夜点击收付款后的屏幕强制亮度";

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        int i = 0;
        MethodResolver methodResolverVarT = dqc.bh(ajn.tryGetClassByClassName("com.android.internal.policy.PhoneWindow")).getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT.name = "setAttributes";
        MethodHookWrapper methodHookWrapperVar = (MethodHookWrapper) StaticHelpers6.setParamsBasedOnVar1Var2AndResolveFirstMethod(new Object[] { dal.getKClassFromClass(WindowManager.LayoutParams.class) }, 1, methodResolverVarT);
        HookPriorityEnum hookPriorityEnumVar = HookPriorityEnum.ENUM_DEFAULT;
        DisableBrightnessHook anvVar = a;
        HookManager hookManagerVarAd = anvVar.createImmediateHook(methodHookWrapperVar, hookPriorityEnumVar);
        anvVar.hookBefore(hookManagerVarAd, (obj -> {
            HookParam hookParam2 = (HookParam) obj;
            hookParam2.getClass();
            Object objX4 = hookParam2.getArgs()[0];
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) objX4;
            if (layoutParams.screenBrightness >= 0.5f) {
                layoutParams.screenBrightness = -1.0f;
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
        return h;
    }
}
