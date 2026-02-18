package me.hd.wauxv.obf;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ayi extends AnimatorListenerAdapter {
    public boolean a = false;
    public final /* synthetic */ ayj b;

    public ayi(ayj ayjVar) {
        this.b = ayjVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        if (this.a) {
            this.a = false;
            return;
        }
        ayj ayjVar = this.b;
        if (((Float) ayjVar.ac.getAnimatedValue()).floatValue() == 0.0f) {
            ayjVar.ad = 0;
            ayjVar.al(0);
        } else {
            ayjVar.ad = 2;
            ayjVar.v.invalidate();
        }
    }
}
