package me.hd.wauxv.obf;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bdr implements eqj {
    public final LinearLayout a;
    public final RecyclerView b;

    public bdr(LinearLayout linearLayout, RecyclerView recyclerView) {
        this.a = linearLayout;
        this.b = recyclerView;
    }

    @Override // me.hd.wauxv.obf.eqj
    public final View getRoot() {
        return this.a;
    }
}
