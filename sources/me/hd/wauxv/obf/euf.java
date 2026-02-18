package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class euf extends doo implements bny {
    public static final euf a = new euf("WebviewSaveScreenshotSide" /* cnb.z(-601364140915498L) */);
    public static final String b = "测试-配置修复-v51-webview" /* cnb.z(-600539507194666L) */;
    public static final String c = "打开WebView长截图侧边入口" /* cnb.z(-600419248110378L) */;

    @Override // me.hd.wauxv.obf.bny
    public final void d(bmm bmmVar, String str) {
        if (z() && str.equals("RepairerConfig_SaveScreenshotSide_Int" /* cnb.z(-601200932158250L) */)) {
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
