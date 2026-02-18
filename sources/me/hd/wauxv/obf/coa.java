package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class coa extends BaseHook implements bny {
    public static final coa a = new coa("NewSendVoice" /* cnb.z(-644202144725802L) */);
    public static final String b = "测试-配置修复-v65-msgSend" /* cnb.z(-643424755645226L) */;
    public static final String c = "发送语音使用新架构" /* cnb.z(-643373216037674L) */;

    @Override // me.hd.wauxv.obf.bny
    public final void d(HookParamWrapper hookParam, String str) {
        if (z() && str.equals("RepairerConfig_NewSendVoice_Int" /* cnb.z(-644111950412586L) */)) {
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
