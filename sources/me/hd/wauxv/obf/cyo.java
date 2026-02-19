package me.hd.wauxv.obf;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cyo implements bul {
    public final /* synthetic */ int a;
    public final Object b;

    public /* synthetic */ cyo(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // me.hd.wauxv.obf.bul
    public final void e(bup bupVar, LifeEventEnum lifeEventEnumVar) {
        int iNextIndex;
        View view;
        switch (this.a) {
            case 0:
                dep depVar = (dep) this.b;
                if (lifeEventEnumVar != LifeEventEnum.ON_CREATE) {
                    throw new AssertionError("Next event must be ON_CREATE");
                }
                bupVar.ap().o(this);
                Bundle bundleG = depVar.ak().g("androidx.savedstate.Restarter");
                if (bundleG == null) {
                    return;
                }
                ArrayList<String> stringArrayList = bundleG.getStringArrayList("classes_to_restore");
                if (stringArrayList == null) {
                    throw new IllegalStateException(
                            "SavedState with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
                }
                for (String str : stringArrayList) {
                    try {
                        Class<? extends U> clsAsSubclass = Class.forName(str, false, cyo.class.getClassLoader())
                                .asSubclass(dem.class);
                        throwIfVar1IsNull(clsAsSubclass);
                        try {
                            Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(null);
                            declaredConstructor.setAccessible(true);
                            try {
                                Object objNewInstance = declaredConstructor.newInstance(null);
                                throwIfVar1IsNull(objNewInstance);
                                if (!(depVar instanceof err)) {
                                    throw new IllegalStateException(
                                            ("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner. Received owner: "
                                                    + depVar).toString());
                                }
                                erq erqVarAj = ((err) depVar).aj();
                                but butVarAk = depVar.ak();
                                erqVarAj.getClass();
                                LinkedHashMap linkedHashMap = erqVarAj.a;
                                for (String str2 : new HashSet(linkedHashMap.keySet())) {
                                    throwIfVar1IsNull(str2, "key");
                                    erk erkVar = (erk) linkedHashMap.get(str2);
                                    if (erkVar != null) {
                                        aye.m(erkVar, butVarAk, depVar.ap());
                                    }
                                }
                                if (!new HashSet(linkedHashMap.keySet()).isEmpty()) {
                                    butVarAk.ag();
                                }
                            } catch (Exception e) {
                                throw new RuntimeException(yg.concat("Failed to instantiate ", str), e);
                            }
                        } catch (NoSuchMethodException e2) {
                            throw new IllegalStateException(
                                    "Class " + clsAsSubclass.getSimpleName()
                                            + " must have default constructor in order to be automatically recreated",
                                    e2);
                        }
                    } catch (ClassNotFoundException e3) {
                        throw new RuntimeException(concat("Class ", str, " wasn't found"), e3);
                    }
                }
                return;
            case 1:
                if (lifeEventEnumVar == LifeEventEnum.ON_DESTROY) {
                    ng.ai(((ng) this.b).as());
                    return;
                }
                return;
            case 2:
                hb hbVar = (hb) this.b;
                if (hbVar.u == null) {
                    acd acdVar = (acd) hbVar.getLastNonConfigurationInstance();
                    if (acdVar != null) {
                        hbVar.u = acdVar.a;
                    }
                    if (hbVar.u == null) {
                        hbVar.u = new erq();
                    }
                }
                hbVar.q.o(this);
                return;
            case 3:
                new HashMap();
                bgw[] bgwVarArr = (bgw[]) this.b;
                if (bgwVarArr.length > 0) {
                    bgw bgwVar = bgwVarArr[0];
                    throw null;
                }
                if (bgwVarArr.length <= 0) {
                    return;
                }
                bgw bgwVar2 = bgwVarArr[0];
                throw null;
            case 4:
                ani aniVar = (ani) this.b;
                int i = anh.a[lifeEventEnumVar.ordinal()];
                if (i == 1) {
                    anc ancVar = (anc) bupVar;
                    Iterable iterable = (Iterable) ((dml) aniVar.w().e.obj).c();
                    if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                        Iterator it = iterable.iterator();
                        while (it.hasNext()) {
                            if (nullSafeIsEqual(((cio) it.next()).f, ancVar.bs)) {
                                return;
                            }
                        }
                    }
                    ancVar.af();
                    return;
                }
                Object obj = null;
                if (i == 2) {
                    anc ancVar2 = (anc) bupVar;
                    for (Object obj2 : (Iterable) ((dml) aniVar.w().f.obj).c()) {
                        if (nullSafeIsEqual(((cio) obj2).f, ancVar2.bs)) {
                            obj = obj2;
                        }
                    }
                    cio cioVar = (cio) obj;
                    if (cioVar != null) {
                        aniVar.w().k(cioVar);
                        return;
                    }
                    return;
                }
                if (i != 3) {
                    if (i != 4) {
                        return;
                    }
                    anc ancVar3 = (anc) bupVar;
                    for (Object obj3 : (Iterable) ((dml) aniVar.w().f.obj).c()) {
                        if (nullSafeIsEqual(((cio) obj3).f, ancVar3.bs)) {
                            obj = obj3;
                        }
                    }
                    cio cioVar2 = (cio) obj;
                    if (cioVar2 != null) {
                        aniVar.w().k(cioVar2);
                    }
                    ancVar3.ch.o(this);
                    return;
                }
                anc ancVar4 = (anc) bupVar;
                if (ancVar4.al().isShowing()) {
                    return;
                }
                List list = (List) ((dml) aniVar.w().e.obj).c();
                ListIterator listIterator = list.listIterator(list.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        iNextIndex = -1;
                    } else if (nullSafeIsEqual(((cio) listIterator.previous()).f, ancVar4.bs)) {
                        iNextIndex = listIterator.nextIndex();
                    }
                }
                cio cioVar3 = (cio) StaticHelpers5.h(iNextIndex, list);
                if (!nullSafeIsEqual(StaticHelpers5.m(list), cioVar3)) {
                    Log.i("DialogFragmentNavigator", "Dialog " + ancVar4
                            + " was dismissed while it was not the top of the back stack, popping all dialogs above this dismissed dialog");
                }
                if (cioVar3 != null) {
                    aniVar.n(iNextIndex, cioVar3, false);
                    return;
                }
                return;
            case 5:
                if (lifeEventEnumVar != LifeEventEnum.ON_STOP || (view = ((SomeFragmentManager) this.b).bz) == null) {
                    return;
                }
                view.cancelPendingInputEvents();
                return;
            case 6:
                ((bfa) this.b).h(false);
                return;
            default:
                if (lifeEventEnumVar != LifeEventEnum.ON_CREATE) {
                    throw new IllegalStateException(("Next event must be ON_CREATE, it was " + lifeEventEnumVar).toString());
                }
                bupVar.ap().o(this);
                ((dek) this.b).f();
                return;
        }
    }
}
