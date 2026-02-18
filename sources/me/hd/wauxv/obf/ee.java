package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class ee extends BaseHook implements bny {
    public static final ee a = new ee("AlbumItemDebugLabel" /* cnb.z(-609017772636970L) */);
    public static final String b = "测试-配置修复-old-albumPicker" /* cnb.z(-608231793621802L) */;
    public static final String c = "相册Item展示Debug标签" /* cnb.z(-608128714406698L) */;

    @Override // me.hd.wauxv.obf.bny
    public final void d(HookParamWrapper hookParam, String str) {
        if (z() && str.equals("RepairerConfig_AlbumItemDebugLabel_Int" /* cnb.z(-608897513552682L) */)) {
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
