package me.hd.wauxv.obf;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import me.hd.wauxv.data.bean.MsgInfoBean;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cfv extends doo implements bnc {
    public static final cfv a;
    public static final String b;
    public static final String c;
    public static final String h;
    public static final bzk j;

    static {
        cnb.z(-448656578706218L);
        cnb.z(-448630808902442L);
        cnb.z(-449086075435818L);
        cnb.z(-449060305632042L);
        cnb.z(-449034535828266L);
        a = new cfv(cnb.z(-449395313081130L));
        b = cnb.z(-449008766024490L);
        c = cnb.z(-448961521384234L);
        h = cnb.z(-448914276743978L);
        j = new bzk(15);
    }

    public static void l(View view, boolean z) {
        int color;
        int color2;
        view.setPadding(32, 20, 32, 20);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        bzo.o(layoutParams, cnb.z(-449330888571690L));
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.leftMargin = 16;
        marginLayoutParams.rightMargin = 16;
        view.setLayoutParams(marginLayoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        int iR = (int) cnh.r(Float.valueOf(1.0f), view.getContext());
        if (cnh.aa(view.getContext())) {
            color = Color.parseColor((!z ? cfo.a : cfs.a).o());
        } else {
            color = Color.parseColor((!z ? cfq.a : cfu.a).o());
        }
        gradientDrawable.setStroke(iR, color);
        gradientDrawable.setCornerRadius(cnh.r(Float.valueOf(8.0f), view.getContext()));
        if (cnh.aa(view.getContext())) {
            color2 = Color.parseColor((!z ? cfn.a : cfr.a).o());
        } else {
            color2 = Color.parseColor((!z ? cfp.a : cft.a).o());
        }
        gradientDrawable.setColor(color2);
        view.setBackground(gradientDrawable);
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
    }

    @Override // me.hd.wauxv.obf.doo
    public final String f() {
        return c;
    }

    @Override // me.hd.wauxv.obf.doo
    public final String g() {
        return b;
    }

    @Override // me.hd.wauxv.obf.bnc
    public final void i(View view, Object obj, Object obj2, MsgInfoBean msgInfoBean) {
        if (z()) {
            int type = msgInfoBean.getType();
            if (type == ewg.a.w || type == ewg.k.w || type == ewg.r.w || type == ewg.s.w) {
                View viewV = cnh.v(view, bhs.v());
                if (viewV != null) {
                    l(viewV, msgInfoBean.isSend());
                    return;
                }
                return;
            }
            if (type != ewg.c.w) {
                if (type == ewg.i.w) {
                    View viewV2 = cnh.v(view, cnb.ab(ewk.c) ? cnb.z(-426915454253866L) : cnb.z(-428513182087978L));
                    if (viewV2 != null) {
                        l(viewV2, msgInfoBean.isSend());
                        return;
                    }
                    return;
                }
                return;
            }
            View viewV3 = cnh.v(view, bhs.w());
            if (viewV3 != null) {
                l(viewV3, msgInfoBean.isSend());
            }
            View viewV4 = cnh.v(view, bhs.x());
            if (viewV4 != null) {
                l(viewV4, msgInfoBean.isSend());
            }
            View viewV5 = cnh.v(view, bhs.y());
            if (viewV5 != null) {
                l(viewV5, msgInfoBean.isSend());
            }
        }
    }

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return h;
    }

    @Override // me.hd.wauxv.obf.doo
    public final bgf p() {
        return j;
    }
}
