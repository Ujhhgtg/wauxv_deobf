package me.hd.wauxv.obf;

import android.text.Editable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class avx extends drk {
    public final /* synthetic */ awa a;

    public avx(awa awaVar) {
        this.a = awaVar;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        this.a.x().j();
    }

    @Override // me.hd.wauxv.obf.drk, android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.a.x().aj();
    }
}
