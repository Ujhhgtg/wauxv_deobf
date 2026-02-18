package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class eue extends SwitchHook implements IHandlesHookParam {
    public static final eue a = new eue("WebviewSaveScreenshot" /* cnb.z(-612724329413418L) */);
    public static final String b = "测试-配置修复-v51-webview" /* cnb.z(-600938939153194L) */;
    public static final String c = "打开WebView长截图" /* cnb.z(-601368435882794L) */;

    @Override // me.hd.wauxv.obf.IHandlesHookParam
    public final void handleHookParam(HookParam hookParam, String str) {
        if (getIsEnabled() && str.equals("RepairerConfig_SaveScreenshot_Int" /* cnb.z(-601067788172074L) */)) {
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
