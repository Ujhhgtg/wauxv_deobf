package me.hd.wauxv.obf;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class akt extends AnimatorListenerAdapter {
    public final /* synthetic */ czx a;
    public final /* synthetic */ int b;
    public final /* synthetic */ View c;
    public final /* synthetic */ int d;
    public final /* synthetic */ ViewPropertyAnimator e;
    public final /* synthetic */ akx f;

    public akt(akx akxVar, czx czxVar, int i, View view, int i2, ViewPropertyAnimator viewPropertyAnimator) {
        this.f = akxVar;
        this.a = czxVar;
        this.b = i;
        this.c = view;
        this.d = i2;
        this.e = viewPropertyAnimator;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        int i = this.b;
        View view = this.c;
        if (i != 0) {
            view.setTranslationX(0.0f);
        }
        if (this.d != 0) {
            view.setTranslationY(0.0f);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.e.setListener(null);
        akx akxVar = this.f;
        czx czxVar = this.a;
        akxVar.ae(czxVar);
        akxVar.k.remove(czxVar);
        akxVar.t();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f.getClass();
    }
}
