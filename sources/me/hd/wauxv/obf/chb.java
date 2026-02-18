package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class chb extends SwitchHook implements IHandlesHookParam {
    public static final chb a = new chb("MsgOriginVideoSend" /* cnb.z(-604100035083050L) */);
    public static final String b = "测试-配置修复-v58-msgSend" /* cnb.z(-627511901813546L) */;
    public static final String c = "聊天允许发送原视频（过年期间可能关闭）" /* cnb.z(-627391642729258L) */;

    @Override // me.hd.wauxv.obf.IHandlesHookParam
    public final void handleHookParam(HookParam hookParam, String str) {
        if (getIsEnabled() && str.equals("RepairerConfig_MsgOriginVideoSend_Int" /* cnb.z(-603984070966058L) */)) {
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
