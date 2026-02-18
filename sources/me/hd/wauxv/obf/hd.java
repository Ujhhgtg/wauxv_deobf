package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class hd extends Button {
    public final ea u;
    public final jl v;
    public ii w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hd(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ekd.b(context);
        drm.h(this, getContext());
        ea eaVar = new ea(this);
        this.u = eaVar;
        eaVar.t(attributeSet, i);
        jl jlVar = new jl(this);
        this.v = jlVar;
        jlVar.t(attributeSet, i);
        jlVar.q();
        getEmojiTextViewHelper().d(attributeSet, i);
    }

    private ii getEmojiTextViewHelper() {
        if (this.w == null) {
            this.w = new ii(this);
        }
        return this.w;
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        ea eaVar = this.u;
        if (eaVar != null) {
            eaVar.h();
        }
        jl jlVar = this.v;
        if (jlVar != null) {
            jlVar.q();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        return super.getAutoSizeMaxTextSize();
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        return super.getAutoSizeMinTextSize();
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        return super.getAutoSizeStepGranularity();
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        return super.getAutoSizeTextAvailableSizes();
    }

    @Override // android.widget.TextView
    public int getAutoSizeTextType() {
        return super.getAutoSizeTextType() == 1 ? 1 : 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return cnb.ar(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        ea eaVar = this.u;
        if (eaVar != null) {
            return eaVar.q();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        ea eaVar = this.u;
        if (eaVar != null) {
            return eaVar.r();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.v.r();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.v.s();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        jl jlVar = this.v;
        if (jlVar != null) {
            jlVar.getClass();
        }
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().e(z);
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i) {
        super.setAutoSizeTextTypeWithDefaults(i);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        ea eaVar = this.u;
        if (eaVar != null) {
            eaVar.v();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        ea eaVar = this.u;
        if (eaVar != null) {
            eaVar.w(i);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(cnb.as(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().f(z);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().c(inputFilterArr));
    }

    public void setSupportAllCaps(boolean z) {
        jl jlVar = this.v;
        if (jlVar != null) {
            jlVar.a.setAllCaps(z);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        ea eaVar = this.u;
        if (eaVar != null) {
            eaVar.ab(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        ea eaVar = this.u;
        if (eaVar != null) {
            eaVar.ac(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        jl jlVar = this.v;
        jlVar.v(colorStateList);
        jlVar.q();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        jl jlVar = this.v;
        jlVar.w(mode);
        jlVar.q();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        jl jlVar = this.v;
        if (jlVar != null) {
            jlVar.u(context, i);
        }
    }
}
