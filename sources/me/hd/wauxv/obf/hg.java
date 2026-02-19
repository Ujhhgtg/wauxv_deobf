package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class hg extends CheckedTextView {
    public final hh a;
    public final ea b;
    public final jl c;
    public ii d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hg(Context context, AttributeSet attributeSet) {
        int resourceId;
        int resourceId2;
        super(context, attributeSet, R.attr.checkedTextViewStyle);
        ekd.b(context);
        drm.h(this, getContext());
        jl jlVar = new jl(this);
        this.c = jlVar;
        jlVar.t(attributeSet, R.attr.checkedTextViewStyle);
        jlVar.q();
        ea eaVar = new ea(this);
        this.b = eaVar;
        eaVar.t(attributeSet, R.attr.checkedTextViewStyle);
        this.a = new hh(this);
        Context context2 = getContext();
        int[] iArr = cyf.l;
        FactoryPools factoryPoolsVarK = FactoryPools.k(context2, attributeSet, iArr, R.attr.checkedTextViewStyle);
        TypedArray typedArray = (TypedArray) factoryPoolsVarK.e;
        ViewCompat.r(this, getContext(), iArr, attributeSet, (TypedArray) factoryPoolsVarK.e, R.attr.checkedTextViewStyle, 0);
        try {
            if (typedArray.hasValue(1) && (resourceId2 = typedArray.getResourceId(1, 0)) != 0) {
                try {
                    setCheckMarkDrawable(cmz.y(getContext(), resourceId2));
                } catch (Resources.NotFoundException unused) {
                    if (typedArray.hasValue(0)) {
                        setCheckMarkDrawable(cmz.y(getContext(), resourceId));
                    }
                }
            } else if (typedArray.hasValue(0) && (resourceId = typedArray.getResourceId(0, 0)) != 0) {
                setCheckMarkDrawable(cmz.y(getContext(), resourceId));
            }
            if (typedArray.hasValue(2)) {
                setCheckMarkTintList(factoryPoolsVarK.r(2));
            }
            if (typedArray.hasValue(3)) {
                setCheckMarkTintMode(apy.f(typedArray.getInt(3, -1), null));
            }
            factoryPoolsVarK.ae();
            getEmojiTextViewHelper().d(attributeSet, R.attr.checkedTextViewStyle);
        } catch (Throwable th) {
            factoryPoolsVarK.ae();
            throw th;
        }
    }

    private ii getEmojiTextViewHelper() {
        if (this.d == null) {
            this.d = new ii(this);
        }
        return this.d;
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        jl jlVar = this.c;
        if (jlVar != null) {
            jlVar.q();
        }
        ea eaVar = this.b;
        if (eaVar != null) {
            eaVar.h();
        }
        hh hhVar = this.a;
        if (hhVar != null) {
            hhVar.h();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return cnb.ar(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        ea eaVar = this.b;
        if (eaVar != null) {
            return eaVar.q();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        ea eaVar = this.b;
        if (eaVar != null) {
            return eaVar.r();
        }
        return null;
    }

    public ColorStateList getSupportCheckMarkTintList() {
        hh hhVar = this.a;
        if (hhVar != null) {
            return hhVar.a;
        }
        return null;
    }

    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        hh hhVar = this.a;
        if (hhVar != null) {
            return hhVar.b;
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.c.r();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.c.s();
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        KotlinHelpers.ak(editorInfo, inputConnectionOnCreateInputConnection, this);
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().e(z);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        ea eaVar = this.b;
        if (eaVar != null) {
            eaVar.v();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        ea eaVar = this.b;
        if (eaVar != null) {
            eaVar.w(i);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        hh hhVar = this.a;
        if (hhVar != null) {
            if (hhVar.e) {
                hhVar.e = false;
            } else {
                hhVar.e = true;
                hhVar.h();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        jl jlVar = this.c;
        if (jlVar != null) {
            jlVar.q();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        jl jlVar = this.c;
        if (jlVar != null) {
            jlVar.q();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(cnb.as(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().f(z);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        ea eaVar = this.b;
        if (eaVar != null) {
            eaVar.ab(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        ea eaVar = this.b;
        if (eaVar != null) {
            eaVar.ac(mode);
        }
    }

    public void setSupportCheckMarkTintList(ColorStateList colorStateList) {
        hh hhVar = this.a;
        if (hhVar != null) {
            hhVar.a = colorStateList;
            hhVar.c = true;
            hhVar.h();
        }
    }

    public void setSupportCheckMarkTintMode(PorterDuff.Mode mode) {
        hh hhVar = this.a;
        if (hhVar != null) {
            hhVar.b = mode;
            hhVar.d = true;
            hhVar.h();
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        jl jlVar = this.c;
        jlVar.v(colorStateList);
        jlVar.q();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        jl jlVar = this.c;
        jlVar.w(mode);
        jlVar.q();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        jl jlVar = this.c;
        if (jlVar != null) {
            jlVar.u(context, i);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i) {
        setCheckMarkDrawable(cmz.y(getContext(), i));
    }
}
