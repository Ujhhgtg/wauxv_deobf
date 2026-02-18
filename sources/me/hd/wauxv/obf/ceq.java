package me.hd.wauxv.obf;

import android.view.View;
import android.widget.LinearLayout;
import com.google.android.material.slider.Slider;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ceq implements eqj {
    public final /* synthetic */ int a;
    public final LinearLayout b;
    public final Slider c;

    public /* synthetic */ ceq(LinearLayout linearLayout, Slider slider, int i) {
        this.a = i;
        this.b = linearLayout;
        this.c = slider;
    }

    @Override // me.hd.wauxv.obf.eqj
    public final View getRoot() {
        switch (this.a) {
            case 0:
                break;
        }
        return this.b;
    }
}
