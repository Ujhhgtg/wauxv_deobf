package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class cob extends doo implements bny {
    public static final cob a = new cob("NewSetting" /* cnb.z(-648733335223082L) */);
    public static final String b = "测试-配置修复-v66-global" /* cnb.z(-649124177247018L) */;
    public static final String c = "新设置页开关" /* cnb.z(-648991033260842L) */;
    public static final String h = "模块入口暂未适配 目前暂不推荐开启" /* cnb.z(-650610235931434L) */;

    @Override // me.hd.wauxv.obf.bny
    public final void d(bmm bmmVar, String str) {
        if (z() && str.equals("RepairerConfig_NewSetting_Int" /* cnb.z(-649201486658346L) */)) {
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

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return h;
    }
}
