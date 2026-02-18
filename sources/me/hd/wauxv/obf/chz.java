package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class chz extends BaseHook implements bny {
    public static final chz a = new chz("MvvmItemShowDebugView" /* cnb.z(-631446091856682L) */);
    public static final String b = "测试-配置修复-v62-chatting-mvvmItem" /* cnb.z(-632807596489514L) */;
    public static final String c = "MvvmView - 显示DebugView" /* cnb.z(-633280042892074L) */;

    @Override // me.hd.wauxv.obf.bny
    public final void d(HookParamWrapper hookParam, String str) {
        if (z() && str.equals("RepairerConfig_MvvmItemShowDebugView_Int" /* cnb.z(-632983690148650L) */)) {
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
