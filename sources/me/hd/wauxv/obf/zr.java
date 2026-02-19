package me.hd.wauxv.obf;

import android.view.ViewGroup;
import java.util.List;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class zr extends SwitchHook implements bnn {
    public static final zr a = new zr("ClearAllUnReadHook" /* "ClearAllUnReadHook" /* "ClearAllUnReadHook" /* cnb.z(-523535038544682L)  */);
    public static final String b = "菜单" /* "菜单" /* "菜单" /* cnb.z(-525411939253034L)  */;
    public static final String c = "清空未读" /* "清空未读" /* "清空未读" /* cnb.z(-525416234220330L)  */;
    public static final String d = "为主页菜单及消息添加清空未读快捷项" /* "为主页菜单及消息添加清空未读快捷项" /* "为主页菜单及消息添加清空未读快捷项" /* cnb.z(-525377579514666L)  */;
    public static final ws h = new ws(24);
    public static final boolean i = true;

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        int i2 = 0;
        HookManager hookManagerVarAd = createImmediateHook(
                (MethodHookWrapper) StaticHelpers6.n(new Object[] { dal.getKClassFromClass(Integer.TYPE), dal.getKClassFromClass(ViewGroup.class) }, 2,
                        dqc.bh(ajn.tryGetClassByClassName("com.tencent.mm.ui.LauncherUIBottomTabView" /* "com.tencent.mm.ui.LauncherUIBottomTabView" /* "com.tencent.mm.ui.LauncherUIBottomTabView" /* cnb.z(-523419074427690L)  */)).getMethodResolverBasedOnPreviouslyProvidedConfig()),
                HookPriorityEnum.ENUM_DEFAULT);
        a.x(hookManagerVarAd, new ws(25));
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

    @Override // me.hd.wauxv.obf.bnn
    public final List j() {
        return (z() && zp.a.i()) ? dqc.toSingletonList(new bly(R.id.MenuItem_Home_ClearAllUnRead,
                "清空未读" /* "清空未读" /* "清空未读" /* cnb.z(-523805621484330L)  */, R.drawable.ic_menu_clear_24dp, new h(25))) : EmptyReadonlyList.INSTANCE;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return d;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final IInvokable getOnClick() {
        return h;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final boolean q() {
        return i;
    }
}
