package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class crr extends BaseHook implements bny {
    public static final crr a = new crr("OpenWayEnhanceWebViewMP" /* cnb.z(-619506082773802L) */);
    public static final String b = "测试-配置修复-v62-openWay" /* cnb.z(-616418001287978L) */;
    public static final String c = "网页(内链)菜单加入打开方式" /* cnb.z(-616366461680426L) */;

    @Override // me.hd.wauxv.obf.bny
    public final void d(HookParamWrapper hookParam, String str) {
        if (z() && str.equals("RepairerConfig_OpenWayEnhanceWebViewMP_Int" /* cnb.z(-619403003558698L) */)) {
            hookParam.setResult(1);
        }
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getName() {
        return c;
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getCategory() {
        return b;
    }
}
