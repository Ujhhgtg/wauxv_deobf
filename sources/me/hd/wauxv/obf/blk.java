package me.hd.wauxv.obf;

import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import me.hd.wauxv.data.bean.MsgInfoBean;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class blk extends SwitchHook implements bnc {
    public static final blk a = new blk("HideMsgAvatarIVHook" /* "HideMsgAvatarIVHook" /* "HideMsgAvatarIVHook" /* cnb.z(-487281219599146L)  */);
    public static final String b = "净化" /* "净化" /* "净化" /* cnb.z(-487143780645674L)  */;
    public static final String c = "隐藏消息头像" /* "隐藏消息头像" /* "隐藏消息头像" /* cnb.z(-487148075612970L)  */;
    public static final String h = "自定义隐藏微信聊天列表中的头像布局" /* "自定义隐藏微信聊天列表中的头像布局" /* "自定义隐藏微信聊天列表中的头像布局" /* cnb.z(-487118010841898L)  */;
    public static final bep j = new bep(17);

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

    @Override // me.hd.wauxv.obf.bnc
    public final void i(View view, Object obj, Object obj2, MsgInfoBean msgInfoBean) {
        if (getIsEnabled()) {
            int i = 0;
            FieldResolver fieldResolverVarR = dqc.getWrapperConfiguration(obj).r();
            fieldResolverVarR.name = "avatarIV" /* "avatarIV" /* "avatarIV" /* cnb.z(-487160960514858L)  */;
            ImageView imageView = (ImageView) ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR)).getValue_();
            if (imageView != null) {
                boolean zIsSend = msgInfoBean.isSend();
                boolean z = bli.a.i() && !zIsSend;
                boolean z2 = blj.a.i() && zIsSend;
                if (z || z2) {
                    imageView.setVisibility(8);
                    ViewParent parent = imageView.getParent();
                    RelativeLayout relativeLayout = parent instanceof RelativeLayout ? (RelativeLayout) parent : null;
                    if (relativeLayout == null) {
                        return;
                    }
                    relativeLayout.getLayoutParams().width = 0;
                }
            }
        }
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return h;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final IInvokable getOnClick() {
        return j;
    }
}
