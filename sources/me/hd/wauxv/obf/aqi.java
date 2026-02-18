package me.hd.wauxv.obf;

import android.animation.ValueAnimator;
import android.view.Choreographer;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class aqi implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ aqi(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float f;
        switch (this.a) {
            case 0:
                aql aqlVar = (aql) this.b;
                aqlVar.getClass();
                aqlVar.ai.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
            case 1:
                cao caoVar = (cao) this.b;
                caoVar.getClass();
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                caoVar.l.setAlpha((int) (255.0f * fFloatValue));
                caoVar.z = fFloatValue;
                break;
            case 2:
                ccz cczVar = (ccz) this.b;
                bzo.q(valueAnimator, "it");
                Choreographer.getInstance().postFrameCallback(new ccy(cczVar));
                break;
            case 3:
                crk crkVar = (crk) this.b;
                bzo.q(valueAnimator, "animation");
                Object animatedValue = valueAnimator.getAnimatedValue();
                bzo.o(animatedValue, "null cannot be cast to non-null type kotlin.Float");
                float fFloatValue2 = ((Float) animatedValue).floatValue();
                crkVar.m = fFloatValue2;
                float f2 = 1.0f;
                float f3 = 0.0f;
                if (fFloatValue2 > 0.5f) {
                    f3 = (fFloatValue2 - 0.5f) * 2.0f;
                    f = 0.0f;
                } else if (fFloatValue2 > 0.33f) {
                    f2 = (fFloatValue2 - 0.33f) * 6.0f;
                    f = 0.0f;
                } else {
                    f = 1.0f - (fFloatValue2 * 3.0f);
                    f2 = 0.0f;
                }
                crkVar.k = crkVar.h.getInterpolation(f2) * 0.8f;
                crkVar.f = crkVar.i.getInterpolation(f3) * 45;
                crkVar.l = crkVar.j.getInterpolation(f);
                crkVar.invalidateSelf();
                break;
            case 4:
                don donVar = (don) this.b;
                Object animatedValue2 = valueAnimator.getAnimatedValue();
                bzo.o(animatedValue2, "null cannot be cast to non-null type kotlin.Int" /* cnb.z(-412982580345642L) */);
                donVar.scrollTo(((Integer) animatedValue2).intValue(), 0);
                break;
            default:
                ((View) ((eut) ((eru) this.b).a).as.getParent()).invalidate();
                break;
        }
    }

    public /* synthetic */ aqi(eru eruVar, View view) {
        this.a = 5;
        this.b = eruVar;
    }
}
