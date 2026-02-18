package me.hd.wauxv.obf;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dpm implements View.OnLayoutChangeListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ dpn b;

    public dpm(dpn dpnVar, View view) {
        this.b = dpnVar;
        this.a = view;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        View view2 = this.a;
        if (view2.getVisibility() == 0) {
            this.b.o(view2);
        }
    }
}
