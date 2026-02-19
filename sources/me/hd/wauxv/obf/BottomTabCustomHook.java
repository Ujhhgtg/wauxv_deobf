package me.hd.wauxv.obf;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class BottomTabCustomHook extends SwitchHook {
    public static final BottomTabCustomHook INSTANCE;
    public static final String b;
    public static final Kotlin$Lazy c;
    public static final Kotlin$Lazy d;
    public static final Kotlin$Lazy h;
    public static final Kotlin$Lazy i;
    public static final Kotlin$Lazy j;
    public static final String l;
    public static final String m;
    public static final String n;
    public static final SomeHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg r;
    public static final boolean s;

    static {
        "微信" /* "微信" /* "微信" /* cnb.z(-439323614772010L) */;
        "通讯" /* "通讯" /* "通讯" /* cnb.z(-439259190262570L)  */;
        "发现" /* "发现" /* "发现" /* cnb.z(-439280665099050L)  */;
        "我的" /* "我的" /* "我的" /* cnb.z(-439284960066346L)  */;
        INSTANCE = new BottomTabCustomHook("BottomTabCustomHook" /* "BottomTabCustomHook" /* "BottomTabCustomHook" /* cnb.z(-438546225691434L)  */);
        Kotlin$Lazy kotlin$LazyVar = PathUtils.externalStorageRoot;
        b = PathUtils.getModuleSubDir("Resource" /* "Resource" /* "Resource" /* cnb.z(-46621869996842L)  */, "BottomTab" /* "BottomTab" /* "BottomTab" /* cnb.z(-46531675683626L)  */);
        c = new Kotlin$Lazy(new h(8));
        d = new Kotlin$Lazy(new h(9));
        h = new Kotlin$Lazy(new h(10));
        i = new Kotlin$Lazy(new h(11));
        j = new Kotlin$Lazy(new h(12));
        l = "美化" /* "美化" /* "美化" /* cnb.z(-439787471239978L)  */;
        m = "底栏自定义" /* "底栏自定义" /* "底栏自定义" /* cnb.z(-439791766207274L)  */;
        n = "替换主页底部标签栏相关资源为自定义" /* "替换主页底部标签栏相关资源为自定义" /* "替换主页底部标签栏相关资源为自定义" /* cnb.z(-439748816534314L)  */;
        r = new SomeHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(11);
        s = true;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        adt adtVarM = dqc.bh(ajn.tryGetClassByClassName("com.tencent.mm.ui.LauncherUIBottomTabView")).m();
        adtVarM.setParams(dal.getKClassFromClass(Context.class));
        ConstructorHookWrapper constructorHookWrapperVar = (ConstructorHookWrapper) StaticHelpers5.safeGetFirstInList(adtVarM.a());
        HookPriorityEnum hookPriorityEnumVar = HookPriorityEnum.ENUM_DEFAULT;
        BottomTabCustomHook bottomTabCustomHookVar = INSTANCE;
        HookManager hookManagerVarAd = bottomTabCustomHookVar.createImmediateHook(constructorHookWrapperVar, hookPriorityEnumVar);
        bottomTabCustomHookVar.hookAfter(hookManagerVarAd, new SomeHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(12));
        hookManagerVarAd.initInstantCollectionAndApplyHooks();
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getName() {
        return m;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getCategory() {
        return l;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return n;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final IInvokable getOnClick() {
        return r;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final boolean q() {
        return s;
    }
}
