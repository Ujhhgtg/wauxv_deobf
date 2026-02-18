package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class cvx extends BaseHook implements bny {
    public static final cvx a = new cvx("ProfileSelectChatImage" /* cnb.z(-621730875833130L) */);
    public static final String b = "测试-配置修复-v64-remark" /* cnb.z(-645091202956074L) */;
    public static final String c = "【通讯录】备注照片-选择聊天中图片" /* cnb.z(-644975238839082L) */;

    @Override // me.hd.wauxv.obf.bny
    public final void d(HookParamWrapper hookParam, String str) {
        if (z() && str.equals("RepairerConfig_ProfileSelectChatImage_Int" /* cnb.z(-621614911716138L) */)) {
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
