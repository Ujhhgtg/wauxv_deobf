package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dhh extends SwitchHook {
    public static final dhh a;
    public static final String b;
    public static final String c;
    public static final String h;

    static {
        "WAuxiliary_chatroom_info_pref" /* "WAuxiliary_chatroom_info_pref" /* "WAuxiliary_chatroom_info_pref" /* "WAuxiliary_chatroom_info_pref" /* cnb.z(-594247380106026L)   */;
        a = new dhh("ShowChatroomInfoHook" /* "ShowChatroomInfoHook" /* "ShowChatroomInfoHook" /* "ShowChatroomInfoHook" /* cnb.z(-597331166624554L)   */);
        b = "界面" /* "界面" /* "界面" /* "界面" /* cnb.z(-594101351217962L)   */;
        c = "显示群聊详情" /* "显示群聊详情" /* "显示群聊详情" /* "显示群聊详情" /* cnb.z(-594054106577706L)   */;
        h = "在对应的群聊界面中显示 群聊详情ID" /* "在对应的群聊界面中显示 群聊详情ID" /* "在对应的群聊界面中显示 群聊详情ID" /* "在对应的群聊界面中显示 群聊详情ID" /* cnb.z(-594075581414186L)   */;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        int i = 0;
        SyntheticPileOfMess bmuVarS = yg.s(-594475013372714L);
        MethodResolver methodResolverVarT = bmuVarS.getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT.name = "initView" /* "initView" /* "initView" /* "initView" /* cnb.z(-594311804615466L)   */;
        MethodHookWrapper methodHookWrapperVar = (MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT.findMethods());
        dhh dhhVar = a;
        HookPriorityEnum hookPriorityEnumVar = HookPriorityEnum.ENUM_DEFAULT;
        HookManager hookManagerVarAd = dhhVar.createImmediateHook(methodHookWrapperVar, hookPriorityEnumVar);
        dhhVar.x(hookManagerVarAd, new dhg(0));
        hookManagerVarAd.initInstantCollectionAndApplyHooks();
        MethodResolver methodResolverVarT2 = bmuVarS.getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT2.name = "onPreferenceTreeClick" /* "onPreferenceTreeClick" /* "onPreferenceTreeClick" /* "onPreferenceTreeClick" /* cnb.z(-594822905723690L)   */;
        HookManager hookManagerVarAd2 = dhhVar.createImmediateHook((MethodHookWrapper) StaticHelpers6.n(new Object[] { eoz.a, cvh.a.b() }, 2, methodResolverVarT2), hookPriorityEnumVar);
        dhhVar.y(hookManagerVarAd2, new dhg(1));
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
        return h;
    }
}
