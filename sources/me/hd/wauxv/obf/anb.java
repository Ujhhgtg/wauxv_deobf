package me.hd.wauxv.obf;

import android.app.Dialog;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class anb extends cnb {
    public final /* synthetic */ bde a;
    public final /* synthetic */ anc b;

    public anb(anc ancVar, bde bdeVar) {
        this.b = ancVar;
        this.a = bdeVar;
    }

    @Override // me.hd.wauxv.obf.cnb
    public final View c(int i) {
        bde bdeVar = this.a;
        if (bdeVar.d()) {
            return bdeVar.c(i);
        }
        Dialog dialog = this.b.s;
        if (dialog != null) {
            return dialog.findViewById(i);
        }
        return null;
    }

    @Override // me.hd.wauxv.obf.cnb
    public final boolean d() {
        return this.a.d() || this.b.w;
    }
}
