package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class cwt extends BaseHook implements bny {
    public static final cwt a = new cwt("QQAssistant" /* cnb.z(-606823044348714L) */);
    public static final String b = "测试-配置修复-v57-global" /* cnb.z(-606054245202730L) */;
    public static final String c = "QQ消息提醒插件" /* cnb.z(-605989820693290L) */;

    @Override // me.hd.wauxv.obf.bny
    public final void d(HookParamWrapper hookParam, String str) {
        if (z() && str.equals("RepairerConfig_QQAssistant_Int" /* cnb.z(-606737145002794L) */)) {
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
