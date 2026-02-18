package me.hd.wauxv.obf;

import java.util.List;
import me.hd.wauxv.R;
import me.hd.wauxv.data.bean.MsgInfoBean;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class etl extends BaseHook implements bna {
    public static final etl a = new etl("VoiceForwardHook" /* cnb.z(-521116971957034L) */);
    public static final String b = "菜单" /* cnb.z(-520167784184618L) */;
    public static final String c = "语音转发" /* cnb.z(-520120539544362L) */;
    public static final String h = "支持语音消息自由转发到私聊或者群聊" /* cnb.z(-520133424446250L) */;

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

    @Override // me.hd.wauxv.obf.bna
    public final List l(MsgInfoBean msgInfoBean) {
        return (z() && msgInfoBean.isVoice()) ? dqc.bf(new wj(R.id.MenuItem_Chat_VoiceForward,
                "转发" /* cnb.z(-521043957513002L) */, R.drawable.ic_menu_forward_24dp, new dfq(17))) : avd.a;
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getDescription() {
        return h;
    }
}
