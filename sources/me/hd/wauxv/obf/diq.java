package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class diq extends SwitchHook {
    public static final diq a = new diq("SnsBackPreviewSaveHook" /* "SnsBackPreviewSaveHook" /* "SnsBackPreviewSaveHook" /* cnb.z(-541410692430634L)  */);
    public static final String b;
    public static final String c;
    public static final String h;
    public static final String i;
    public static final dhg j;

    static {
        Kotlin$Lazy kotlin$LazyVar = PathUtils.externalStorageRoot;
        b = PathUtils.getModuleSubDir("Download" /* "Download" /* "Download" /* cnb.z(-46304042416938L)  */, "Sns" /* "Sns" /* "Sns" /* cnb.z(-46282567580458L)  */);
        c = "朋友圈" /* "朋友圈" /* "朋友圈" /* cnb.z(-530548720139050L)  */;
        h = "朋友圈封面保存" /* "朋友圈封面保存" /* "朋友圈封面保存" /* cnb.z(-531046936345386L)  */;
        i = "支持长按朋友圈封面保存到本地存储中" /* "支持长按朋友圈封面保存到本地存储中" /* "支持长按朋友圈封面保存到本地存储中" /* cnb.z(-531012576607018L)  */;
        j = new dhg(10);
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        for (String str : OtherStaticHelpers.argsToList(
                "com.tencent.mm.plugin.sns.cover.preview.SnsImageBackPreview" /* "com.tencent.mm.plugin.sns.cover.preview.SnsImageBackPreview" /* "com.tencent.mm.plugin.sns.cover.preview.SnsImageBackPreview" /* cnb.z(-541311908182826L)  */,
                "com.tencent.mm.plugin.sns.cover.preview.SnsVideoBackPreview" /* "com.tencent.mm.plugin.sns.cover.preview.SnsVideoBackPreview" /* "com.tencent.mm.plugin.sns.cover.preview.SnsVideoBackPreview" /* cnb.z(-542737837325098L)  */,
                "com.tencent.mm.plugin.finder.view.snscover.SnsFinderVideoBackPreview" /* "com.tencent.mm.plugin.finder.view.snscover.SnsFinderVideoBackPreview" /* "com.tencent.mm.plugin.finder.view.snscover.SnsFinderVideoBackPreview" /* cnb.z(-542995535362858L)  */)) {
            int i2 = 0;
            MethodResolver methodResolverVarT = dqc.bh(ajn.tryGetClassByClassName(str)).getMethodResolverBasedOnPreviouslyProvidedConfig();
            methodResolverVarT.name = "loadCover" /* "loadCover" /* "loadCover" /* cnb.z(-542183786543914L)  */;
            MethodHookWrapper methodHookWrapperVar = (MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT.findMethods());
            HookPriorityEnum hookPriorityEnumVar = HookPriorityEnum.ENUM_DEFAULT;
            diq diqVar = a;
            HookManager hookManagerVarAd = diqVar.createImmediateHook(methodHookWrapperVar, hookPriorityEnumVar);
            diqVar.x(hookManagerVarAd, new dhg(11));
            hookManagerVarAd.initInstantCollectionAndApplyHooks();
        }
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getName() {
        return h;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getCategory() {
        return c;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return i;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final IInvokable getOnClick() {
        return j;
    }
}
