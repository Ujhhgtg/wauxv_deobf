package me.hd.wauxv.obf;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.dx.io.Opcodes;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.WeakHashMap;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bpc {
    public final int a;
    public ColorStateList aa;
    public Typeface ab;
    public final int b;
    public final int c;
    public final TimeInterpolator d;
    public final TimeInterpolator e;
    public final TimeInterpolator f;
    public final Context g;
    public final TextInputLayout h;
    public LinearLayout i;
    public int j;
    public FrameLayout k;
    public AnimatorSet l;
    public final float m;
    public int n;
    public int o;
    public CharSequence p;
    public boolean q;
    public jp r;
    public CharSequence s;
    public int t;
    public int u;
    public ColorStateList v;
    public CharSequence w;
    public boolean x;
    public jp y;
    public int z;

    public bpc(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.g = context;
        this.h = textInputLayout;
        this.m = context.getResources().getDimensionPixelSize(R.dimen.design_textinput_caption_translate_y);
        this.a = ajn.ad(context, R.attr.motionDurationShort4, Opcodes.RSUB_INT_LIT8);
        this.b = ajn.ad(context, R.attr.motionDurationMedium4, 167);
        this.c = ajn.ad(context, R.attr.motionDurationShort4, 167);
        this.d = ajn.ae(context, R.attr.motionEasingEmphasizedDecelerateInterpolator, ff.d);
        LinearInterpolator linearInterpolator = ff.a;
        this.e = ajn.ae(context, R.attr.motionEasingEmphasizedDecelerateInterpolator, linearInterpolator);
        this.f = ajn.ae(context, R.attr.motionEasingLinearInterpolator, linearInterpolator);
    }

    public final void ac(jp jpVar, int i) {
        if (this.i == null && this.k == null) {
            Context context = this.g;
            LinearLayout linearLayout = new LinearLayout(context);
            this.i = linearLayout;
            linearLayout.setOrientation(0);
            LinearLayout linearLayout2 = this.i;
            TextInputLayout textInputLayout = this.h;
            textInputLayout.addView(linearLayout2, -1, -2);
            this.k = new FrameLayout(context);
            this.i.addView(this.k, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (textInputLayout.getEditText() != null) {
                ad();
            }
        }
        if (i == 0 || i == 1) {
            this.k.setVisibility(0);
            this.k.addView(jpVar);
        } else {
            this.i.addView(jpVar, new LinearLayout.LayoutParams(-2, -2));
        }
        this.i.setVisibility(0);
        this.j++;
    }

    public final void ad() {
        if (this.i != null) {
            TextInputLayout textInputLayout = this.h;
            if (textInputLayout.getEditText() != null) {
                EditText editText = textInputLayout.getEditText();
                Context context = this.g;
                boolean zAd = cnb.ad(context);
                LinearLayout linearLayout = this.i;
                WeakHashMap weakHashMap = eqz.a;
                int paddingStart = editText.getPaddingStart();
                if (zAd) {
                    paddingStart = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_horizontal);
                }
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_default_padding_top);
                if (zAd) {
                    dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_top);
                }
                int paddingEnd = editText.getPaddingEnd();
                if (zAd) {
                    paddingEnd = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_horizontal);
                }
                linearLayout.setPaddingRelative(paddingStart, dimensionPixelSize, paddingEnd, 0);
            }
        }
    }

    public final void ae() {
        AnimatorSet animatorSet = this.l;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public final void af(ArrayList arrayList, boolean z, jp jpVar, int i, int i2, int i3) {
        if (jpVar == null || !z) {
            return;
        }
        if (i == i3 || i == i2) {
            boolean z2 = i3 == i;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(jpVar, (Property<jp, Float>) View.ALPHA, z2 ? 1.0f : 0.0f);
            int i4 = this.c;
            objectAnimatorOfFloat.setDuration(z2 ? this.b : i4);
            objectAnimatorOfFloat.setInterpolator(z2 ? this.e : this.f);
            if (i == i3 && i2 != 0) {
                objectAnimatorOfFloat.setStartDelay(i4);
            }
            arrayList.add(objectAnimatorOfFloat);
            if (i3 != i || i2 == 0) {
                return;
            }
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(jpVar, (Property<jp, Float>) View.TRANSLATION_Y, -this.m, 0.0f);
            objectAnimatorOfFloat2.setDuration(this.a);
            objectAnimatorOfFloat2.setInterpolator(this.d);
            objectAnimatorOfFloat2.setStartDelay(i4);
            arrayList.add(objectAnimatorOfFloat2);
        }
    }

    public final TextView ag(int i) {
        if (i == 1) {
            return this.r;
        }
        if (i != 2) {
            return null;
        }
        return this.y;
    }

    public final void ah() {
        this.p = null;
        ae();
        if (this.n == 1) {
            if (!this.x || TextUtils.isEmpty(this.w)) {
                this.o = 0;
            } else {
                this.o = 2;
            }
        }
        ak(this.n, this.o, aj(this.r, ""));
    }

    public final void ai(jp jpVar, int i) {
        FrameLayout frameLayout;
        LinearLayout linearLayout = this.i;
        if (linearLayout == null) {
            return;
        }
        if ((i == 0 || i == 1) && (frameLayout = this.k) != null) {
            frameLayout.removeView(jpVar);
        } else {
            linearLayout.removeView(jpVar);
        }
        int i2 = this.j - 1;
        this.j = i2;
        LinearLayout linearLayout2 = this.i;
        if (i2 == 0) {
            linearLayout2.setVisibility(8);
        }
    }

    public final boolean aj(jp jpVar, CharSequence charSequence) {
        WeakHashMap weakHashMap = eqz.a;
        TextInputLayout textInputLayout = this.h;
        if (textInputLayout.isLaidOut() && textInputLayout.isEnabled()) {
            return (this.o == this.n && jpVar != null && TextUtils.equals(jpVar.getText(), charSequence)) ? false : true;
        }
        return false;
    }

    public final void ak(int i, int i2, boolean z) {
        TextView textViewAg;
        TextView textViewAg2;
        bpc bpcVar = this;
        if (i == i2) {
            return;
        }
        if (z) {
            AnimatorSet animatorSet = new AnimatorSet();
            bpcVar.l = animatorSet;
            ArrayList arrayList = new ArrayList();
            bpcVar.af(arrayList, bpcVar.x, bpcVar.y, 2, i, i2);
            bpcVar.af(arrayList, bpcVar.q, bpcVar.r, 1, i, i2);
            int size = arrayList.size();
            long jMax = 0;
            for (int i3 = 0; i3 < size; i3++) {
                Animator animator = (Animator) arrayList.get(i3);
                jMax = Math.max(jMax, animator.getDuration() + animator.getStartDelay());
            }
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 0);
            valueAnimatorOfInt.setDuration(jMax);
            arrayList.add(0, valueAnimatorOfInt);
            animatorSet.playTogether(arrayList);
            bpa bpaVar = new bpa(this, i2, ag(i), i, bpcVar.ag(i2));
            bpcVar = this;
            animatorSet.addListener(bpaVar);
            animatorSet.start();
        } else if (i != i2) {
            if (i2 != 0 && (textViewAg2 = bpcVar.ag(i2)) != null) {
                textViewAg2.setVisibility(0);
                textViewAg2.setAlpha(1.0f);
            }
            if (i != 0 && (textViewAg = ag(i)) != null) {
                textViewAg.setVisibility(4);
                if (i == 1) {
                    textViewAg.setText((CharSequence) null);
                }
            }
            bpcVar.n = i2;
        }
        TextInputLayout textInputLayout = bpcVar.h;
        textInputLayout.cr();
        textInputLayout.cu(z, false);
        textInputLayout.cx();
    }
}
