package me.hd.wauxv.obf;

import java.util.List;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cwy extends SwitchHook implements bnn {
    public static final cwy a = new cwy("QuickKillHook" /* cnb.z(-513278656641834L) */);
    public static final String b = "菜单" /* cnb.z(-513231412001578L) */;
    public static final String c = "快捷终止" /* cnb.z(-512617231678250L) */;
    public static final String h = "为主页右上角菜单添加快捷终止快捷项" /* cnb.z(-512647296449322L) */;

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getName() {
        return c;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getCategory() {
        return b;
    }

    @Override // me.hd.wauxv.obf.bnn
    public final List j() {
        return !z() ? avd.a
                : dqc.bf(new bly(R.id.MenuItem_Home_QuickKill, "快捷终止" /* cnb.z(-513201347230506L) */,
                        R.drawable.ic_menu_kill_24dp, new cfh(20)));
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return h;
    }
}
