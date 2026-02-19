package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class CustomContactCountHook extends SwitchHook {
    public static final CustomContactCountHook a = new CustomContactCountHook("CustomContactCountHook" /*
                                                                                                        * cnb.z(-
                                                                                                        * 429140247313194L)
                                                                                                        */);
    public static final String b = "美化" /* "美化" /* "美化" /* "美化" /* cnb.z(-430450212338474L)   */;
    public static final String c = "自定义数量" /* "自定义数量" /* "自定义数量" /* "自定义数量" /* cnb.z(-430454507305770L)   */;
    public static final String d = "自定义好友和群聊列表底部的显示数量" /* "自定义好友和群聊列表底部的显示数量" /* "自定义好友和群聊列表底部的显示数量" /* "自定义好友和群聊列表底部的显示数量" /* cnb.z(-430411557632810L)   */;
    public static final age h = new age(24);

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        int i = 0;
        MethodResolver methodResolverVarT = yg.s(-430690730507050L).getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT.name = "onMeasure" /* "onMeasure" /* "onMeasure" /* "onMeasure" /* cnb.z(-430523226782506L)   */;
        MethodHookWrapper methodHookWrapperVar = (MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT.findMethods());
        HookPriorityEnum hookPriorityEnumVar = HookPriorityEnum.ENUM_DEFAULT;
        CustomContactCountHook airVar = a;
        HookManager hookManagerVarAd = airVar.createImmediateHook(methodHookWrapperVar, hookPriorityEnumVar);
        airVar.hookBefore(hookManagerVarAd, new age(25));
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
