package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class eol extends SwitchHook implements IHandlesHookParam {
    public static final eol a = new eol("UseNewDraftNotify" /* "UseNewDraftNotify" /* "UseNewDraftNotify" /* cnb.z(-623315718765354L)  */);
    public static final String b = "测试-配置修复-v63-chatting" /* "测试-配置修复-v63-chatting" /* "测试-配置修复-v63-chatting" /* cnb.z(-622529739750186L)  */;
    public static final String c = "使用新的会话草稿同步逻辑" /* "使用新的会话草稿同步逻辑" /* "使用新的会话草稿同步逻辑" /* cnb.z(-622405185698602L)  */;

    @Override // me.hd.wauxv.obf.IHandlesHookParam
    public final void handleHookParam(HookParam hookParam, String str) {
        if (getIsEnabled() && str.equals("RepairerConfig_UseNewDraftNotify_Int" /* "RepairerConfig_UseNewDraftNotify_Int" /* "RepairerConfig_UseNewDraftNotify_Int" /* cnb.z(-623186869746474L)  */)) {
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
