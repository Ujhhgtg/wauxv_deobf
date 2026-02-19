package me.hd.wauxv.obf;

import android.graphics.Color;
import android.view.View;
import me.hd.wauxv.data.bean.MsgInfoBean;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class chh extends SwitchHook implements bnc {
    public static final chh a;
    public static final String b;
    public static final String c;
    public static final String h;
    public static final cgu j;

    static {
        "#FF000000" /* "#FF000000" /* "#FF000000" /* cnb.z(-455970908011306L)  */;
        "#FFFFFFFF" /* "#FFFFFFFF" /* "#FFFFFFFF" /* cnb.z(-455945138207530L)  */;
        a = new chh("MsgTvColorHook" /* "MsgTvColorHook" /* "MsgTvColorHook" /* cnb.z(-450224241769258L)  */);
        b = "美化" /* "美化" /* "美化" /* cnb.z(-455919368403754L)  */;
        c = "消息文本颜色" /* "消息文本颜色" /* "消息文本颜色" /* cnb.z(-455854943894314L)  */;
        h = "当前仅支持配置微信部分消息文本颜色" /* "当前仅支持配置微信部分消息文本颜色" /* "当前仅支持配置微信部分消息文本颜色" /* cnb.z(-455824879123242L)  */;
        j = new cgu(5);
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
        View viewV;
        int color;
        if (getIsEnabled()) {
            int type = msgInfoBean.getType();
            if ((type == ewg.a.w || type == ewg.k.w || type == ewg.r.w || type == ewg.s.w)
                    && (viewV = cnh.v(view, bhs.v())) != null) {
                int i = 0;
                MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(viewV).getMethodResolverBasedOnPreviouslyProvidedConfig();
                methodResolverVarT.name = "setTextColor" /* "setTextColor" /* "setTextColor" /* cnb.z(-450211356867370L)  */;
                MethodHookWrapper methodHookWrapperVar = (MethodHookWrapper) StaticHelpers6.resolveFirstMethod(methodResolverVarT);
                if (cnh.aa(viewV.getContext())) {
                    color = Color.parseColor((!msgInfoBean.isSend() ? chd.a : chf.a).o());
                } else {
                    color = Color.parseColor((!msgInfoBean.isSend() ? che.a : chg.a).o());
                }
                methodHookWrapperVar.e(Integer.valueOf(color));
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
