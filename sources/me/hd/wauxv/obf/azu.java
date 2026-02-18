package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class azu extends doo implements bny {
    public static final azu a = new azu("FileSrcBtnEntrance" /* cnb.z(-644915109296938L) */);
    public static final String b = "测试-配置修复-v65-chatting" /* cnb.z(-645220051974954L) */;
    public static final String c = "「查看包含该图片/视频/文件的聊天」入口" /* cnb.z(-644562921978666L) */;

    @Override // me.hd.wauxv.obf.bny
    public final void d(bmm bmmVar, String str) {
        if (z() && str.equals("RepairerConfig_FileSrcBtnEntrance_Int" /* cnb.z(-645400440601386L) */)) {
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
