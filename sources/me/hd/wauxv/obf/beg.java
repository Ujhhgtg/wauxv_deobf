package me.hd.wauxv.obf;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentContainerView;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class beg {
    public final bdz aa;
    public final SyntheticClass ab;
    public dy ac;
    public dy ad;
    public dy ae;
    public ArrayDeque af;
    public boolean ag;
    public boolean ah;
    public boolean ai;
    public boolean aj;
    public boolean ak;
    public ArrayList al;
    public ArrayList am;
    public ArrayList an;
    public bej ao;
    public final dc ap;
    public boolean b;
    public ArrayList e;
    public cqt g;
    public final ArrayList n;
    public final io o;
    public final CopyOnWriteArrayList p;
    public final bdu q;
    public final bdu r;
    public final bdu s;
    public final bdu t;
    public final bdy u;
    public int v;
    public bdm w;
    public cnb x;
    public SomeFragmentManager y;
    public SomeFragmentManager z;
    public final ArrayList a = new ArrayList();
    public final chm c = new chm(6);
    public ArrayList d = new ArrayList();
    public final bds f = new bds(this);
    public mu h = null;
    public boolean i = false;
    public final bdx j = new bdx(this, 0);
    public final AtomicInteger k = new AtomicInteger();
    public final Map l = Collections.synchronizedMap(new HashMap());
    public final Map m = Collections.synchronizedMap(new HashMap());

    /* JADX WARN: Type inference failed for: r0v16, types: [me.hd.wauxv.obf.bdu] */
    /* JADX WARN: Type inference failed for: r0v17, types: [me.hd.wauxv.obf.bdu] */
    /* JADX WARN: Type inference failed for: r0v18, types: [me.hd.wauxv.obf.bdu] */
    /* JADX WARN: Type inference failed for: r0v19, types: [me.hd.wauxv.obf.bdu] */
    public beg() {
        final int i = 0;
        Collections.synchronizedMap(new HashMap());
        this.n = new ArrayList();
        this.o = new io(this);
        this.p = new CopyOnWriteArrayList();
        this.q = new adv(this) { // from class: me.hd.wauxv.obf.bdu
            public final /* synthetic */ beg b;

            {
                this.b = this;
            }

            @Override // me.hd.wauxv.obf.adv
            public final void accept(Object obj) {
                switch (i) {
                    case 0:
                        beg begVar = this.b;
                        if (begVar.ch()) {
                            begVar.be(false);
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        beg begVar2 = this.b;
                        if (begVar2.ch() && num.intValue() == 80) {
                            begVar2.bi(false);
                            break;
                        }
                        break;
                    case 2:
                        chp chpVar = (chp) obj;
                        beg begVar3 = this.b;
                        if (begVar3.ch()) {
                            boolean z = chpVar.a;
                            begVar3.bj(false);
                        }
                        break;
                    default:
                        ctj ctjVar = (ctj) obj;
                        beg begVar4 = this.b;
                        if (begVar4.ch()) {
                            boolean z2 = ctjVar.a;
                            begVar4.bo(false);
                        }
                        break;
                }
            }
        };
        final int i2 = 1;
        this.r = new adv(this) { // from class: me.hd.wauxv.obf.bdu
            public final /* synthetic */ beg b;

            {
                this.b = this;
            }

            @Override // me.hd.wauxv.obf.adv
            public final void accept(Object obj) {
                switch (i2) {
                    case 0:
                        beg begVar = this.b;
                        if (begVar.ch()) {
                            begVar.be(false);
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        beg begVar2 = this.b;
                        if (begVar2.ch() && num.intValue() == 80) {
                            begVar2.bi(false);
                            break;
                        }
                        break;
                    case 2:
                        chp chpVar = (chp) obj;
                        beg begVar3 = this.b;
                        if (begVar3.ch()) {
                            boolean z = chpVar.a;
                            begVar3.bj(false);
                        }
                        break;
                    default:
                        ctj ctjVar = (ctj) obj;
                        beg begVar4 = this.b;
                        if (begVar4.ch()) {
                            boolean z2 = ctjVar.a;
                            begVar4.bo(false);
                        }
                        break;
                }
            }
        };
        final int i3 = 2;
        this.s = new adv(this) { // from class: me.hd.wauxv.obf.bdu
            public final /* synthetic */ beg b;

            {
                this.b = this;
            }

            @Override // me.hd.wauxv.obf.adv
            public final void accept(Object obj) {
                switch (i3) {
                    case 0:
                        beg begVar = this.b;
                        if (begVar.ch()) {
                            begVar.be(false);
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        beg begVar2 = this.b;
                        if (begVar2.ch() && num.intValue() == 80) {
                            begVar2.bi(false);
                            break;
                        }
                        break;
                    case 2:
                        chp chpVar = (chp) obj;
                        beg begVar3 = this.b;
                        if (begVar3.ch()) {
                            boolean z = chpVar.a;
                            begVar3.bj(false);
                        }
                        break;
                    default:
                        ctj ctjVar = (ctj) obj;
                        beg begVar4 = this.b;
                        if (begVar4.ch()) {
                            boolean z2 = ctjVar.a;
                            begVar4.bo(false);
                        }
                        break;
                }
            }
        };
        final int i4 = 3;
        this.t = new adv(this) { // from class: me.hd.wauxv.obf.bdu
            public final /* synthetic */ beg b;

            {
                this.b = this;
            }

            @Override // me.hd.wauxv.obf.adv
            public final void accept(Object obj) {
                switch (i4) {
                    case 0:
                        beg begVar = this.b;
                        if (begVar.ch()) {
                            begVar.be(false);
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        beg begVar2 = this.b;
                        if (begVar2.ch() && num.intValue() == 80) {
                            begVar2.bi(false);
                            break;
                        }
                        break;
                    case 2:
                        chp chpVar = (chp) obj;
                        beg begVar3 = this.b;
                        if (begVar3.ch()) {
                            boolean z = chpVar.a;
                            begVar3.bj(false);
                        }
                        break;
                    default:
                        ctj ctjVar = (ctj) obj;
                        beg begVar4 = this.b;
                        if (begVar4.ch()) {
                            boolean z2 = ctjVar.a;
                            begVar4.bo(false);
                        }
                        break;
                }
            }
        };
        this.u = new bdy(this);
        this.v = -1;
        this.aa = new bdz(this);
        this.ab = new SyntheticClass(10);
        this.af = new ArrayDeque();
        this.ap = new dc(this, 8);
    }

    public static HashSet aq(mu muVar) {
        HashSet hashSet = new HashSet();
        for (int i = 0; i < muVar.a.size(); i++) {
            SomeFragmentManager someFragmentManagerVar = ((bfe) muVar.a.get(i)).b;
            if (someFragmentManagerVar != null && muVar.g) {
                hashSet.add(someFragmentManagerVar);
            }
        }
        return hashSet;
    }

    public static boolean ar(int i) {
        return Log.isLoggable("FragmentManager", i);
    }

    public static boolean as(SomeFragmentManager someFragmentManagerVar) {
        someFragmentManagerVar.getClass();
        boolean zAs = false;
        for (SomeFragmentManager someFragmentManagerVar2 : someFragmentManagerVar.bo.c.ad()) {
            if (someFragmentManagerVar2 != null) {
                zAs = as(someFragmentManagerVar2);
            }
            if (zAs) {
                return true;
            }
        }
        return false;
    }

    public static boolean at(SomeFragmentManager someFragmentManagerVar) {
        if (someFragmentManagerVar == null) {
            return true;
        }
        if (someFragmentManagerVar.bw) {
            return someFragmentManagerVar.bm == null || at(someFragmentManagerVar.bp);
        }
        return false;
    }

    public static boolean au(SomeFragmentManager someFragmentManagerVar) {
        if (someFragmentManagerVar == null) {
            return true;
        }
        beg begVar = someFragmentManagerVar.bm;
        return someFragmentManagerVar.equals(begVar.z) && au(begVar.y);
    }

    public static void av(SomeFragmentManager someFragmentManagerVar) {
        if (ar(2)) {
            Log.v("FragmentManager", "show: " + someFragmentManagerVar);
        }
        if (someFragmentManagerVar.bt) {
            someFragmentManagerVar.bt = false;
            someFragmentManagerVar.cd = !someFragmentManagerVar.cd;
        }
    }

    public final FragmentManager aw(SomeFragmentManager someFragmentManagerVar) {
        String str = someFragmentManagerVar.cf;
        if (str != null) {
            bfd.d(someFragmentManagerVar, str);
        }
        if (ar(2)) {
            Log.v("FragmentManager", "add: " + someFragmentManagerVar);
        }
        FragmentManager fragmentManagerVarBc = bc(someFragmentManagerVar);
        someFragmentManagerVar.bm = this;
        chm chmVar = this.c;
        chmVar.aj(fragmentManagerVarBc);
        if (!someFragmentManagerVar.bu) {
            chmVar.s(someFragmentManagerVar);
            someFragmentManagerVar.bd = false;
            if (someFragmentManagerVar.bz == null) {
                someFragmentManagerVar.cd = false;
            }
            if (as(someFragmentManagerVar)) {
                this.ag = true;
            }
        }
        return fragmentManagerVarBc;
    }

    public final void ax(bdm bdmVar, cnb cnbVar, SomeFragmentManager someFragmentManagerVar) {
        if (this.w != null) {
            throw new IllegalStateException("Already attached");
        }
        this.w = bdmVar;
        this.x = cnbVar;
        this.y = someFragmentManagerVar;
        CopyOnWriteArrayList copyOnWriteArrayList = this.p;
        if (someFragmentManagerVar != null) {
            copyOnWriteArrayList.add(new bea(someFragmentManagerVar));
        } else if (bdmVar != null) {
            copyOnWriteArrayList.add(bdmVar);
        }
        if (this.y != null) {
            cz();
        }
        if (bdmVar != null) {
            cqt cqtVarAn = bdmVar.h.an();
            this.g = cqtVarAn;
            bup bupVar = someFragmentManagerVar != null ? someFragmentManagerVar : bdmVar;
            cqtVarAn.getClass();
            bdx bdxVar = this.j;
            throwIfVar1IsNull(bdxVar, "onBackPressedCallback");
            bur burVarAp = bupVar.ap();
            if (burVarAp.c != buh.a) {
                bdxVar.b.add(new cqq(cqtVarAn, burVarAp, bdxVar));
                cqtVarAn.k();
                bdxVar.c = new cqs(0, cqtVarAn, cqt.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0, 0,
                        0);
            }
        }
        if (someFragmentManagerVar != null) {
            bej bejVar = someFragmentManagerVar.bm.ao;
            HashMap map = bejVar.c;
            bej bejVar2 = (bej) map.get(someFragmentManagerVar.aw);
            if (bejVar2 == null) {
                bejVar2 = new bej(bejVar.e);
                map.put(someFragmentManagerVar.aw, bejVar2);
            }
            this.ao = bejVar2;
        } else if (bdmVar != null) {
            erq erqVarAj = bdmVar.h.aj();
            ahv ahvVar = ahv.a;
            throwIfVar1IsNull(ahvVar, "defaultCreationExtras");
            chm chmVar = new chm(erqVarAj, bej.a, ahvVar);
            KClass zcVarB = dal.getKClassFromClass(bej.class);
            String strAo = emc.ao(zcVarB);
            if (strAo == null) {
                throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
            }
            this.ao = (bej) chmVar.ah("androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strAo), zcVarB);
        } else {
            this.ao = new bej(false);
        }
        this.ao.g = ci();
        this.c.f = this.ao;
        bdm bdmVar2 = this.w;
        if (bdmVar2 != null && someFragmentManagerVar == null) {
            but butVarAk = bdmVar2.ak();
            butVarAk.ad("android:support:fragments", new bdv(this, 0));
            Bundle bundleG = butVarAk.g("android:support:fragments");
            if (bundleG != null) {
                cq(bundleG);
            }
        }
        bdm bdmVar3 = this.w;
        if (bdmVar3 != null) {
            acg acgVar = bdmVar3.h.x;
            String strK = yg.concat("FragmentManager:", someFragmentManagerVar != null ? yg.concatToVar1(new StringBuilder(), someFragmentManagerVar.aw, ":") : "");
            this.ac = acgVar.k(StaticHelpers6.concat(strK, "StartActivityForResult"), new ds(2), new bdw(this, 1));
            this.ad = acgVar.k(StaticHelpers6.concat(strK, "StartIntentSenderForResult"), new ds(3), new bdw(this, 2));
            this.ae = acgVar.k(StaticHelpers6.concat(strK, "RequestPermissions"), new ds(1), new bdw(this, 0));
        }
        bdm bdmVar4 = this.w;
        if (bdmVar4 != null) {
            bdmVar4.h.al(this.q);
        }
        bdm bdmVar5 = this.w;
        if (bdmVar5 != null) {
            hb hbVar = bdmVar5.h;
            hbVar.getClass();
            bdu bduVar = this.r;
            throwIfVar1IsNull(bduVar, "listener");
            hbVar.z.add(bduVar);
        }
        bdm bdmVar6 = this.w;
        if (bdmVar6 != null) {
            hb hbVar2 = bdmVar6.h;
            hbVar2.getClass();
            bdu bduVar2 = this.s;
            throwIfVar1IsNull(bduVar2, "listener");
            hbVar2.ab.add(bduVar2);
        }
        bdm bdmVar7 = this.w;
        if (bdmVar7 != null) {
            hb hbVar3 = bdmVar7.h;
            hbVar3.getClass();
            bdu bduVar3 = this.t;
            throwIfVar1IsNull(bduVar3, "listener");
            hbVar3.ac.add(bduVar3);
        }
        bdm bdmVar8 = this.w;
        if (bdmVar8 == null || someFragmentManagerVar != null) {
            return;
        }
        hb hbVar4 = bdmVar8.h;
        hbVar4.getClass();
        bdy bdyVar = this.u;
        throwIfVar1IsNull(bdyVar, com.umeng.analytics.pro.f.M);
        FactoryPools factoryPoolsVar = hbVar4.s;
        ((CopyOnWriteArrayList) factoryPoolsVar.h).add(bdyVar);
        ((Runnable) factoryPoolsVar.f).run();
    }

    public final void ay(SomeFragmentManager someFragmentManagerVar) {
        if (ar(2)) {
            Log.v("FragmentManager", "attach: " + someFragmentManagerVar);
        }
        if (someFragmentManagerVar.bu) {
            someFragmentManagerVar.bu = false;
            if (someFragmentManagerVar.bc) {
                return;
            }
            this.c.s(someFragmentManagerVar);
            if (ar(2)) {
                Log.v("FragmentManager", "add from attach: " + someFragmentManagerVar);
            }
            if (as(someFragmentManagerVar)) {
                this.ag = true;
            }
        }
    }

    public final void az() {
        this.b = false;
        this.am.clear();
        this.al.clear();
    }

    public final HashSet ba() {
        aln alnVar;
        HashSet hashSet = new HashSet();
        Iterator it = this.c.ac().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((FragmentManager) it.next()).c.by;
            if (viewGroup != null) {
                throwIfVar1IsNull(cf(), "factory");
                Object tag = viewGroup.getTag(R.id.special_effects_controller_view_tag);
                if (tag instanceof aln) {
                    alnVar = (aln) tag;
                } else {
                    alnVar = new aln(viewGroup);
                    viewGroup.setTag(R.id.special_effects_controller_view_tag, alnVar);
                }
                hashSet.add(alnVar);
            }
        }
        return hashSet;
    }

    public final HashSet bb(ArrayList arrayList, int i, int i2) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i < i2) {
            Iterator it = ((mu) arrayList.get(i)).a.iterator();
            while (it.hasNext()) {
                SomeFragmentManager someFragmentManagerVar = ((bfe) it.next()).b;
                if (someFragmentManagerVar != null && (viewGroup = someFragmentManagerVar.by) != null) {
                    hashSet.add(aln.g(viewGroup, this));
                }
            }
            i++;
        }
        return hashSet;
    }

    public final FragmentManager bc(SomeFragmentManager someFragmentManagerVar) {
        String str = someFragmentManagerVar.aw;
        chm chmVar = this.c;
        FragmentManager fragmentManagerVar = (FragmentManager) ((HashMap) chmVar.d).get(str);
        if (fragmentManagerVar != null) {
            return fragmentManagerVar;
        }
        FragmentManager fragmentManagerVar2 = new FragmentManager(this.o, chmVar, someFragmentManagerVar);
        fragmentManagerVar2.r(this.w.e.getClassLoader());
        fragmentManagerVar2.e = this.v;
        return fragmentManagerVar2;
    }

    public final void bd(SomeFragmentManager someFragmentManagerVar) {
        if (ar(2)) {
            Log.v("FragmentManager", "detach: " + someFragmentManagerVar);
        }
        if (someFragmentManagerVar.bu) {
            return;
        }
        someFragmentManagerVar.bu = true;
        if (someFragmentManagerVar.bc) {
            if (ar(2)) {
                Log.v("FragmentManager", "remove from detach: " + someFragmentManagerVar);
            }
            chm chmVar = this.c;
            synchronized (((ArrayList) chmVar.c)) {
                ((ArrayList) chmVar.c).remove(someFragmentManagerVar);
            }
            someFragmentManagerVar.bc = false;
            if (as(someFragmentManagerVar)) {
                this.ag = true;
            }
            cw(someFragmentManagerVar);
        }
    }

    public final void be(boolean z) {
        if (z && this.w != null) {
            cy(new IllegalStateException(
                    "Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
            throw null;
        }
        for (SomeFragmentManager someFragmentManagerVar : this.c.af()) {
            if (someFragmentManagerVar != null) {
                someFragmentManagerVar.bx = true;
                if (z) {
                    someFragmentManagerVar.bo.be(true);
                }
            }
        }
    }

    public final boolean bf() {
        if (this.v >= 1) {
            for (SomeFragmentManager someFragmentManagerVar : this.c.af()) {
                if (someFragmentManagerVar != null) {
                    if (!someFragmentManagerVar.bt ? someFragmentManagerVar.bo.bf() : false) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean bg() {
        if (this.v < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z = false;
        for (SomeFragmentManager someFragmentManagerVar : this.c.af()) {
            if (someFragmentManagerVar != null && at(someFragmentManagerVar)) {
                if (!someFragmentManagerVar.bt ? someFragmentManagerVar.bo.bg() : false) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(someFragmentManagerVar);
                    z = true;
                }
            }
        }
        if (this.e != null) {
            for (int i = 0; i < this.e.size(); i++) {
                SomeFragmentManager someFragmentManagerVar2 = (SomeFragmentManager) this.e.get(i);
                if (arrayList == null || !arrayList.contains(someFragmentManagerVar2)) {
                    someFragmentManagerVar2.getClass();
                }
            }
        }
        this.e = arrayList;
        return z;
    }

    public final void bh() {
        boolean zIsChangingConfigurations = true;
        this.aj = true;
        bw(true);
        bt();
        bdm bdmVar = this.w;
        chm chmVar = this.c;
        if (bdmVar != null) {
            zIsChangingConfigurations = ((bej) chmVar.f).f;
        } else {
            hb hbVar = bdmVar.e;
            if (hbVar != null) {
                zIsChangingConfigurations = true ^ hbVar.isChangingConfigurations();
            }
        }
        if (zIsChangingConfigurations) {
            Iterator it = this.l.values().iterator();
            while (it.hasNext()) {
                Iterator it2 = ((mw) it.next()).a.iterator();
                while (it2.hasNext()) {
                    ((bej) chmVar.f).i((String) it2.next(), false);
                }
            }
        }
        bq(-1);
        bdm bdmVar2 = this.w;
        if (bdmVar2 != null) {
            hb hbVar2 = bdmVar2.h;
            hbVar2.getClass();
            bdu bduVar = this.r;
            throwIfVar1IsNull(bduVar, "listener");
            hbVar2.z.remove(bduVar);
        }
        bdm bdmVar3 = this.w;
        if (bdmVar3 != null) {
            hb hbVar3 = bdmVar3.h;
            hbVar3.getClass();
            bdu bduVar2 = this.q;
            throwIfVar1IsNull(bduVar2, "listener");
            hbVar3.y.remove(bduVar2);
        }
        bdm bdmVar4 = this.w;
        if (bdmVar4 != null) {
            hb hbVar4 = bdmVar4.h;
            hbVar4.getClass();
            bdu bduVar3 = this.s;
            throwIfVar1IsNull(bduVar3, "listener");
            hbVar4.ab.remove(bduVar3);
        }
        bdm bdmVar5 = this.w;
        if (bdmVar5 != null) {
            hb hbVar5 = bdmVar5.h;
            hbVar5.getClass();
            bdu bduVar4 = this.t;
            throwIfVar1IsNull(bduVar4, "listener");
            hbVar5.ac.remove(bduVar4);
        }
        bdm bdmVar6 = this.w;
        if (bdmVar6 != null && this.y == null) {
            hb hbVar6 = bdmVar6.h;
            hbVar6.getClass();
            bdy bdyVar = this.u;
            throwIfVar1IsNull(bdyVar, com.umeng.analytics.pro.f.M);
            FactoryPools factoryPoolsVar = hbVar6.s;
            ((CopyOnWriteArrayList) factoryPoolsVar.h).remove(bdyVar);
            if (((HashMap) factoryPoolsVar.e).remove(bdyVar) != null) {
                throw new ClassCastException();
            }
            ((Runnable) factoryPoolsVar.f).run();
        }
        this.w = null;
        this.x = null;
        this.y = null;
        if (this.g != null) {
            Iterator it3 = this.j.b.iterator();
            while (it3.hasNext()) {
                ((tb) it3.next()).cancel();
            }
            this.g = null;
        }
        dy dyVar = this.ac;
        if (dyVar != null) {
            dyVar.f();
            this.ad.f();
            this.ae.f();
        }
    }

    public final void bi(boolean z) {
        if (z && this.w != null) {
            cy(new IllegalStateException(
                    "Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
            throw null;
        }
        for (SomeFragmentManager someFragmentManagerVar : this.c.af()) {
            if (someFragmentManagerVar != null) {
                someFragmentManagerVar.bx = true;
                if (z) {
                    someFragmentManagerVar.bo.bi(true);
                }
            }
        }
    }

    public final void bj(boolean z) {
        if (z && this.w != null) {
            cy(new IllegalStateException(
                    "Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
            throw null;
        }
        for (SomeFragmentManager someFragmentManagerVar : this.c.af()) {
            if (someFragmentManagerVar != null && z) {
                someFragmentManagerVar.bo.bj(true);
            }
        }
    }

    public final void bk() {
        for (SomeFragmentManager someFragmentManagerVar : this.c.ad()) {
            if (someFragmentManagerVar != null) {
                someFragmentManagerVar.cw();
                someFragmentManagerVar.bo.bk();
            }
        }
    }

    public final boolean bl() {
        if (this.v >= 1) {
            for (SomeFragmentManager someFragmentManagerVar : this.c.af()) {
                if (someFragmentManagerVar != null) {
                    if (!someFragmentManagerVar.bt ? someFragmentManagerVar.bo.bl() : false) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final void bm() {
        if (this.v < 1) {
            return;
        }
        for (SomeFragmentManager someFragmentManagerVar : this.c.af()) {
            if (someFragmentManagerVar != null && !someFragmentManagerVar.bt) {
                someFragmentManagerVar.bo.bm();
            }
        }
    }

    public final void bn(SomeFragmentManager someFragmentManagerVar) {
        if (someFragmentManagerVar != null) {
            if (someFragmentManagerVar.equals(this.c.z(someFragmentManagerVar.aw))) {
                someFragmentManagerVar.bm.getClass();
                boolean zAu = au(someFragmentManagerVar);
                Boolean bool = someFragmentManagerVar.bb;
                if (bool == null || bool.booleanValue() != zAu) {
                    someFragmentManagerVar.bb = Boolean.valueOf(zAu);
                    beg begVar = someFragmentManagerVar.bo;
                    begVar.cz();
                    begVar.bn(begVar.z);
                }
            }
        }
    }

    public final void bo(boolean z) {
        if (z && this.w != null) {
            cy(new IllegalStateException(
                    "Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
            throw null;
        }
        for (SomeFragmentManager someFragmentManagerVar : this.c.af()) {
            if (someFragmentManagerVar != null && z) {
                someFragmentManagerVar.bo.bo(true);
            }
        }
    }

    public final boolean bp() {
        if (this.v < 1) {
            return false;
        }
        boolean z = false;
        for (SomeFragmentManager someFragmentManagerVar : this.c.af()) {
            if (someFragmentManagerVar != null && at(someFragmentManagerVar)) {
                if (!someFragmentManagerVar.bt ? someFragmentManagerVar.bo.bp() : false) {
                    z = true;
                }
            }
        }
        return z;
    }

    public final void bq(int i) {
        try {
            this.b = true;
            for (FragmentManager fragmentManagerVar : ((HashMap) this.c.d).values()) {
                if (fragmentManagerVar != null) {
                    fragmentManagerVar.e = i;
                }
            }
            cj(i, false);
            Iterator it = ba().iterator();
            while (it.hasNext()) {
                ((aln) it.next()).p();
            }
            this.b = false;
            bw(true);
        } catch (Throwable th) {
            this.b = false;
            throw th;
        }
    }

    public final void br() {
        if (this.ak) {
            this.ak = false;
            cx();
        }
    }

    public final void bs(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        String str2;
        String strS = StaticHelpers6.concat(str, "    ");
        chm chmVar = this.c;
        ArrayList arrayList = (ArrayList) chmVar.c;
        String strS2 = StaticHelpers6.concat(str, "    ");
        HashMap map = (HashMap) chmVar.d;
        if (!map.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (FragmentManager fragmentManagerVar : map.values()) {
                printWriter.print(str);
                if (fragmentManagerVar != null) {
                    SomeFragmentManager someFragmentManagerVar = fragmentManagerVar.c;
                    printWriter.println(someFragmentManagerVar);
                    someFragmentManagerVar.getClass();
                    printWriter.print(strS2);
                    printWriter.print("mFragmentId=#");
                    printWriter.print(Integer.toHexString(someFragmentManagerVar.bq));
                    printWriter.print(" mContainerId=#");
                    printWriter.print(Integer.toHexString(someFragmentManagerVar.br));
                    printWriter.print(" mTag=");
                    printWriter.println(someFragmentManagerVar.bs);
                    printWriter.print(strS2);
                    printWriter.print("mState=");
                    printWriter.print(someFragmentManagerVar.as);
                    printWriter.print(" mWho=");
                    printWriter.print(someFragmentManagerVar.aw);
                    printWriter.print(" mBackStackNesting=");
                    printWriter.println(someFragmentManagerVar.bl);
                    printWriter.print(strS2);
                    printWriter.print("mAdded=");
                    printWriter.print(someFragmentManagerVar.bc);
                    printWriter.print(" mRemoving=");
                    printWriter.print(someFragmentManagerVar.bd);
                    printWriter.print(" mFromLayout=");
                    printWriter.print(someFragmentManagerVar.bg);
                    printWriter.print(" mInLayout=");
                    printWriter.println(someFragmentManagerVar.bh);
                    printWriter.print(strS2);
                    printWriter.print("mHidden=");
                    printWriter.print(someFragmentManagerVar.bt);
                    printWriter.print(" mDetached=");
                    printWriter.print(someFragmentManagerVar.bu);
                    printWriter.print(" mMenuVisible=");
                    printWriter.print(someFragmentManagerVar.bw);
                    printWriter.print(" mHasMenu=");
                    printWriter.println(false);
                    printWriter.print(strS2);
                    printWriter.print("mRetainInstance=");
                    printWriter.print(someFragmentManagerVar.bv);
                    printWriter.print(" mUserVisibleHint=");
                    printWriter.println(someFragmentManagerVar.cb);
                    if (someFragmentManagerVar.bm != null) {
                        printWriter.print(strS2);
                        printWriter.print("mFragmentManager=");
                        printWriter.println(someFragmentManagerVar.bm);
                    }
                    if (someFragmentManagerVar.bn != null) {
                        printWriter.print(strS2);
                        printWriter.print("mHost=");
                        printWriter.println(someFragmentManagerVar.bn);
                    }
                    if (someFragmentManagerVar.bp != null) {
                        printWriter.print(strS2);
                        printWriter.print("mParentFragment=");
                        printWriter.println(someFragmentManagerVar.bp);
                    }
                    if (someFragmentManagerVar.ax != null) {
                        printWriter.print(strS2);
                        printWriter.print("mArguments=");
                        printWriter.println(someFragmentManagerVar.ax);
                    }
                    if (someFragmentManagerVar.at != null) {
                        printWriter.print(strS2);
                        printWriter.print("mSavedFragmentState=");
                        printWriter.println(someFragmentManagerVar.at);
                    }
                    if (someFragmentManagerVar.au != null) {
                        printWriter.print(strS2);
                        printWriter.print("mSavedViewState=");
                        printWriter.println(someFragmentManagerVar.au);
                    }
                    if (someFragmentManagerVar.av != null) {
                        printWriter.print(strS2);
                        printWriter.print("mSavedViewRegistryState=");
                        printWriter.println(someFragmentManagerVar.av);
                    }
                    Object objZ = someFragmentManagerVar.ay;
                    if (objZ == null) {
                        beg begVar = someFragmentManagerVar.bm;
                        objZ = (begVar == null || (str2 = someFragmentManagerVar.az) == null) ? null : begVar.c.z(str2);
                    }
                    if (objZ != null) {
                        printWriter.print(strS2);
                        printWriter.print("mTarget=");
                        printWriter.print(objZ);
                        printWriter.print(" mTargetRequestCode=");
                        printWriter.println(someFragmentManagerVar.ba);
                    }
                    printWriter.print(strS2);
                    printWriter.print("mPopDirection=");
                    bdg bdgVar = someFragmentManagerVar.cc;
                    printWriter.println(bdgVar == null ? false : bdgVar.a);
                    bdg bdgVar2 = someFragmentManagerVar.cc;
                    if ((bdgVar2 == null ? 0 : bdgVar2.b) != 0) {
                        printWriter.print(strS2);
                        printWriter.print("getEnterAnim=");
                        bdg bdgVar3 = someFragmentManagerVar.cc;
                        printWriter.println(bdgVar3 == null ? 0 : bdgVar3.b);
                    }
                    bdg bdgVar4 = someFragmentManagerVar.cc;
                    if ((bdgVar4 == null ? 0 : bdgVar4.c) != 0) {
                        printWriter.print(strS2);
                        printWriter.print("getExitAnim=");
                        bdg bdgVar5 = someFragmentManagerVar.cc;
                        printWriter.println(bdgVar5 == null ? 0 : bdgVar5.c);
                    }
                    bdg bdgVar6 = someFragmentManagerVar.cc;
                    if ((bdgVar6 == null ? 0 : bdgVar6.d) != 0) {
                        printWriter.print(strS2);
                        printWriter.print("getPopEnterAnim=");
                        bdg bdgVar7 = someFragmentManagerVar.cc;
                        printWriter.println(bdgVar7 == null ? 0 : bdgVar7.d);
                    }
                    bdg bdgVar8 = someFragmentManagerVar.cc;
                    if ((bdgVar8 == null ? 0 : bdgVar8.e) != 0) {
                        printWriter.print(strS2);
                        printWriter.print("getPopExitAnim=");
                        bdg bdgVar9 = someFragmentManagerVar.cc;
                        printWriter.println(bdgVar9 == null ? 0 : bdgVar9.e);
                    }
                    if (someFragmentManagerVar.by != null) {
                        printWriter.print(strS2);
                        printWriter.print("mContainer=");
                        printWriter.println(someFragmentManagerVar.by);
                    }
                    if (someFragmentManagerVar.bz != null) {
                        printWriter.print(strS2);
                        printWriter.print("mView=");
                        printWriter.println(someFragmentManagerVar.bz);
                    }
                    if (someFragmentManagerVar.cq() != null) {
                        erq erqVarAj = someFragmentManagerVar.aj();
                        bei beiVar = bwv.a;
                        throwIfVar1IsNull(erqVarAj, "store");
                        ahv ahvVar = ahv.a;
                        throwIfVar1IsNull(ahvVar, "defaultCreationExtras");
                        chm chmVar2 = new chm(erqVarAj, beiVar, ahvVar);
                        KClass zcVarB = dal.getKClassFromClass(bwv.class);
                        String strAo = emc.ao(zcVarB);
                        if (strAo == null) {
                            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
                        }
                        dlo dloVar = ((bwv) chmVar2.ah("androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strAo),
                                zcVarB)).b;
                        if (dloVar.i() > 0) {
                            printWriter.print(strS2);
                            printWriter.println("Loaders:");
                            if (dloVar.i() > 0) {
                                if (dloVar.j(0) != null) {
                                    throw new ClassCastException();
                                }
                                printWriter.print(strS2);
                                printWriter.print("  #");
                                printWriter.print(dloVar.g(0));
                                printWriter.print(": ");
                                throw null;
                            }
                        }
                    }
                    printWriter.print(strS2);
                    printWriter.println("Child " + someFragmentManagerVar.bo + ":");
                    someFragmentManagerVar.bo.bs(StaticHelpers6.concat(strS2, "  "), fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size2 = arrayList.size();
        if (size2 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i = 0; i < size2; i++) {
                SomeFragmentManager someFragmentManagerVar2 = (SomeFragmentManager) arrayList.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(someFragmentManagerVar2.toString());
            }
        }
        ArrayList arrayList2 = this.e;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < size; i2++) {
                SomeFragmentManager someFragmentManagerVar3 = (SomeFragmentManager) this.e.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(someFragmentManagerVar3.toString());
            }
        }
        int size3 = this.d.size();
        if (size3 > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i3 = 0; i3 < size3; i3++) {
                mu muVar = (mu) this.d.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(muVar.toString());
                muVar.ad(printWriter, strS, true);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.k.get());
        synchronized (this.a) {
            try {
                int size4 = this.a.size();
                if (size4 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i4 = 0; i4 < size4; i4++) {
                        Object obj = (bec) this.a.get(i4);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i4);
                        printWriter.print(": ");
                        printWriter.println(obj);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.w);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.x);
        if (this.y != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.y);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.v);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.ah);
        printWriter.print(" mStopped=");
        printWriter.print(this.ai);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.aj);
        if (this.ag) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.ag);
        }
    }

    public final void bt() {
        Iterator it = ba().iterator();
        while (it.hasNext()) {
            ((aln) it.next()).p();
        }
    }

    public final void bu(bec becVar, boolean z) {
        if (!z) {
            if (this.w == null) {
                if (!this.aj) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            if (ci()) {
                throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
            }
        }
        synchronized (this.a) {
            try {
                if (this.w == null) {
                    if (!z) {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                } else {
                    this.a.add(becVar);
                    cs();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void bv(boolean z) {
        if (this.b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.w == null) {
            if (!this.aj) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.w.f.getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z && ci()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.al == null) {
            this.al = new ArrayList();
            this.am = new ArrayList();
        }
    }

    public final boolean bw(boolean z) {
        boolean zV;
        mu muVar;
        bv(z);
        if (!this.i && (muVar = this.h) != null) {
            muVar.s = false;
            muVar.y();
            if (ar(3)) {
                Log.d("FragmentManager", "Reversing mTransitioningOp " + this.h
                        + " as part of execPendingActions for actions " + this.a);
            }
            this.h.aa(false, false);
            this.a.add(0, this.h);
            Iterator it = this.h.a.iterator();
            while (it.hasNext()) {
                SomeFragmentManager someFragmentManagerVar = ((bfe) it.next()).b;
                if (someFragmentManagerVar != null) {
                    someFragmentManagerVar.be = false;
                }
            }
            this.h = null;
        }
        boolean z2 = false;
        while (true) {
            ArrayList arrayList = this.al;
            ArrayList arrayList2 = this.am;
            synchronized (this.a) {
                if (this.a.isEmpty()) {
                    zV = false;
                } else {
                    try {
                        int size = this.a.size();
                        zV = false;
                        for (int i = 0; i < size; i++) {
                            zV |= ((bec) this.a.get(i)).v(arrayList, arrayList2);
                        }
                        this.a.clear();
                        this.w.f.removeCallbacks(this.ap);
                    } catch (Throwable th) {
                        this.a.clear();
                        this.w.f.removeCallbacks(this.ap);
                        throw th;
                    }
                }
            }
            if (!zV) {
                cz();
                br();
                ((HashMap) this.c.d).values().removeAll(Collections.singleton(null));
                return z2;
            }
            z2 = true;
            this.b = true;
            try {
                cp(this.al, this.am);
                az();
            } catch (Throwable th2) {
                az();
                throw th2;
            }
        }
    }

    public final void bx(mu muVar, boolean z) {
        if (z && (this.w == null || this.aj)) {
            return;
        }
        bv(z);
        mu muVar2 = this.h;
        if (muVar2 != null) {
            muVar2.s = false;
            muVar2.y();
            if (ar(3)) {
                Log.d("FragmentManager",
                        "Reversing mTransitioningOp " + this.h + " as part of execSingleAction for action " + muVar);
            }
            this.h.aa(false, false);
            this.h.v(this.al, this.am);
            Iterator it = this.h.a.iterator();
            while (it.hasNext()) {
                SomeFragmentManager someFragmentManagerVar = ((bfe) it.next()).b;
                if (someFragmentManagerVar != null) {
                    someFragmentManagerVar.be = false;
                }
            }
            this.h = null;
        }
        muVar.v(this.al, this.am);
        this.b = true;
        try {
            cp(this.al, this.am);
            az();
            cz();
            br();
            ((HashMap) this.c.d).values().removeAll(Collections.singleton(null));
        } catch (Throwable th) {
            az();
            throw th;
        }
    }

    /*
     * JADX WARN: Found duplicated region for block: B:113:0x0238 A[PHI: r15
     * 0x0238: PHI (r15v25 int) = (r15v24 int), (r15v27 int) binds: [B:105:0x0225,
     * B:109:0x022f] A[DONT_GENERATE, DONT_INLINE]]
     */
    /* JADX WARN: Found duplicated region for block: B:25:0x0074 */
    /* JADX WARN: Found duplicated region for block: B:64:0x0178 */
    public final void by(ArrayList arrayList, ArrayList arrayList2, int i, int i2) {
        Object objPrevious;
        String str;
        ArrayList arrayList3;
        boolean z;
        int i3;
        boolean z2;
        boolean z3;
        ArrayList arrayList4;
        int i4;
        int i5;
        int i6 = i;
        chm chmVar = this.c;
        ArrayList arrayList5 = this.n;
        boolean z4 = ((mu) arrayList.get(i6)).p;
        ArrayList arrayList6 = this.an;
        if (arrayList6 == null) {
            this.an = new ArrayList();
        } else {
            arrayList6.clear();
        }
        this.an.addAll(chmVar.af());
        SomeFragmentManager someFragmentManagerVar = this.z;
        int i7 = i6;
        boolean z5 = false;
        while (i7 < i2) {
            mu muVar = (mu) arrayList.get(i7);
            if (((Boolean) arrayList2.get(i7)).booleanValue()) {
                arrayList3 = arrayList5;
                z = z4;
                i3 = i7;
                z2 = z5;
                int i8 = 1;
                ArrayList arrayList7 = this.an;
                ArrayList arrayList8 = muVar.a;
                int size = arrayList8.size() - 1;
                while (size >= 0) {
                    bfe bfeVar = (bfe) arrayList8.get(size);
                    int i9 = bfeVar.a;
                    if (i9 != i8) {
                        if (i9 != 3) {
                            switch (i9) {
                                case 6:
                                    arrayList7.add(bfeVar.b);
                                    break;
                                case 8:
                                    someFragmentManagerVar = null;
                                    break;
                                case 9:
                                    someFragmentManagerVar = bfeVar.b;
                                    break;
                                case 10:
                                    bfeVar.i = bfeVar.h;
                                    break;
                            }
                        } else {
                            arrayList7.add(bfeVar.b);
                        }
                        size--;
                        i8 = 1;
                    }
                    arrayList7.remove(bfeVar.b);
                    size--;
                    i8 = 1;
                }
            } else {
                ArrayList arrayList9 = this.an;
                ArrayList arrayList10 = muVar.a;
                int i10 = 0;
                while (i10 < arrayList10.size()) {
                    bfe bfeVar2 = (bfe) arrayList10.get(i10);
                    boolean z6 = z4;
                    int i11 = bfeVar2.a;
                    int i12 = i7;
                    int i13 = 1;
                    if (i11 != 1) {
                        z3 = z5;
                        if (i11 != 2) {
                            if (i11 == 3 || i11 == 6) {
                                arrayList9.remove(bfeVar2.b);
                                SomeFragmentManager someFragmentManagerVar2 = bfeVar2.b;
                                if (someFragmentManagerVar2 == someFragmentManagerVar) {
                                    arrayList10.add(i10, new bfe(9, someFragmentManagerVar2));
                                    i10++;
                                    arrayList4 = arrayList5;
                                    someFragmentManagerVar = null;
                                } else {
                                    arrayList4 = arrayList5;
                                }
                            } else if (i11 == 7) {
                                i13 = 1;
                            } else if (i11 != 8) {
                                arrayList4 = arrayList5;
                            } else {
                                arrayList10.add(i10, new bfe(9, someFragmentManagerVar, 0));
                                bfeVar2.c = true;
                                i10++;
                                arrayList4 = arrayList5;
                                someFragmentManagerVar = bfeVar2.b;
                            }
                            i13 = 1;
                        } else {
                            SomeFragmentManager someFragmentManagerVar3 = bfeVar2.b;
                            int i14 = someFragmentManagerVar3.br;
                            int size2 = arrayList9.size() - 1;
                            boolean z7 = false;
                            while (size2 >= 0) {
                                int i15 = size2;
                                SomeFragmentManager someFragmentManagerVar4 = (SomeFragmentManager) arrayList9.get(size2);
                                ArrayList arrayList11 = arrayList5;
                                if (someFragmentManagerVar4.br != i14) {
                                    i4 = i14;
                                } else if (someFragmentManagerVar4 == someFragmentManagerVar3) {
                                    i4 = i14;
                                    z7 = true;
                                } else {
                                    if (someFragmentManagerVar4 == someFragmentManagerVar) {
                                        i4 = i14;
                                        arrayList10.add(i10, new bfe(9, someFragmentManagerVar4, 0));
                                        i10++;
                                        i5 = 0;
                                        someFragmentManagerVar = null;
                                    } else {
                                        i4 = i14;
                                        i5 = 0;
                                    }
                                    bfe bfeVar3 = new bfe(3, someFragmentManagerVar4, i5);
                                    bfeVar3.d = bfeVar2.d;
                                    bfeVar3.f = bfeVar2.f;
                                    bfeVar3.e = bfeVar2.e;
                                    bfeVar3.g = bfeVar2.g;
                                    arrayList10.add(i10, bfeVar3);
                                    arrayList9.remove(someFragmentManagerVar4);
                                    i10++;
                                    someFragmentManagerVar = someFragmentManagerVar;
                                }
                                size2 = i15 - 1;
                                i14 = i4;
                                arrayList5 = arrayList11;
                            }
                            arrayList4 = arrayList5;
                            i13 = 1;
                            if (z7) {
                                arrayList10.remove(i10);
                                i10--;
                            } else {
                                bfeVar2.a = 1;
                                bfeVar2.c = true;
                                arrayList9.add(someFragmentManagerVar3);
                            }
                        }
                        i10 += i13;
                        z4 = z6;
                        i7 = i12;
                        z5 = z3;
                        arrayList5 = arrayList4;
                    } else {
                        z3 = z5;
                    }
                    arrayList4 = arrayList5;
                    arrayList9.add(bfeVar2.b);
                    i10 += i13;
                    z4 = z6;
                    i7 = i12;
                    z5 = z3;
                    arrayList5 = arrayList4;
                }
                arrayList3 = arrayList5;
                z = z4;
                i3 = i7;
                z2 = z5;
            }
            z5 = z2 || muVar.g;
            i7 = i3 + 1;
            z4 = z;
            arrayList5 = arrayList3;
        }
        ArrayList<bes> arrayList12 = arrayList5;
        boolean z8 = z4;
        boolean z9 = z5;
        this.an.clear();
        if (!z8 && this.v >= 1) {
            for (int i16 = i6; i16 < i2; i16++) {
                Iterator it = ((mu) arrayList.get(i16)).a.iterator();
                while (it.hasNext()) {
                    SomeFragmentManager someFragmentManagerVar5 = ((bfe) it.next()).b;
                    if (someFragmentManagerVar5 != null && someFragmentManagerVar5.bm != null) {
                        chmVar.aj(bc(someFragmentManagerVar5));
                    }
                }
            }
        }
        String str2 = "Unknown cmd: ";
        int i17 = i6;
        while (i17 < i2) {
            mu muVar2 = (mu) arrayList.get(i17);
            if (((Boolean) arrayList2.get(i17)).booleanValue()) {
                muVar2.x(-1);
                beg begVar = muVar2.r;
                ArrayList arrayList13 = muVar2.a;
                for (int size3 = arrayList13.size() - 1; size3 >= 0; size3--) {
                    bfe bfeVar4 = (bfe) arrayList13.get(size3);
                    SomeFragmentManager someFragmentManagerVar6 = bfeVar4.b;
                    if (someFragmentManagerVar6 != null) {
                        someFragmentManagerVar6.bf = muVar2.u;
                        if (someFragmentManagerVar6.cc != null) {
                            someFragmentManagerVar6.co().a = true;
                        }
                        int i18 = muVar2.f;
                        int i19 = q.a.s;
                        int i20 = q.a.a;
                        if (i18 != 4097) {
                            if (i18 != 8194) {
                                i19 = q.a.d;
                                if (i18 != 8197) {
                                    i20 = q.a.c;
                                    i19 = i18 != 4099 ? i18 != 4100 ? 0 : q.a.v : i20;
                                }
                            }
                        }
                        if (someFragmentManagerVar6.cc != null || i19 != 0) {
                            someFragmentManagerVar6.co();
                            someFragmentManagerVar6.cc.f = i19;
                        }
                        someFragmentManagerVar6.co();
                        someFragmentManagerVar6.cc.getClass();
                    }
                    switch (bfeVar4.a) {
                        case 1:
                            someFragmentManagerVar6.de(bfeVar4.d, bfeVar4.e, bfeVar4.f, bfeVar4.g);
                            begVar.ct(someFragmentManagerVar6, true);
                            begVar.co(someFragmentManagerVar6);
                            break;
                        case 2:
                        default:
                            throw new IllegalArgumentException(str2 + bfeVar4.a);
                        case 3:
                            someFragmentManagerVar6.de(bfeVar4.d, bfeVar4.e, bfeVar4.f, bfeVar4.g);
                            begVar.aw(someFragmentManagerVar6);
                            break;
                        case 4:
                            someFragmentManagerVar6.de(bfeVar4.d, bfeVar4.e, bfeVar4.f, bfeVar4.g);
                            begVar.getClass();
                            av(someFragmentManagerVar6);
                            break;
                        case 5:
                            someFragmentManagerVar6.de(bfeVar4.d, bfeVar4.e, bfeVar4.f, bfeVar4.g);
                            begVar.ct(someFragmentManagerVar6, true);
                            begVar.cg(someFragmentManagerVar6);
                            break;
                        case 6:
                            someFragmentManagerVar6.de(bfeVar4.d, bfeVar4.e, bfeVar4.f, bfeVar4.g);
                            begVar.ay(someFragmentManagerVar6);
                            break;
                        case 7:
                            someFragmentManagerVar6.de(bfeVar4.d, bfeVar4.e, bfeVar4.f, bfeVar4.g);
                            begVar.ct(someFragmentManagerVar6, true);
                            begVar.bd(someFragmentManagerVar6);
                            break;
                        case 8:
                            begVar.cv(null);
                            break;
                        case 9:
                            begVar.cv(someFragmentManagerVar6);
                            break;
                        case 10:
                            begVar.cu(someFragmentManagerVar6, bfeVar4.h);
                            break;
                    }
                }
            } else {
                muVar2.x(1);
                beg begVar2 = muVar2.r;
                ArrayList arrayList14 = muVar2.a;
                int size4 = arrayList14.size();
                int i21 = 0;
                while (i21 < size4) {
                    bfe bfeVar5 = (bfe) arrayList14.get(i21);
                    SomeFragmentManager someFragmentManagerVar7 = bfeVar5.b;
                    if (someFragmentManagerVar7 != null) {
                        someFragmentManagerVar7.bf = muVar2.u;
                        if (someFragmentManagerVar7.cc != null) {
                            someFragmentManagerVar7.co().a = false;
                        }
                        int i22 = muVar2.f;
                        if (someFragmentManagerVar7.cc != null || i22 != 0) {
                            someFragmentManagerVar7.co();
                            someFragmentManagerVar7.cc.f = i22;
                        }
                        someFragmentManagerVar7.co();
                        someFragmentManagerVar7.cc.getClass();
                    }
                    switch (bfeVar5.a) {
                        case 1:
                            str = str2;
                            someFragmentManagerVar7.de(bfeVar5.d, bfeVar5.e, bfeVar5.f, bfeVar5.g);
                            begVar2.ct(someFragmentManagerVar7, false);
                            begVar2.aw(someFragmentManagerVar7);
                            i21++;
                            str2 = str;
                            break;
                        case 2:
                        default:
                            throw new IllegalArgumentException(str2 + bfeVar5.a);
                        case 3:
                            str = str2;
                            someFragmentManagerVar7.de(bfeVar5.d, bfeVar5.e, bfeVar5.f, bfeVar5.g);
                            begVar2.co(someFragmentManagerVar7);
                            i21++;
                            str2 = str;
                            break;
                        case 4:
                            str = str2;
                            someFragmentManagerVar7.de(bfeVar5.d, bfeVar5.e, bfeVar5.f, bfeVar5.g);
                            begVar2.cg(someFragmentManagerVar7);
                            i21++;
                            str2 = str;
                            break;
                        case 5:
                            str = str2;
                            someFragmentManagerVar7.de(bfeVar5.d, bfeVar5.e, bfeVar5.f, bfeVar5.g);
                            begVar2.ct(someFragmentManagerVar7, false);
                            av(someFragmentManagerVar7);
                            i21++;
                            str2 = str;
                            break;
                        case 6:
                            str = str2;
                            someFragmentManagerVar7.de(bfeVar5.d, bfeVar5.e, bfeVar5.f, bfeVar5.g);
                            begVar2.bd(someFragmentManagerVar7);
                            i21++;
                            str2 = str;
                            break;
                        case 7:
                            str = str2;
                            someFragmentManagerVar7.de(bfeVar5.d, bfeVar5.e, bfeVar5.f, bfeVar5.g);
                            begVar2.ct(someFragmentManagerVar7, false);
                            begVar2.ay(someFragmentManagerVar7);
                            i21++;
                            str2 = str;
                            break;
                        case 8:
                            begVar2.cv(someFragmentManagerVar7);
                            str = str2;
                            i21++;
                            str2 = str;
                            break;
                        case 9:
                            begVar2.cv(null);
                            str = str2;
                            i21++;
                            str2 = str;
                            break;
                        case 10:
                            begVar2.cu(someFragmentManagerVar7, bfeVar5.i);
                            str = str2;
                            i21++;
                            str2 = str;
                            break;
                    }
                }
            }
            i17++;
            str2 = str2;
        }
        boolean zBooleanValue = ((Boolean) arrayList2.get(i2 - 1)).booleanValue();
        if (z9 && !arrayList12.isEmpty()) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                linkedHashSet.addAll(aq((mu) it2.next()));
            }
            if (this.h == null) {
                for (bes besVar : arrayList12) {
                    Iterator it3 = linkedHashSet.iterator();
                    while (it3.hasNext()) {
                        besVar.d((SomeFragmentManager) it3.next(), zBooleanValue);
                    }
                }
                for (bes besVar2 : arrayList12) {
                    Iterator it4 = linkedHashSet.iterator();
                    while (it4.hasNext()) {
                        besVar2.c((SomeFragmentManager) it4.next(), zBooleanValue);
                    }
                }
            }
        }
        for (int i23 = i6; i23 < i2; i23++) {
            mu muVar3 = (mu) arrayList.get(i23);
            if (zBooleanValue) {
                for (int size5 = muVar3.a.size() - 1; size5 >= 0; size5--) {
                    SomeFragmentManager someFragmentManagerVar8 = ((bfe) muVar3.a.get(size5)).b;
                    if (someFragmentManagerVar8 != null) {
                        bc(someFragmentManagerVar8).p();
                    }
                }
            } else {
                Iterator it5 = muVar3.a.iterator();
                while (it5.hasNext()) {
                    SomeFragmentManager someFragmentManagerVar9 = ((bfe) it5.next()).b;
                    if (someFragmentManagerVar9 != null) {
                        bc(someFragmentManagerVar9).p();
                    }
                }
            }
        }
        cj(this.v, true);
        for (aln alnVar : bb(arrayList, i6, i2)) {
            alnVar.e = zBooleanValue;
            synchronized (alnVar.b) {
                try {
                    alnVar.r();
                    ArrayList arrayList15 = alnVar.b;
                    ListIterator listIterator = arrayList15.listIterator(arrayList15.size());
                    while (true) {
                        if (listIterator.hasPrevious()) {
                            objPrevious = listIterator.previous();
                            dlr dlrVar = (dlr) objPrevious;
                            View view = dlrVar.c.bz;
                            throwIfVar1IsNull(view, "operation.fragment.mView");
                            char c = 4;
                            if (view.getAlpha() != 0.0f || view.getVisibility() != 0) {
                                int visibility = view.getVisibility();
                                if (visibility == 0) {
                                    c = 2;
                                } else if (visibility != 4) {
                                    if (visibility != 8) {
                                        throw new IllegalArgumentException("Unknown visibility " + visibility);
                                    }
                                    c = 3;
                                }
                            }
                            if (dlrVar.a != 2 || c == 2) {
                            }
                        } else {
                            objPrevious = null;
                        }
                    }
                    alnVar.f = false;
                } catch (Throwable th) {
                    throw th;
                }
            }
            alnVar.m();
        }
        while (i6 < i2) {
            mu muVar4 = (mu) arrayList.get(i6);
            if (((Boolean) arrayList2.get(i6)).booleanValue() && muVar4.t >= 0) {
                muVar4.t = -1;
            }
            if (muVar4.q != null) {
                for (int i24 = 0; i24 < muVar4.q.size(); i24++) {
                    ((Runnable) muVar4.q.get(i24)).run();
                }
                muVar4.q = null;
            }
            i6++;
        }
        if (z9) {
            for (int i25 = 0; i25 < arrayList12.size(); i25++) {
                ((bes) arrayList12.get(i25)).getClass();
            }
        }
    }

    public final int bz(String str, int i, boolean z) {
        if (this.d.isEmpty()) {
            return -1;
        }
        if (str == null && i < 0) {
            if (z) {
                return 0;
            }
            return this.d.size() - 1;
        }
        int size = this.d.size() - 1;
        while (size >= 0) {
            mu muVar = (mu) this.d.get(size);
            if ((str != null && str.equals(muVar.i)) || (i >= 0 && i == muVar.t)) {
                break;
            }
            size--;
        }
        if (size < 0) {
            return size;
        }
        if (!z) {
            if (size == this.d.size() - 1) {
                return -1;
            }
            return size + 1;
        }
        while (size > 0) {
            mu muVar2 = (mu) this.d.get(size - 1);
            if ((str == null || !str.equals(muVar2.i)) && (i < 0 || i != muVar2.t)) {
                break;
            }
            size--;
        }
        return size;
    }

    public final SomeFragmentManager ca(int i) {
        chm chmVar = this.c;
        ArrayList arrayList = (ArrayList) chmVar.c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            SomeFragmentManager someFragmentManagerVar = (SomeFragmentManager) arrayList.get(size);
            if (someFragmentManagerVar != null && someFragmentManagerVar.bq == i) {
                return someFragmentManagerVar;
            }
        }
        for (FragmentManager fragmentManagerVar : ((HashMap) chmVar.d).values()) {
            if (fragmentManagerVar != null) {
                SomeFragmentManager someFragmentManagerVar2 = fragmentManagerVar.c;
                if (someFragmentManagerVar2.bq == i) {
                    return someFragmentManagerVar2;
                }
            }
        }
        return null;
    }

    public final SomeFragmentManager cb(String str) {
        chm chmVar = this.c;
        ArrayList arrayList = (ArrayList) chmVar.c;
        if (str != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                SomeFragmentManager someFragmentManagerVar = (SomeFragmentManager) arrayList.get(size);
                if (someFragmentManagerVar != null && str.equals(someFragmentManagerVar.bs)) {
                    return someFragmentManagerVar;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (FragmentManager fragmentManagerVar : ((HashMap) chmVar.d).values()) {
            if (fragmentManagerVar != null) {
                SomeFragmentManager someFragmentManagerVar2 = fragmentManagerVar.c;
                if (str.equals(someFragmentManagerVar2.bs)) {
                    return someFragmentManagerVar2;
                }
            }
        }
        return null;
    }

    public final void cc() {
        for (aln alnVar : ba()) {
            if (alnVar.f) {
                if (ar(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Forcing postponed operations");
                }
                alnVar.f = false;
                alnVar.m();
            }
        }
    }

    public final ViewGroup cd(SomeFragmentManager someFragmentManagerVar) {
        ViewGroup viewGroup = someFragmentManagerVar.by;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (someFragmentManagerVar.br <= 0 || !this.x.d()) {
            return null;
        }
        View viewC = this.x.c(someFragmentManagerVar.br);
        if (viewC instanceof ViewGroup) {
            return (ViewGroup) viewC;
        }
        return null;
    }

    public final bdz ce() {
        SomeFragmentManager someFragmentManagerVar = this.y;
        return someFragmentManagerVar != null ? someFragmentManagerVar.bm.ce() : this.aa;
    }

    public final SyntheticClass cf() {
        SomeFragmentManager someFragmentManagerVar = this.y;
        return someFragmentManagerVar != null ? someFragmentManagerVar.bm.cf() : this.ab;
    }

    public final void cg(SomeFragmentManager someFragmentManagerVar) {
        if (ar(2)) {
            Log.v("FragmentManager", "hide: " + someFragmentManagerVar);
        }
        if (someFragmentManagerVar.bt) {
            return;
        }
        someFragmentManagerVar.bt = true;
        someFragmentManagerVar.cd = true ^ someFragmentManagerVar.cd;
        cw(someFragmentManagerVar);
    }

    public final boolean ch() {
        SomeFragmentManager someFragmentManagerVar = this.y;
        if (someFragmentManagerVar == null) {
            return true;
        }
        return someFragmentManagerVar.cv() && this.y.cs().ch();
    }

    public final boolean ci() {
        return this.ah || this.ai;
    }

    public final void cj(int i, boolean z) {
        bdm bdmVar;
        if (this.w == null && i != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z || i != this.v) {
            this.v = i;
            chm chmVar = this.c;
            HashMap map = (HashMap) chmVar.d;
            Iterator it = ((ArrayList) chmVar.c).iterator();
            while (it.hasNext()) {
                FragmentManager fragmentManagerVar = (FragmentManager) map.get(((SomeFragmentManager) it.next()).aw);
                if (fragmentManagerVar != null) {
                    fragmentManagerVar.p();
                }
            }
            for (FragmentManager fragmentManagerVar2 : map.values()) {
                if (fragmentManagerVar2 != null) {
                    fragmentManagerVar2.p();
                    SomeFragmentManager someFragmentManagerVar = fragmentManagerVar2.c;
                    if (someFragmentManagerVar.bd && !someFragmentManagerVar.cx()) {
                        if (someFragmentManagerVar.bf && !((HashMap) chmVar.e).containsKey(someFragmentManagerVar.aw)) {
                            chmVar.as(someFragmentManagerVar.aw, fragmentManagerVar2.t());
                        }
                        chmVar.ak(fragmentManagerVar2);
                    }
                }
            }
            cx();
            if (this.ag && (bdmVar = this.w) != null && this.v == 7) {
                bdmVar.h.invalidateOptionsMenu();
                this.ag = false;
            }
        }
    }

    public final void ck() {
        if (this.w == null) {
            return;
        }
        this.ah = false;
        this.ai = false;
        this.ao.g = false;
        for (SomeFragmentManager someFragmentManagerVar : this.c.af()) {
            if (someFragmentManagerVar != null) {
                someFragmentManagerVar.bo.ck();
            }
        }
    }

    public final boolean cl() {
        return cm(-1, 0);
    }

    public final boolean cm(int i, int i2) {
        bw(false);
        bv(true);
        SomeFragmentManager someFragmentManagerVar = this.z;
        if (someFragmentManagerVar != null && i < 0 && someFragmentManagerVar.cp().cl()) {
            return true;
        }
        boolean zCn = cn(this.al, this.am, null, i, i2);
        if (zCn) {
            this.b = true;
            try {
                cp(this.al, this.am);
                az();
            } catch (Throwable th) {
                az();
                throw th;
            }
        }
        cz();
        br();
        ((HashMap) this.c.d).values().removeAll(Collections.singleton(null));
        return zCn;
    }

    public final boolean cn(ArrayList arrayList, ArrayList arrayList2, String str, int i, int i2) {
        int iBz = bz(str, i, (i2 & 1) != 0);
        if (iBz < 0) {
            return false;
        }
        for (int size = this.d.size() - 1; size >= iBz; size--) {
            arrayList.add((mu) this.d.remove(size));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    public final void co(SomeFragmentManager someFragmentManagerVar) {
        if (ar(2)) {
            Log.v("FragmentManager", "remove: " + someFragmentManagerVar + " nesting=" + someFragmentManagerVar.bl);
        }
        boolean zCx = someFragmentManagerVar.cx();
        if (someFragmentManagerVar.bu && zCx) {
            return;
        }
        chm chmVar = this.c;
        synchronized (((ArrayList) chmVar.c)) {
            ((ArrayList) chmVar.c).remove(someFragmentManagerVar);
        }
        someFragmentManagerVar.bc = false;
        if (as(someFragmentManagerVar)) {
            this.ag = true;
        }
        someFragmentManagerVar.bd = true;
        cw(someFragmentManagerVar);
    }

    public final void cp(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            if (!((mu) arrayList.get(i)).p) {
                if (i2 != i) {
                    by(arrayList, arrayList2, i2, i);
                }
                i2 = i + 1;
                if (((Boolean) arrayList2.get(i)).booleanValue()) {
                    while (i2 < size && ((Boolean) arrayList2.get(i2)).booleanValue() && !((mu) arrayList.get(i2)).p) {
                        i2++;
                    }
                }
                by(arrayList, arrayList2, i, i2);
                i = i2 - 1;
            }
            i++;
        }
        if (i2 != size) {
            by(arrayList, arrayList2, i2, size);
        }
    }

    public final void cq(Bundle bundle) {
        io ioVar;
        FragmentManager fragmentManagerVar;
        Bundle bundle2;
        Bundle bundle3;
        for (String str : bundle.keySet()) {
            if (str.startsWith("result_") && (bundle3 = bundle.getBundle(str)) != null) {
                bundle3.setClassLoader(this.w.e.getClassLoader());
                this.m.put(str.substring(7), bundle3);
            }
        }
        HashMap map = new HashMap();
        for (String str2 : bundle.keySet()) {
            if (str2.startsWith("fragment_") && (bundle2 = bundle.getBundle(str2)) != null) {
                bundle2.setClassLoader(this.w.e.getClassLoader());
                map.put(str2.substring(9), bundle2);
            }
        }
        chm chmVar = this.c;
        HashMap map2 = (HashMap) chmVar.e;
        HashMap map3 = (HashMap) chmVar.d;
        map2.clear();
        map2.putAll(map);
        beh behVar = (beh) bundle.getParcelable("state");
        if (behVar == null) {
            return;
        }
        map3.clear();
        Iterator it = behVar.a.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            ioVar = this.o;
            if (!zHasNext) {
                break;
            }
            Bundle bundleAs = chmVar.as((String) it.next(), null);
            if (bundleAs != null) {
                SomeFragmentManager someFragmentManagerVar = (SomeFragmentManager) this.ao.b.get(((bey) bundleAs.getParcelable("state")).b);
                if (someFragmentManagerVar != null) {
                    if (ar(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + someFragmentManagerVar);
                    }
                    fragmentManagerVar = new FragmentManager(ioVar, chmVar, someFragmentManagerVar, bundleAs);
                } else {
                    fragmentManagerVar = new FragmentManager(this.o, this.c, this.w.e.getClassLoader(), ce(), bundleAs);
                }
                SomeFragmentManager someFragmentManagerVar2 = fragmentManagerVar.c;
                someFragmentManagerVar2.at = bundleAs;
                someFragmentManagerVar2.bm = this;
                if (ar(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + someFragmentManagerVar2.aw + "): " + someFragmentManagerVar2);
                }
                fragmentManagerVar.r(this.w.e.getClassLoader());
                chmVar.aj(fragmentManagerVar);
                fragmentManagerVar.e = this.v;
            }
        }
        bej bejVar = this.ao;
        bejVar.getClass();
        for (SomeFragmentManager someFragmentManagerVar3 : new ArrayList(bejVar.b.values())) {
            if (map3.get(someFragmentManagerVar3.aw) == null) {
                if (ar(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + someFragmentManagerVar3
                            + " that was not found in the set of active Fragments " + behVar.a);
                }
                this.ao.l(someFragmentManagerVar3);
                someFragmentManagerVar3.bm = this;
                FragmentManager fragmentManagerVar2 = new FragmentManager(ioVar, chmVar, someFragmentManagerVar3);
                fragmentManagerVar2.e = 1;
                fragmentManagerVar2.p();
                someFragmentManagerVar3.bd = true;
                fragmentManagerVar2.p();
            }
        }
        ArrayList<String> arrayList = behVar.b;
        ((ArrayList) chmVar.c).clear();
        if (arrayList != null) {
            for (String str3 : arrayList) {
                SomeFragmentManager someFragmentManagerVarZ = chmVar.z(str3);
                if (someFragmentManagerVarZ == null) {
                    throw new IllegalStateException(concat("No instantiated fragment for (", str3, ")"));
                }
                if (ar(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str3 + "): " + someFragmentManagerVarZ);
                }
                chmVar.s(someFragmentManagerVarZ);
            }
        }
        if (behVar.c != null) {
            this.d = new ArrayList(behVar.c.length);
            int i = 0;
            while (true) {
                mv[] mvVarArr = behVar.c;
                if (i >= mvVarArr.length) {
                    break;
                }
                mv mvVar = mvVarArr[i];
                ArrayList arrayList2 = mvVar.b;
                mu muVar = new mu(this);
                mvVar.o(muVar);
                muVar.t = mvVar.g;
                for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                    String str4 = (String) arrayList2.get(i2);
                    if (str4 != null) {
                        ((bfe) muVar.a.get(i2)).b = chmVar.z(str4);
                    }
                }
                muVar.x(1);
                if (ar(2)) {
                    StringBuilder sbR = yg.concatVar213(i, "restoreAllState: back stack #", " (index ");
                    sbR.append(muVar.t);
                    sbR.append("): ");
                    sbR.append(muVar);
                    Log.v("FragmentManager", sbR.toString());
                    PrintWriter printWriter = new PrintWriter(new bxr());
                    muVar.ad(printWriter, "  ", false);
                    printWriter.close();
                }
                this.d.add(muVar);
                i++;
            }
        } else {
            this.d = new ArrayList();
        }
        this.k.set(behVar.d);
        String str5 = behVar.e;
        if (str5 != null) {
            SomeFragmentManager someFragmentManagerVarZ2 = chmVar.z(str5);
            this.z = someFragmentManagerVarZ2;
            bn(someFragmentManagerVarZ2);
        }
        ArrayList arrayList3 = behVar.f;
        if (arrayList3 != null) {
            for (int i3 = 0; i3 < arrayList3.size(); i3++) {
                this.l.put((String) arrayList3.get(i3), (mw) behVar.g.get(i3));
            }
        }
        this.af = new ArrayDeque(behVar.h);
    }

    public final Bundle cr() {
        ArrayList arrayList;
        mv[] mvVarArr;
        Bundle bundle = new Bundle();
        cc();
        bt();
        bw(true);
        this.ah = true;
        this.ao.g = true;
        chm chmVar = this.c;
        chmVar.getClass();
        HashMap map = (HashMap) chmVar.d;
        ArrayList arrayList2 = new ArrayList(map.size());
        for (FragmentManager fragmentManagerVar : map.values()) {
            if (fragmentManagerVar != null) {
                SomeFragmentManager someFragmentManagerVar = fragmentManagerVar.c;
                chmVar.as(someFragmentManagerVar.aw, fragmentManagerVar.t());
                arrayList2.add(someFragmentManagerVar.aw);
                if (ar(2)) {
                    Log.v("FragmentManager", "Saved state of " + someFragmentManagerVar + ": " + someFragmentManagerVar.at);
                }
            }
        }
        HashMap map2 = (HashMap) this.c.e;
        if (!map2.isEmpty()) {
            chm chmVar2 = this.c;
            synchronized (((ArrayList) chmVar2.c)) {
                try {
                    if (((ArrayList) chmVar2.c).isEmpty()) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(((ArrayList) chmVar2.c).size());
                        for (SomeFragmentManager someFragmentManagerVar2 : (ArrayList) chmVar2.c) {
                            arrayList.add(someFragmentManagerVar2.aw);
                            if (ar(2)) {
                                Log.v("FragmentManager",
                                        "saveAllState: adding fragment (" + someFragmentManagerVar2.aw + "): " + someFragmentManagerVar2);
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            int size = this.d.size();
            if (size > 0) {
                mvVarArr = new mv[size];
                for (int i = 0; i < size; i++) {
                    mvVarArr[i] = new mv((mu) this.d.get(i));
                    if (ar(2)) {
                        StringBuilder sbR = yg.concatVar213(i, "saveAllState: adding back stack #", ": ");
                        sbR.append(this.d.get(i));
                        Log.v("FragmentManager", sbR.toString());
                    }
                }
            } else {
                mvVarArr = null;
            }
            beh behVar = new beh();
            behVar.e = null;
            ArrayList arrayList3 = new ArrayList();
            behVar.f = arrayList3;
            ArrayList arrayList4 = new ArrayList();
            behVar.g = arrayList4;
            behVar.a = arrayList2;
            behVar.b = arrayList;
            behVar.c = mvVarArr;
            behVar.d = this.k.get();
            SomeFragmentManager someFragmentManagerVar3 = this.z;
            if (someFragmentManagerVar3 != null) {
                behVar.e = someFragmentManagerVar3.aw;
            }
            arrayList3.addAll(this.l.keySet());
            arrayList4.addAll(this.l.values());
            behVar.h = new ArrayList(this.af);
            bundle.putParcelable("state", behVar);
            for (String str : this.m.keySet()) {
                bundle.putBundle(yg.concat("result_", str), (Bundle) this.m.get(str));
            }
            for (String str2 : map2.keySet()) {
                bundle.putBundle(yg.concat("fragment_", str2), (Bundle) map2.get(str2));
            }
        } else if (ar(2)) {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return bundle;
        }
        return bundle;
    }

    public final void cs() {
        synchronized (this.a) {
            try {
                if (this.a.size() == 1) {
                    this.w.f.removeCallbacks(this.ap);
                    this.w.f.post(this.ap);
                    cz();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void ct(SomeFragmentManager someFragmentManagerVar, boolean z) {
        ViewGroup viewGroupCd = cd(someFragmentManagerVar);
        if (viewGroupCd == null || !(viewGroupCd instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) viewGroupCd).setDrawDisappearingViewsLast(!z);
    }

    public final void cu(SomeFragmentManager someFragmentManagerVar, buh buhVar) {
        if (someFragmentManagerVar.equals(this.c.z(someFragmentManagerVar.aw)) && (someFragmentManagerVar.bn == null || someFragmentManagerVar.bm == this)) {
            someFragmentManagerVar.cg = buhVar;
            return;
        }
        throw new IllegalArgumentException(
                "Fragment " + someFragmentManagerVar + " is not an active fragment of FragmentManager " + this);
    }

    public final void cv(SomeFragmentManager someFragmentManagerVar) {
        if (someFragmentManagerVar != null) {
            if (!someFragmentManagerVar.equals(this.c.z(someFragmentManagerVar.aw)) || (someFragmentManagerVar.bn != null && someFragmentManagerVar.bm != this)) {
                throw new IllegalArgumentException(
                        "Fragment " + someFragmentManagerVar + " is not an active fragment of FragmentManager " + this);
            }
        }
        SomeFragmentManager someFragmentManagerVar2 = this.z;
        this.z = someFragmentManagerVar;
        bn(someFragmentManagerVar2);
        bn(this.z);
    }

    public final void cw(SomeFragmentManager someFragmentManagerVar) {
        ViewGroup viewGroupCd = cd(someFragmentManagerVar);
        if (viewGroupCd != null) {
            bdg bdgVar = someFragmentManagerVar.cc;
            if ((bdgVar == null ? 0 : bdgVar.e) + (bdgVar == null ? 0 : bdgVar.d) + (bdgVar == null ? 0 : bdgVar.c)
                    + (bdgVar == null ? 0 : bdgVar.b) > 0) {
                if (viewGroupCd.getTag(R.id.visible_removing_fragment_view_tag) == null) {
                    viewGroupCd.setTag(R.id.visible_removing_fragment_view_tag, someFragmentManagerVar);
                }
                SomeFragmentManager someFragmentManagerVar2 = (SomeFragmentManager) viewGroupCd.getTag(R.id.visible_removing_fragment_view_tag);
                bdg bdgVar2 = someFragmentManagerVar.cc;
                boolean z = bdgVar2 != null ? bdgVar2.a : false;
                if (someFragmentManagerVar2.cc == null) {
                    return;
                }
                someFragmentManagerVar2.co().a = z;
            }
        }
    }

    public final void cx() {
        for (FragmentManager fragmentManagerVar : this.c.ac()) {
            SomeFragmentManager someFragmentManagerVar = fragmentManagerVar.c;
            if (someFragmentManagerVar.ca) {
                if (this.b) {
                    this.ak = true;
                } else {
                    someFragmentManagerVar.ca = false;
                    fragmentManagerVar.p();
                }
            }
        }
    }

    public final void cy(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new bxr());
        bdm bdmVar = this.w;
        if (bdmVar == null) {
            try {
                bs("  ", null, printWriter, new String[0]);
                throw runtimeException;
            } catch (Exception e) {
                Log.e("FragmentManager", "Failed dumping state", e);
                throw runtimeException;
            }
        }
        try {
            bdmVar.h.dump("  ", null, printWriter, new String[0]);
            throw runtimeException;
        } catch (Exception e2) {
            Log.e("FragmentManager", "Failed dumping state", e2);
            throw runtimeException;
        }
    }

    /*
     * JADX WARN: Type inference failed for: r0v7, types: [me.hd.wauxv.obf.bfu,
     * me.hd.wauxv.obf.bgr]
     */
    /*
     * JADX WARN: Type inference failed for: r2v6, types: [me.hd.wauxv.obf.bfu,
     * me.hd.wauxv.obf.bgr]
     */
    public final void cz() {
        synchronized (this.a) {
            try {
                if (!this.a.isEmpty()) {
                    bdx bdxVar = this.j;
                    bdxVar.a = true;
                    ?? r2 = bdxVar.c;
                    if (r2 != 0) {
                        r2.invoke();
                    }
                    if (ar(3)) {
                        Log.d("FragmentManager", "FragmentManager " + this + " enabling OnBackPressedCallback, caused by non-empty pending actions");
                    }
                    return;
                }
                boolean z = this.d.size() + (this.h != null ? 1 : 0) > 0 && au(this.y);
                if (ar(3)) {
                    Log.d("FragmentManager", "OnBackPressedCallback for FragmentManager " + this + " enabled state is " + z);
                }
                bdx bdxVar2 = this.j;
                bdxVar2.a = z;
                ?? r0 = bdxVar2.c;
                if (r0 != 0) {
                    r0.invoke();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        SomeFragmentManager someFragmentManagerVar = this.y;
        if (someFragmentManagerVar != null) {
            sb.append(someFragmentManagerVar.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.y)));
            sb.append("}");
        } else {
            bdm bdmVar = this.w;
            if (bdmVar != null) {
                sb.append(bdmVar.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.w)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }
}
