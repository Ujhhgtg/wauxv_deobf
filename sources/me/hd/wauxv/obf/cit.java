package me.hd.wauxv.obf;

import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cit {
    public final dop a;
    public final dml b;
    public final dml c;
    public boolean d;
    public final SyntheticPileOfMess e;
    public final SyntheticPileOfMess f;
    public final ckl g;
    public final /* synthetic */ cjl h;

    public cit(cjl cjlVar, ckl cklVar) {
        throwIfVar1IsNull(cklVar, "navigator");
        this.h = cjlVar;
        this.a = new dop(2);
        dml dmlVar = new dml(EmptyReadonlyList.INSTANCE);
        this.b = dmlVar;
        dml dmlVar2 = new dml(avh.a);
        this.c = dmlVar2;
        this.e = new SyntheticPileOfMess(dmlVar);
        this.f = new SyntheticPileOfMess(dmlVar2);
        this.g = cklVar;
    }

    public final void i(cio cioVar) {
        throwIfVar1IsNull(cioVar, "backStackEntry");
        synchronized (this.a) {
            dml dmlVar = this.b;
            dmlVar.g(StaticHelpers5.p((Collection) dmlVar.c(), cioVar));
        }
    }

    public final cio j(cjg cjgVar, Bundle bundle) {
        cix cixVar = this.h.b;
        cixVar.getClass();
        return cbm.h(cixVar.a.c, cjgVar, bundle, cixVar.ah(), cixVar.n);
    }

    /* JADX WARN: Found duplicated region for block: B:31:0x00ad */
    public final void k(cio cioVar) {
        ciy ciyVar;
        erq erqVar;
        throwIfVar1IsNull(cioVar, "entry");
        cix cixVar = this.h.b;
        dml dmlVar = cixVar.h;
        String str = cioVar.f;
        LinkedHashMap linkedHashMap = cixVar.v;
        boolean zF = nullSafeIsEqual(linkedHashMap.get(cioVar), Boolean.TRUE);
        dml dmlVar2 = this.c;
        Set set = (Set) dmlVar2.c();
        throwIfVar1IsNull(set, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(KotlinHelpers.calcHashMapCapacity(set.size()));
        boolean z = false;
        for (Object obj : set) {
            boolean z2 = true;
            if (!z && nullSafeIsEqual(obj, cioVar)) {
                z = true;
                z2 = false;
            }
            if (z2) {
                linkedHashSet.add(obj);
            }
        }
        dmlVar2.g(linkedHashSet);
        linkedHashMap.remove(cioVar);
        km kmVar = cixVar.f;
        if (kmVar.contains(cioVar)) {
            if (this.d) {
                return;
            }
            cixVar.ar();
            cixVar.g.g(StaticHelpers5.ab(kmVar));
            dmlVar.g(cixVar.an());
            return;
        }
        cixVar.aq(cioVar);
        if (cioVar.h.j.c.compareTo(buh.c) >= 0) {
            cioVar.i(buh.a);
        }
        if (!kmVar.isEmpty()) {
            Iterator it = kmVar.iterator();
            while (it.hasNext()) {
                if (nullSafeIsEqual(((cio) it.next()).f, str)) {
                }
            }
            if (!zF) {
                throwIfVar1IsNull(str, "backStackEntryId");
                erqVar = (erq) ciyVar.a.remove(str);
                if (erqVar != null) {
                    erqVar.b();
                }
            }
        } else if (!zF && (ciyVar = cixVar.n) != null) {
            throwIfVar1IsNull(str, "backStackEntryId");
            erqVar = (erq) ciyVar.a.remove(str);
            if (erqVar != null) {
                erqVar.b();
            }
        }
        cixVar.ar();
        dmlVar.g(cixVar.an());
    }

    public final void l(cio cioVar) {
        int iNextIndex;
        synchronized (this.a) {
            try {
                ArrayList arrayListAb = StaticHelpers5.ab((Collection) ((dml) this.e.obj).c());
                ListIterator listIterator = arrayListAb.listIterator(arrayListAb.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        iNextIndex = -1;
                        break;
                    } else if (nullSafeIsEqual(((cio) listIterator.previous()).f, cioVar.f)) {
                        iNextIndex = listIterator.nextIndex();
                        break;
                    }
                }
                arrayListAb.set(iNextIndex, cioVar);
                this.b.g(arrayListAb);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m(cio cioVar, boolean z) {
        cix cixVar = this.h.b;
        ls lsVar = new ls(this, cioVar, z);
        cixVar.getClass();
        ckl cklVarD = cixVar.r.d(cioVar.b.f);
        cixVar.v.put(cioVar, Boolean.valueOf(z));
        if (!cklVarD.equals(this.g)) {
            Object obj = cixVar.s.get(cklVarD);
            throwIfVar1IsNull(obj);
            ((cit) obj).m(cioVar, z);
            return;
        }
        ciu ciuVar = cixVar.u;
        if (ciuVar != null) {
            ciuVar.invoke(cioVar);
            lsVar.invoke();
            return;
        }
        km kmVar = cixVar.f;
        int iIndexOf = kmVar.indexOf(cioVar);
        if (iIndexOf < 0) {
            String str = "Ignoring pop of " + cioVar + " as it was not found on the current back stack";
            throwIfVar1IsNull(str, "message");
            Log.i("NavController", str);
            return;
        }
        int i = iIndexOf + 1;
        if (i != kmVar.f) {
            cixVar.al(((cio) kmVar.get(i)).b.g.a, true, false);
        }
        cix.aa(cixVar, cioVar);
        lsVar.invoke();
        cixVar.b.invoke();
        cixVar.ac();
    }

    public final void n(cio cioVar, boolean z) {
        Object objPrevious;
        dml dmlVar = this.c;
        Iterable iterable = (Iterable) dmlVar.c();
        boolean z2 = iterable instanceof Collection;
        SyntheticPileOfMess bmuVar = this.e;
        if (!z2 || !((Collection) iterable).isEmpty()) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                if (((cio) it.next()) == cioVar) {
                    Iterable iterable2 = (Iterable) ((dml) bmuVar.obj).c();
                    if ((iterable2 instanceof Collection) && ((Collection) iterable2).isEmpty()) {
                        return;
                    }
                    Iterator it2 = iterable2.iterator();
                    while (it2.hasNext()) {
                        if (((cio) it2.next()) == cioVar) {
                            break;
                        }
                    }
                    return;
                }
            }
        }
        dmlVar.g(dgg.b((Set) dmlVar.c(), cioVar));
        dml dmlVar2 = (dml) bmuVar.obj;
        dml dmlVar3 = (dml) bmuVar.obj;
        List list = (List) dmlVar2.c();
        ListIterator listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            }
            objPrevious = listIterator.previous();
            cio cioVar2 = (cio) objPrevious;
            if (!nullSafeIsEqual(cioVar2, cioVar)
                    && ((List) dmlVar3.c()).lastIndexOf(cioVar2) < ((List) dmlVar3.c()).lastIndexOf(cioVar)) {
                break;
            }
        }
        cio cioVar3 = (cio) objPrevious;
        if (cioVar3 != null) {
            dmlVar.g(dgg.b((Set) dmlVar.c(), cioVar3));
        }
        m(cioVar, z);
    }

    public final void o(cio cioVar) {
        throwIfVar1IsNull(cioVar, "backStackEntry");
        cix cixVar = this.h.b;
        cixVar.getClass();
        ckl cklVarD = cixVar.r.d(cioVar.b.f);
        if (!cklVarD.equals(this.g)) {
            Object obj = cixVar.s.get(cklVarD);
            if (obj == null) {
                throw new IllegalStateException(
                        yg.concatToVar1(new StringBuilder("NavigatorBackStack for "), cioVar.b.f, " should already be created")
                                .toString());
            }
            ((cit) obj).o(cioVar);
            return;
        }
        IInvokable bgfVar = cixVar.t;
        if (bgfVar != null) {
            bgfVar.invoke(cioVar);
            i(cioVar);
            return;
        }
        String str = "Ignoring add of destination " + cioVar.b + " outside of the call to navigate(). ";
        throwIfVar1IsNull(str, "message");
        Log.i("NavController", str);
    }

    public final void p(cio cioVar) {
        dml dmlVar = this.c;
        Iterable iterable = (Iterable) dmlVar.c();
        boolean z = iterable instanceof Collection;
        SyntheticPileOfMess bmuVar = this.e;
        if (!z || !((Collection) iterable).isEmpty()) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                if (((cio) it.next()) == cioVar) {
                    Iterable iterable2 = (Iterable) ((dml) bmuVar.obj).c();
                    if (!(iterable2 instanceof Collection) || !((Collection) iterable2).isEmpty()) {
                        Iterator it2 = iterable2.iterator();
                        while (it2.hasNext()) {
                            if (((cio) it2.next()) == cioVar) {
                                return;
                            }
                        }
                        break;
                    }
                    break;
                }
            }
        }
        cio cioVar2 = (cio) StaticHelpers5.m((List) ((dml) bmuVar.obj).c());
        if (cioVar2 != null) {
            dmlVar.g(dgg.b((Set) dmlVar.c(), cioVar2));
        }
        dmlVar.g(dgg.b((Set) dmlVar.c(), cioVar));
        o(cioVar);
    }
}
