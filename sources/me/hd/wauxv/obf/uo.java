package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class uo extends SwitchHook {
    public static final uo a = new uo("ChatFavVoiceForwardHook" /* "ChatFavVoiceForwardHook" /* "ChatFavVoiceForwardHook" /* cnb.z(-477248175995690L)  */);
    public static final String b = "收藏" /* "收藏" /* "收藏" /* cnb.z(-479253925722922L)  */;
    public static final String c = "聊天收藏语音转发" /* "聊天收藏语音转发" /* "聊天收藏语音转发" /* cnb.z(-479275400559402L)  */;
    public static final String d = "在聊天窗口进我的收藏中选择语音发送" /* "在聊天窗口进我的收藏中选择语音发送" /* "在聊天窗口进我的收藏中选择语音发送" /* cnb.z(-479236745853738L)  */;

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        int i = 0;
        MethodResolver methodResolverVarT = yg.s(-477694852594474L).getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT.name = "onItemClick" /* "onItemClick" /* "onItemClick" /* cnb.z(-477518758935338L)  */;
        MethodHookWrapper methodHookWrapperVar = (MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT.findMethods());
        HookPriorityEnum hookPriorityEnumVar = HookPriorityEnum.ENUM_DEFAULT;
        uo uoVar = a;
        HookManager hookManagerVarAd = uoVar.createImmediateHook(methodHookWrapperVar, hookPriorityEnumVar);
        uoVar.y(hookManagerVarAd, new SomeHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(23));
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
}
