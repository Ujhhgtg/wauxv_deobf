package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class cnn extends BaseHook implements bny {
    public static final cnn a = new cnn("NewRecordDetail" /* cnb.z(-627340103121706L) */);
    public static final String b = "测试-配置修复-v58-msgSend" /* cnb.z(-627619275995946L) */;
    public static final String c = "聊天记录使用新详情页" /* cnb.z(-627567736388394L) */;

    @Override // me.hd.wauxv.obf.bny
    public final void d(HookParamWrapper hookParam, String str) {
        if (z() && str.equals("RepairerConfig_NewRecordDetail_Int" /* cnb.z(-627821139458858L) */)) {
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
