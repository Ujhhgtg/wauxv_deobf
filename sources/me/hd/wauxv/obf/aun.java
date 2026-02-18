package me.hd.wauxv.obf;

import java.util.List;
import me.hd.wauxv.R;
import me.hd.wauxv.data.bean.MsgInfoBean;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aun extends doo implements bna {
    public static final aun a = new aun("EmojiSaveHook" /* cnb.z(-519205711510314L) */);
    public static final String b;
    public static final String c;
    public static final String h;
    public static final String i;
    public static final atn j;

    static {
        dov dovVar = ctf.a;
        b = ctf.c("Download" /* cnb.z(-46385646795562L) */, "Emoji" /* cnb.z(-46346992089898L) */);
        c = "菜单" /* cnb.z(-519489179351850L) */;
        h = "表情保存" /* cnb.z(-519510654188330L) */;
        i = "支持将表情消息自由保存到本地存储中" /* cnb.z(-519454819613482L) */;
        j = new atn(16);
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
    }

    @Override // me.hd.wauxv.obf.doo
    public final String f() {
        return h;
    }

    @Override // me.hd.wauxv.obf.doo
    public final String g() {
        return c;
    }

    @Override // me.hd.wauxv.obf.bna
    public final List l(MsgInfoBean msgInfoBean) {
        return (z() && msgInfoBean.isEmoji()) ? dqc.bf(new wj(R.id.MenuItem_Chat_EmojiSave, "保存" /* cnb.z(-519128402098986L) */, R.drawable.ic_menu_save_24dp, new fq(7))) : avd.a;
    }

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return i;
    }

    @Override // me.hd.wauxv.obf.doo
    public final bgf p() {
        return j;
    }
}
