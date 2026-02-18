package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class cym extends BaseHook implements bny {
    public static final cym a = new cym("RecommendDeleteContactFeatureSwitch" /* cnb.z(-615069381557034L) */);
    public static final String b = "测试-配置修复-v51-global" /* cnb.z(-611895400725290L) */;
    public static final String c = "整理好友需求功能开关" /* cnb.z(-612380732029738L) */;

    @Override // me.hd.wauxv.obf.bny
    public final void d(HookParamWrapper hookParam, String str) {
        if (z() && str
                .equals("RepairerConfig_RecommendDeleteContactFeatureSwitch_Int" /* cnb.z(-612131623926570L) */)) {
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
