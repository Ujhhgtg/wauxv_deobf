package me.hd.wauxv.obf;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import android.widget.TextView;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ih extends EditText implements crb {
    public final ea c;
    public final jl d;
    public final DefaultConfig e;
    public final dri f;
    public final DefaultConfig g;
    public ig h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ih(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.editTextStyle);
        ekd.b(context);
        drm.h(this, getContext());
        ea eaVar = new ea(this);
        this.c = eaVar;
        eaVar.t(attributeSet, R.attr.editTextStyle);
        jl jlVar = new jl(this);
        this.d = jlVar;
        jlVar.t(attributeSet, R.attr.editTextStyle);
        jlVar.q();
        DefaultConfig ioVar = new DefaultConfig(5, false);
        ioVar.c = this;
        this.e = ioVar;
        this.f = new dri();
        DefaultConfig ioVar2 = new DefaultConfig((EditText) this, 4);
        this.g = ioVar2;
        ioVar2.am(attributeSet, R.attr.editTextStyle);
        KeyListener keyListener = getKeyListener();
        if (keyListener instanceof NumberKeyListener) {
            return;
        }
        boolean zIsFocusable = super.isFocusable();
        boolean zIsClickable = super.isClickable();
        boolean zIsLongClickable = super.isLongClickable();
        int inputType = super.getInputType();
        KeyListener keyListenerAi = ioVar2.ai(keyListener);
        if (keyListenerAi == keyListener) {
            return;
        }
        super.setKeyListener(keyListenerAi);
        super.setRawInputType(inputType);
        super.setFocusable(zIsFocusable);
        super.setClickable(zIsClickable);
        super.setLongClickable(zIsLongClickable);
    }

    private ig getSuperCaller() {
        if (this.h == null) {
            this.h = new ig(this);
        }
        return this.h;
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        ea eaVar = this.c;
        if (eaVar != null) {
            eaVar.h();
        }
        jl jlVar = this.d;
        if (jlVar != null) {
            jlVar.q();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return cnb.ar(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        ea eaVar = this.c;
        if (eaVar != null) {
            return eaVar.q();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        ea eaVar = this.c;
        if (eaVar != null) {
            return eaVar.r();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.d.r();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.d.s();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        DefaultConfig ioVar;
        if (Build.VERSION.SDK_INT >= 28 || (ioVar = this.e) == null) {
            return super.getTextClassifier();
        }
        TextClassifier textClassifier = (TextClassifier) ioVar.d;
        return textClassifier == null ? jf.a((TextView) ioVar.c) : textClassifier;
    }

    @Override // me.hd.wauxv.obf.crb
    public final afm i(afm afmVar) {
        this.f.getClass();
        return dri.a(this, afmVar);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        String[] strArrM;
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.d.getClass();
        jl.o(editorInfo, inputConnectionOnCreateInputConnection, this);
        KotlinHelpers.ak(editorInfo, inputConnectionOnCreateInputConnection, this);
        if (inputConnectionOnCreateInputConnection != null && Build.VERSION.SDK_INT <= 30 && (strArrM = ViewCompat.m(this)) != null) {
            editorInfo.contentMimeTypes = strArrM;
            inputConnectionOnCreateInputConnection = new InputConnectionCompat(inputConnectionOnCreateInputConnection, new qp(this, 8));
        }
        return this.g.an(inputConnectionOnCreateInputConnection, editorInfo);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int i = Build.VERSION.SDK_INT;
        if (i < 30 || i >= 33) {
            return;
        }
        ((InputMethodManager) getContext().getSystemService("input_method")).isActive(this);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onDragEvent(DragEvent dragEvent) {
        Activity activity;
        boolean zA = false;
        if (Build.VERSION.SDK_INT < 31 && dragEvent.getLocalState() == null && ViewCompat.m(this) != null) {
            Context context = getContext();
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    activity = null;
                    break;
                }
                if (context instanceof Activity) {
                    activity = (Activity) context;
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            }
            if (activity == null) {
                Log.i("ReceiveContent", "Can't handle drop: no activity: view=" + this);
            } else if (dragEvent.getAction() != 1 && dragEvent.getAction() == 3) {
                zA = ir.a(dragEvent, this, activity);
            }
        }
        if (zA) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public final boolean onTextContextMenuItem(int i) {
        afk afkVar;
        afj afjVar;
        int i2;
        erp erpVar;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 31 || ViewCompat.m(this) == null || !(i == 16908322 || i == 16908337)) {
            return super.onTextContextMenuItem(i);
        }
        ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
        ClipData primaryClip = clipboardManager == null ? null : clipboardManager.getPrimaryClip();
        if (primaryClip != null && primaryClip.getItemCount() > 0) {
            if (i3 >= 31) {
                erpVar = new erp(primaryClip, 1);
            } else {
                afkVar = new afk();
                afkVar.b = primaryClip;
                afkVar.c = 1;
            }
            if (i == 16908322) {
                afjVar = afkVar;
                afjVar = erpVar;
                i2 = 0;
            } else {
                afjVar = afkVar;
                afjVar = erpVar;
                i2 = 1;
            }
            afjVar.k(i2);
            ViewCompat.o(this, afjVar.build());
        }
        return true;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        ea eaVar = this.c;
        if (eaVar != null) {
            eaVar.v();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        ea eaVar = this.c;
        if (eaVar != null) {
            eaVar.w(i);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        jl jlVar = this.d;
        if (jlVar != null) {
            jlVar.q();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        jl jlVar = this.d;
        if (jlVar != null) {
            jlVar.q();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(cnb.as(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z) {
        this.g.aw(z);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.g.ai(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        ea eaVar = this.c;
        if (eaVar != null) {
            eaVar.ab(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        ea eaVar = this.c;
        if (eaVar != null) {
            eaVar.ac(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        jl jlVar = this.d;
        jlVar.v(colorStateList);
        jlVar.q();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        jl jlVar = this.d;
        jlVar.w(mode);
        jlVar.q();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        jl jlVar = this.d;
        if (jlVar != null) {
            jlVar.u(context, i);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        DefaultConfig ioVar;
        if (Build.VERSION.SDK_INT >= 28 || (ioVar = this.e) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            ioVar.d = textClassifier;
        }
    }

    @Override // android.widget.EditText, android.widget.TextView
    public Editable getText() {
        return Build.VERSION.SDK_INT >= 28 ? super.getText() : super.getEditableText();
    }
}
