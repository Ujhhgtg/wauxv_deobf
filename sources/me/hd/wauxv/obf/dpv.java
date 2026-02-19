package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dpv extends bws {
    public static final dpv a = new dpv();
    public static String b = "" /* "" /* "" /* cnb.z(-115736483724074L)  */;

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        int i = 0;
        MethodResolver methodResolverVarT = dqc.bh(ajn.tryGetClassByClassName("com.tencent.mm.pluginsdk.ui.chat.ChatFooter" /* "com.tencent.mm.pluginsdk.ui.chat.ChatFooter" /* "com.tencent.mm.pluginsdk.ui.chat.ChatFooter" /* cnb.z(-115977001892650L)  */)).getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT.name = "setUserName" /* "setUserName" /* "setUserName" /* cnb.z(-115822383069994L)  */;
        aki akiVarAd = ad((MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT.findMethods()), HookPriorityEnum.ENUM_DEFAULT);
        akiVarAd.n(new dos(3));
        akiVarAd.o();
    }
}
