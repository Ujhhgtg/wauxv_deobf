package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class big extends doo implements bny {
    public static final big a = new big("GlobalStorageForceShowOtherRes" /* cnb.z(-643115517999914L) */);
    public static final String b = "测试-配置修复-v65-global" /* cnb.z(-642252229573418L) */;
    public static final String c = "强制显示资源文件卡片(开启: >=1)" /* cnb.z(-642119085587242L) */;

    @Override // me.hd.wauxv.obf.bny
    public final void d(bmm bmmVar, String str) {
        if (z() && str.equals("RepairerConfig_GlobalStorageForceShowOtherRes_Int_Int" /* cnb.z(-642982374013738L) */)) {
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
