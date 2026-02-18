package me.hd.wauxv.obf;

import android.os.Trace;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bgv implements Runnable {
    public static final ThreadLocal a = new ThreadLocal();
    public static final ex b = new ex(6);
    public long d;
    public long e;
    public final ArrayList c = new ArrayList();
    public final ArrayList f = new ArrayList();

    public static czx g(RecyclerView recyclerView, int i, long j) {
        int iAb = recyclerView.p.ab();
        for (int i2 = 0; i2 < iAb; i2++) {
            czx czxVarCs = RecyclerView.cs(recyclerView.p.aa(i2));
            if (czxVarCs.f == i && !czxVarCs.ad()) {
                return null;
            }
        }
        czo czoVar = recyclerView.m;
        if (j == Long.MAX_VALUE) {
            try {
                if (ekx.c()) {
                    Trace.beginSection("RV Prefetch forced - needed next frame");
                }
            } finally {
                recyclerView.ed(false);
                Trace.endSection();
            }
        }
        recyclerView.ec();
        czx czxVarS = czoVar.s(i, j);
        if (czxVarS != null) {
            if (!czxVarS.ac() || czxVarS.ad()) {
                czoVar.i(czxVarS, false);
            } else {
                czoVar.p(czxVarS.d);
            }
        }
        return czxVarS;
    }

    public final void h(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.ac) {
            if (RecyclerView.a && !this.c.contains(recyclerView)) {
                throw new IllegalStateException("attempting to post unregistered view!");
            }
            if (this.d == 0) {
                this.d = recyclerView.getNanoTime();
                recyclerView.post(this);
            }
        }
        bpq bpqVar = recyclerView.bn;
        bpqVar.b = i;
        bpqVar.c = i2;
    }

    /* JADX WARN: Found duplicated region for block: B:46:0x00d0  */
    public final void i(long j) {
        bgu bguVar;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        bgu bguVar2;
        ArrayList arrayList = this.c;
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            RecyclerView recyclerView3 = (RecyclerView) arrayList.get(i3);
            int windowVisibility = recyclerView3.getWindowVisibility();
            bpq bpqVar = recyclerView3.bn;
            if (windowVisibility == 0) {
                bpqVar.g(recyclerView3, false);
                i2 += bpqVar.d;
            }
        }
        ArrayList arrayList2 = this.f;
        arrayList2.ensureCapacity(i2);
        int i4 = 0;
        int i5 = 0;
        while (i4 < size) {
            RecyclerView recyclerView4 = (RecyclerView) arrayList.get(i4);
            if (recyclerView4.getWindowVisibility() == 0) {
                bpq bpqVar2 = recyclerView4.bn;
                int iAbs = Math.abs(bpqVar2.c) + Math.abs(bpqVar2.b);
                for (int i6 = i; i6 < bpqVar2.d * 2; i6 += 2) {
                    if (i5 >= arrayList2.size()) {
                        bguVar2 = new bgu();
                        arrayList2.add(bguVar2);
                    } else {
                        bguVar2 = (bgu) arrayList2.get(i5);
                    }
                    int[] iArr = (int[]) bpqVar2.e;
                    int i7 = iArr[i6 + 1];
                    bguVar2.a = i7 <= iAbs;
                    bguVar2.b = iAbs;
                    bguVar2.c = i7;
                    bguVar2.d = recyclerView4;
                    bguVar2.e = iArr[i6];
                    i5++;
                }
            }
            i4++;
            i = 0;
        }
        Collections.sort(arrayList2, b);
        for (int i8 = 0; i8 < arrayList2.size() && (recyclerView = (bguVar = (bgu) arrayList2.get(i8)).d) != null; i8++) {
            czx czxVarG = g(recyclerView, bguVar.e, bguVar.a ? Long.MAX_VALUE : j);
            if (czxVarG != null && czxVarG.e != null && czxVarG.ac() && !czxVarG.ad() && (recyclerView2 = (RecyclerView) czxVarG.e.get()) != null) {
                if (recyclerView2.an && recyclerView2.p.ab() != 0) {
                    czo czoVar = recyclerView2.m;
                    czc czcVar = recyclerView2.aw;
                    if (czcVar != null) {
                        czcVar.q();
                    }
                    czg czgVar = recyclerView2.x;
                    if (czgVar != null) {
                        czgVar.fb(czoVar);
                        recyclerView2.x.fc(czoVar);
                    }
                    czoVar.a.clear();
                    czoVar.n();
                }
                bpq bpqVar3 = recyclerView2.bn;
                bpqVar3.g(recyclerView2, true);
                if (bpqVar3.d != 0) {
                    try {
                        Trace.beginSection(j == Long.MAX_VALUE ? "RV Nested Prefetch" : "RV Nested Prefetch forced - needed next frame");
                        czt cztVar = recyclerView2.bo;
                        cyw cywVar = recyclerView2.w;
                        cztVar.d = 1;
                        cztVar.e = cywVar.d();
                        cztVar.g = false;
                        cztVar.h = false;
                        cztVar.i = false;
                        for (int i9 = 0; i9 < bpqVar3.d * 2; i9 += 2) {
                            g(recyclerView2, ((int[]) bpqVar3.e)[i9], j);
                        }
                        Trace.endSection();
                    } catch (Throwable th) {
                        Trace.endSection();
                        throw th;
                    }
                }
            }
            bguVar.a = false;
            bguVar.b = 0;
            bguVar.c = 0;
            bguVar.d = null;
            bguVar.e = 0;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList arrayList = this.c;
        try {
            Trace.beginSection("RV Prefetch");
            if (!arrayList.isEmpty()) {
                int size = arrayList.size();
                long jMax = 0;
                for (int i = 0; i < size; i++) {
                    RecyclerView recyclerView = (RecyclerView) arrayList.get(i);
                    if (recyclerView.getWindowVisibility() == 0) {
                        jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                    }
                }
                if (jMax != 0) {
                    i(TimeUnit.MILLISECONDS.toNanos(jMax) + this.e);
                }
            }
        } finally {
            this.d = 0L;
            Trace.endSection();
        }
    }
}
