package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class cny extends SwitchHook implements IHandlesHookParam {
    public static final cny a = new cny("NewSendRecord" /* cnb.z(-626936376195882L) */);
    public static final String b = "测试-配置修复-v58-msgSend" /* cnb.z(-626786052340522L) */;
    public static final String c = "发送聊天记录使用新架构" /* cnb.z(-627215549070122L) */;

    @Override // me.hd.wauxv.obf.IHandlesHookParam
    public final void handleHookParam(HookParam hookParam, String str) {
        if (getIsEnabled() && str.equals("RepairerConfig_NewSendRecord_Int" /* cnb.z(-626927786261290L) */)) {
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
