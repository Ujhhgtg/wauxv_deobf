package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ajp {
    public final ArrayList a = new ArrayList();
    public final ArrayList b = new ArrayList();
    public bhw c;
    public Object d;
    public int e;
    public int f;
    public Class g;
    public afr h;
    public crw i;
    public Map j;
    public Class k;
    public boolean l;
    public boolean m;
    public btj n;
    public cvq o;
    public aoi p;
    public boolean q;
    public boolean r;

    public final ArrayList s() {
        boolean z = this.m;
        ArrayList arrayList = this.b;
        if (!z) {
            this.m = true;
            arrayList.clear();
            ArrayList arrayListT = t();
            int size = arrayListT.size();
            for (int i = 0; i < size; i++) {
                cdu cduVar = (cdu) arrayListT.get(i);
                btj btjVar = cduVar.a;
                List list = cduVar.b;
                if (!arrayList.contains(btjVar)) {
                    arrayList.add(cduVar.a);
                }
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (!arrayList.contains(list.get(i2))) {
                        arrayList.add((btj) list.get(i2));
                    }
                }
            }
        }
        return arrayList;
    }

    public final ArrayList t() {
        boolean z = this.l;
        ArrayList arrayList = this.a;
        if (!z) {
            this.l = true;
            arrayList.clear();
            List listP = this.c.l().p(this.d);
            int size = listP.size();
            for (int i = 0; i < size; i++) {
                cdu cduVarE = ((cdv) listP.get(i)).e(this.d, this.e, this.f, this.i);
                if (cduVarE != null) {
                    arrayList.add(cduVarE);
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final bwt u(Class cls) {
        bwt bwtVar;
        Class cls2;
        Class cls3;
        Class cls4;
        bwt bwtVar2;
        ArrayList arrayList;
        dcq dcqVar;
        Class cls5 = cls;
        das dasVarL = this.c.l();
        Class cls6 = this.g;
        Class cls7 = this.k;
        bwu bwuVar = dasVarL.i;
        chj chjVar = (chj) bwuVar.c.getAndSet(null);
        if (chjVar == null) {
            chjVar = new chj();
        }
        chjVar.a = cls5;
        chjVar.b = cls6;
        chjVar.c = cls7;
        synchronized (bwuVar.b) {
            bwtVar = (bwt) bwuVar.b.get(chjVar);
        }
        bwuVar.c.set(chjVar);
        dasVarL.i.getClass();
        if (bwu.a.equals(bwtVar)) {
            return null;
        }
        if (bwtVar != null) {
            return bwtVar;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Class<?> cls8 : dasVarL.c.r(cls5, cls6)) {
            for (Class cls9 : dasVarL.f.c(cls8, cls7)) {
                but butVar = dasVarL.c;
                synchronized (butVar) {
                    arrayList = new ArrayList();
                    Iterator it = ((ArrayList) butVar.c).iterator();
                    while (it.hasNext()) {
                        List<dck> list = (List) ((HashMap) butVar.b).get((String) it.next());
                        if (list != null) {
                            for (dck dckVar : list) {
                                if (dckVar.a.isAssignableFrom(cls5) && cls8.isAssignableFrom(dckVar.b)) {
                                    arrayList.add(dckVar.c);
                                }
                            }
                        }
                    }
                }
                avw avwVar = dasVarL.f;
                synchronized (avwVar) {
                    if (cls9.isAssignableFrom(cls8)) {
                        dcqVar = arj.p;
                    } else {
                        Iterator it2 = avwVar.a.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                throw new IllegalArgumentException(
                                        "No transcoder registered to transcode from " + cls8 + " to " + cls9);
                            }
                            ekz ekzVar = (ekz) it2.next();
                            if (ekzVar.a.isAssignableFrom(cls8) && cls9.isAssignableFrom(ekzVar.b)) {
                                dcqVar = ekzVar.c;
                                break;
                            }
                            cls5 = cls;
                        }
                    }
                }
                arrayList2.add(new ajs(cls5, cls8, cls9, arrayList, dcqVar, dasVarL.j));
                cls5 = cls;
            }
            cls5 = cls;
        }
        if (arrayList2.isEmpty()) {
            cls2 = cls;
            cls3 = cls6;
            cls4 = cls7;
            bwtVar2 = null;
        } else {
            cls2 = cls;
            cls3 = cls6;
            cls4 = cls7;
            bwtVar2 = new bwt(cls2, cls3, cls4, arrayList2, dasVarL.j);
        }
        bwu bwuVar2 = dasVarL.i;
        synchronized (bwuVar2.b) {
            bwuVar2.b.put(new chj(cls2, cls3, cls4), bwtVar2 != null ? bwtVar2 : bwu.a);
        }
        return bwtVar2;
    }

    public final avu v(Object obj) {
        avu avuVar;
        avw avwVar = this.c.l().b;
        Class<?> cls = obj.getClass();
        synchronized (avwVar) {
            for (avv avvVar : avwVar.a) {
                if (avvVar.a.isAssignableFrom(cls)) {
                    avuVar = avvVar.b;
                }
            }
            avuVar = null;
        }
        if (avuVar != null) {
            return avuVar;
        }
        throw new dar(concatVar2Var1(obj.getClass(), "Failed to find source encoder for data class: "));
    }

    public final elc w(Class cls) {
        elc elcVar = (elc) this.j.get(cls);
        if (elcVar == null) {
            for (Map.Entry entry : this.j.entrySet()) {
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    elcVar = (elc) entry.getValue();
                    break;
                }
            }
        }
        if (elcVar != null) {
            return elcVar;
        }
        if (!this.j.isEmpty() || !this.q) {
            return env.b;
        }
        throw new IllegalArgumentException("Missing transformation for " + cls
                + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }
}
