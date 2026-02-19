package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class dez extends SwitchHook implements IHandlesHookParam {
    public static final dez a = new dez("ScreenShotShareService" /* "ScreenShotShareService" /* "ScreenShotShareService" /* cnb.z(-623843999742762L)  */);
    public static final String b = "测试-配置修复-v63-screenshot" /* "测试-配置修复-v63-screenshot" /* "测试-配置修复-v63-screenshot" /* cnb.z(-620816047799082L)  */;
    public static final String c = "「截图转发」 - 入口显示" /* "「截图转发」 - 入口显示" /* "「截图转发」 - 入口显示" /* cnb.z(-620717263551274L)  */;

    @Override // me.hd.wauxv.obf.IHandlesHookParam
    public final void handleHookParam(HookParam hookParam, String str) {
        if (getIsEnabled() && str.equals("RepairerConfig_ScreenShotShareService_Int" /* "RepairerConfig_ScreenShotShareService_Int" /* "RepairerConfig_ScreenShotShareService_Int" /* cnb.z(-623796755102506L)  */)) {
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
