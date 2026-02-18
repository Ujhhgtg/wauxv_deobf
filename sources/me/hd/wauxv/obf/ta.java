package me.hd.wauxv.obf;

import android.graphics.Typeface;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ta extends bhv {
    public final Typeface _ax;
    public final aas b;
    public boolean c;

    public ta(aas aasVar, Typeface typeface) {
        this._ax = typeface;
        this.b = aasVar;
    }

    @Override // me.hd.wauxv.obf.bhv
    public final void d(int i) {
        if (this.c) {
            return;
        }
        this.b.c(this._ax);
    }

    @Override // me.hd.wauxv.obf.bhv
    public final void e(Typeface typeface, boolean z) {
        if (this.c) {
            return;
        }
        this.b.c(typeface);
    }
}
