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
public final class cgr extends doo implements bnb {
    public static final cgr c;
    public static final List h;
    public static final String i;
    public static final String j;
    public static final String l;
    public static final bzk m;

    static {
        cnb.z(-467653219056426L);
        cnb.z(-467627449252650L);
        cnb.z(-467601679448874L);
        cnb.z(-473554504121130L);
        cnb.z(-473528734317354L);
        cnb.z(-473468604775210L);
        c = new cgr(cnb.z(-466643901741866L));
        h = aba.ag(cnb.z(-473429950069546L), cnb.z(-473395590331178L), cnb.z(-473361230592810L), cnb.z(-473889511570218L), cnb.z(-473803612224298L));
        i = cnb.z(-473726302812970L);
        j = cnb.z(-473730597780266L);
        l = cnb.z(-473700533009194L);
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
                View viewV = cnh.v(viewGroup, cnb.ac(ewh.r) ? cnb.z(-467872262388522L) : cnb.ac(ewh.q) ? cnb.z(-468370478594858L) : cnb.ac(ewh.o) ? cnb.z(-468387658464042L) : cnb.ac(ewh.n) ? cnb.z(-468336118856490L) : cnb.ac(ewh.m) ? cnb.z(-468353298725674L) : cnb.ac(ewh.l) ? cnb.z(-468301759118122L) : cnb.ac(ewh.k) ? cnb.z(-468318938987306L) : cnb.ac(ewh.j) ? cnb.z(-468267399379754L) : cnb.ac(ewh.i) ? cnb.z(-468284579248938L) : cnb.ac(ewh.h) ? cnb.z(-468233039641386L) : cnb.ac(ewh.g) ? cnb.z(-468250219510570L) : cnb.ac(ewh.f) ? cnb.z(-468198679903018L) : cnb.ac(ewh.e) ? cnb.z(-468215859772202L) : cnb.ac(ewh.d) ? cnb.z(-468164320164650L) : cnb.ac(ewh.c) ? cnb.z(-468181500033834L) : cnb.ac(ewh.b) ? cnb.z(-468129960426282L) : cnb.ac(ewh.a) ? cnb.z(-468147140295466L) : cnb.ab(ewk.c) ? cnb.z(-467545844874026L) : cnb.z(-467563024743210L));
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
            String strBo = dnr.bo(cgp.a.o(), cnb.z(-466626721872682L), cnh.ag(msgInfoBean.getCreateTime(), cgq.a.o(), null, 2));
            String strZ2 = cnb.z(-466592362134314L);
            String strZ3 = cnb.z(-466558002395946L);
            int type = msgInfoBean.getType();
            cmz.o(16);
            String string = Integer.toString(type, 16);
            bzo.p(string, cnb.z(-466510757755690L));
            String upperCase = string.toUpperCase(Locale.ROOT);
            bzo.p(upperCase, cnb.z(-466502167821098L));
            String strBo2 = dnr.bo(dnr.bo(dnr.bo(strBo, strZ2, strZ3.concat(upperCase)), cnb.z(-468078420818730L), String.valueOf(msgInfoBean.getMsgId())), cnb.z(-467988226505514L), String.valueOf(msgInfoBean.getMsgSvrId()));
            String strZ4 = cnb.z(-467971046636330L);
            if (msgInfoBean.getAtUserList().isEmpty()) {
                strZ = cnb.z(-467876557355818L);
            } else if (msgInfoBean.isAnnounceAll()) {
                strZ = cnb.z(-467893737225002L);
            } else if (msgInfoBean.isNotifyAll()) {
                strZ = cnb.z(-467906622126890L);
            } else if (msgInfoBean.isAtMe()) {
                strZ = cnb.z(-467855082519338L);
            } else {
                strZ = "@" + msgInfoBean.getAtUserList().size() + (char) 20154;
            }
            textView.setText(dnr.bo(strBo2, strZ4, strZ));
            Integer numValueOf = Integer.valueOf(cgi.a.k());
            Context context = textView.getContext();
            textView.setTextSize((numValueOf.floatValue() * context.getResources().getDisplayMetrics().density) / context.getResources().getDisplayMetrics().scaledDensity);
            relativeLayout.setOnClickListener(new bq(msgInfoBean, 11));
        }
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
    }

    @Override // me.hd.wauxv.obf.doo
    public final String f() {
        return j;
    }

    @Override // me.hd.wauxv.obf.doo
    public final String g() {
        return i;
    }

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return l;
    }

    @Override // me.hd.wauxv.obf.doo
    public final bgf p() {
        return m;
    }
}
