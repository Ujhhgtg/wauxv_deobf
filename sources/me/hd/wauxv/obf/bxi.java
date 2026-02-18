package me.hd.wauxv.obf;

import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bxi implements TextWatcher {
    public final /* synthetic */ int a;

    private final void b(int i, int i2, int i3, CharSequence charSequence) {
    }

    private final void c(int i, int i2, int i3, CharSequence charSequence) {
    }

    private final void d(int i, int i2, int i3, CharSequence charSequence) {
    }

    private final void e(int i, int i2, int i3, CharSequence charSequence) {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        switch (this.a) {
            case 0:
                Float fBd = dnp.bd(String.valueOf(editable));
                if (fBd != null) {
                    bxf.a.q(fBd.floatValue());
                }
                break;
            default:
                Float fBd2 = dnp.bd(String.valueOf(editable));
                if (fBd2 != null) {
                    bxg.a.q(fBd2.floatValue());
                }
                break;
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        int i4 = this.a;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        int i4 = this.a;
    }
}
