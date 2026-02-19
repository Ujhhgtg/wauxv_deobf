package me.hd.wauxv.obf;

import java.util.List;
import me.hd.wauxv.R;
import me.hd.wauxv.data.bean.MsgInfoBean;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cgc extends SwitchHook implements bna {
    public static final cgc a = new cgc("MsgForwardSnsHook" /* "MsgForwardSnsHook" /* "MsgForwardSnsHook" /* cnb.z(-519394690071338L)  */);
    public static final String b = "菜单" /* "菜单" /* "菜单" /* cnb.z(-519313085692714L)  */;
    public static final String c = "消息转圈" /* "消息转圈" /* "消息转圈" /* cnb.z(-519248661183274L)  */;
    public static final String h = "支持将部分消息转发到朋友圈编辑发表" /* "支持将部分消息转发到朋友圈编辑发表" /* "支持将部分消息转发到朋友圈编辑发表" /* cnb.z(-519278725954346L)  */;

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
                return dqc.toSingletonList(new wj(R.id.MenuItem_Chat_ForwardSns, "转圈" /* "转圈" /* "转圈" /* cnb.z(-519334560529194L)  */,
                        R.drawable.ic_menu_forward_24dp, new cbk(12)));
            }
            if (msgInfoBean.isImage()) {
                return dqc.toSingletonList(new wj(R.id.MenuItem_Chat_ForwardSns, "转圈" /* "转圈" /* "转圈" /* cnb.z(-519287315888938L)  */,
                        R.drawable.ic_menu_forward_24dp, new cbk(13)));
            }
            if (msgInfoBean.isVideo()) {
                return dqc.toSingletonList(new wj(R.id.MenuItem_Chat_ForwardSns, "转圈" /* "转圈" /* "转圈" /* cnb.z(-519291610856234L)  */,
                        R.drawable.ic_menu_forward_24dp, new cbk(14)));
            }
        }
        return EmptyReadonlyList.INSTANCE;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return h;
    }
}
