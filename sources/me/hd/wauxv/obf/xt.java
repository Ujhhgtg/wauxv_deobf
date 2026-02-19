package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class xt extends SwitchHook implements IHandlesHookParam {
    public static final xt a = new xt("ChattingConvBoxSingleRoom" /* "ChattingConvBoxSingleRoom" /* "ChattingConvBoxSingleRoom" /* cnb.z(-598830110210858L)  */);
    public static final String b = "测试-配置修复-v55-chatting" /* "测试-配置修复-v55-chatting" /* "测试-配置修复-v55-chatting" /* cnb.z(-599126462954282L)  */;
    public static final String c = "单聊支持折叠" /* "单聊支持折叠" /* "单聊支持折叠" /* cnb.z(-599019088771882L)  */;

    @Override // me.hd.wauxv.obf.IHandlesHookParam
    public final void handleHookParam(HookParam hookParam, String str) {
        if (getIsEnabled()
                && str.equals("RepairerConfig_ChattingConvBoxSingleRoom_Int" /* "RepairerConfig_ChattingConvBoxSingleRoom_Int" /* "RepairerConfig_ChattingConvBoxSingleRoom_Int" /* cnb.z(-598735620930346L)  */)) {
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
