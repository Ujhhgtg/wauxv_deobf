package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class ewv extends SwitchHook implements IHandlesHookParam {
    public static final ewv a = new ewv("YuanBaoAnalyzeChatRecordsSupportPrivateChat" /* "YuanBaoAnalyzeChatRecordsSupportPrivateChat" /* "YuanBaoAnalyzeChatRecordsSupportPrivateChat" /* cnb.z(-646195009551146L)  */);
    public static final String b = "测试-配置修复-v65-chatting" /* "测试-配置修复-v65-chatting" /* "测试-配置修复-v65-chatting" /* cnb.z(-646302383733546L)  */;
    public static final String c = "允许「元宝分析聊天记录」在单聊中使用" /* "允许「元宝分析聊天记录」在单聊中使用" /* "允许「元宝分析聊天记录」在单聊中使用" /* cnb.z(-645645253737258L)  */;

    @Override // me.hd.wauxv.obf.IHandlesHookParam
    public final void handleHookParam(HookParam hookParam, String str) {
        if (getIsEnabled() && str.equals("RepairerConfig_YuanBaoAnalyzeChatRecordsSupportPrivateChat_Int" /*
                                                                                                           * cnb.z(-
                                                                                                           * 645971671251754L)
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
