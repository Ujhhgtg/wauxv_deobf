package me.hd.wauxv.obf;

import android.view.View;
import android.widget.TextView;
import me.hd.wauxv.data.bean.MsgInfoBean;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bcu extends SwitchHook implements bnc {
    public static final bcu a;
    public static final String b;
    public static final String c;
    public static final String h;
    public static final ayz j;

    static {
        "E HH:mm" /* "E HH:mm" /* "E HH:mm" /* cnb.z(-463680374307626L)  */;
        a = new bcu("FormatMsgTimeHook" /* "FormatMsgTimeHook" /* "FormatMsgTimeHook" /* cnb.z(-462147070982954L)  */);
        b = "净化" /* "净化" /* "净化" /* cnb.z(-463646014569258L)  */;
        c = "格式消息时间" /* "格式消息时间" /* "格式消息时间" /* cnb.z(-463598769929002L)  */;
        h = "自定义聊天项顶部时间是否显示与格式" /* "自定义聊天项顶部时间是否显示与格式" /* "自定义聊天项顶部时间是否显示与格式" /* cnb.z(-463551525288746L)  */;
        j = new ayz(29);
    }

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
            fieldResolverVarR.name = "timeTV" /* "timeTV" /* "timeTV" /* cnb.z(-462086941440810L)  */;
            TextView textView = (TextView) ((azk) yg.e(fieldResolverVarR)).e();
            int iK = bcs.a.k();
            if (iK == bcr.a.e) {
                if (textView != null) {
                    textView.setVisibility(8);
                }
            } else if (iK == bcr.c.e && textView != null) {
                textView.setVisibility(0);
            }
            if (textView != null) {
                textView.setText(cnh.ag(msgInfoBean.getCreateTime(), bct.a.o(), null, 2));
            }
        }
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return h;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final bgf getOnClick() {
        return j;
    }
}
