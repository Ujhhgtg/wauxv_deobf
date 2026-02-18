package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class sk extends SwitchHook implements IHandlesHookParam {
    public static final sk a = new sk("C2CLiveAlbumAutoEnableConfig" /* cnb.z(-616018569329450L) */);
    public static final String b = "测试-配置修复-v63-chatting" /* cnb.z(-617891175070506L) */;
    public static final String c = "聊天发送Live时是否自动打开 (单位毫秒, by realhe)" /* cnb.z(-617766621018922L) */;

    @Override // me.hd.wauxv.obf.IHandlesHookParam
    public final void handleHookParam(HookParam hookParam, String str) {
        if (getIsEnabled() && str
                .equals("RepairerConfig_Chatting_C2C_Live_Album_Auto_Enable_Int" /* cnb.z(-617577642457898L) */)) {
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
