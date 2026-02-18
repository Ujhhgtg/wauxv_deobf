package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class ewx extends BaseHook implements bny {
    public static final ewx a = new ewx("YuanBaoSummaryEntrance" /* cnb.z(-645580829227818L) */);
    public static final String b = "测试-配置修复-v65-chatting" /* cnb.z(-645799872559914L) */;
    public static final String c = "启用聊天长按菜单「元宝总结」入口" /* cnb.z(-645744037985066L) */;

    @Override // me.hd.wauxv.obf.bny
    public final void d(HookParamWrapper hookParam, String str) {
        if (z() && str.equals("RepairerConfig_YuanBaoSummaryEntrance_Int" /* cnb.z(-645482044980010L) */)) {
            hookParam.setResult(1);
        }
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getName() {
        return c;
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getCategory() {
        return b;
    }
}
