package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class eww extends doo implements bny {
    public static final eww a = new eww("YuanBaoMakingAvatarEnable" /* cnb.z(-649523609205546L) */);
    public static final String b = "测试-配置修复-v65-yuanbao" /* cnb.z(-649768422341418L) */;
    public static final String c = "元宝制作头像 - 开关" /* cnb.z(-649648163257130L) */;

    @Override // me.hd.wauxv.obf.bny
    public final void d(bmm bmmVar, String str) {
        if (z() && str.equals("RepairerConfig_YuanBaoMakingAvatarEnable_Int" /* cnb.z(-649429119925034L) */)) {
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
