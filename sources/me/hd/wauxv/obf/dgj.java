package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class dgj extends doo implements bny {
    public static final dgj a = new dgj("SettingSearch" /* cnb.z(-650550106389290L) */);
    public static final String b = "测试-配置修复-v66-global" /* cnb.z(-650880818871082L) */;
    public static final String c = "新设置页面搜索开关" /* cnb.z(-650833574230826L) */;

    @Override // me.hd.wauxv.obf.bny
    public final void d(bmm bmmVar, String str) {
        if (z() && str.equals("RepairerConfig_SettingSearch_Int" /* cnb.z(-650472796977962L) */)) {
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
