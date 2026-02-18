package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.RadioButton;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ip extends RadioButton implements ekg {
    public final hh d;
    public final ea e;
    public final jl f;
    public ii g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, R.attr.radioButtonStyle);
        ekd.b(context);
        drm.h(this, getContext());
        hh hhVar = new hh(this);
        this.d = hhVar;
        hhVar.i(attributeSet, R.attr.radioButtonStyle);
        ea eaVar = new ea(this);
        this.e = eaVar;
        eaVar.t(attributeSet, R.attr.radioButtonStyle);
        jl jlVar = new jl(this);
        this.f = jlVar;
        jlVar.t(attributeSet, R.attr.radioButtonStyle);
        getEmojiTextViewHelper().d(attributeSet, R.attr.radioButtonStyle);
    }

    private ii getEmojiTextViewHelper() {
        if (this.g == null) {
            this.g = new ii(this);
        }
        return this.g;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        ea eaVar = this.e;
        if (eaVar != null) {
            eaVar.h();
        }
        jl jlVar = this.f;
        if (jlVar != null) {
            jlVar.q();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        ea eaVar = this.e;
        if (eaVar != null) {
            return eaVar.q();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        ea eaVar = this.e;
        if (eaVar != null) {
            return eaVar.r();
        }
        return null;
    }

    @Override // me.hd.wauxv.obf.ekg
    public ColorStateList getSupportButtonTintList() {
        hh hhVar = this.d;
        if (hhVar != null) {
            return hhVar.a;
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        hh hhVar = this.d;
        if (hhVar != null) {
            return hhVar.b;
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f.r();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f.s();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().e(z);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        ea eaVar = this.e;
        if (eaVar != null) {
            eaVar.v();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        ea eaVar = this.e;
        if (eaVar != null) {
            eaVar.w(i);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        hh hhVar = this.d;
        if (hhVar != null) {
            if (hhVar.e) {
                hhVar.e = false;
            } else {
                hhVar.e = true;
                hhVar.g();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        jl jlVar = this.f;
        if (jlVar != null) {
            jlVar.q();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        jl jlVar = this.f;
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
        ea eaVar = this.e;
        if (eaVar != null) {
            eaVar.ab(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        ea eaVar = this.e;
        if (eaVar != null) {
            eaVar.ac(mode);
        }
    }

    @Override // me.hd.wauxv.obf.ekg
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        hh hhVar = this.d;
        if (hhVar != null) {
            hhVar.a = colorStateList;
            hhVar.c = true;
            hhVar.g();
        }
    }

    @Override // me.hd.wauxv.obf.ekg
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        hh hhVar = this.d;
        if (hhVar != null) {
            hhVar.b = mode;
            hhVar.d = true;
            hhVar.g();
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        jl jlVar = this.f;
        jlVar.v(colorStateList);
        jlVar.q();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        jl jlVar = this.f;
        jlVar.w(mode);
        jlVar.q();
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(cmz.y(getContext(), i));
    }
}
