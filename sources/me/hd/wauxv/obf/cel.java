package me.hd.wauxv.obf;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.TextInputEditText;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cel implements eqj {
    public final LinearLayout a;
    public final TextInputEditText b;
    public final TextInputEditText c;
    public final TextInputEditText d;
    public final TextInputEditText e;
    public final TextInputEditText f;
    public final TextInputEditText g;
    public final TextInputEditText h;
    public final TextInputEditText i;
    public final TextInputEditText j;
    public final MaterialRadioButton k;
    public final MaterialRadioButton l;
    public final MaterialRadioButton m;
    public final RadioGroup n;

    public cel(LinearLayout linearLayout, TextInputEditText textInputEditText, TextInputEditText textInputEditText2, TextInputEditText textInputEditText3, TextInputEditText textInputEditText4, TextInputEditText textInputEditText5, TextInputEditText textInputEditText6, TextInputEditText textInputEditText7, TextInputEditText textInputEditText8, TextInputEditText textInputEditText9, MaterialRadioButton materialRadioButton, MaterialRadioButton materialRadioButton2, MaterialRadioButton materialRadioButton3, RadioGroup radioGroup) {
        this.a = linearLayout;
        this.b = textInputEditText;
        this.c = textInputEditText2;
        this.d = textInputEditText3;
        this.e = textInputEditText4;
        this.f = textInputEditText5;
        this.g = textInputEditText6;
        this.h = textInputEditText7;
        this.i = textInputEditText8;
        this.j = textInputEditText9;
        this.k = materialRadioButton;
        this.l = materialRadioButton2;
        this.m = materialRadioButton3;
        this.n = radioGroup;
    }

    @Override // me.hd.wauxv.obf.eqj
    public final View getRoot() {
        return this.a;
    }
}
