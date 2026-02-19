package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class cia extends SwitchHook implements IHandlesHookParam {
    public static final cia a = new cia("MvvmListDebug" /* "MvvmListDebug" /* "MvvmListDebug" /* "MvvmListDebug" /* cnb.z(-608059994929962L)   */);
    public static final String b = "测试-配置修复-old-chatting" /* "测试-配置修复-old-chatting" /* "测试-配置修复-old-chatting" /* "测试-配置修复-old-chatting" /* cnb.z(-608407887280938L)   */;
    public static final String c = "选择联系人MvvmList显示Id" /* "选择联系人MvvmList显示Id" /* "选择联系人MvvmList显示Id" /* "选择联系人MvvmList显示Id" /* cnb.z(-614330647182122L)   */;

    @Override // me.hd.wauxv.obf.IHandlesHookParam
    public final void handleHookParam(HookParam hookParam, String str) {
        if (getIsEnabled() && str.equals("RepairerConfig_MvvmListDebug_Int" /* "RepairerConfig_MvvmListDebug_Int" /* "RepairerConfig_MvvmListDebug_Int" /* "RepairerConfig_MvvmListDebug_Int" /* cnb.z(-608532441332522L)   */)) {
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
