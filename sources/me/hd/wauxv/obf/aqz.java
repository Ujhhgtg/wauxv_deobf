package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class aqz extends SwitchHook implements IHandlesHookParam {
    public static final aqz a = new aqz("Edge2EdgeMainFrostedTabBar" /* cnb.z(-622332171254570L) */);
    public static final String b = "测试-配置修复-v63-edge2edge" /* cnb.z(-624183302159146L) */;
    public static final String c = "Edge2Edge-首页-TabBar" /* cnb.z(-624140352486186L) */;

    @Override // me.hd.wauxv.obf.IHandlesHookParam
    public final void handleHookParam(HookParam hookParam, String str) {
        if (getIsEnabled() && str.equals("RepairerConfig_Edge2Edge_LauncherUI_FrostedTabBar_Int" /*
                                                                                                  * cnb.z(-
                                                                                                  * 622783142820650L)
                                                                                                  */)) {
            hookParam.setResult(1);
        }
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getName() {
        return c;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getCategory() {
        return b;
    }
}
