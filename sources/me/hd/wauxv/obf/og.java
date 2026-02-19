package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class og extends SwitchHook implements IHandlesHookParam {
    public static final og a = new og("BatchRevokeMsg" /* "BatchRevokeMsg" /* "BatchRevokeMsg" /* "BatchRevokeMsg" /* cnb.z(-650807804427050L)   */);
    public static final String b = "测试-配置修复-v66-msgSend" /* "测试-配置修复-v66-msgSend" /* "测试-配置修复-v66-msgSend" /* "测试-配置修复-v66-msgSend" /* cnb.z(-650047595215658L)   */;
    public static final String c = "是否开启批量撤回功能" /* "是否开启批量撤回功能" /* "是否开启批量撤回功能" /* "是否开启批量撤回功能" /* cnb.z(-649927336131370L)   */;

    @Override // me.hd.wauxv.obf.IHandlesHookParam
    public final void handleHookParam(HookParam hookParam, String str) {
        if (getIsEnabled() && str.equals("RepairerConfig_BatchRevokeMsg_Int" /* "RepairerConfig_BatchRevokeMsg_Int" /* "RepairerConfig_BatchRevokeMsg_Int" /* "RepairerConfig_BatchRevokeMsg_Int" /* cnb.z(-650726200048426L)   */)) {
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
