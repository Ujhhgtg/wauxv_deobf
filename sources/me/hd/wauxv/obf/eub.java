package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class eub extends doo implements bny {
    public static final eub a = new eub("WebViewNewFloatBall" /* cnb.z(-631269998197546L) */);
    public static final String b = "测试-配置修复-61-webview" /* cnb.z(-631600710679338L) */;
    public static final String c = "是否新版网页浮窗" /* cnb.z(-631467566693162L) */;

    @Override // me.hd.wauxv.obf.bny
    public final void d(bmm bmmVar, String str) {
        if (z() && str.equals("RepairerConfig_WebViewNewFloatBall_Int" /* cnb.z(-631218458589994L) */)) {
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
