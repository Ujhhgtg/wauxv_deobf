package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class ya extends BaseHook implements bny {
    public static final ya a = new ya("ChattingMoreMenuShareOpen" /* cnb.z(-630389529901866L) */);
    public static final String b = "测试-配置修复-v62-openWay" /* cnb.z(-618522535263018L) */;
    public static final String c = "消息多选分享至其他应用总开关" /* cnb.z(-619020751469354L) */;

    @Override // me.hd.wauxv.obf.bny
    public final void d(HookParamWrapper hookParam, String str) {
        if (z() && str.equals("RepairerConfig_ChattingMoreMenuShareOpen_Int" /* cnb.z(-618750168529706L) */)) {
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
