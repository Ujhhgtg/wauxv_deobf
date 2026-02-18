package me.hd.wauxv.obf;

import android.widget.AbsListView;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bwl implements AbsListView.OnScrollListener {
    public final /* synthetic */ bwn a;

    public bwl(bwn bwnVar) {
        this.a = bwnVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
        bwn bwnVar = this.a;
        bwj bwjVar = bwnVar.an;
        in inVar = bwnVar.av;
        if (i != 1 || inVar.getInputMethodMode() == 2 || inVar.getContentView() == null) {
            return;
        }
        bwnVar.ar.removeCallbacks(bwjVar);
        bwjVar.run();
    }
}
