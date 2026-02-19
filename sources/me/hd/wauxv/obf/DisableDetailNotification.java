package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class DisableDetailNotification extends SwitchHook implements IHandlesHookParam {
    public static final DisableDetailNotification a = new DisableDetailNotification("DisableDetailNotification" /*
                                                                                                                 * cnb.z
                                                                                                                 * (-
                                                                                                                 * 627198369200938L)
                                                                                                                 */);
    public static final String b = "测试-配置修复-v58-notification" /* "测试-配置修复-v58-notification" /* "测试-配置修复-v58-notification" /* cnb.z(-628534104029994L)  */;
    public static final String c = "通知关闭详情@我提示优化" /* "通知关闭详情@我提示优化" /* "通知关闭详情@我提示优化" /* cnb.z(-628426729847594L)  */;

    @Override // me.hd.wauxv.obf.IHandlesHookParam
    public final void handleHookParam(HookParam hookParam, String str) {
        if (getIsEnabled() && str.equals("RepairerConfig_NOTIFICATION_AT_ME_TIPS_Int" /* "RepairerConfig_NOTIFICATION_AT_ME_TIPS_Int" /* "RepairerConfig_NOTIFICATION_AT_ME_TIPS_Int" /* cnb.z(-627035160443690L)  */)) {
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
