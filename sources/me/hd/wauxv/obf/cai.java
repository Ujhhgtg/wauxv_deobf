package me.hd.wauxv.obf;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cai extends LinearLayoutManager {
    public final /* synthetic */ int a;
    public final /* synthetic */ cal b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cai(cal calVar, int i, int i2) {
        super(i);
        this.b = calVar;
        this.a = i2;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, me.hd.wauxv.obf.czg
    public final void cj(RecyclerView recyclerView, czt cztVar, int i) {
        tg tgVar = new tg(recyclerView.getContext());
        tgVar.f = i;
        fm(tgVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void ck(czt cztVar, int[] iArr) {
        int i = this.a;
        cal calVar = this.b;
        if (i == 0) {
            iArr[0] = calVar.n.getWidth();
            iArr[1] = calVar.n.getWidth();
        } else {
            iArr[0] = calVar.n.getHeight();
            iArr[1] = calVar.n.getHeight();
        }
    }
}
