package me.hd.wauxv.obf;

import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aur extends emc {
    public final auq a;

    public aur(TextView textView) {
        super(7);
        this.a = new auq(textView);
    }

    @Override // me.hd.wauxv.obf.emc
    public final InputFilter[] _x(InputFilter[] inputFilterArr) {
        return !(atf.b != null) ? inputFilterArr : this.a._x(inputFilterArr);
    }

    @Override // me.hd.wauxv.obf.emc
    public final boolean _y() {
        return this.a.c;
    }

    @Override // me.hd.wauxv.obf.emc
    public final void k(boolean z) {
        if (atf.b != null) {
            this.a.k(z);
        }
    }

    @Override // me.hd.wauxv.obf.emc
    public final void l(boolean z) {
        auq auqVar = this.a;
        if (atf.b != null) {
            auqVar.l(z);
        } else {
            auqVar.c = z;
        }
    }

    @Override // me.hd.wauxv.obf.emc
    public final TransformationMethod m(TransformationMethod transformationMethod) {
        return !(atf.b != null) ? transformationMethod : this.a.m(transformationMethod);
    }
}
