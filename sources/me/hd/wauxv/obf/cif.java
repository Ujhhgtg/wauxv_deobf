package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cif extends doo implements bnj {
    public static final cif a = new cif("MyFavMenuForwardHook" /* cnb.z(-476011225414442L) */);
    public static final String b = "收藏" /* cnb.z(-476857333971754L) */;
    public static final String c = "我的收藏语音转发" /* cnb.z(-476878808808234L) */;
    public static final String h = "在我的收藏页面长按语音呼出转发菜单" /* cnb.z(-476840154102570L) */;

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

    public final List i() {
        return !z() ? avd.a : dqc.bf(new ayv("转发[WA]" /* cnb.z(-475886671362858L) */, new cgu(10)));
    }

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return h;
    }
}
