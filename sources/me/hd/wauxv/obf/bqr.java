package me.hd.wauxv.obf;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bqr implements eqj {
    public final /* synthetic */ int a;
    public final LinearLayout b;
    public final TextView c;
    public final View d;
    public final View e;

    public /* synthetic */ bqr(LinearLayout linearLayout, View view, TextView textView, View view2, int i) {
        this.a = i;
        this.b = linearLayout;
        this.d = view;
        this.c = textView;
        this.e = view2;
    }

    @Override // me.hd.wauxv.obf.eqj
    public final View getRoot() {
        switch (this.a) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
        return this.b;
    }

    public bqr(LinearLayout linearLayout, MaterialCheckBox materialCheckBox, TextInputEditText textInputEditText, MaterialTextView materialTextView, MaterialTextView materialTextView2) {
        this.a = 1;
        this.b = linearLayout;
        this.d = materialCheckBox;
        this.e = textInputEditText;
        this.c = materialTextView;
    }

    public bqr(LinearLayout linearLayout, MaterialCheckBox materialCheckBox, TextInputEditText textInputEditText, MaterialTextView materialTextView, TextInputEditText textInputEditText2) {
        this.a = 2;
        this.b = linearLayout;
        this.d = materialCheckBox;
        this.c = textInputEditText;
        this.e = textInputEditText2;
    }

    public bqr(LinearLayout linearLayout, MaterialButton materialButton, TextInputEditText textInputEditText, MaterialRadioButton materialRadioButton, MaterialRadioButton materialRadioButton2, RadioGroup radioGroup, RecyclerView recyclerView) {
        this.a = 4;
        this.b = linearLayout;
        this.d = textInputEditText;
        this.c = materialRadioButton;
        this.e = materialRadioButton2;
    }
}
