package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class dru extends SwitchHook implements IHandlesHookParam {
    public static final dru a = new dru("TimeDetailEnable" /* "TimeDetailEnable" /* "TimeDetailEnable" /* cnb.z(-632253545708330L)  */);
    public static final String b = "测试-配置修复-v62-chatting" /* "测试-配置修复-v62-chatting" /* "测试-配置修复-v62-chatting" /* cnb.z(-632541308517162L)  */;
    public static final String c = "聊天切换显示时间详情 - 启用" /* "聊天切换显示时间详情 - 启用" /* "聊天切换显示时间详情 - 启用" /* cnb.z(-629685155265322L)  */;

    @Override // me.hd.wauxv.obf.IHandlesHookParam
    public final void handleHookParam(HookParam hookParam, String str) {
        if (getIsEnabled() && str.equals("RepairerConfig_TimeDetailEnable_Int" /* "RepairerConfig_TimeDetailEnable_Int" /* "RepairerConfig_TimeDetailEnable_Int" /* cnb.z(-632730287078186L)  */)) {
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
