package me.hd.wauxv.obf;

import androidx.appcompat.widget.ActionBarContextView;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements esi {
    public boolean a = false;
    public int b;
    public final /* synthetic */ ActionBarContextView c;

    public k(ActionBarContextView actionBarContextView) {
        this.c = actionBarContextView;
    }

    @Override // me.hd.wauxv.obf.esi
    public final void d() {
        this.a = true;
    }

    @Override // me.hd.wauxv.obf.esi
    public final void e() {
        super/*android.view.View*/.setVisibility(0);
        this.a = false;
    }

    @Override // me.hd.wauxv.obf.esi
    public final void f() {
        if (this.a) {
            return;
        }
        ActionBarContextView actionBarContextView = this.c;
        actionBarContextView.f = null;
        super/*android.view.View*/.setVisibility(this.b);
    }
}
