package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class eud extends doo implements bny {
    public static final eud a = new eud("WebviewNewScreenshotUI" /* cnb.z(-612625545165610L) */);
    public static final String b = "测试-配置修复-v51-webview" /* cnb.z(-612896128105258L) */;
    public static final String c = "Webview长截图是否使用新裁剪UI" /* cnb.z(-612775869020970L) */;

    @Override // me.hd.wauxv.obf.bny
    public final void d(bmm bmmVar, String str) {
        if (z() && str.equals("RepairerConfig_WebviewNewScreenshotUI_Int" /* cnb.z(-612509581048618L) */)) {
            bmmVar.h(1);
        }
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
    }

    @Override // me.hd.wauxv.obf.doo
    public final String f() {
        return c;
    }

    @Override // me.hd.wauxv.obf.doo
    public final String g() {
        return b;
    }
}
