package me.hd.wauxv.obf;

import android.animation.ValueAnimator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ccs implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ bfk b;

    public /* synthetic */ ccs(bfk bfkVar, int i) {
        this.a = i;
        this.b = bfkVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.a) {
            case 0:
                ((cct) this.b.ao).b.s(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
            default:
                ((cct) this.b.ao).b.s(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
        }
    }
}
