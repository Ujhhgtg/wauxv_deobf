package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class xs extends SwitchHook implements IHandlesHookParam {
    public static final xs a = new xs("ChattingConvBoxGuide" /* "ChattingConvBoxGuide" /* "ChattingConvBoxGuide" /* "ChattingConvBoxGuide" /* cnb.z(-601467220130602L)   */);
    public static final String b = "测试-配置修复-v55-chatting" /* "测试-配置修复-v55-chatting" /* "测试-配置修复-v55-chatting" /* "测试-配置修复-v55-chatting" /* cnb.z(-601716328233770L)   */;
    public static final String c = "强制显示聊天折叠引导" /* "强制显示聊天折叠引导" /* "强制显示聊天折叠引导" /* "强制显示聊天折叠引导" /* cnb.z(-598911714589482L)   */;

    @Override // me.hd.wauxv.obf.IHandlesHookParam
    public final void handleHookParam(HookParam hookParam, String str) {
        if (getIsEnabled() && str.equals("RepairerConfig_ForceConvBoxGuide_Int" /* "RepairerConfig_ForceConvBoxGuide_Int" /* "RepairerConfig_ForceConvBoxGuide_Int" /* "RepairerConfig_ForceConvBoxGuide_Int" /* cnb.z(-601892421892906L)   */)) {
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
