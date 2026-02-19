package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.hd.wauxv.R;
import me.hd.wauxv.data.bean.MsgInfoBean;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cfa extends SwitchHook implements bnq {
    public static final cfa b = new cfa("MoreMsgRevokeHook" /* "MoreMsgRevokeHook" /* "MoreMsgRevokeHook" /* "MoreMsgRevokeHook" /* cnb.z(-512814800173866L)   */);
    public static final String c = "菜单" /* "菜单" /* "菜单" /* "菜单" /* cnb.z(-512716015926058L)   */;
    public static final String h = "多选消息撤回" /* "多选消息撤回" /* "多选消息撤回" /* "多选消息撤回" /* cnb.z(-512651591416618L)   */;
    public static final String i = "支持多选聊天消息后进行批量撤回操作" /* "支持多选聊天消息后进行批量撤回操作" /* "支持多选聊天消息后进行批量撤回操作" /* "支持多选聊天消息后进行批量撤回操作" /* cnb.z(-514270794087210L)   */;

    @Override // me.hd.wauxv.obf.bnq
    public final List a(ArrayList arrayList) {
        if (getIsEnabled() && !arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (((MsgInfoBean) it.next()).isSend()) {
                    return dqc.toSingletonList(new cev(R.id.MenuItem_MoreBtnBar_Revoke, "批量撤回" /* "批量撤回" /* "批量撤回" /* "批量撤回" /* cnb.z(-512685951154986L)   */,
                            new cbk(10)));
                }
            }
        }
        return EmptyReadonlyList.INSTANCE;
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
