package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.hd.wauxv.R;
import me.hd.wauxv.data.bean.MsgInfoBean;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cfc extends BaseHook implements bnq {
    public static final cfc b = new cfc("MoreMsgVoiceForwardHook" /* cnb.z(-514210664545066L) */);
    public static final String c = "菜单" /* cnb.z(-513738218142506L) */;
    public static final String h = "多选语音转发" /* cnb.z(-513742513109802L) */;
    public static final String i = "支持多选语音消息后转发到私聊或群聊" /* cnb.z(-513712448338730L) */;

    @Override // me.hd.wauxv.obf.bnq
    public final List a(ArrayList arrayList) {
        if (z() && !arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (((MsgInfoBean) it.next()).isVoice()) {
                    return dqc.bf(new cev(R.id.MenuItem_MoreBtnBar_VoiceForward, "语音转发" /* cnb.z(-514107585329962L) */,
                            new cbk(11)));
                }
            }
        }
        return avd.a;
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
