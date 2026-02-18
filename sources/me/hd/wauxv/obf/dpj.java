package me.hd.wauxv.obf;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dpj implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ View b;
    public final /* synthetic */ dpk c;

    public dpj(dpk dpkVar, View view, View view2) {
        this.c = dpkVar;
        this.a = view;
        this.b = view2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.c.f(this.a, this.b, valueAnimator.getAnimatedFraction());
    }
}
