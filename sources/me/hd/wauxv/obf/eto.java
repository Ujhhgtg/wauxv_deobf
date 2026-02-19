package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class eto extends SwitchHook implements IHandlesHookParam {
    public static final eto a = new eto("VoiceInputGuide" /* "VoiceInputGuide" /* "VoiceInputGuide" /* cnb.z(-628933535988522L)  */);
    public static final String b = "测试-配置修复-v62-chatting" /* "测试-配置修复-v62-chatting" /* "测试-配置修复-v62-chatting" /* cnb.z(-629294313241386L)  */;
    public static final String c = "聊天输入栏语音输入新手引导" /* "聊天输入栏语音输入新手引导" /* "聊天输入栏语音输入新手引导" /* cnb.z(-630836206500650L)  */;

    @Override // me.hd.wauxv.obf.IHandlesHookParam
    public final void handleHookParam(HookParam hookParam, String str) {
        if (getIsEnabled() && str.equals("RepairerConfig_VoiceInput_Guide_Int" /* "RepairerConfig_VoiceInput_Guide_Int" /* "RepairerConfig_VoiceInput_Guide_Int" /* cnb.z(-629414572325674L)  */)) {
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
