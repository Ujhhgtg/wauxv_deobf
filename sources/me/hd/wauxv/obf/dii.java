package me.hd.wauxv.obf;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dii extends czl {
    public boolean a = false;
    public final /* synthetic */ csj c;

    public dii(csj csjVar) {
        this.c = csjVar;
    }

    @Override // me.hd.wauxv.obf.czl
    public final void b(RecyclerView recyclerView, int i, int i2) {
        if (i == 0 && i2 == 0) {
            return;
        }
        this.a = true;
    }

    @Override // me.hd.wauxv.obf.czl
    public final void e(RecyclerView recyclerView, int i) {
        if (i == 0 && this.a) {
            this.a = false;
            this.c.l();
        }
    }
}
