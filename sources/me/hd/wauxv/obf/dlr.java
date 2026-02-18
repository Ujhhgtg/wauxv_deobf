package me.hd.wauxv.obf;

import android.util.Log;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dlr {
    public int a;
    public int b;
    public final bdj c;
    public final ArrayList d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public final ArrayList j;
    public final ArrayList k;
    public final bfb l;

    public dlr(int i, int i2, bfb bfbVar) {
        bjs.t(i, "finalState");
        bjs.t(i2, "lifecycleImpact");
        bdj bdjVar = bfbVar.c;
        throwIfVar1IsNull(bdjVar, "fragmentStateManager.fragment");
        bjs.t(i, "finalState");
        bjs.t(i2, "lifecycleImpact");
        throwIfVar1IsNull(bdjVar, "fragment");
        this.a = i;
        this.b = i2;
        this.c = bdjVar;
        this.d = new ArrayList();
        this.i = true;
        ArrayList arrayList = new ArrayList();
        this.j = arrayList;
        this.k = arrayList;
        this.l = bfbVar;
    }

    public final void m(ViewGroup viewGroup) {
        throwIfVar1IsNull(viewGroup, "container");
        this.h = false;
        if (this.e) {
            return;
        }
        this.e = true;
        if (this.j.isEmpty()) {
            n();
            return;
        }
        for (dlq dlqVar : aaz.z(this.k)) {
            dlqVar.getClass();
            if (!dlqVar.h) {
                dlqVar.b(viewGroup);
            }
            dlqVar.h = true;
        }
    }

    public final void n() {
        this.h = false;
        if (!this.f) {
            if (beg.ar(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.f = true;
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }
        this.c.be = false;
        this.l.p();
    }

    public final void o(dlq dlqVar) {
        throwIfVar1IsNull(dlqVar, "effect");
        ArrayList arrayList = this.j;
        if (arrayList.remove(dlqVar) && arrayList.isEmpty()) {
            n();
        }
    }

    public final void p(int i, int i2) {
        bjs.t(i, "finalState");
        bjs.t(i2, "lifecycleImpact");
        int iAe = dkz.ae(i2);
        bdj bdjVar = this.c;
        if (iAe == 0) {
            if (this.a != 1) {
                if (beg.ar(2)) {
                    Log.v("FragmentManager",
                            "SpecialEffectsController: For fragment " + bdjVar + " mFinalState = " + bjs.ac(this.a)
                                    + " -> " + bjs.ac(i)
                                    + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
                }
                this.a = i;
                return;
            }
            return;
        }
        if (iAe == 1) {
            if (this.a == 1) {
                if (beg.ar(2)) {
                    Log.v("FragmentManager",
                            "SpecialEffectsController: For fragment " + bdjVar
                                    + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + bjs.ab(this.b)
                                    + " to ADDING.");
                }
                this.a = 2;
                this.b = 2;
                this.i = true;
                return;
            }
            return;
        }
        if (iAe != 2) {
            return;
        }
        if (beg.ar(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: For fragment " + bdjVar + " mFinalState = "
                    + bjs.ac(this.a) + " -> REMOVED. mLifecycleImpact  = " + bjs.ab(this.b) + " to REMOVING.");
        }
        this.a = 1;
        this.b = 3;
        this.i = true;
    }

    public final String toString() {
        StringBuilder sbZ = dkz.z("Operation {", Integer.toHexString(System.identityHashCode(this)),
                "} {finalState = ");
        sbZ.append(bjs.ac(this.a));
        sbZ.append(" lifecycleImpact = ");
        sbZ.append(bjs.ab(this.b));
        sbZ.append(" fragment = ");
        sbZ.append(this.c);
        sbZ.append('}');
        return sbZ.toString();
    }
}
