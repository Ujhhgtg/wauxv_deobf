package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.hd.wauxv.R;
import me.hd.wauxv.data.bean.MsgInfoBean;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cez extends SwitchHook implements bnq {
    public static final cez b = new cez("MoreMsgForwardSnsHook" /* "MoreMsgForwardSnsHook" /* "MoreMsgForwardSnsHook" /* cnb.z(-512518447430442L)  */);
    public static final String c = "菜单" /* "菜单" /* "菜单" /* cnb.z(-512900699519786L)  */;
    public static final String h = "多选消息转圈" /* "多选消息转圈" /* "多选消息转圈" /* cnb.z(-512922174356266L)  */;
    public static final String i = "支持多选聊天消息后转发到朋友圈编辑" /* "支持多选聊天消息后转发到朋友圈编辑" /* "支持多选聊天消息后转发到朋友圈编辑" /* cnb.z(-512874929716010L)  */;

    @Override // me.hd.wauxv.obf.bnq
    public final List a(ArrayList arrayList) {
        if (!z()) {
            return EmptyReadonlyList.INSTANCE;
        }
        ArrayList arrayList2 = new ArrayList();
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (((MsgInfoBean) it.next()).isText()) {
                    arrayList2.add(new cev(R.id.MenuItem_MoreBtnBar_TextForward, "文本转圈" /* "文本转圈" /* "文本转圈" /* cnb.z(-512475497757482L)  */,
                            new cbk(7)));
                    break;
                }
            }
        }
        if (!arrayList.isEmpty()) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                if (((MsgInfoBean) it2.next()).isImage()) {
                    arrayList2.add(new cev(R.id.MenuItem_MoreBtnBar_ImageForward, "图片转圈" /* "图片转圈" /* "图片转圈" /* cnb.z(-512419663182634L)  */,
                            new cbk(8)));
                    break;
                }
            }
        }
        if (!arrayList.isEmpty()) {
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                if (((MsgInfoBean) it3.next()).isVideo()) {
                    arrayList2.add(new cev(R.id.MenuItem_MoreBtnBar_VideoForward, "视频转圈" /* "视频转圈" /* "视频转圈" /* cnb.z(-512381008476970L)  */,
                            new cbk(9)));
                    break;
                }
            }
        }
        return arrayList2;
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
