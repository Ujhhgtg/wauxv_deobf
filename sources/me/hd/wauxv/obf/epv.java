package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class epv extends SwitchHook implements IHandlesHookParam {
    public static final epv a = new epv("VideoDownloadSupportPlay" /* cnb.z(-630295040621354L) */);
    public static final String b = "测试-配置修复-v62-msgSend" /* cnb.z(-630514083953450L) */;
    public static final String c = "视频预览播放支持边下边播" /* cnb.z(-630462544345898L) */;

    @Override // me.hd.wauxv.obf.IHandlesHookParam
    public final void handleHookParam(HookParam hookParam, String str) {
        if (getIsEnabled()
                && str.equals("RepairerConfig_VideoDownloadSupportPlay_Int" /* cnb.z(-630187666438954L) */)) {
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
