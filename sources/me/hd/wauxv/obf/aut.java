package me.hd.wauxv.obf;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aut implements TextWatcher {
    public final EditText a;
    public aus b;
    public boolean c = true;

    public aut(EditText editText) {
        this.a = editText;
    }

    public static void d(EditText editText, int i) {
        int length;
        if (i == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            atf atfVarL = atf.l();
            if (editableText == null) {
                length = 0;
            } else {
                atfVarL.getClass();
                length = editableText.length();
            }
            atfVarL.p(0, length, editableText);
            if (selectionStart >= 0 && selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionStart, selectionEnd);
            } else if (selectionStart >= 0) {
                Selection.setSelection(editableText, selectionStart);
            } else if (selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionEnd);
            }
        }
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) throws Throwable {
        EditText editText = this.a;
        if (editText.isInEditMode() || !this.c || atf.b == null || i2 > i3 || !(charSequence instanceof Spannable)) {
            return;
        }
        int iM = atf.l().m();
        if (iM != 0) {
            if (iM == 1) {
                atf.l().p(i, i3 + i, (Spannable) charSequence);
                return;
            } else if (iM != 3) {
                return;
            }
        }
        atf atfVarL = atf.l();
        if (this.b == null) {
            this.b = new aus(editText);
        }
        atfVarL.q(this.b);
    }
}
