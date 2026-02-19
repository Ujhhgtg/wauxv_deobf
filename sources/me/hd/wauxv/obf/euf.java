package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class euf extends SwitchHook implements IHandlesHookParam {
    public static final euf a = new euf("WebviewSaveScreenshotSide" /* "WebviewSaveScreenshotSide" /* "WebviewSaveScreenshotSide" /* cnb.z(-601364140915498L)  */);
    public static final String b = "测试-配置修复-v51-webview" /* "测试-配置修复-v51-webview" /* "测试-配置修复-v51-webview" /* cnb.z(-600539507194666L)  */;
    public static final String c = "打开WebView长截图侧边入口" /* "打开WebView长截图侧边入口" /* "打开WebView长截图侧边入口" /* cnb.z(-600419248110378L)  */;

    @Override // me.hd.wauxv.obf.IHandlesHookParam
    public final void handleHookParam(HookParam hookParam, String str) {
        if (getIsEnabled() && str.equals("RepairerConfig_SaveScreenshotSide_Int" /* "RepairerConfig_SaveScreenshotSide_Int" /* "RepairerConfig_SaveScreenshotSide_Int" /* cnb.z(-601200932158250L)  */)) {
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
