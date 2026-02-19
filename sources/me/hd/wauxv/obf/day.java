package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class day extends SwitchHook {
    public static final day a = new day("RemoveStatusInputLimitHook" /* "RemoveStatusInputLimitHook" /* "RemoveStatusInputLimitHook" /* cnb.z(-498688652737322L)  */);
    public static final String b = "限制" /* "限制" /* "限制" /* cnb.z(-498319285549866L)  */;
    public static final String c = "移除状态限制" /* "移除状态限制" /* "移除状态限制" /* cnb.z(-498254861040426L)  */;
    public static final String h = "移除个人状态词最多输入10长度的限制" /* "移除个人状态词最多输入10长度的限制" /* "移除个人状态词最多输入10长度的限制" /* cnb.z(-498224796269354L)  */;

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        int i = 0;
        adt adtVarM = yg.s(-499139624303402L).m();
        adtVarM.y();
        ConstructorHookWrapper constructorHookWrapperVar = (ConstructorHookWrapper) StaticHelpers5.safeGetFirstInList(adtVarM.a());
        HookPriorityEnum hookPriorityEnumVar = HookPriorityEnum.ENUM_DEFAULT;
        day dayVar = a;
        HookManager hookManagerVarAd = dayVar.createImmediateHook(constructorHookWrapperVar, hookPriorityEnumVar);
        dayVar.hookAfter(hookManagerVarAd, new cvc(26));
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
