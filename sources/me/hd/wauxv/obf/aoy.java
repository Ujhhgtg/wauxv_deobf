package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class aoy extends doo implements bny {
    public static final aoy a = new aoy("DistinctAtMeOrAtAllToNotify" /* cnb.z(-599637564062506L) */);
    public static final String b = "测试-配置修复-v55-msgSync" /* cnb.z(-605379935337258L) */;
    public static final String c = "聊天摘要是否区分[@我]与[@all]" /* cnb.z(-605809432066858L) */;

    @Override // me.hd.wauxv.obf.bny
    public final void d(bmm bmmVar, String str) {
        if (z() && str.equals("RepairerConfig_DistinctAtMeOrAtAllToNotify_Int" /* cnb.z(-605530259192618L) */)) {
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
