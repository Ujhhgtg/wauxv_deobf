package me.hd.wauxv.obf;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cen implements eqj {
    public final /* synthetic */ int a = 1;
    public final LinearLayout b;
    public final CompoundButton c;
    public final CompoundButton d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    public final View l;
    public final View m;

    public cen(LinearLayout linearLayout, MaterialRadioButton materialRadioButton, MaterialRadioButton materialRadioButton2, MaterialRadioButton materialRadioButton3, MaterialRadioButton materialRadioButton4, MaterialRadioButton materialRadioButton5, MaterialRadioButton materialRadioButton6, MaterialRadioButton materialRadioButton7, MaterialRadioButton materialRadioButton8, MaterialRadioButton materialRadioButton9, RadioGroup radioGroup, RadioGroup radioGroup2) {
        this.b = linearLayout;
        this.c = materialRadioButton;
        this.d = materialRadioButton2;
        this.e = materialRadioButton3;
        this.f = materialRadioButton4;
        this.g = materialRadioButton5;
        this.h = materialRadioButton6;
        this.i = materialRadioButton7;
        this.j = materialRadioButton8;
        this.k = materialRadioButton9;
        this.l = radioGroup;
        this.m = radioGroup2;
    }

    @Override // me.hd.wauxv.obf.eqj
    public final View getRoot() {
        switch (this.a) {
            case 0:
                break;
        }
        return this.b;
    }

    public cen(LinearLayout linearLayout, MaterialCheckBox materialCheckBox, MaterialCheckBox materialCheckBox2, TextInputEditText textInputEditText, TextInputEditText textInputEditText2, TextInputEditText textInputEditText3, TextInputEditText textInputEditText4, TextInputEditText textInputEditText5, TextInputEditText textInputEditText6, TextInputEditText textInputEditText7, TextInputEditText textInputEditText8, MaterialTextView materialTextView, TextInputEditText textInputEditText9) {
        this.b = linearLayout;
        this.c = materialCheckBox;
        this.d = materialCheckBox2;
        this.e = textInputEditText;
        this.f = textInputEditText2;
        this.g = textInputEditText3;
        this.h = textInputEditText4;
        this.i = textInputEditText5;
        this.j = textInputEditText6;
        this.k = textInputEditText7;
        this.l = textInputEditText8;
        this.m = textInputEditText9;
    }
}
