package me.hd.wauxv.obf;

import android.text.InputFilter;
import android.text.Spanned;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aue implements InputFilter {
    public final TextView a;
    public aud b;

    public aue(TextView textView) {
        this.a = textView;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        TextView textView = this.a;
        if (textView.isInEditMode()) {
            return charSequence;
        }
        int iM = atf.l().m();
        if (iM != 0) {
            if (iM == 1) {
                if ((i4 == 0 && i3 == 0 && spanned.length() == 0 && charSequence == textView.getText()) || charSequence == null) {
                    return charSequence;
                }
                if (i != 0 || i2 != charSequence.length()) {
                    charSequence = charSequence.subSequence(i, i2);
                }
                return atf.l().p(0, charSequence.length(), charSequence);
            }
            if (iM != 3) {
                return charSequence;
            }
        }
        atf atfVarL = atf.l();
        if (this.b == null) {
            this.b = new aud(textView, this);
        }
        atfVarL.q(this.b);
        return charSequence;
    }
}
