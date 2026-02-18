package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class cov extends doo implements bny {
    public static final cov a = new cov("NotificationHalfScreenChat" /* cnb.z(-604555301616426L) */);
    public static final String b = "测试-配置修复-v58-global" /* cnb.z(-603640473582378L) */;
    public static final String c = "微信内消息通知半屏" /* cnb.z(-604125804886826L) */;

    @Override // me.hd.wauxv.obf.bny
    public final void d(bmm bmmVar, String str) {
        if (z() && str.equals("RepairerConfig_NotificationHalfScreenChat_Int" /* cnb.z(-603855221947178L) */)) {
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
