package me.hd.wauxv.obf;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bde extends cnb {
    public final /* synthetic */ bdj a;

    public bde(bdj bdjVar) {
        this.a = bdjVar;
    }

    @Override // me.hd.wauxv.obf.cnb
    public final View c(int i) {
        bdj bdjVar = this.a;
        View view = bdjVar.bz;
        if (view != null) {
            return view.findViewById(i);
        }
        throw new IllegalStateException("Fragment " + bdjVar + " does not have a view");
    }

    @Override // me.hd.wauxv.obf.cnb
    public final boolean d() {
        return this.a.bz != null;
    }
}
