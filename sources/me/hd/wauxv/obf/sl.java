package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class sl extends BaseHook implements bny {
    public static final sl a = new sl("C2CLiveImagePreview" /* cnb.z(-617088016186154L) */);
    public static final String b = "测试-配置修复-v63-chatting" /* cnb.z(-617311354485546L) */;
    public static final String c = "聊天预览支持Live (by realhe)" /* cnb.z(-617272699779882L) */;

    @Override // me.hd.wauxv.obf.bny
    public final void d(HookParamWrapper hookParam, String str) {
        if (z() && str.equals("RepairerConfig_Chatting_C2C_Live_Preview_V2_Int" /* cnb.z(-616967757101866L) */)) {
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
