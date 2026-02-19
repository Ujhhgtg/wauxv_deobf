package me.hd.wauxv.obf;

import android.os.Looper;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bur {
    public final boolean a;
    public ayg b;
    public buh c;
    public final WeakReference d;
    public int e;
    public boolean f;
    public boolean g;
    public final ArrayList h;
    public final dml i;

    public bur(bup bupVar) {
        new AtomicReference(null);
        this.a = true;
        this.b = new ayg();
        buh buhVar = buh.b;
        this.c = buhVar;
        this.h = new ArrayList();
        this.d = new WeakReference(bupVar);
        this.i = new dml(buhVar);
    }

    public final void j(buo buoVar) {
        bul akzVar;
        Object obj;
        bup bupVar;
        throwIfVar1IsNull(buoVar, "observer");
        l("addObserver");
        buh buhVar = this.c;
        buh buhVar2 = buh.a;
        if (buhVar != buhVar2) {
            buhVar2 = buh.b;
        }
        buq buqVar = new buq();
        HashMap map = buu.a;
        boolean z = buoVar instanceof bul;
        boolean z2 = buoVar instanceof atg;
        int i = 3;
        if (z && z2) {
            akzVar = new akz((atg) buoVar, (bul) buoVar);
        } else if (z2) {
            akzVar = new akz((atg) buoVar, (bul) null);
        } else if (z) {
            akzVar = (bul) buoVar;
        } else {
            Class<?> cls = buoVar.getClass();
            if (buu.d(cls) == 2) {
                Object obj2 = buu.b.get(cls);
                throwIfVar1IsNull(obj2);
                List list = (List) obj2;
                if (list.size() == 1) {
                    buu.c((Constructor) list.get(0), buoVar);
                    throw null;
                }
                int size = list.size();
                bgw[] bgwVarArr = new bgw[size];
                if (size > 0) {
                    buu.c((Constructor) list.get(0), buoVar);
                    throw null;
                }
                akzVar = new cyo(bgwVarArr, i);
            } else {
                akzVar = new akz(buoVar);
            }
        }
        buqVar.b = akzVar;
        buqVar.a = buhVar2;
        ayg aygVar = this.b;
        deb debVarB = aygVar.b(buoVar);
        if (debVarB != null) {
            obj = debVarB.b;
        } else {
            HashMap map2 = aygVar.a;
            deb debVar = new deb(buoVar, buqVar);
            aygVar.g++;
            deb debVar2 = aygVar.e;
            if (debVar2 == null) {
                aygVar.d = debVar;
                aygVar.e = debVar;
            } else {
                debVar2.c = debVar;
                debVar.d = debVar2;
                aygVar.e = debVar;
            }
            map2.put(buoVar, debVar);
            obj = null;
        }
        if (((buq) obj) == null && (bupVar = (bup) this.d.get()) != null) {
            boolean z3 = this.e != 0 || this.f;
            buh buhVarK = k(buoVar);
            this.e++;
            while (buqVar.a.compareTo(buhVarK) < 0 && this.b.a.containsKey(buoVar)) {
                buh buhVar3 = buqVar.a;
                ArrayList arrayList = this.h;
                arrayList.add(buhVar3);
                bue bueVar = LifeEventEnum.Companion;
                buh buhVar4 = buqVar.a;
                bueVar.getClass();
                throwIfVar1IsNull(buhVar4, "state");
                int iOrdinal = buhVar4.ordinal();
                LifeEventEnum lifeEventEnumVar = iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? null : LifeEventEnum.ON_RESUME : LifeEventEnum.ON_START
                        : LifeEventEnum.ON_CREATE;
                if (lifeEventEnumVar == null) {
                    throw new IllegalStateException("no event up from " + buqVar.a);
                }
                buqVar.c(bupVar, lifeEventEnumVar);
                arrayList.remove(arrayList.size() - 1);
                buhVarK = k(buoVar);
            }
            if (!z3) {
                q();
            }
            this.e--;
        }
    }

    public final buh k(buo buoVar) {
        HashMap map = this.b.a;
        deb debVar = map.containsKey(buoVar) ? ((deb) map.get(buoVar)).d : null;
        buh buhVar = debVar != null ? ((buq) debVar.b).a : null;
        ArrayList arrayList = this.h;
        buh buhVar2 = arrayList.isEmpty() ? null : (buh) StaticHelpers6.getLastNElem(1, arrayList);
        buh buhVar3 = this.c;
        throwIfVar1IsNull(buhVar3, "state1");
        if (buhVar == null || buhVar.compareTo(buhVar3) >= 0) {
            buhVar = buhVar3;
        }
        return (buhVar2 == null || buhVar2.compareTo(buhVar) >= 0) ? buhVar : buhVar2;
    }

    public final void l(String str) {
        if (this.a) {
            ((kj) kj.c().b).getClass();
            if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                throw new IllegalStateException(
                        concat("Method ", str, " must be called on the main thread").toString());
            }
        }
    }

    public final void m(LifeEventEnum lifeEventEnumVar) {
        throwIfVar1IsNull(lifeEventEnumVar, "event");
        l("handleLifecycleEvent");
        n(lifeEventEnumVar.a());
    }

    public final void n(buh buhVar) {
        if (this.c == buhVar) {
            return;
        }
        bup bupVar = (bup) this.d.get();
        buh buhVar2 = this.c;
        throwIfVar1IsNull(buhVar2, "current");
        throwIfVar1IsNull(buhVar, "next");
        buh buhVar3 = buh.b;
        buh buhVar4 = buh.a;
        if (buhVar2 == buhVar3 && buhVar == buhVar4) {
            throw new IllegalStateException(
                    ("State must be at least '" + buh.c + "' to be moved to '" + buhVar + "' in component " + bupVar)
                            .toString());
        }
        if (buhVar2 == buhVar4 && buhVar2 != buhVar) {
            throw new IllegalStateException(
                    ("State is '" + buhVar4 + "' and cannot be moved to `" + buhVar + "` in component " + bupVar)
                            .toString());
        }
        this.c = buhVar;
        if (this.f || this.e != 0) {
            this.g = true;
            return;
        }
        this.f = true;
        q();
        this.f = false;
        if (this.c == buhVar4) {
            this.b = new ayg();
        }
    }

    public final void o(buo buoVar) {
        throwIfVar1IsNull(buoVar, "observer");
        l("removeObserver");
        this.b.c(buoVar);
    }

    public final void p(buh buhVar) {
        throwIfVar1IsNull(buhVar, "state");
        l("setCurrentState");
        n(buhVar);
    }

    public final void q() {
        bup bupVar = (bup) this.d.get();
        if (bupVar == null) {
            throw new IllegalStateException(
                    "LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
        }
        while (true) {
            ayg aygVar = this.b;
            if (aygVar.g != 0) {
                deb debVar = aygVar.d;
                throwIfVar1IsNull(debVar);
                buh buhVar = ((buq) debVar.b).a;
                deb debVar2 = this.b.e;
                throwIfVar1IsNull(debVar2);
                buh buhVar2 = ((buq) debVar2.b).a;
                if (buhVar == buhVar2 && this.c == buhVar2) {
                    break;
                }
                this.g = false;
                buh buhVar3 = this.c;
                deb debVar3 = this.b.d;
                throwIfVar1IsNull(debVar3);
                int iCompareTo = buhVar3.compareTo(((buq) debVar3.b).a);
                ArrayList arrayList = this.h;
                if (iCompareTo < 0) {
                    ayg aygVar2 = this.b;
                    dea deaVar = new dea(aygVar2.e, aygVar2.d, 1);
                    aygVar2.f.put(deaVar, Boolean.FALSE);
                    while (deaVar.hasNext() && !this.g) {
                        Map.Entry entry = (Map.Entry) deaVar.next();
                        throwIfVar1IsNull(entry);
                        buo buoVar = (buo) entry.getKey();
                        buq buqVar = (buq) entry.getValue();
                        while (buqVar.a.compareTo(this.c) > 0 && !this.g && this.b.a.containsKey(buoVar)) {
                            bue bueVar = LifeEventEnum.Companion;
                            buh buhVar4 = buqVar.a;
                            bueVar.getClass();
                            throwIfVar1IsNull(buhVar4, "state");
                            int iOrdinal = buhVar4.ordinal();
                            LifeEventEnum lifeEventEnumVar = iOrdinal != 2
                                    ? iOrdinal != 3 ? iOrdinal != 4 ? null : LifeEventEnum.ON_PAUSE : LifeEventEnum.ON_STOP
                                    : LifeEventEnum.ON_DESTROY;
                            if (lifeEventEnumVar == null) {
                                throw new IllegalStateException("no event down from " + buqVar.a);
                            }
                            arrayList.add(lifeEventEnumVar.a());
                            buqVar.c(bupVar, lifeEventEnumVar);
                            arrayList.remove(arrayList.size() - 1);
                        }
                    }
                }
                deb debVar4 = this.b.e;
                if (!this.g && debVar4 != null && this.c.compareTo(((buq) debVar4.b).a) > 0) {
                    ayg aygVar3 = this.b;
                    aygVar3.getClass();
                    dec decVar = new dec(aygVar3);
                    aygVar3.f.put(decVar, Boolean.FALSE);
                    while (decVar.hasNext() && !this.g) {
                        Map.Entry entry2 = (Map.Entry) decVar.next();
                        buo buoVar2 = (buo) entry2.getKey();
                        buq buqVar2 = (buq) entry2.getValue();
                        while (buqVar2.a.compareTo(this.c) < 0 && !this.g && this.b.a.containsKey(buoVar2)) {
                            arrayList.add(buqVar2.a);
                            bue bueVar2 = LifeEventEnum.Companion;
                            buh buhVar5 = buqVar2.a;
                            bueVar2.getClass();
                            throwIfVar1IsNull(buhVar5, "state");
                            int iOrdinal2 = buhVar5.ordinal();
                            LifeEventEnum lifeEventEnumVar2 = iOrdinal2 != 1
                                    ? iOrdinal2 != 2 ? iOrdinal2 != 3 ? null : LifeEventEnum.ON_RESUME : LifeEventEnum.ON_START
                                    : LifeEventEnum.ON_CREATE;
                            if (lifeEventEnumVar2 == null) {
                                throw new IllegalStateException("no event up from " + buqVar2.a);
                            }
                            buqVar2.c(bupVar, lifeEventEnumVar2);
                            arrayList.remove(arrayList.size() - 1);
                        }
                    }
                }
            } else {
                break;
            }
        }
        this.g = false;
        this.i.g(this.c);
    }
}
