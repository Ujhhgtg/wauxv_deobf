package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class anw extends doo implements bny {
    public static final anw a = new anw("DisableDetailNotification" /* cnb.z(-627198369200938L) */);
    public static final String b = "测试-配置修复-v58-notification" /* cnb.z(-628534104029994L) */;
    public static final String c = "通知关闭详情@我提示优化" /* cnb.z(-628426729847594L) */;

    @Override // me.hd.wauxv.obf.bny
    public final void d(bmm bmmVar, String str) {
        if (z() && str.equals("RepairerConfig_NOTIFICATION_AT_ME_TIPS_Int" /* cnb.z(-627035160443690L) */)) {
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
