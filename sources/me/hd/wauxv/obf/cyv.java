package me.hd.wauxv.obf;

import android.util.Log;
import android.view.View;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cyv implements ano {
    public final /* synthetic */ androidx.recyclerview.widget.RecyclerView a;

    public /* synthetic */ cyv(androidx.recyclerview.widget.RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    public void b(dz dzVar) {
        int i = dzVar.a;
        androidx.recyclerview.widget.RecyclerView recyclerView = this.a;
        if (i == 1) {
            recyclerView.x.z(dzVar.b, dzVar.c);
            return;
        }
        if (i == 2) {
            recyclerView.x.ac(dzVar.b, dzVar.c);
        } else if (i == 4) {
            recyclerView.x.ad(dzVar.b, dzVar.c);
        } else {
            if (i != 8) {
                return;
            }
            recyclerView.x.ab(dzVar.b, dzVar.c);
        }
    }

    public SomeView c(int i) {
        androidx.recyclerview.widget.RecyclerView recyclerView = this.a;
        int iAb = recyclerView.p.ab();
        SomeView someViewVar = null;
        for (int i2 = 0; i2 < iAb; i2++) {
            SomeView someViewVarCs = androidx.recyclerview.widget.RecyclerView.cs(recyclerView.p.aa(i2));
            if (someViewVarCs != null && !someViewVarCs.af() && someViewVarCs.f == i) {
                if (!((ArrayList) recyclerView.p.e).contains(someViewVarCs.d)) {
                    someViewVar = someViewVarCs;
                    break;
                }
                someViewVar = someViewVarCs;
            }
        }
        if (someViewVar != null) {
            if (!((ArrayList) recyclerView.p.e).contains(someViewVar.d)) {
                return someViewVar;
            }
            if (androidx.recyclerview.widget.RecyclerView.b) {
                Log.d("RecyclerView", "assuming view holder cannot be find because it is hidden");
            }
        }
        return null;
    }

    public void d(int i, int i2) {
        int i3;
        int i4;
        androidx.recyclerview.widget.RecyclerView recyclerView = this.a;
        int iAb = recyclerView.p.ab();
        int i5 = i2 + i;
        for (int i6 = 0; i6 < iAb; i6++) {
            View viewAa = recyclerView.p.aa(i6);
            SomeView someViewVarCs = androidx.recyclerview.widget.RecyclerView.cs(viewAa);
            if (someViewVarCs != null && !someViewVarCs.am() && (i4 = someViewVarCs.f) >= i && i4 < i5) {
                someViewVarCs.w(2);
                someViewVarCs.w(1024);
                ((czh) viewAa.getLayoutParams()).e = true;
            }
        }
        RecyclerView recyclerViewVar = recyclerView.m;
        ArrayList arrayList = recyclerViewVar.c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            SomeView someViewVar = (SomeView) arrayList.get(size);
            if (someViewVar != null && (i3 = someViewVar.f) >= i && i3 < i5) {
                someViewVar.w(2);
                recyclerViewVar.o(size);
            }
        }
        recyclerView.bs = true;
    }

    @Override // me.hd.wauxv.obf.ano
    public boolean e(float f) {
        int i;
        int i2;
        androidx.recyclerview.widget.RecyclerView recyclerView = this.a;
        if (recyclerView.x.bv()) {
            i2 = (int) f;
            i = 0;
        } else if (recyclerView.x.bu()) {
            i = (int) f;
            i2 = 0;
        } else {
            i = 0;
            i2 = 0;
        }
        if (i == 0 && i2 == 0) {
            return false;
        }
        recyclerView.ey();
        return recyclerView.ds(i, i2, 0, Integer.MAX_VALUE);
    }

    @Override // me.hd.wauxv.obf.ano
    public float f() {
        float f;
        androidx.recyclerview.widget.RecyclerView recyclerView = this.a;
        if (recyclerView.x.bv()) {
            f = recyclerView.bj;
        } else {
            if (!recyclerView.x.bu()) {
                return 0.0f;
            }
            f = recyclerView.bi;
        }
        return -f;
    }

    @Override // me.hd.wauxv.obf.ano
    public void g() {
        this.a.ey();
    }

    public void h(int i, int i2) {
        androidx.recyclerview.widget.RecyclerView recyclerView = this.a;
        int iAb = recyclerView.p.ab();
        for (int i3 = 0; i3 < iAb; i3++) {
            SomeView someViewVarCs = androidx.recyclerview.widget.RecyclerView.cs(recyclerView.p.aa(i3));
            if (someViewVarCs != null && !someViewVarCs.am() && someViewVarCs.f >= i) {
                if (androidx.recyclerview.widget.RecyclerView.b) {
                    Log.d("RecyclerView", "offsetPositionRecordsForInsert attached child " + i3 + " holder " + someViewVarCs + " now at position " + (someViewVarCs.f + i2));
                }
                someViewVarCs.aj(i2, false);
                recyclerView.bo.f = true;
            }
        }
        ArrayList arrayList = recyclerView.m.c;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            SomeView someViewVar = (SomeView) arrayList.get(i4);
            if (someViewVar != null && someViewVar.f >= i) {
                if (androidx.recyclerview.widget.RecyclerView.b) {
                    Log.d("RecyclerView", "offsetPositionRecordsForInsert cached " + i4 + " holder " + someViewVar + " now at position " + (someViewVar.f + i2));
                }
                someViewVar.aj(i2, false);
            }
        }
        recyclerView.requestLayout();
        recyclerView.br = true;
    }

    public void i(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        androidx.recyclerview.widget.RecyclerView recyclerView = this.a;
        int iAb = recyclerView.p.ab();
        if (i < i2) {
            i4 = i;
            i3 = i2;
            i5 = -1;
        } else {
            i3 = i;
            i4 = i2;
            i5 = 1;
        }
        boolean z = false;
        for (int i11 = 0; i11 < iAb; i11++) {
            SomeView someViewVarCs = androidx.recyclerview.widget.RecyclerView.cs(recyclerView.p.aa(i11));
            if (someViewVarCs != null && (i10 = someViewVarCs.f) >= i4 && i10 <= i3) {
                if (androidx.recyclerview.widget.RecyclerView.b) {
                    Log.d("RecyclerView", "offsetPositionRecordsForMove attached child " + i11 + " holder " + someViewVarCs);
                }
                if (someViewVarCs.f == i) {
                    someViewVarCs.aj(i2 - i, false);
                } else {
                    someViewVarCs.aj(i5, false);
                }
                recyclerView.bo.f = true;
            }
        }
        ArrayList arrayList = recyclerView.m.c;
        if (i < i2) {
            i7 = i;
            i6 = i2;
            i8 = -1;
        } else {
            i6 = i;
            i7 = i2;
            i8 = 1;
        }
        int size = arrayList.size();
        int i12 = 0;
        while (i12 < size) {
            SomeView someViewVar = (SomeView) arrayList.get(i12);
            if (someViewVar != null && (i9 = someViewVar.f) >= i7 && i9 <= i6) {
                if (i9 == i) {
                    someViewVar.aj(i2 - i, z);
                } else {
                    someViewVar.aj(i8, z);
                }
                if (androidx.recyclerview.widget.RecyclerView.b) {
                    Log.d("RecyclerView", "offsetPositionRecordsForMove cached child " + i12 + " holder " + someViewVar);
                }
            }
            i12++;
            z = false;
        }
        recyclerView.requestLayout();
        recyclerView.br = true;
    }

    /* JADX WARN: Found duplicated region for block: B:9:0x0020 A[MOVE_INLINED] */
    public void j(SomeView someViewVar, cjn cjnVar, cjn cjnVar2) {
        boolean zS;
        androidx.recyclerview.widget.RecyclerView recyclerView = this.a;
        recyclerView.getClass();
        someViewVar.al(false);
        akx akxVar = (akx) recyclerView.aw;
        if (cjnVar != null) {
            akxVar.getClass();
            int i = cjnVar.a;
            int i2 = cjnVar2.a;
            if (i == i2 && cjnVar.b == cjnVar2.b) {
                akxVar.w(someViewVar);
                someViewVar.d.setAlpha(0.0f);
                akxVar.d.add(someViewVar);
                zS = true;
            } else {
                zS = akxVar.s(someViewVar, i, cjnVar.b, i2, cjnVar2.b);
            }
        } else {
            akxVar.w(someViewVar);
            someViewVar.d.setAlpha(0.0f);
            akxVar.d.add(someViewVar);
            zS = true;
        }
        if (zS) {
            recyclerView.ef();
        }
    }

    public void k(SomeView someViewVar, cjn cjnVar, cjn cjnVar2) {
        boolean zS;
        androidx.recyclerview.widget.RecyclerView recyclerView = this.a;
        recyclerView.m.t(someViewVar);
        recyclerView.ct(someViewVar);
        someViewVar.al(false);
        akx akxVar = (akx) recyclerView.aw;
        akxVar.getClass();
        int i = cjnVar.a;
        int i2 = cjnVar.b;
        View view = someViewVar.d;
        int left = cjnVar2 == null ? view.getLeft() : cjnVar2.a;
        int top = cjnVar2 == null ? view.getTop() : cjnVar2.b;
        if (someViewVar.af() || (i == left && i2 == top)) {
            akxVar.w(someViewVar);
            akxVar.c.add(someViewVar);
            zS = true;
        } else {
            view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
            zS = akxVar.s(someViewVar, i, i2, left, top);
        }
        if (zS) {
            recyclerView.ef();
        }
    }

    public void l(int i) {
        androidx.recyclerview.widget.RecyclerView recyclerView = this.a;
        View childAt = recyclerView.getChildAt(i);
        if (childAt != null) {
            recyclerView.db(childAt);
            childAt.clearAnimation();
        }
        recyclerView.removeViewAt(i);
    }
}
