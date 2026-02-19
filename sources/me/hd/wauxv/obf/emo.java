package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class emo extends SwitchHook implements IHandlesHookParam {
    public static final emo a = new emo("TypingSend" /* "TypingSend" /* "TypingSend" /* "TypingSend" /* cnb.z(-603481559792426L)   */);
    public static final String b = "测试-配置修复-v58-chatting" /* "测试-配置修复-v58-chatting" /* "测试-配置修复-v58-chatting" /* "测试-配置修复-v58-chatting" /* cnb.z(-602772890188586L)   */;
    public static final String c = "对方正在输入..接入新协议" /* "对方正在输入..接入新协议" /* "对方正在输入..接入新协议" /* "对方正在输入..接入新协议" /* cnb.z(-602648336137002L)   */;

    @Override // me.hd.wauxv.obf.IHandlesHookParam
    public final void handleHookParam(HookParam hookParam, String str) {
        if (getIsEnabled() && str.equals("RepairerConfig_TypingSend_Int" /* "RepairerConfig_TypingSend_Int" /* "RepairerConfig_TypingSend_Int" /* "RepairerConfig_TypingSend_Int" /* cnb.z(-603399955413802L)   */)) {
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
