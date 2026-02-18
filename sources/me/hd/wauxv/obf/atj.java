package me.hd.wauxv.obf;

import android.text.Editable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class atj extends Editable.Factory {
    public static final Object a = new Object();
    public static volatile atj b;
    public static Class c;

    @Override // android.text.Editable.Factory
    public final Editable newEditable(CharSequence charSequence) {
        Class cls = c;
        return cls != null ? new dlm(cls, charSequence) : super.newEditable(charSequence);
    }
}
