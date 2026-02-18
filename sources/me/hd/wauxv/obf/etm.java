package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class etm extends doo implements bny {
    public static final etm a = new etm("VoiceInput" /* cnb.z(-629616435788586L) */);
    public static final String b = "测试-配置修复-v62-chatting" /* cnb.z(-629990097943338L) */;
    public static final String c = "聊天输入栏支持语音输入" /* cnb.z(-629951443237674L) */;

    @Override // me.hd.wauxv.obf.bny
    public final void d(bmm bmmVar, String str) {
        if (z() && str.equals("RepairerConfig_VoiceInput_Int" /* cnb.z(-629586371017514L) */)) {
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
