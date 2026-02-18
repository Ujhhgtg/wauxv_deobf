package me.hd.wauxv.obf;

import android.view.View;
import android.widget.LinearLayout;
import com.google.android.material.checkbox.MaterialCheckBox;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cek implements eqj {
    public final /* synthetic */ int a;
    public final LinearLayout b;
    public final MaterialCheckBox c;
    public final MaterialCheckBox d;

    public /* synthetic */ cek(LinearLayout linearLayout, MaterialCheckBox materialCheckBox, MaterialCheckBox materialCheckBox2, int i) {
        this.a = i;
        this.b = linearLayout;
        this.c = materialCheckBox;
        this.d = materialCheckBox2;
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
