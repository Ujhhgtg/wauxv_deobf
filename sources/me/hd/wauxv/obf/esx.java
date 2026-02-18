package me.hd.wauxv.obf;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class esx extends AnimatorListenerAdapter implements elk {
    public final View a;
    public final int b;
    public final ViewGroup i;
    public boolean k;
    public boolean l = false;
    public final boolean j = true;

    public esx(View view, int i) {
        this.a = view;
        this.b = i;
        this.i = (ViewGroup) view.getParent();
        m(true);
    }

    @Override // me.hd.wauxv.obf.elk
    public final void c(ell ellVar) {
    }

    @Override // me.hd.wauxv.obf.elk
    public final void d() {
        m(false);
        if (this.l) {
            return;
        }
        eso.d(this.a, this.b);
    }

    @Override // me.hd.wauxv.obf.elk
    public final void e(ell ellVar) {
        ellVar.n(this);
    }

    @Override // me.hd.wauxv.obf.elk
    public final void f() {
        m(true);
        if (this.l) {
            return;
        }
        eso.d(this.a, 0);
    }

    @Override // me.hd.wauxv.obf.elk
    public final void g(ell ellVar) {
    }

    public final void m(boolean z) {
        ViewGroup viewGroup;
        if (!this.j || this.k == z || (viewGroup = this.i) == null) {
            return;
        }
        this.k = z;
        dqc.bk(viewGroup, z);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.l = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        if (!this.l) {
            eso.d(this.a, this.b);
            ViewGroup viewGroup = this.i;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
        m(false);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator, boolean z) {
        if (z) {
            eso.d(this.a, 0);
            ViewGroup viewGroup = this.i;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator, boolean z) {
        if (z) {
            return;
        }
        if (!this.l) {
            eso.d(this.a, this.b);
            ViewGroup viewGroup = this.i;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
        m(false);
    }
}
