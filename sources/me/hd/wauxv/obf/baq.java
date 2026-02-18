package me.hd.wauxv.obf;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class baq implements ViewTreeObserver.OnDrawListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ bar b;

    public baq(bar barVar, View view) {
        this.b = barVar;
        this.a = view;
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        eot.i().post(new cs(this, 5, this));
    }
}
