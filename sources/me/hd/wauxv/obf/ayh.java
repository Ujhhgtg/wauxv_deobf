package me.hd.wauxv.obf;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ayh extends czl {
    public final /* synthetic */ ayj a;

    public ayh(ayj ayjVar) {
        this.a = ayjVar;
    }

    @Override // me.hd.wauxv.obf.czl
    public final void b(RecyclerView recyclerView, int i, int i2) {
        int iComputeHorizontalScrollOffset = recyclerView.computeHorizontalScrollOffset();
        int iComputeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
        ayj ayjVar = this.a;
        int i3 = ayjVar.d;
        int iComputeVerticalScrollRange = ayjVar.v.computeVerticalScrollRange();
        int i4 = ayjVar.u;
        ayjVar.w = iComputeVerticalScrollRange - i4 > 0 && i4 >= i3;
        int iComputeHorizontalScrollRange = ayjVar.v.computeHorizontalScrollRange();
        int i5 = ayjVar.t;
        boolean z = iComputeHorizontalScrollRange - i5 > 0 && i5 >= i3;
        ayjVar.x = z;
        boolean z2 = ayjVar.w;
        if (!z2 && !z) {
            if (ayjVar.y != 0) {
                ayjVar.al(0);
                return;
            }
            return;
        }
        if (z2) {
            float f = i4;
            ayjVar.o = (int) ((((f / 2.0f) + iComputeVerticalScrollOffset) * f) / iComputeVerticalScrollRange);
            ayjVar.n = Math.min(i4, (i4 * i4) / iComputeVerticalScrollRange);
        }
        if (ayjVar.x) {
            float f2 = iComputeHorizontalScrollOffset;
            float f3 = i5;
            ayjVar.r = (int) ((((f3 / 2.0f) + f2) * f3) / iComputeHorizontalScrollRange);
            ayjVar.q = Math.min(i5, (i5 * i5) / iComputeHorizontalScrollRange);
        }
        int i6 = ayjVar.y;
        if (i6 == 0 || i6 == 1) {
            ayjVar.al(1);
        }
    }
}
