package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class csa extends BaseHook implements bod {
    public static final csa a = new csa("OtherSearchMethodsVisible" /* cnb.z(-646980988566314L) */);
    public static final String b = "测试-配置同步-userinfo" /* cnb.z(-648265183787818L) */;
    public static final String c = "添加我的方式-其他" /* cnb.z(-648192169343786L) */;

    @Override // me.hd.wauxv.obf.bod
    public final void d(HookParamWrapper hookParam, String str) {
        if (z() && str.equals("USERINFO_OTHER_SEARCH_METHODS_VISIBLE_CLIENT_GRAY_BOOLEAN_SYNC" /*
                                                                                                * cnb.z(-
                                                                                                * 646886499285802L)
                                                                                                */)) {
            hookParam.setResult(Boolean.TRUE);
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
