package me.hd.wauxv.obf;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aku extends AnimatorListenerAdapter {
    public final /* synthetic */ int a;
    public final /* synthetic */ akv b;
    public final /* synthetic */ ViewPropertyAnimator c;
    public final /* synthetic */ View d;
    public final /* synthetic */ akx e;

    public /* synthetic */ aku(akx akxVar, akv akvVar, ViewPropertyAnimator viewPropertyAnimator, View view, int i) {
        this.a = i;
        this.e = akxVar;
        this.b = akvVar;
        this.c = viewPropertyAnimator;
        this.d = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.a) {
            case 0:
                this.c.setListener(null);
                View view = this.d;
                view.setAlpha(1.0f);
                view.setTranslationX(0.0f);
                view.setTranslationY(0.0f);
                akv akvVar = this.b;
                czx czxVar = akvVar.a;
                akx akxVar = this.e;
                akxVar.ae(czxVar);
                akxVar.m.remove(akvVar.a);
                akxVar.t();
                break;
            default:
                this.c.setListener(null);
                View view2 = this.d;
                view2.setAlpha(1.0f);
                view2.setTranslationX(0.0f);
                view2.setTranslationY(0.0f);
                akv akvVar2 = this.b;
                czx czxVar2 = akvVar2.b;
                akx akxVar2 = this.e;
                akxVar2.ae(czxVar2);
                akxVar2.m.remove(akvVar2.b);
                akxVar2.t();
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.a) {
            case 0:
                czx czxVar = this.b.a;
                this.e.getClass();
                break;
            default:
                czx czxVar2 = this.b.b;
                this.e.getClass();
                break;
        }
    }
}
