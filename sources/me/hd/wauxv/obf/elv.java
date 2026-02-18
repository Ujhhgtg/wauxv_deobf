package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class elv extends BaseHook implements bny {
    public static final elv a = new elv("TransmitSingleImg" /* cnb.z(-611762256739114L) */);
    public static final String b = "测试-配置修复-v51-msgSend" /* cnb.z(-613175300979498L) */;
    public static final String c = "转发单张图片使用新架构" /* cnb.z(-613055041895210L) */;

    @Override // me.hd.wauxv.obf.bny
    public final void d(HookParamWrapper hookParam, String str) {
        if (z() && str.equals("RepairerConfig_TransmitSingleImg_Int" /* cnb.z(-611702127196970L) */)) {
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
