package com.google.android.material.theme;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textview.MaterialTextView;
import me.hd.wauxv.obf.caa;
import me.hd.wauxv.obf.hc;
import me.hd.wauxv.obf.hd;
import me.hd.wauxv.obf.hf;
import me.hd.wauxv.obf.ip;
import me.hd.wauxv.obf.jp;
import me.hd.wauxv.obf.jw;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class MaterialComponentsViewInflater extends jw {
    @Override // me.hd.wauxv.obf.jw
    public final hc a(Context context, AttributeSet attributeSet) {
        return new caa(context, attributeSet);
    }

    @Override // me.hd.wauxv.obf.jw
    public final hd b(Context context, AttributeSet attributeSet) {
        return new MaterialButton(context, attributeSet);
    }

    @Override // me.hd.wauxv.obf.jw
    public final hf c(Context context, AttributeSet attributeSet) {
        return new MaterialCheckBox(context, attributeSet);
    }

    @Override // me.hd.wauxv.obf.jw
    public final ip d(Context context, AttributeSet attributeSet) {
        return new MaterialRadioButton(context, attributeSet);
    }

    @Override // me.hd.wauxv.obf.jw
    public final jp e(Context context, AttributeSet attributeSet) {
        return new MaterialTextView(context, attributeSet);
    }
}
