package me.hd.wauxv.obf;

import java.util.List;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class crm extends BaseHook implements bnn {
    public static final crm a = new crm("OpenInfoUiHook" /* cnb.z(-513068203244330L) */);
    public static final String b = "菜单" /* cnb.z(-513428980497194L) */;
    public static final String c = "打开详情" /* cnb.z(-513433275464490L) */;
    public static final String h = "打开 好友ID 或者 群聊ID 的对应详情页" /* cnb.z(-513394620758826L) */;
    public static final crl i = new crl(0);

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
                : dqc.bf(new bly(R.id.MenuItem_Home_OpenInfo, "打开详情" /* cnb.z(-513055318342442L) */,
                        R.drawable.ic_menu_info_24dp, new cfh(14)));
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getDescription() {
        return h;
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final IHasInvokeMethod p() {
        return i;
    }
}
