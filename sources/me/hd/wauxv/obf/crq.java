package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class crq extends SwitchHook implements IHandlesHookParam {
    public static final crq a = new crq("OpenWayEnhanceWebView" /* "OpenWayEnhanceWebView" /* "OpenWayEnhanceWebView" /* cnb.z(-619909809699626L)  */);
    public static final String b = "测试-配置修复-v62-openWay" /* "测试-配置修复-v62-openWay" /* "测试-配置修复-v62-openWay" /* cnb.z(-619072291076906L)  */;
    public static final String c = "网页(外链)菜单加入打开方式" /* "网页(外链)菜单加入打开方式" /* "网页(外链)菜单加入打开方式" /* cnb.z(-619570507283242L)  */;

    @Override // me.hd.wauxv.obf.IHandlesHookParam
    public final void handleHookParam(HookParam hookParam, String str) {
        if (getIsEnabled() && str.equals("RepairerConfig_OpenWayEnhanceWebView_Int" /* "RepairerConfig_OpenWayEnhanceWebView_Int" /* "RepairerConfig_OpenWayEnhanceWebView_Int" /* cnb.z(-619248384736042L)  */)) {
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
