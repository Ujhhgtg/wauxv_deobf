package me.hd.wauxv.obf;

import android.view.View;
import android.widget.LinearLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cem implements eqj {
    public final /* synthetic */ int a;
    public final LinearLayout b;
    public final TextInputEditText c;
    public final TextInputEditText d;

    public /* synthetic */ cem(LinearLayout linearLayout, TextInputEditText textInputEditText, TextInputEditText textInputEditText2, int i) {
        this.a = i;
        this.b = linearLayout;
        this.c = textInputEditText;
        this.d = textInputEditText2;
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
            case 4:
                break;
            case 5:
                break;
        }
        return this.b;
    }

    public /* synthetic */ cem(LinearLayout linearLayout, TextInputEditText textInputEditText, MaterialTextView materialTextView, TextInputEditText textInputEditText2, int i) {
        this.a = i;
        this.b = linearLayout;
        this.c = textInputEditText;
        this.d = textInputEditText2;
    }

    public cem(LinearLayout linearLayout, MaterialButton materialButton, TextInputEditText textInputEditText, TextInputEditText textInputEditText2) {
        this.a = 2;
        this.b = linearLayout;
        this.c = textInputEditText;
        this.d = textInputEditText2;
    }
}
