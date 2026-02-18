package me.hd.wauxv.obf;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class im extends MultiAutoCompleteTextView {
    public static final int[] a = {R.attr.popupBackground};
    public final ea b;
    public final jl c;
    public final io d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public im(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, me.hd.wauxv.R.attr.autoCompleteTextViewStyle);
        ekd.b(context);
        drm.h(this, getContext());
        jx jxVarK = jx.k(getContext(), attributeSet, a, me.hd.wauxv.R.attr.autoCompleteTextViewStyle);
        if (((TypedArray) jxVarK.e).hasValue(0)) {
            setDropDownBackgroundDrawable(jxVarK.s(0));
        }
        jxVarK.ae();
        ea eaVar = new ea(this);
        this.b = eaVar;
        eaVar.t(attributeSet, me.hd.wauxv.R.attr.autoCompleteTextViewStyle);
        jl jlVar = new jl(this);
        this.c = jlVar;
        jlVar.t(attributeSet, me.hd.wauxv.R.attr.autoCompleteTextViewStyle);
        jlVar.q();
        io ioVar = new io((EditText) this, 4);
        this.d = ioVar;
        ioVar.am(attributeSet, me.hd.wauxv.R.attr.autoCompleteTextViewStyle);
        KeyListener keyListener = getKeyListener();
        if (keyListener instanceof NumberKeyListener) {
            return;
        }
        boolean zIsFocusable = isFocusable();
        boolean zIsClickable = isClickable();
        boolean zIsLongClickable = isLongClickable();
        int inputType = getInputType();
        KeyListener keyListenerAi = ioVar.ai(keyListener);
        if (keyListenerAi == keyListener) {
            return;
        }
        super.setKeyListener(keyListenerAi);
        setRawInputType(inputType);
        setFocusable(zIsFocusable);
        setClickable(zIsClickable);
        setLongClickable(zIsLongClickable);
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        ea eaVar = this.b;
        if (eaVar != null) {
            eaVar.h();
        }
        jl jlVar = this.c;
        if (jlVar != null) {
            jlVar.q();
        }
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

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.c.r();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.c.s();
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        bzo.ak(editorInfo, inputConnectionOnCreateInputConnection, this);
        return this.d.an(inputConnectionOnCreateInputConnection, editorInfo);
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

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(cmz.y(getContext(), i));
    }

    public void setEmojiCompatEnabled(boolean z) {
        this.d.aw(z);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.d.ai(keyListener));
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
}
