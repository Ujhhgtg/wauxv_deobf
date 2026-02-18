package me.hd.wauxv.obf;

import android.database.DataSetObserver;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bwk extends DataSetObserver {
    public final /* synthetic */ bwn a;

    public bwk(bwn bwnVar) {
        this.a = bwnVar;
    }

    @Override // android.database.DataSetObserver
    public final void onChanged() {
        bwn bwnVar = this.a;
        if (bwnVar.av.isShowing()) {
            bwnVar.ag();
        }
    }

    @Override // android.database.DataSetObserver
    public final void onInvalidated() {
        this.a.dismiss();
    }
}
