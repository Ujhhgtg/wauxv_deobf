package me.hd.wauxv.obf;

import java.util.List;
import me.hd.wauxv.R;
import me.hd.wauxv.data.bean.MsgInfoBean;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class etw extends doo implements bna {
    public static final etw a = new etw(cnb.z(-520459841960746L));
    public static final String b;
    public static final String c;
    public static final String h;
    public static final String i;
    public static final epy j;

    static {
        dov dovVar = ctf.a;
        b = ctf.c(cnb.z(-46231027972906L), cnb.z(-46192373267242L));
        c = cnb.z(-526305292450602L);
        h = cnb.z(-526309587417898L);
        i = cnb.z(-526270932712234L);
        j = new epy(13);
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
        return (z() && msgInfoBean.isVoice()) ? dqc.bf(new wj(R.id.MenuItem_Chat_VoiceSave, cnb.z(-520382532549418L), R.drawable.ic_menu_save_24dp, new dfq(18))) : avd.a;
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
