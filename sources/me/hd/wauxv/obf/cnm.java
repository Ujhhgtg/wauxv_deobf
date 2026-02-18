package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class cnm extends BaseHook implements bny {
    public static final cnm a = new cnm("NewImgMsgSendOrigin" /* cnb.z(-622095948053290L) */);
    public static final String b = "测试-配置修复-v64-msgSend" /* cnb.z(-621327148907306L) */;
    public static final String c = "新图片转发发送原图" /* cnb.z(-621756645636906L) */;

    @Override // me.hd.wauxv.obf.bny
    public final void d(HookParamWrapper hookParam, String str) {
        if (z() && str.equals("RepairerConfig_NewImgMsgSendOrigin_Int" /* cnb.z(-621494652631850L) */)) {
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
