package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class eth extends SwitchHook implements IHandlesHookParam {
    public static final eth a = new eth("Voice2TxtLLM" /* "Voice2TxtLLM" /* "Voice2TxtLLM" /* "Voice2TxtLLM" /* cnb.z(-624591324052266L)   */);
    public static final String b = "测试-配置修复-v61-chatting" /* "测试-配置修复-v61-chatting" /* "测试-配置修复-v61-chatting" /* "测试-配置修复-v61-chatting" /* cnb.z(-624913446599466L)   */;
    public static final String c = "上滑语音转文字，支持llm整理文字" /* "上滑语音转文字，支持llm整理文字" /* "上滑语音转文字，支持llm整理文字" /* "上滑语音转文字，支持llm整理文字" /* cnb.z(-624806072417066L)   */;

    @Override // me.hd.wauxv.obf.IHandlesHookParam
    public final void handleHookParam(HookParam hookParam, String str) {
        if (getIsEnabled() && str.equals("RepairerConfig_Voice2TxtLLM_Int" /* "RepairerConfig_Voice2TxtLLM_Int" /* "RepairerConfig_Voice2TxtLLM_Int" /* "RepairerConfig_Voice2TxtLLM_Int" /* cnb.z(-625050885552938L)   */)) {
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
