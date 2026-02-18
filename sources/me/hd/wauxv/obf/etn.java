package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class etn extends SwitchHook implements IHandlesHookParam {
    public static final etn a = new etn("VoiceInputForward" /* cnb.z(-629865543891754L) */);
    public static final String b = "测试-配置修复-v62-chatting" /* cnb.z(-629075269909290L) */;
    public static final String c = "转发输入栏支持语音输入" /* cnb.z(-629019435334442L) */;

    @Override // me.hd.wauxv.obf.IHandlesHookParam
    public final void handleHookParam(HookParam hookParam, String str) {
        if (getIsEnabled() && str.equals("RepairerConfig_VoiceInput_Forward_Int" /* cnb.z(-629805414349610L) */)) {
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
