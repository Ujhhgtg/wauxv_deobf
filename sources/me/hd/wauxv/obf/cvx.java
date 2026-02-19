package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class cvx extends SwitchHook implements IHandlesHookParam {
    public static final cvx a = new cvx("ProfileSelectChatImage" /* "ProfileSelectChatImage" /* "ProfileSelectChatImage" /* "ProfileSelectChatImage" /* cnb.z(-621730875833130L)   */);
    public static final String b = "测试-配置修复-v64-remark" /* "测试-配置修复-v64-remark" /* "测试-配置修复-v64-remark" /* "测试-配置修复-v64-remark" /* cnb.z(-645091202956074L)   */;
    public static final String c = "【通讯录】备注照片-选择聊天中图片" /* "【通讯录】备注照片-选择聊天中图片" /* "【通讯录】备注照片-选择聊天中图片" /* "【通讯录】备注照片-选择聊天中图片" /* cnb.z(-644975238839082L)   */;

    @Override // me.hd.wauxv.obf.IHandlesHookParam
    public final void handleHookParam(HookParam hookParam, String str) {
        if (getIsEnabled() && str.equals("RepairerConfig_ProfileSelectChatImage_Int" /* "RepairerConfig_ProfileSelectChatImage_Int" /* "RepairerConfig_ProfileSelectChatImage_Int" /* "RepairerConfig_ProfileSelectChatImage_Int" /* cnb.z(-621614911716138L)   */)) {
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
