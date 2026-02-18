package me.hd.wauxv.obf;

import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bes {
    public final /* synthetic */ cit a;
    public final /* synthetic */ beq b;

    public bes(cit citVar, beq beqVar) {
        this.a = citVar;
        this.b = beqVar;
    }

    public final void c(bdj bdjVar, boolean z) {
        Object obj;
        Object objPrevious;
        beq beqVar = this.b;
        ArrayList arrayList = beqVar.h;
        throwIfVar1IsNull(bdjVar, "fragment");
        cit citVar = this.a;
        ArrayList arrayListO = aaz.o((Collection) ((dml) citVar.e.h).c(), (Iterable) ((dml) citVar.f.h).c());
        ListIterator listIterator = arrayListO.listIterator(arrayListO.size());
        do {
            obj = null;
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            }
            objPrevious = listIterator.previous();
        } while (!nullSafeIsEqual(((cio) objPrevious).f, bdjVar.bs));
        cio cioVar = (cio) objPrevious;
        boolean z2 = z && arrayList.isEmpty() && bdjVar.bd;
        for (Object obj2 : arrayList) {
            if (nullSafeIsEqual(((Pair) obj2).first, bdjVar.bs)) {
                obj = obj2;
                break;
            }
        }
        Pair pairVar = (Pair) obj;
        if (pairVar != null) {
            arrayList.remove(pairVar);
        }
        if (!z2 && beq.p()) {
            Log.v("FragmentNavigator",
                    "OnBackStackChangedCommitted for fragment " + bdjVar + " associated with entry " + cioVar);
        }
        boolean z3 = pairVar != null && ((Boolean) pairVar.second).booleanValue();
        if (!z && !z3 && cioVar == null) {
            throw new IllegalArgumentException(yg.l("The fragment ", bdjVar,
                    " is unknown to the FragmentNavigator. Please use the navigate() function to add fragments to the FragmentNavigator managed FragmentManager.")
                    .toString());
        }
        if (cioVar != null) {
            beqVar.s(bdjVar, cioVar, citVar);
            if (z2) {
                if (beq.p()) {
                    Log.v("FragmentNavigator", "OnBackStackChangedCommitted for fragment " + bdjVar
                            + " popping associated entry " + cioVar + " via system back");
                }
                citVar.n(cioVar, false);
            }
        }
    }

    public final void d(bdj bdjVar, boolean z) {
        Object objPrevious;
        throwIfVar1IsNull(bdjVar, "fragment");
        if (z) {
            cit citVar = this.a;
            List list = (List) ((dml) citVar.e.h).c();
            ListIterator listIterator = list.listIterator(list.size());
            do {
                if (!listIterator.hasPrevious()) {
                    objPrevious = null;
                    break;
                }
                objPrevious = listIterator.previous();
            } while (!nullSafeIsEqual(((cio) objPrevious).f, bdjVar.bs));
            cio cioVar = (cio) objPrevious;
            if (beq.p()) {
                Log.v("FragmentNavigator",
                        "OnBackStackChangedStarted for fragment " + bdjVar + " associated with entry " + cioVar);
            }
            if (cioVar != null) {
                dml dmlVar = citVar.c;
                dmlVar.g(dgg.b((Set) dmlVar.c(), cioVar));
                cix cixVar = citVar.h.b;
                cixVar.getClass();
                if (!cixVar.f.contains(cioVar)) {
                    throw new IllegalStateException("Cannot transition entry that is not in the back stack");
                }
                cioVar.i(buh.d);
            }
        }
    }
}
