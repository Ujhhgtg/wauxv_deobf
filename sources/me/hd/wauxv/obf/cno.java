package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class cno extends BaseHook implements bny {
    public static final cno a = new cno("NewScreenShotUtil" /* cnb.z(-624273496472362L) */);
    public static final String b = "测试-配置修复-v63-screenshot" /* cnb.z(-623470337588010L) */;
    public static final String c = "「截图组件」 - 使用重构" /* cnb.z(-623921309154090L) */;

    @Override // me.hd.wauxv.obf.bny
    public final void d(HookParamWrapper hookParam, String str) {
        if (z() && str.equals("RepairerConfig_NewScreenShotUtil_Int" /* cnb.z(-623663611116330L) */)) {
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
