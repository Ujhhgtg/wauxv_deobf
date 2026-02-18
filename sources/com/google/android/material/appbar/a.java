package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ CoordinatorLayout a;
    public final /* synthetic */ AppBarLayout b;
    public final /* synthetic */ AppBarLayout.BaseBehavior c;

    public a(CoordinatorLayout coordinatorLayout, AppBarLayout.BaseBehavior baseBehavior, AppBarLayout appBarLayout) {
        this.c = baseBehavior;
        this.a = coordinatorLayout;
        this.b = appBarLayout;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.c.ad(this.a, this.b, ((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
