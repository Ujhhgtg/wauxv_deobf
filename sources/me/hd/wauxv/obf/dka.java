package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class dka extends SwitchHook implements IHandlesHookParam {
    public static final dka a = new dka("SnsPublishLivePhoto" /* cnb.z(-599890967132970L) */);
    public static final String b = "测试-配置修复-v55-livePhoto" /* cnb.z(-600221679614762L) */;
    public static final String c = "朋友圈发表LivePhoto" /* cnb.z(-600110010465066L) */;

    @Override // me.hd.wauxv.obf.IHandlesHookParam
    public final void handleHookParam(HookParam hookParam, String str) {
        if (getIsEnabled() && str.equals("RepairerConfig_SnsPublishLivePhoto_Int" /* cnb.z(-599839427525418L) */)) {
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
