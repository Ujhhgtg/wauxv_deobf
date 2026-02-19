package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class cro extends SwitchHook implements IHandlesHookParam {
    public static final cro a = new cro("OpenWayEnhanceImage" /* "OpenWayEnhanceImage" /* "OpenWayEnhanceImage" /* cnb.z(-618449520818986L)  */);
    public static final String b = "测试-配置修复-v62-openWay" /* "测试-配置修复-v62-openWay" /* "测试-配置修复-v62-openWay" /* cnb.z(-618213297617706L)  */;
    public static final String c = "图片菜单加入打开方式" /* "图片菜单加入打开方式" /* "图片菜单加入打开方式" /* cnb.z(-619811025451818L)  */;

    @Override // me.hd.wauxv.obf.IHandlesHookParam
    public final void handleHookParam(HookParam hookParam, String str) {
        if (getIsEnabled() && str.equals("RepairerConfig_OpenWayEnhanceImage_Int" /* "RepairerConfig_OpenWayEnhanceImage_Int" /* "RepairerConfig_OpenWayEnhanceImage_Int" /* cnb.z(-618397981211434L)  */)) {
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
