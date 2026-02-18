package com.google.android.material.behavior;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.android.dx.io.Opcodes;
import java.util.Iterator;
import java.util.LinkedHashSet;
import me.hd.wauxv.R;
import me.hd.wauxv.obf.agr;
import me.hd.wauxv.obf.ajn;
import me.hd.wauxv.obf.ci;
import me.hd.wauxv.obf.ff;
import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends agr {
    public ViewPropertyAnimator _r;
    public int f;
    public int g;
    public TimeInterpolator h;
    public TimeInterpolator q;
    public final LinkedHashSet a = new LinkedHashSet();
    public int r = 0;
    public int s = 2;

    public HideBottomViewOnScrollBehavior() {
    }

    @Override // me.hd.wauxv.obf.agr
    public boolean i(CoordinatorLayout coordinatorLayout, View view, int i) {
        this.r = view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
        this.f = ajn.ad(view.getContext(), R.attr.motionDurationLong2, Opcodes.SHR_INT_LIT8);
        this.g = ajn.ad(view.getContext(), R.attr.motionDurationMedium4, 175);
        this.h = ajn.ae(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, ff.d);
        this.q = ajn.ae(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, ff.c);
        return false;
    }

    @Override // me.hd.wauxv.obf.agr
    public final void l(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int[] iArr) {
        LinkedHashSet linkedHashSet = this.a;
        if (i > 0) {
            if (this.s == 1) {
                return;
            }
            ViewPropertyAnimator viewPropertyAnimator = this._r;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
                view.clearAnimation();
            }
            this.s = 1;
            Iterator it = linkedHashSet.iterator();
            if (it.hasNext()) {
                throw yg.d(it);
            }
            this._r = view.animate().translationY(this.r).setInterpolator(this.q).setDuration(this.g).setListener(new ci(this, 4));
            return;
        }
        if (i >= 0 || this.s == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator2 = this._r;
        if (viewPropertyAnimator2 != null) {
            viewPropertyAnimator2.cancel();
            view.clearAnimation();
        }
        this.s = 2;
        Iterator it2 = linkedHashSet.iterator();
        if (it2.hasNext()) {
            throw yg.d(it2);
        }
        this._r = view.animate().translationY(0).setInterpolator(this.h).setDuration(this.f).setListener(new ci(this, 4));
    }

    @Override // me.hd.wauxv.obf.agr
    public boolean o(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2) {
        return i == 2;
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
    }
}
