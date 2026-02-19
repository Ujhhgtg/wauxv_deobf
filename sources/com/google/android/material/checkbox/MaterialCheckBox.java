package com.google.android.material.checkbox;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillManager;
import android.widget.CompoundButton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import me.hd.wauxv.R;
import me.hd.wauxv.obf.FastKV;
import me.hd.wauxv.obf.cap;
import me.hd.wauxv.obf.caq;
import me.hd.wauxv.obf.ci;
import me.hd.wauxv.obf.cmz;
import me.hd.wauxv.obf.cna;
import me.hd.wauxv.obf.cnb;
import me.hd.wauxv.obf.cxs;
import me.hd.wauxv.obf.dcu;
import me.hd.wauxv.obf.ew;
import me.hd.wauxv.obf.ewz;
import me.hd.wauxv.obf.fc;
import me.hd.wauxv.obf.fd;
import me.hd.wauxv.obf.fe;
import me.hd.wauxv.obf.hf;
import me.hd.wauxv.obf.FactoryPools;
import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class MaterialCheckBox extends hf {
    public static final int[] a = {R.attr.state_indeterminate};
    public static final int[] b = {R.attr.state_error};
    public static final int[][] c = {new int[]{android.R.attr.state_enabled, R.attr.state_error}, new int[]{android.R.attr.state_enabled, android.R.attr.state_checked}, new int[]{android.R.attr.state_enabled, -16842912}, new int[]{-16842910, android.R.attr.state_checked}, new int[]{-16842910, -16842912}};
    public static final int d = Resources.getSystem().getIdentifier("btn_check_material_anim", "drawable", "android");
    public final LinkedHashSet e;
    public final LinkedHashSet f;
    public ColorStateList g;
    public boolean h;
    public boolean i;
    public boolean j;
    public CharSequence k;
    public Drawable l;
    public Drawable m;
    public boolean n;
    public ColorStateList o;
    public ColorStateList p;
    public PorterDuff.Mode q;
    public int r;
    public int[] s;
    public boolean t;
    public CharSequence u;
    public CompoundButton.OnCheckedChangeListener v;
    public final fe w;
    public final cap x;

    public MaterialCheckBox(Context context, AttributeSet attributeSet) {
        super(cmz.aq(context, attributeSet, R.attr.checkboxStyle, R.style.Widget_MaterialComponents_CompoundButton_CheckBox), attributeSet, R.attr.checkboxStyle);
        this.e = new LinkedHashSet();
        this.f = new LinkedHashSet();
        Context context2 = getContext();
        fe feVar = new fe(context2, 0);
        Resources resources = context2.getResources();
        Resources.Theme theme = context2.getTheme();
        ThreadLocal threadLocal = dcu.a;
        Drawable drawable = resources.getDrawable(R.drawable.mtrl_checkbox_button_checked_unchecked, theme);
        feVar.f = drawable;
        drawable.setCallback(feVar.e);
        new fd(feVar.f.getConstantState(), 0);
        this.w = feVar;
        this.x = new cap(this);
        Context context3 = getContext();
        this.l = getButtonDrawable();
        this.o = getSuperButtonTintList();
        setSupportButtonTintList(null);
        FactoryPools factoryPoolsVarAo = FastKV.ao(context3, attributeSet, cxs.w, R.attr.checkboxStyle, R.style.Widget_MaterialComponents_CompoundButton_CheckBox, new int[0]);
        TypedArray typedArray = (TypedArray) factoryPoolsVarAo.e;
        this.m = factoryPoolsVarAo.s(2);
        if (this.l != null && cmz.am(context3, R.attr.isMaterial3Theme, false)) {
            int resourceId = typedArray.getResourceId(0, 0);
            int resourceId2 = typedArray.getResourceId(1, 0);
            if (resourceId == d && resourceId2 == 0) {
                super.setButtonDrawable((Drawable) null);
                this.l = cmz.y(context3, R.drawable.mtrl_checkbox_button);
                this.n = true;
                if (this.m == null) {
                    this.m = cmz.y(context3, R.drawable.mtrl_checkbox_button_icon);
                }
            }
        }
        this.p = cnb.w(context3, factoryPoolsVarAo, 3);
        this.q = ewz.ap(typedArray.getInt(4, -1), PorterDuff.Mode.SRC_IN);
        this.h = typedArray.getBoolean(10, false);
        this.i = typedArray.getBoolean(6, true);
        this.j = typedArray.getBoolean(9, false);
        this.k = typedArray.getText(8);
        if (typedArray.hasValue(7)) {
            setCheckedState(typedArray.getInt(7, 0));
        }
        factoryPoolsVarAo.ae();
        y();
    }

    private String getButtonStateDescription() {
        int i = this.r;
        return i == 1 ? getResources().getString(R.string.mtrl_checkbox_state_description_checked) : i == 0 ? getResources().getString(R.string.mtrl_checkbox_state_description_unchecked) : getResources().getString(R.string.mtrl_checkbox_state_description_indeterminate);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.g == null) {
            int iV = cna.v(this, R.attr.colorControlActivated);
            int iV2 = cna.v(this, R.attr.colorError);
            int iV3 = cna.v(this, R.attr.colorSurface);
            int iV4 = cna.v(this, R.attr.colorOnSurface);
            this.g = new ColorStateList(c, new int[]{cna.ad(iV3, 1.0f, iV2), cna.ad(iV3, 1.0f, iV), cna.ad(iV3, 0.54f, iV4), cna.ad(iV3, 0.38f, iV4), cna.ad(iV3, 0.38f, iV4)});
        }
        return this.g;
    }

    private ColorStateList getSuperButtonTintList() {
        ColorStateList colorStateList = this.o;
        return colorStateList != null ? colorStateList : super.getButtonTintList() != null ? super.getButtonTintList() : getSupportButtonTintList();
    }

    @Override // android.widget.CompoundButton
    public Drawable getButtonDrawable() {
        return this.l;
    }

    public Drawable getButtonIconDrawable() {
        return this.m;
    }

    public ColorStateList getButtonIconTintList() {
        return this.p;
    }

    public PorterDuff.Mode getButtonIconTintMode() {
        return this.q;
    }

    @Override // android.widget.CompoundButton
    public ColorStateList getButtonTintList() {
        return this.o;
    }

    public int getCheckedState() {
        return this.r;
    }

    public CharSequence getErrorAccessibilityLabel() {
        return this.k;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final boolean isChecked() {
        return this.r == 1;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.h && this.o == null && this.p == null) {
            setUseMaterialThemeColors(true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (getCheckedState() == 2) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, a);
        }
        if (this.j) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, b);
        }
        this.s = cmz.w(iArrOnCreateDrawableState);
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        Drawable buttonDrawable;
        if (!this.i || !TextUtils.isEmpty(getText()) || (buttonDrawable = getButtonDrawable()) == null) {
            super.onDraw(canvas);
            return;
        }
        int width = ((getWidth() - buttonDrawable.getIntrinsicWidth()) / 2) * (ewz.al(this) ? -1 : 1);
        int iSave = canvas.save();
        canvas.translate(width, 0.0f);
        super.onDraw(canvas);
        canvas.restoreToCount(iSave);
        if (getBackground() != null) {
            Rect bounds = buttonDrawable.getBounds();
            getBackground().setHotspotBounds(bounds.left + width, bounds.top, bounds.right + width, bounds.bottom);
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (accessibilityNodeInfo != null && this.j) {
            accessibilityNodeInfo.setText(((Object) accessibilityNodeInfo.getText()) + ", " + ((Object) this.k));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof caq)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        caq caqVar = (caq) parcelable;
        super.onRestoreInstanceState(caqVar.getSuperState());
        setCheckedState(caqVar.a);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        caq caqVar = new caq(super.onSaveInstanceState());
        caqVar.a = getCheckedState();
        return caqVar;
    }

    @Override // me.hd.wauxv.obf.hf, android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(cmz.y(getContext(), i));
    }

    public void setButtonIconDrawable(Drawable drawable) {
        this.m = drawable;
        y();
    }

    public void setButtonIconDrawableResource(int i) {
        setButtonIconDrawable(cmz.y(getContext(), i));
    }

    public void setButtonIconTintList(ColorStateList colorStateList) {
        if (this.p == colorStateList) {
            return;
        }
        this.p = colorStateList;
        y();
    }

    public void setButtonIconTintMode(PorterDuff.Mode mode) {
        if (this.q == mode) {
            return;
        }
        this.q = mode;
        y();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintList(ColorStateList colorStateList) {
        if (this.o == colorStateList) {
            return;
        }
        this.o = colorStateList;
        y();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintMode(PorterDuff.Mode mode) {
        setSupportButtonTintMode(mode);
        y();
    }

    public void setCenterIfNoTextEnabled(boolean z) {
        this.i = z;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        setCheckedState(z ? 1 : 0);
    }

    public void setCheckedState(int i) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        if (this.r != i) {
            this.r = i;
            super.setChecked(i == 1);
            refreshDrawableState();
            if (Build.VERSION.SDK_INT >= 30 && this.u == null) {
                super.setStateDescription(getButtonStateDescription());
            }
            if (this.t) {
                return;
            }
            this.t = true;
            LinkedHashSet linkedHashSet = this.f;
            if (linkedHashSet != null) {
                Iterator it = linkedHashSet.iterator();
                if (it.hasNext()) {
                    throw yg.d(it);
                }
            }
            if (this.r != 2 && (onCheckedChangeListener = this.v) != null) {
                onCheckedChangeListener.onCheckedChanged(this, isChecked());
            }
            AutofillManager autofillManager = (AutofillManager) getContext().getSystemService(AutofillManager.class);
            if (autofillManager != null) {
                autofillManager.notifyValueChanged(this);
            }
            this.t = false;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
    }

    public void setErrorAccessibilityLabel(CharSequence charSequence) {
        this.k = charSequence;
    }

    public void setErrorAccessibilityLabelResource(int i) {
        setErrorAccessibilityLabel(i != 0 ? getResources().getText(i) : null);
    }

    public void setErrorShown(boolean z) {
        if (this.j == z) {
            return;
        }
        this.j = z;
        refreshDrawableState();
        Iterator it = this.e.iterator();
        if (it.hasNext()) {
            throw yg.d(it);
        }
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.v = onCheckedChangeListener;
    }

    @Override // android.widget.CompoundButton, android.view.View
    public void setStateDescription(CharSequence charSequence) {
        this.u = charSequence;
        if (charSequence != null) {
            super.setStateDescription(charSequence);
        } else {
            if (Build.VERSION.SDK_INT < 30 || charSequence != null) {
                return;
            }
            super.setStateDescription(getButtonStateDescription());
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.h = z;
        if (z) {
            setButtonTintList(getMaterialThemeColorsTintList());
        } else {
            setButtonTintList(null);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        setChecked(!isChecked());
    }

    public final void y() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ci ciVar;
        this.l = cmz.r(this.l, this.o, getButtonTintMode());
        this.m = cmz.r(this.m, this.p, this.q);
        if (this.n) {
            fe feVar = this.w;
            if (feVar != null) {
                fc fcVar = feVar.a;
                Drawable drawable = feVar.f;
                cap capVar = this.x;
                if (drawable != null) {
                    AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) drawable;
                    if (capVar.a == null) {
                        capVar.a = new ew(capVar);
                    }
                    animatedVectorDrawable.unregisterAnimationCallback(capVar.a);
                }
                ArrayList arrayList = feVar.d;
                if (arrayList != null && capVar != null) {
                    arrayList.remove(capVar);
                    if (feVar.d.size() == 0 && (ciVar = feVar.c) != null) {
                        fcVar.b.removeListener(ciVar);
                        feVar.c = null;
                    }
                }
                Drawable drawable2 = feVar.f;
                if (drawable2 != null) {
                    AnimatedVectorDrawable animatedVectorDrawable2 = (AnimatedVectorDrawable) drawable2;
                    if (capVar.a == null) {
                        capVar.a = new ew(capVar);
                    }
                    animatedVectorDrawable2.registerAnimationCallback(capVar.a);
                } else if (capVar != null) {
                    if (feVar.d == null) {
                        feVar.d = new ArrayList();
                    }
                    if (!feVar.d.contains(capVar)) {
                        feVar.d.add(capVar);
                        if (feVar.c == null) {
                            feVar.c = new ci(feVar, 1);
                        }
                        fcVar.b.addListener(feVar.c);
                    }
                }
            }
            Drawable drawable3 = this.l;
            if ((drawable3 instanceof AnimatedStateListDrawable) && feVar != null) {
                ((AnimatedStateListDrawable) drawable3).addTransition(R.id.checked, R.id.unchecked, feVar, false);
                ((AnimatedStateListDrawable) this.l).addTransition(R.id.indeterminate, R.id.unchecked, feVar, false);
            }
        }
        Drawable drawable4 = this.l;
        if (drawable4 != null && (colorStateList2 = this.o) != null) {
            drawable4.setTintList(colorStateList2);
        }
        Drawable drawable5 = this.m;
        if (drawable5 != null && (colorStateList = this.p) != null) {
            drawable5.setTintList(colorStateList);
        }
        super.setButtonDrawable(cmz.q(this.l, this.m, -1, -1));
        refreshDrawableState();
    }

    @Override // me.hd.wauxv.obf.hf, android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        this.l = drawable;
        this.n = false;
        y();
    }
}
