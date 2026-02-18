package me.hd.wauxv.obf;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bqu implements Animator.AnimatorListener {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final czx e;
    public final int f;
    public final ValueAnimator g;
    public boolean h;
    public float i;
    public float j;
    public boolean k = false;
    public boolean l = false;
    public float m;
    public final /* synthetic */ int n;
    public final /* synthetic */ czx o;
    public final /* synthetic */ bqx p;

    public bqu(bqx bqxVar, czx czxVar, int i, float f, float f2, float f3, float f4, int i2, czx czxVar2) {
        this.p = bqxVar;
        this.n = i2;
        this.o = czxVar2;
        this.f = i;
        this.e = czxVar;
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.g = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new no(this, 6));
        valueAnimatorOfFloat.setTarget(czxVar.d);
        valueAnimatorOfFloat.addListener(this);
        this.m = 0.0f;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.m = 1.0f;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        q(animator);
        if (this.k) {
            return;
        }
        int i = this.n;
        czx czxVar = this.o;
        bqx bqxVar = this.p;
        if (i <= 0) {
            bqxVar.n.getClass();
            xe.g(czxVar);
        } else {
            bqxVar.a.add(czxVar.d);
            this.h = true;
            if (i > 0) {
                bqxVar.s.post(new cs(bqxVar, this, i));
            }
        }
        View view = bqxVar.x;
        View view2 = czxVar.d;
        if (view == view2) {
            bqxVar.ap(view2);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }

    public final void q(Animator animator) {
        if (!this.l) {
            this.e.al(true);
        }
        this.l = true;
    }
}
