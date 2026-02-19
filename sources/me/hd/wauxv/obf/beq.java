package me.hd.wauxv.obf;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
@ckk("fragment")
public class beq extends ckl {
    public final Context a;
    public final beg b;
    public final int f;
    public final LinkedHashSet g = new LinkedHashSet();
    public final ArrayList h = new ArrayList();
    public final bel m = new bel(this, 0);
    public final StillAnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg n = new StillAnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(this, 4);

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static final class a extends erk {
        public WeakReference a;

        @Override // me.hd.wauxv.obf.erk
        public final void h() {
            WeakReference weakReference = this.a;
            if (weakReference == null) {
                throwLateinitPropNotInitYet("completeTransition");
                throw null;
            }
            bfu bfuVar = (bfu) weakReference.get();
            if (bfuVar != null) {
                bfuVar.invoke();
            }
        }
    }

    public beq(Context context, beg begVar, int i) {
        this.a = context;
        this.b = begVar;
        this.f = i;
    }

    public static void o(beq beqVar, String str, int i) {
        boolean z = (i & 2) == 0;
        boolean z2 = (i & 4) != 0;
        ArrayList arrayList = beqVar.h;
        if (z2) {
            StaticHelpers2.ap(arrayList, new beo(str, 0));
        }
        arrayList.add(new Pair(str, Boolean.valueOf(z)));
    }

    public static boolean p() {
        return Log.isLoggable("FragmentManager", 2) || Log.isLoggable("FragmentNavigator", 2);
    }

    @Override // me.hd.wauxv.obf.ckl
    public final cjg c() {
        return new ber(this);
    }

    @Override // me.hd.wauxv.obf.ckl
    public final void i(List list, cjo cjoVar) {
        beg begVar = this.b;
        if (begVar.ci()) {
            Log.i("FragmentNavigator", "Ignoring navigate() call: FragmentManager has already saved its state");
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            cio cioVar = (cio) it.next();
            boolean zIsEmpty = ((List) ((dml) w().e.obj).c()).isEmpty();
            if (cjoVar == null || zIsEmpty || !cjoVar.b || !this.g.remove(cioVar.f)) {
                mu muVarT = t(cioVar, cjoVar);
                String str = cioVar.f;
                if (!zIsEmpty) {
                    cio cioVar2 = (cio) StaticHelpers5.m((List) ((dml) w().e.obj).c());
                    if (cioVar2 != null) {
                        o(this, cioVar2.f, 6);
                    }
                    o(this, str, 6);
                    if (!muVarT.h) {
                        throw new IllegalStateException(
                                "This FragmentTransaction is not allowed to be added to the back stack.");
                    }
                    muVarT.g = true;
                    muVarT.i = str;
                }
                muVarT.z();
                if (p()) {
                    Log.v("FragmentNavigator", "Calling pushWithTransition via navigate() on entry " + cioVar);
                }
                w().p(cioVar);
            } else {
                begVar.bu(new bef(begVar, cioVar.f, 0), false);
                w().p(cioVar);
            }
        }
    }

    @Override // me.hd.wauxv.obf.ckl
    public final void j(final cit citVar) {
        this.u = citVar;
        this.v = true;
        if (p()) {
            Log.v("FragmentNavigator", "onAttach");
        }
        beu beuVar = new beu() { // from class: me.hd.wauxv.obf.bem
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Object, me.hd.wauxv.obf.bet] */
            @Override // me.hd.wauxv.obf.beu
            public final void b(beg begVar, SomeFragmentManager bdjVar) {
                Object obj;
                Object objPrevious;
                throwIfVar1IsNull(begVar, "<unused var>");
                throwIfVar1IsNull(bdjVar, "fragment");
                cit citVar2 = citVar;
                List list = (List) ((dml) citVar2.e.obj).c();
                ListIterator listIterator = list.listIterator(list.size());
                do {
                    obj = null;
                    if (!listIterator.hasPrevious()) {
                        objPrevious = null;
                        break;
                    }
                    objPrevious = listIterator.previous();
                } while (!nullSafeIsEqual(((cio) objPrevious).f, bdjVar.bs));
                cio cioVar = (cio) objPrevious;
                boolean zP = beq.p();
                beq beqVar = this;
                if (zP) {
                    Log.v("FragmentNavigator", "Attaching fragment " + bdjVar + " associated with entry " + cioVar + " to FragmentManager " + beqVar.b);
                }
                if (cioVar != null) {
                    chv chvVar = bdjVar.cj;
                    final ben benVar = new ben(beqVar, bdjVar, cioVar, 0);
                    ?? r5 = new cqg() { // from class: me.hd.wauxv.obf.bet
                        @Override // me.hd.wauxv.obf.cqg
                        public final /* synthetic */ void b(Object obj2) {
                            benVar.invoke(obj2);
                        }

                        public final boolean equals(Object obj2) {
                            if (!(obj2 instanceof cqg) || !(obj2 instanceof bet)) {
                                return false;
                            }
                            return benVar.equals(benVar);
                        }

                        public final int hashCode() {
                            return benVar.hashCode();
                        }
                    };
                    chvVar.getClass();
                    chv.k("observe");
                    if (bdjVar.ch.c != buh.a) {
                        bwq bwqVar = new bwq(chvVar, bdjVar, r5);
                        dee deeVar = chvVar.c;
                        deb debVarB = deeVar.b(r5);
                        if (debVarB != null) {
                            obj = debVarB.b;
                        } else {
                            deb debVar = new deb(r5, bwqVar);
                            deeVar.g++;
                            deb debVar2 = deeVar.e;
                            if (debVar2 == null) {
                                deeVar.d = debVar;
                                deeVar.e = debVar;
                            } else {
                                debVar2.c = debVar;
                                debVar.d = debVar2;
                                deeVar.e = debVar;
                            }
                        }
                        bwr bwrVar = (bwr) obj;
                        if (bwrVar != null && !bwrVar.f(bdjVar)) {
                            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
                        }
                        if (bwrVar == null) {
                            bdjVar.ch.j(bwqVar);
                        }
                    }
                    bdjVar.ch.j(beqVar.m);
                    beqVar.s(bdjVar, cioVar, citVar2);
                }
            }
        };
        beg begVar = this.b;
        begVar.p.add(beuVar);
        begVar.n.add(new bes(citVar, this));
    }

    @Override // me.hd.wauxv.obf.ckl
    public final void k(cio cioVar) {
        String str = cioVar.f;
        beg begVar = this.b;
        if (begVar.ci()) {
            Log.i("FragmentNavigator",
                    "Ignoring onLaunchSingleTop() call: FragmentManager has already saved its state");
            return;
        }
        mu muVarT = t(cioVar, null);
        List list = (List) ((dml) w().e.obj).c();
        if (list.size() > 1) {
            cio cioVar2 = (cio) StaticHelpers5.h(OtherStaticHelpers.af(list) - 1, list);
            if (cioVar2 != null) {
                o(this, cioVar2.f, 6);
            }
            o(this, str, 4);
            begVar.bu(new bed(begVar, str, -1), false);
            o(this, str, 2);
            if (!muVarT.h) {
                throw new IllegalStateException(
                        "This FragmentTransaction is not allowed to be added to the back stack.");
            }
            muVarT.g = true;
            muVarT.i = str;
        }
        muVarT.z();
        w().l(cioVar);
    }

    @Override // me.hd.wauxv.obf.ckl
    public final void l(cio cioVar, boolean z) {
        int i;
        beg begVar = this.b;
        if (begVar.ci()) {
            Log.i("FragmentNavigator", "Ignoring popBackStack() call: FragmentManager has already saved its state");
            return;
        }
        List list = (List) ((dml) w().e.obj).c();
        int iIndexOf = list.indexOf(cioVar);
        List listSubList = list.subList(iIndexOf, list.size());
        cio cioVar2 = (cio) StaticHelpers5.safeGetFirstInList(list);
        cio cioVar3 = (cio) StaticHelpers5.h(iIndexOf - 1, list);
        if (cioVar3 != null) {
            o(this, cioVar3.f, 6);
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = listSubList.iterator();
        while (true) {
            if (!it.hasNext()) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    o(this, ((cio) it2.next()).f, 4);
                }
                if (z) {
                    for (cio cioVar4 : StaticHelpers5.r(listSubList)) {
                        if (nullSafeIsEqual(cioVar4, cioVar2)) {
                            Log.i("FragmentNavigator",
                                    "FragmentManager cannot save the state of the initial destination " + cioVar4);
                        } else {
                            begVar.bu(new bef(begVar, cioVar4.f, 1), false);
                            this.g.add(cioVar4.f);
                        }
                    }
                } else {
                    begVar.bu(new bed(begVar, cioVar.f, -1), false);
                }
                if (p()) {
                    Log.v("FragmentNavigator", "Calling popWithTransition via popBackStack() on entry " + cioVar
                            + " with savedState " + z);
                }
                w().n(cioVar, z);
                return;
            }
            Object next = it.next();
            cio cioVar5 = (cio) next;
            lb lbVarA = StaticHelpers5.a(this.h);
            String str = cioVar5.f;
            Iterator it3 = lbVarA.iterator();
            int i2 = 0;
            while (true) {
                if (!it3.hasNext()) {
                    i = -1;
                    break;
                }
                Pair pairVar = (Pair) it3.next();
                throwIfVar1IsNull(pairVar, "it");
                String str2 = (String) pairVar.a;
                if (i2 < 0) {
                    OtherStaticHelpers.aj();
                    throw null;
                }
                if (nullSafeIsEqual(str, str2)) {
                    i = i2;
                    break;
                }
                i2++;
            }
            if ((i >= 0) || !nullSafeIsEqual(cioVar5.f, cioVar2.f)) {
                arrayList.add(next);
            }
        }
    }

    @Override // me.hd.wauxv.obf.ckl
    public final void q(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("androidx-nav-fragment:navigator:savedIds");
        if (stringArrayList != null) {
            LinkedHashSet linkedHashSet = this.g;
            linkedHashSet.clear();
            StaticHelpers2.an(linkedHashSet, stringArrayList);
        }
    }

    @Override // me.hd.wauxv.obf.ckl
    public final Bundle r() {
        LinkedHashSet linkedHashSet = this.g;
        if (linkedHashSet.isEmpty()) {
            return null;
        }
        return ResourcesCompat.r(new Pair("androidx-nav-fragment:navigator:savedIds", new ArrayList(linkedHashSet)));
    }

    public final void s(SomeFragmentManager someFragmentManagerVar, cio cioVar, cit citVar) {
        throwIfVar1IsNull(someFragmentManagerVar, "fragment");
        erq erqVarAj = someFragmentManagerVar.aj();
        bpg bpgVar = new bpg(0);
        bpgVar.b(dal.getKClassFromClass(a.class), new bep(0));
        SyntheticPileOfMess bmuVarC = bpgVar.c();
        ahv ahvVar = ahv.a;
        throwIfVar1IsNull(ahvVar, "defaultCreationExtras");
        chm chmVar = new chm(erqVarAj, bmuVarC, ahvVar);
        KClass zcVarB = dal.getKClassFromClass(a.class);
        String strAo = emc.ao(zcVarB);
        if (strAo == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        ((a) chmVar.ah("androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strAo), zcVarB)).a = new WeakReference(
                new ls(cioVar, citVar, this, someFragmentManagerVar));
    }

    public final mu t(cio cioVar, cjo cjoVar) {
        cjg cjgVar = cioVar.b;
        throwIfVar1IsNull(cjgVar,
                "null cannot be cast to non-null type androidx.navigation.fragment.FragmentNavigator.Destination");
        Bundle bundleL = cioVar.h.l();
        String str = ((ber) cjgVar).a;
        if (str == null) {
            throw new IllegalStateException("Fragment class was not set");
        }
        char cCharAt = str.charAt(0);
        Context context = this.a;
        if (cCharAt == '.') {
            str = context.getPackageName() + str;
        }
        beg begVar = this.b;
        bdz bdzVarCe = begVar.ce();
        context.getClassLoader();
        SomeFragmentManager someFragmentManagerVarE = bdzVarCe.e(str);
        throwIfVar1IsNull(someFragmentManagerVarE, "instantiate(...)");
        someFragmentManagerVarE.df(bundleL);
        mu muVar = new mu(begVar);
        int i = cjoVar != null ? cjoVar.f : -1;
        int i2 = cjoVar != null ? cjoVar.g : -1;
        int i3 = cjoVar != null ? cjoVar.h : -1;
        int i4 = cjoVar != null ? cjoVar.i : -1;
        if (i != -1 || i2 != -1 || i3 != -1 || i4 != -1) {
            if (i == -1) {
                i = 0;
            }
            if (i2 == -1) {
                i2 = 0;
            }
            if (i3 == -1) {
                i3 = 0;
            }
            int i5 = i4 != -1 ? i4 : 0;
            muVar.b = i;
            muVar.c = i2;
            muVar.d = i3;
            muVar.e = i5;
        }
        String str2 = cioVar.f;
        int i6 = this.f;
        if (i6 == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        muVar.ac(i6, someFragmentManagerVarE, str2, 2);
        muVar.ag(someFragmentManagerVarE);
        muVar.p = true;
        return muVar;
    }
}
