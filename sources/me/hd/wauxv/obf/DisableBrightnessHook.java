package me.hd.wauxv.obf;

import android.view.WindowManager;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class DisableBrightnessHook extends SwitchHook {
    public static final DisableBrightnessHook a = new DisableBrightnessHook("DisableBrightnessHook" /*
                                                                                                     * cnb.z(-
                                                                                                     * 511367396195114L)
                                                                                                     */);
    public static final String b = "杂项" /* "杂项" /* "杂项" /* cnb.z(-511556374756138L)  */;
    public static final String c = "禁止屏幕高亮" /* "禁止屏幕高亮" /* "禁止屏幕高亮" /* cnb.z(-511560669723434L)  */;
    public static final String h = "屏蔽深夜点击收付款后的屏幕强制亮度" /* "屏蔽深夜点击收付款后的屏幕强制亮度" /* "屏蔽深夜点击收付款后的屏幕强制亮度" /* cnb.z(-517577918905130L)  */;

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        int i = 0;
        MethodResolver methodResolverVarT = yg.s(-511805482859306L).getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT.name = "setAttributes" /* "setAttributes" /* "setAttributes" /* cnb.z(-511633684167466L)  */;
        MethodHookWrapper methodHookWrapperVar = (MethodHookWrapper) StaticHelpers6.n(new Object[] { dal.getKClassFromClass(WindowManager.LayoutParams.class) }, 1, methodResolverVarT);
        HookPriorityEnum hookPriorityEnumVar = HookPriorityEnum.ENUM_DEFAULT;
        DisableBrightnessHook anvVar = a;
        HookManager hookManagerVarAd = anvVar.createImmediateHook(methodHookWrapperVar, hookPriorityEnumVar);
        anvVar.y(hookManagerVarAd, new amb(4));
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
