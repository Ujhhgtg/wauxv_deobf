package me.hd.wauxv.obf;

import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.internal.CheckableImageButton;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class zv extends awb {
    public final int a;
    public final int b;
    public final TimeInterpolator c;
    public final TimeInterpolator d;
    public EditText e;
    public final bq f;
    public final zs g;
    public AnimatorSet h;
    public ValueAnimator i;

    public zv(awa awaVar) {
        super(awaVar);
        this.f = new bq(this, 2);
        this.g = new zs(this, 0);
        this.a = ajn.ad(awaVar.getContext(), R.attr.motionDurationShort3, 100);
        this.b = ajn.ad(awaVar.getContext(), R.attr.motionDurationShort3, 150);
        this.c = ajn.ae(awaVar.getContext(), R.attr.motionEasingLinearInterpolator, ff.a);
        this.d = ajn.ae(awaVar.getContext(), R.attr.motionEasingEmphasizedInterpolator, ff.d);
    }

    @Override // me.hd.wauxv.obf.awb
    public final void j() {
        if (this.ag.p != null) {
            return;
        }
        t(u());
    }

    @Override // me.hd.wauxv.obf.awb
    public final int k() {
        return R.string.clear_text_end_icon_content_description;
    }

    @Override // me.hd.wauxv.obf.awb
    public final int l() {
        return R.drawable.mtrl_ic_cancel;
    }

    @Override // me.hd.wauxv.obf.awb
    public final View.OnFocusChangeListener m() {
        return this.g;
    }

    @Override // me.hd.wauxv.obf.awb
    public final View.OnClickListener n() {
        return this.f;
    }

    @Override // me.hd.wauxv.obf.awb
    public final View.OnFocusChangeListener o() {
        return this.g;
    }

    @Override // me.hd.wauxv.obf.awb
    public final void p(EditText editText) {
        this.e = editText;
        this.af.setEndIconVisible(u());
    }

    @Override // me.hd.wauxv.obf.awb
    public final void q(boolean z) {
        if (this.ag.p == null) {
            return;
        }
        t(z);
    }

    @Override // me.hd.wauxv.obf.awb
    public final void r() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(this.d);
        valueAnimatorOfFloat.setDuration(this.b);
        final int i = 1;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: me.hd.wauxv.obf.zt
            public final /* synthetic */ zv b;

            {
                this.b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i) {
                    case 0:
                        zv zvVar = this.b;
                        zvVar.getClass();
                        zvVar.ai.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        zv zvVar2 = this.b;
                        zvVar2.getClass();
                        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        CheckableImageButton checkableImageButton = zvVar2.ai;
                        checkableImageButton.setScaleX(fFloatValue);
                        checkableImageButton.setScaleY(fFloatValue);
                        break;
                }
            }
        });
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = this.c;
        valueAnimatorOfFloat2.setInterpolator(timeInterpolator);
        int i2 = this.a;
        valueAnimatorOfFloat2.setDuration(i2);
        final int i3 = 0;
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: me.hd.wauxv.obf.zt
            public final /* synthetic */ zv b;

            {
                this.b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i3) {
                    case 0:
                        zv zvVar = this.b;
                        zvVar.getClass();
                        zvVar.ai.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        zv zvVar2 = this.b;
                        zvVar2.getClass();
                        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        CheckableImageButton checkableImageButton = zvVar2.ai;
                        checkableImageButton.setScaleX(fFloatValue);
                        checkableImageButton.setScaleY(fFloatValue);
                        break;
                }
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        this.h = animatorSet;
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        this.h.addListener(new zu(this, i3));
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat3.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat3.setDuration(i2);
        valueAnimatorOfFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: me.hd.wauxv.obf.zt
            public final /* synthetic */ zv b;

            {
                this.b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i3) {
                    case 0:
                        zv zvVar = this.b;
                        zvVar.getClass();
                        zvVar.ai.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        zv zvVar2 = this.b;
                        zvVar2.getClass();
                        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        CheckableImageButton checkableImageButton = zvVar2.ai;
                        checkableImageButton.setScaleX(fFloatValue);
                        checkableImageButton.setScaleY(fFloatValue);
                        break;
                }
            }
        });
        this.i = valueAnimatorOfFloat3;
        valueAnimatorOfFloat3.addListener(new zu(this, i));
    }

    @Override // me.hd.wauxv.obf.awb
    public final void s() {
        EditText editText = this.e;
        if (editText != null) {
            editText.post(new dh(this, 2));
        }
    }

    public final void t(boolean z) {
        boolean z2 = this.ag.z() == z;
        if (z && !this.h.isRunning()) {
            this.i.cancel();
            this.h.start();
            if (z2) {
                this.h.end();
                return;
            }
            return;
        }
        if (z) {
            return;
        }
        this.h.cancel();
        this.i.start();
        if (z2) {
            this.i.end();
        }
    }

    public final boolean u() {
        EditText editText = this.e;
        if (editText != null) {
            return (editText.hasFocus() || this.ai.hasFocus()) && this.e.getText().length() > 0;
        }
        return false;
    }
}
