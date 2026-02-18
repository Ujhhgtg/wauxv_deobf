package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class boq extends SwitchHook implements IHandlesHookParam {
    public static final boq a = new boq("ImgUploadHevc" /* cnb.z(-604744280177450L) */);
    public static final String b = "测试-配置修复-v56-msgSend" /* cnb.z(-605092172528426L) */;
    public static final String c = "发送图片是否支持Hevc" /* cnb.z(-605040632920874L) */;

    @Override // me.hd.wauxv.obf.IHandlesHookParam
    public final void handleHookParam(HookParam hookParam, String str) {
        if (getIsEnabled() && str.equals("RepairerConfig_ImgUploadHevc_Int" /* cnb.z(-605216726580010L) */)) {
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
