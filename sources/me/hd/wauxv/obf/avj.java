package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class avj extends doo implements bny {
    public static final avj a = new avj("EnableMsgPaste" /* cnb.z(-642939424340778L) */);
    public static final String b = "测试-配置修复-v65-global" /* cnb.z(-642728970943274L) */;
    public static final String c = "支持消息粘贴" /* cnb.z(-643162762640170L) */;

    @Override // me.hd.wauxv.obf.bny
    public final void d(bmm bmmVar, String str) {
        if (z() && str.equals("RepairerConfig_EnableMsgPaste_Int" /* cnb.z(-642857819962154L) */)) {
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
