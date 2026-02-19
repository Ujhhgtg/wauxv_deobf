package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class CustomBalanceHook extends SwitchHook {
    public static final CustomBalanceHook a = new CustomBalanceHook("CustomBalanceHook" /* "CustomBalanceHook" /* "CustomBalanceHook" /* cnb.z(-429612693715754L)  */);
    public static final String b = "美化" /* "美化" /* "美化" /* cnb.z(-429045758032682L)  */;
    public static final String c = "自定义余额" /* "自定义余额" /* "自定义余额" /* cnb.z(-428998513392426L)  */;
    public static final String d = "可动态替换真实余额为指定的金额数值" /* "可动态替换真实余额为指定的金额数值" /* "可动态替换真实余额为指定的金额数值" /* cnb.z(-428955563719466L)  */;
    public static final age h = new age(21);

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        int i = 0;
        MethodResolver methodResolverVarT = yg.s(-429552564173610L).getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT.d = new age(22);
        MethodHookWrapper methodHookWrapperVar = (MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT.findMethods());
        HookPriorityEnum hookPriorityEnumVar = HookPriorityEnum.ENUM_DEFAULT;
        CustomBalanceHook aioVar = a;
        HookManager hookManagerVarAd = aioVar.createImmediateHook(methodHookWrapperVar, hookPriorityEnumVar);
        aioVar.y(hookManagerVarAd, new age(23));
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
    public final IInvokable getOnClick() {
        return h;
    }
}
