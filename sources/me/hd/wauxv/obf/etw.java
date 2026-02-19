package me.hd.wauxv.obf;

import java.util.List;
import me.hd.wauxv.R;
import me.hd.wauxv.data.bean.MsgInfoBean;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class etw extends SwitchHook implements bna {
    public static final etw a = new etw("VoiceSaveHook" /* "VoiceSaveHook" /* "VoiceSaveHook" /* cnb.z(-520459841960746L)  */);
    public static final String b;
    public static final String c;
    public static final String h;
    public static final String i;
    public static final epy j;

    static {
        dov dovVar = ctf.a;
        b = ctf.c("Download" /* "Download" /* "Download" /* cnb.z(-46231027972906L)  */, "Voice" /* "Voice" /* "Voice" /* cnb.z(-46192373267242L)  */);
        c = "菜单" /* "菜单" /* "菜单" /* cnb.z(-526305292450602L)  */;
        h = "语音保存" /* "语音保存" /* "语音保存" /* cnb.z(-526309587417898L)  */;
        i = "支持将语音消息自由保存到本地存储中" /* "支持将语音消息自由保存到本地存储中" /* "支持将语音消息自由保存到本地存储中" /* cnb.z(-526270932712234L)  */;
        j = new epy(13);
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getName() {
        return h;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getCategory() {
        return c;
    }

    @Override // me.hd.wauxv.obf.bna
    public final List l(MsgInfoBean msgInfoBean) {
        return (z() && msgInfoBean.isVoice()) ? dqc.toSingletonList(new wj(R.id.MenuItem_Chat_VoiceSave,
                "保存" /* "保存" /* "保存" /* cnb.z(-520382532549418L)  */, R.drawable.ic_menu_save_24dp, new dfq(18))) : EmptyReadonlyList.a;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return i;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final IInvokable getOnClick() {
        return j;
    }
}
