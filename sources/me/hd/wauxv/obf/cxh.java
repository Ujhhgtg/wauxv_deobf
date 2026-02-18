package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class cxh extends BaseHook implements bny {
    public static final cxh a = new cxh("QuoteJumpOpt" /* cnb.z(-633181258644266L) */);
    public static final String b = "测试-配置修复-v62-chatting" /* cnb.z(-632403869563690L) */;
    public static final String c = "引用优化（更快跳回原文+未发送支持点击引用" /* cnb.z(-632296495381290L) */;

    @Override // me.hd.wauxv.obf.bny
    public final void d(HookParamWrapper hookParam, String str) {
        if (z() && str.equals("RepairerConfig_QuoteJumpOpt_Int" /* cnb.z(-633091064331050L) */)) {
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
