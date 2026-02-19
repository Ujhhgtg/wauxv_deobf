package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class eti extends SwitchHook implements IHandlesHookParam {
    public static final eti a = new eti("VoiceBackPlay" /* "VoiceBackPlay" /* "VoiceBackPlay" /* "VoiceBackPlay" /* cnb.z(-598971844131626L)   */);
    public static final String b = "测试-配置修复-v55-chatting" /* "测试-配置修复-v55-chatting" /* "测试-配置修复-v55-chatting" /* "测试-配置修复-v55-chatting" /* cnb.z(-598220224854826L)   */;
    public static final String c = "语音消息背景播放" /* "语音消息背景播放" /* "语音消息背景播放" /* "语音消息背景播放" /* cnb.z(-598164390279978L)   */;

    @Override // me.hd.wauxv.obf.IHandlesHookParam
    public final void handleHookParam(HookParam hookParam, String str) {
        if (getIsEnabled() && str.equals("RepairerConfig_VoiceBackPlay_Int" /* "RepairerConfig_VoiceBackPlay_Int" /* "RepairerConfig_VoiceBackPlay_Int" /* "RepairerConfig_VoiceBackPlay_Int" /* cnb.z(-598344778906410L)   */)) {
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
