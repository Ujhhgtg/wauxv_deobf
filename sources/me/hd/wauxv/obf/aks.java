package me.hd.wauxv.obf;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aks extends AnimatorListenerAdapter {
    public final /* synthetic */ int a = 1;
    public final /* synthetic */ czx b;
    public final /* synthetic */ View c;
    public final /* synthetic */ ViewPropertyAnimator d;
    public final /* synthetic */ akx e;

    public aks(akx akxVar, czx czxVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.e = akxVar;
        this.b = czxVar;
        this.d = viewPropertyAnimator;
        this.c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.a) {
            case 1:
                this.c.setAlpha(1.0f);
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.a) {
            case 0:
                this.d.setListener(null);
                this.c.setAlpha(1.0f);
                akx akxVar = this.e;
                czx czxVar = this.b;
                akxVar.ae(czxVar);
                akxVar.l.remove(czxVar);
                akxVar.t();
                break;
            default:
                this.d.setListener(null);
                akx akxVar2 = this.e;
                czx czxVar2 = this.b;
                akxVar2.ae(czxVar2);
                akxVar2.j.remove(czxVar2);
                akxVar2.t();
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.a) {
            case 0:
                this.e.getClass();
                break;
            default:
                this.e.getClass();
                break;
        }
    }

    public aks(akx akxVar, czx czxVar, View view, ViewPropertyAnimator viewPropertyAnimator) {
        this.e = akxVar;
        this.b = czxVar;
        this.c = view;
        this.d = viewPropertyAnimator;
    }
}
