package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class AccbilityDisableClick extends SwitchHook implements IHandlesHookParam {
    public static final AccbilityDisableClick a = new AccbilityDisableClick("AccbilityDisableClick" /*
                                                                                                     * cnb.z(-
                                                                                                     * 602248904178474L)
                                                                                                     */);
    public static final String b = "测试-配置修复-v55-global" /* "测试-配置修复-v55-global" /* "测试-配置修复-v55-global" /* cnb.z(-602510897183530L)  */;
    public static final String c = "Accessibility - 禁用Action_Click响应" /* "Accessibility - 禁用Action_Click响应" /* "Accessibility - 禁用Action_Click响应" /* cnb.z(-602463652543274L)  */;

    @Override // me.hd.wauxv.obf.IHandlesHookParam
    public final void handleHookParam(HookParam hookParam, String str) {
        if (getIsEnabled() && str.equals("RepairerConfig_AccbilityDisableClick_Int" /* "RepairerConfig_AccbilityDisableClick_Int" /* "RepairerConfig_AccbilityDisableClick_Int" /* cnb.z(-602137235028778L)  */)) {
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
