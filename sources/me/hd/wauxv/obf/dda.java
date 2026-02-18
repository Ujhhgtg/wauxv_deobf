package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class dda extends SwitchHook implements IHandlesHookParam {
    public static final dda a = new dda("RevokeMsgUseNewXmlAndFold" /* cnb.z(-650090544888618L) */);
    public static final String b = "测试-配置修复-v66-msgSend" /* cnb.z(-647586578955050L) */;
    public static final String c = "是否支持撤回消息折叠功能(并使用newXml)" /* cnb.z(-647535039347498L) */;

    @Override // me.hd.wauxv.obf.IHandlesHookParam
    public final void handleHookParam(HookParam hookParam, String str) {
        if (getIsEnabled()
                && str.equals("RepairerConfig_RevokeMsgUseNewXmlAndFold_Int" /* cnb.z(-647247276538666L) */)) {
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
