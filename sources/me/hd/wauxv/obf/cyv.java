package me.hd.wauxv.obf;

import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cyv implements ano {
    public final /* synthetic */ RecyclerView a;

    public /* synthetic */ cyv(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    public void b(dz dzVar) {
        int i = dzVar.a;
        RecyclerView recyclerView = this.a;
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

    public czx c(int i) {
        RecyclerView recyclerView = this.a;
        int iAb = recyclerView.p.ab();
        czx czxVar = null;
        for (int i2 = 0; i2 < iAb; i2++) {
            czx czxVarCs = RecyclerView.cs(recyclerView.p.aa(i2));
            if (czxVarCs != null && !czxVarCs.af() && czxVarCs.f == i) {
                if (!((ArrayList) recyclerView.p.e).contains(czxVarCs.d)) {
                    czxVar = czxVarCs;
                    break;
                }
                czxVar = czxVarCs;
            }
        }
        if (czxVar != null) {
            if (!((ArrayList) recyclerView.p.e).contains(czxVar.d)) {
                return czxVar;
            }
            if (RecyclerView.b) {
                Log.d("RecyclerView", "assuming view holder cannot be find because it is hidden");
            }
        }
        return null;
    }

    public void d(int i, int i2) {
        int i3;
        int i4;
        RecyclerView recyclerView = this.a;
        int iAb = recyclerView.p.ab();
        int i5 = i2 + i;
        for (int i6 = 0; i6 < iAb; i6++) {
            View viewAa = recyclerView.p.aa(i6);
            czx czxVarCs = RecyclerView.cs(viewAa);
            if (czxVarCs != null && !czxVarCs.am() && (i4 = czxVarCs.f) >= i && i4 < i5) {
                czxVarCs.w(2);
                czxVarCs.w(1024);
                ((czh) viewAa.getLayoutParams()).e = true;
            }
        }
        czo czoVar = recyclerView.m;
        ArrayList arrayList = czoVar.c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            czx czxVar = (czx) arrayList.get(size);
            if (czxVar != null && (i3 = czxVar.f) >= i && i3 < i5) {
                czxVar.w(2);
                czoVar.o(size);
            }
        }
        recyclerView.bs = true;
    }

    @Override // me.hd.wauxv.obf.ano
    public boolean e(float f) {
        int i;
        int i2;
        RecyclerView recyclerView = this.a;
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
        RecyclerView recyclerView = this.a;
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
        RecyclerView recyclerView = this.a;
        int iAb = recyclerView.p.ab();
        for (int i3 = 0; i3 < iAb; i3++) {
            czx czxVarCs = RecyclerView.cs(recyclerView.p.aa(i3));
            if (czxVarCs != null && !czxVarCs.am() && czxVarCs.f >= i) {
                if (RecyclerView.b) {
                    Log.d("RecyclerView", "offsetPositionRecordsForInsert attached child " + i3 + " holder " + czxVarCs + " now at position " + (czxVarCs.f + i2));
                }
                czxVarCs.aj(i2, false);
                recyclerView.bo.f = true;
            }
        }
        ArrayList arrayList = recyclerView.m.c;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            czx czxVar = (czx) arrayList.get(i4);
            if (czxVar != null && czxVar.f >= i) {
                if (RecyclerView.b) {
                    Log.d("RecyclerView", "offsetPositionRecordsForInsert cached " + i4 + " holder " + czxVar + " now at position " + (czxVar.f + i2));
                }
                czxVar.aj(i2, false);
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
        RecyclerView recyclerView = this.a;
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
            czx czxVarCs = RecyclerView.cs(recyclerView.p.aa(i11));
            if (czxVarCs != null && (i10 = czxVarCs.f) >= i4 && i10 <= i3) {
                if (RecyclerView.b) {
                    Log.d("RecyclerView", "offsetPositionRecordsForMove attached child " + i11 + " holder " + czxVarCs);
                }
                if (czxVarCs.f == i) {
                    czxVarCs.aj(i2 - i, false);
                } else {
                    czxVarCs.aj(i5, false);
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
            czx czxVar = (czx) arrayList.get(i12);
            if (czxVar != null && (i9 = czxVar.f) >= i7 && i9 <= i6) {
                if (i9 == i) {
                    czxVar.aj(i2 - i, z);
                } else {
                    czxVar.aj(i8, z);
                }
                if (RecyclerView.b) {
                    Log.d("RecyclerView", "offsetPositionRecordsForMove cached child " + i12 + " holder " + czxVar);
                }
            }
            i12++;
            z = false;
        }
        recyclerView.requestLayout();
        recyclerView.br = true;
    }

    /* JADX WARN: Found duplicated region for block: B:9:0x0020 A[MOVE_INLINED] */
    public void j(czx czxVar, cjn cjnVar, cjn cjnVar2) {
        boolean zS;
        RecyclerView recyclerView = this.a;
        recyclerView.getClass();
        czxVar.al(false);
        akx akxVar = (akx) recyclerView.aw;
        if (cjnVar != null) {
            akxVar.getClass();
            int i = cjnVar.a;
            int i2 = cjnVar2.a;
            if (i == i2 && cjnVar.b == cjnVar2.b) {
                akxVar.w(czxVar);
                czxVar.d.setAlpha(0.0f);
                akxVar.d.add(czxVar);
                zS = true;
            } else {
                zS = akxVar.s(czxVar, i, cjnVar.b, i2, cjnVar2.b);
            }
        } else {
            akxVar.w(czxVar);
            czxVar.d.setAlpha(0.0f);
            akxVar.d.add(czxVar);
            zS = true;
        }
        if (zS) {
            recyclerView.ef();
        }
    }

    public void k(czx czxVar, cjn cjnVar, cjn cjnVar2) {
        boolean zS;
        RecyclerView recyclerView = this.a;
        recyclerView.m.t(czxVar);
        recyclerView.ct(czxVar);
        czxVar.al(false);
        akx akxVar = (akx) recyclerView.aw;
        akxVar.getClass();
        int i = cjnVar.a;
        int i2 = cjnVar.b;
        View view = czxVar.d;
        int left = cjnVar2 == null ? view.getLeft() : cjnVar2.a;
        int top = cjnVar2 == null ? view.getTop() : cjnVar2.b;
        if (czxVar.af() || (i == left && i2 == top)) {
            akxVar.w(czxVar);
            akxVar.c.add(czxVar);
            zS = true;
        } else {
            view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
            zS = akxVar.s(czxVar, i, i2, left, top);
        }
        if (zS) {
            recyclerView.ef();
        }
    }

    public void l(int i) {
        RecyclerView recyclerView = this.a;
        View childAt = recyclerView.getChildAt(i);
        if (childAt != null) {
            recyclerView.db(childAt);
            childAt.clearAnimation();
        }
        recyclerView.removeViewAt(i);
    }
}
