package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class cxm extends SwitchHook implements IHandlesHookParam {
    public static final cxm a = new cxm("QuoteSupportImg" /* cnb.z(-625312878557994L) */);
    public static final String b = "测试-配置修复-v60-msgSend" /* cnb.z(-625592051432234L) */;
    public static final String c = "引用支持图片消息发送" /* cnb.z(-625540511824682L) */;

    @Override // me.hd.wauxv.obf.IHandlesHookParam
    public final void handleHookParam(HookParam hookParam, String str) {
        if (getIsEnabled() && str.equals("RepairerConfig_QuoteSupportImg_Int" /* cnb.z(-625244159081258L) */)) {
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
