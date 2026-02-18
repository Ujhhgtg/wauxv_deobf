package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class xk extends doo implements bod {
    public static final xk a = new xk("ChatroomMuteDetail" /* cnb.z(-647431960132394L) */);
    public static final String b = "测试-配置同步-userinfo" /* cnb.z(-646581556607786L) */;
    public static final String c = "消息免打扰-以下消息仍通知" /* cnb.z(-647058297977642L) */;

    @Override // me.hd.wauxv.obf.bod
    public final void d(bmm bmmVar, String str) {
        if (z() && str.equals("USERINFO_CHATROOM_MUTE_DETAIL_CLIENT_GRAY_BOOLEAN_SYNC" /* cnb.z(-647367535622954L) */)) {
            bmmVar.h(Boolean.TRUE);
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
