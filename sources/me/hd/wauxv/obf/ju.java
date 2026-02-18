package me.hd.wauxv.obf;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.ToggleButton;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ju extends ToggleButton {
    public final ea a;
    public final jl b;
    public ii c;

    public ju(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.buttonStyleToggle);
        drm.h(this, getContext());
        ea eaVar = new ea(this);
        this.a = eaVar;
        eaVar.t(attributeSet, R.attr.buttonStyleToggle);
        jl jlVar = new jl(this);
        this.b = jlVar;
        jlVar.t(attributeSet, R.attr.buttonStyleToggle);
        getEmojiTextViewHelper().d(attributeSet, R.attr.buttonStyleToggle);
    }

    private ii getEmojiTextViewHelper() {
        if (this.c == null) {
            this.c = new ii(this);
        }
        return this.c;
    }

    @Override // android.widget.ToggleButton, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        ea eaVar = this.a;
        if (eaVar != null) {
            eaVar.h();
        }
        jl jlVar = this.b;
        if (jlVar != null) {
            jlVar.q();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        ea eaVar = this.a;
        if (eaVar != null) {
            return eaVar.q();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        ea eaVar = this.a;
        if (eaVar != null) {
            return eaVar.r();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.b.r();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.b.s();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().e(z);
    }

    @Override // android.widget.ToggleButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        ea eaVar = this.a;
        if (eaVar != null) {
            eaVar.v();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        ea eaVar = this.a;
        if (eaVar != null) {
            eaVar.w(i);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        jl jlVar = this.b;
        if (jlVar != null) {
            jlVar.q();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        jl jlVar = this.b;
        if (jlVar != null) {
            jlVar.q();
        }
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().f(z);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().c(inputFilterArr));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        ea eaVar = this.a;
        if (eaVar != null) {
            eaVar.ab(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        ea eaVar = this.a;
        if (eaVar != null) {
            eaVar.ac(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        jl jlVar = this.b;
        jlVar.v(colorStateList);
        jlVar.q();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        jl jlVar = this.b;
        jlVar.w(mode);
        jlVar.q();
    }
}
