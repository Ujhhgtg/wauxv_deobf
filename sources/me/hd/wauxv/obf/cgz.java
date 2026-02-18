package me.hd.wauxv.obf;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import me.hd.wauxv.R;
import me.hd.wauxv.data.bean.MsgInfoBean;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cgz extends SwitchHook implements bnb {
    public static final cgz c = new cgz("MsgLeftSwipeHook" /* cnb.z(-473030518111018L) */);
    public static final String h = "聊天" /* cnb.z(-473094942620458L) */;
    public static final String i = "消息左滑引用" /* cnb.z(-474696965421866L) */;
    public static final String j = "可左滑选中以修复无法多选消息的问题" /* cnb.z(-474649720781610L) */;

    @Override // me.hd.wauxv.obf.bnb
    public final void a(ViewGroup viewGroup) {
        if (getIsEnabled()) {
            View viewV = cnh.v(viewGroup, cnb.ac(ewh.r) ? "c0g"
                    /* cnb.z(-472957503666986L) */ : cnb.ac(ewh.q) ? "bzy"
                            /* cnb.z(-472905964059434L) */ : cnb.ac(ewh.o) ? "byw"
                                    /* cnb.z(-472923143928618L) */ : cnb.ac(ewh.n) ? "bxy"
                                            /* cnb.z(-472871604321066L) */ : cnb.ac(ewh.m) ? "bx_"
                                                    /* cnb.z(-472888784190250L) */ : cnb.ac(ewh.l) ? "bw0"
                                                            /* cnb.z(-472837244582698L) */ : cnb.ac(ewh.k) ? "bvg"
                                                                    /* cnb.z(-472854424451882L) */ : cnb.ac(ewh.j)
                                                                            ? "buz"
                                                                            /* cnb.z(-472802884844330L) */ : cnb
                                                                                    .ac(ewh.i)
                                                                                            ? "bu9"
                                                                                            /*
                                                                                             * cnb.z(-472820064713514L)
                                                                                             */ : cnb.ac(ewh.h) ? "btr"
                                                                                                    /*
                                                                                                     * cnb.z(-
                                                                                                     * 473318280919850L)
                                                                                                     */ : cnb.ac(ewh.g)
                                                                                                            ? "bvm"
                                                                                                            /*
                                                                                                             * cnb.z(-
                                                                                                             * 473335460789034L)
                                                                                                             */ : cnb
                                                                                                                    .ac(ewh.f)
                                                                                                                            ? "bv7"
                                                                                                                            /*
                                                                                                                             * cnb
                                                                                                                             * .
                                                                                                                             * z
                                                                                                                             * (
                                                                                                                             * -
                                                                                                                             * 473283921181482L)
                                                                                                                             */ : cnb
                                                                                                                                    .ac(ewh.e)
                                                                                                                                            ? "br2"
                                                                                                                                            /*
                                                                                                                                             * cnb
                                                                                                                                             * .
                                                                                                                                             * z
                                                                                                                                             * (
                                                                                                                                             * -
                                                                                                                                             * 473301101050666L)
                                                                                                                                             */ : cnb
                                                                                                                                                    .ac(ewh.d)
                                                                                                                                                            ? "bqh"
                                                                                                                                                            /*
                                                                                                                                                             * cnb
                                                                                                                                                             * .
                                                                                                                                                             * z
                                                                                                                                                             * (
                                                                                                                                                             * -
                                                                                                                                                             * 473249561443114L)
                                                                                                                                                             */ : cnb
                                                                                                                                                                    .ac(ewh.c)
                                                                                                                                                                            ? "bm8"
                                                                                                                                                                            /*
                                                                                                                                                                             * cnb
                                                                                                                                                                             * .
                                                                                                                                                                             * z
                                                                                                                                                                             * (
                                                                                                                                                                             * -
                                                                                                                                                                             * 473266741312298L)
                                                                                                                                                                             */ : cnb
                                                                                                                                                                                    .ac(ewh.b)
                                                                                                                                                                                            ? "bi0"
                                                                                                                                                                                            /*
                                                                                                                                                                                             * cnb
                                                                                                                                                                                             * .
                                                                                                                                                                                             * z
                                                                                                                                                                                             * (
                                                                                                                                                                                             * -
                                                                                                                                                                                             * 473215201704746L)
                                                                                                                                                                                             */ : cnb
                                                                                                                                                                                                    .ac(ewh.a)
                                                                                                                                                                                                            ? "bdv"
                                                                                                                                                                                                            /*
                                                                                                                                                                                                             * cnb
                                                                                                                                                                                                             * .
                                                                                                                                                                                                             * z
                                                                                                                                                                                                             * (
                                                                                                                                                                                                             * -
                                                                                                                                                                                                             * 473232381573930L)
                                                                                                                                                                                                             */ : cnb
                                                                                                                                                                                                                    .ab(ewk.c)
                                                                                                                                                                                                                            ? "bkj"
                                                                                                                                                                                                                            /*
                                                                                                                                                                                                                             * cnb
                                                                                                                                                                                                                             * .
                                                                                                                                                                                                                             * z
                                                                                                                                                                                                                             * (
                                                                                                                                                                                                                             * -
                                                                                                                                                                                                                             * 473180841966378L)
                                                                                                                                                                                                                             */ : "b4_" /*
                                                                                                                                                                                                                                         * cnb
                                                                                                                                                                                                                                         * .
                                                                                                                                                                                                                                         * z
                                                                                                                                                                                                                                         * (
                                                                                                                                                                                                                                         * -
                                                                                                                                                                                                                                         * 473198021835562L)
                                                                                                                                                                                                                                         */);
            throwIfVar1IsNull(viewV);
            ViewParent parent = viewV.getParent();
            ViewGroup viewGroup2 = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup2 != null) {
                viewGroup2.removeView(viewV);
            }
            don donVar = new don(viewV.getContext());
            donVar.setLayoutParams(viewV.getLayoutParams());
            donVar.setId(R.id.MsgLeftSwipe_SwipeMenu);
            donVar.addView(viewV);
            FrameLayout frameLayout = new FrameLayout(donVar.getContext());
            frameLayout.setLayoutParams(new LinearLayout.LayoutParams((int) cnh.r(180, frameLayout.getContext()), -1));
            ImageView imageView = new ImageView(frameLayout.getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.setMargins((int) cnh.r(Double.valueOf(36.0d), imageView.getContext()),
                    ((ViewGroup.MarginLayoutParams) layoutParams).topMargin,
                    ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin,
                    ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
            imageView.setLayoutParams(layoutParams);
            imageView.setImageResource(R.drawable.ic_menu_quote_24dp);
            imageView.setImageTintList(emc.ai(
                    Color.parseColor(cnb.z(cnh.aa(imageView.getContext()) ? -473146482228010L : -473120712424234L))));
            frameLayout.addView(imageView);
            donVar.addView(frameLayout);
            viewGroup.addView(donVar);
        }
    }

    @Override // me.hd.wauxv.obf.bnb
    public final void b(Object obj, ViewGroup viewGroup, Object obj2, MsgInfoBean msgInfoBean) {
        don donVar;
        if (getIsEnabled() && (donVar = (don) viewGroup.findViewById(R.id.MsgLeftSwipe_SwipeMenu)) != null) {
            donVar.setSmoothListener(new chm(donVar, obj, msgInfoBean, obj2));
        }
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getName() {
        return i;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getCategory() {
        return h;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return j;
    }
}
