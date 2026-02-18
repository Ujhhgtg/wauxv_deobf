package me.hd.wauxv.obf;

import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ekp extends ViewGroup.MarginLayoutParams {
    public int a;
    public int b;

    public ekp(ekp ekpVar) {
        super((ViewGroup.MarginLayoutParams) ekpVar);
        this.a = 0;
        this.a = ekpVar.a;
    }

    public ekp(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.a = 0;
    }
}
