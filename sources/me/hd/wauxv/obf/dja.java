package me.hd.wauxv.obf;

import java.util.List;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dja extends SwitchHook implements boa {
    public static final dja b = new dja("SnsForwardHook" /* "SnsForwardHook" /* "SnsForwardHook" /* cnb.z(-534581694429994L)  */);
    public static final String c = "朋友圈" /* "朋友圈" /* "朋友圈" /* cnb.z(-534663298808618L)  */;
    public static final String h = "朋友圈消息转发" /* "朋友圈消息转发" /* "朋友圈消息转发" /* cnb.z(-536261026642730L)  */;
    public static final String i = "支持在朋友圈转发并编辑部分消息发表" /* "支持在朋友圈转发并编辑部分消息发表" /* "支持在朋友圈转发并编辑部分消息发表" /* cnb.z(-536226666904362L)  */;

    @Override // me.hd.wauxv.obf.boa
    public final List a() {
        return !z() ? EmptyReadonlyList.INSTANCE
                : dqc.toSingletonList(new djl(R.id.MenuItem_Sns_Forward, "转发[WA]" /* "转发[WA]" /* "转发[WA]" /* cnb.z(-534517269920554L)  */, new wx(2)));
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

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return i;
    }
}
