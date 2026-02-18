package me.hd.wauxv.obf;

import android.os.Build;
import android.util.Log;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cqt {
    public final Runnable a;
    public final km b = new km();
    public bdx c;
    public final OnBackInvokedCallback d;
    public OnBackInvokedDispatcher e;
    public boolean f;
    public boolean g;

    public cqt(Runnable runnable) {
        OnBackInvokedCallback onBackInvokedCallbackB;
        this.a = runnable;
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            if (i >= 34) {
                onBackInvokedCallbackB = cqp.a.b(new cql(this, 0), new cql(this, 1), new cqm(this, 0),
                        new cqm(this, 1));
            } else {
                onBackInvokedCallbackB = cqn.a.b(new cqm(this, 2));
            }
            this.d = onBackInvokedCallbackB;
        }
    }

    public final void h() {
        Object objPrevious;
        bdx bdxVar = this.c;
        if (bdxVar == null) {
            km kmVar = this.b;
            ListIterator<E> listIterator = kmVar.listIterator(kmVar.size());
            do {
                if (!listIterator.hasPrevious()) {
                    objPrevious = null;
                    break;
                }
                objPrevious = listIterator.previous();
            } while (!((bdx) objPrevious).a);
            bdxVar = (bdx) objPrevious;
        }
        this.c = null;
        if (bdxVar != null) {
            bdxVar.f();
        }
    }

    public final void i() {
        Object objPrevious;
        bdx bdxVar = this.c;
        if (bdxVar == null) {
            km kmVar = this.b;
            ListIterator listIterator = kmVar.listIterator(kmVar.a());
            do {
                if (!listIterator.hasPrevious()) {
                    objPrevious = null;
                    break;
                }
                objPrevious = listIterator.previous();
            } while (!((bdx) objPrevious).a);
            bdxVar = (bdx) objPrevious;
        }
        this.c = null;
        if (bdxVar == null) {
            this.a.run();
            return;
        }
        switch (bdxVar.d) {
            case 0:
                beg begVar = (beg) bdxVar.e;
                if (beg.ar(3)) {
                    Log.d("FragmentManager", "handleOnBackPressed. PREDICTIVE_BACK = true fragment manager " + begVar);
                }
                bdx bdxVar2 = begVar.j;
                ArrayList<bes> arrayList = begVar.n;
                begVar.i = true;
                begVar.bw(true);
                begVar.i = false;
                if (begVar.h != null) {
                    if (!arrayList.isEmpty()) {
                        LinkedHashSet linkedHashSet = new LinkedHashSet(beg.aq(begVar.h));
                        for (bes besVar : arrayList) {
                            Iterator it = linkedHashSet.iterator();
                            while (it.hasNext()) {
                                besVar.c((bdj) it.next(), true);
                            }
                        }
                    }
                    Iterator it2 = begVar.h.a.iterator();
                    while (it2.hasNext()) {
                        bdj bdjVar = ((bfe) it2.next()).b;
                        if (bdjVar != null) {
                            bdjVar.be = false;
                        }
                    }
                    for (aln alnVar : begVar.bb(new ArrayList(Collections.singletonList(begVar.h)), 0, 1)) {
                        ArrayList arrayList2 = alnVar.c;
                        if (beg.ar(3)) {
                            Log.d("FragmentManager", "SpecialEffectsController: Completing Back ");
                        }
                        alnVar.q(arrayList2);
                        alnVar.k(arrayList2);
                    }
                    Iterator it3 = begVar.h.a.iterator();
                    while (it3.hasNext()) {
                        bdj bdjVar2 = ((bfe) it3.next()).b;
                        if (bdjVar2 != null && bdjVar2.by == null) {
                            begVar.bc(bdjVar2).p();
                        }
                    }
                    begVar.h = null;
                    begVar.cz();
                    if (beg.ar(3)) {
                        Log.d("FragmentManager", "Op is being set to null");
                        Log.d("FragmentManager",
                                "OnBackPressedCallback enabled=" + bdxVar2.a + " for  FragmentManager " + begVar);
                    }
                } else if (bdxVar2.a) {
                    if (beg.ar(3)) {
                        Log.d("FragmentManager", "Calling popBackStackImmediate via onBackPressed callback");
                    }
                    begVar.cl();
                } else {
                    if (beg.ar(3)) {
                        Log.d("FragmentManager", "Calling onBackPressed via onBackPressed callback");
                    }
                    begVar.g.i();
                }
                break;
            default:
                cix cixVar = ((cjl) bdxVar.e).b;
                if (!cixVar.f.isEmpty()) {
                    cjg cjgVarAf = cixVar.af();
                    throwIfVar1IsNull(cjgVarAf);
                    if (cixVar.al(cjgVarAf.g.a, true, false)) {
                        cixVar.ac();
                    }
                    break;
                }
                break;
        }
    }

    public final void j(boolean z) {
        OnBackInvokedCallback onBackInvokedCallback;
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.e;
        if (onBackInvokedDispatcher == null || (onBackInvokedCallback = this.d) == null) {
            return;
        }
        cqn cqnVar = cqn.a;
        if (z && !this.f) {
            cqnVar.c(onBackInvokedDispatcher, 0, onBackInvokedCallback);
            this.f = true;
        } else {
            if (z || !this.f) {
                return;
            }
            cqnVar.d(onBackInvokedDispatcher, onBackInvokedCallback);
            this.f = false;
        }
    }

    public final void k() {
        boolean z = this.g;
        boolean z2 = false;
        km kmVar = this.b;
        if (kmVar == null || !kmVar.isEmpty()) {
            Iterator it = kmVar.iterator();
            while (it.hasNext()) {
                if (((bdx) it.next()).a) {
                    z2 = true;
                    break;
                }
            }
        }
        this.g = z2;
        if (z2 == z || Build.VERSION.SDK_INT < 33) {
            return;
        }
        j(z2);
    }
}
