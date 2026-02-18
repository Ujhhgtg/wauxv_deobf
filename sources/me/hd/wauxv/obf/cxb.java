package me.hd.wauxv.obf;

import java.util.List;
import me.hd.wauxv.R;
import me.hd.wauxv.data.bean.ConversationBean;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cxb extends BaseHook implements bnf {
    public static final cxb b = new cxb("QuickPullGroupHook" /* cnb.z(-526713314343722L) */);
    public static final String c = "菜单" /* cnb.z(-527065501661994L) */;
    public static final String h = "快捷拉群" /* cnb.z(-527018257021738L) */;
    public static final String i = "为聊天列表菜单添加快捷邀请好友加群" /* cnb.z(-527031141923626L) */;

    @Override // me.hd.wauxv.obf.bnf
    public final List a(ConversationBean conversationBean) {
        return (!z()
                || dnj.ab(conversationBean
                        .getUsername(), "@" /* cnb.z(-527215825517354L) */, false)
                || dnr.bp(conversationBean.getUsername(), "gh_" /* cnb.z(-527155695975210L) */, false)) ? avd.a
                        : dqc.bf(new agf(R.id.MenuItem_Conversation_QuickPullGroup, "快捷拉群" /*
                                                                                            * cnb.z(-527172875844394L)
                                                                                            */, new cvc(5)));
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getName() {
        return h;
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getCategory() {
        return c;
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getDescription() {
        return i;
    }
}
