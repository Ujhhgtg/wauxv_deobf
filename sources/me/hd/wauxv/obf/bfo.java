package me.hd.wauxv.obf;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import com.kongzue.dialogx.util.views.ActivityScreenShotImageView;
import com.kongzue.dialogx.util.views.DialogXBaseRelativeLayout;
import com.kongzue.dialogx.util.views.MaxRelativeLayout;
import java.lang.ref.WeakReference;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bfo {
    public bfr a;
    public final ActivityScreenShotImageView b;
    public final DialogXBaseRelativeLayout c;
    public final RelativeLayout d;
    public final MaxRelativeLayout e;
    public final RelativeLayout f;
    public final dfa g;
    public float h;
    public int i;
    public final Rect j;
    public boolean k;
    public final /* synthetic */ bfp l;

    public bfo(bfp bfpVar, View view) {
        GradientDrawable gradientDrawable;
        bfp bfpVar2 = bfpVar.bf;
        this.l = bfpVar;
        this.h = -1.0f;
        int i = 0;
        this.j = new Rect(0, 0, 0, 0);
        int i2 = 1;
        this.k = true;
        if (view == null) {
            return;
        }
        bfpVar.g = new WeakReference(view);
        ActivityScreenShotImageView activityScreenShotImageView = (ActivityScreenShotImageView) view.findViewById(R.id.img_zoom_activity);
        this.b = activityScreenShotImageView;
        DialogXBaseRelativeLayout dialogXBaseRelativeLayout = (DialogXBaseRelativeLayout) view.findViewById(R.id.box_root);
        this.c = dialogXBaseRelativeLayout;
        this.d = (RelativeLayout) view.findViewById(R.id.box_bkg);
        MaxRelativeLayout maxRelativeLayout = (MaxRelativeLayout) view.findViewById(R.id.bkg);
        this.e = maxRelativeLayout;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.box_custom);
        this.f = relativeLayout;
        activityScreenShotImageView.getClass();
        activityScreenShotImageView.i = bfpVar;
        view.setBackgroundResource(R.color.black);
        activityScreenShotImageView.setVisibility(0);
        dialogXBaseRelativeLayout.t(bfpVar2);
        bfpVar.ar().setTranslationZ(0);
        dialogXBaseRelativeLayout.g = new bfl(this, i);
        dialogXBaseRelativeLayout.h = new bfm(this);
        bfo bfoVar = bfpVar.bg;
        bfr bfrVar = new bfr();
        bfrVar.a = false;
        bfrVar.d(bfpVar2, bfoVar);
        this.a = bfrVar;
        dialogXBaseRelativeLayout.s(0.0f);
        dialogXBaseRelativeLayout.post(new bfn(this, i));
        dialogXBaseRelativeLayout.b = new bfm(this);
        maxRelativeLayout.i = new bfm(this);
        int i3 = 2;
        relativeLayout.addOnLayoutChangeListener(new pw(this, i3));
        bfpVar.bg = this;
        Activity activityAs = bfpVar.as();
        or orVar = bfpVar.ba;
        if (activityAs == null) {
            return;
        }
        dialogXBaseRelativeLayout.d = bfpVar.k;
        int[] iArr = bfpVar.t;
        int i4 = iArr[0];
        int i5 = iArr[1];
        int i6 = iArr[2];
        int i7 = iArr[3];
        int[] iArr2 = dialogXBaseRelativeLayout.r;
        iArr2[0] = i4;
        iArr2[1] = i5;
        iArr2[2] = i6;
        iArr2[3] = i7;
        bht bhtVar = anj.a;
        int i8 = bfpVar.s;
        i8 = i8 == 0 ? 0 : i8;
        if (i8 > 0) {
            maxRelativeLayout.c = i8;
        }
        maxRelativeLayout.setMinimumWidth(0);
        maxRelativeLayout.setMinimumHeight(0);
        if (bfpVar.m) {
            dialogXBaseRelativeLayout.setOnClickListener(new ch(this, i3));
        } else {
            dialogXBaseRelativeLayout.setOnClickListener(null);
        }
        if (bfpVar.bb > -1.0f) {
            if ((maxRelativeLayout.getBackground() instanceof GradientDrawable) && (gradientDrawable = (GradientDrawable) maxRelativeLayout.getBackground()) != null) {
                float f = bfpVar.bb;
                gradientDrawable.setCornerRadii(new float[]{f, f, f, f, 0.0f, 0.0f, 0.0f, 0.0f});
            }
            maxRelativeLayout.setOutlineProvider(new yl(this, i2));
            maxRelativeLayout.setClipToOutline(true);
        }
        if (orVar != null) {
            if (orVar.d() != null && orVar.d().getParent() != relativeLayout && relativeLayout.getTag(-109) != orVar.d().toString()) {
                if (orVar.d().getParent() != null) {
                    ((ViewGroup) orVar.d().getParent()).removeView(orVar.d());
                }
                ViewGroup.LayoutParams layoutParams = orVar.d().getLayoutParams();
                relativeLayout.addView(orVar.d(), layoutParams == null ? new RelativeLayout.LayoutParams(-1, -2) : layoutParams);
                orVar.d();
                View viewD = orVar.d();
                if (bfpVar2.hashCode() != orVar.a || viewD.hashCode() != orVar.c) {
                    orVar.a = bfpVar2.hashCode();
                    orVar.c = viewD.hashCode();
                    orVar.d();
                }
            }
            if (orVar.d() instanceof dfa) {
                this.g = (dfa) orVar.d();
            } else {
                KeyEvent.Callback callbackFindViewWithTag = orVar.d().findViewWithTag("ScrollController");
                if (callbackFindViewWithTag instanceof dfa) {
                    this.g = (dfa) callbackFindViewWithTag;
                }
            }
        }
        bfpVar.ar().setBackgroundResource(R.color.black);
        activityScreenShotImageView.setVisibility(0);
        this.a.d(bfpVar2, this);
    }

    public final void m(View view) {
        int i = 0;
        if (view != null) {
            view.setEnabled(false);
        }
        bfp bfpVar = this.l;
        if (bfpVar.as() == null || bfpVar.u) {
            return;
        }
        if (bfpVar.be == null) {
            bfpVar.be = new bfk(this, i);
        }
        bfk bfkVar = bfpVar.be;
        if (bfkVar != null) {
            int i2 = 1;
            bfpVar.u = true;
            if (bfkVar == null) {
                bfpVar.be = new bfk(this, i);
            }
            bfpVar.be.ap(bfpVar.bf);
            bfn bfnVar = new bfn(this, i2);
            long j = bfpVar.r;
            if (j == -1) {
                j = 300;
            }
            if (j < 0) {
                return;
            }
            bht bhtVar = anj.a;
            ng.ac().postDelayed(bfnVar, j);
        }
    }

    public final void n(int i, final int i2, boolean z) {
        this.k = true;
        long j = this.l.q;
        if (j < 0) {
            j = 300;
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i, i2);
        valueAnimatorOfInt.setDuration(j);
        valueAnimatorOfInt.setInterpolator(new DecelerateInterpolator());
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: me.hd.wauxv.obf.bfj
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                bfo bfoVar = this.a;
                bfoVar.getClass();
                int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                bfoVar.e.setY(iIntValue);
                bfoVar.p();
                float safeHeight = bfoVar.c.getSafeHeight() - bfoVar.i;
                if (safeHeight < 0.0f) {
                    safeHeight = 0.0f;
                }
                if (safeHeight != bfoVar.h) {
                    bfoVar.h = safeHeight;
                    valueAnimator.cancel();
                    bfoVar.n(iIntValue, (int) safeHeight, true);
                } else if (iIntValue >= i2) {
                    bfoVar.k = false;
                }
            }
        });
        valueAnimatorOfInt.start();
        this.e.setVisibility(0);
        if (z) {
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(j);
        valueAnimatorOfFloat.addUpdateListener(new no(this, 4));
        valueAnimatorOfFloat.start();
    }

    public final float o() {
        return Math.max(0.0f, this.c.getSafeHeight() - this.i);
    }

    public final void p() {
        bfp bfpVar;
        or orVar;
        ViewGroup.LayoutParams layoutParams;
        int height = this.f.getHeight();
        if (height == 0 || ((orVar = (bfpVar = this.l).ba) != null && orVar.d() != null && (layoutParams = bfpVar.ba.d().getLayoutParams()) != null && layoutParams.height == -1)) {
            height = (int) this.c.getSafeHeight();
        }
        this.i = height;
    }

    public final void q() {
        bfp bfpVar = this.l;
        if (bfpVar.m) {
            m(this.c);
            return;
        }
        long j = bfpVar.r;
        if (j < 0) {
            j = 300;
        }
        MaxRelativeLayout maxRelativeLayout = this.e;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(maxRelativeLayout, "y", maxRelativeLayout.getY(), this.h);
        objectAnimatorOfFloat.setDuration(j);
        objectAnimatorOfFloat.start();
    }
}
