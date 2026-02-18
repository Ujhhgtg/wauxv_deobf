package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class sm extends BaseHook implements bny {
    public static final sm a = new sm("C2CLiveImageSend" /* cnb.z(-617156735662890L) */);
    public static final String b = "测试-配置修复-v63-chatting" /* cnb.z(-622920581774122L) */;
    public static final String c = "聊天发送支持Live (by realhe)" /* cnb.z(-623362963405610L) */;

    @Override // me.hd.wauxv.obf.bny
    public final void d(HookParamWrapper hookParam, String str) {
        if (z() && str.equals("RepairerConfig_Chatting_C2C_Live_Send_V3_Int" /* cnb.z(-623148215040810L) */)) {
            hookParam.setResult(1);
        }
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getName() {
        return c;
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getCategory() {
        return b;
    }
}
