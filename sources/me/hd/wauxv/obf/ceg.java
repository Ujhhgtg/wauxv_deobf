package me.hd.wauxv.obf;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputEditText;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ceg implements eqj {
    public final /* synthetic */ int a = 0;
    public final LinearLayout b;
    public final TextInputEditText c;
    public final TextInputEditText d;
    public final TextInputEditText e;
    public final TextInputEditText f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    public final TextView j;

    public ceg(LinearLayout linearLayout, MaterialCheckBox materialCheckBox, MaterialCheckBox materialCheckBox2, MaterialCheckBox materialCheckBox3, MaterialCheckBox materialCheckBox4, TextInputEditText textInputEditText, TextInputEditText textInputEditText2, TextInputEditText textInputEditText3, TextInputEditText textInputEditText4) {
        this.b = linearLayout;
        this.g = materialCheckBox;
        this.h = materialCheckBox2;
        this.i = materialCheckBox3;
        this.j = materialCheckBox4;
        this.c = textInputEditText;
        this.d = textInputEditText2;
        this.e = textInputEditText3;
        this.f = textInputEditText4;
    }

    @Override // me.hd.wauxv.obf.eqj
    public final View getRoot() {
        switch (this.a) {
            case 0:
                break;
        }
        return this.b;
    }

    public ceg(LinearLayout linearLayout, TextInputEditText textInputEditText, TextInputEditText textInputEditText2, TextInputEditText textInputEditText3, TextInputEditText textInputEditText4, TextInputEditText textInputEditText5, TextInputEditText textInputEditText6, TextInputEditText textInputEditText7, TextInputEditText textInputEditText8) {
        this.b = linearLayout;
        this.c = textInputEditText;
        this.d = textInputEditText2;
        this.e = textInputEditText3;
        this.f = textInputEditText4;
        this.g = textInputEditText5;
        this.h = textInputEditText6;
        this.i = textInputEditText7;
        this.j = textInputEditText8;
    }
}
