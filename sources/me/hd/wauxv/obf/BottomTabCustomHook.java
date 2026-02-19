package me.hd.wauxv.obf;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class BottomTabCustomHook extends SwitchHook {
    public static final BottomTabCustomHook INSTANCE;
    public static final String b;
    public static final dov c;
    public static final dov d;
    public static final dov h;
    public static final dov i;
    public static final dov j;
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
        dov dovVar = ctf.a;
        b = ctf.c("Resource" /* "Resource" /* "Resource" /* cnb.z(-46621869996842L)  */, "BottomTab" /* "BottomTab" /* "BottomTab" /* cnb.z(-46531675683626L)  */);
        c = new dov(new h(8));
        d = new dov(new h(9));
        h = new dov(new h(10));
        i = new dov(new h(11));
        j = new dov(new h(12));
        l = "美化" /* "美化" /* "美化" /* cnb.z(-439787471239978L)  */;
        m = "底栏自定义" /* "底栏自定义" /* "底栏自定义" /* cnb.z(-439791766207274L)  */;
        n = "替换主页底部标签栏相关资源为自定义" /* "替换主页底部标签栏相关资源为自定义" /* "替换主页底部标签栏相关资源为自定义" /* cnb.z(-439748816534314L)  */;
        r = new SomeHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(11);
        s = true;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        adt adtVarM = dqc.bh(ajn.tryGetClassByClassName("com.tencent.mm.ui.LauncherUIBottomTabView")).m();
        adtVarM.z(dal.b(Context.class));
        ConstructorHookWrapper constructorHookWrapperVar = (ConstructorHookWrapper) aaz.e(adtVarM.a());
        exg exgVar = exg.a;
        BottomTabCustomHook bottomTabCustomHookVar = INSTANCE;
        aki akiVarAd = bottomTabCustomHookVar.ad(constructorHookWrapperVar, exgVar);
        bottomTabCustomHookVar.x(akiVarAd, new SomeHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(12));
        akiVarAd.o();
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
