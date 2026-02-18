package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class cyn extends BaseHook implements bny {
    public static final cyn a = new cyn("RecommendDeleteContactTestSwitch" /* cnb.z(-612299127651114L) */);
    public static final String b = "测试-配置修复-v51-global" /* cnb.z(-611418659355434L) */;
    public static final String c = "整理好友需求test开关（方便测试,无一万好友也可触发）" /* cnb.z(-611852451052330L) */;

    @Override // me.hd.wauxv.obf.bny
    public final void d(HookParamWrapper hookParam, String str) {
        if (z() && str.equals("RepairerConfig_RecommendDeleteContactTestSwitch_Int" /* cnb.z(-612157393730346L) */)) {
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
