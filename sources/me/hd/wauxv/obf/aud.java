package me.hd.wauxv.obf;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.widget.TextView;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aud extends atd {
    public final WeakReference c;
    public final WeakReference d;

    public aud(TextView textView, aue aueVar) {
        this.c = new WeakReference(textView);
        this.d = new WeakReference(aueVar);
    }

    @Override // me.hd.wauxv.obf.atd
    public final void b() throws Throwable {
        InputFilter[] filters;
        int length;
        TextView textView = (TextView) this.c.get();
        InputFilter inputFilter = (InputFilter) this.d.get();
        if (inputFilter == null || textView == null || (filters = textView.getFilters()) == null) {
            return;
        }
        for (InputFilter inputFilter2 : filters) {
            if (inputFilter2 == inputFilter) {
                if (textView.isAttachedToWindow()) {
                    CharSequence text = textView.getText();
                    atf atfVarL = atf.l();
                    if (text == null) {
                        length = 0;
                    } else {
                        atfVarL.getClass();
                        length = text.length();
                    }
                    CharSequence charSequenceP = atfVarL.p(0, length, text);
                    if (text == charSequenceP) {
                        return;
                    }
                    int selectionStart = Selection.getSelectionStart(charSequenceP);
                    int selectionEnd = Selection.getSelectionEnd(charSequenceP);
                    textView.setText(charSequenceP);
                    if (charSequenceP instanceof Spannable) {
                        Spannable spannable = (Spannable) charSequenceP;
                        if (selectionStart >= 0 && selectionEnd >= 0) {
                            Selection.setSelection(spannable, selectionStart, selectionEnd);
                            return;
                        } else if (selectionStart >= 0) {
                            Selection.setSelection(spannable, selectionStart);
                            return;
                        } else {
                            if (selectionEnd >= 0) {
                                Selection.setSelection(spannable, selectionEnd);
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                return;
            }
        }
    }
}
