package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class cnz extends doo implements bny {
    public static final cnz a = new cnz("NewSendVideo" /* cnb.z(-649914451229482L) */);
    public static final String b = "测试-配置修复-v66-msgSend" /* cnb.z(-650236573776682L) */;
    public static final String c = "发送视频使用新架构" /* cnb.z(-650185034169130L) */;

    @Override // me.hd.wauxv.obf.bny
    public final void d(bmm bmmVar, String str) {
        if (z() && str.equals("RepairerConfig_NewSendVideo_Int" /* cnb.z(-649824256916266L) */)) {
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
