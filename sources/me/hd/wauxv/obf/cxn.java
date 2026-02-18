package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class cxn extends SwitchHook implements IHandlesHookParam {
    public static final cxn a = new cxn("QuoteSupportPartial" /* cnb.z(-632189121198890L) */);
    public static final String b = "测试-配置修复-v61-msgSend" /* cnb.z(-631970077866794L) */;
    public static final String c = "文本消息支持局部引用" /* cnb.z(-631300062968618L) */;

    @Override // me.hd.wauxv.obf.IHandlesHookParam
    public final void handleHookParam(HookParam hookParam, String str) {
        if (getIsEnabled() && str.equals("RepairerConfig_QuoteSupportPartial_Int" /* cnb.z(-632137581591338L) */)) {
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
