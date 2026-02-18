package me.hd.wauxv.obf;

import android.text.Editable;
import android.text.TextWatcher;
import com.google.android.material.textview.MaterialTextView;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class wg implements TextWatcher {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ wg(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    private final void c(int i, int i2, int i3, CharSequence charSequence) {
    }

    private final void d(int i, int i2, int i3, CharSequence charSequence) {
    }

    private final void e(int i, int i2, int i3, CharSequence charSequence) {
    }

    private final void f(int i, int i2, int i3, CharSequence charSequence) {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        switch (this.a) {
            case 0:
                MaterialTextView materialTextView = (MaterialTextView) ((bqr) this.b).c;
                wh whVar = wh.a;
                String strValueOf = String.valueOf(editable);
                whVar.getClass();
                materialTextView.setText(wh.l(strValueOf));
                break;
            default:
                ((aek) this.b).p(String.valueOf(editable));
                break;
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        int i4 = this.a;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        int i4 = this.a;
    }
}
