package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class cnq extends SwitchHook implements IHandlesHookParam {
    public static final cnq a = new cnq("NewSendImg" /* "NewSendImg" /* "NewSendImg" /* cnb.z(-602321918622506L)  */);
    public static final String b = "测试-配置修复-v54-msgSend" /* "测试-配置修复-v54-msgSend" /* "测试-配置修复-v54-msgSend" /* cnb.z(-601544529541930L)  */;
    public static final String c = "发送图片使用新架构" /* "发送图片使用新架构" /* "发送图片使用新架构" /* cnb.z(-601492989934378L)  */;

    @Override // me.hd.wauxv.obf.IHandlesHookParam
    public final void handleHookParam(HookParam hookParam, String str) {
        if (getIsEnabled() && str.equals("RepairerConfig_NewSendImg_Int" /* "RepairerConfig_NewSendImg_Int" /* "RepairerConfig_NewSendImg_Int" /* cnb.z(-601690558429994L)  */)) {
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
