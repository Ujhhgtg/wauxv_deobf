package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class bcw extends doo implements bny {
    public static final bcw a = new bcw("ForwardNewRecordDetail" /* cnb.z(-625832569600810L) */);
    public static final String b = "测试-配置修复-v61-msgSend" /* cnb.z(-626120332409642L) */;
    public static final String c = "聊天记录使用新详情页 - 转发预览" /* cnb.z(-626068792802090L) */;

    @Override // me.hd.wauxv.obf.bny
    public final void d(bmm bmmVar, String str) {
        if (z() && str.equals("RepairerConfig_ForwardNewRecordDetail_Int" /* cnb.z(-625733785353002L) */)) {
            bmmVar.h(1);
        }
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
    }

    @Override // me.hd.wauxv.obf.doo
    public final String f() {
        return c;
    }

    @Override // me.hd.wauxv.obf.doo
    public final String g() {
        return b;
    }
}
