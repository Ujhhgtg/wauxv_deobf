package me.hd.wauxv.obf;

import android.content.Context;
import android.util.Log;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
@ckk("dialog")
public final class ani extends ckl {
    public final Context a;
    public final beg b;
    public final LinkedHashSet f = new LinkedHashSet();
    public final cyo g = new cyo(this, 4);
    public final LinkedHashMap h = new LinkedHashMap();

    public ani(Context context, beg begVar) {
        this.a = context;
        this.b = begVar;
    }

    @Override // me.hd.wauxv.obf.ckl
    public final cjg c() {
        return new ang(this);
    }

    @Override // me.hd.wauxv.obf.ckl
    public final void i(List list, cjo cjoVar) {
        beg begVar = this.b;
        if (begVar.ci()) {
            Log.i("DialogFragmentNavigator", "Ignoring navigate() call: FragmentManager has already saved its state");
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            cio cioVar = (cio) it.next();
            m(cioVar).am(begVar, cioVar.f);
            cio cioVar2 = (cio) aaz.m((List) ((dml) w().e.h).c());
            boolean zB = aaz.b((Iterable) ((dml) w().f.h).c(), cioVar2);
            w().p(cioVar);
            if (cioVar2 != null && !zB) {
                w().k(cioVar2);
            }
        }
    }

    @Override // me.hd.wauxv.obf.ckl
    public final void j(cit citVar) {
        bur burVar;
        this.u = citVar;
        this.v = true;
        Iterator it = ((List) ((dml) citVar.e.h).c()).iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            beg begVar = this.b;
            if (!zHasNext) {
                begVar.p.add(new beu() { // from class: me.hd.wauxv.obf.anf
                    @Override // me.hd.wauxv.obf.beu
                    public final void b(beg begVar2, bdj bdjVar) {
                        throwIfVar1IsNull(begVar2, "<unused var>");
                        throwIfVar1IsNull(bdjVar, "childFragment");
                        ani aniVar = this.a;
                        LinkedHashSet linkedHashSet = aniVar.f;
                        String str = bdjVar.bs;
                        if ((linkedHashSet instanceof IEmpty) && !(linkedHashSet instanceof IEmpty2)) {
                            emc.bb(linkedHashSet, "kotlin.collections.MutableCollection");
                            throw null;
                        }
                        if (linkedHashSet.remove(str)) {
                            bdjVar.ch.j(aniVar.g);
                        }
                        LinkedHashMap linkedHashMap = aniVar.h;
                        String str2 = bdjVar.bs;
                        emc.ae(linkedHashMap);
                        linkedHashMap.remove(str2);
                    }
                });
                return;
            }
            cio cioVar = (cio) it.next();
            anc ancVar = (anc) begVar.cb(cioVar.f);
            if (ancVar == null || (burVar = ancVar.ch) == null) {
                this.f.add(cioVar.f);
            } else {
                burVar.j(this.g);
            }
        }
    }

    @Override // me.hd.wauxv.obf.ckl
    public final void k(cio cioVar) {
        String str = cioVar.f;
        beg begVar = this.b;
        if (begVar.ci()) {
            Log.i("DialogFragmentNavigator",
                    "Ignoring onLaunchSingleTop() call: FragmentManager has already saved its state");
            return;
        }
        anc ancVar = (anc) this.h.get(str);
        if (ancVar == null) {
            bdj bdjVarCb = begVar.cb(str);
            ancVar = bdjVarCb instanceof anc ? (anc) bdjVarCb : null;
        }
        if (ancVar != null) {
            ancVar.ch.o(this.g);
            ancVar.af();
        }
        m(cioVar).am(begVar, str);
        cit citVarW = w();
        List list = (List) ((dml) citVarW.e.h).c();
        ListIterator listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            cio cioVar2 = (cio) listIterator.previous();
            if (nullSafeIsEqual(cioVar2.f, str)) {
                dml dmlVar = citVarW.c;
                dmlVar.g(dgg.b(dgg.b((Set) dmlVar.c(), cioVar2), cioVar));
                citVarW.l(cioVar);
                return;
            }
        }
        throw new NoSuchElementException("List contains no element matching the predicate.");
    }

    @Override // me.hd.wauxv.obf.ckl
    public final void l(cio cioVar, boolean z) {
        beg begVar = this.b;
        if (begVar.ci()) {
            Log.i("DialogFragmentNavigator",
                    "Ignoring popBackStack() call: FragmentManager has already saved its state");
            return;
        }
        List list = (List) ((dml) w().e.h).c();
        int iIndexOf = list.indexOf(cioVar);
        Iterator it = aaz.r(list.subList(iIndexOf, list.size())).iterator();
        while (it.hasNext()) {
            bdj bdjVarCb = begVar.cb(((cio) it.next()).f);
            if (bdjVarCb != null) {
                ((anc) bdjVarCb).af();
            }
        }
        n(iIndexOf, cioVar, z);
    }

    public final anc m(cio cioVar) {
        cjg cjgVar = cioVar.b;
        throwIfVar1IsNull(cjgVar,
                "null cannot be cast to non-null type androidx.navigation.fragment.DialogFragmentNavigator.Destination");
        ang angVar = (ang) cjgVar;
        String str = angVar.a;
        if (str == null) {
            throw new IllegalStateException("DialogFragment class was not set");
        }
        char cCharAt = str.charAt(0);
        Context context = this.a;
        if (cCharAt == '.') {
            str = context.getPackageName() + str;
        }
        bdz bdzVarCe = this.b.ce();
        context.getClassLoader();
        bdj bdjVarE = bdzVarCe.e(str);
        throwIfVar1IsNull(bdjVarE, "instantiate(...)");
        if (anc.class.isAssignableFrom(bdjVarE.getClass())) {
            anc ancVar = (anc) bdjVarE;
            ancVar.df(cioVar.h.l());
            ancVar.ch.j(this.g);
            this.h.put(cioVar.f, ancVar);
            return ancVar;
        }
        StringBuilder sb = new StringBuilder("Dialog destination ");
        String str2 = angVar.a;
        if (str2 != null) {
            throw new IllegalArgumentException(yg.concatToVar1(sb, str2, " is not an instance of DialogFragment").toString());
        }
        throw new IllegalStateException("DialogFragment class was not set");
    }

    public final void n(int i, cio cioVar, boolean z) {
        cio cioVar2 = (cio) aaz.h(i - 1, (List) ((dml) w().e.h).c());
        boolean zB = aaz.b((Iterable) ((dml) w().f.h).c(), cioVar2);
        w().n(cioVar, z);
        if (cioVar2 == null || zB) {
            return;
        }
        w().k(cioVar2);
    }
}
