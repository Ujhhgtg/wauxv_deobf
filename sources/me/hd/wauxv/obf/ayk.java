package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class ayk extends SwitchHook implements IHandlesHookParam {
    public static final ayk a = new ayk("FavCleanSpaceNew" /* cnb.z(-649630983387946L) */);
    public static final String b = "测试-配置修复-v66-global" /* cnb.z(-648819234569002L) */;
    public static final String c = "空间清理模式新版" /* cnb.z(-648771989928746L) */;

    @Override // me.hd.wauxv.obf.IHandlesHookParam
    public final void handleHookParam(HookParam hookParam, String str) {
        if (getIsEnabled() && str.equals("RepairerConfig_FavCleanSpaceNew_Int" /* cnb.z(-649557968943914L) */)) {
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
