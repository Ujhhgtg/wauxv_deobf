package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class euc extends SwitchHook implements IHandlesHookParam {
    public static final euc a = new euc("WebViewScreenshotUseXWeb" /* cnb.z(-628903471217450L) */);
    public static final String b = "测试-配置修复-v58-webview" /* cnb.z(-628091722398506L) */;
    public static final String c = "是否通过XWeb生成长截图" /* cnb.z(-627971463314218L) */;

    @Override // me.hd.wauxv.obf.IHandlesHookParam
    public final void handleHookParam(HookParam hookParam, String str) {
        if (getIsEnabled()
                && str.equals("RepairerConfig_WebViewScreenshotUseXWeb_Int" /* cnb.z(-628796097035050L) */)) {
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
