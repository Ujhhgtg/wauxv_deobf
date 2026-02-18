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
public final class bfb {
    public final io a;
    public final chm b;
    public final bdj c;
    public boolean d = false;
    public int e = -1;

    public bfb(io ioVar, chm chmVar, bdj bdjVar) {
        this.a = ioVar;
        this.b = chmVar;
        this.c = bdjVar;
    }

    public final void f() {
        boolean zAr = beg.ar(3);
        bdj bdjVar = this.c;
        if (zAr) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + bdjVar);
        }
        Bundle bundle = bdjVar.at;
        if (bundle != null) {
            bundle.getBundle("savedInstanceState");
        }
        bdjVar.bo.ck();
        bdjVar.as = 3;
        bdjVar.bx = false;
        bdjVar.y();
        if (!bdjVar.bx) {
            throw new doa(yg.l("Fragment ", bdjVar, " did not call through to super.onActivityCreated()"));
        }
        if (beg.ar(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + bdjVar);
        }
        if (bdjVar.bz != null) {
            Bundle bundle2 = bdjVar.at;
            Bundle bundle3 = bundle2 != null ? bundle2.getBundle("savedInstanceState") : null;
            SparseArray<Parcelable> sparseArray = bdjVar.au;
            if (sparseArray != null) {
                bdjVar.bz.restoreHierarchyState(sparseArray);
                bdjVar.au = null;
            }
            bdjVar.bx = false;
            bdjVar.ad(bundle3);
            if (!bdjVar.bx) {
                throw new doa(yg.l("Fragment ", bdjVar, " did not call through to super.onViewStateRestored()"));
            }
            if (bdjVar.bz != null) {
                bdjVar.ci.f(bug.ON_CREATE);
            }
        }
        bdjVar.at = null;
        beg begVar = bdjVar.bo;
        begVar.ah = false;
        begVar.ai = false;
        begVar.ao.g = false;
        begVar.bq(4);
        this.a.q(bdjVar, false);
    }

    public final void g() {
        bdj bdjVar;
        View view;
        View view2;
        bdj bdjVar2 = this.c;
        View view3 = bdjVar2.by;
        while (true) {
            bdjVar = null;
            if (view3 == null) {
                break;
            }
            Object tag = view3.getTag(R.id.fragment_container_view_tag);
            bdj bdjVar3 = tag instanceof bdj ? (bdj) tag : null;
            if (bdjVar3 != null) {
                bdjVar = bdjVar3;
                break;
            } else {
                Object parent = view3.getParent();
                view3 = parent instanceof View ? (View) parent : null;
            }
        }
        bdj bdjVar4 = bdjVar2.bp;
        if (bdjVar != null && !bdjVar.equals(bdjVar4)) {
            int i = bdjVar2.br;
            bfc bfcVar = bfd.a;
            StringBuilder sb = new StringBuilder("Attempting to nest fragment ");
            sb.append(bdjVar2);
            sb.append(" within the view of parent fragment ");
            sb.append(bdjVar);
            sb.append(" via container with ID ");
            bfd.c(new bex(bdjVar2, yg.m(sb, " without using parent's childFragmentManager", i)));
            bfd.b(bdjVar2).getClass();
        }
        ArrayList arrayList = (ArrayList) this.b.c;
        ViewGroup viewGroup = bdjVar2.by;
        int iIndexOfChild = -1;
        if (viewGroup != null) {
            int iIndexOf = arrayList.indexOf(bdjVar2);
            for (int i2 = iIndexOf - 1; i2 >= 0; i2--) {
                bdj bdjVar5 = (bdj) arrayList.get(i2);
                if (bdjVar5.by == viewGroup && (view2 = bdjVar5.bz) != null) {
                    iIndexOfChild = viewGroup.indexOfChild(view2) + 1;
                }
            }
            while (true) {
                iIndexOf++;
                if (iIndexOf >= arrayList.size()) {
                    break;
                }
                bdj bdjVar6 = (bdj) arrayList.get(iIndexOf);
                if (bdjVar6.by == viewGroup && (view = bdjVar6.bz) != null) {
                    iIndexOfChild = viewGroup.indexOfChild(view);
                    break;
                }
            }
        }
        bdjVar2.by.addView(bdjVar2.bz, iIndexOfChild);
    }

    public final void h() {
        boolean zAr = beg.ar(3);
        bdj bdjVar = this.c;
        if (zAr) {
            Log.d("FragmentManager", "moveto ATTACHED: " + bdjVar);
        }
        bdj bdjVar2 = bdjVar.ay;
        bfb bfbVar = null;
        chm chmVar = this.b;
        if (bdjVar2 != null) {
            bfb bfbVar2 = (bfb) ((HashMap) chmVar.d).get(bdjVar2.aw);
            if (bfbVar2 == null) {
                throw new IllegalStateException("Fragment " + bdjVar + " declared target fragment " + bdjVar.ay + " that does not belong to this FragmentManager!");
            }
            bdjVar.az = bdjVar.ay.aw;
            bdjVar.ay = null;
            bfbVar = bfbVar2;
        } else {
            String str = bdjVar.az;
            if (str != null && (bfbVar = (bfb) ((HashMap) chmVar.d).get(str)) == null) {
                StringBuilder sb = new StringBuilder("Fragment ");
                sb.append(bdjVar);
                sb.append(" declared target fragment ");
                throw new IllegalStateException(yg.o(sb, bdjVar.az, " that does not belong to this FragmentManager!"));
            }
        }
        if (bfbVar != null) {
            bfbVar.p();
        }
        beg begVar = bdjVar.bm;
        bdjVar.bn = begVar.w;
        bdjVar.bp = begVar.y;
        io ioVar = this.a;
        ioVar.y(bdjVar, false);
        ArrayList arrayList = bdjVar.cm;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((bdh) it.next()).b();
        }
        arrayList.clear();
        bdjVar.bo.ax(bdjVar.bn, bdjVar.x(), bdjVar);
        bdjVar.as = 0;
        bdjVar.bx = false;
        bdjVar.e(bdjVar.bn.e);
        if (!bdjVar.bx) {
            throw new doa(yg.l("Fragment ", bdjVar, " did not call through to super.onAttach()"));
        }
        beg begVar2 = bdjVar.bm;
        Iterator it2 = begVar2.p.iterator();
        while (it2.hasNext()) {
            ((beu) it2.next()).b(begVar2, bdjVar);
        }
        beg begVar3 = bdjVar.bo;
        begVar3.ah = false;
        begVar3.ai = false;
        begVar3.ao.g = false;
        begVar3.bq(0);
        ioVar.r(bdjVar, false);
    }

    public final int i() {
        bdj bdjVar = this.c;
        if (bdjVar.bm == null) {
            return bdjVar.as;
        }
        int iMin = this.e;
        int iOrdinal = bdjVar.cg.ordinal();
        if (iOrdinal == 1) {
            iMin = Math.min(iMin, 0);
        } else if (iOrdinal == 2) {
            iMin = Math.min(iMin, 1);
        } else if (iOrdinal == 3) {
            iMin = Math.min(iMin, 5);
        } else if (iOrdinal != 4) {
            iMin = Math.min(iMin, -1);
        }
        if (bdjVar.bg) {
            if (bdjVar.bh) {
                iMin = Math.max(this.e, 2);
                View view = bdjVar.bz;
                if (view != null && view.getParent() == null) {
                    iMin = Math.min(iMin, 2);
                }
            } else {
                iMin = this.e < 4 ? Math.min(iMin, bdjVar.as) : Math.min(iMin, 1);
            }
        }
        if (bdjVar.bi && bdjVar.by == null) {
            iMin = Math.min(iMin, 4);
        }
        if (!bdjVar.bc) {
            iMin = Math.min(iMin, 1);
        }
        ViewGroup viewGroup = bdjVar.by;
        if (viewGroup != null) {
            aln alnVarG = aln.g(viewGroup, bdjVar.cs());
            dlr dlrVarN = alnVarG.n(bdjVar);
            int i = dlrVarN != null ? dlrVarN.b : 0;
            dlr dlrVarO = alnVarG.o(bdjVar);
            i = dlrVarO != null ? dlrVarO.b : 0;
            int i2 = i == 0 ? -1 : dls.a[dkz.ae(i)];
            if (i2 != -1 && i2 != 1) {
                i = i;
            }
        }
        if (i == 2) {
            iMin = Math.min(iMin, 6);
        } else if (i == 3) {
            iMin = Math.max(iMin, 3);
        } else if (bdjVar.bd) {
            iMin = bdjVar.cx() ? Math.min(iMin, 1) : Math.min(iMin, -1);
        }
        if (bdjVar.ca && bdjVar.as < 5) {
            iMin = Math.min(iMin, 4);
        }
        if (bdjVar.be) {
            iMin = Math.max(iMin, 3);
        }
        if (beg.ar(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + iMin + " for " + bdjVar);
        }
        return iMin;
    }

    public final void j() {
        Bundle bundle;
        boolean zAr = beg.ar(3);
        bdj bdjVar = this.c;
        if (zAr) {
            Log.d("FragmentManager", "moveto CREATED: " + bdjVar);
        }
        Bundle bundle2 = bdjVar.at;
        Bundle bundle3 = bundle2 != null ? bundle2.getBundle("savedInstanceState") : null;
        if (bdjVar.ce) {
            bdjVar.as = 1;
            Bundle bundle4 = bdjVar.at;
            if (bundle4 == null || (bundle = bundle4.getBundle("childFragmentManager")) == null) {
                return;
            }
            bdjVar.bo.cq(bundle);
            beg begVar = bdjVar.bo;
            begVar.ah = false;
            begVar.ai = false;
            begVar.ao.g = false;
            begVar.bq(1);
            return;
        }
        io ioVar = this.a;
        ioVar.z(bdjVar, false);
        bdjVar.bo.ck();
        bdjVar.as = 1;
        bdjVar.bx = false;
        bdjVar.ch.j(new cyo(bdjVar, 5));
        bdjVar.f(bundle3);
        bdjVar.ce = true;
        if (!bdjVar.bx) {
            throw new doa(yg.l("Fragment ", bdjVar, " did not call through to super.onCreate()"));
        }
        bdjVar.ch.m(bug.ON_CREATE);
        ioVar.t(bdjVar, false);
    }

    public final void k() {
        String resourceName;
        bdj bdjVar = this.c;
        if (bdjVar.bg) {
            return;
        }
        if (beg.ar(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + bdjVar);
        }
        Bundle bundle = bdjVar.at;
        ViewGroup viewGroup = null;
        Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
        LayoutInflater layoutInflaterAa = bdjVar.aa(bundle2);
        ViewGroup viewGroup2 = bdjVar.by;
        if (viewGroup2 != null) {
            viewGroup = viewGroup2;
        } else {
            int i = bdjVar.br;
            if (i != 0) {
                if (i == -1) {
                    throw new IllegalArgumentException(yg.l("Cannot create fragment ", bdjVar, " for a container view with no id"));
                }
                viewGroup = (ViewGroup) bdjVar.bm.x.c(i);
                if (viewGroup == null) {
                    if (!bdjVar.bj && !bdjVar.bi) {
                        try {
                            resourceName = bdjVar.dc().getResources().getResourceName(bdjVar.br);
                        } catch (Resources.NotFoundException unused) {
                            resourceName = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(bdjVar.br) + " (" + resourceName + ") for fragment " + bdjVar);
                    }
                } else if (!(viewGroup instanceof FragmentContainerView)) {
                    bfc bfcVar = bfd.a;
                    bfd.c(new bex(bdjVar, "Attempting to add fragment " + bdjVar + " to container " + viewGroup + " which is not a FragmentContainerView"));
                    bfd.b(bdjVar).getClass();
                }
            }
        }
        bdjVar.by = viewGroup;
        bdjVar.ae(layoutInflaterAa, viewGroup, bundle2);
        int i2 = 2;
        if (bdjVar.bz != null) {
            if (beg.ar(3)) {
                Log.d("FragmentManager", "moveto VIEW_CREATED: " + bdjVar);
            }
            bdjVar.bz.setSaveFromParentEnabled(false);
            bdjVar.bz.setTag(R.id.fragment_container_view_tag, bdjVar);
            if (viewGroup != null) {
                g();
            }
            if (bdjVar.bt) {
                bdjVar.bz.setVisibility(8);
            }
            if (bdjVar.bz.isAttachedToWindow()) {
                View view = bdjVar.bz;
                WeakHashMap weakHashMap = eqz.a;
                eqo.c(view);
            } else {
                View view2 = bdjVar.bz;
                view2.addOnAttachStateChangeListener(new tj(view2, i2));
            }
            Bundle bundle3 = bdjVar.at;
            if (bundle3 != null) {
                bundle3.getBundle("savedInstanceState");
            }
            bdjVar.k(bdjVar.bz);
            bdjVar.bo.bq(2);
            this.a.ae(bdjVar, bdjVar.bz, false);
            int visibility = bdjVar.bz.getVisibility();
            bdjVar.co().j = bdjVar.bz.getAlpha();
            if (bdjVar.by != null && visibility == 0) {
                View viewFindFocus = bdjVar.bz.findFocus();
                if (viewFindFocus != null) {
                    bdjVar.co().k = viewFindFocus;
                    if (beg.ar(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + bdjVar);
                    }
                }
                bdjVar.bz.setAlpha(0.0f);
            }
        }
        bdjVar.as = 2;
    }

    public final void l() {
        boolean z;
        bdj bdjVarZ;
        boolean zAr = beg.ar(3);
        bdj bdjVar = this.c;
        if (zAr) {
            Log.d("FragmentManager", "movefrom CREATED: " + bdjVar);
        }
        boolean z2 = bdjVar.bd && !bdjVar.cx();
        chm chmVar = this.b;
        if (z2 && !bdjVar.bf) {
            chmVar.as(bdjVar.aw, null);
        }
        if (!z2) {
            bej bejVar = (bej) chmVar.f;
            if (!((bejVar.b.containsKey(bdjVar.aw) && bejVar.e) ? bejVar.f : true)) {
                String str = bdjVar.az;
                if (str != null && (bdjVarZ = chmVar.z(str)) != null && bdjVarZ.bv) {
                    bdjVar.ay = bdjVarZ;
                }
                bdjVar.as = 0;
                return;
            }
        }
        bdm bdmVar = bdjVar.bn;
        if (bdmVar != null) {
            z = ((bej) chmVar.f).f;
        } else {
            z = bdmVar.e != null ? !r6.isChangingConfigurations() : true;
        }
        if ((z2 && !bdjVar.bf) || z) {
            ((bej) chmVar.f).j(bdjVar, false);
        }
        bdjVar.bo.bh();
        bdjVar.ch.m(bug.ON_DESTROY);
        bdjVar.as = 0;
        bdjVar.ce = false;
        bdjVar.bx = true;
        this.a.u(bdjVar, false);
        for (bfb bfbVar : chmVar.ac()) {
            if (bfbVar != null) {
                bdj bdjVar2 = bfbVar.c;
                if (bdjVar.aw.equals(bdjVar2.az)) {
                    bdjVar2.ay = bdjVar;
                    bdjVar2.az = null;
                }
            }
        }
        String str2 = bdjVar.az;
        if (str2 != null) {
            bdjVar.ay = chmVar.z(str2);
        }
        chmVar.ak(this);
    }

    public final void m() {
        View view;
        bdj bdjVar = this.c;
        if (beg.ar(3)) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + bdjVar);
        }
        ViewGroup viewGroup = bdjVar.by;
        if (viewGroup != null && (view = bdjVar.bz) != null) {
            viewGroup.removeView(view);
        }
        bdjVar.bo.bq(1);
        if (bdjVar.bz != null) {
            bfg bfgVar = bdjVar.ci;
            bfgVar.g();
            if (bfgVar.d.c.compareTo(buh.c) >= 0) {
                bdjVar.ci.f(bug.ON_DESTROY);
            }
        }
        bdjVar.as = 1;
        bdjVar.bx = false;
        bdjVar.h();
        if (!bdjVar.bx) {
            throw new doa(yg.l("Fragment ", bdjVar, " did not call through to super.onDestroyView()"));
        }
        erq erqVarAj = bdjVar.aj();
        bei beiVar = bwv.a;
        bzo.q(erqVarAj, "store");
        ahv ahvVar = ahv.a;
        bzo.q(ahvVar, "defaultCreationExtras");
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
        bdjVar.bk = false;
        this.a.af(bdjVar, false);
        bdjVar.by = null;
        bdjVar.bz = null;
        bdjVar.ci = null;
        chv chvVar = bdjVar.cj;
        chvVar.getClass();
        chv.k("setValue");
        chvVar.h++;
        chvVar.f = null;
        chvVar.m(null);
        bdjVar.bh = false;
    }

    public final void n() {
        boolean zAr = beg.ar(3);
        bdj bdjVar = this.c;
        if (zAr) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + bdjVar);
        }
        bdjVar.as = -1;
        bdjVar.bx = false;
        bdjVar.z();
        if (!bdjVar.bx) {
            throw new doa(yg.l("Fragment ", bdjVar, " did not call through to super.onDetach()"));
        }
        beg begVar = bdjVar.bo;
        if (!begVar.aj) {
            begVar.bh();
            bdjVar.bo = new beg();
        }
        this.a.v(bdjVar, false);
        bdjVar.as = -1;
        bdjVar.bn = null;
        bdjVar.bp = null;
        bdjVar.bm = null;
        if (!bdjVar.bd || bdjVar.cx()) {
            bej bejVar = (bej) this.b.f;
            if (!((bejVar.b.containsKey(bdjVar.aw) && bejVar.e) ? bejVar.f : true)) {
                return;
            }
        }
        if (beg.ar(3)) {
            Log.d("FragmentManager", "initState called for fragment: " + bdjVar);
        }
        bdjVar.cu();
    }

    public final void o() {
        bdj bdjVar = this.c;
        if (bdjVar.bg && bdjVar.bh && !bdjVar.bk) {
            if (beg.ar(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + bdjVar);
            }
            Bundle bundle = bdjVar.at;
            Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
            bdjVar.ae(bdjVar.aa(bundle2), null, bundle2);
            View view = bdjVar.bz;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                bdjVar.bz.setTag(R.id.fragment_container_view_tag, bdjVar);
                if (bdjVar.bt) {
                    bdjVar.bz.setVisibility(8);
                }
                Bundle bundle3 = bdjVar.at;
                if (bundle3 != null) {
                    bundle3.getBundle("savedInstanceState");
                }
                bdjVar.k(bdjVar.bz);
                bdjVar.bo.bq(2);
                this.a.ae(bdjVar, bdjVar.bz, false);
                bdjVar.as = 2;
            }
        }
    }

    public final void p() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        boolean z = this.d;
        bdj bdjVar = this.c;
        if (z) {
            if (beg.ar(2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + bdjVar);
                return;
            }
            return;
        }
        try {
            this.d = true;
            boolean z2 = false;
            while (true) {
                int i = i();
                int i2 = bdjVar.as;
                int i3 = 3;
                chm chmVar = this.b;
                if (i == i2) {
                    if (!z2 && i2 == -1 && bdjVar.bd && !bdjVar.cx() && !bdjVar.bf) {
                        if (beg.ar(3)) {
                            Log.d("FragmentManager", "Cleaning up state of never attached fragment: " + bdjVar);
                        }
                        ((bej) chmVar.f).j(bdjVar, true);
                        chmVar.ak(this);
                        if (beg.ar(3)) {
                            Log.d("FragmentManager", "initState called for fragment: " + bdjVar);
                        }
                        bdjVar.cu();
                    }
                    if (bdjVar.cd) {
                        if (bdjVar.bz != null && (viewGroup = bdjVar.by) != null) {
                            aln alnVarG = aln.g(viewGroup, bdjVar.cs());
                            if (bdjVar.bt) {
                                if (beg.ar(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + bdjVar);
                                }
                                alnVarG.l(3, 1, this);
                            } else {
                                if (beg.ar(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + bdjVar);
                                }
                                alnVarG.l(2, 1, this);
                            }
                        }
                        beg begVar = bdjVar.bm;
                        if (begVar != null && bdjVar.bc && beg.as(bdjVar)) {
                            begVar.ag = true;
                        }
                        bdjVar.cd = false;
                        bdjVar.bo.bk();
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
                            if (bdjVar.bf) {
                                if (((Bundle) ((HashMap) chmVar.e).get(bdjVar.aw)) == null) {
                                    chmVar.as(bdjVar.aw, t());
                                }
                            }
                            l();
                            break;
                        case 1:
                            m();
                            bdjVar.as = 1;
                            break;
                        case 2:
                            bdjVar.bh = false;
                            bdjVar.as = 2;
                            break;
                        case 3:
                            if (beg.ar(3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + bdjVar);
                            }
                            if (bdjVar.bf) {
                                chmVar.as(bdjVar.aw, t());
                            } else if (bdjVar.bz != null && bdjVar.au == null) {
                                u();
                            }
                            if (bdjVar.bz != null && (viewGroup2 = bdjVar.by) != null) {
                                aln alnVarG2 = aln.g(viewGroup2, bdjVar.cs());
                                if (beg.ar(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + bdjVar);
                                }
                                alnVarG2.l(1, 3, this);
                            }
                            bdjVar.as = 3;
                            break;
                        case 4:
                            w();
                            break;
                        case 5:
                            bdjVar.as = 5;
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
                            if (bdjVar.bz != null && (viewGroup3 = bdjVar.by) != null) {
                                aln alnVarG3 = aln.g(viewGroup3, bdjVar.cs());
                                int visibility = bdjVar.bz.getVisibility();
                                if (visibility == 0) {
                                    i3 = 2;
                                } else if (visibility == 4) {
                                    i3 = 4;
                                } else if (visibility != 8) {
                                    throw new IllegalArgumentException("Unknown visibility " + visibility);
                                }
                                bjs.t(i3, "finalState");
                                if (beg.ar(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + bdjVar);
                                }
                                alnVarG3.l(i3, 2, this);
                            }
                            bdjVar.as = 4;
                            break;
                        case 5:
                            v();
                            break;
                        case 6:
                            bdjVar.as = 6;
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
        bdj bdjVar = this.c;
        if (zAr) {
            Log.d("FragmentManager", "movefrom RESUMED: " + bdjVar);
        }
        bdjVar.bo.bq(5);
        if (bdjVar.bz != null) {
            bdjVar.ci.f(bug.ON_PAUSE);
        }
        bdjVar.ch.m(bug.ON_PAUSE);
        bdjVar.as = 6;
        bdjVar.bx = true;
        this.a.w(bdjVar, false);
    }

    public final void r(ClassLoader classLoader) {
        bdj bdjVar = this.c;
        Bundle bundle = bdjVar.at;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        if (bdjVar.at.getBundle("savedInstanceState") == null) {
            bdjVar.at.putBundle("savedInstanceState", new Bundle());
        }
        try {
            bdjVar.au = bdjVar.at.getSparseParcelableArray("viewState");
            bdjVar.av = bdjVar.at.getBundle("viewRegistryState");
            bey beyVar = (bey) bdjVar.at.getParcelable("state");
            if (beyVar != null) {
                bdjVar.az = beyVar.m;
                bdjVar.ba = beyVar.n;
                bdjVar.cb = beyVar.o;
            }
            if (bdjVar.cb) {
                return;
            }
            bdjVar.ca = true;
        } catch (BadParcelableException e) {
            throw new IllegalStateException("Failed to restore view hierarchy state for fragment " + bdjVar, e);
        }
    }

    /* JADX WARN: Found duplicated region for block: B:19:0x0041  */
    /* JADX WARN: Found duplicated region for block: B:21:0x0052  */
    /* JADX WARN: Found duplicated region for block: B:22:0x0055  */
    public final void s() {
        boolean zRequestFocus;
        boolean zAr = beg.ar(3);
        bdj bdjVar = this.c;
        if (zAr) {
            Log.d("FragmentManager", "moveto RESUMED: " + bdjVar);
        }
        bdg bdgVar = bdjVar.cc;
        View view = bdgVar == null ? null : bdgVar.k;
        if (view != null) {
            if (view == bdjVar.bz) {
                zRequestFocus = view.requestFocus();
                if (beg.ar(2)) {
                    StringBuilder sb = new StringBuilder("requestFocus: Restoring focused view ");
                    sb.append(view);
                    sb.append(" ");
                    sb.append(zRequestFocus ? "succeeded" : "failed");
                    sb.append(" on Fragment ");
                    sb.append(bdjVar);
                    sb.append(" resulting in focused view ");
                    sb.append(bdjVar.bz.findFocus());
                    Log.v("FragmentManager", sb.toString());
                }
            } else {
                ViewParent parent = view.getParent();
                while (true) {
                    if (parent != null) {
                        if (parent == bdjVar.bz) {
                            zRequestFocus = view.requestFocus();
                            if (beg.ar(2)) {
                                StringBuilder sb2 = new StringBuilder("requestFocus: Restoring focused view ");
                                sb2.append(view);
                                sb2.append(" ");
                                sb2.append(zRequestFocus ? "succeeded" : "failed");
                                sb2.append(" on Fragment ");
                                sb2.append(bdjVar);
                                sb2.append(" resulting in focused view ");
                                sb2.append(bdjVar.bz.findFocus());
                                Log.v("FragmentManager", sb2.toString());
                            }
                        } else {
                            parent = parent.getParent();
                        }
                    }
                }
            }
        }
        bdjVar.co().k = null;
        bdjVar.bo.ck();
        bdjVar.bo.bw(true);
        bdjVar.as = 7;
        bdjVar.bx = false;
        bdjVar.cz();
        if (!bdjVar.bx) {
            throw new doa(yg.l("Fragment ", bdjVar, " did not call through to super.onResume()"));
        }
        bur burVar = bdjVar.ch;
        bug bugVar = bug.ON_RESUME;
        burVar.m(bugVar);
        if (bdjVar.bz != null) {
            bdjVar.ci.d.m(bugVar);
        }
        beg begVar = bdjVar.bo;
        begVar.ah = false;
        begVar.ai = false;
        begVar.ao.g = false;
        begVar.bq(7);
        this.a.aa(bdjVar, false);
        this.b.as(bdjVar.aw, null);
        bdjVar.at = null;
        bdjVar.au = null;
        bdjVar.av = null;
    }

    public final Bundle t() {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        bdj bdjVar = this.c;
        if (bdjVar.as == -1 && (bundle = bdjVar.at) != null) {
            bundle2.putAll(bundle);
        }
        bundle2.putParcelable("state", new bey(bdjVar));
        if (bdjVar.as > -1) {
            Bundle bundle3 = new Bundle();
            bdjVar.j(bundle3);
            if (!bundle3.isEmpty()) {
                bundle2.putBundle("savedInstanceState", bundle3);
            }
            this.a.ab(bdjVar, bundle3, false);
            Bundle bundle4 = new Bundle();
            bdjVar.ck.ab(bundle4);
            if (!bundle4.isEmpty()) {
                bundle2.putBundle("registryState", bundle4);
            }
            Bundle bundleCr = bdjVar.bo.cr();
            if (!bundleCr.isEmpty()) {
                bundle2.putBundle("childFragmentManager", bundleCr);
            }
            if (bdjVar.bz != null) {
                u();
            }
            SparseArray<? extends Parcelable> sparseArray = bdjVar.au;
            if (sparseArray != null) {
                bundle2.putSparseParcelableArray("viewState", sparseArray);
            }
            Bundle bundle5 = bdjVar.av;
            if (bundle5 != null) {
                bundle2.putBundle("viewRegistryState", bundle5);
            }
        }
        Bundle bundle6 = bdjVar.ax;
        if (bundle6 != null) {
            bundle2.putBundle("arguments", bundle6);
        }
        return bundle2;
    }

    public final void u() {
        bdj bdjVar = this.c;
        if (bdjVar.bz == null) {
            return;
        }
        if (beg.ar(2)) {
            Log.v("FragmentManager", "Saving view state for fragment " + bdjVar + " with view " + bdjVar.bz);
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        bdjVar.bz.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            bdjVar.au = sparseArray;
        }
        Bundle bundle = new Bundle();
        bdjVar.ci.e.ab(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        bdjVar.av = bundle;
    }

    public final void v() {
        boolean zAr = beg.ar(3);
        bdj bdjVar = this.c;
        if (zAr) {
            Log.d("FragmentManager", "moveto STARTED: " + bdjVar);
        }
        bdjVar.bo.ck();
        bdjVar.bo.bw(true);
        bdjVar.as = 5;
        bdjVar.bx = false;
        bdjVar.ab();
        if (!bdjVar.bx) {
            throw new doa(yg.l("Fragment ", bdjVar, " did not call through to super.onStart()"));
        }
        bur burVar = bdjVar.ch;
        bug bugVar = bug.ON_START;
        burVar.m(bugVar);
        if (bdjVar.bz != null) {
            bdjVar.ci.d.m(bugVar);
        }
        beg begVar = bdjVar.bo;
        begVar.ah = false;
        begVar.ai = false;
        begVar.ao.g = false;
        begVar.bq(5);
        this.a.ac(bdjVar, false);
    }

    public final void w() {
        boolean zAr = beg.ar(3);
        bdj bdjVar = this.c;
        if (zAr) {
            Log.d("FragmentManager", "movefrom STARTED: " + bdjVar);
        }
        beg begVar = bdjVar.bo;
        begVar.ai = true;
        begVar.ao.g = true;
        begVar.bq(4);
        if (bdjVar.bz != null) {
            bdjVar.ci.f(bug.ON_STOP);
        }
        bdjVar.ch.m(bug.ON_STOP);
        bdjVar.as = 4;
        bdjVar.bx = false;
        bdjVar.ac();
        if (!bdjVar.bx) {
            throw new doa(yg.l("Fragment ", bdjVar, " did not call through to super.onStop()"));
        }
        this.a.ad(bdjVar, false);
    }

    public bfb(io ioVar, chm chmVar, ClassLoader classLoader, bdz bdzVar, Bundle bundle) {
        this.a = ioVar;
        this.b = chmVar;
        bdj bdjVarP = ((bey) bundle.getParcelable("state")).p(bdzVar);
        this.c = bdjVarP;
        bdjVarP.at = bundle;
        Bundle bundle2 = bundle.getBundle("arguments");
        if (bundle2 != null) {
            bundle2.setClassLoader(classLoader);
        }
        bdjVarP.df(bundle2);
        if (beg.ar(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + bdjVarP);
        }
    }

    public bfb(io ioVar, chm chmVar, bdj bdjVar, Bundle bundle) {
        this.a = ioVar;
        this.b = chmVar;
        this.c = bdjVar;
        bdjVar.au = null;
        bdjVar.av = null;
        bdjVar.bl = 0;
        bdjVar.bh = false;
        bdjVar.bc = false;
        bdj bdjVar2 = bdjVar.ay;
        bdjVar.az = bdjVar2 != null ? bdjVar2.aw : null;
        bdjVar.ay = null;
        bdjVar.at = bundle;
        bdjVar.ax = bundle.getBundle("arguments");
    }
}
