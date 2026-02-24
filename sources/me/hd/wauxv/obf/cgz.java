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
    public static final cgz c = new cgz("MsgLeftSwipeHook" /* "MsgLeftSwipeHook" /* "MsgLeftSwipeHook" /* "MsgLeftSwipeHook" /* cnb.z(-473030518111018L)   */);
    public static final String h = "聊天" /* "聊天" /* "聊天" /* "聊天" /* cnb.z(-473094942620458L)   */;
    public static final String i = "消息左滑引用" /* "消息左滑引用" /* "消息左滑引用" /* "消息左滑引用" /* cnb.z(-474696965421866L)   */;
    public static final String j = "可左滑选中以修复无法多选消息的问题" /* "可左滑选中以修复无法多选消息的问题" /* "可左滑选中以修复无法多选消息的问题" /* "可左滑选中以修复无法多选消息的问题" /* cnb.z(-474649720781610L)   */;

    @Override // me.hd.wauxv.obf.bnb
    public final void a(ViewGroup viewGroup) {
        if (getIsEnabled()) {
            View viewV = cnh.v(viewGroup, cnb.isNewerThanArgVerAndPlay(ewh.VER_8065) ? "c0g" : cnb.isNewerThanArgVerAndPlay(ewh.VER_8064) ? "bzy" : cnb.isNewerThanArgVerAndPlay(ewh.VER_8063) ? "byw" : cnb.isNewerThanArgVerAndPlay(ewh.VER_8061_PATCH) ? "bxy" : cnb.isNewerThanArgVerAndPlay(ewh.VER_8061) ? "bx_" : cnb.isNewerThanArgVerAndPlay(ewh.VER_8060) ? "bw0" : cnb.isNewerThanArgVerAndPlay(ewh.VER_8058) ? "bvg" : cnb.isNewerThanArgVerAndPlay(ewh.VER_8057) ? "buz" : cnb.isNewerThanArgVerAndPlay(ewh.VER_8056) ? "bu9" : cnb.isNewerThanArgVerAndPlay(ewh.h) ? "btr"  : cnb.isNewerThanArgVerAndPlay(ewh.g) ? "bvm" : cnb.isNewerThanArgVerAndPlay(ewh.f) : cnb.isNewerThanArgVerAndPlay(ewh.e) ? "br2" : cnb.isNewerThanArgVerAndPlay(ewh.d) ? "bqh" : cnb.isNewerThanArgVerAndPlay(ewh.c) ? "bm8" : cnb.isNewerThanArgVerAndPlay(ewh.b) ? "bi0" : cnb.isNewerThanArgVerAndPlay(ewh.a) ? "bdv" : cnb.isNewerThanArgVerAndNotPlay(ewk.c) ? "bkj" : "b4_");
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
