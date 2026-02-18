package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class cxo extends SwitchHook implements IHandlesHookParam {
    public static final cxo a = new cxo("QuoteSupportVideo" /* cnb.z(-625458907446058L) */);
    public static final String b = "测试-配置修复-v60-msgSend" /* cnb.z(-624724468038442L) */;
    public static final String c = "引用支持视频消息发送" /* cnb.z(-624604208954154L) */;

    @Override // me.hd.wauxv.obf.IHandlesHookParam
    public final void handleHookParam(HookParam hookParam, String str) {
        if (getIsEnabled() && str.equals("RepairerConfig_QuoteSupportVideo_Int" /* cnb.z(-625398777903914L) */)) {
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
