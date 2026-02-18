package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class cnx extends doo implements bny {
    public static final cnx a = new cnx("NewSendMultiMsg" /* cnb.z(-625939943783210L) */);
    public static final String b = "测试-配置修复-v61-msgSend" /* cnb.z(-631785394273066L) */;
    public static final String c = "逐条转发使用新架构" /* cnb.z(-631733854665514L) */;

    @Override // me.hd.wauxv.obf.bny
    public final void d(bmm bmmVar, String str) {
        if (z() && str.equals("RepairerConfig_NewSendMultiMsg_Int" /* cnb.z(-631918538259242L) */)) {
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
