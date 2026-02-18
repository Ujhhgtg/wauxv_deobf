package me.hd.wauxv.obf;

import android.view.View;
import android.widget.LinearLayout;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputEditText;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cej implements eqj {
    public final LinearLayout a;
    public final MaterialCheckBox b;
    public final TextInputEditText c;
    public final TextInputEditText d;
    public final TextInputEditText e;
    public final TextInputEditText f;
    public final TextInputEditText g;
    public final TextInputEditText h;
    public final TextInputEditText i;
    public final TextInputEditText j;

    public cej(LinearLayout linearLayout, MaterialCheckBox materialCheckBox, TextInputEditText textInputEditText, TextInputEditText textInputEditText2, TextInputEditText textInputEditText3, TextInputEditText textInputEditText4, TextInputEditText textInputEditText5, TextInputEditText textInputEditText6, TextInputEditText textInputEditText7, TextInputEditText textInputEditText8) {
        this.a = linearLayout;
        this.b = materialCheckBox;
        this.c = textInputEditText;
        this.d = textInputEditText2;
        this.e = textInputEditText3;
        this.f = textInputEditText4;
        this.g = textInputEditText5;
        this.h = textInputEditText6;
        this.i = textInputEditText7;
        this.j = textInputEditText8;
    }

    @Override // me.hd.wauxv.obf.eqj
    public final View getRoot() {
        return this.a;
    }
}
