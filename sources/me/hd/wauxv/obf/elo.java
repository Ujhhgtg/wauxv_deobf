package me.hd.wauxv.obf;

import android.animation.Animator;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowId;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class elo implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
    public ell a;
    public ViewGroup b;

    /* JADX WARN: Found duplicated region for block: B:101:0x021e  */
    /* JADX WARN: Found duplicated region for block: B:103:0x022c  */
    /* JADX WARN: Found duplicated region for block: B:104:0x0238  */
    /* JADX WARN: Found duplicated region for block: B:108:0x024a  */
    /* JADX WARN: Found duplicated region for block: B:135:0x01f6 A[EDGE_INSN: B:135:0x01f6->B:91:0x01f6 BREAK  A[LOOP:1: B:19:0x0085->B:90:0x01ec], SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:14:0x004c  */
    /* JADX WARN: Found duplicated region for block: B:165:0x0216 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:17:0x0056 A[LOOP:0: B:15:0x0050->B:17:0x0056, LOOP_END] */
    /* JADX WARN: Found duplicated region for block: B:21:0x008a  */
    /* JADX WARN: Found duplicated region for block: B:23:0x008e  */
    /* JADX WARN: Found duplicated region for block: B:25:0x0091  */
    /* JADX WARN: Found duplicated region for block: B:27:0x0094  */
    /* JADX WARN: Found duplicated region for block: B:29:0x0097  */
    /* JADX WARN: Found duplicated region for block: B:30:0x009c  */
    /* JADX WARN: Found duplicated region for block: B:32:0x00ab  */
    /* JADX WARN: Found duplicated region for block: B:45:0x00f5  */
    /* JADX WARN: Found duplicated region for block: B:48:0x0105  */
    /* JADX WARN: Found duplicated region for block: B:50:0x011a  */
    /* JADX WARN: Found duplicated region for block: B:63:0x015f  */
    /* JADX WARN: Found duplicated region for block: B:65:0x016f  */
    /* JADX WARN: Found duplicated region for block: B:78:0x01b2  */
    /* JADX WARN: Found duplicated region for block: B:80:0x01bb  */
    /* JADX WARN: Found duplicated region for block: B:94:0x01fd  */
    /* JADX WARN: Found duplicated region for block: B:96:0x020b  */
    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        ArrayList arrayList;
        int i;
        chm chmVar;
        chm chmVar2;
        ku kuVar;
        ku kuVar2;
        int i2;
        int[] iArr;
        boolean z;
        int i3;
        int i4;
        ku kuVarBf;
        int i5;
        Animator animator;
        elh elhVar;
        elt eltVar;
        elt eltVar2;
        int i6;
        chm chmVar3;
        boolean z2;
        int i7;
        View view;
        elt eltVar3;
        ku kuVar3;
        int i8;
        int i9;
        View view2;
        View view3;
        SparseArray sparseArray;
        int size;
        int i10;
        View view4;
        View view5;
        byc bycVar;
        int iK;
        int i11;
        View view6;
        chm chmVar4;
        boolean z3;
        Iterator it;
        ell ellVar = this.a;
        ViewGroup viewGroup = this.b;
        viewGroup.getViewTreeObserver().removeOnPreDrawListener(this);
        viewGroup.removeOnAttachStateChangeListener(this);
        boolean z4 = true;
        if (!elp.c.remove(viewGroup)) {
            return true;
        }
        ku kuVarE = elp.e();
        ArrayList arrayList2 = (ArrayList) kuVarE.get(viewGroup);
        if (arrayList2 != null) {
            arrayList = arrayList2.size() > 0 ? new ArrayList(arrayList2) : null;
            arrayList2.add(ellVar);
            ellVar.bh(new eln(this, kuVarE));
            i = 0;
            ellVar.bj(viewGroup, false);
            if (arrayList != null) {
                it = arrayList.iterator();
                while (it.hasNext()) {
                    ((ell) it.next()).o(viewGroup);
                }
            }
            ellVar.aq = new ArrayList();
            ellVar.ar = new ArrayList();
            chmVar = ellVar.am;
            chmVar2 = ellVar.an;
            kuVar = new ku((ku) chmVar.c);
            kuVar2 = new ku((ku) chmVar2.c);
            i2 = 0;
            while (true) {
                iArr = ellVar.ap;
                if (i2 < iArr.length) {
                    break;
                }
                i6 = iArr[i2];
                if (i6 != z4) {
                    chmVar3 = chmVar2;
                    z2 = z4;
                    for (i7 = kuVar.l - 1; i7 >= 0; i7--) {
                        view = (View) kuVar.r(i7);
                        if (view == null && ellVar.bp(view) && (eltVar3 = (elt) kuVar2.remove(view)) != null && ellVar.bp(eltVar3.b)) {
                            ellVar.aq.add((elt) kuVar.h(i7));
                            ellVar.ar.add(eltVar3);
                        }
                    }
                } else if (i6 != 2) {
                    chmVar3 = chmVar2;
                    z2 = z4;
                    kuVar3 = (ku) chmVar.f;
                    ku kuVar4 = (ku) chmVar3.f;
                    i8 = kuVar3.l;
                    for (i9 = 0; i9 < i8; i9++) {
                        view2 = (View) kuVar3.s(i9);
                        if (view2 == null && ellVar.bp(view2) && (view3 = (View) kuVar4.get(kuVar3.r(i9))) != null && ellVar.bp(view3)) {
                            elt eltVar4 = (elt) kuVar.get(view2);
                            elt eltVar5 = (elt) kuVar2.get(view3);
                            if (eltVar4 != null && eltVar5 != null) {
                                ellVar.aq.add(eltVar4);
                                ellVar.ar.add(eltVar5);
                                kuVar.remove(view2);
                                kuVar2.remove(view3);
                            }
                        }
                    }
                } else if (i6 != 3) {
                    z2 = z4;
                    sparseArray = (SparseArray) chmVar.d;
                    chmVar3 = chmVar2;
                    SparseArray sparseArray2 = (SparseArray) chmVar3.d;
                    size = sparseArray.size();
                    for (i10 = 0; i10 < size; i10++) {
                        view4 = (View) sparseArray.valueAt(i10);
                        if (view4 == null && ellVar.bp(view4) && (view5 = (View) sparseArray2.get(sparseArray.keyAt(i10))) != null && ellVar.bp(view5)) {
                            elt eltVar6 = (elt) kuVar.get(view4);
                            elt eltVar7 = (elt) kuVar2.get(view5);
                            if (eltVar6 != null && eltVar7 != null) {
                                ellVar.aq.add(eltVar6);
                                ellVar.ar.add(eltVar7);
                                kuVar.remove(view4);
                                kuVar2.remove(view5);
                            }
                        }
                    }
                } else if (i6 != 4) {
                    chmVar3 = chmVar2;
                    z2 = z4;
                } else {
                    bycVar = (byc) chmVar.e;
                    byc bycVar2 = (byc) chmVar2.e;
                    iK = bycVar.k();
                    i11 = i;
                    while (i11 < iK) {
                        view6 = (View) bycVar.l(i11);
                        if (view6 == null && ellVar.bp(view6)) {
                            chmVar4 = chmVar2;
                            View view7 = (View) bycVar2.f(bycVar.h(i11));
                            if (view7 != null && ellVar.bp(view7)) {
                                elt eltVar8 = (elt) kuVar.get(view6);
                                elt eltVar9 = (elt) kuVar2.get(view7);
                                if (eltVar8 != null && eltVar9 != null) {
                                    z3 = z4;
                                    ellVar.aq.add(eltVar8);
                                    ellVar.ar.add(eltVar9);
                                    kuVar.remove(view6);
                                    kuVar2.remove(view7);
                                }
                            }
                            i11++;
                            chmVar2 = chmVar4;
                            z4 = z3;
                        } else {
                            chmVar4 = chmVar2;
                        }
                        z3 = z4;
                        i11++;
                        chmVar2 = chmVar4;
                        z4 = z3;
                    }
                    z2 = z4;
                    chmVar3 = chmVar2;
                }
                i2++;
                chmVar2 = chmVar3;
                z4 = z2;
                i = 0;
            }
            z = z4;
            for (i3 = 0; i3 < kuVar.l; i3++) {
                eltVar2 = (elt) kuVar.s(i3);
                if (ellVar.bp(eltVar2.b)) {
                    ellVar.aq.add(eltVar2);
                    ellVar.ar.add(null);
                }
            }
            for (i4 = 0; i4 < kuVar2.l; i4++) {
                eltVar = (elt) kuVar2.s(i4);
                if (ellVar.bp(eltVar.b)) {
                    ellVar.ar.add(eltVar);
                    ellVar.aq.add(null);
                }
            }
            kuVarBf = ell.bf();
            int i12 = kuVarBf.l;
            WindowId windowId = viewGroup.getWindowId();
            i5 = i12 - 1;
            while (i5 >= 0) {
                animator = (Animator) kuVarBf.r(i5);
                if (animator == null && (elhVar = (elh) kuVarBf.get(animator)) != null) {
                    ell ellVar2 = elhVar.e;
                    View view8 = elhVar.a;
                    if (view8 != null && windowId.equals(elhVar.d)) {
                        elt eltVar10 = elhVar.c;
                        boolean z5 = z;
                        elt eltVarBo = ellVar.bo(view8, z5);
                        elt eltVarBm = ellVar.bm(view8, z5);
                        if (eltVarBo == null && eltVarBm == null) {
                            eltVarBm = (elt) ((ku) ellVar.an.c).get(view8);
                        }
                        if ((eltVarBo != null || eltVarBm != null) && ellVar2.y(eltVar10, eltVarBm)) {
                            ellVar2.bn().getClass();
                            if (animator.isRunning() || animator.isStarted()) {
                                animator.cancel();
                            } else {
                                kuVarBf.remove(animator);
                            }
                        }
                    }
                }
                i5--;
                z = true;
            }
            ellVar.j(viewGroup, ellVar.am, ellVar.an, ellVar.aq, ellVar.ar);
            ellVar.p();
            return true;
        }
        arrayList2 = new ArrayList();
        kuVarE.put(viewGroup, arrayList2);
        arrayList2.add(ellVar);
        ellVar.bh(new eln(this, kuVarE));
        i = 0;
        ellVar.bj(viewGroup, false);
        if (arrayList != null) {
            it = arrayList.iterator();
            while (it.hasNext()) {
                ((ell) it.next()).o(viewGroup);
            }
        }
        ellVar.aq = new ArrayList();
        ellVar.ar = new ArrayList();
        chmVar = ellVar.am;
        chmVar2 = ellVar.an;
        kuVar = new ku((ku) chmVar.c);
        kuVar2 = new ku((ku) chmVar2.c);
        i2 = 0;
        while (true) {
            iArr = ellVar.ap;
            if (i2 < iArr.length) {
                break;
                break;
            }
            i6 = iArr[i2];
            if (i6 != z4) {
                chmVar3 = chmVar2;
                z2 = z4;
                while (i7 >= 0) {
                    view = (View) kuVar.r(i7);
                    if (view == null) {
                    }
                }
            } else if (i6 != 2) {
                chmVar3 = chmVar2;
                z2 = z4;
                kuVar3 = (ku) chmVar.f;
                ku kuVar42 = (ku) chmVar3.f;
                i8 = kuVar3.l;
                while (i9 < i8) {
                    view2 = (View) kuVar3.s(i9);
                    if (view2 == null) {
                    }
                }
            } else if (i6 != 3) {
                z2 = z4;
                sparseArray = (SparseArray) chmVar.d;
                chmVar3 = chmVar2;
                SparseArray sparseArray22 = (SparseArray) chmVar3.d;
                size = sparseArray.size();
                while (i10 < size) {
                    view4 = (View) sparseArray.valueAt(i10);
                    if (view4 == null) {
                    }
                }
            } else if (i6 != 4) {
                chmVar3 = chmVar2;
                z2 = z4;
            } else {
                bycVar = (byc) chmVar.e;
                byc bycVar22 = (byc) chmVar2.e;
                iK = bycVar.k();
                i11 = i;
                while (i11 < iK) {
                    view6 = (View) bycVar.l(i11);
                    if (view6 == null) {
                        chmVar4 = chmVar2;
                        z3 = z4;
                    } else {
                        chmVar4 = chmVar2;
                        z3 = z4;
                    }
                    i11++;
                    chmVar2 = chmVar4;
                    z4 = z3;
                }
                z2 = z4;
                chmVar3 = chmVar2;
            }
            i2++;
            chmVar2 = chmVar3;
            z4 = z2;
            i = 0;
        }
        z = z4;
        while (i3 < kuVar.l) {
            eltVar2 = (elt) kuVar.s(i3);
            if (ellVar.bp(eltVar2.b)) {
                ellVar.aq.add(eltVar2);
                ellVar.ar.add(null);
            }
        }
        while (i4 < kuVar2.l) {
            eltVar = (elt) kuVar2.s(i4);
            if (ellVar.bp(eltVar.b)) {
                ellVar.ar.add(eltVar);
                ellVar.aq.add(null);
            }
        }
        kuVarBf = ell.bf();
        int i122 = kuVarBf.l;
        WindowId windowId2 = viewGroup.getWindowId();
        i5 = i122 - 1;
        while (i5 >= 0) {
            animator = (Animator) kuVarBf.r(i5);
            if (animator == null) {
            }
            i5--;
            z = true;
        }
        ellVar.j(viewGroup, ellVar.am, ellVar.an, ellVar.aq, ellVar.ar);
        ellVar.p();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        ViewGroup viewGroup = this.b;
        viewGroup.getViewTreeObserver().removeOnPreDrawListener(this);
        viewGroup.removeOnAttachStateChangeListener(this);
        elp.c.remove(viewGroup);
        ArrayList arrayList = (ArrayList) elp.e().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((ell) it.next()).o(viewGroup);
            }
        }
        this.a.bk(true);
    }
}
