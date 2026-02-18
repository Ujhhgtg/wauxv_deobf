package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class lq extends doo implements bny {
    public static final lq a = new lq("AttachVoiceInput" /* cnb.z(-615885425343274L) */);
    public static final String b = "测试-配置修复-v63-chatting" /* cnb.z(-616186073053994L) */;
    public static final String c = "附件栏语音输入切换成聊天栏语音输入" /* cnb.z(-616078698871594L) */;

    @Override // me.hd.wauxv.obf.bny
    public final void d(bmm bmmVar, String str) {
        if (z() && str.equals("RepairerConfig_Attach_VoiceInput_Int" /* cnb.z(-615829590768426L) */)) {
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
