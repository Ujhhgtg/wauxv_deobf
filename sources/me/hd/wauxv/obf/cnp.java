package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class cnp extends doo implements bny {
    public static final cnp a = new cnp("NewSendFile" /* cnb.z(-624020093401898L) */);
    public static final String b = "测试-配置修复-v63-msgSend" /* cnb.z(-624419525360426L) */;
    public static final String c = "发送文件使用新架构" /* cnb.z(-624299266276138L) */;

    @Override // me.hd.wauxv.obf.bny
    public final void d(bmm bmmVar, String str) {
        if (z() && str.equals("RepairerConfig_NewSendFile_Int" /* cnb.z(-624002913532714L) */)) {
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
