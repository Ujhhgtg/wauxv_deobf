package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class bih extends BaseHook implements bny {
    public static final bih a = new bih("GlobalStorageOtherResAndAccSeparating" /* cnb.z(-642617301793578L) */);
    public static final String b = "测试-配置修复-v65-global" /* cnb.z(-643807007734570L) */;
    public static final String c = "其他资源 & 其他账号卡片分离(开启: >=1)" /* cnb.z(-644292339039018L) */;

    @Override // me.hd.wauxv.obf.bny
    public final void d(HookParamWrapper hookParam, String str) {
        if (z() && str.equals("RepairerConfig_GlobalStorageOtherResAndAccSeparating_Int_Int" /*
                                                                                              * cnb.z(-642436913167146L)
                                                                                              */)) {
            hookParam.setResult(1);
        }
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getName() {
        return c;
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getCategory() {
        return b;
    }
}
