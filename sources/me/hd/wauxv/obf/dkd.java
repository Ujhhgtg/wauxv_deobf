package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class dkd extends doo implements bny {
    public static final dkd a = new dkd("SnsSupportSaveLivePhoto" /* cnb.z(-599478650272554L) */);
    public static final String b = "测试-配置修复-v55-livePhoto" /* cnb.z(-599255311973162L) */;
    public static final String c = "朋友圈支持保存LivePhoto" /* cnb.z(-599693398637354L) */;

    @Override // me.hd.wauxv.obf.bny
    public final void d(bmm bmmVar, String str) {
        if (z() && str.equals("RepairerConfig_SnsSaveLivePhoto_Int" /* cnb.z(-599375571057450L) */)) {
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
