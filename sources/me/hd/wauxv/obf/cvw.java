package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class cvw extends SwitchHook implements IHandlesHookParam {
    public static final cvw a = new cvw("ProfileModUIRefactor" /* "ProfileModUIRefactor" /* "ProfileModUIRefactor" /* cnb.z(-643347446233898L)  */);
    public static final String b = "测试-配置修复-v65-remark" /* "测试-配置修复-v65-remark" /* "测试-配置修复-v65-remark" /* cnb.z(-643618029173546L)  */;
    public static final String c = "【通讯录】修改备注页-重构" /* "【通讯录】修改备注页-重构" /* "【通讯录】修改备注页-重构" /* cnb.z(-643553604664106L)  */;

    @Override // me.hd.wauxv.obf.IHandlesHookParam
    public final void handleHookParam(HookParam hookParam, String str) {
        if (getIsEnabled() && str.equals("RepairerConfig_ProfileModUIRefactor_Int" /* "RepairerConfig_ProfileModUIRefactor_Int" /* "RepairerConfig_ProfileModUIRefactor_Int" /* cnb.z(-643240072051498L)  */)) {
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
