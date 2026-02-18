package me.hd.wauxv.obf;

import java.util.List;
import me.hd.wauxv.R;
import me.hd.wauxv.data.bean.MsgInfoBean;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class etl extends doo implements bna {
    public static final etl a = new etl(cnb.z(-521116971957034L));
    public static final String b = cnb.z(-520167784184618L);
    public static final String c = cnb.z(-520120539544362L);
    public static final String h = cnb.z(-520133424446250L);

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

    @Override // me.hd.wauxv.obf.bna
    public final List l(MsgInfoBean msgInfoBean) {
        return (z() && msgInfoBean.isVoice()) ? dqc.bf(new wj(R.id.MenuItem_Chat_VoiceForward, cnb.z(-521043957513002L), R.drawable.ic_menu_forward_24dp, new dfq(17))) : avd.a;
    }

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return h;
    }
}
