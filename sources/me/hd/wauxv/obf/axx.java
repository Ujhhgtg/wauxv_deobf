package me.hd.wauxv.obf;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class axx extends AnimatorListenerAdapter implements elk {
    public final View a;
    public boolean b = false;

    public axx(View view) {
        this.a = view;
    }

    @Override // me.hd.wauxv.obf.elk
    public final void c(ell ellVar) {
    }

    @Override // me.hd.wauxv.obf.elk
    public final void d() {
        View view = this.a;
        view.setTag(R.id.transition_pause_alpha, Float.valueOf(view.getVisibility() == 0 ? eso.a.ab(view) : 0.0f));
    }

    @Override // me.hd.wauxv.obf.elk
    public final void e(ell ellVar) {
    }

    @Override // me.hd.wauxv.obf.elk
    public final void f() {
        this.a.setTag(R.id.transition_pause_alpha, null);
    }

    @Override // me.hd.wauxv.obf.elk
    public final void g(ell ellVar) {
    }

    @Override // me.hd.wauxv.obf.elk
    public final void h(ell ellVar) {
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        eso.a.af(this.a, 1.0f);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        onAnimationEnd(animator, false);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        View view = this.a;
        if (view.hasOverlappingRendering() && view.getLayerType() == 0) {
            this.b = true;
            view.setLayerType(2, null);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator, boolean z) {
        boolean z2 = this.b;
        View view = this.a;
        if (z2) {
            view.setLayerType(0, null);
        }
        if (z) {
            return;
        }
        est estVar = eso.a;
        estVar.af(view, 1.0f);
        estVar.getClass();
    }
}
