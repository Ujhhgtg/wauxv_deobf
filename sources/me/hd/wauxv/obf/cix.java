package me.hd.wauxv.obf;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cix {
    public final cjl a;
    public final cis b;
    public cji c;
    public Bundle d;
    public Bundle[] e;
    public final km f = new km();
    public final dml g;
    public final dml h;
    public final LinkedHashMap i;
    public final LinkedHashMap j;
    public final LinkedHashMap k;
    public final LinkedHashMap l;
    public bup m;
    public ciy n;
    public final ArrayList o;
    public buh p;
    public final bel q;
    public final ckm r;
    public final LinkedHashMap s;
    public bgf t;
    public ciu u;
    public final LinkedHashMap v;
    public int w;
    public final ArrayList x;
    public final dhb y;

    public cix(cjl cjlVar, cis cisVar) {
        this.a = cjlVar;
        this.b = cisVar;
        EmptyReadonlyList emptyReadonlyListVar = EmptyReadonlyList.a;
        this.g = new dml(emptyReadonlyListVar);
        this.h = new dml(emptyReadonlyListVar);
        this.i = new LinkedHashMap();
        this.j = new LinkedHashMap();
        this.k = new LinkedHashMap();
        this.l = new LinkedHashMap();
        this.o = new ArrayList();
        this.p = buh.b;
        this.q = new bel(this, 1);
        this.r = new ckm();
        this.s = new LinkedHashMap();
        this.v = new LinkedHashMap();
        this.x = new ArrayList();
        this.y = new dhb();
    }

    public static /* synthetic */ void aa(cix cixVar, cio cioVar) {
        cixVar.am(cioVar, false, new km());
    }

    public static cjg z(int i, cjg cjgVar, cjg cjgVar2, boolean z) {
        if (cjgVar.g.a == i && (cjgVar2 == null || (cjgVar.equals(cjgVar2) && nullSafeIsEqual(cjgVar.h, cjgVar2.h)))) {
            return cjgVar;
        }
        cji cjiVar = cjgVar instanceof cji ? (cji) cjgVar : null;
        if (cjiVar == null) {
            cjiVar = cjgVar.h;
            throwIfVar1IsNull(cjiVar);
        }
        return cjiVar.b.k(i, cjiVar, cjgVar2, z);
    }

    public final void ab(cjg cjgVar, Bundle bundle, cio cioVar, List list) {
        Object objPrevious;
        Object objPrevious2;
        anr anrVar = this.a.c;
        cjg cjgVar2 = cioVar.b;
        boolean z = cjgVar2 instanceof bbn;
        km kmVar = this.f;
        if (!z) {
            while (!kmVar.isEmpty() && (((cio) kmVar.last()).b instanceof bbn)
                    && al(((cio) kmVar.last()).b.g.a, true, false)) {
            }
        }
        km<cio> kmVar2 = new km();
        Object obj = null;
        if (cjgVar instanceof cji) {
            cjg cjgVar3 = cjgVar2;
            do {
                throwIfVar1IsNull(cjgVar3);
                cjgVar3 = cjgVar3.h;
                if (cjgVar3 != null) {
                    ListIterator listIterator = list.listIterator(list.size());
                    do {
                        if (!listIterator.hasPrevious()) {
                            objPrevious2 = null;
                            break;
                        }
                        objPrevious2 = listIterator.previous();
                    } while (!nullSafeIsEqual(((cio) objPrevious2).b, cjgVar3));
                    cio cioVarH = (cio) objPrevious2;
                    if (cioVarH == null) {
                        cioVarH = cbm.h(anrVar, cjgVar3, bundle, ah(), this.n);
                    }
                    kmVar2.addFirst(cioVarH);
                    if (!kmVar.isEmpty() && ((cio) kmVar.last()).b == cjgVar3) {
                        aa(this, (cio) kmVar.last());
                    }
                }
                if (cjgVar3 == null) {
                    break;
                }
            } while (cjgVar3 != cjgVar);
        }
        cjg cjgVar4 = kmVar2.isEmpty() ? cjgVar2 : ((cio) kmVar2.first()).b;
        while (cjgVar4 != null && ad(cjgVar4.g.a, cjgVar4) != cjgVar4) {
            cjgVar4 = cjgVar4.h;
            if (cjgVar4 != null) {
                Bundle bundle2 = (bundle == null || !bundle.isEmpty()) ? bundle : null;
                ListIterator listIterator2 = list.listIterator(list.size());
                do {
                    if (!listIterator2.hasPrevious()) {
                        objPrevious = null;
                        break;
                    }
                    objPrevious = listIterator2.previous();
                } while (!nullSafeIsEqual(((cio) objPrevious).b, cjgVar4));
                cio cioVarH2 = (cio) objPrevious;
                if (cioVarH2 == null) {
                    cioVarH2 = cbm.h(anrVar, cjgVar4, cjgVar4.k(bundle2), ah(), this.n);
                }
                kmVar2.addFirst(cioVarH2);
            }
        }
        if (!kmVar2.isEmpty()) {
            cjgVar2 = ((cio) kmVar2.first()).b;
        }
        while (!kmVar.isEmpty() && (((cio) kmVar.last()).b instanceof cji)) {
            cjg cjgVar5 = ((cio) kmVar.last()).b;
            throwIfVar1IsNull(cjgVar5, "null cannot be cast to non-null type androidx.navigation.NavGraph");
            if (((dlo) ((cji) cjgVar5).b.e).f(cjgVar2.g.a) != null) {
                break;
            } else {
                aa(this, (cio) kmVar.last());
            }
        }
        cio cioVar2 = (cio) (kmVar.isEmpty() ? null : kmVar.e[kmVar.d]);
        if (cioVar2 == null) {
            cioVar2 = (cio) (kmVar2.isEmpty() ? null : kmVar2.e[kmVar2.d]);
        }
        if (!nullSafeIsEqual(cioVar2 != null ? cioVar2.b : null, this.c)) {
            ListIterator listIterator3 = list.listIterator(list.size());
            while (listIterator3.hasPrevious()) {
                Object objPrevious3 = listIterator3.previous();
                cjg cjgVar6 = ((cio) objPrevious3).b;
                cji cjiVar = this.c;
                throwIfVar1IsNull(cjiVar);
                if (nullSafeIsEqual(cjgVar6, cjiVar)) {
                    obj = objPrevious3;
                    break;
                }
            }
            cio cioVarH3 = (cio) obj;
            if (cioVarH3 == null) {
                cji cjiVar2 = this.c;
                throwIfVar1IsNull(cjiVar2);
                cji cjiVar3 = this.c;
                throwIfVar1IsNull(cjiVar3);
                cioVarH3 = cbm.h(anrVar, cjiVar2, cjiVar3.k(bundle), ah(), this.n);
            }
            kmVar2.addFirst(cioVarH3);
        }
        for (cio cioVar3 : kmVar2) {
            Object obj2 = this.s.get(this.r.d(cioVar3.b.f));
            if (obj2 == null) {
                throw new IllegalStateException(
                        yg.concatToVar1(new StringBuilder("NavigatorBackStack for "), cjgVar.f, " should already be created")
                                .toString());
            }
            ((cit) obj2).i(cioVar3);
        }
        kmVar.addAll(kmVar2);
        kmVar.addLast(cioVar);
        for (cio cioVar4 : aaz.p(kmVar2, cioVar)) {
            cji cjiVar4 = cioVar4.b.h;
            if (cjiVar4 != null) {
                aj(cioVar4, ae(cjiVar4.g.a));
            }
        }
    }

    public final boolean ac() {
        afw[] afwVarArr;
        ArrayList arrayList = this.x;
        km kmVar = this.f;
        while (!kmVar.isEmpty() && (((cio) kmVar.last()).b instanceof cji)) {
            aa(this, (cio) kmVar.last());
        }
        cio cioVar = (cio) kmVar.j();
        if (cioVar != null) {
            arrayList.add(cioVar);
        }
        this.w++;
        ar();
        int i = this.w - 1;
        this.w = i;
        if (i == 0) {
            ArrayList<cio> arrayListAb = aaz.ab(arrayList);
            arrayList.clear();
            for (cio cioVar2 : arrayListAb) {
                Iterator it = aaz.z(this.o).iterator();
                if (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    cjg cjgVar = cioVar2.b;
                    cioVar2.h.l();
                    throw null;
                }
                dhb dhbVar = this.y;
                afw[] afwVarArr2 = bhs.e;
                synchronized (dhbVar) {
                    int i2 = dhbVar.g;
                    Object[] objArrI = dhbVar.a;
                    if (objArrI == null) {
                        objArrI = dhbVar.i(null, 0, 2);
                    } else if (i2 >= objArrI.length) {
                        objArrI = dhbVar.i(objArrI, i2, objArrI.length * 2);
                    }
                    objArrI[((int) (dhbVar.h() + ((long) i2))) & (objArrI.length - 1)] = cioVar2;
                    int i3 = dhbVar.g + 1;
                    dhbVar.g = i3;
                    if (i3 > 1) {
                        Object[] objArr = dhbVar.a;
                        throwIfVar1IsNull(objArr);
                        objArr[((int) dhbVar.h()) & (objArr.length - 1)] = null;
                        dhbVar.g--;
                        long jH = dhbVar.h() + 1;
                        if (dhbVar.b < jH) {
                            dhbVar.b = jH;
                        }
                        if (dhbVar.c < jH) {
                            dhbVar.c = jH;
                        }
                    }
                    dhbVar.c = dhbVar.h() + ((long) dhbVar.g);
                    afwVarArr = afwVarArr2;
                }
                for (afw afwVar : afwVarArr) {
                    if (afwVar != null) {
                        afwVar._bn(KotlinUnit.INSTANCE);
                    }
                }
            }
            this.g.g(aaz.ab(kmVar));
            this.h.g(an());
        }
        return cioVar != null;
    }

    public final cjg ad(int i, cjg cjgVar) {
        cjg cjgVar2;
        cji cjiVar = this.c;
        if (cjiVar == null) {
            return null;
        }
        if (cjiVar.g.a == i) {
            if (cjgVar == null) {
                return cjiVar;
            }
            if (nullSafeIsEqual(cjiVar, cjgVar) && cjgVar.h == null) {
                return this.c;
            }
        }
        cio cioVar = (cio) this.f.j();
        if (cioVar == null || (cjgVar2 = cioVar.b) == null) {
            cjgVar2 = this.c;
            throwIfVar1IsNull(cjgVar2);
        }
        return z(i, cjgVar2, cjgVar, false);
    }

    public final cio ae(int i) {
        Object objPrevious;
        km kmVar = this.f;
        ListIterator<E> listIterator = kmVar.listIterator(kmVar.size());
        do {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            }
            objPrevious = listIterator.previous();
        } while (((cio) objPrevious).b.g.a != i);
        cio cioVar = (cio) objPrevious;
        if (cioVar != null) {
            return cioVar;
        }
        StringBuilder sbR = yg.concatVar213(i, "No destination with ID ",
                " is on the NavController's back stack. The current destination is ");
        sbR.append(af());
        throw new IllegalArgumentException(sbR.toString().toString());
    }

    public final cjg af() {
        cio cioVar = (cio) this.f.j();
        if (cioVar != null) {
            return cioVar.b;
        }
        return null;
    }

    public final cji ag() {
        cji cjiVar = this.c;
        if (cjiVar == null) {
            throw new IllegalStateException("You must call setGraph() before calling getGraph()");
        }
        throwIfVar1IsNull(cjiVar, "null cannot be cast to non-null type androidx.navigation.NavGraph");
        return cjiVar;
    }

    public final buh ah() {
        return this.m == null ? buh.c : this.p;
    }

    public final cji ai() {
        cjg cjgVar;
        cio cioVar = (cio) this.f.j();
        if (cioVar == null || (cjgVar = cioVar.b) == null) {
            cjgVar = this.c;
            throwIfVar1IsNull(cjgVar);
        }
        cji cjiVar = cjgVar instanceof cji ? (cji) cjgVar : null;
        if (cjiVar != null) {
            return cjiVar;
        }
        cji cjiVar2 = cjgVar.h;
        throwIfVar1IsNull(cjiVar2);
        return cjiVar2;
    }

    public final void aj(cio cioVar, cio cioVar2) {
        this.i.put(cioVar, cioVar2);
        LinkedHashMap linkedHashMap = this.j;
        if (linkedHashMap.get(cioVar2) == null) {
            linkedHashMap.put(cioVar2, new lp());
        }
        Object obj = linkedHashMap.get(cioVar2);
        throwIfVar1IsNull(obj);
        ((lp) obj).a.incrementAndGet();
    }

    /* JADX WARN: Found duplicated region for block: B:11:0x003c */
    /* JADX WARN: Found duplicated region for block: B:19:0x0061 */
    /* JADX WARN: Found duplicated region for block: B:49:0x0107 */
    /*
     * JADX WARN: Found duplicated region for block: B:52:0x0112 A[LOOP:4:
     * B:50:0x010c->B:52:0x0112, LOOP_END, MOVE_INLINED]
     */
    /* JADX WARN: Found duplicated region for block: B:56:0x0171 */
    /* JADX WARN: Found duplicated region for block: B:58:0x017d */
    /*
     * JADX WARN: Found duplicated region for block: B:63:0x0196 A[LOOP:6:
     * B:61:0x0190->B:63:0x0196, LOOP_END]
     */
    /* JADX WARN: Found duplicated region for block: B:65:0x01ab */
    /* JADX WARN: Found duplicated region for block: B:67:0x01b1 A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:68:0x01db */
    /* JADX WARN: Found duplicated region for block: B:91:0x0188 A[SYNTHETIC] */
    public final void ak(cjg cjgVar, Bundle bundle, cjo cjoVar) {
        boolean zAl;
        ckm ckmVar;
        dag dagVar;
        boolean z;
        int iNextIndex;
        cjg cjgVar2;
        km<cio> kmVar;
        cji cjiVar;
        throwIfVar1IsNull(cjgVar, "node");
        ea eaVar = cjgVar.g;
        LinkedHashMap linkedHashMap = this.s;
        Iterator it = linkedHashMap.values().iterator();
        while (it.hasNext()) {
            ((cit) it.next()).d = true;
        }
        dag dagVar2 = new dag();
        if (cjoVar != null) {
            boolean z2 = cjoVar.e;
            boolean z3 = cjoVar.d;
            int i = cjoVar.c;
            zAl = i != -1 ? al(i, z3, z2) : false;
        }
        Bundle bundleK = cjgVar.k(bundle);
        if (cjoVar == null || !cjoVar.b) {
            ckmVar = this.r;
            if (cjoVar == null && cjoVar.a) {
                km kmVar2 = this.f;
                cio cioVar = (cio) kmVar2.j();
                ListIterator listIterator = kmVar2.listIterator(kmVar2.a());
                while (true) {
                    if (listIterator.hasPrevious()) {
                        if (((cio) listIterator.previous()).b == cjgVar) {
                            iNextIndex = listIterator.nextIndex();
                            break;
                        }
                    } else {
                        iNextIndex = -1;
                        break;
                    }
                }
                if (iNextIndex == -1) {
                    dagVar = dagVar2;
                    z = false;
                } else if (cjgVar instanceof cji) {
                    int i2 = cji.a;
                    List listAk = dfv.ak(new dpu(dfv.ai((cji) cjgVar, new cgu(20)), new cgu(15), 1));
                    if (kmVar2.f - iNextIndex == listAk.size()) {
                        List listSubList = kmVar2.subList(iNextIndex, kmVar2.f);
                        ArrayList arrayList = new ArrayList(abb.ak(listSubList, 10));
                        Iterator it2 = listSubList.iterator();
                        while (it2.hasNext()) {
                            arrayList.add(Integer.valueOf(((cio) it2.next()).b.g.a));
                        }
                        if (arrayList.equals(listAk)) {
                            kmVar = new km();
                            while (OtherStaticHelpers.af(kmVar2) >= iNextIndex) {
                                cio cioVar2 = (cio) abf.ar(kmVar2);
                                aq(cioVar2);
                                dag dagVar3 = dagVar2;
                                cio cioVar3 = new cio(cioVar2.a, cioVar2.b, cioVar2.b.k(bundle), cioVar2.d, cioVar2.e,
                                        cioVar2.f, cioVar2.g);
                                buh buhVar = cioVar2.d;
                                ciq ciqVar = cioVar3.h;
                                ciqVar.getClass();
                                throwIfVar1IsNull(buhVar, "<set-?>");
                                ciqVar.d = buhVar;
                                buh buhVar2 = cioVar2.h.k;
                                throwIfVar1IsNull(buhVar2, "maxState");
                                ciqVar.k = buhVar2;
                                ciqVar.m();
                                kmVar.addFirst(cioVar3);
                                dagVar2 = dagVar3;
                            }
                            dagVar = dagVar2;
                            for (cio cioVar4 : kmVar) {
                                cjiVar = cioVar4.b.h;
                                if (cjiVar != null) {
                                    aj(cioVar4, ae(cjiVar.g.a));
                                }
                                kmVar2.addLast(cioVar4);
                            }
                            for (cio cioVar5 : kmVar) {
                                ckmVar.d(cioVar5.b.f).k(cioVar5);
                            }
                            z = true;
                        }
                    }
                    dagVar = dagVar2;
                    z = false;
                } else if (cioVar == null || (cjgVar2 = cioVar.b) == null || eaVar.a != cjgVar2.g.a) {
                    dagVar = dagVar2;
                    z = false;
                } else {
                    kmVar = new km();
                    while (OtherStaticHelpers.af(kmVar2) >= iNextIndex) {
                        cio cioVar22 = (cio) abf.ar(kmVar2);
                        aq(cioVar22);
                        dag dagVar32 = dagVar2;
                        cio cioVar32 = new cio(cioVar22.a, cioVar22.b, cioVar22.b.k(bundle), cioVar22.d, cioVar22.e,
                                cioVar22.f, cioVar22.g);
                        buh buhVar3 = cioVar22.d;
                        ciq ciqVar2 = cioVar32.h;
                        ciqVar2.getClass();
                        throwIfVar1IsNull(buhVar3, "<set-?>");
                        ciqVar2.d = buhVar3;
                        buh buhVar22 = cioVar22.h.k;
                        throwIfVar1IsNull(buhVar22, "maxState");
                        ciqVar2.k = buhVar22;
                        ciqVar2.m();
                        kmVar.addFirst(cioVar32);
                        dagVar2 = dagVar32;
                    }
                    dagVar = dagVar2;
                    while (r1.hasNext()) {
                        cjiVar = cioVar4.b.h;
                        if (cjiVar != null) {
                            aj(cioVar4, ae(cjiVar.g.a));
                        }
                        kmVar2.addLast(cioVar4);
                    }
                    while (r0.hasNext()) {
                        ckmVar.d(cioVar5.b.f).k(cioVar5);
                    }
                    z = true;
                }
            } else {
                dagVar = dagVar2;
                z = false;
            }
            if (z) {
                dagVar2 = dagVar;
            } else {
                cio cioVarH = cbm.h(this.a.c, cjgVar, bundleK, ah(), this.n);
                ckl cklVarD = ckmVar.d(cjgVar.f);
                List listBf = dqc.toSingletonList(cioVarH);
                dagVar2 = dagVar;
                this.t = new cbj(dagVar2, this, cjgVar, bundleK, 1);
                cklVarD.i(listBf, cjoVar);
                this.t = null;
            }
        } else if (this.k.containsKey(Integer.valueOf(eaVar.a))) {
            dagVar2.a = ao(eaVar.a, bundleK, cjoVar);
            z = false;
        } else {
            ckmVar = this.r;
            if (cjoVar == null) {
                dagVar = dagVar2;
                z = false;
            } else {
                dagVar = dagVar2;
                z = false;
            }
            if (z) {
                cio cioVarH2 = cbm.h(this.a.c, cjgVar, bundleK, ah(), this.n);
                ckl cklVarD2 = ckmVar.d(cjgVar.f);
                List listBf2 = dqc.toSingletonList(cioVarH2);
                dagVar2 = dagVar;
                this.t = new cbj(dagVar2, this, cjgVar, bundleK, 1);
                cklVarD2.i(listBf2, cjoVar);
                this.t = null;
            } else {
                dagVar2 = dagVar;
            }
        }
        this.b.invoke();
        Iterator it3 = linkedHashMap.values().iterator();
        while (it3.hasNext()) {
            ((cit) it3.next()).d = false;
        }
        if (zAl || dagVar2.a || z) {
            ac();
        } else {
            ar();
        }
    }

    public final boolean al(int i, boolean z, boolean z2) {
        cjg cjgVar;
        cix cixVar;
        boolean z3;
        ea eaVar;
        km kmVar = this.f;
        final int i2 = 0;
        if (kmVar.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = aaz.r(kmVar).iterator();
        do {
            if (!it.hasNext()) {
                cjgVar = null;
                break;
            }
            cjgVar = ((cio) it.next()).b;
            String str = cjgVar.f;
            eaVar = cjgVar.g;
            ckl cklVarD = this.r.d(str);
            if (z || eaVar.a != i) {
                arrayList.add(cklVarD);
            }
        } while (eaVar.a != i);
        if (cjgVar == null) {
            int i3 = cjg.e;
            String str2 = "Ignoring popBackStack to destination " + bmy.r(this.a.c, i)
                    + " as it was not found on the current back stack";
            throwIfVar1IsNull(str2, "message");
            Log.i("NavController", str2);
            return false;
        }
        dag dagVar = new dag();
        km kmVar2 = new km();
        Iterator it2 = arrayList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                cixVar = this;
                z3 = z2;
                break;
            }
            ckl cklVar = (ckl) it2.next();
            dag dagVar2 = new dag();
            cio cioVar = (cio) kmVar.last();
            cixVar = this;
            z3 = z2;
            ciu ciuVar = new ciu(dagVar2, dagVar, cixVar, z3, kmVar2);
            throwIfVar1IsNull(cklVar, "navigator");
            throwIfVar1IsNull(cioVar, "popUpTo");
            cixVar.u = ciuVar;
            cklVar.l(cioVar, z3);
            cixVar.u = null;
            if (!dagVar2.a) {
                break;
            }
            z2 = z3;
        }
        if (z3) {
            LinkedHashMap linkedHashMap = cixVar.k;
            if (!z) {
                baa baaVar = new baa(new dpu(dfv.ai(cjgVar, new cgu(13)), new bgf(this) { // from class:
                                                                                          // me.hd.wauxv.obf.civ
                    public final /* synthetic */ cix b;

                    {
                        this.b = this;
                    }

                    @Override // me.hd.wauxv.obf.bgf
                    public final Object invoke(Object obj) {
                        boolean zContainsKey;
                        cjg cjgVar2 = (cjg) obj;
                        switch (i2) {
                            case 0:
                                throwIfVar1IsNull(cjgVar2, "destination");
                                zContainsKey = this.b.k.containsKey(Integer.valueOf(cjgVar2.g.a));
                                break;
                            default:
                                throwIfVar1IsNull(cjgVar2, "destination");
                                zContainsKey = this.b.k.containsKey(Integer.valueOf(cjgVar2.g.a));
                                break;
                        }
                        return Boolean.valueOf(!zContainsKey);
                    }
                }, 0));
                while (baaVar.hasNext()) {
                    Integer numValueOf = Integer.valueOf(((cjg) baaVar.next()).g.a);
                    cir cirVar = (cir) (kmVar2.isEmpty() ? null : kmVar2.e[kmVar2.d]);
                    linkedHashMap.put(numValueOf, cirVar != null ? (String) cirVar.a.d : null);
                }
            }
            if (!kmVar2.isEmpty()) {
                xe xeVar = ((cir) kmVar2.first()).a;
                final int i4 = 1;
                baa baaVar2 = new baa(new dpu(dfv.ai(ad(xeVar.c, null), new cgu(14)), new bgf(this) { // from class:
                                                                                                      // me.hd.wauxv.obf.civ
                    public final /* synthetic */ cix b;

                    {
                        this.b = this;
                    }

                    @Override // me.hd.wauxv.obf.bgf
                    public final Object invoke(Object obj) {
                        boolean zContainsKey;
                        cjg cjgVar2 = (cjg) obj;
                        switch (i4) {
                            case 0:
                                throwIfVar1IsNull(cjgVar2, "destination");
                                zContainsKey = this.b.k.containsKey(Integer.valueOf(cjgVar2.g.a));
                                break;
                            default:
                                throwIfVar1IsNull(cjgVar2, "destination");
                                zContainsKey = this.b.k.containsKey(Integer.valueOf(cjgVar2.g.a));
                                break;
                        }
                        return Boolean.valueOf(!zContainsKey);
                    }
                }, 0));
                while (baaVar2.hasNext()) {
                    linkedHashMap.put(Integer.valueOf(((cjg) baaVar2.next()).g.a), (String) xeVar.d);
                }
                if (linkedHashMap.values().contains((String) xeVar.d)) {
                    cixVar.l.put((String) xeVar.d, kmVar2);
                }
            }
        }
        cixVar.b.invoke();
        return dagVar.a;
    }

    public final void am(cio cioVar, boolean z, km kmVar) {
        ciy ciyVar;
        bmu bmuVar;
        Set set;
        throwIfVar1IsNull(cioVar, "popUpTo");
        km kmVar2 = this.f;
        cio cioVar2 = (cio) kmVar2.last();
        if (!nullSafeIsEqual(cioVar2, cioVar)) {
            throw new IllegalStateException(
                    ("Attempted to pop " + cioVar.b + ", which is not the top of the back stack (" + cioVar2.b + ')')
                            .toString());
        }
        abf.ar(kmVar2);
        cit citVar = (cit) this.s.get(this.r.d(cioVar2.b.f));
        boolean z2 = true;
        if ((citVar == null || (bmuVar = citVar.f) == null || (set = (Set) ((dml) bmuVar.h).c()) == null
                || !set.contains(cioVar2)) && !this.j.containsKey(cioVar2)) {
            z2 = false;
        }
        buh buhVar = cioVar2.h.j.c;
        buh buhVar2 = buh.c;
        if (buhVar.compareTo(buhVar2) >= 0) {
            if (z) {
                cioVar2.i(buhVar2);
                kmVar.addFirst(new cir(cioVar2));
            }
            if (z2) {
                cioVar2.i(buhVar2);
            } else {
                cioVar2.i(buh.a);
                aq(cioVar2);
            }
        }
        if (z || z2 || (ciyVar = this.n) == null) {
            return;
        }
        String str = cioVar2.f;
        throwIfVar1IsNull(str, "backStackEntryId");
        erq erqVar = (erq) ciyVar.a.remove(str);
        if (erqVar != null) {
            erqVar.b();
        }
    }

    public final ArrayList an() {
        buh buhVar;
        ArrayList arrayList = new ArrayList();
        Iterator it = this.s.values().iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            buhVar = buh.d;
            if (!zHasNext) {
                break;
            }
            Iterable iterable = (Iterable) ((dml) ((cit) it.next()).f.h).c();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : iterable) {
                cio cioVar = (cio) obj;
                if (!arrayList.contains(cioVar) && cioVar.h.k.compareTo(buhVar) < 0) {
                    arrayList2.add(obj);
                }
            }
            abf.an(arrayList, arrayList2);
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : this.f) {
            cio cioVar2 = (cio) obj2;
            if (!arrayList.contains(cioVar2) && cioVar2.h.k.compareTo(buhVar) >= 0) {
                arrayList3.add(obj2);
            }
        }
        abf.an(arrayList, arrayList3);
        ArrayList arrayList4 = new ArrayList();
        for (Object obj3 : arrayList) {
            if (!(((cio) obj3).b instanceof cji)) {
                arrayList4.add(obj3);
            }
        }
        return arrayList4;
    }

    public final boolean ao(int i, final Bundle bundle, cjo cjoVar) {
        cjg cjgVarAg;
        cio cioVar;
        cjg cjgVar;
        Bundle bundle2;
        Integer numValueOf = Integer.valueOf(i);
        LinkedHashMap linkedHashMap = this.k;
        if (!linkedHashMap.containsKey(numValueOf)) {
            return false;
        }
        String str = (String) linkedHashMap.get(Integer.valueOf(i));
        Collection collectionValues = linkedHashMap.values();
        throwIfVar1IsNull(collectionValues, "<this>");
        Iterator it = collectionValues.iterator();
        while (it.hasNext()) {
            if (nullSafeIsEqual((String) it.next(), str)) {
                it.remove();
            }
        }
        LinkedHashMap linkedHashMap2 = this.l;
        emc.ae(linkedHashMap2);
        km<cir> kmVar = (km) linkedHashMap2.remove(str);
        anr anrVar = this.a.c;
        final ArrayList arrayList = new ArrayList();
        cio cioVar2 = (cio) this.f.j();
        if (cioVar2 == null || (cjgVarAg = cioVar2.b) == null) {
            cjgVarAg = ag();
        }
        if (kmVar != null) {
            for (cir cirVar : kmVar) {
                xe xeVar = cirVar.a;
                xe xeVar2 = cirVar.a;
                cjg cjgVarZ = z(xeVar.c, cjgVarAg, null, true);
                if (cjgVarZ == null) {
                    int i2 = cjg.e;
                    throw new IllegalStateException(("Restore State failed: destination " + bmy.r(anrVar, xeVar2.c)
                            + " cannot be found from the current destination " + cjgVarAg).toString());
                }
                buh buhVarAh = ah();
                ciy ciyVar = this.n;
                throwIfVar1IsNull(anrVar, "context");
                throwIfVar1IsNull(buhVarAh, "hostLifecycleState");
                Bundle bundle3 = (Bundle) xeVar2.e;
                if (bundle3 != null) {
                    bundle3.setClassLoader(anrVar.b.getClassLoader());
                    bundle2 = bundle3;
                } else {
                    bundle2 = null;
                }
                String str2 = (String) xeVar2.d;
                Bundle bundle4 = (Bundle) xeVar2.f;
                throwIfVar1IsNull(str2, "id");
                arrayList.add(new cio(anrVar, cjgVarZ, bundle2, buhVarAh, ciyVar, str2, bundle4));
                cjgVarAg = cjgVarZ;
            }
        }
        ArrayList<List> arrayList2 = new ArrayList();
        ArrayList<cio> arrayList3 = new ArrayList();
        for (Object obj : arrayList) {
            if (!(((cio) obj).b instanceof cji)) {
                arrayList3.add(obj);
            }
        }
        for (cio cioVar3 : arrayList3) {
            List list = (List) aaz.m(arrayList2);
            if (nullSafeIsEqual(
                    (list == null || (cioVar = (cio) aaz.l(list)) == null || (cjgVar = cioVar.b) == null) ? null
                            : cjgVar.f,
                    cioVar3.b.f)) {
                list.add(cioVar3);
            } else {
                arrayList2.add(OtherStaticHelpers.ah(cioVar3));
            }
        }
        final dag dagVar = new dag();
        for (List list2 : arrayList2) {
            ckl cklVarD = this.r.d(((cio) aaz.e(list2)).b.f);
            final dah dahVar = new dah();
            this.t = new bgf() { // from class: me.hd.wauxv.obf.ciw
                @Override // me.hd.wauxv.obf.bgf
                public final Object invoke(Object obj2) {
                    List listSubList;
                    cio cioVar4 = (cio) obj2;
                    throwIfVar1IsNull(cioVar4, "entry");
                    dagVar.a = true;
                    ArrayList arrayList4 = arrayList;
                    int iIndexOf = arrayList4.indexOf(cioVar4);
                    if (iIndexOf != -1) {
                        dah dahVar2 = dahVar;
                        int i3 = iIndexOf + 1;
                        listSubList = arrayList4.subList(dahVar2.a, i3);
                        dahVar2.a = i3;
                    } else {
                        listSubList = EmptyReadonlyList.a;
                    }
                    this.ab(cioVar4.b, bundle, cioVar4, listSubList);
                    return KotlinUnit.INSTANCE;
                }
            };
            cklVarD.i(list2, cjoVar);
            this.t = null;
        }
        return dagVar.a;
    }

    /* JADX WARN: Found duplicated region for block: B:132:0x02f9 */
    /* JADX WARN: Found duplicated region for block: B:134:0x02fd */
    /* JADX WARN: Found duplicated region for block: B:136:0x0308 */
    /* JADX WARN: Found duplicated region for block: B:137:0x030b */
    /* JADX WARN: Found duplicated region for block: B:138:0x030d */
    /* JADX WARN: Found duplicated region for block: B:141:0x0321 */
    /* JADX WARN: Found duplicated region for block: B:153:0x034c */
    /* JADX WARN: Found duplicated region for block: B:154:0x036c */
    /* JADX WARN: Found duplicated region for block: B:156:0x0377 */
    /* JADX WARN: Found duplicated region for block: B:173:0x03da */
    /* JADX WARN: Found duplicated region for block: B:174:0x03dd */
    /* JADX WARN: Found duplicated region for block: B:177:0x03e2 */
    /* JADX WARN: Found duplicated region for block: B:179:0x03ea */
    /* JADX WARN: Found duplicated region for block: B:180:0x03fa */
    /* JADX WARN: Found duplicated region for block: B:183:0x03fe */
    /*
     * JADX WARN: Found duplicated region for block: B:185:0x040b A[LOOP:10:
     * B:181:0x03fb->B:185:0x040b, LOOP_END]
     */
    /* JADX WARN: Found duplicated region for block: B:189:0x043a */
    /* JADX WARN: Found duplicated region for block: B:191:0x0440 */
    /* JADX WARN: Found duplicated region for block: B:193:0x0446 */
    /* JADX WARN: Found duplicated region for block: B:194:0x0449 */
    /* JADX WARN: Found duplicated region for block: B:196:0x0452 */
    /* JADX WARN: Found duplicated region for block: B:198:0x0459 */
    /*
     * JADX WARN: Found duplicated region for block: B:201:0x045f A[LOOP:12:
     * B:201:0x045f->B:203:0x046e, LOOP_START, PHI: r11
     * 0x045f: PHI (r11v6 me.hd.wauxv.obf.cjg) = (r11v5 me.hd.wauxv.obf.cjg), (r11v8
     * me.hd.wauxv.obf.cjg) binds: [B:199:0x045b, B:203:0x046e] A[DONT_GENERATE,
     * DONT_INLINE]]
     */
    /*
     * JADX WARN: Found duplicated region for block: B:203:0x046e A[LOOP:12:
     * B:201:0x045f->B:203:0x046e, LOOP_END]
     */
    /* JADX WARN: Found duplicated region for block: B:205:0x047a A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:268:0x0349 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:269:0x0316 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:279:0x041a A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:281:0x04a2 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:284:0x049f A[SYNTHETIC] */
    /*
     * JADX WARN: Found duplicated region for block: B:286:0x0478 A[EDGE_INSN:
     * B:286:0x0478->B:204:0x0478 BREAK A[LOOP:12: B:201:0x045f->B:203:0x046e],
     * SYNTHETIC]
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r20v1, types: [android.os.Bundle[]] */
    /* JADX WARN: Type inference failed for: r20v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r20v3, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r20v4, types: [java.lang.Throwable] */
    /*
     * JADX WARN: Type inference failed for: r5v16, types: [me.hd.wauxv.obf.cjg,
     * me.hd.wauxv.obf.cji]
     */
    public final void ap(cji cjiVar, Bundle bundle) {
        boolean z;
        ckm ckmVar;
        String str;
        Intent intent;
        int[] intArray;
        int[] iArr;
        int[] iArr2;
        cji cjiVar2;
        int length;
        int i;
        String strR;
        int length2;
        Bundle[] bundleArr;
        int i2;
        int i3;
        int i4;
        cji cjiVar3;
        int length3;
        int i5;
        Bundle bundle2;
        cjg cjgVarP;
        cji cjiVar4;
        xe xeVar;
        int i6;
        int i7;
        int i8;
        Bundle bundle3;
        cjg cjgVarAd;
        Bundle bundle4;
        int i9;
        cjg cjgVarP2;
        cji cjiVar5;
        xe xeVar2 = cjiVar.b;
        km<cio> kmVar = this.f;
        if (!kmVar.isEmpty() && ah() == buh.a) {
            throw new IllegalStateException("You cannot set a new graph on a NavController with entries on the back stack after the NavController has been destroyed. Please ensure that your NavHost has the same lifetime as your NavController.");
        }
        boolean z2 = true;
        if (nullSafeIsEqual(this.c, cjiVar)) {
            int i10 = ((dlo) xeVar2.e).i();
            for (int i11 = 0; i11 < i10; i11++) {
                cjg cjgVar = (cjg) ((dlo) xeVar2.e).j(i11);
                cji cjiVar6 = this.c;
                throwIfVar1IsNull(cjiVar6);
                int iG = ((dlo) cjiVar6.b.e).g(i11);
                cji cjiVar7 = this.c;
                throwIfVar1IsNull(cjiVar7);
                dlo dloVar = (dlo) cjiVar7.b.e;
                if (dloVar.a) {
                    bht.q(dloVar);
                }
                int i12 = KotlinHelpers.i(dloVar.b, dloVar.d, iG);
                if (i12 >= 0) {
                    Object[] objArr = dloVar.c;
                    Object obj = objArr[i12];
                    objArr[i12] = cjgVar;
                }
            }
            for (cio cioVar : kmVar) {
                int i13 = cjg.e;
                cjg cjgVar2 = cioVar.b;
                throwIfVar1IsNull(cjgVar2, "<this>");
                bzv bzvVar = new bzv(dfv.ak(dfv.ai(cjgVar2, new cgu(19))), 1);
                cjg cjgVarP3 = this.c;
                throwIfVar1IsNull(cjgVarP3);
                Iterator it = bzvVar.iterator();
                while (true) {
                    ListIterator listIterator = ((dcz) it).a;
                    if (listIterator.hasPrevious()) {
                        cjg cjgVar3 = (cjg) listIterator.previous();
                        if (!nullSafeIsEqual(cjgVar3, this.c) || !nullSafeIsEqual(cjgVarP3, cjiVar)) {
                            if (cjgVarP3 instanceof cji) {
                                cjgVarP3 = ((cji) cjgVarP3).p(cjgVar3.g.a);
                                throwIfVar1IsNull(cjgVarP3);
                            }
                        }
                    }
                }
                throwIfVar1IsNull(cjgVarP3, "<set-?>");
                cioVar.b = cjgVarP3;
            }
            return;
        }
        cji cjiVar8 = this.c;
        LinkedHashMap linkedHashMap = this.s;
        cjg cjgVar4 = null;
        if (cjiVar8 != null) {
            for (Integer num : new ArrayList(this.k.keySet())) {
                throwIfVar1IsNull(num);
                int iIntValue = num.intValue();
                Iterator it2 = linkedHashMap.values().iterator();
                while (it2.hasNext()) {
                    ((cit) it2.next()).d = true;
                }
                cjp cjpVar = new cjp();
                cjpVar.c = true;
                boolean z3 = cjpVar.b;
                boolean z4 = cjpVar.c;
                int i14 = cjpVar.d;
                boolean z5 = cjpVar.e;
                cjn cjnVar = cjpVar.a;
                boolean zAo = ao(iIntValue, null, new cjo(z3, z4, i14, false, z5, cjnVar.a, cjnVar.b, -1, -1));
                Iterator it3 = linkedHashMap.values().iterator();
                while (it3.hasNext()) {
                    ((cit) it3.next()).d = false;
                }
                if (zAo) {
                    al(iIntValue, true, false);
                }
            }
            al(cjiVar8.g.a, true, false);
        }
        this.c = cjiVar;
        cjl cjlVar = this.a;
        cix cixVar = cjlVar.b;
        anr anrVar = cjlVar.c;
        Bundle bundle5 = this.d;
        ckm ckmVar2 = this.r;
        if (bundle5 != null && bundle5.containsKey("android-support-nav:controller:navigatorState:names")) {
            ArrayList<String> stringArrayList = bundle5.getStringArrayList("android-support-nav:controller:navigatorState:names");
            if (stringArrayList == null) {
                cmz.ad("android-support-nav:controller:navigatorState:names");
                throw null;
            }
            for (String str2 : stringArrayList) {
                ckl cklVarD = ckmVar2.d(str2);
                if (bundle5.containsKey(str2)) {
                    Bundle bundle6 = bundle5.getBundle(str2);
                    if (bundle6 == null) {
                        cmz.ad(str2);
                        throw null;
                    }
                    cklVarD.q(bundle6);
                }
            }
        }
        Bundle[] bundleArr2 = this.e;
        String str3 = " cannot be found from the current destination ";
        if (bundleArr2 != null) {
            int length4 = bundleArr2.length;
            int i15 = 0;
            while (i15 < length4) {
                Bundle bundle7 = bundleArr2[i15];
                throwIfVar1IsNull(bundle7, "state");
                bundle7.setClassLoader(cir.class.getClassLoader());
                boolean z6 = z2;
                String string = bundle7.getString("nav-entry-state:id");
                if (string == null) {
                    ?? r20 = cjgVar4;
                    cmz.ad("nav-entry-state:id");
                    throw r20;
                }
                int iV = KotlinHelpers.v("nav-entry-state:destination-id", bundle7);
                int i16 = length4;
                Bundle bundle8 = bundle7.getBundle("nav-entry-state:args");
                if (bundle8 == null) {
                    ?? r202 = cjgVar4;
                    cmz.ad("nav-entry-state:args");
                    throw r202;
                }
                Bundle bundle9 = bundle7.getBundle("nav-entry-state:saved-state");
                if (bundle9 == null) {
                    ?? r203 = cjgVar4;
                    cmz.ad("nav-entry-state:saved-state");
                    throw r203;
                }
                String str4 = str3;
                cjg cjgVarAd2 = ad(iV, cjgVar4);
                if (cjgVarAd2 == null) {
                    int i17 = cjg.e;
                    StringBuilder sbZ = dkz.z("Restoring the Navigation back stack failed: destination ", bmy.r(anrVar, iV), str4);
                    sbZ.append(af());
                    throw new IllegalStateException(sbZ.toString());
                }
                int i18 = i15;
                buh buhVarAh = ah();
                ciy ciyVar = this.n;
                cjg cjgVar5 = cjgVar4;
                throwIfVar1IsNull(anrVar, "context");
                throwIfVar1IsNull(buhVarAh, "hostLifecycleState");
                bundle8.setClassLoader(anrVar.b.getClassLoader());
                ckm ckmVar3 = ckmVar2;
                Bundle[] bundleArr3 = bundleArr2;
                cio cioVar2 = new cio(anrVar, cjgVarAd2, bundle8, buhVarAh, ciyVar, string, bundle9);
                ckl cklVarD2 = ckmVar3.d(cjgVarAd2.f);
                Object citVar = linkedHashMap.get(cklVarD2);
                if (citVar == null) {
                    citVar = new cit(cjlVar, cklVarD2);
                    linkedHashMap.put(cklVarD2, citVar);
                }
                kmVar.addLast(cioVar2);
                ((cit) citVar).i(cioVar2);
                cji cjiVar9 = cioVar2.b.h;
                if (cjiVar9 != null) {
                    aj(cioVar2, ae(cjiVar9.g.a));
                }
                i15 = i18 + 1;
                ckmVar2 = ckmVar3;
                length4 = i16;
                str3 = str4;
                z2 = z6;
                bundleArr2 = bundleArr3;
                cjgVar4 = cjgVar5;
            }
            z = z2;
            ?? r204 = cjgVar4;
            ckmVar = ckmVar2;
            str = str3;
            this.b.invoke();
            this.e = r204;
        } else {
            z = true;
            ckmVar = ckmVar2;
            str = " cannot be found from the current destination ";
        }
        Collection collectionValues = KotlinHelpers.at(ckmVar.b).values();
        ArrayList<ckl> arrayList = new ArrayList();
        for (Object obj2 : collectionValues) {
            if (!((ckl) obj2).v) {
                arrayList.add(obj2);
            }
        }
        for (ckl cklVar : arrayList) {
            Object citVar2 = linkedHashMap.get(cklVar);
            if (citVar2 == null) {
                throwIfVar1IsNull(cklVar, "navigator");
                citVar2 = new cit(cjlVar, cklVar);
                linkedHashMap.put(cklVar, citVar2);
            }
            cklVar.j((cit) citVar2);
        }
        if (this.c == null || !kmVar.isEmpty()) {
            ac();
            return;
        }
        Activity activity = cjlVar.d;
        if (!cjlVar.e && activity != null && (intent = activity.getIntent()) != null) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                try {
                    intArray = extras.getIntArray("android-support-nav:controller:deepLinkIds");
                } catch (Exception e) {
                    Log.e("NavController", "handleDeepLink() could not extract deepLink from " + intent, e);
                    intArray = null;
                }
            } else {
                intArray = null;
            }
            ArrayList parcelableArrayList = extras != null ? extras.getParcelableArrayList("android-support-nav:controller:deepLinkArgs") : null;
            Bundle bundleR = bht.r((Pair[]) Arrays.copyOf(new Pair[0], 0));
            Bundle bundle10 = extras != null ? extras.getBundle("android-support-nav:controller:deepLinkExtras") : null;
            if (bundle10 != null) {
                bundleR.putAll(bundle10);
            }
            if (intArray == null || intArray.length == 0) {
                ?? Ai = cixVar.ai();
                iArr = intArray;
                cjf cjfVarQ = Ai.q(new jx(intent.getData(), intent.getAction(), intent.getType(), 17), Ai);
                if (cjfVarQ != null) {
                    cjg cjgVar6 = cjfVarQ.a;
                    int[] iArrL = cjgVar6.l(null);
                    Bundle bundleK = cjgVar6.k(cjfVarQ.b);
                    if (bundleK != null) {
                        bundleR.putAll(bundleK);
                    }
                    iArr2 = iArrL;
                    parcelableArrayList = null;
                }
                if (iArr2 != null && iArr2.length != 0) {
                    cixVar.getClass();
                    cjiVar2 = cixVar.c;
                    length = iArr2.length;
                    i = 0;
                    while (true) {
                        if (i < length) {
                            strR = null;
                            break;
                        }
                        i9 = iArr2[i];
                        if (i == 0) {
                            cji cjiVar10 = cixVar.c;
                            throwIfVar1IsNull(cjiVar10);
                            cjgVarP2 = cjiVar10.g.a == i9 ? cixVar.c : null;
                        } else {
                            throwIfVar1IsNull(cjiVar2);
                            cjgVarP2 = cjiVar2.p(i9);
                        }
                        if (cjgVarP2 == null) {
                            int i19 = cjg.e;
                            strR = bmy.r(cixVar.a.c, i9);
                            break;
                        }
                        if (i == iArr2.length - 1 && (cjgVarP2 instanceof cji)) {
                            while (true) {
                                cjiVar5 = (cji) cjgVarP2;
                                throwIfVar1IsNull(cjiVar5);
                                xe xeVar3 = cjiVar5.b;
                                if (!(cjiVar5.p(xeVar3.c) instanceof cji)) {
                                    break;
                                } else {
                                    cjgVarP2 = cjiVar5.p(xeVar3.c);
                                }
                            }
                            cjiVar2 = cjiVar5;
                        }
                        i++;
                    }
                    if (strR != null) {
                        bundleR.putParcelable("android-support-nav:controller:deepLinkIntent", intent);
                        length2 = iArr2.length;
                        bundleArr = new Bundle[length2];
                        for (i2 = 0; i2 < length2; i2++) {
                            Bundle bundleR2 = bht.r((Pair[]) Arrays.copyOf(new Pair[0], 0));
                            bundleR2.putAll(bundleR);
                            if (parcelableArrayList == null && (bundle4 = (Bundle) parcelableArrayList.get(i2)) != null) {
                                bundleR2.putAll(bundle4);
                            }
                            bundleArr[i2] = bundleR2;
                        }
                        int flags = intent.getFlags();
                        i3 = 268435456 & flags;
                        if (i3 == 0 && (flags & 32768) == 0) {
                            intent.addFlags(32768);
                            dqa dqaVar = new dqa(cjlVar.a);
                            ComponentName component = intent.getComponent();
                            if (component == null) {
                                component = intent.resolveActivity(dqaVar.b.getPackageManager());
                            }
                            if (component != null) {
                                dqaVar.c(component);
                            }
                            dqaVar.a.add(intent);
                            dqaVar.d();
                            activity.finish();
                            activity.overridePendingTransition(0, 0);
                            return;
                        }
                        if (i3 != 0 ? z : false) {
                            if (cixVar.f.isEmpty()) {
                                i6 = 0;
                            } else {
                                cji cjiVar11 = cixVar.c;
                                throwIfVar1IsNull(cjiVar11);
                                i6 = 0;
                                cixVar.al(cjiVar11.g.a, z, false);
                            }
                            while (i6 < iArr2.length) {
                                i7 = iArr2[i6];
                                i8 = i6 + 1;
                                bundle3 = bundleArr[i6];
                                cjgVarAd = cixVar.ad(i7, null);
                                if (cjgVarAd != null) {
                                    int i20 = cjg.e;
                                    StringBuilder sbZ2 = dkz.z("Deep Linking failed: destination ", bmy.r(anrVar, i7), str);
                                    sbZ2.append(cixVar.af());
                                    throw new IllegalStateException(sbZ2.toString());
                                }
                                cixVar.ak(cjgVarAd, bundle3, cmz.ah(new bka(cjgVarAd, 2, cjlVar)));
                                i6 = i8;
                            }
                            cjlVar.e = true;
                            return;
                        }
                        cjiVar3 = cixVar.c;
                        length3 = iArr2.length;
                        for (i4 = 0; i4 < length3; i4++) {
                            i5 = iArr2[i4];
                            bundle2 = bundleArr[i4];
                            if (i4 == 0) {
                                cjgVarP = cixVar.c;
                            } else {
                                throwIfVar1IsNull(cjiVar3);
                                cjgVarP = cjiVar3.p(i5);
                            }
                            if (cjgVarP != null) {
                                int i21 = cjg.e;
                                throw new IllegalStateException("Deep Linking failed: destination " + bmy.r(anrVar, i5) + " cannot be found in graph " + cjiVar3);
                            }
                            if (i4 != iArr2.length - 1) {
                                cji cjiVar12 = cixVar.c;
                                throwIfVar1IsNull(cjiVar12);
                                cixVar.ak(cjgVarP, bundle2, new cjo(false, false, cjiVar12.g.a, true, false, 0, 0, -1, -1));
                            } else if (cjgVarP instanceof cji) {
                                while (true) {
                                    cjiVar4 = (cji) cjgVarP;
                                    throwIfVar1IsNull(cjiVar4);
                                    xeVar = cjiVar4.b;
                                    if (cjiVar4.p(xeVar.c) instanceof cji) {
                                        break;
                                    } else {
                                        cjgVarP = cjiVar4.p(xeVar.c);
                                    }
                                }
                                cjiVar3 = cjiVar4;
                            }
                        }
                        cjlVar.e = true;
                        return;
                    }
                    String str5 = "Could not find destination " + strR + " in the navigation graph, ignoring the deep link from " + intent;
                    throwIfVar1IsNull(str5, "message");
                    Log.i("NavController", str5);
                }
            } else {
                iArr = intArray;
            }
            iArr2 = iArr;
            if (iArr2 != null) {
                cixVar.getClass();
                cjiVar2 = cixVar.c;
                length = iArr2.length;
                i = 0;
                while (true) {
                    if (i < length) {
                        strR = null;
                        break;
                    }
                    i9 = iArr2[i];
                    if (i == 0) {
                        cji cjiVar102 = cixVar.c;
                        throwIfVar1IsNull(cjiVar102);
                        if (cjiVar102.g.a == i9) {
                        }
                    } else {
                        throwIfVar1IsNull(cjiVar2);
                        cjgVarP2 = cjiVar2.p(i9);
                    }
                    if (cjgVarP2 == null) {
                        int i192 = cjg.e;
                        strR = bmy.r(cixVar.a.c, i9);
                        break;
                    } else {
                        if (i == iArr2.length - 1) {
                        }
                        i++;
                    }
                }
                if (strR != null) {
                    bundleR.putParcelable("android-support-nav:controller:deepLinkIntent", intent);
                    length2 = iArr2.length;
                    bundleArr = new Bundle[length2];
                    while (i2 < length2) {
                        Bundle bundleR22 = bht.r((Pair[]) Arrays.copyOf(new Pair[0], 0));
                        bundleR22.putAll(bundleR);
                        if (parcelableArrayList == null) {
                        }
                        bundleArr[i2] = bundleR22;
                    }
                    int flags2 = intent.getFlags();
                    i3 = 268435456 & flags2;
                    if (i3 == 0) {
                    }
                    if (i3 != 0 ? z : false) {
                        if (cixVar.f.isEmpty()) {
                            cji cjiVar112 = cixVar.c;
                            throwIfVar1IsNull(cjiVar112);
                            i6 = 0;
                            cixVar.al(cjiVar112.g.a, z, false);
                        } else {
                            i6 = 0;
                        }
                        while (i6 < iArr2.length) {
                            i7 = iArr2[i6];
                            i8 = i6 + 1;
                            bundle3 = bundleArr[i6];
                            cjgVarAd = cixVar.ad(i7, null);
                            if (cjgVarAd != null) {
                                int i202 = cjg.e;
                                StringBuilder sbZ22 = dkz.z("Deep Linking failed: destination ", bmy.r(anrVar, i7), str);
                                sbZ22.append(cixVar.af());
                                throw new IllegalStateException(sbZ22.toString());
                            }
                            cixVar.ak(cjgVarAd, bundle3, cmz.ah(new bka(cjgVarAd, 2, cjlVar)));
                            i6 = i8;
                        }
                        cjlVar.e = true;
                        return;
                    }
                    cjiVar3 = cixVar.c;
                    length3 = iArr2.length;
                    while (i4 < length3) {
                        i5 = iArr2[i4];
                        bundle2 = bundleArr[i4];
                        if (i4 == 0) {
                            cjgVarP = cixVar.c;
                        } else {
                            throwIfVar1IsNull(cjiVar3);
                            cjgVarP = cjiVar3.p(i5);
                        }
                        if (cjgVarP != null) {
                            int i212 = cjg.e;
                            throw new IllegalStateException("Deep Linking failed: destination " + bmy.r(anrVar, i5) + " cannot be found in graph " + cjiVar3);
                        }
                        if (i4 != iArr2.length - 1) {
                            cji cjiVar122 = cixVar.c;
                            throwIfVar1IsNull(cjiVar122);
                            cixVar.ak(cjgVarP, bundle2, new cjo(false, false, cjiVar122.g.a, true, false, 0, 0, -1, -1));
                        } else if (cjgVarP instanceof cji) {
                            while (true) {
                                cjiVar4 = (cji) cjgVarP;
                                throwIfVar1IsNull(cjiVar4);
                                xeVar = cjiVar4.b;
                                if (cjiVar4.p(xeVar.c) instanceof cji) {
                                    break;
                                    break;
                                }
                                cjgVarP = cjiVar4.p(xeVar.c);
                            }
                            cjiVar3 = cjiVar4;
                        }
                    }
                    cjlVar.e = true;
                    return;
                }
                String str52 = "Could not find destination " + strR + " in the navigation graph, ignoring the deep link from " + intent;
                throwIfVar1IsNull(str52, "message");
                Log.i("NavController", str52);
            }
        }
        cji cjiVar13 = this.c;
        throwIfVar1IsNull(cjiVar13);
        ak(cjiVar13, bundle, null);
    }

    public final void aq(cio cioVar) {
        throwIfVar1IsNull(cioVar, "child");
        cio cioVar2 = (cio) this.i.remove(cioVar);
        if (cioVar2 == null) {
            return;
        }
        LinkedHashMap linkedHashMap = this.j;
        lp lpVar = (lp) linkedHashMap.get(cioVar2);
        Integer numValueOf = lpVar != null ? Integer.valueOf(lpVar.a.decrementAndGet()) : null;
        if (numValueOf != null && numValueOf.intValue() == 0) {
            cit citVar = (cit) this.s.get(this.r.d(cioVar2.b.f));
            if (citVar != null) {
                citVar.k(cioVar2);
            }
            linkedHashMap.remove(cioVar2);
        }
    }

    public final void ar() {
        lp lpVar;
        bmu bmuVar;
        Set set;
        ArrayList<cio> arrayListAb = aaz.ab(this.f);
        if (arrayListAb.isEmpty()) {
            return;
        }
        ArrayList arrayListAh = OtherStaticHelpers.ah(((cio) aaz.l(arrayListAb)).b);
        ArrayList arrayList = new ArrayList();
        if (aaz.l(arrayListAh) instanceof bbn) {
            Iterator it = aaz.r(arrayListAb).iterator();
            while (it.hasNext()) {
                cjg cjgVar = ((cio) it.next()).b;
                arrayList.add(cjgVar);
                if (!(cjgVar instanceof bbn) && !(cjgVar instanceof cji)) {
                    break;
                }
            }
        }
        HashMap map = new HashMap();
        for (cio cioVar : aaz.r(arrayListAb)) {
            buh buhVar = cioVar.h.k;
            cjg cjgVar2 = cioVar.b;
            cjg cjgVar3 = (cjg) aaz.g(arrayListAh);
            buh buhVar2 = buh.e;
            buh buhVar3 = buh.d;
            if (cjgVar3 != null && cjgVar3.g.a == cjgVar2.g.a) {
                if (buhVar != buhVar2) {
                    cit citVar = (cit) this.s.get(this.r.d(cioVar.b.f));
                    if (nullSafeIsEqual((citVar == null || (bmuVar = citVar.f) == null
                            || (set = (Set) ((dml) bmuVar.h).c()) == null) ? null
                                    : Boolean.valueOf(set.contains(cioVar)),
                            Boolean.TRUE) || ((lpVar = (lp) this.j.get(cioVar)) != null && lpVar.a.get() == 0)) {
                        map.put(cioVar, buhVar3);
                    } else {
                        map.put(cioVar, buhVar2);
                    }
                }
                cjg cjgVar4 = (cjg) aaz.g(arrayList);
                if (cjgVar4 != null && cjgVar4.g.a == cjgVar2.g.a) {
                    abf.aq(arrayList);
                }
                abf.aq(arrayListAh);
                cji cjiVar = cjgVar2.h;
                if (cjiVar != null) {
                    arrayListAh.add(cjiVar);
                }
            } else if (arrayList.isEmpty() || cjgVar2.g.a != ((cjg) aaz.e(arrayList)).g.a) {
                cioVar.i(buh.c);
            } else {
                cjg cjgVar5 = (cjg) abf.aq(arrayList);
                if (buhVar == buhVar2) {
                    cioVar.i(buhVar3);
                } else if (buhVar != buhVar3) {
                    map.put(cioVar, buhVar3);
                }
                cji cjiVar2 = cjgVar5.h;
                if (cjiVar2 != null && !arrayList.contains(cjiVar2)) {
                    arrayList.add(cjiVar2);
                }
            }
        }
        for (cio cioVar2 : arrayListAb) {
            buh buhVar4 = (buh) map.get(cioVar2);
            if (buhVar4 != null) {
                cioVar2.i(buhVar4);
            } else {
                cioVar2.h.m();
            }
        }
    }
}
