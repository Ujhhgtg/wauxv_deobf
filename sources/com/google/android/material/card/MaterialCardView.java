package com.google.android.material.card;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import me.hd.wauxv.obf.ResourcesCompat;
import me.hd.wauxv.obf.FastKV;
import me.hd.wauxv.obf.cam;
import me.hd.wauxv.obf.cao;
import me.hd.wauxv.obf.cau;
import me.hd.wauxv.obf.cmz;
import me.hd.wauxv.obf.cna;
import me.hd.wauxv.obf.cnb;
import me.hd.wauxv.obf.KotlinHelpers2;
import me.hd.wauxv.obf.cxs;
import me.hd.wauxv.obf.ddb;
import me.hd.wauxv.obf.dgl;
import me.hd.wauxv.obf.dgm;
import me.hd.wauxv.obf.dgx;
import me.hd.wauxv.obf.te;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class MaterialCardView extends te implements Checkable, dgx {
    public static final int[] a = {R.attr.state_checkable};
    public static final int[] b = {R.attr.state_checked};
    public static final int[] c = {me.hd.wauxv.R.attr.state_dragged};
    public final cao d;
    public final boolean e;
    public boolean f;
    public boolean g;

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        super(cmz.aq(context, attributeSet, me.hd.wauxv.R.attr.materialCardViewStyle, me.hd.wauxv.R.style.Widget_MaterialComponents_CardView), attributeSet);
        this.f = false;
        this.g = false;
        this.e = true;
        TypedArray typedArrayAn = FastKV.an(getContext(), attributeSet, cxs.v, me.hd.wauxv.R.attr.materialCardViewStyle, me.hd.wauxv.R.style.Widget_MaterialComponents_CardView, new int[0]);
        cao caoVar = new cao(this, attributeSet);
        this.d = caoVar;
        ColorStateList cardBackgroundColor = super.getCardBackgroundColor();
        cau cauVar = caoVar.e;
        cauVar.dz(cardBackgroundColor);
        caoVar.d.set(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
        caoVar.al();
        MaterialCardView materialCardView = caoVar.c;
        ColorStateList colorStateListV = cnb.v(materialCardView.getContext(), typedArrayAn, 11);
        caoVar.p = colorStateListV;
        if (colorStateListV == null) {
            caoVar.p = ColorStateList.valueOf(-1);
        }
        caoVar.j = typedArrayAn.getDimensionPixelSize(12, 0);
        boolean z = typedArrayAn.getBoolean(0, false);
        caoVar.u = z;
        materialCardView.setLongClickable(z);
        caoVar.n = cnb.v(materialCardView.getContext(), typedArrayAn, 6);
        caoVar.ag(cnb.x(materialCardView.getContext(), typedArrayAn, 2));
        caoVar.h = typedArrayAn.getDimensionPixelSize(5, 0);
        caoVar.g = typedArrayAn.getDimensionPixelSize(4, 0);
        caoVar.i = typedArrayAn.getInteger(3, 8388661);
        ColorStateList colorStateListV2 = cnb.v(materialCardView.getContext(), typedArrayAn, 7);
        caoVar.m = colorStateListV2;
        if (colorStateListV2 == null) {
            caoVar.m = ColorStateList.valueOf(cna.v(materialCardView, me.hd.wauxv.R.attr.colorControlHighlight));
        }
        ColorStateList colorStateListV3 = cnb.v(materialCardView.getContext(), typedArrayAn, 1);
        colorStateListV3 = colorStateListV3 == null ? ColorStateList.valueOf(0) : colorStateListV3;
        cau cauVar2 = caoVar.f;
        cauVar2.dz(colorStateListV3);
        int[] iArr = ddb.a;
        RippleDrawable rippleDrawable = caoVar.q;
        if (rippleDrawable != null) {
            rippleDrawable.setColor(caoVar.m);
        }
        cauVar.dy(materialCardView.getCardElevation());
        float f = caoVar.j;
        ColorStateList colorStateList = caoVar.p;
        cauVar2.ct.k = f;
        cauVar2.invalidateSelf();
        cauVar2.ed(colorStateList);
        materialCardView.setBackgroundInternal(caoVar.ad(cauVar));
        Drawable drawableAc = caoVar.aj() ? caoVar.ac() : cauVar2;
        caoVar.k = drawableAc;
        materialCardView.setForeground(caoVar.ad(drawableAc));
        typedArrayAn.recycle();
    }

    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.d.e.getBounds());
        return rectF;
    }

    @Override // me.hd.wauxv.obf.te
    public ColorStateList getCardBackgroundColor() {
        return this.d.e.ct.d;
    }

    public ColorStateList getCardForegroundColor() {
        return this.d.f.ct.d;
    }

    public float getCardViewRadius() {
        return super.getRadius();
    }

    public Drawable getCheckedIcon() {
        return this.d.l;
    }

    public int getCheckedIconGravity() {
        return this.d.i;
    }

    public int getCheckedIconMargin() {
        return this.d.g;
    }

    public int getCheckedIconSize() {
        return this.d.h;
    }

    public ColorStateList getCheckedIconTint() {
        return this.d.n;
    }

    @Override // me.hd.wauxv.obf.te
    public int getContentPaddingBottom() {
        return this.d.d.bottom;
    }

    @Override // me.hd.wauxv.obf.te
    public int getContentPaddingLeft() {
        return this.d.d.left;
    }

    @Override // me.hd.wauxv.obf.te
    public int getContentPaddingRight() {
        return this.d.d.right;
    }

    @Override // me.hd.wauxv.obf.te
    public int getContentPaddingTop() {
        return this.d.d.top;
    }

    public float getProgress() {
        return this.d.e.ct.j;
    }

    @Override // me.hd.wauxv.obf.te
    public float getRadius() {
        return this.d.e.dv();
    }

    public ColorStateList getRippleColor() {
        return this.d.m;
    }

    public dgm getShapeAppearanceModel() {
        return this.d.o;
    }

    @Deprecated
    public int getStrokeColor() {
        ColorStateList colorStateList = this.d.p;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }

    public ColorStateList getStrokeColorStateList() {
        return this.d.p;
    }

    public int getStrokeWidth() {
        return this.d.j;
    }

    public final void h() {
        cao caoVar = this.d;
        RippleDrawable rippleDrawable = caoVar.q;
        if (rippleDrawable != null) {
            Rect bounds = rippleDrawable.getBounds();
            int i = bounds.bottom;
            caoVar.q.setBounds(bounds.left, bounds.top, bounds.right, i - 1);
            caoVar.q.setBounds(bounds.left, bounds.top, bounds.right, i);
        }
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        cao caoVar = this.d;
        caoVar.ak();
        KotlinHelpers2.bi(this, caoVar.e);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 3);
        cao caoVar = this.d;
        if (caoVar != null && caoVar.u) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, a);
        }
        if (this.f) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, b);
        }
        if (this.g) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, c);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(this.f);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        cao caoVar = this.d;
        accessibilityNodeInfo.setCheckable(caoVar != null && caoVar.u);
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(this.f);
    }

    @Override // me.hd.wauxv.obf.te, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.d.ae(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.e) {
            cao caoVar = this.d;
            if (!caoVar.t) {
                Log.i("MaterialCardView", "Setting a custom background is not supported.");
                caoVar.t = true;
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // me.hd.wauxv.obf.te
    public void setCardBackgroundColor(int i) {
        this.d.e.dz(ColorStateList.valueOf(i));
    }

    @Override // me.hd.wauxv.obf.te
    public void setCardElevation(float f) {
        super.setCardElevation(f);
        cao caoVar = this.d;
        caoVar.e.dy(caoVar.c.getCardElevation());
    }

    public void setCardForegroundColor(ColorStateList colorStateList) {
        cau cauVar = this.d.f;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        cauVar.dz(colorStateList);
    }

    public void setCheckable(boolean z) {
        this.d.u = z;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.f != z) {
            toggle();
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        this.d.ag(drawable);
    }

    public void setCheckedIconGravity(int i) {
        cao caoVar = this.d;
        if (caoVar.i != i) {
            caoVar.i = i;
            MaterialCardView materialCardView = caoVar.c;
            caoVar.ae(materialCardView.getMeasuredWidth(), materialCardView.getMeasuredHeight());
        }
    }

    public void setCheckedIconMargin(int i) {
        this.d.g = i;
    }

    public void setCheckedIconMarginResource(int i) {
        if (i != -1) {
            this.d.g = getResources().getDimensionPixelSize(i);
        }
    }

    public void setCheckedIconResource(int i) {
        this.d.ag(cmz.y(getContext(), i));
    }

    public void setCheckedIconSize(int i) {
        this.d.h = i;
    }

    public void setCheckedIconSizeResource(int i) {
        if (i != 0) {
            this.d.h = getResources().getDimensionPixelSize(i);
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        cao caoVar = this.d;
        caoVar.n = colorStateList;
        Drawable drawable = caoVar.l;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
        }
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
        cao caoVar = this.d;
        if (caoVar != null) {
            caoVar.ak();
        }
    }

    public void setDragged(boolean z) {
        if (this.g != z) {
            this.g = z;
            refreshDrawableState();
            h();
            invalidate();
        }
    }

    @Override // me.hd.wauxv.obf.te
    public void setMaxCardElevation(float f) {
        super.setMaxCardElevation(f);
        this.d.am();
    }

    public void setOnCheckedChangeListener(cam camVar) {
    }

    @Override // me.hd.wauxv.obf.te
    public void setPreventCornerOverlap(boolean z) {
        super.setPreventCornerOverlap(z);
        cao caoVar = this.d;
        caoVar.am();
        caoVar.al();
    }

    public void setProgress(float f) {
        cao caoVar = this.d;
        caoVar.e.ea(f);
        cau cauVar = caoVar.f;
        if (cauVar != null) {
            cauVar.ea(f);
        }
        cau cauVar2 = caoVar.s;
        if (cauVar2 != null) {
            cauVar2.ea(f);
        }
    }

    /* JADX WARN: Found duplicated region for block: B:8:0x0038  */
    @Override // me.hd.wauxv.obf.te
    public void setRadius(float f) {
        super.setRadius(f);
        cao caoVar = this.d;
        dgl dglVarQ = caoVar.o.q();
        dglVarQ.n(f);
        caoVar.ah(dglVarQ.m());
        caoVar.k.invalidateSelf();
        if (caoVar.ai()) {
            caoVar.al();
        } else if (caoVar.c.getPreventCornerOverlap()) {
            cau cauVar = caoVar.e;
            if (!cauVar.ct.b.p(cauVar.du())) {
                caoVar.al();
            }
        }
        if (caoVar.ai()) {
            caoVar.am();
        }
    }

    public void setRippleColor(ColorStateList colorStateList) {
        cao caoVar = this.d;
        caoVar.m = colorStateList;
        int[] iArr = ddb.a;
        RippleDrawable rippleDrawable = caoVar.q;
        if (rippleDrawable != null) {
            rippleDrawable.setColor(colorStateList);
        }
    }

    public void setRippleColorResource(int i) {
        ColorStateList colorStateListV = ResourcesCompat.v(getContext(), i);
        cao caoVar = this.d;
        caoVar.m = colorStateListV;
        int[] iArr = ddb.a;
        RippleDrawable rippleDrawable = caoVar.q;
        if (rippleDrawable != null) {
            rippleDrawable.setColor(colorStateListV);
        }
    }

    @Override // me.hd.wauxv.obf.dgx
    public void setShapeAppearanceModel(dgm dgmVar) {
        setClipToOutline(dgmVar.p(getBoundsAsRectF()));
        this.d.ah(dgmVar);
    }

    public void setStrokeColor(int i) {
        setStrokeColor(ColorStateList.valueOf(i));
    }

    public void setStrokeWidth(int i) {
        cao caoVar = this.d;
        if (i != caoVar.j) {
            caoVar.j = i;
            cau cauVar = caoVar.f;
            ColorStateList colorStateList = caoVar.p;
            cauVar.ct.k = i;
            cauVar.invalidateSelf();
            cauVar.ed(colorStateList);
        }
        invalidate();
    }

    @Override // me.hd.wauxv.obf.te
    public void setUseCompatPadding(boolean z) {
        super.setUseCompatPadding(z);
        cao caoVar = this.d;
        caoVar.am();
        caoVar.al();
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        cao caoVar = this.d;
        if (caoVar != null && caoVar.u && isEnabled()) {
            this.f = !this.f;
            refreshDrawableState();
            h();
            caoVar.af(this.f, true);
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        cao caoVar = this.d;
        if (caoVar.p != colorStateList) {
            caoVar.p = colorStateList;
            cau cauVar = caoVar.f;
            cauVar.ct.k = caoVar.j;
            cauVar.invalidateSelf();
            cauVar.ed(colorStateList);
        }
        invalidate();
    }

    @Override // me.hd.wauxv.obf.te
    public void setCardBackgroundColor(ColorStateList colorStateList) {
        this.d.e.dz(colorStateList);
    }
}
