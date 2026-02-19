package me.hd.wauxv.obf;

import java.util.List;
import me.hd.wauxv.R;
import me.hd.wauxv.data.bean.MsgInfoBean;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class chc extends SwitchHook implements bna {
    public static final chc a = new chc("MsgRepeatHook" /* "MsgRepeatHook" /* "MsgRepeatHook" /* "MsgRepeatHook" /* cnb.z(-520799144377130L)   */);
    public static final String b = "菜单" /* "菜单" /* "菜单" /* "菜单" /* cnb.z(-520661705423658L)   */;
    public static final String c = "消息复读" /* "消息复读" /* "消息复读" /* "消息复读" /* cnb.z(-520666000390954L)   */;
    public static final String h = "支持直接复读部分的简单消息到上下文" /* "支持直接复读部分的简单消息到上下文" /* "支持直接复读部分的简单消息到上下文" /* "支持直接复读部分的简单消息到上下文" /* cnb.z(-520627345685290L)   */;

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

    @Override // me.hd.wauxv.obf.bna
    public final List l(MsgInfoBean msgInfoBean) {
        if (getIsEnabled()) {
            if (msgInfoBean.isText()) {
                return dqc.toSingletonList(new wj(R.id.MenuItem_Chat_MsgRepeat, "复读" /* "复读" /* "复读" /* "复读" /* cnb.z(-520790554442538L)   */,
                        R.drawable.ic_menu_repeat_24dp, new cbk(15)));
            }
            if (msgInfoBean.isImage()) {
                return dqc.toSingletonList(new wj(R.id.MenuItem_Chat_MsgRepeat, "复读" /* "复读" /* "复读" /* "复读" /* cnb.z(-520726129933098L)   */,
                        R.drawable.ic_menu_repeat_24dp, new cbk(16)));
            }
            if (msgInfoBean.isVoice()) {
                return dqc.toSingletonList(new wj(R.id.MenuItem_Chat_MsgRepeat, "复读" /* "复读" /* "复读" /* "复读" /* cnb.z(-520747604769578L)   */,
                        R.drawable.ic_menu_repeat_24dp, new cbk(17)));
            }
            if (msgInfoBean.isVideo()) {
                return dqc.toSingletonList(new wj(R.id.MenuItem_Chat_MsgRepeat, "复读" /* "复读" /* "复读" /* "复读" /* cnb.z(-520751899736874L)   */,
                        R.drawable.ic_menu_repeat_24dp, new cbk(18)));
            }
            if (msgInfoBean.isEmoji()) {
                return dqc.toSingletonList(new wj(R.id.MenuItem_Chat_MsgRepeat, "复读" /* "复读" /* "复读" /* "复读" /* cnb.z(-520704655096618L)   */,
                        R.drawable.ic_menu_repeat_24dp, new cbk(19)));
            }
            if (msgInfoBean.isQuote()) {
                return dqc.toSingletonList(new wj(R.id.MenuItem_Chat_MsgRepeat, "复读" /* "复读" /* "复读" /* "复读" /* cnb.z(-520708950063914L)   */,
                        R.drawable.ic_menu_repeat_24dp, new cbk(20)));
            }
        }
        return EmptyReadonlyList.a;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return h;
    }
}
