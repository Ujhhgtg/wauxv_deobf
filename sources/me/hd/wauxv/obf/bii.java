package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class bii extends SwitchHook implements IHandlesHookParam {
    public static final bii a = new bii("GlobalToastActivityName" /* "GlobalToastActivityName" /* "GlobalToastActivityName" /* "GlobalToastActivityName" /* cnb.z(-615335669529386L)   */);
    public static final String b = "测试-配置修复-old-global" /* "测试-配置修复-old-global" /* "测试-配置修复-old-global" /* "测试-配置修复-old-global" /* cnb.z(-615563302796074L)   */;
    public static final String c = "查看Activity的类名" /* "查看Activity的类名" /* "查看Activity的类名" /* "查看Activity的类名" /* cnb.z(-615498878286634L)   */;

    @Override // me.hd.wauxv.obf.IHandlesHookParam
    public final void handleHookParam(HookParam hookParam, String str) {
        if (getIsEnabled() && str.equals("RepairerConfig_GlobalToastActivityName_Int" /* "RepairerConfig_GlobalToastActivityName_Int" /* "RepairerConfig_GlobalToastActivityName_Int" /* "RepairerConfig_GlobalToastActivityName_Int" /* cnb.z(-615232590314282L)   */)) {
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
