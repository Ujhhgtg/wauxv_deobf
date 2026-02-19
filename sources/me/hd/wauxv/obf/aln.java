package me.hd.wauxv.obf;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aln {
    public final ViewGroup a;
    public final ArrayList b;
    public final ArrayList c;
    public boolean d;
    public boolean e;
    public boolean f;

    public aln(ViewGroup viewGroup) {
        throwIfVar1IsNull(viewGroup, "container");
        this.a = viewGroup;
        this.b = new ArrayList();
        this.c = new ArrayList();
    }

    public static final aln g(ViewGroup viewGroup, beg begVar) {
        throwIfVar1IsNull(viewGroup, "container");
        throwIfVar1IsNull(begVar, "fragmentManager");
        throwIfVar1IsNull(begVar.cf(), "fragmentManager.specialEffectsControllerFactory");
        Object tag = viewGroup.getTag(R.id.special_effects_controller_view_tag);
        if (tag instanceof aln) {
            return (aln) tag;
        }
        aln alnVar = new aln(viewGroup);
        viewGroup.setTag(R.id.special_effects_controller_view_tag, alnVar);
        return alnVar;
    }

    public static boolean h(ArrayList arrayList) {
        boolean z;
        dlq dlqVar;
        Iterator it = arrayList.iterator();
        loop0: while (true) {
            z = true;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                dlr dlrVar = (dlr) it.next();
                if (!dlrVar.k.isEmpty()) {
                    ArrayList arrayList2 = dlrVar.k;
                    if (arrayList2 != null && arrayList2.isEmpty()) {
                        break;
                    }
                    Iterator it2 = arrayList2.iterator();
                    do {
                        if (!it2.hasNext()) {
                            break;
                        }
                        dlqVar = (dlq) it2.next();
                        dlqVar.getClass();
                    } while (dlqVar instanceof alj);
                }
                z = false;
            }
        }
        if (z) {
            ArrayList arrayList3 = new ArrayList();
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                StaticHelpers2.an(arrayList3, ((dlr) it3.next()).k);
            }
            if (!arrayList3.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public final void i(dlr dlrVar) {
        throwIfVar1IsNull(dlrVar, "operation");
        if (dlrVar.i) {
            bjs.a(dlrVar.a, dlrVar.c.dd(), this.a);
            dlrVar.i = false;
        }
    }

    public final void j(ArrayList arrayList, boolean z) {
        Object obj;
        Object next;
        if (beg.ar(2)) {
            Log.v("FragmentManager", "Collecting Effects");
        }
        Iterator it = arrayList.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            dlr dlrVar = (dlr) next;
            View view = dlrVar.c.bz;
            throwIfVar1IsNull(view, "operation.fragment.mView");
            if (view.getAlpha() != 0.0f || view.getVisibility() != 0) {
                int visibility = view.getVisibility();
                if (visibility == 0) {
                    if (dlrVar.a != 2) {
                        break;
                    }
                } else {
                    if (visibility != 4 && visibility != 8) {
                        throw new IllegalArgumentException(concatVar2Var1(visibility, "Unknown visibility "));
                    }
                }
            }
        }
        dlr dlrVar2 = (dlr) next;
        ListIterator listIterator = arrayList.listIterator(arrayList.size());
        while (listIterator.hasPrevious()) {
            Object objPrevious = listIterator.previous();
            dlr dlrVar3 = (dlr) objPrevious;
            View view2 = dlrVar3.c.bz;
            throwIfVar1IsNull(view2, "operation.fragment.mView");
            if (view2.getAlpha() != 0.0f || view2.getVisibility() != 0) {
                int visibility2 = view2.getVisibility();
                if (visibility2 == 0) {
                    continue;
                } else if (visibility2 != 4 && visibility2 != 8) {
                    throw new IllegalArgumentException(concatVar2Var1(visibility2, "Unknown visibility "));
                }
            }
            if (dlrVar3.a == 2) {
                obj = objPrevious;
                break;
            }
        }
        dlr dlrVar4 = (dlr) obj;
        if (beg.ar(2)) {
            Log.v("FragmentManager", "Executing operations from " + dlrVar2 + " to " + dlrVar4);
        }
        ArrayList<alh> arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        SomeFragmentManager someFragmentManagerVar = ((dlr) StaticHelpers5.l(arrayList)).c;
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            bdg bdgVar = ((dlr) it2.next()).c.cc;
            bdg bdgVar2 = someFragmentManagerVar.cc;
            bdgVar.b = bdgVar2.b;
            bdgVar.c = bdgVar2.c;
            bdgVar.d = bdgVar2.d;
            bdgVar.e = bdgVar2.e;
        }
        Iterator it3 = arrayList.iterator();
        while (true) {
            boolean z2 = false;
            if (!it3.hasNext()) {
                break;
            }
            dlr dlrVar5 = (dlr) it3.next();
            arrayList2.add(new alh(dlrVar5, z));
            if (!z ? dlrVar5 == dlrVar4 : dlrVar5 == dlrVar2) {
                z2 = true;
            }
            SomeFragmentManager someFragmentManagerVar2 = dlrVar5.c;
            alm almVar = new alm(dlrVar5);
            if (dlrVar5.a == 2) {
                if (z) {
                    bdg bdgVar3 = someFragmentManagerVar2.cc;
                } else {
                    someFragmentManagerVar2.getClass();
                }
            } else if (z) {
                bdg bdgVar4 = someFragmentManagerVar2.cc;
            } else {
                someFragmentManagerVar2.getClass();
            }
            if (dlrVar5.a == 2) {
                if (z) {
                    bdg bdgVar5 = someFragmentManagerVar2.cc;
                } else {
                    bdg bdgVar6 = someFragmentManagerVar2.cc;
                }
            }
            if (z2) {
                if (z) {
                    bdg bdgVar7 = someFragmentManagerVar2.cc;
                } else {
                    someFragmentManagerVar2.getClass();
                }
            }
            arrayList3.add(almVar);
            dlrVar5.d.add(new ald(this, dlrVar5, 0));
        }
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : arrayList3) {
            if (!((alm) obj2).h()) {
                arrayList4.add(obj2);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        Iterator it4 = arrayList4.iterator();
        while (it4.hasNext()) {
            ((alm) it4.next()).getClass();
        }
        Iterator it5 = arrayList5.iterator();
        while (it5.hasNext()) {
            ((alm) it5.next()).getClass();
        }
        ArrayList<alh> arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        Iterator it6 = arrayList2.iterator();
        while (it6.hasNext()) {
            StaticHelpers2.an(arrayList7, ((dlr) ((alh) it6.next()).g).k);
        }
        boolean zIsEmpty = arrayList7.isEmpty();
        boolean z3 = false;
        for (alh alhVar : arrayList2) {
            Context context = this.a.getContext();
            dlr dlrVar6 = (dlr) alhVar.g;
            throwIfVar1IsNull(context, "context");
            DefaultConfig ioVarJ = alhVar.j(context);
            if (ioVarJ != null) {
                if (((AnimatorSet) ioVarJ.d) == null) {
                    arrayList6.add(alhVar);
                } else {
                    SomeFragmentManager someFragmentManagerVar3 = dlrVar6.c;
                    if (dlrVar6.k.isEmpty()) {
                        if (dlrVar6.a == 3) {
                            dlrVar6.i = false;
                        }
                        dlrVar6.j.add(new alj(alhVar));
                        z3 = true;
                    } else if (beg.ar(2)) {
                        Log.v("FragmentManager", "Ignoring Animator set on " + someFragmentManagerVar3
                                + " as this Fragment was involved in a Transition.");
                    }
                }
            }
        }
        for (alh alhVar2 : arrayList6) {
            dlr dlrVar7 = (dlr) alhVar2.g;
            SomeFragmentManager someFragmentManagerVar4 = dlrVar7.c;
            if (zIsEmpty) {
                if (!z3) {
                    dlrVar7.j.add(new alg(alhVar2));
                } else if (beg.ar(2)) {
                    Log.v("FragmentManager",
                            "Ignoring Animation set on " + someFragmentManagerVar4 + " as Animations cannot run alongside Animators.");
                }
            } else if (beg.ar(2)) {
                Log.v("FragmentManager",
                        "Ignoring Animation set on " + someFragmentManagerVar4 + " as Animations cannot run alongside Transitions.");
            }
        }
    }

    public final void k(List list) {
        throwIfVar1IsNull(list, "operations");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            StaticHelpers2.an(arrayList, ((dlr) it.next()).k);
        }
        List listZ = StaticHelpers5.z(StaticHelpers5.ad(arrayList));
        int size = listZ.size();
        for (int i = 0; i < size; i++) {
            ((dlq) listZ.get(i)).c(this.a);
        }
        int size2 = list.size();
        for (int i2 = 0; i2 < size2; i2++) {
            i((dlr) list.get(i2));
        }
        List listZ2 = StaticHelpers5.z(list);
        int size3 = listZ2.size();
        for (int i3 = 0; i3 < size3; i3++) {
            dlr dlrVar = (dlr) listZ2.get(i3);
            if (dlrVar.k.isEmpty()) {
                dlrVar.n();
            }
        }
    }

    public final void l(int i, int i2, FragmentManager fragmentManagerVar) {
        synchronized (this.b) {
            try {
                SomeFragmentManager someFragmentManagerVar = fragmentManagerVar.c;
                throwIfVar1IsNull(someFragmentManagerVar, "fragmentStateManager.fragment");
                dlr dlrVarN = n(someFragmentManagerVar);
                if (dlrVarN == null) {
                    SomeFragmentManager someFragmentManagerVar2 = fragmentManagerVar.c;
                    dlrVarN = (someFragmentManagerVar2.be || someFragmentManagerVar2.bd) ? o(someFragmentManagerVar2) : null;
                }
                if (dlrVarN != null) {
                    dlrVarN.p(i, i2);
                    return;
                }
                dlr dlrVar = new dlr(i, i2, fragmentManagerVar);
                this.b.add(dlrVar);
                dlrVar.d.add(new ald(this, dlrVar, 1));
                dlrVar.d.add(new ald(this, dlrVar, 2));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m() {
        boolean z;
        if (this.f) {
            return;
        }
        if (!this.a.isAttachedToWindow()) {
            p();
            this.e = false;
            return;
        }
        synchronized (this.b) {
            try {
                ArrayList<dlr> arrayListAb = StaticHelpers5.ab(this.c);
                this.c.clear();
                Iterator it = arrayListAb.iterator();
                while (true) {
                    z = true;
                    if (!it.hasNext()) {
                        break;
                    }
                    dlr dlrVar = (dlr) it.next();
                    if (this.b.isEmpty() || !dlrVar.c.be) {
                        z = false;
                    }
                    dlrVar.g = z;
                }
                for (dlr dlrVar2 : arrayListAb) {
                    if (this.d) {
                        if (beg.ar(2)) {
                            Log.v("FragmentManager",
                                    "SpecialEffectsController: Completing non-seekable operation " + dlrVar2);
                        }
                        dlrVar2.n();
                    } else {
                        if (beg.ar(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + dlrVar2);
                        }
                        dlrVar2.m(this.a);
                    }
                    this.d = false;
                    if (!dlrVar2.f) {
                        this.c.add(dlrVar2);
                    }
                }
                if (!this.b.isEmpty()) {
                    r();
                    ArrayList arrayListAb2 = StaticHelpers5.ab(this.b);
                    if (arrayListAb2.isEmpty()) {
                        return;
                    }
                    this.b.clear();
                    this.c.addAll(arrayListAb2);
                    if (beg.ar(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Executing pending operations");
                    }
                    j(arrayListAb2, this.e);
                    boolean zH = h(arrayListAb2);
                    Iterator it2 = arrayListAb2.iterator();
                    boolean z2 = true;
                    while (it2.hasNext()) {
                        if (!((dlr) it2.next()).c.be) {
                            z2 = false;
                        }
                    }
                    if (!z2 || zH) {
                        z = false;
                    }
                    this.d = z;
                    if (beg.ar(2)) {
                        Log.v("FragmentManager",
                                "SpecialEffectsController: Operation seekable = " + zH + " \ntransition = " + z2);
                    }
                    if (!z2) {
                        q(arrayListAb2);
                        k(arrayListAb2);
                    } else if (zH) {
                        q(arrayListAb2);
                        int size = arrayListAb2.size();
                        for (int i = 0; i < size; i++) {
                            i((dlr) arrayListAb2.get(i));
                        }
                    }
                    this.e = false;
                    if (beg.ar(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Finished executing pending operations");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final dlr n(SomeFragmentManager someFragmentManagerVar) {
        Object next;
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            next = it.next();
            dlr dlrVar = (dlr) next;
            if (nullSafeIsEqual(dlrVar.c, someFragmentManagerVar) && !dlrVar.e) {
                return (dlr) next;
            }
        }
        next = null;
        return (dlr) next;
    }

    public final dlr o(SomeFragmentManager someFragmentManagerVar) {
        Object next;
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            next = it.next();
            dlr dlrVar = (dlr) next;
            if (nullSafeIsEqual(dlrVar.c, someFragmentManagerVar) && !dlrVar.e) {
                return (dlr) next;
            }
        }
        next = null;
        return (dlr) next;
    }

    public final void p() {
        if (beg.ar(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Forcing all operations to complete");
        }
        boolean zIsAttachedToWindow = this.a.isAttachedToWindow();
        synchronized (this.b) {
            try {
                r();
                q(this.b);
                ArrayList<dlr> arrayListAb = StaticHelpers5.ab(this.c);
                Iterator it = arrayListAb.iterator();
                while (it.hasNext()) {
                    ((dlr) it.next()).g = false;
                }
                for (dlr dlrVar : arrayListAb) {
                    if (beg.ar(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: "
                                + (zIsAttachedToWindow ? "" : "Container " + this.a + " is not attached to window. ")
                                + "Cancelling running operation " + dlrVar);
                    }
                    dlrVar.m(this.a);
                }
                ArrayList<dlr> arrayListAb2 = StaticHelpers5.ab(this.b);
                Iterator it2 = arrayListAb2.iterator();
                while (it2.hasNext()) {
                    ((dlr) it2.next()).g = false;
                }
                for (dlr dlrVar2 : arrayListAb2) {
                    if (beg.ar(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: "
                                + (zIsAttachedToWindow ? "" : "Container " + this.a + " is not attached to window. ")
                                + "Cancelling pending operation " + dlrVar2);
                    }
                    dlrVar2.m(this.a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void q(List list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            dlr dlrVar = (dlr) list.get(i);
            FragmentManager fragmentManagerVar = dlrVar.l;
            if (!dlrVar.h) {
                dlrVar.h = true;
                int i2 = dlrVar.b;
                if (i2 == 2) {
                    SomeFragmentManager someFragmentManagerVar = fragmentManagerVar.c;
                    throwIfVar1IsNull(someFragmentManagerVar, "fragmentStateManager.fragment");
                    View viewFindFocus = someFragmentManagerVar.bz.findFocus();
                    if (viewFindFocus != null) {
                        someFragmentManagerVar.co().k = viewFindFocus;
                        if (beg.ar(2)) {
                            Log.v("FragmentManager",
                                    "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + someFragmentManagerVar);
                        }
                    }
                    View viewDd = dlrVar.c.dd();
                    if (viewDd.getParent() == null) {
                        if (beg.ar(2)) {
                            Log.v("FragmentManager",
                                    "Adding fragment " + someFragmentManagerVar + " view " + viewDd + " to container in onStart");
                        }
                        fragmentManagerVar.g();
                        viewDd.setAlpha(0.0f);
                    }
                    if (viewDd.getAlpha() == 0.0f && viewDd.getVisibility() == 0) {
                        if (beg.ar(2)) {
                            Log.v("FragmentManager", "Making view " + viewDd + " INVISIBLE in onStart");
                        }
                        viewDd.setVisibility(4);
                    }
                    bdg bdgVar = someFragmentManagerVar.cc;
                    viewDd.setAlpha(bdgVar == null ? 1.0f : bdgVar.j);
                    if (beg.ar(2)) {
                        StringBuilder sb = new StringBuilder("Setting view alpha to ");
                        bdg bdgVar2 = someFragmentManagerVar.cc;
                        sb.append(bdgVar2 != null ? bdgVar2.j : 1.0f);
                        sb.append(" in onStart");
                        Log.v("FragmentManager", sb.toString());
                    }
                } else if (i2 == 3) {
                    SomeFragmentManager someFragmentManagerVar2 = fragmentManagerVar.c;
                    throwIfVar1IsNull(someFragmentManagerVar2, "fragmentStateManager.fragment");
                    View viewDd2 = someFragmentManagerVar2.dd();
                    if (beg.ar(2)) {
                        Log.v("FragmentManager", "Clearing focus " + viewDd2.findFocus() + " on view " + viewDd2
                                + " for Fragment " + someFragmentManagerVar2);
                    }
                    viewDd2.clearFocus();
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            StaticHelpers2.an(arrayList, ((dlr) it.next()).k);
        }
        List listZ = StaticHelpers5.z(StaticHelpers5.ad(arrayList));
        int size2 = listZ.size();
        for (int i3 = 0; i3 < size2; i3++) {
            dlq dlqVar = (dlq) listZ.get(i3);
            dlqVar.getClass();
            ViewGroup viewGroup = this.a;
            throwIfVar1IsNull(viewGroup, "container");
            if (!dlqVar.g) {
                dlqVar.f(viewGroup);
            }
            dlqVar.g = true;
        }
    }

    public final void r() {
        for (dlr dlrVar : this.b) {
            int i = 2;
            if (dlrVar.b == 2) {
                int visibility = dlrVar.c.dd().getVisibility();
                if (visibility != 0) {
                    i = 4;
                    if (visibility != 4) {
                        if (visibility != 8) {
                            throw new IllegalArgumentException(concatVar2Var1(visibility, "Unknown visibility "));
                        }
                        i = 3;
                    }
                }
                dlrVar.p(i, 1);
            }
        }
    }
}
