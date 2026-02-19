package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class bie extends SwitchHook implements IHandlesHookParam {
    public static final bie a = new bie("GlobalContactInfo" /* "GlobalContactInfo" /* "GlobalContactInfo" /* cnb.z(-614064359209770L)  */);
    public static final String b = "测试-配置修复-old-global" /* "测试-配置修复-old-global" /* "测试-配置修复-old-global" /* cnb.z(-613828136008490L)  */;
    public static final String c = "ContactInfo复制" /* "ContactInfo复制" /* "ContactInfo复制" /* cnb.z(-615412978940714L)  */;

    @Override // me.hd.wauxv.obf.IHandlesHookParam
    public final void handleHookParam(HookParam hookParam, String str) {
        if (getIsEnabled() && str.equals("RepairerConfig_GlobalContactInfo_Int" /* "RepairerConfig_GlobalContactInfo_Int" /* "RepairerConfig_GlobalContactInfo_Int" /* cnb.z(-614004229667626L)  */)) {
            hookParam.setResult(1);
        }
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getName() {
        return c;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getCategory() {
        return b;
    }
}
