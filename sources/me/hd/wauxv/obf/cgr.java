package me.hd.wauxv.obf;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.List;
import java.util.Locale;
import me.hd.wauxv.R;
import me.hd.wauxv.data.bean.MsgInfoBean;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cgr extends BaseHook implements bnb {
    public static final cgr c;
    public static final List h;
    public static final String i;
    public static final String j;
    public static final String l;
    public static final bzk m;

    static {
        "#11000000" /* cnb.z(-467653219056426L) */;
        "#FFFFFFFF" /* cnb.z(-467627449252650L) */;
        "#11FFFFFF" /* cnb.z(-467601679448874L) */;
        "#FFFFFFFF" /* cnb.z(-473554504121130L) */;
        "${time} | ${type}" /* cnb.z(-473528734317354L) */;
        "HH:mm:ss" /* cnb.z(-473468604775210L) */;
        c = new cgr("MsgInfoHook" /* cnb.z(-466643901741866L) */);
        h = aba.ag("${time}" /* cnb.z(-473429950069546L) */, "${type}" /* cnb.z(-473395590331178L) */, "${msgId}" /* cnb.z(-473361230592810L) */, "${msgSvrId}" /* cnb.z(-473889511570218L) */, "${atUserList}" /* cnb.z(-473803612224298L) */);
        i = "聊天" /* cnb.z(-473726302812970L) */;
        j = "消息底部详情" /* cnb.z(-473730597780266L) */;
        l = "为聊天列表项目的底部添加自定义文本" /* cnb.z(-473700533009194L) */;
        m = new bzk(23);
    }

    @Override // me.hd.wauxv.obf.bnb
    public final void a(ViewGroup viewGroup) {
        if (z()) {
            RelativeLayout relativeLayout = new RelativeLayout(viewGroup.getContext());
            relativeLayout.setVisibility(8);
            relativeLayout.setId(R.id.MsgInfo_RelativeLayout);
            TextView textView = new TextView(viewGroup.getContext());
            textView.setId(R.id.MsgInfo_TextView);
            relativeLayout.addView(textView);
            viewGroup.addView(relativeLayout);
        }
    }

    @Override // me.hd.wauxv.obf.bnb
    public final void b(Object obj, ViewGroup viewGroup, Object obj2, MsgInfoBean msgInfoBean) {
        String strZ;
        if (z()) {
            RelativeLayout relativeLayout = (RelativeLayout) viewGroup.findViewById(R.id.MsgInfo_RelativeLayout);
            if (msgInfoBean.getType() == ewg.t.w) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            relativeLayout.setVisibility(0);
            if (msgInfoBean.isSend()) {
                layoutParams.addRule(11);
                layoutParams.setMarginEnd((int) cnh.r(Integer.valueOf(cgm.a.k()), relativeLayout.getContext()));
            } else {
                layoutParams.addRule(9);
                layoutParams.setMarginStart((int) cnh.r(Integer.valueOf(cgj.a.k()), relativeLayout.getContext()));
            }
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.MsgLeftSwipe_SwipeMenu);
            cgr cgrVar = c;
            if (viewGroup2 != null) {
                layoutParams.addRule(3, viewGroup2.getId());
            } else {
                cgrVar.getClass();
                View viewV = cnh.v(viewGroup, cnb.ac(ewh.r) ? "c0g"
                        /* cnb.z(-467872262388522L) */ : cnb.ac(ewh.q) ? "bzy"
                                /* cnb.z(-468370478594858L) */ : cnb.ac(ewh.o) ? "byw"
                                        /* cnb.z(-468387658464042L) */ : cnb.ac(ewh.n) ? "bxy"
                                                /* cnb.z(-468336118856490L) */ : cnb.ac(ewh.m) ? "bx_"
                                                        /* cnb.z(-468353298725674L) */ : cnb.ac(ewh.l) ? "bw0"
                                                                /* cnb.z(-468301759118122L) */ : cnb.ac(ewh.k) ? "bvg"
                                                                        /* cnb.z(-468318938987306L) */ : cnb.ac(ewh.j)
                                                                                ? "buz"
                                                                                /* cnb.z(-468267399379754L) */ : cnb
                                                                                        .ac(ewh.i)
                                                                                                ? "bu9"
                                                                                                /*
                                                                                                 * cnb.z(-
                                                                                                 * 468284579248938L)
                                                                                                 */ : cnb.ac(ewh.h)
                                                                                                        ? "btr"
                                                                                                        /*
                                                                                                         * cnb.z(-
                                                                                                         * 468233039641386L)
                                                                                                         */ : cnb.ac(
                                                                                                                ewh.g) ? "bvm"
                                                                                                                        /*
                                                                                                                         * cnb
                                                                                                                         * .
                                                                                                                         * z
                                                                                                                         * (
                                                                                                                         * -
                                                                                                                         * 468250219510570L)
                                                                                                                         */ : cnb
                                                                                                                                .ac(ewh.f)
                                                                                                                                        ? "bv7"
                                                                                                                                        /*
                                                                                                                                         * cnb
                                                                                                                                         * .
                                                                                                                                         * z
                                                                                                                                         * (
                                                                                                                                         * -
                                                                                                                                         * 468198679903018L)
                                                                                                                                         */ : cnb
                                                                                                                                                .ac(ewh.e)
                                                                                                                                                        ? "br2"
                                                                                                                                                        /*
                                                                                                                                                         * cnb
                                                                                                                                                         * .
                                                                                                                                                         * z
                                                                                                                                                         * (
                                                                                                                                                         * -
                                                                                                                                                         * 468215859772202L)
                                                                                                                                                         */ : cnb
                                                                                                                                                                .ac(ewh.d)
                                                                                                                                                                        ? "bqh"
                                                                                                                                                                        /*
                                                                                                                                                                         * cnb
                                                                                                                                                                         * .
                                                                                                                                                                         * z
                                                                                                                                                                         * (
                                                                                                                                                                         * -
                                                                                                                                                                         * 468164320164650L)
                                                                                                                                                                         */ : cnb
                                                                                                                                                                                .ac(ewh.c)
                                                                                                                                                                                        ? "bm8"
                                                                                                                                                                                        /*
                                                                                                                                                                                         * cnb
                                                                                                                                                                                         * .
                                                                                                                                                                                         * z
                                                                                                                                                                                         * (
                                                                                                                                                                                         * -
                                                                                                                                                                                         * 468181500033834L)
                                                                                                                                                                                         */ : cnb
                                                                                                                                                                                                .ac(ewh.b)
                                                                                                                                                                                                        ? "bi0"
                                                                                                                                                                                                        /*
                                                                                                                                                                                                         * cnb
                                                                                                                                                                                                         * .
                                                                                                                                                                                                         * z
                                                                                                                                                                                                         * (
                                                                                                                                                                                                         * -
                                                                                                                                                                                                         * 468129960426282L)
                                                                                                                                                                                                         */ : cnb
                                                                                                                                                                                                                .ac(ewh.a)
                                                                                                                                                                                                                        ? "bdv"
                                                                                                                                                                                                                        /*
                                                                                                                                                                                                                         * cnb
                                                                                                                                                                                                                         * .
                                                                                                                                                                                                                         * z
                                                                                                                                                                                                                         * (
                                                                                                                                                                                                                         * -
                                                                                                                                                                                                                         * 468147140295466L)
                                                                                                                                                                                                                         */ : cnb
                                                                                                                                                                                                                                .ab(ewk.c)
                                                                                                                                                                                                                                        ? "bkj"
                                                                                                                                                                                                                                        /*
                                                                                                                                                                                                                                         * cnb
                                                                                                                                                                                                                                         * .
                                                                                                                                                                                                                                         * z
                                                                                                                                                                                                                                         * (
                                                                                                                                                                                                                                         * -
                                                                                                                                                                                                                                         * 467545844874026L)
                                                                                                                                                                                                                                         */ : "b4_" /*
                                                                                                                                                                                                                                                     * cnb
                                                                                                                                                                                                                                                     * .
                                                                                                                                                                                                                                                     * z
                                                                                                                                                                                                                                                     * (
                                                                                                                                                                                                                                                     * -
                                                                                                                                                                                                                                                     * 467563024743210L)
                                                                                                                                                                                                                                                     */);
                if (viewV != null) {
                    layoutParams.addRule(3, viewV.getId());
                }
            }
            relativeLayout.setLayoutParams(layoutParams);
            TextView textView = (TextView) viewGroup.findViewById(R.id.MsgInfo_TextView);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            if (cnh.aa(textView.getContext())) {
                gradientDrawable.setColor(Color.parseColor(cgg.a.o()));
                textView.setTextColor(Color.parseColor(cgh.a.o()));
            } else {
                gradientDrawable.setColor(Color.parseColor(cgk.a.o()));
                textView.setTextColor(Color.parseColor(cgl.a.o()));
            }
            gradientDrawable.setCornerRadius(5.0f);
            textView.setBackground(gradientDrawable);
            int iR = (int) cnh.r(5, textView.getContext());
            textView.setPadding(iR, iR, iR, iR);
            cgrVar.getClass();
            String strBo = dnr.bo(cgp.a.o(), "${time}" /* cnb.z(-466626721872682L) */,
                    cnh.ag(msgInfoBean.getCreateTime(), cgq.a.o(), null, 2));
            String strZ2 = "${type}" /* cnb.z(-466592362134314L) */;
            String strZ3 = "0x" /* cnb.z(-466558002395946L) */;
            int type = msgInfoBean.getType();
            cmz.o(16);
            String string = Integer.toString(type, 16);
            throwIfVar1IsNull(string, "toString(...)" /* cnb.z(-466510757755690L) */);
            String upperCase = string.toUpperCase(Locale.ROOT);
            throwIfVar1IsNull(upperCase, "toUpperCase(...)" /* cnb.z(-466502167821098L) */);
            String strBo2 = dnr.bo(
                    dnr.bo(dnr.bo(strBo, strZ2, strZ3.concat(upperCase)), "${msgId}" /* cnb.z(-468078420818730L) */,
                            String.valueOf(msgInfoBean.getMsgId())),
                    "${msgSvrId}" /* cnb.z(-467988226505514L) */, String.valueOf(msgInfoBean.getMsgSvrId()));
            String strZ4 = "${atUserList}" /* cnb.z(-467971046636330L) */;
            if (msgInfoBean.getAtUserList().isEmpty()) {
                strZ = "" /* cnb.z(-467876557355818L) */;
            } else if (msgInfoBean.isAnnounceAll()) {
                strZ = "@群公告" /* cnb.z(-467893737225002L) */;
            } else if (msgInfoBean.isNotifyAll()) {
                strZ = "@全体" /* cnb.z(-467906622126890L) */;
            } else if (msgInfoBean.isAtMe()) {
                strZ = "@我" /* cnb.z(-467855082519338L) */;
            } else {
                strZ = "@" + msgInfoBean.getAtUserList().size() + (char) 20154;
            }
            textView.setText(dnr.bo(strBo2, strZ4, strZ));
            Integer numValueOf = Integer.valueOf(cgi.a.k());
            Context context = textView.getContext();
            textView.setTextSize((numValueOf.floatValue() * context.getResources().getDisplayMetrics().density)
                    / context.getResources().getDisplayMetrics().scaledDensity);
            relativeLayout.setOnClickListener(new bq(msgInfoBean, 11));
        }
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getName() {
        return j;
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getCategory() {
        return i;
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getDescription() {
        return l;
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final bgf p() {
        return m;
    }
}
