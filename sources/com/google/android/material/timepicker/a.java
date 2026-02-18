package com.google.android.material.timepicker;

import android.text.Editable;
import android.text.TextUtils;
import com.google.android.material.chip.Chip;
import me.hd.wauxv.obf.drk;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends drk {
    public final /* synthetic */ ChipTextInputComboView a;

    public a(ChipTextInputComboView chipTextInputComboView) {
        this.a = chipTextInputComboView;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        boolean zIsEmpty = TextUtils.isEmpty(editable);
        ChipTextInputComboView chipTextInputComboView = this.a;
        if (zIsEmpty) {
            chipTextInputComboView.a.setText(ChipTextInputComboView.c(chipTextInputComboView, "00"));
            return;
        }
        String strC = ChipTextInputComboView.c(chipTextInputComboView, editable);
        Chip chip = chipTextInputComboView.a;
        if (TextUtils.isEmpty(strC)) {
            strC = ChipTextInputComboView.c(chipTextInputComboView, "00");
        }
        chip.setText(strC);
    }
}
