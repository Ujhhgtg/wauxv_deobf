package me.hd.wauxv.obf;

import android.os.Trace;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class RecyclerView {
    public final ArrayList a;
    public ArrayList b;
    public final ArrayList c;
    public final List d;
    public int e;
    public int f;
    public czn g;
    public final /* synthetic */ androidx.recyclerview.widget.RecyclerView h;

    public RecyclerView(androidx.recyclerview.widget.RecyclerView recyclerView) {
        this.h = recyclerView;
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        this.b = null;
        this.c = new ArrayList();
        this.d = Collections.unmodifiableList(arrayList);
        this.e = 2;
        this.f = 2;
    }

    public final void i(SomeView someViewVar, boolean z) {
        androidx.recyclerview.widget.RecyclerView.cp(someViewVar);
        View view = someViewVar.d;
        androidx.recyclerview.widget.RecyclerView recyclerView = this.h;
        czz czzVar = recyclerView.bv;
        if (czzVar != null) {
            czy czyVar = czzVar.b;
            ViewCompat.setAccessibilityDelegate(view, czyVar != null ? (AccessibilityDelegateCompat) czyVar.b.remove(view) : null);
        }
        if (z) {
            ArrayList arrayList = recyclerView.y;
            if (arrayList.size() > 0) {
                arrayList.get(0).getClass();
                throw new ClassCastException();
            }
            cyw cywVar = recyclerView.w;
            if (cywVar != null) {
                cywVar.w(someViewVar);
            }
            if (recyclerView.bo != null) {
                recyclerView.q.af(someViewVar);
            }
            if (androidx.recyclerview.widget.RecyclerView.b) {
                Log.d("RecyclerView", "dispatchViewRecycled: " + someViewVar);
            }
        }
        someViewVar.v = null;
        someViewVar.u = null;
        czn cznVarK = k();
        cznVarK.getClass();
        int i = someViewVar.i;
        ArrayList arrayList2 = cznVarK.d(i).a;
        if (((czm) cznVarK.a.get(i)).b <= arrayList2.size()) {
            KotlinHelpers.k(view);
        } else {
            if (androidx.recyclerview.widget.RecyclerView.a && arrayList2.contains(someViewVar)) {
                throw new IllegalArgumentException("this scrap item already exists");
            }
            someViewVar.ak();
            arrayList2.add(someViewVar);
        }
    }

    public final int j(int i) {
        androidx.recyclerview.widget.RecyclerView recyclerView = this.h;
        if (i >= 0 && i < recyclerView.bo.p()) {
            return !recyclerView.bo.g ? i : recyclerView.o.n(i, 0);
        }
        StringBuilder sbR = yg.concatVar213(i, "invalid position ", ". State item count is ");
        sbR.append(recyclerView.bo.p());
        sbR.append(recyclerView.dm());
        throw new IndexOutOfBoundsException(sbR.toString());
    }

    public final czn k() {
        if (this.g == null) {
            czn cznVar = new czn();
            cznVar.a = new SparseArray();
            cznVar.b = 0;
            cznVar.c = Collections.newSetFromMap(new IdentityHashMap());
            this.g = cznVar;
            l();
        }
        return this.g;
    }

    public final void l() {
        androidx.recyclerview.widget.RecyclerView recyclerView;
        cyw cywVar;
        czn cznVar = this.g;
        if (cznVar == null || (cywVar = (recyclerView = this.h).w) == null || !recyclerView.ac) {
            return;
        }
        cznVar.c.add(cywVar);
    }

    public final void m(cyw cywVar, boolean z) {
        czn cznVar = this.g;
        if (cznVar != null) {
            SparseArray sparseArray = cznVar.a;
            Set set = cznVar.c;
            set.remove(cywVar);
            if (set.size() != 0 || z) {
                return;
            }
            for (int i = 0; i < sparseArray.size(); i++) {
                ArrayList arrayList = ((czm) sparseArray.get(sparseArray.keyAt(i))).a;
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    KotlinHelpers.k(((SomeView) arrayList.get(i2)).d);
                }
            }
        }
    }

    public final void n() {
        ArrayList arrayList = this.c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            o(size);
        }
        arrayList.clear();
        if (androidx.recyclerview.widget.RecyclerView.g) {
            bpq bpqVar = this.h.bn;
            int[] iArr = (int[]) bpqVar.e;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            bpqVar.d = 0;
        }
    }

    public final void o(int i) {
        if (androidx.recyclerview.widget.RecyclerView.b) {
            Log.d("RecyclerView", "Recycling cached view at index " + i);
        }
        ArrayList arrayList = this.c;
        SomeView someViewVar = (SomeView) arrayList.get(i);
        if (androidx.recyclerview.widget.RecyclerView.b) {
            Log.d("RecyclerView", "CachedViewHolder to be recycled: " + someViewVar);
        }
        i(someViewVar, true);
        arrayList.remove(i);
    }

    public final void p(View view) {
        SomeView someViewVarCs = androidx.recyclerview.widget.RecyclerView.cs(view);
        boolean zAh = someViewVarCs.ah();
        androidx.recyclerview.widget.RecyclerView recyclerView = this.h;
        if (zAh) {
            recyclerView.removeDetachedView(view, false);
        }
        if (someViewVarCs.ag()) {
            someViewVarCs.q.t(someViewVarCs);
        } else if (someViewVarCs.an()) {
            someViewVarCs.m &= -33;
        }
        q(someViewVarCs);
        if (recyclerView.aw == null || someViewVarCs.ae()) {
            return;
        }
        recyclerView.aw.p(someViewVarCs);
    }

    /* JADX WARN: Found duplicated region for block: B:16:0x0032  */
    /* JADX WARN: Found duplicated region for block: B:61:0x00c9  */
    /* JADX WARN: Found duplicated region for block: B:63:0x00d7  */
    /* JADX WARN: Found duplicated region for block: B:65:0x00de  */
    /* JADX WARN: Found duplicated region for block: B:68:0x00e9 A[LOOP:2: B:64:0x00dc->B:68:0x00e9, LOOP_END] */
    /* JADX WARN: Found duplicated region for block: B:93:0x00ec A[EDGE_INSN: B:93:0x00ec->B:69:0x00ec BREAK  A[LOOP:1: B:60:0x00c7->B:67:0x00e6, LOOP_LABEL: LOOP:1: B:60:0x00c7->B:67:0x00e6], SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:95:0x00ec A[EDGE_INSN: B:95:0x00ec->B:69:0x00ec BREAK  A[LOOP:1: B:60:0x00c7->B:67:0x00e6], SYNTHETIC] */
    public final void q(SomeView someViewVar) {
        boolean z;
        boolean z2;
        int i;
        int i2;
        int i3;
        int i4;
        androidx.recyclerview.widget.RecyclerView recyclerView = this.h;
        bpq bpqVar = recyclerView.bn;
        boolean zAg = someViewVar.ag();
        View view = someViewVar.d;
        boolean z3 = true;
        if (zAg || view.getParent() != null) {
            StringBuilder sb = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:");
            sb.append(someViewVar.ag());
            sb.append(" isAttached:");
            sb.append(view.getParent() != null);
            sb.append(recyclerView.dm());
            throw new IllegalArgumentException(sb.toString());
        }
        if (someViewVar.ah()) {
            StringBuilder sb2 = new StringBuilder("Tmp detached view should be removed from RecyclerView before it can be recycled: ");
            sb2.append(someViewVar);
            throw new IllegalArgumentException(yg.i(recyclerView, sb2));
        }
        if (someViewVar.am()) {
            throw new IllegalArgumentException(yg.i(recyclerView, new StringBuilder("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.")));
        }
        if ((someViewVar.m & 16) == 0) {
            WeakHashMap weakHashMap = ViewCompat.a;
            z = view.hasTransientState();
        }
        cyw cywVar = recyclerView.w;
        boolean z4 = cywVar != null && z && cywVar.v(someViewVar);
        boolean z5 = androidx.recyclerview.widget.RecyclerView.a;
        ArrayList arrayList = this.c;
        if (z5 && arrayList.contains(someViewVar)) {
            StringBuilder sb3 = new StringBuilder("cached view received recycle internal? ");
            sb3.append(someViewVar);
            throw new IllegalArgumentException(yg.i(recyclerView, sb3));
        }
        if (z4 || someViewVar.ae()) {
            if (this.f <= 0 || (someViewVar.m & 526) != 0) {
                z2 = false;
            } else {
                int size = arrayList.size();
                if (size >= this.f && size > 0) {
                    o(0);
                    size--;
                }
                if (androidx.recyclerview.widget.RecyclerView.g && size > 0) {
                    int i5 = someViewVar.f;
                    if (((int[]) bpqVar.e) != null) {
                        int i6 = bpqVar.d * 2;
                        int i7 = 0;
                        while (true) {
                            if (i7 >= i6) {
                                i = size - 1;
                                loop1: while (i >= 0) {
                                    i2 = ((SomeView) arrayList.get(i)).f;
                                    if (((int[]) bpqVar.e) != null) {
                                        break;
                                    }
                                    i3 = bpqVar.d * 2;
                                    i4 = 0;
                                    while (true) {
                                        if (i4 < i3) {
                                            break loop1;
                                        } else if (((int[]) bpqVar.e)[i4] == i2) {
                                            break;
                                        } else {
                                            i4 += 2;
                                        }
                                    }
                                    i--;
                                }
                                size = i + 1;
                            } else if (((int[]) bpqVar.e)[i7] != i5) {
                                i7 += 2;
                            }
                        }
                    } else {
                        i = size - 1;
                        loop1: while (i >= 0) {
                            i2 = ((SomeView) arrayList.get(i)).f;
                            if (((int[]) bpqVar.e) != null) {
                                break;
                                break;
                            }
                            i3 = bpqVar.d * 2;
                            i4 = 0;
                            while (true) {
                                if (i4 < i3) {
                                    break loop1;
                                    break loop1;
                                } else if (((int[]) bpqVar.e)[i4] == i2) {
                                    break;
                                } else {
                                    i4 += 2;
                                }
                            }
                            i--;
                        }
                        size = i + 1;
                    }
                }
                arrayList.add(size, someViewVar);
                z2 = true;
            }
            if (z2) {
                z3 = false;
            } else {
                i(someViewVar, true);
            }
            z = z2;
        } else {
            if (androidx.recyclerview.widget.RecyclerView.b) {
                Log.d("RecyclerView", "trying to recycle a non-recycleable holder. Hopefully, it will re-visit here. We are still removing it from animation lists" + recyclerView.dm());
            }
            z3 = false;
        }
        recyclerView.q.af(someViewVar);
        if (z || z3 || !z) {
            return;
        }
        KotlinHelpers.k(view);
        someViewVar.v = null;
        someViewVar.u = null;
    }

    public final void r(View view) {
        czc czcVar;
        SomeView someViewVarCs = androidx.recyclerview.widget.RecyclerView.cs(view);
        int i = someViewVarCs.m & 12;
        androidx.recyclerview.widget.RecyclerView recyclerView = this.h;
        if (i == 0 && someViewVarCs.ai() && (czcVar = recyclerView.aw) != null) {
            akx akxVar = (akx) czcVar;
            if (someViewVarCs.aa().isEmpty() && akxVar.b && !someViewVarCs.ad()) {
                if (this.b == null) {
                    this.b = new ArrayList();
                }
                someViewVarCs.q = this;
                someViewVarCs.r = true;
                this.b.add(someViewVarCs);
                return;
            }
        }
        if (someViewVarCs.ad() && !someViewVarCs.af() && !recyclerView.w.ad) {
            throw new IllegalArgumentException(yg.i(recyclerView, new StringBuilder("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.")));
        }
        someViewVarCs.q = this;
        someViewVarCs.r = false;
        this.a.add(someViewVarCs);
    }

    /* JADX WARN: Found duplicated region for block: B:120:0x020b  */
    /* JADX WARN: Found duplicated region for block: B:191:0x0373 A[EDGE_INSN: B:191:0x0373->B:192:0x0374 BREAK  A[LOOP:4: B:186:0x035b->B:190:0x0370]] */
    /* JADX WARN: Found duplicated region for block: B:279:0x04e1  */
    /* JADX WARN: Found duplicated region for block: B:281:0x04e7  */
    /* JADX WARN: Found duplicated region for block: B:282:0x04f5  */
    /* JADX WARN: Found duplicated region for block: B:285:0x04ff  */
    /* JADX WARN: Found duplicated region for block: B:286:0x0502  */
    /* JADX WARN: Found duplicated region for block: B:288:0x0505  */
    /* JADX WARN: Found duplicated region for block: B:290:0x050b  */
    /* JADX WARN: Found duplicated region for block: B:293:0x051f  */
    /* JADX WARN: Found duplicated region for block: B:296:0x0538  */
    /* JADX WARN: Found duplicated region for block: B:312:0x059f  */
    /* JADX WARN: Found duplicated region for block: B:314:0x05a3  */
    /* JADX WARN: Found duplicated region for block: B:317:0x05b4  */
    /* JADX WARN: Found duplicated region for block: B:320:0x05bf  */
    /* JADX WARN: Found duplicated region for block: B:324:0x05d6  */
    /* JADX WARN: Found duplicated region for block: B:330:0x05eb  */
    /* JADX WARN: Found duplicated region for block: B:332:0x05ee  */
    /* JADX WARN: Found duplicated region for block: B:334:0x05f5  */
    /* JADX WARN: Found duplicated region for block: B:338:0x05fd  */
    /* JADX WARN: Found duplicated region for block: B:340:0x0601  */
    /* JADX WARN: Found duplicated region for block: B:342:0x0607  */
    /* JADX WARN: Found duplicated region for block: B:343:0x0609  */
    /* JADX WARN: Found duplicated region for block: B:345:0x060d  */
    /* JADX WARN: Found duplicated region for block: B:346:0x0612  */
    /* JADX WARN: Found duplicated region for block: B:351:0x0625  */
    /* JADX WARN: Found duplicated region for block: B:354:0x062a  */
    /* JADX WARN: Found duplicated region for block: B:358:0x0633  */
    /* JADX WARN: Found duplicated region for block: B:359:0x063d  */
    /* JADX WARN: Found duplicated region for block: B:35:0x007b A[EDGE_INSN: B:35:0x007b->B:36:0x007c BREAK  A[LOOP:0: B:14:0x0023->B:20:0x003d]] */
    /* JADX WARN: Found duplicated region for block: B:361:0x0643  */
    /* JADX WARN: Found duplicated region for block: B:362:0x064d  */
    /* JADX WARN: Found duplicated region for block: B:365:0x0653 A[ADDED_TO_REGION] */
    /* JADX WARN: Found duplicated region for block: B:367:0x0657  */
    public final SomeView s(int i, long j) {
        boolean z;
        SomeView someViewVarG;
        boolean z2;
        long j2;
        long j3;
        boolean z3;
        boolean z4;
        cyw cywVar;
        boolean z5;
        long nanoTime;
        long j4;
        AccessibilityManager accessibilityManager;
        boolean z6;
        czz czzVar;
        czy czyVar;
        AccessibilityDelegateCompat aqVar;
        ArrayList arrayList;
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        czh czhVar;
        androidx.recyclerview.widget.RecyclerView recyclerViewCr;
        SomeView someViewVar;
        SomeView someViewVar2;
        ArrayList arrayList2;
        View view;
        boolean z7;
        int size;
        int iN;
        androidx.recyclerview.widget.RecyclerView recyclerView = this.h;
        czt cztVar = recyclerView.bo;
        if (i < 0 || i >= cztVar.p()) {
            StringBuilder sbQ = yg.concatVar31425(i, i, "Invalid item position ", "(", "). Item count:");
            sbQ.append(cztVar.p());
            sbQ.append(recyclerView.dm());
            throw new IndexOutOfBoundsException(sbQ.toString());
        }
        if (cztVar.g) {
            ArrayList arrayList3 = this.b;
            if (arrayList3 != null && (size = arrayList3.size()) != 0) {
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        if (recyclerView.w.ad && (iN = recyclerView.o.n(i, 0)) > 0 && iN < recyclerView.w.d()) {
                            long jE = recyclerView.w.e(iN);
                            int i3 = 0;
                            while (true) {
                                if (i3 >= size) {
                                    someViewVarG = null;
                                    break;
                                }
                                SomeView someViewVar3 = (SomeView) this.b.get(i3);
                                if (!someViewVar3.an() && someViewVar3.h == jE) {
                                    someViewVar3.w(32);
                                    someViewVarG = someViewVar3;
                                    break;
                                }
                                i3++;
                            }
                        } else {
                            someViewVarG = null;
                            break;
                        }
                    } else {
                        someViewVarG = (SomeView) this.b.get(i2);
                        if (!someViewVarG.an() && someViewVarG.z() == i) {
                            someViewVarG.w(32);
                            break;
                        }
                        i2++;
                    }
                }
            } else {
                someViewVarG = null;
                break;
            }
            z = someViewVarG != null;
        } else {
            z = false;
            someViewVarG = null;
        }
        ArrayList arrayList4 = this.a;
        ArrayList arrayList5 = this.c;
        if (someViewVarG == null) {
            int size2 = arrayList4.size();
            int i4 = 0;
            while (true) {
                if (i4 >= size2) {
                    ArrayList arrayList6 = (ArrayList) recyclerView.p.e;
                    int size3 = arrayList6.size();
                    int i5 = 0;
                    while (true) {
                        if (i5 >= size3) {
                            z2 = true;
                            view = null;
                            break;
                        }
                        view = (View) arrayList6.get(i5);
                        SomeView someViewVarCs = androidx.recyclerview.widget.RecyclerView.cs(view);
                        z2 = true;
                        if (someViewVarCs.z() == i && !someViewVarCs.ad() && !someViewVarCs.af()) {
                            break;
                        }
                        i5++;
                    }
                    if (view == null) {
                        int size4 = arrayList5.size();
                        int i6 = 0;
                        while (true) {
                            if (i6 >= size4) {
                                someViewVarG = null;
                                break;
                            }
                            SomeView someViewVar4 = (SomeView) arrayList5.get(i6);
                            if (!someViewVar4.ad() && someViewVar4.z() == i && !someViewVar4.ab()) {
                                arrayList5.remove(i6);
                                if (androidx.recyclerview.widget.RecyclerView.b) {
                                    Log.d("RecyclerView", "getScrapOrHiddenOrCachedHolderForPosition(" + i + ") found match in cache: " + someViewVar4);
                                }
                                someViewVarG = someViewVar4;
                                break;
                            }
                            i6++;
                        }
                    } else {
                        SomeView someViewVarCs2 = androidx.recyclerview.widget.RecyclerView.cs(view);
                        yi yiVar = recyclerView.p;
                        yh yhVar = (yh) yiVar.d;
                        int iIndexOfChild = ((cyv) yiVar.c).a.indexOfChild(view);
                        if (iIndexOfChild < 0) {
                            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
                        }
                        if (!yhVar.f(iIndexOfChild)) {
                            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
                        }
                        yhVar.c(iIndexOfChild);
                        yiVar.ak(view);
                        yi yiVar2 = recyclerView.p;
                        yh yhVar2 = (yh) yiVar2.d;
                        int iIndexOfChild2 = ((cyv) yiVar2.c).a.indexOfChild(view);
                        int iD = (iIndexOfChild2 == -1 || yhVar2.f(iIndexOfChild2)) ? -1 : iIndexOfChild2 - yhVar2.d(iIndexOfChild2);
                        if (iD == -1) {
                            StringBuilder sb = new StringBuilder("layout index should not be -1 after unhiding a view:");
                            sb.append(someViewVarCs2);
                            throw new IllegalStateException(yg.i(recyclerView, sb));
                        }
                        recyclerView.p.u(iD);
                        r(view);
                        someViewVarCs2.w(8224);
                        someViewVarG = someViewVarCs2;
                        break;
                    }
                } else {
                    SomeView someViewVar5 = (SomeView) arrayList4.get(i4);
                    if (!someViewVar5.an() && someViewVar5.z() == i && !someViewVar5.ad() && (cztVar.g || !someViewVar5.af())) {
                        someViewVar5.w(32);
                        someViewVarG = someViewVar5;
                        z2 = true;
                        break;
                    }
                    i4++;
                }
            }
            if (someViewVarG != null) {
                if (!someViewVarG.af()) {
                    int i7 = someViewVarG.f;
                    if (i7 < 0 || i7 >= recyclerView.w.d()) {
                        StringBuilder sb2 = new StringBuilder("Inconsistency detected. Invalid view holder adapter position");
                        sb2.append(someViewVarG);
                        throw new IndexOutOfBoundsException(yg.i(recyclerView, sb2));
                    }
                    if (cztVar.g || recyclerView.w.i(someViewVarG.f) == someViewVarG.i) {
                        cyw cywVar2 = recyclerView.w;
                        z7 = (!cywVar2.ad || someViewVarG.h == cywVar2.e(someViewVarG.f)) ? z2 : false;
                    }
                } else {
                    if (androidx.recyclerview.widget.RecyclerView.a && !cztVar.g) {
                        throw new IllegalStateException(yg.i(recyclerView, new StringBuilder("should not receive a removed view unless it is pre layout")));
                    }
                    z7 = cztVar.g;
                }
                if (z7) {
                    z = z2;
                } else {
                    someViewVarG.w(4);
                    if (someViewVarG.ag()) {
                        recyclerView.removeDetachedView(someViewVarG.d, false);
                        someViewVarG.q.t(someViewVarG);
                    } else if (someViewVarG.an()) {
                        someViewVarG.m &= -33;
                    }
                    q(someViewVarG);
                    someViewVarG = null;
                }
            }
        } else {
            z2 = true;
        }
        if (someViewVarG == null) {
            int iN2 = recyclerView.o.n(i, 0);
            if (iN2 >= 0) {
                j2 = 3;
                if (iN2 < recyclerView.w.d()) {
                    int i8 = recyclerView.w.i(iN2);
                    cyw cywVar3 = recyclerView.w;
                    j3 = 4;
                    if (cywVar3.ad) {
                        long jE2 = cywVar3.e(iN2);
                        int size5 = arrayList4.size() - 1;
                        while (true) {
                            if (size5 < 0) {
                                int size6 = arrayList5.size() - 1;
                                while (true) {
                                    if (size6 >= 0) {
                                        someViewVar2 = (SomeView) arrayList5.get(size6);
                                        if (someViewVar2.h != jE2 || someViewVar2.ab()) {
                                            size6--;
                                        } else if (i8 == someViewVar2.i) {
                                            arrayList5.remove(size6);
                                        } else {
                                            o(size6);
                                        }
                                    }
                                    someViewVarG = null;
                                    break;
                                }
                            }
                            someViewVar2 = (SomeView) arrayList4.get(size5);
                            ArrayList arrayList7 = arrayList4;
                            long j5 = someViewVar2.h;
                            View view2 = someViewVar2.d;
                            if (j5 != jE2 || someViewVar2.an()) {
                                arrayList2 = arrayList7;
                            } else if (i8 == someViewVar2.i) {
                                someViewVar2.w(32);
                                if (someViewVar2.af() && !cztVar.g) {
                                    someViewVar2.m = (someViewVar2.m & (-15)) | 2;
                                }
                            } else {
                                arrayList2 = arrayList7;
                                arrayList2.remove(size5);
                                recyclerView.removeDetachedView(view2, false);
                                SomeView someViewVarCs3 = androidx.recyclerview.widget.RecyclerView.cs(view2);
                                someViewVarCs3.q = null;
                                someViewVarCs3.r = false;
                                someViewVarCs3.m &= -33;
                                q(someViewVarCs3);
                            }
                            size5--;
                            arrayList4 = arrayList2;
                            someViewVarG = someViewVar2;
                            break;
                        }
                        if (someViewVarG != null) {
                            someViewVarG.f = iN2;
                            z = z2;
                        }
                    }
                    if (someViewVarG == null) {
                        if (androidx.recyclerview.widget.RecyclerView.b) {
                            Log.d("RecyclerView", "tryGetViewHolderForPositionByDeadline(" + i + ") fetching from shared pool");
                        }
                        czm czmVar = (czm) k().a.get(i8);
                        if (czmVar == null) {
                            someViewVar = null;
                            break;
                        }
                        ArrayList arrayList8 = czmVar.a;
                        if (!arrayList8.isEmpty()) {
                            int size7 = arrayList8.size() - 1;
                            while (true) {
                                if (size7 < 0) {
                                    someViewVar = null;
                                    break;
                                }
                                if (!((SomeView) arrayList8.get(size7)).ab()) {
                                    someViewVar = (SomeView) arrayList8.remove(size7);
                                    break;
                                }
                                size7--;
                            }
                        } else {
                            someViewVar = null;
                            break;
                        }
                        if (someViewVar != null) {
                            someViewVar.ak();
                            boolean z8 = androidx.recyclerview.widget.RecyclerView.a;
                        }
                        someViewVarG = someViewVar;
                    }
                    if (someViewVarG == null) {
                        long nanoTime2 = recyclerView.getNanoTime();
                        if (j != Long.MAX_VALUE) {
                            long j6 = this.g.d(i8).c;
                            if (!((j6 == 0 || j6 + nanoTime2 < j) ? z2 : false)) {
                                return null;
                            }
                        }
                        cyw cywVar4 = recyclerView.w;
                        cywVar4.getClass();
                        try {
                            if (TraceCompat.c()) {
                                Trace.beginSection(String.format("RV onCreateViewHolder type=0x%X", Integer.valueOf(i8)));
                            }
                            someViewVarG = cywVar4.g(recyclerView, i8);
                            View view3 = someViewVarG.d;
                            if (view3.getParent() != null) {
                                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                            }
                            someViewVarG.i = i8;
                            Trace.endSection();
                            if (androidx.recyclerview.widget.RecyclerView.g && (recyclerViewCr = androidx.recyclerview.widget.RecyclerView.cr(view3)) != null) {
                                someViewVarG.e = new WeakReference(recyclerViewCr);
                            }
                            long nanoTime3 = recyclerView.getNanoTime() - nanoTime2;
                            czm czmVarD = this.g.d(i8);
                            long j7 = czmVarD.c;
                            if (j7 != 0) {
                                nanoTime3 = (nanoTime3 / 4) + ((j7 / 4) * 3);
                            }
                            czmVarD.c = nanoTime3;
                            if (androidx.recyclerview.widget.RecyclerView.b) {
                                Log.d("RecyclerView", "tryGetViewHolderForPositionByDeadline created new ViewHolder");
                            }
                        } catch (Throwable th) {
                            Trace.endSection();
                            throw th;
                        }
                    }
                }
            }
            StringBuilder sbQ2 = yg.concatVar31425(i, iN2, "Inconsistency detected. Invalid item position ", "(offset:", ").state:");
            sbQ2.append(cztVar.p());
            sbQ2.append(recyclerView.dm());
            throw new IndexOutOfBoundsException(sbQ2.toString());
        }
        j2 = 3;
        j3 = 4;
        View view4 = someViewVarG.d;
        if (z && !cztVar.g) {
            int i9 = someViewVarG.m;
            if ((i9 & 8192) != 0 ? z2 : false) {
                someViewVarG.m = i9 & (-8193);
                if (cztVar.j) {
                    czc.ad(someViewVarG);
                    czc czcVar = recyclerView.aw;
                    someViewVarG.aa();
                    czcVar.getClass();
                    cjn cjnVar = new cjn();
                    cjnVar.c(someViewVarG);
                    recyclerView.ei(someViewVarG, cjnVar);
                }
            }
        }
        if (!cztVar.g || !someViewVarG.ac()) {
            if (someViewVarG.ac()) {
                if (((someViewVarG.m & 2) != 0 ? z2 : false) || someViewVarG.ad()) {
                }
                layoutParams2 = view4.getLayoutParams();
                if (layoutParams2 == null) {
                    czhVar = (czh) recyclerView.generateDefaultLayoutParams();
                    view4.setLayoutParams(czhVar);
                } else if (recyclerView.checkLayoutParams(layoutParams2)) {
                    czhVar = (czh) layoutParams2;
                } else {
                    czhVar = (czh) recyclerView.generateLayoutParams(layoutParams2);
                    view4.setLayoutParams(czhVar);
                }
                czhVar.c = someViewVarG;
                czhVar.f = (z || !z3) ? false : z6;
                return someViewVarG;
            }
            if (androidx.recyclerview.widget.RecyclerView.a && someViewVarG.af()) {
                StringBuilder sb3 = new StringBuilder("Removed holder should be bound and it should come here only in pre-layout. Holder: ");
                sb3.append(someViewVarG);
                throw new IllegalStateException(yg.i(recyclerView, sb3));
            }
            z3 = false;
            int iN3 = recyclerView.o.n(i, 0);
            someViewVarG.v = null;
            someViewVarG.u = recyclerView;
            int i10 = someViewVarG.i;
            long nanoTime4 = recyclerView.getNanoTime();
            if (j != Long.MAX_VALUE) {
                long j8 = this.g.d(i10).d;
                if (j8 == 0 || j8 + nanoTime4 < j) {
                    if (someViewVarG.ah()) {
                        recyclerView.attachViewToParent(view4, recyclerView.getChildCount(), view4.getLayoutParams());
                        z4 = z2;
                    } else {
                        z4 = false;
                    }
                    cywVar = recyclerView.w;
                    cywVar.getClass();
                    z5 = someViewVarG.v == null ? z2 : false;
                    if (z5) {
                        someViewVarG.f = iN3;
                        if (cywVar.ad) {
                            someViewVarG.h = cywVar.e(iN3);
                        }
                        someViewVarG.m = (someViewVarG.m & (-520)) | 1;
                        if (TraceCompat.c()) {
                            Trace.beginSection(String.format("RV onBindViewHolder type=0x%X", Integer.valueOf(someViewVarG.i)));
                        }
                    }
                    someViewVarG.v = cywVar;
                    if (androidx.recyclerview.widget.RecyclerView.a) {
                        if (view4.getParent() != null && view4.isAttachedToWindow() != someViewVarG.ah()) {
                            throw new IllegalStateException("Temp-detached state out of sync with reality. holder.isTmpDetached(): " + someViewVarG.ah() + ", attached to window: " + view4.isAttachedToWindow() + ", holder: " + someViewVarG);
                        }
                        if (view4.getParent() == null && view4.isAttachedToWindow()) {
                            throw new IllegalStateException("Attempting to bind attached holder with no parent (AKA temp detached): " + someViewVarG);
                        }
                    }
                    cywVar.k(someViewVarG, iN3, someViewVarG.aa());
                    if (z5) {
                        arrayList = someViewVarG.n;
                        if (arrayList != null) {
                            arrayList.clear();
                        }
                        someViewVarG.m &= -1025;
                        layoutParams = view4.getLayoutParams();
                        if (layoutParams instanceof czh) {
                            ((czh) layoutParams).e = z2;
                        }
                        Trace.endSection();
                    }
                    if (z4) {
                        recyclerView.detachViewFromParent(view4);
                    }
                    nanoTime = recyclerView.getNanoTime() - nanoTime4;
                    czm czmVarD2 = this.g.d(someViewVarG.i);
                    j4 = czmVarD2.d;
                    if (j4 != 0) {
                        nanoTime = (nanoTime / j3) + ((j4 / j3) * j2);
                    }
                    czmVarD2.d = nanoTime;
                    accessibilityManager = recyclerView.al;
                    if (accessibilityManager == null && accessibilityManager.isEnabled()) {
                        z6 = true;
                        if (view4.getImportantForAccessibility() == 0) {
                            view4.setImportantForAccessibility(1);
                        }
                        czzVar = recyclerView.bv;
                        if (czzVar != null) {
                            czyVar = czzVar.b;
                            if (czyVar != null) {
                                View.AccessibilityDelegate accessibilityDelegateJ = ViewCompat.getAccessibilityDelegate(view4);
                                aqVar = accessibilityDelegateJ == null ? null : accessibilityDelegateJ instanceof AccessibilityDelegateCompat$AccessibilityDelegateAdapter ? ((AccessibilityDelegateCompat$AccessibilityDelegateAdapter) accessibilityDelegateJ).a : new AccessibilityDelegateCompat(accessibilityDelegateJ);
                                if (aqVar != null && aqVar != czyVar) {
                                    czyVar.b.put(view4, aqVar);
                                }
                            }
                            ViewCompat.setAccessibilityDelegate(view4, czyVar);
                        }
                    } else {
                        z6 = true;
                    }
                    if (cztVar.g) {
                        someViewVarG.j = i;
                    }
                    z3 = z6;
                } else {
                    z6 = z2;
                }
            } else {
                if (someViewVarG.ah()) {
                    recyclerView.attachViewToParent(view4, recyclerView.getChildCount(), view4.getLayoutParams());
                    z4 = z2;
                } else {
                    z4 = false;
                }
                cywVar = recyclerView.w;
                cywVar.getClass();
                if (someViewVarG.v == null) {
                }
                if (z5) {
                    someViewVarG.f = iN3;
                    if (cywVar.ad) {
                        someViewVarG.h = cywVar.e(iN3);
                    }
                    someViewVarG.m = (someViewVarG.m & (-520)) | 1;
                    if (TraceCompat.c()) {
                        Trace.beginSection(String.format("RV onBindViewHolder type=0x%X", Integer.valueOf(someViewVarG.i)));
                    }
                }
                someViewVarG.v = cywVar;
                if (androidx.recyclerview.widget.RecyclerView.a) {
                    if (view4.getParent() != null) {
                    }
                    if (view4.getParent() == null) {
                        throw new IllegalStateException("Attempting to bind attached holder with no parent (AKA temp detached): " + someViewVarG);
                    }
                }
                cywVar.k(someViewVarG, iN3, someViewVarG.aa());
                if (z5) {
                    arrayList = someViewVarG.n;
                    if (arrayList != null) {
                        arrayList.clear();
                    }
                    someViewVarG.m &= -1025;
                    layoutParams = view4.getLayoutParams();
                    if (layoutParams instanceof czh) {
                        ((czh) layoutParams).e = z2;
                    }
                    Trace.endSection();
                }
                if (z4) {
                    recyclerView.detachViewFromParent(view4);
                }
                nanoTime = recyclerView.getNanoTime() - nanoTime4;
                czm czmVarD22 = this.g.d(someViewVarG.i);
                j4 = czmVarD22.d;
                if (j4 != 0) {
                    nanoTime = (nanoTime / j3) + ((j4 / j3) * j2);
                }
                czmVarD22.d = nanoTime;
                accessibilityManager = recyclerView.al;
                if (accessibilityManager == null && accessibilityManager.isEnabled()) {
                    z6 = true;
                    if (view4.getImportantForAccessibility() == 0) {
                        view4.setImportantForAccessibility(1);
                    }
                    czzVar = recyclerView.bv;
                    if (czzVar != null) {
                        czyVar = czzVar.b;
                        if (czyVar != null) {
                            View.AccessibilityDelegate accessibilityDelegateJ2 = ViewCompat.getAccessibilityDelegate(view4);
                            if (accessibilityDelegateJ2 == null) {
                            }
                            if (aqVar != null) {
                                czyVar.b.put(view4, aqVar);
                            }
                        }
                        ViewCompat.setAccessibilityDelegate(view4, czyVar);
                    }
                } else {
                    z6 = true;
                }
                if (cztVar.g) {
                    someViewVarG.j = i;
                }
                z3 = z6;
            }
            layoutParams2 = view4.getLayoutParams();
            if (layoutParams2 == null) {
                czhVar = (czh) recyclerView.generateDefaultLayoutParams();
                view4.setLayoutParams(czhVar);
            } else if (recyclerView.checkLayoutParams(layoutParams2)) {
                czhVar = (czh) recyclerView.generateLayoutParams(layoutParams2);
                view4.setLayoutParams(czhVar);
            } else {
                czhVar = (czh) layoutParams2;
            }
            czhVar.c = someViewVarG;
            czhVar.f = (z || !z3) ? false : z6;
            return someViewVarG;
        }
        someViewVarG.j = i;
        z6 = z2;
        z3 = false;
        layoutParams2 = view4.getLayoutParams();
        if (layoutParams2 == null) {
            czhVar = (czh) recyclerView.generateDefaultLayoutParams();
            view4.setLayoutParams(czhVar);
        } else if (recyclerView.checkLayoutParams(layoutParams2)) {
            czhVar = (czh) recyclerView.generateLayoutParams(layoutParams2);
            view4.setLayoutParams(czhVar);
        } else {
            czhVar = (czh) layoutParams2;
        }
        czhVar.c = someViewVarG;
        czhVar.f = (z || !z3) ? false : z6;
        return someViewVarG;
    }

    public final void t(SomeView someViewVar) {
        if (someViewVar.r) {
            this.b.remove(someViewVar);
        } else {
            this.a.remove(someViewVar);
        }
        someViewVar.q = null;
        someViewVar.r = false;
        someViewVar.m &= -33;
    }

    public final void u() {
        czg czgVar = this.h.x;
        this.f = this.e + (czgVar != null ? czgVar.dx : 0);
        ArrayList arrayList = this.c;
        for (int size = arrayList.size() - 1; size >= 0 && arrayList.size() > this.f; size--) {
            o(size);
        }
    }
}
