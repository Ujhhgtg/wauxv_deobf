package me.hd.wauxv.obf;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import com.android.dx.io.Opcodes;
import com.google.android.material.card.MaterialCardView;
import java.util.WeakHashMap;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cao {
    public static final double a = Math.cos(Math.toRadians(45.0d));
    public static final ColorDrawable b;
    public final MaterialCardView c;
    public final cau e;
    public final cau f;
    public int g;
    public int h;
    public int i;
    public int j;
    public Drawable k;
    public Drawable l;
    public ColorStateList m;
    public ColorStateList n;
    public dgm o;
    public ColorStateList p;
    public RippleDrawable q;
    public LayerDrawable r;
    public cau s;
    public boolean u;
    public ValueAnimator v;
    public final TimeInterpolator w;
    public final int x;
    public final int y;
    public final Rect d = new Rect();
    public boolean t = false;
    public float z = 0.0f;

    static {
        b = Build.VERSION.SDK_INT <= 28 ? new ColorDrawable() : null;
    }

    public cao(MaterialCardView materialCardView, AttributeSet attributeSet) {
        this.c = materialCardView;
        cau cauVar = new cau(materialCardView.getContext(), attributeSet, R.attr.materialCardViewStyle, R.style.Widget_MaterialComponents_CardView);
        this.e = cauVar;
        cauVar.dx(materialCardView.getContext());
        cauVar.eb();
        dgl dglVarQ = cauVar.ct.b.q();
        TypedArray typedArrayObtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, cxs.f, R.attr.materialCardViewStyle, R.style.CardView);
        if (typedArrayObtainStyledAttributes.hasValue(3)) {
            dglVarQ.n(typedArrayObtainStyledAttributes.getDimension(3, 0.0f));
        }
        this.f = new cau();
        ah(dglVarQ.m());
        this.w = ajn.ae(materialCardView.getContext(), R.attr.motionEasingLinearInterpolator, ff.a);
        this.x = ajn.ad(materialCardView.getContext(), R.attr.motionDurationShort2, 300);
        this.y = ajn.ad(materialCardView.getContext(), R.attr.motionDurationShort1, 300);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static float aa(bhv bhvVar, float f) {
        if (bhvVar instanceof ddk) {
            return (float) ((1.0d - a) * ((double) f));
        }
        if (bhvVar instanceof aiv) {
            return f / 2.0f;
        }
        return 0.0f;
    }

    public final float ab() {
        bhv bhvVar = this.o.a;
        cau cauVar = this.e;
        return Math.max(Math.max(aa(bhvVar, cauVar.dv()), aa(this.o.b, cauVar.ct.b.f.b(cauVar.du()))), Math.max(aa(this.o.c, cauVar.ct.b.g.b(cauVar.du())), aa(this.o.d, cauVar.ct.b.h.b(cauVar.du()))));
    }

    public final LayerDrawable ac() {
        if (this.q == null) {
            int[] iArr = ddb.a;
            this.s = new cau(this.o);
            this.q = new RippleDrawable(this.m, null, this.s);
        }
        if (this.r == null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.q, this.f, this.l});
            this.r = layerDrawable;
            layerDrawable.setId(2, R.id.mtrl_card_checked_layer_id);
        }
        return this.r;
    }

    public final can ad(Drawable drawable) {
        int iCeil;
        int i;
        if (this.c.getUseCompatPadding()) {
            int iCeil2 = (int) Math.ceil((r0.getMaxCardElevation() * 1.5f) + (ai() ? ab() : 0.0f));
            iCeil = (int) Math.ceil(r0.getMaxCardElevation() + (ai() ? ab() : 0.0f));
            i = iCeil2;
        } else {
            iCeil = 0;
            i = 0;
        }
        return new can(drawable, iCeil, i, iCeil, i);
    }

    public final void ae(int i, int i2) {
        int iCeil;
        int iCeil2;
        int i3;
        int i4;
        if (this.r != null) {
            MaterialCardView materialCardView = this.c;
            if (materialCardView.getUseCompatPadding()) {
                iCeil = (int) Math.ceil(((materialCardView.getMaxCardElevation() * 1.5f) + (ai() ? ab() : 0.0f)) * 2.0f);
                iCeil2 = (int) Math.ceil((materialCardView.getMaxCardElevation() + (ai() ? ab() : 0.0f)) * 2.0f);
            } else {
                iCeil = 0;
                iCeil2 = 0;
            }
            int i5 = this.i;
            int i6 = (i5 & 8388613) == 8388613 ? ((i - this.g) - this.h) - iCeil2 : this.g;
            int i7 = (i5 & 80) == 80 ? this.g : ((i2 - this.g) - this.h) - iCeil;
            int i8 = (i5 & 8388613) == 8388613 ? this.g : ((i - this.g) - this.h) - iCeil2;
            int i9 = (i5 & 80) == 80 ? ((i2 - this.g) - this.h) - iCeil : this.g;
            WeakHashMap weakHashMap = ViewCompat.a;
            if (materialCardView.getLayoutDirection() == 1) {
                i4 = i8;
                i3 = i6;
            } else {
                i3 = i8;
                i4 = i6;
            }
            this.r.setLayerInset(2, i4, i9, i3, i7);
        }
    }

    public final void af(boolean z, boolean z2) {
        Drawable drawable = this.l;
        if (drawable != null) {
            if (!z2) {
                drawable.setAlpha(z ? Opcodes.CONST_METHOD_TYPE : 0);
                this.z = z ? 1.0f : 0.0f;
                return;
            }
            float f = z ? 1.0f : 0.0f;
            float f2 = z ? 1.0f - this.z : this.z;
            ValueAnimator valueAnimator = this.v;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.v = null;
            }
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.z, f);
            this.v = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new aqi(this, 1));
            this.v.setInterpolator(this.w);
            this.v.setDuration((long) ((z ? this.x : this.y) * f2));
            this.v.start();
        }
    }

    public final void ag(Drawable drawable) {
        if (drawable != null) {
            Drawable drawableMutate = drawable.mutate();
            this.l = drawableMutate;
            drawableMutate.setTintList(this.n);
            af(this.c.f, false);
        } else {
            this.l = b;
        }
        LayerDrawable layerDrawable = this.r;
        if (layerDrawable != null) {
            layerDrawable.setDrawableByLayerId(R.id.mtrl_card_checked_layer_id, this.l);
        }
    }

    public final void ah(dgm dgmVar) {
        this.o = dgmVar;
        cau cauVar = this.e;
        cauVar.setShapeAppearanceModel(dgmVar);
        cauVar.dp = !cauVar.ct.b.p(cauVar.du());
        cau cauVar2 = this.f;
        if (cauVar2 != null) {
            cauVar2.setShapeAppearanceModel(dgmVar);
        }
        cau cauVar3 = this.s;
        if (cauVar3 != null) {
            cauVar3.setShapeAppearanceModel(dgmVar);
        }
    }

    public final boolean ai() {
        MaterialCardView materialCardView = this.c;
        if (!materialCardView.getPreventCornerOverlap()) {
            return false;
        }
        cau cauVar = this.e;
        return cauVar.ct.b.p(cauVar.du()) && materialCardView.getUseCompatPadding();
    }

    public final boolean aj() {
        View view = this.c;
        if (view.isClickable()) {
            return true;
        }
        while (view.isDuplicateParentStateEnabled() && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        return view.isClickable();
    }

    public final void ak() {
        Drawable drawable = this.k;
        Drawable drawableAc = aj() ? ac() : this.f;
        this.k = drawableAc;
        if (drawable != drawableAc) {
            MaterialCardView materialCardView = this.c;
            if (materialCardView.getForeground() instanceof InsetDrawable) {
                ((InsetDrawable) materialCardView.getForeground()).setDrawable(drawableAc);
            } else {
                materialCardView.setForeground(ad(drawableAc));
            }
        }
    }

    /* JADX WARN: Found duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Found duplicated region for block: B:7:0x001a  */
    /* JADX WARN: Found duplicated region for block: B:9:0x0020  */
    public final void al() {
        float fAb;
        MaterialCardView materialCardView = this.c;
        float cardViewRadius = 0.0f;
        if (materialCardView.getPreventCornerOverlap()) {
            cau cauVar = this.e;
            if (cauVar.ct.b.p(cauVar.du())) {
                fAb = ai() ? ab() : 0.0f;
            }
        } else if (ai()) {
        }
        if (materialCardView.getPreventCornerOverlap() && materialCardView.getUseCompatPadding()) {
            cardViewRadius = (float) ((1.0d - a) * ((double) materialCardView.getCardViewRadius()));
        }
        int i = (int) (fAb - cardViewRadius);
        Rect rect = this.d;
        materialCardView.m.set(rect.left + i, rect.top + i, rect.right + i, rect.bottom + i);
        DefaultConfig ioVar = materialCardView.o;
        if (!((te) ioVar.d).getUseCompatPadding()) {
            ioVar.ax(0, 0, 0, 0);
            return;
        }
        ddi ddiVar = (ddi) ((Drawable) ioVar.c);
        float f = ddiVar.e;
        float f2 = ddiVar.a;
        int iCeil = (int) Math.ceil(ddj.b(f, f2, r1.getPreventCornerOverlap()));
        int iCeil2 = (int) Math.ceil(ddj.c(f, f2, r1.getPreventCornerOverlap()));
        ioVar.ax(iCeil, iCeil2, iCeil, iCeil2);
    }

    public final void am() {
        boolean z = this.t;
        MaterialCardView materialCardView = this.c;
        if (!z) {
            materialCardView.setBackgroundInternal(ad(this.e));
        }
        materialCardView.setForeground(ad(this.k));
    }
}
