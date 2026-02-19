package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class etm extends SwitchHook implements IHandlesHookParam {
    public static final etm a = new etm("VoiceInput" /* "VoiceInput" /* "VoiceInput" /* cnb.z(-629616435788586L)  */);
    public static final String b = "测试-配置修复-v62-chatting" /* "测试-配置修复-v62-chatting" /* "测试-配置修复-v62-chatting" /* cnb.z(-629990097943338L)  */;
    public static final String c = "聊天输入栏支持语音输入" /* "聊天输入栏支持语音输入" /* "聊天输入栏支持语音输入" /* cnb.z(-629951443237674L)  */;

    @Override // me.hd.wauxv.obf.IHandlesHookParam
    public final void handleHookParam(HookParam hookParam, String str) {
        if (getIsEnabled() && str.equals("RepairerConfig_VoiceInput_Int" /* "RepairerConfig_VoiceInput_Int" /* "RepairerConfig_VoiceInput_Int" /* cnb.z(-629586371017514L)  */)) {
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
