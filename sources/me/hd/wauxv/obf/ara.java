package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class ara extends SwitchHook implements IHandlesHookParam {
    public static final ara a = new ara("Edge2EdgeSNSFrostedActionBar" /* cnb.z(-626395210316586L) */);
    public static final String b = "测试-配置修复-v61-edge2edge" /* cnb.z(-626588483844906L) */;
    public static final String c = "Edge2Edge-朋友圈-ActionBar模糊" /* cnb.z(-626545534171946L) */;

    @Override // me.hd.wauxv.obf.IHandlesHookParam
    public final void handleHookParam(HookParam hookParam, String str) {
        if (getIsEnabled() && str.equals("RepairerConfig_Edge2Edge_SNS_FrostedActionBar_Int" /*
                                                                                              * cnb.z(-626305016003370L)
                                                                                              */)) {
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
