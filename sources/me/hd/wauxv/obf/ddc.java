package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class ddc extends doo implements bny {
    public static final ddc a = new ddc("RoamNewContactSelectUI" /* cnb.z(-605757892459306L) */);
    public static final String b = "测试-配置修复-v55-roamBackup" /* cnb.z(-604877424163626L) */;
    public static final String c = "使用新的联系人选择UI" /* cnb.z(-604830179523370L) */;

    @Override // me.hd.wauxv.obf.bny
    public final void d(bmm bmmVar, String str) {
        if (z() && str.equals("RepairerConfig_RoamNewContactSelectUI_Int" /* cnb.z(-605659108211498L) */)) {
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
