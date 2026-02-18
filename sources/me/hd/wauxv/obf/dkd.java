package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class dkd extends SwitchHook implements IHandlesHookParam {
    public static final dkd a = new dkd("SnsSupportSaveLivePhoto" /* cnb.z(-599478650272554L) */);
    public static final String b = "测试-配置修复-v55-livePhoto" /* cnb.z(-599255311973162L) */;
    public static final String c = "朋友圈支持保存LivePhoto" /* cnb.z(-599693398637354L) */;

    @Override // me.hd.wauxv.obf.IHandlesHookParam
    public final void handleHookParam(HookParam hookParam, String str) {
        if (getIsEnabled() && str.equals("RepairerConfig_SnsSaveLivePhoto_Int" /* cnb.z(-599375571057450L) */)) {
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
