package me.hd.wauxv.obf;

import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class avy {
    public final /* synthetic */ awa a;

    public avy(awa awaVar) {
        this.a = awaVar;
    }

    public final void b(TextInputLayout textInputLayout) {
        awa awaVar = this.a;
        avx avxVar = awaVar.v;
        if (awaVar.s == textInputLayout.getEditText()) {
            return;
        }
        EditText editText = awaVar.s;
        if (editText != null) {
            editText.removeTextChangedListener(avxVar);
            if (awaVar.s.getOnFocusChangeListener() == awaVar.x().m()) {
                awaVar.s.setOnFocusChangeListener(null);
            }
        }
        EditText editText2 = textInputLayout.getEditText();
        awaVar.s = editText2;
        if (editText2 != null) {
            editText2.addTextChangedListener(avxVar);
        }
        awaVar.x().p(awaVar.s);
        awaVar.af(awaVar.x());
    }
}
