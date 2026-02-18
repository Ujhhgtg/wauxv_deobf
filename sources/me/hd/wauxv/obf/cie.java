package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cie extends BaseHook implements bnk {
    public static final cie a = new cie("MyFavFilterMenuForwardHook" /* cnb.z(-479176616311594L) */);
    public static final String b = "收藏" /* cnb.z(-475598908554026L) */;
    public static final String c = "我的收藏语音过滤转发" /* cnb.z(-475603203521322L) */;
    public static final String h = "在我的收藏页面长按语音呼出转发菜单" /* cnb.z(-476071354956586L) */;

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

    public final List i() {
        return !z() ? avd.a : dqc.bf(new aza("转发[WA]" /* cnb.z(-478476536642346L) */, new cgu(9)));
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getDescription() {
        return h;
    }
}
