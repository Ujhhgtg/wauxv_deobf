package com.google.android.material.button;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import me.hd.wauxv.obf.bht;
import me.hd.wauxv.obf.bhu;
import me.hd.wauxv.obf.bmu;
import me.hd.wauxv.obf.cab;
import me.hd.wauxv.obf.cac;
import me.hd.wauxv.obf.cad;
import me.hd.wauxv.obf.cmz;
import me.hd.wauxv.obf.cnb;
import me.hd.wauxv.obf.cnd;
import me.hd.wauxv.obf.cxs;
import me.hd.wauxv.obf.ddb;
import me.hd.wauxv.obf.dgl;
import me.hd.wauxv.obf.dgm;
import me.hd.wauxv.obf.dgx;
import me.hd.wauxv.obf.eqz;
import me.hd.wauxv.obf.ewz;
import me.hd.wauxv.obf.hd;
import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class MaterialButton extends hd implements Checkable, dgx {
    public static final int[] a = {R.attr.state_checkable};
    public static final int[] b = {R.attr.state_checked};
    public final cad c;
    public final LinkedHashSet d;
    public cab e;
    public PorterDuff.Mode f;
    public ColorStateList g;
    public Drawable h;
    public String i;
    public int j;
    public int k;
    public int l;
    public int m;
    public boolean n;
    public boolean o;
    public int p;

    public MaterialButton(Context context, AttributeSet attributeSet) {
        super(cmz.aq(context, attributeSet, me.hd.wauxv.R.attr.materialButtonStyle, me.hd.wauxv.R.style.Widget_MaterialComponents_Button), attributeSet, me.hd.wauxv.R.attr.materialButtonStyle);
        this.d = new LinkedHashSet();
        this.n = false;
        this.o = false;
        Context context2 = getContext();
        TypedArray typedArrayAn = bhu.an(context2, attributeSet, cxs.r, me.hd.wauxv.R.attr.materialButtonStyle, me.hd.wauxv.R.style.Widget_MaterialComponents_Button, new int[0]);
        this.m = typedArrayAn.getDimensionPixelSize(12, 0);
        int i = typedArrayAn.getInt(15, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        this.f = ewz.ap(i, mode);
        this.g = cnb.v(getContext(), typedArrayAn, 14);
        this.h = cnb.x(getContext(), typedArrayAn, 10);
        this.p = typedArrayAn.getInteger(11, 1);
        this.j = typedArrayAn.getDimensionPixelSize(13, 0);
        cad cadVar = new cad(this, dgm.n(context2, attributeSet, me.hd.wauxv.R.attr.materialButtonStyle, me.hd.wauxv.R.style.Widget_MaterialComponents_Button).m());
        this.c = cadVar;
        cadVar.c = typedArrayAn.getDimensionPixelOffset(1, 0);
        cadVar.d = typedArrayAn.getDimensionPixelOffset(2, 0);
        cadVar.e = typedArrayAn.getDimensionPixelOffset(3, 0);
        cadVar.f = typedArrayAn.getDimensionPixelOffset(4, 0);
        if (typedArrayAn.hasValue(8)) {
            int dimensionPixelSize = typedArrayAn.getDimensionPixelSize(8, -1);
            cadVar.g = dimensionPixelSize;
            dgl dglVarQ = cadVar.b.q();
            dglVarQ.n(dimensionPixelSize);
            cadVar.w(dglVarQ.m());
            cadVar.p = true;
        }
        cadVar.h = typedArrayAn.getDimensionPixelSize(20, 0);
        cadVar.i = ewz.ap(typedArrayAn.getInt(7, -1), mode);
        cadVar.j = cnb.v(getContext(), typedArrayAn, 6);
        cadVar.k = cnb.v(getContext(), typedArrayAn, 19);
        cadVar.l = cnb.v(getContext(), typedArrayAn, 16);
        cadVar.q = typedArrayAn.getBoolean(5, false);
        cadVar.t = typedArrayAn.getDimensionPixelSize(9, 0);
        cadVar.r = typedArrayAn.getBoolean(21, true);
        WeakHashMap weakHashMap = eqz.a;
        int paddingStart = getPaddingStart();
        int paddingTop = getPaddingTop();
        int paddingEnd = getPaddingEnd();
        int paddingBottom = getPaddingBottom();
        if (typedArrayAn.hasValue(0)) {
            cadVar.o = true;
            setSupportBackgroundTintList(cadVar.j);
            setSupportBackgroundTintMode(cadVar.i);
        } else {
            cadVar.y();
        }
        setPaddingRelative(paddingStart + cadVar.c, paddingTop + cadVar.e, paddingEnd + cadVar.d, paddingBottom + cadVar.f);
        typedArrayAn.recycle();
        setCompoundDrawablePadding(this.m);
        s(this.h != null);
    }

    private Layout.Alignment getActualTextAlignment() {
        int textAlignment = getTextAlignment();
        return textAlignment != 1 ? (textAlignment == 6 || textAlignment == 3) ? Layout.Alignment.ALIGN_OPPOSITE : textAlignment != 4 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER : getGravityTextAlignment();
    }

    private Layout.Alignment getGravityTextAlignment() {
        int gravity = getGravity() & 8388615;
        return gravity != 1 ? (gravity == 5 || gravity == 8388613) ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER;
    }

    private int getTextHeight() {
        if (getLineCount() > 1) {
            return getLayout().getHeight();
        }
        TextPaint paint = getPaint();
        String string = getText().toString();
        if (getTransformationMethod() != null) {
            string = getTransformationMethod().getTransformation(string, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(string, 0, string.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextLayoutWidth() {
        int lineCount = getLineCount();
        float fMax = 0.0f;
        for (int i = 0; i < lineCount; i++) {
            fMax = Math.max(fMax, getLayout().getLineWidth(i));
        }
        return (int) Math.ceil(fMax);
    }

    public String getA11yClassName() {
        if (!TextUtils.isEmpty(this.i)) {
            return this.i;
        }
        cad cadVar = this.c;
        return ((cadVar == null || !cadVar.q) ? Button.class : CompoundButton.class).getName();
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (q()) {
            return this.c.g;
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.h;
    }

    public int getIconGravity() {
        return this.p;
    }

    public int getIconPadding() {
        return this.m;
    }

    public int getIconSize() {
        return this.j;
    }

    public ColorStateList getIconTint() {
        return this.g;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f;
    }

    public int getInsetBottom() {
        return this.c.f;
    }

    public int getInsetTop() {
        return this.c.e;
    }

    public ColorStateList getRippleColor() {
        if (q()) {
            return this.c.l;
        }
        return null;
    }

    public dgm getShapeAppearanceModel() {
        if (q()) {
            return this.c.b;
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (q()) {
            return this.c.k;
        }
        return null;
    }

    public int getStrokeWidth() {
        if (q()) {
            return this.c.h;
        }
        return 0;
    }

    @Override // me.hd.wauxv.obf.hd
    public ColorStateList getSupportBackgroundTintList() {
        return q() ? this.c.j : super.getSupportBackgroundTintList();
    }

    @Override // me.hd.wauxv.obf.hd
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return q() ? this.c.i : super.getSupportBackgroundTintMode();
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.n;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (q()) {
            cnd.bi(this, this.c.v(false));
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 2);
        cad cadVar = this.c;
        if (cadVar != null && cadVar.q) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, a);
        }
        if (this.n) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, b);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // me.hd.wauxv.obf.hd, android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(this.n);
    }

    @Override // me.hd.wauxv.obf.hd, android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        cad cadVar = this.c;
        accessibilityNodeInfo.setCheckable(cadVar != null && cadVar.q);
        accessibilityNodeInfo.setChecked(this.n);
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // me.hd.wauxv.obf.hd, android.widget.TextView, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        t(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof cac)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        cac cacVar = (cac) parcelable;
        super.onRestoreInstanceState(cacVar.g);
        setChecked(cacVar.a);
    }

    @Override // android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        cac cacVar = new cac(super.onSaveInstanceState());
        cacVar.a = this.n;
        return cacVar;
    }

    @Override // me.hd.wauxv.obf.hd, android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        t(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (this.c.r) {
            toggle();
        }
        return super.performClick();
    }

    public final boolean q() {
        cad cadVar = this.c;
        return (cadVar == null || cadVar.o) ? false : true;
    }

    public final void r() {
        int i = this.p;
        if (i == 1 || i == 2) {
            setCompoundDrawablesRelative(this.h, null, null, null);
            return;
        }
        if (i == 3 || i == 4) {
            setCompoundDrawablesRelative(null, null, this.h, null);
        } else if (i == 16 || i == 32) {
            setCompoundDrawablesRelative(null, this.h, null, null);
        }
    }

    @Override // android.view.View
    public final void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.h != null) {
            if (this.h.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    public final void s(boolean z) {
        Drawable drawable = this.h;
        if (drawable != null) {
            Drawable drawableMutate = drawable.mutate();
            this.h = drawableMutate;
            drawableMutate.setTintList(this.g);
            PorterDuff.Mode mode = this.f;
            if (mode != null) {
                this.h.setTintMode(mode);
            }
            int intrinsicWidth = this.j;
            if (intrinsicWidth == 0) {
                intrinsicWidth = this.h.getIntrinsicWidth();
            }
            int intrinsicHeight = this.j;
            if (intrinsicHeight == 0) {
                intrinsicHeight = this.h.getIntrinsicHeight();
            }
            Drawable drawable2 = this.h;
            int i = this.k;
            int i2 = this.l;
            drawable2.setBounds(i, i2, intrinsicWidth + i, intrinsicHeight + i2);
            this.h.setVisible(true, z);
        }
        if (z) {
            r();
            return;
        }
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        Drawable drawable3 = compoundDrawablesRelative[0];
        Drawable drawable4 = compoundDrawablesRelative[1];
        Drawable drawable5 = compoundDrawablesRelative[2];
        int i3 = this.p;
        if (((i3 == 1 || i3 == 2) && drawable3 != this.h) || (((i3 == 3 || i3 == 4) && drawable5 != this.h) || ((i3 == 16 || i3 == 32) && drawable4 != this.h))) {
            r();
        }
    }

    public void setA11yClassName(String str) {
        this.i = str;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (!q()) {
            super.setBackgroundColor(i);
            return;
        }
        cad cadVar = this.c;
        if (cadVar.v(false) != null) {
            cadVar.v(false).setTint(i);
        }
    }

    @Override // me.hd.wauxv.obf.hd, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (!q()) {
            super.setBackgroundDrawable(drawable);
            return;
        }
        if (drawable == getBackground()) {
            getBackground().setState(drawable.getState());
            return;
        }
        Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
        cad cadVar = this.c;
        cadVar.o = true;
        MaterialButton materialButton = cadVar.a;
        materialButton.setSupportBackgroundTintList(cadVar.j);
        materialButton.setSupportBackgroundTintMode(cadVar.i);
        super.setBackgroundDrawable(drawable);
    }

    @Override // me.hd.wauxv.obf.hd, android.view.View
    public void setBackgroundResource(int i) {
        setBackgroundDrawable(i != 0 ? cmz.y(getContext(), i) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z) {
        if (q()) {
            this.c.q = z;
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        cad cadVar = this.c;
        if (cadVar == null || !cadVar.q || !isEnabled() || this.n == z) {
            return;
        }
        this.n = z;
        refreshDrawableState();
        if (getParent() instanceof MaterialButtonToggleGroup) {
            MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) getParent();
            boolean z2 = this.n;
            if (!materialButtonToggleGroup.g) {
                materialButtonToggleGroup.m(getId(), z2);
            }
        }
        if (this.o) {
            return;
        }
        this.o = true;
        Iterator it = this.d.iterator();
        if (it.hasNext()) {
            throw yg.d(it);
        }
        this.o = false;
    }

    public void setCornerRadius(int i) {
        if (q()) {
            cad cadVar = this.c;
            if (cadVar.p && cadVar.g == i) {
                return;
            }
            cadVar.g = i;
            cadVar.p = true;
            dgl dglVarQ = cadVar.b.q();
            dglVarQ.n(i);
            cadVar.w(dglVarQ.m());
        }
    }

    public void setCornerRadiusResource(int i) {
        if (q()) {
            setCornerRadius(getResources().getDimensionPixelSize(i));
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        if (q()) {
            this.c.v(false).dy(f);
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.h != drawable) {
            this.h = drawable;
            s(true);
            t(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i) {
        if (this.p != i) {
            this.p = i;
            t(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(int i) {
        if (this.m != i) {
            this.m = i;
            setCompoundDrawablePadding(i);
        }
    }

    public void setIconResource(int i) {
        setIcon(i != 0 ? cmz.y(getContext(), i) : null);
    }

    public void setIconSize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.j != i) {
            this.j = i;
            s(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.g != colorStateList) {
            this.g = colorStateList;
            s(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f != mode) {
            this.f = mode;
            s(false);
        }
    }

    public void setIconTintResource(int i) {
        setIconTint(bht.v(getContext(), i));
    }

    public void setInsetBottom(int i) {
        cad cadVar = this.c;
        cadVar.x(cadVar.e, i);
    }

    public void setInsetTop(int i) {
        cad cadVar = this.c;
        cadVar.x(i, cadVar.f);
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(cab cabVar) {
        this.e = cabVar;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        cab cabVar = this.e;
        if (cabVar != null) {
            ((MaterialButtonToggleGroup) ((bmu) cabVar).h).invalidate();
        }
        super.setPressed(z);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (q()) {
            cad cadVar = this.c;
            MaterialButton materialButton = cadVar.a;
            if (cadVar.l != colorStateList) {
                cadVar.l = colorStateList;
                if (materialButton.getBackground() instanceof RippleDrawable) {
                    ((RippleDrawable) materialButton.getBackground()).setColor(ddb.i(colorStateList));
                }
            }
        }
    }

    public void setRippleColorResource(int i) {
        if (q()) {
            setRippleColor(bht.v(getContext(), i));
        }
    }

    @Override // me.hd.wauxv.obf.dgx
    public void setShapeAppearanceModel(dgm dgmVar) {
        if (!q()) {
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        this.c.w(dgmVar);
    }

    public void setShouldDrawSurfaceColorStroke(boolean z) {
        if (q()) {
            cad cadVar = this.c;
            cadVar.n = z;
            cadVar.z();
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (q()) {
            cad cadVar = this.c;
            if (cadVar.k != colorStateList) {
                cadVar.k = colorStateList;
                cadVar.z();
            }
        }
    }

    public void setStrokeColorResource(int i) {
        if (q()) {
            setStrokeColor(bht.v(getContext(), i));
        }
    }

    public void setStrokeWidth(int i) {
        if (q()) {
            cad cadVar = this.c;
            if (cadVar.h != i) {
                cadVar.h = i;
                cadVar.z();
            }
        }
    }

    public void setStrokeWidthResource(int i) {
        if (q()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i));
        }
    }

    @Override // me.hd.wauxv.obf.hd
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (!q()) {
            super.setSupportBackgroundTintList(colorStateList);
            return;
        }
        cad cadVar = this.c;
        if (cadVar.j != colorStateList) {
            cadVar.j = colorStateList;
            if (cadVar.v(false) != null) {
                cadVar.v(false).setTintList(cadVar.j);
            }
        }
    }

    @Override // me.hd.wauxv.obf.hd
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (!q()) {
            super.setSupportBackgroundTintMode(mode);
            return;
        }
        cad cadVar = this.c;
        if (cadVar.i != mode) {
            cadVar.i = mode;
            if (cadVar.v(false) == null || cadVar.i == null) {
                return;
            }
            cadVar.v(false).setTintMode(cadVar.i);
        }
    }

    @Override // android.view.View
    public void setTextAlignment(int i) {
        super.setTextAlignment(i);
        t(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setToggleCheckedStateOnClick(boolean z) {
        this.c.r = z;
    }

    public final void t(int i, int i2) {
        if (this.h == null || getLayout() == null) {
            return;
        }
        int i3 = this.p;
        if (i3 != 1 && i3 != 2 && i3 != 3 && i3 != 4) {
            if (i3 == 16 || i3 == 32) {
                this.k = 0;
                if (i3 == 16) {
                    this.l = 0;
                    s(false);
                    return;
                }
                int intrinsicHeight = this.j;
                if (intrinsicHeight == 0) {
                    intrinsicHeight = this.h.getIntrinsicHeight();
                }
                int iMax = Math.max(0, (((((i2 - getTextHeight()) - getPaddingTop()) - intrinsicHeight) - this.m) - getPaddingBottom()) / 2);
                if (this.l != iMax) {
                    this.l = iMax;
                    s(false);
                    return;
                }
                return;
            }
            return;
        }
        this.l = 0;
        Layout.Alignment actualTextAlignment = getActualTextAlignment();
        int i4 = this.p;
        if (i4 == 1 || i4 == 3 || ((i4 == 2 && actualTextAlignment == Layout.Alignment.ALIGN_NORMAL) || (i4 == 4 && actualTextAlignment == Layout.Alignment.ALIGN_OPPOSITE))) {
            this.k = 0;
            s(false);
            return;
        }
        int intrinsicWidth = this.j;
        if (intrinsicWidth == 0) {
            intrinsicWidth = this.h.getIntrinsicWidth();
        }
        int textLayoutWidth = i - getTextLayoutWidth();
        WeakHashMap weakHashMap = eqz.a;
        int paddingEnd = (((textLayoutWidth - getPaddingEnd()) - intrinsicWidth) - this.m) - getPaddingStart();
        if (actualTextAlignment == Layout.Alignment.ALIGN_CENTER) {
            paddingEnd /= 2;
        }
        if ((getLayoutDirection() == 1) != (this.p == 4)) {
            paddingEnd = -paddingEnd;
        }
        if (this.k != paddingEnd) {
            this.k = paddingEnd;
            s(false);
        }
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.n);
    }
}
