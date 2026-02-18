package me.hd.wauxv.obf;

import android.view.View;
import android.widget.LinearLayout;
import com.google.android.material.textfield.TextInputEditText;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ceo implements eqj {
    public final /* synthetic */ int a;
    public final LinearLayout b;
    public final TextInputEditText c;
    public final TextInputEditText d;
    public final TextInputEditText e;
    public final TextInputEditText f;

    public /* synthetic */ ceo(LinearLayout linearLayout, TextInputEditText textInputEditText, TextInputEditText textInputEditText2, TextInputEditText textInputEditText3, TextInputEditText textInputEditText4, int i) {
        this.a = i;
        this.b = linearLayout;
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
            case 1:
                break;
        }
        return this.b;
    }
}
