package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class coa extends SwitchHook implements IHandlesHookParam {
    public static final coa a = new coa("NewSendVoice" /* cnb.z(-644202144725802L) */);
    public static final String b = "测试-配置修复-v65-msgSend" /* cnb.z(-643424755645226L) */;
    public static final String c = "发送语音使用新架构" /* cnb.z(-643373216037674L) */;

    @Override // me.hd.wauxv.obf.IHandlesHookParam
    public final void handleHookParam(HookParam hookParam, String str) {
        if (getIsEnabled() && str.equals("RepairerConfig_NewSendVoice_Int" /* cnb.z(-644111950412586L) */)) {
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
