package me.hd.wauxv.obf;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bve extends czd {
    public int a;

    @Override // me.hd.wauxv.obf.czd
    public final void _bj(Rect rect, View view, RecyclerView recyclerView, czt cztVar) {
        super._bj(rect, view, recyclerView, cztVar);
        cyw adapter = recyclerView.getAdapter();
        int iD = adapter != null ? adapter.d() : 0;
        if (iD >= 0) {
            czx czxVarCs = RecyclerView.cs(view);
            rect.set(0, 0, (czxVarCs != null ? czxVarCs.x() : -1) == iD + (-1) ? 0 : this.a, 0);
        }
    }
}
