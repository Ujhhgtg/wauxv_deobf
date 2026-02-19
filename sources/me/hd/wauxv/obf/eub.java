package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class eub extends SwitchHook implements IHandlesHookParam {
    public static final eub a = new eub("WebViewNewFloatBall" /* "WebViewNewFloatBall" /* "WebViewNewFloatBall" /* "WebViewNewFloatBall" /* cnb.z(-631269998197546L)   */);
    public static final String b = "测试-配置修复-61-webview" /* "测试-配置修复-61-webview" /* "测试-配置修复-61-webview" /* "测试-配置修复-61-webview" /* cnb.z(-631600710679338L)   */;
    public static final String c = "是否新版网页浮窗" /* "是否新版网页浮窗" /* "是否新版网页浮窗" /* "是否新版网页浮窗" /* cnb.z(-631467566693162L)   */;

    @Override // me.hd.wauxv.obf.IHandlesHookParam
    public final void handleHookParam(HookParam hookParam, String str) {
        if (getIsEnabled() && str.equals("RepairerConfig_WebViewNewFloatBall_Int" /* "RepairerConfig_WebViewNewFloatBall_Int" /* "RepairerConfig_WebViewNewFloatBall_Int" /* "RepairerConfig_WebViewNewFloatBall_Int" /* cnb.z(-631218458589994L)   */)) {
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
