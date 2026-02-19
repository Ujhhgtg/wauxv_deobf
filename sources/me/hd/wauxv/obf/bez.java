package me.hd.wauxv.obf;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bez extends cyy {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ bez(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // me.hd.wauxv.obf.cyy
    public final void c() {
        switch (this.a) {
            case 0:
                ((bfa) this.b).h(true);
                break;
            case 1:
                RecyclerView recyclerView = (RecyclerView) this.b;
                recyclerView.cw(null);
                recyclerView.bo.f = true;
                recyclerView.eh(true);
                if (!recyclerView.o.s()) {
                    recyclerView.requestLayout();
                }
                break;
            default:
                ((dpq) this.b).f();
                break;
        }
    }

    @Override // me.hd.wauxv.obf.cyy
    public final void d(int i, int i2) {
        int i3 = this.a;
        Object obj = this.b;
        switch (i3) {
            case 0:
                c();
                break;
            case 1:
                RecyclerView recyclerView = (RecyclerView) obj;
                recyclerView.cw(null);
                ea eaVar = recyclerView.o;
                ArrayList arrayList = (ArrayList) eaVar.c;
                if (i != i2) {
                    arrayList.add(eaVar.u(8, i, i2));
                    eaVar.a |= 8;
                    if (arrayList.size() == 1) {
                        RecyclerView recyclerView2 = (RecyclerView) obj;
                        if (recyclerView2.ad && recyclerView2.ac) {
                            cyu cyuVar = recyclerView2.s;
                            WeakHashMap weakHashMap = ViewCompat.a;
                            recyclerView2.postOnAnimation(cyuVar);
                        } else {
                            recyclerView2.ak = true;
                            recyclerView2.requestLayout();
                        }
                    }
                    break;
                }
                break;
            default:
                ((dpq) obj).f();
                break;
        }
    }
}
