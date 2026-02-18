package me.hd.wauxv.obf;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class esy extends AnimatorListenerAdapter implements elk {
    public final ViewGroup a;
    public final View b;
    public final View i;
    public boolean j = true;
    public final /* synthetic */ axy k;

    public esy(axy axyVar, ViewGroup viewGroup, View view, View view2) {
        this.k = axyVar;
        this.a = viewGroup;
        this.b = view;
        this.i = view2;
    }

    @Override // me.hd.wauxv.obf.elk
    public final void c(ell ellVar) {
        if (this.j) {
            l();
        }
    }

    @Override // me.hd.wauxv.obf.elk
    public final void getArgs() {
    }

    @Override // me.hd.wauxv.obf.elk
    public final void e(ell ellVar) {
        ellVar.n(this);
    }

    @Override // me.hd.wauxv.obf.elk
    public final void getResult() {
    }

    @Override // me.hd.wauxv.obf.elk
    public final void g(ell ellVar) {
    }

    public final void l() {
        this.i.setTag(R.id.save_overlay_view, null);
        this.a.getOverlay().remove(this.b);
        this.j = false;
    }

    @Override // android.animation.AnimatorListenerAdapter,
              // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        l();
    }

    @Override // android.animation.AnimatorListenerAdapter,
              // android.animation.Animator.AnimatorPauseListener
    public final void onAnimationPause(Animator animator) {
        this.a.getOverlay().remove(this.b);
    }

    @Override // android.animation.AnimatorListenerAdapter,
              // android.animation.Animator.AnimatorPauseListener
    public final void onAnimationResume(Animator animator) {
        View view = this.b;
        if (view.getParent() == null) {
            this.a.getOverlay().add(view);
        } else {
            this.k.cancel();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator, boolean z) {
        if (z) {
            View view = this.i;
            View view2 = this.b;
            view.setTag(R.id.save_overlay_view, view2);
            this.a.getOverlay().add(view2);
            this.j = true;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator, boolean z) {
        if (z) {
            return;
        }
        l();
    }
}
