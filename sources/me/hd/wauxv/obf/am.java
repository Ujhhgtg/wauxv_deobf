package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class am extends doo implements bny {
    public static final am a = new am("AccbilityDisableClick" /* cnb.z(-602248904178474L) */);
    public static final String b = "测试-配置修复-v55-global" /* cnb.z(-602510897183530L) */;
    public static final String c = "Accessibility - 禁用Action_Click响应" /* cnb.z(-602463652543274L) */;

    @Override // me.hd.wauxv.obf.bny
    public final void d(bmm bmmVar, String str) {
        if (z() && str.equals("RepairerConfig_AccbilityDisableClick_Int" /* cnb.z(-602137235028778L) */)) {
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
