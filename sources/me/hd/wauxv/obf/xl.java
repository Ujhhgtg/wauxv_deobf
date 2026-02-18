package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class xl extends doo implements bny {
    public static final xl a = new xl("ChatroomRecentAt" /* cnb.z(-620708673616682L) */);
    public static final String b = "测试-配置修复-v64-chatting-mvvmItem" /* cnb.z(-620996436425514L) */;
    public static final String c = "群聊@显示最常提醒" /* cnb.z(-620300651723562L) */;

    @Override // me.hd.wauxv.obf.bny
    public final void d(bmm bmmVar, String str) {
        if (z() && str.equals("RepairerConfig_ChatroomRecentAt_Int" /* cnb.z(-621185414986538L) */)) {
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
