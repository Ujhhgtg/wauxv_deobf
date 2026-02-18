package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class eww extends SwitchHook implements IHandlesHookParam {
    public static final eww a = new eww("YuanBaoMakingAvatarEnable" /* cnb.z(-649523609205546L) */);
    public static final String b = "测试-配置修复-v65-yuanbao" /* cnb.z(-649768422341418L) */;
    public static final String c = "元宝制作头像 - 开关" /* cnb.z(-649648163257130L) */;

    @Override // me.hd.wauxv.obf.IHandlesHookParam
    public final void handleHookParam(HookParam hookParam, String str) {
        if (getIsEnabled()
                && str.equals("RepairerConfig_YuanBaoMakingAvatarEnable_Int" /* cnb.z(-649429119925034L) */)) {
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
