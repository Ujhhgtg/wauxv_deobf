package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class ewu extends SwitchHook implements IHandlesHookParam {
    public static final ewu a = new ewu("YuanBaoAnalyzeChatRecordsEntrance" /* "YuanBaoAnalyzeChatRecordsEntrance" /* "YuanBaoAnalyzeChatRecordsEntrance" /* cnb.z(-644507087403818L)  */);
    public static final String b = "测试-配置修复-v65-chatting" /* "测试-配置修复-v65-chatting" /* "测试-配置修复-v65-chatting" /* cnb.z(-644717540801322L)  */;
    public static final String c = "启用消息多选「元宝分析聊天记录」入口" /* "启用消息多选「元宝分析聊天记录」入口" /* "启用消息多选「元宝分析聊天记录」入口" /* cnb.z(-644592986749738L)  */;

    @Override // me.hd.wauxv.obf.IHandlesHookParam
    public final void handleHookParam(HookParam hookParam, String str) {
        if (getIsEnabled()
                && str.equals("RepairerConfig_YuanBaoAnalyzeChatRecords_Int" /* "RepairerConfig_YuanBaoAnalyzeChatRecords_Int" /* "RepairerConfig_YuanBaoAnalyzeChatRecords_Int" /* cnb.z(-644378238384938L)  */)) {
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
