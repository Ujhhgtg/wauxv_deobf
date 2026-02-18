package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class ety extends BaseHook implements bny {
    public static final ety a = new ety("VoiceTransformScrollOpt" /* cnb.z(-627894153902890L) */);
    public static final String b = "测试-配置修复-v60-chatting" /* cnb.z(-628190506646314L) */;
    public static final String c = "文字转语音 - 滚动优化" /* cnb.z(-625317173525290L) */;

    @Override // me.hd.wauxv.obf.bny
    public final void d(HookParamWrapper hookParam, String str) {
        if (z() && str.equals("RepairerConfig_VoiceTransformScrollOpt_Int" /* cnb.z(-628340830501674L) */)) {
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
