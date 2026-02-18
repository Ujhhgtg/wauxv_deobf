package me.hd.wauxv.obf;

import java.util.List;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cha extends BaseHook implements bnn {
    public static final cha a = new cha("MsgListHideOrShowHook" /* cnb.z(-525317449972522L) */);
    public static final String b = "菜单" /* cnb.z(-524776284093226L) */;
    public static final String c = "消息列表" /* cnb.z(-513166987492138L) */;
    public static final String h = "为主页菜单添加消息列表隐藏或者显示" /* cnb.z(-513197052263210L) */;

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

    @Override // me.hd.wauxv.obf.bnn
    public final List j() {
        return !z() ? avd.a
                : aba.ag(
                        new bly(R.id.MenuItem_Home_MsgListHide, "列表隐藏" /* cnb.z(-524656025008938L) */,
                                R.drawable.ic_menu_hide_24dp, new cfh(7)),
                        new bly(R.id.MenuItem_Home_MsgListShow, "列表显示" /* cnb.z(-524668909910826L) */,
                                R.drawable.ic_menu_show_24dp, new cfh(8)));
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getDescription() {
        return h;
    }
}
