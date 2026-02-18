package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class dhn extends doo implements bny {
    public static final dhn a = new dhn("ShowProfileCreateTime" /* cnb.z(-613037862026026L) */);
    public static final String b = "测试-配置修复-v51-profile" /* cnb.z(-613299855031082L) */;
    public static final String c = "是否显示用户添加好友时间" /* cnb.z(-612698559609642L) */;

    @Override // me.hd.wauxv.obf.bny
    public final void d(bmm bmmVar, String str) {
        if (z() && str.equals("RepairerConfig_ShowProfileCreateTime_Int" /* cnb.z(-613475948690218L) */)) {
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
