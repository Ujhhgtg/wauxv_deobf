package me.hd.wauxv.obf;

import android.content.res.Resources;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.FragmentContainerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.WeakHashMap;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class FragmentManager {
    public final DefaultConfig a;
    public final chm b;
    public final SomeFragmentManager c;
    public boolean d = false;
    public int e = -1;

    public FragmentManager(DefaultConfig ioVar, chm chmVar, SomeFragmentManager someFragmentManagerVar) {
        this.a = ioVar;
        this.b = chmVar;
        this.c = someFragmentManagerVar;
    }

    public final void f() {
        boolean zAr = beg.ar(3);
        SomeFragmentManager someFragmentManagerVar = this.c;
        if (zAr) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + someFragmentManagerVar);
        }
        Bundle bundle = someFragmentManagerVar.at;
        if (bundle != null) {
            bundle.getBundle("savedInstanceState");
        }
        someFragmentManagerVar.bo.ck();
        someFragmentManagerVar.as = 3;
        someFragmentManagerVar.bx = false;
        someFragmentManagerVar.y();
        if (!someFragmentManagerVar.bx) {
            throw new doa(yg.l("Fragment ", someFragmentManagerVar, " did not call through to super.onActivityCreated()"));
        }
        if (beg.ar(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + someFragmentManagerVar);
        }
        if (someFragmentManagerVar.bz != null) {
            Bundle bundle2 = someFragmentManagerVar.at;
            Bundle bundle3 = bundle2 != null ? bundle2.getBundle("savedInstanceState") : null;
            SparseArray<Parcelable> sparseArray = someFragmentManagerVar.au;
            if (sparseArray != null) {
                someFragmentManagerVar.bz.restoreHierarchyState(sparseArray);
                someFragmentManagerVar.au = null;
            }
            someFragmentManagerVar.bx = false;
            someFragmentManagerVar.ad(bundle3);
            if (!someFragmentManagerVar.bx) {
                throw new doa(yg.l("Fragment ", someFragmentManagerVar, " did not call through to super.onViewStateRestored()"));
            }
            if (someFragmentManagerVar.bz != null) {
                someFragmentManagerVar.ci.f(LifeEventEnum.ON_CREATE);
            }
        }
        someFragmentManagerVar.at = null;
        beg begVar = someFragmentManagerVar.bo;
        begVar.ah = false;
        begVar.ai = false;
        begVar.ao.g = false;
        begVar.bq(4);
        this.a.q(someFragmentManagerVar, false);
    }

    public final void g() {
        SomeFragmentManager someFragmentManagerVar;
        View view;
        View view2;
        SomeFragmentManager someFragmentManagerVar2 = this.c;
        View view3 = someFragmentManagerVar2.by;
        while (true) {
            someFragmentManagerVar = null;
            if (view3 == null) {
                break;
            }
            Object tag = view3.getTag(R.id.fragment_container_view_tag);
            SomeFragmentManager someFragmentManagerVar3 = tag instanceof SomeFragmentManager ? (SomeFragmentManager) tag : null;
            if (someFragmentManagerVar3 != null) {
                someFragmentManagerVar = someFragmentManagerVar3;
                break;
            } else {
                Object parent = view3.getParent();
                view3 = parent instanceof View ? (View) parent : null;
            }
        }
        SomeFragmentManager someFragmentManagerVar4 = someFragmentManagerVar2.bp;
        if (someFragmentManagerVar != null && !someFragmentManagerVar.equals(someFragmentManagerVar4)) {
            int i = someFragmentManagerVar2.br;
            bfc bfcVar = bfd.a;
            StringBuilder sb = new StringBuilder("Attempting to nest fragment ");
            sb.append(someFragmentManagerVar2);
            sb.append(" within the view of parent fragment ");
            sb.append(someFragmentManagerVar);
            sb.append(" via container with ID ");
            bfd.c(new bex(someFragmentManagerVar2, yg.concatToVar1(sb, " without using parent's childFragmentManager", i)));
            bfd.b(someFragmentManagerVar2).getClass();
        }
        ArrayList arrayList = (ArrayList) this.b.c;
        ViewGroup viewGroup = someFragmentManagerVar2.by;
        int iIndexOfChild = -1;
        if (viewGroup != null) {
            int iIndexOf = arrayList.indexOf(someFragmentManagerVar2);
            for (int i2 = iIndexOf - 1; i2 >= 0; i2--) {
                SomeFragmentManager someFragmentManagerVar5 = (SomeFragmentManager) arrayList.get(i2);
                if (someFragmentManagerVar5.by == viewGroup && (view2 = someFragmentManagerVar5.bz) != null) {
                    iIndexOfChild = viewGroup.indexOfChild(view2) + 1;
                }
            }
            while (true) {
                iIndexOf++;
                if (iIndexOf >= arrayList.size()) {
                    break;
                }
                SomeFragmentManager someFragmentManagerVar6 = (SomeFragmentManager) arrayList.get(iIndexOf);
                if (someFragmentManagerVar6.by == viewGroup && (view = someFragmentManagerVar6.bz) != null) {
                    iIndexOfChild = viewGroup.indexOfChild(view);
                    break;
                }
            }
        }
        someFragmentManagerVar2.by.addView(someFragmentManagerVar2.bz, iIndexOfChild);
    }

    public final void h() {
        boolean zAr = beg.ar(3);
        SomeFragmentManager someFragmentManagerVar = this.c;
        if (zAr) {
            Log.d("FragmentManager", "moveto ATTACHED: " + someFragmentManagerVar);
        }
        SomeFragmentManager someFragmentManagerVar2 = someFragmentManagerVar.ay;
        FragmentManager fragmentManagerVar = null;
        chm chmVar = this.b;
        if (someFragmentManagerVar2 != null) {
            FragmentManager fragmentManagerVar2 = (FragmentManager) ((HashMap) chmVar.d).get(someFragmentManagerVar2.aw);
            if (fragmentManagerVar2 == null) {
                throw new IllegalStateException("Fragment " + someFragmentManagerVar + " declared target fragment " + someFragmentManagerVar.ay
                        + " that does not belong to this FragmentManager!");
            }
            someFragmentManagerVar.az = someFragmentManagerVar.ay.aw;
            someFragmentManagerVar.ay = null;
            fragmentManagerVar = fragmentManagerVar2;
        } else {
            String str = someFragmentManagerVar.az;
            if (str != null && (fragmentManagerVar = (FragmentManager) ((HashMap) chmVar.d).get(str)) == null) {
                StringBuilder sb = new StringBuilder("Fragment ");
                sb.append(someFragmentManagerVar);
                sb.append(" declared target fragment ");
                throw new IllegalStateException(yg.concatToVar1(sb, someFragmentManagerVar.az, " that does not belong to this FragmentManager!"));
            }
        }
        if (fragmentManagerVar != null) {
            fragmentManagerVar.p();
        }
        beg begVar = someFragmentManagerVar.bm;
        someFragmentManagerVar.bn = begVar.w;
        someFragmentManagerVar.bp = begVar.y;
        DefaultConfig ioVar = this.a;
        ioVar.y(someFragmentManagerVar, false);
        ArrayList arrayList = someFragmentManagerVar.cm;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((bdh) it.next()).b();
        }
        arrayList.clear();
        someFragmentManagerVar.bo.ax(someFragmentManagerVar.bn, someFragmentManagerVar.x(), someFragmentManagerVar);
        someFragmentManagerVar.as = 0;
        someFragmentManagerVar.bx = false;
        someFragmentManagerVar.e(someFragmentManagerVar.bn.e);
        if (!someFragmentManagerVar.bx) {
            throw new doa(yg.l("Fragment ", someFragmentManagerVar, " did not call through to super.onAttach()"));
        }
        beg begVar2 = someFragmentManagerVar.bm;
        Iterator it2 = begVar2.p.iterator();
        while (it2.hasNext()) {
            ((beu) it2.next()).b(begVar2, someFragmentManagerVar);
        }
        beg begVar3 = someFragmentManagerVar.bo;
        begVar3.ah = false;
        begVar3.ai = false;
        begVar3.ao.g = false;
        begVar3.bq(0);
        ioVar.r(someFragmentManagerVar, false);
    }

    public final int i() {
        SomeFragmentManager someFragmentManagerVar = this.c;
        if (someFragmentManagerVar.bm == null) {
            return someFragmentManagerVar.as;
        }
        int iMin = this.e;
        int iOrdinal = someFragmentManagerVar.cg.ordinal();
        if (iOrdinal == 1) {
            iMin = Math.min(iMin, 0);
        } else if (iOrdinal == 2) {
            iMin = Math.min(iMin, 1);
        } else if (iOrdinal == 3) {
            iMin = Math.min(iMin, 5);
        } else if (iOrdinal != 4) {
            iMin = Math.min(iMin, -1);
        }
        if (someFragmentManagerVar.bg) {
            if (someFragmentManagerVar.bh) {
                iMin = Math.max(this.e, 2);
                View view = someFragmentManagerVar.bz;
                if (view != null && view.getParent() == null) {
                    iMin = Math.min(iMin, 2);
                }
            } else {
                iMin = this.e < 4 ? Math.min(iMin, someFragmentManagerVar.as) : Math.min(iMin, 1);
            }
        }
        if (someFragmentManagerVar.bi && someFragmentManagerVar.by == null) {
            iMin = Math.min(iMin, 4);
        }
        if (!someFragmentManagerVar.bc) {
            iMin = Math.min(iMin, 1);
        }
        ViewGroup viewGroup = someFragmentManagerVar.by;
        if (viewGroup != null) {
            aln alnVarG = aln.g(viewGroup, someFragmentManagerVar.cs());
            dlr dlrVarN = alnVarG.n(someFragmentManagerVar);
            int i = dlrVarN != null ? dlrVarN.b : 0;
            dlr dlrVarO = alnVarG.o(someFragmentManagerVar);
            i = dlrVarO != null ? dlrVarO.b : 0;
            int i2 = i == 0 ? -1 : dls.a[StaticHelpers6.ae(i)];
            if (i2 != -1 && i2 != 1) {
                i = i;
            }
        }
        if (i == 2) {
            iMin = Math.min(iMin, 6);
        } else if (i == 3) {
            iMin = Math.max(iMin, 3);
        } else if (someFragmentManagerVar.bd) {
            iMin = someFragmentManagerVar.cx() ? Math.min(iMin, 1) : Math.min(iMin, -1);
        }
        if (someFragmentManagerVar.ca && someFragmentManagerVar.as < 5) {
            iMin = Math.min(iMin, 4);
        }
        if (someFragmentManagerVar.be) {
            iMin = Math.max(iMin, 3);
        }
        if (beg.ar(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + iMin + " for " + someFragmentManagerVar);
        }
        return iMin;
    }

    public final void j() {
        Bundle bundle;
        boolean zAr = beg.ar(3);
        SomeFragmentManager someFragmentManagerVar = this.c;
        if (zAr) {
            Log.d("FragmentManager", "moveto CREATED: " + someFragmentManagerVar);
        }
        Bundle bundle2 = someFragmentManagerVar.at;
        Bundle bundle3 = bundle2 != null ? bundle2.getBundle("savedInstanceState") : null;
        if (someFragmentManagerVar.ce) {
            someFragmentManagerVar.as = 1;
            Bundle bundle4 = someFragmentManagerVar.at;
            if (bundle4 == null || (bundle = bundle4.getBundle("childFragmentManager")) == null) {
                return;
            }
            someFragmentManagerVar.bo.cq(bundle);
            beg begVar = someFragmentManagerVar.bo;
            begVar.ah = false;
            begVar.ai = false;
            begVar.ao.g = false;
            begVar.bq(1);
            return;
        }
        DefaultConfig ioVar = this.a;
        ioVar.z(someFragmentManagerVar, false);
        someFragmentManagerVar.bo.ck();
        someFragmentManagerVar.as = 1;
        someFragmentManagerVar.bx = false;
        someFragmentManagerVar.ch.j(new cyo(someFragmentManagerVar, 5));
        someFragmentManagerVar.f(bundle3);
        someFragmentManagerVar.ce = true;
        if (!someFragmentManagerVar.bx) {
            throw new doa(yg.l("Fragment ", someFragmentManagerVar, " did not call through to super.onCreate()"));
        }
        someFragmentManagerVar.ch.m(LifeEventEnum.ON_CREATE);
        ioVar.t(someFragmentManagerVar, false);
    }

    public final void k() {
        String resourceName;
        SomeFragmentManager someFragmentManagerVar = this.c;
        if (someFragmentManagerVar.bg) {
            return;
        }
        if (beg.ar(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + someFragmentManagerVar);
        }
        Bundle bundle = someFragmentManagerVar.at;
        ViewGroup viewGroup = null;
        Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
        LayoutInflater layoutInflaterAa = someFragmentManagerVar.aa(bundle2);
        ViewGroup viewGroup2 = someFragmentManagerVar.by;
        if (viewGroup2 != null) {
            viewGroup = viewGroup2;
        } else {
            int i = someFragmentManagerVar.br;
            if (i != 0) {
                if (i == -1) {
                    throw new IllegalArgumentException(
                            yg.l("Cannot create fragment ", someFragmentManagerVar, " for a container view with no id"));
                }
                viewGroup = (ViewGroup) someFragmentManagerVar.bm.x.c(i);
                if (viewGroup == null) {
                    if (!someFragmentManagerVar.bj && !someFragmentManagerVar.bi) {
                        try {
                            resourceName = someFragmentManagerVar.dc().getResources().getResourceName(someFragmentManagerVar.br);
                        } catch (Resources.NotFoundException unused) {
                            resourceName = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(someFragmentManagerVar.br)
                                + " (" + resourceName + ") for fragment " + someFragmentManagerVar);
                    }
                } else if (!(viewGroup instanceof FragmentContainerView)) {
                    bfc bfcVar = bfd.a;
                    bfd.c(new bex(someFragmentManagerVar, "Attempting to add fragment " + someFragmentManagerVar + " to container " + viewGroup
                            + " which is not a FragmentContainerView"));
                    bfd.b(someFragmentManagerVar).getClass();
                }
            }
        }
        someFragmentManagerVar.by = viewGroup;
        someFragmentManagerVar.ae(layoutInflaterAa, viewGroup, bundle2);
        int i2 = 2;
        if (someFragmentManagerVar.bz != null) {
            if (beg.ar(3)) {
                Log.d("FragmentManager", "moveto VIEW_CREATED: " + someFragmentManagerVar);
            }
            someFragmentManagerVar.bz.setSaveFromParentEnabled(false);
            someFragmentManagerVar.bz.setTag(R.id.fragment_container_view_tag, someFragmentManagerVar);
            if (viewGroup != null) {
                g();
            }
            if (someFragmentManagerVar.bt) {
                someFragmentManagerVar.bz.setVisibility(8);
            }
            if (someFragmentManagerVar.bz.isAttachedToWindow()) {
                View view = someFragmentManagerVar.bz;
                WeakHashMap weakHashMap = ViewCompat.a;
                eqo.c(view);
            } else {
                View view2 = someFragmentManagerVar.bz;
                view2.addOnAttachStateChangeListener(new tj(view2, i2));
            }
            Bundle bundle3 = someFragmentManagerVar.at;
            if (bundle3 != null) {
                bundle3.getBundle("savedInstanceState");
            }
            someFragmentManagerVar.k(someFragmentManagerVar.bz);
            someFragmentManagerVar.bo.bq(2);
            this.a.ae(someFragmentManagerVar, someFragmentManagerVar.bz, false);
            int visibility = someFragmentManagerVar.bz.getVisibility();
            someFragmentManagerVar.co().j = someFragmentManagerVar.bz.getAlpha();
            if (someFragmentManagerVar.by != null && visibility == 0) {
                View viewFindFocus = someFragmentManagerVar.bz.findFocus();
                if (viewFindFocus != null) {
                    someFragmentManagerVar.co().k = viewFindFocus;
                    if (beg.ar(2)) {
                        Log.v("FragmentManager",
                                "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + someFragmentManagerVar);
                    }
                }
                someFragmentManagerVar.bz.setAlpha(0.0f);
            }
        }
        someFragmentManagerVar.as = 2;
    }

    public final void l() {
        boolean z;
        SomeFragmentManager someFragmentManagerVarZ;
        boolean zAr = beg.ar(3);
        SomeFragmentManager someFragmentManagerVar = this.c;
        if (zAr) {
            Log.d("FragmentManager", "movefrom CREATED: " + someFragmentManagerVar);
        }
        boolean z2 = someFragmentManagerVar.bd && !someFragmentManagerVar.cx();
        chm chmVar = this.b;
        if (z2 && !someFragmentManagerVar.bf) {
            chmVar.as(someFragmentManagerVar.aw, null);
        }
        if (!z2) {
            bej bejVar = (bej) chmVar.f;
            if (!((bejVar.b.containsKey(someFragmentManagerVar.aw) && bejVar.e) ? bejVar.f : true)) {
                String str = someFragmentManagerVar.az;
                if (str != null && (someFragmentManagerVarZ = chmVar.z(str)) != null && someFragmentManagerVarZ.bv) {
                    someFragmentManagerVar.ay = someFragmentManagerVarZ;
                }
                someFragmentManagerVar.as = 0;
                return;
            }
        }
        bdm bdmVar = someFragmentManagerVar.bn;
        if (bdmVar != null) {
            z = ((bej) chmVar.f).f;
        } else {
            z = bdmVar.e != null ? !r6.isChangingConfigurations() : true;
        }
        if ((z2 && !someFragmentManagerVar.bf) || z) {
            ((bej) chmVar.f).j(someFragmentManagerVar, false);
        }
        someFragmentManagerVar.bo.bh();
        someFragmentManagerVar.ch.m(LifeEventEnum.ON_DESTROY);
        someFragmentManagerVar.as = 0;
        someFragmentManagerVar.ce = false;
        someFragmentManagerVar.bx = true;
        this.a.u(someFragmentManagerVar, false);
        for (FragmentManager fragmentManagerVar : chmVar.ac()) {
            if (fragmentManagerVar != null) {
                SomeFragmentManager someFragmentManagerVar2 = fragmentManagerVar.c;
                if (someFragmentManagerVar.aw.equals(someFragmentManagerVar2.az)) {
                    someFragmentManagerVar2.ay = someFragmentManagerVar;
                    someFragmentManagerVar2.az = null;
                }
            }
        }
        String str2 = someFragmentManagerVar.az;
        if (str2 != null) {
            someFragmentManagerVar.ay = chmVar.z(str2);
        }
        chmVar.ak(this);
    }

    public final void m() {
        View view;
        SomeFragmentManager someFragmentManagerVar = this.c;
        if (beg.ar(3)) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + someFragmentManagerVar);
        }
        ViewGroup viewGroup = someFragmentManagerVar.by;
        if (viewGroup != null && (view = someFragmentManagerVar.bz) != null) {
            viewGroup.removeView(view);
        }
        someFragmentManagerVar.bo.bq(1);
        if (someFragmentManagerVar.bz != null) {
            bfg bfgVar = someFragmentManagerVar.ci;
            bfgVar.g();
            if (bfgVar.d.c.compareTo(buh.c) >= 0) {
                someFragmentManagerVar.ci.f(LifeEventEnum.ON_DESTROY);
            }
        }
        someFragmentManagerVar.as = 1;
        someFragmentManagerVar.bx = false;
        someFragmentManagerVar.h();
        if (!someFragmentManagerVar.bx) {
            throw new doa(yg.l("Fragment ", someFragmentManagerVar, " did not call through to super.onDestroyView()"));
        }
        erq erqVarAj = someFragmentManagerVar.aj();
        bei beiVar = bwv.a;
        throwIfVar1IsNull(erqVarAj, "store");
        ahv ahvVar = ahv.a;
        throwIfVar1IsNull(ahvVar, "defaultCreationExtras");
        chm chmVar = new chm(erqVarAj, beiVar, ahvVar);
        zc zcVarB = dal.b(bwv.class);
        String strAo = emc.ao(zcVarB);
        if (strAo == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        dlo dloVar = ((bwv) chmVar.ah("androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strAo), zcVarB)).b;
        if (dloVar.i() > 0) {
            dloVar.j(0).getClass();
            throw new ClassCastException();
        }
        someFragmentManagerVar.bk = false;
        this.a.af(someFragmentManagerVar, false);
        someFragmentManagerVar.by = null;
        someFragmentManagerVar.bz = null;
        someFragmentManagerVar.ci = null;
        chv chvVar = someFragmentManagerVar.cj;
        chvVar.getClass();
        chv.k("setValue");
        chvVar.h++;
        chvVar.f = null;
        chvVar.m(null);
        someFragmentManagerVar.bh = false;
    }

    public final void n() {
        boolean zAr = beg.ar(3);
        SomeFragmentManager someFragmentManagerVar = this.c;
        if (zAr) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + someFragmentManagerVar);
        }
        someFragmentManagerVar.as = -1;
        someFragmentManagerVar.bx = false;
        someFragmentManagerVar.z();
        if (!someFragmentManagerVar.bx) {
            throw new doa(yg.l("Fragment ", someFragmentManagerVar, " did not call through to super.onDetach()"));
        }
        beg begVar = someFragmentManagerVar.bo;
        if (!begVar.aj) {
            begVar.bh();
            someFragmentManagerVar.bo = new beg();
        }
        this.a.v(someFragmentManagerVar, false);
        someFragmentManagerVar.as = -1;
        someFragmentManagerVar.bn = null;
        someFragmentManagerVar.bp = null;
        someFragmentManagerVar.bm = null;
        if (!someFragmentManagerVar.bd || someFragmentManagerVar.cx()) {
            bej bejVar = (bej) this.b.f;
            if (!((bejVar.b.containsKey(someFragmentManagerVar.aw) && bejVar.e) ? bejVar.f : true)) {
                return;
            }
        }
        if (beg.ar(3)) {
            Log.d("FragmentManager", "initState called for fragment: " + someFragmentManagerVar);
        }
        someFragmentManagerVar.cu();
    }

    public final void o() {
        SomeFragmentManager someFragmentManagerVar = this.c;
        if (someFragmentManagerVar.bg && someFragmentManagerVar.bh && !someFragmentManagerVar.bk) {
            if (beg.ar(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + someFragmentManagerVar);
            }
            Bundle bundle = someFragmentManagerVar.at;
            Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
            someFragmentManagerVar.ae(someFragmentManagerVar.aa(bundle2), null, bundle2);
            View view = someFragmentManagerVar.bz;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                someFragmentManagerVar.bz.setTag(R.id.fragment_container_view_tag, someFragmentManagerVar);
                if (someFragmentManagerVar.bt) {
                    someFragmentManagerVar.bz.setVisibility(8);
                }
                Bundle bundle3 = someFragmentManagerVar.at;
                if (bundle3 != null) {
                    bundle3.getBundle("savedInstanceState");
                }
                someFragmentManagerVar.k(someFragmentManagerVar.bz);
                someFragmentManagerVar.bo.bq(2);
                this.a.ae(someFragmentManagerVar, someFragmentManagerVar.bz, false);
                someFragmentManagerVar.as = 2;
            }
        }
    }

    public final void p() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        boolean z = this.d;
        SomeFragmentManager someFragmentManagerVar = this.c;
        if (z) {
            if (beg.ar(2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + someFragmentManagerVar);
                return;
            }
            return;
        }
        try {
            this.d = true;
            boolean z2 = false;
            while (true) {
                int i = i();
                int i2 = someFragmentManagerVar.as;
                int i3 = 3;
                chm chmVar = this.b;
                if (i == i2) {
                    if (!z2 && i2 == -1 && someFragmentManagerVar.bd && !someFragmentManagerVar.cx() && !someFragmentManagerVar.bf) {
                        if (beg.ar(3)) {
                            Log.d("FragmentManager", "Cleaning up state of never attached fragment: " + someFragmentManagerVar);
                        }
                        ((bej) chmVar.f).j(someFragmentManagerVar, true);
                        chmVar.ak(this);
                        if (beg.ar(3)) {
                            Log.d("FragmentManager", "initState called for fragment: " + someFragmentManagerVar);
                        }
                        someFragmentManagerVar.cu();
                    }
                    if (someFragmentManagerVar.cd) {
                        if (someFragmentManagerVar.bz != null && (viewGroup = someFragmentManagerVar.by) != null) {
                            aln alnVarG = aln.g(viewGroup, someFragmentManagerVar.cs());
                            if (someFragmentManagerVar.bt) {
                                if (beg.ar(2)) {
                                    Log.v("FragmentManager",
                                            "SpecialEffectsController: Enqueuing hide operation for fragment "
                                                    + someFragmentManagerVar);
                                }
                                alnVarG.l(3, 1, this);
                            } else {
                                if (beg.ar(2)) {
                                    Log.v("FragmentManager",
                                            "SpecialEffectsController: Enqueuing show operation for fragment "
                                                    + someFragmentManagerVar);
                                }
                                alnVarG.l(2, 1, this);
                            }
                        }
                        beg begVar = someFragmentManagerVar.bm;
                        if (begVar != null && someFragmentManagerVar.bc && beg.as(someFragmentManagerVar)) {
                            begVar.ag = true;
                        }
                        someFragmentManagerVar.cd = false;
                        someFragmentManagerVar.bo.bk();
                    }
                    this.d = false;
                    return;
                }
                if (i <= i2) {
                    switch (i2 - 1) {
                        case -1:
                            n();
                            break;
                        case 0:
                            if (someFragmentManagerVar.bf) {
                                if (((Bundle) ((HashMap) chmVar.e).get(someFragmentManagerVar.aw)) == null) {
                                    chmVar.as(someFragmentManagerVar.aw, t());
                                }
                            }
                            l();
                            break;
                        case 1:
                            m();
                            someFragmentManagerVar.as = 1;
                            break;
                        case 2:
                            someFragmentManagerVar.bh = false;
                            someFragmentManagerVar.as = 2;
                            break;
                        case 3:
                            if (beg.ar(3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + someFragmentManagerVar);
                            }
                            if (someFragmentManagerVar.bf) {
                                chmVar.as(someFragmentManagerVar.aw, t());
                            } else if (someFragmentManagerVar.bz != null && someFragmentManagerVar.au == null) {
                                u();
                            }
                            if (someFragmentManagerVar.bz != null && (viewGroup2 = someFragmentManagerVar.by) != null) {
                                aln alnVarG2 = aln.g(viewGroup2, someFragmentManagerVar.cs());
                                if (beg.ar(2)) {
                                    Log.v("FragmentManager",
                                            "SpecialEffectsController: Enqueuing remove operation for fragment "
                                                    + someFragmentManagerVar);
                                }
                                alnVarG2.l(1, 3, this);
                            }
                            someFragmentManagerVar.as = 3;
                            break;
                        case 4:
                            w();
                            break;
                        case 5:
                            someFragmentManagerVar.as = 5;
                            break;
                        case 6:
                            q();
                            break;
                    }
                } else {
                    switch (i2 + 1) {
                        case 0:
                            h();
                            break;
                        case 1:
                            j();
                            break;
                        case 2:
                            o();
                            k();
                            break;
                        case 3:
                            f();
                            break;
                        case 4:
                            if (someFragmentManagerVar.bz != null && (viewGroup3 = someFragmentManagerVar.by) != null) {
                                aln alnVarG3 = aln.g(viewGroup3, someFragmentManagerVar.cs());
                                int visibility = someFragmentManagerVar.bz.getVisibility();
                                if (visibility == 0) {
                                    i3 = 2;
                                } else if (visibility == 4) {
                                    i3 = 4;
                                } else if (visibility != 8) {
                                    throw new IllegalArgumentException("Unknown visibility " + visibility);
                                }
                                bjs.t(i3, "finalState");
                                if (beg.ar(2)) {
                                    Log.v("FragmentManager",
                                            "SpecialEffectsController: Enqueuing add operation for fragment " + someFragmentManagerVar);
                                }
                                alnVarG3.l(i3, 2, this);
                            }
                            someFragmentManagerVar.as = 4;
                            break;
                        case 5:
                            v();
                            break;
                        case 6:
                            someFragmentManagerVar.as = 6;
                            break;
                        case 7:
                            s();
                            break;
                    }
                }
                z2 = true;
            }
        } catch (Throwable th) {
            this.d = false;
            throw th;
        }
    }

    public final void q() {
        boolean zAr = beg.ar(3);
        SomeFragmentManager someFragmentManagerVar = this.c;
        if (zAr) {
            Log.d("FragmentManager", "movefrom RESUMED: " + someFragmentManagerVar);
        }
        someFragmentManagerVar.bo.bq(5);
        if (someFragmentManagerVar.bz != null) {
            someFragmentManagerVar.ci.f(LifeEventEnum.ON_PAUSE);
        }
        someFragmentManagerVar.ch.m(LifeEventEnum.ON_PAUSE);
        someFragmentManagerVar.as = 6;
        someFragmentManagerVar.bx = true;
        this.a.w(someFragmentManagerVar, false);
    }

    public final void r(ClassLoader classLoader) {
        SomeFragmentManager someFragmentManagerVar = this.c;
        Bundle bundle = someFragmentManagerVar.at;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        if (someFragmentManagerVar.at.getBundle("savedInstanceState") == null) {
            someFragmentManagerVar.at.putBundle("savedInstanceState", new Bundle());
        }
        try {
            someFragmentManagerVar.au = someFragmentManagerVar.at.getSparseParcelableArray("viewState");
            someFragmentManagerVar.av = someFragmentManagerVar.at.getBundle("viewRegistryState");
            bey beyVar = (bey) someFragmentManagerVar.at.getParcelable("state");
            if (beyVar != null) {
                someFragmentManagerVar.az = beyVar.m;
                someFragmentManagerVar.ba = beyVar.n;
                someFragmentManagerVar.cb = beyVar.o;
            }
            if (someFragmentManagerVar.cb) {
                return;
            }
            someFragmentManagerVar.ca = true;
        } catch (BadParcelableException e) {
            throw new IllegalStateException("Failed to restore view hierarchy state for fragment " + someFragmentManagerVar, e);
        }
    }

    /* JADX WARN: Found duplicated region for block: B:19:0x0041 */
    /* JADX WARN: Found duplicated region for block: B:21:0x0052 */
    /* JADX WARN: Found duplicated region for block: B:22:0x0055 */
    public final void s() {
        boolean zRequestFocus;
        boolean zAr = beg.ar(3);
        SomeFragmentManager someFragmentManagerVar = this.c;
        if (zAr) {
            Log.d("FragmentManager", "moveto RESUMED: " + someFragmentManagerVar);
        }
        bdg bdgVar = someFragmentManagerVar.cc;
        View view = bdgVar == null ? null : bdgVar.k;
        if (view != null) {
            if (view == someFragmentManagerVar.bz) {
                zRequestFocus = view.requestFocus();
                if (beg.ar(2)) {
                    StringBuilder sb = new StringBuilder("requestFocus: Restoring focused view ");
                    sb.append(view);
                    sb.append(" ");
                    sb.append(zRequestFocus ? "succeeded" : "failed");
                    sb.append(" on Fragment ");
                    sb.append(someFragmentManagerVar);
                    sb.append(" resulting in focused view ");
                    sb.append(someFragmentManagerVar.bz.findFocus());
                    Log.v("FragmentManager", sb.toString());
                }
            } else {
                ViewParent parent = view.getParent();
                while (true) {
                    if (parent != null) {
                        if (parent == someFragmentManagerVar.bz) {
                            zRequestFocus = view.requestFocus();
                            if (beg.ar(2)) {
                                StringBuilder sb2 = new StringBuilder("requestFocus: Restoring focused view ");
                                sb2.append(view);
                                sb2.append(" ");
                                sb2.append(zRequestFocus ? "succeeded" : "failed");
                                sb2.append(" on Fragment ");
                                sb2.append(someFragmentManagerVar);
                                sb2.append(" resulting in focused view ");
                                sb2.append(someFragmentManagerVar.bz.findFocus());
                                Log.v("FragmentManager", sb2.toString());
                            }
                        } else {
                            parent = parent.getParent();
                        }
                    }
                }
            }
        }
        someFragmentManagerVar.co().k = null;
        someFragmentManagerVar.bo.ck();
        someFragmentManagerVar.bo.bw(true);
        someFragmentManagerVar.as = 7;
        someFragmentManagerVar.bx = false;
        someFragmentManagerVar.cz();
        if (!someFragmentManagerVar.bx) {
            throw new doa(yg.l("Fragment ", someFragmentManagerVar, " did not call through to super.onResume()"));
        }
        bur burVar = someFragmentManagerVar.ch;
        LifeEventEnum lifeEventEnumVar = LifeEventEnum.ON_RESUME;
        burVar.m(lifeEventEnumVar);
        if (someFragmentManagerVar.bz != null) {
            someFragmentManagerVar.ci.d.m(lifeEventEnumVar);
        }
        beg begVar = someFragmentManagerVar.bo;
        begVar.ah = false;
        begVar.ai = false;
        begVar.ao.g = false;
        begVar.bq(7);
        this.a.aa(someFragmentManagerVar, false);
        this.b.as(someFragmentManagerVar.aw, null);
        someFragmentManagerVar.at = null;
        someFragmentManagerVar.au = null;
        someFragmentManagerVar.av = null;
    }

    public final Bundle t() {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        SomeFragmentManager someFragmentManagerVar = this.c;
        if (someFragmentManagerVar.as == -1 && (bundle = someFragmentManagerVar.at) != null) {
            bundle2.putAll(bundle);
        }
        bundle2.putParcelable("state", new bey(someFragmentManagerVar));
        if (someFragmentManagerVar.as > -1) {
            Bundle bundle3 = new Bundle();
            someFragmentManagerVar.j(bundle3);
            if (!bundle3.isEmpty()) {
                bundle2.putBundle("savedInstanceState", bundle3);
            }
            this.a.ab(someFragmentManagerVar, bundle3, false);
            Bundle bundle4 = new Bundle();
            someFragmentManagerVar.ck.ab(bundle4);
            if (!bundle4.isEmpty()) {
                bundle2.putBundle("registryState", bundle4);
            }
            Bundle bundleCr = someFragmentManagerVar.bo.cr();
            if (!bundleCr.isEmpty()) {
                bundle2.putBundle("childFragmentManager", bundleCr);
            }
            if (someFragmentManagerVar.bz != null) {
                u();
            }
            SparseArray<? extends Parcelable> sparseArray = someFragmentManagerVar.au;
            if (sparseArray != null) {
                bundle2.putSparseParcelableArray("viewState", sparseArray);
            }
            Bundle bundle5 = someFragmentManagerVar.av;
            if (bundle5 != null) {
                bundle2.putBundle("viewRegistryState", bundle5);
            }
        }
        Bundle bundle6 = someFragmentManagerVar.ax;
        if (bundle6 != null) {
            bundle2.putBundle("arguments", bundle6);
        }
        return bundle2;
    }

    public final void u() {
        SomeFragmentManager someFragmentManagerVar = this.c;
        if (someFragmentManagerVar.bz == null) {
            return;
        }
        if (beg.ar(2)) {
            Log.v("FragmentManager", "Saving view state for fragment " + someFragmentManagerVar + " with view " + someFragmentManagerVar.bz);
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        someFragmentManagerVar.bz.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            someFragmentManagerVar.au = sparseArray;
        }
        Bundle bundle = new Bundle();
        someFragmentManagerVar.ci.e.ab(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        someFragmentManagerVar.av = bundle;
    }

    public final void v() {
        boolean zAr = beg.ar(3);
        SomeFragmentManager someFragmentManagerVar = this.c;
        if (zAr) {
            Log.d("FragmentManager", "moveto STARTED: " + someFragmentManagerVar);
        }
        someFragmentManagerVar.bo.ck();
        someFragmentManagerVar.bo.bw(true);
        someFragmentManagerVar.as = 5;
        someFragmentManagerVar.bx = false;
        someFragmentManagerVar.ab();
        if (!someFragmentManagerVar.bx) {
            throw new doa(yg.l("Fragment ", someFragmentManagerVar, " did not call through to super.onStart()"));
        }
        bur burVar = someFragmentManagerVar.ch;
        LifeEventEnum lifeEventEnumVar = LifeEventEnum.ON_START;
        burVar.m(lifeEventEnumVar);
        if (someFragmentManagerVar.bz != null) {
            someFragmentManagerVar.ci.d.m(lifeEventEnumVar);
        }
        beg begVar = someFragmentManagerVar.bo;
        begVar.ah = false;
        begVar.ai = false;
        begVar.ao.g = false;
        begVar.bq(5);
        this.a.ac(someFragmentManagerVar, false);
    }

    public final void w() {
        boolean zAr = beg.ar(3);
        SomeFragmentManager someFragmentManagerVar = this.c;
        if (zAr) {
            Log.d("FragmentManager", "movefrom STARTED: " + someFragmentManagerVar);
        }
        beg begVar = someFragmentManagerVar.bo;
        begVar.ai = true;
        begVar.ao.g = true;
        begVar.bq(4);
        if (someFragmentManagerVar.bz != null) {
            someFragmentManagerVar.ci.f(LifeEventEnum.ON_STOP);
        }
        someFragmentManagerVar.ch.m(LifeEventEnum.ON_STOP);
        someFragmentManagerVar.as = 4;
        someFragmentManagerVar.bx = false;
        someFragmentManagerVar.ac();
        if (!someFragmentManagerVar.bx) {
            throw new doa(yg.l("Fragment ", someFragmentManagerVar, " did not call through to super.onStop()"));
        }
        this.a.ad(someFragmentManagerVar, false);
    }

    public FragmentManager(DefaultConfig ioVar, chm chmVar, ClassLoader classLoader, bdz bdzVar, Bundle bundle) {
        this.a = ioVar;
        this.b = chmVar;
        SomeFragmentManager someFragmentManagerVarP = ((bey) bundle.getParcelable("state")).p(bdzVar);
        this.c = someFragmentManagerVarP;
        someFragmentManagerVarP.at = bundle;
        Bundle bundle2 = bundle.getBundle("arguments");
        if (bundle2 != null) {
            bundle2.setClassLoader(classLoader);
        }
        someFragmentManagerVarP.df(bundle2);
        if (beg.ar(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + someFragmentManagerVarP);
        }
    }

    public FragmentManager(DefaultConfig ioVar, chm chmVar, SomeFragmentManager someFragmentManagerVar, Bundle bundle) {
        this.a = ioVar;
        this.b = chmVar;
        this.c = someFragmentManagerVar;
        someFragmentManagerVar.au = null;
        someFragmentManagerVar.av = null;
        someFragmentManagerVar.bl = 0;
        someFragmentManagerVar.bh = false;
        someFragmentManagerVar.bc = false;
        SomeFragmentManager someFragmentManagerVar2 = someFragmentManagerVar.ay;
        someFragmentManagerVar.az = someFragmentManagerVar2 != null ? someFragmentManagerVar2.aw : null;
        someFragmentManagerVar.ay = null;
        someFragmentManagerVar.at = bundle;
        someFragmentManagerVar.ax = bundle.getBundle("arguments");
    }
}
