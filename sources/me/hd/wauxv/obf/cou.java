package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class cou extends SwitchHook implements IHandlesHookParam {
    public static final cou a = new cou("NotificationDetail" /* cnb.z(-604379207957290L) */);
    public static final String b = "测试-配置修复-v58-global" /* cnb.z(-604684150635306L) */;
    public static final String c = "微信banner三档消息通知" /* cnb.z(-604568186518314L) */;

    @Override // me.hd.wauxv.obf.IHandlesHookParam
    public final void handleHookParam(HookParam hookParam, String str) {
        if (getIsEnabled() && str.equals("RepairerConfig_NotificationDetail_Int" /* cnb.z(-604314783447850L) */)) {
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
