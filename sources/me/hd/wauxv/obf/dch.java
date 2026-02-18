package me.hd.wauxv.obf;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dch implements ajd, aja {
    public final ajr a;
    public final ajp b;
    public int c;
    public int d = -1;
    public btj e;
    public List f;
    public int g;
    public volatile cdu h;
    public File i;
    public dci m;

    public dch(ajp ajpVar, ajr ajrVar) {
        this.b = ajpVar;
        this.a = ajrVar;
    }

    @Override // me.hd.wauxv.obf.aja
    public final void _bo(Object obj) {
        this.a.a(this.e, obj, this.h.c, 4, this.m);
    }

    @Override // me.hd.wauxv.obf.ajd
    public final void cancel() {
        cdu cduVar = this.h;
        if (cduVar != null) {
            cduVar.c.cancel();
        }
    }

    @Override // me.hd.wauxv.obf.ajd
    public final boolean j() {
        List list;
        ArrayList arrayListAe;
        ArrayList arrayListS = this.b.s();
        boolean z = false;
        if (!arrayListS.isEmpty()) {
            ajp ajpVar = this.b;
            das dasVarL = ajpVar.c.l();
            Class<?> cls = ajpVar.d.getClass();
            Class cls2 = ajpVar.g;
            Class cls3 = ajpVar.k;
            but butVar = dasVarL.h;
            chj chjVar = (chj) ((AtomicReference) butVar.b).getAndSet(null);
            if (chjVar == null) {
                chjVar = new chj(cls, cls2, cls3);
            } else {
                chjVar.a = cls;
                chjVar.b = cls2;
                chjVar.c = cls3;
            }
            synchronized (((ku) butVar.c)) {
                list = (List) ((ku) butVar.c).get(chjVar);
            }
            ((AtomicReference) butVar.b).set(chjVar);
            List list2 = list;
            if (list == null) {
                ArrayList arrayList = new ArrayList();
                but butVar2 = dasVarL.a;
                synchronized (butVar2) {
                    arrayListAe = ((chm) butVar2.b).ae(cls);
                }
                Iterator it = arrayListAe.iterator();
                while (it.hasNext()) {
                    for (Class cls4 : dasVarL.c.r((Class) it.next(), cls2)) {
                        if (!dasVarL.f.c(cls4, cls3).isEmpty() && !arrayList.contains(cls4)) {
                            arrayList.add(cls4);
                        }
                    }
                }
                but butVar3 = dasVarL.h;
                List listUnmodifiableList = Collections.unmodifiableList(arrayList);
                synchronized (((ku) butVar3.c)) {
                    ((ku) butVar3.c).put(new chj(cls, cls2, cls3), listUnmodifiableList);
                }
                list2 = arrayList;
            }
            if (!list2.isEmpty()) {
                while (true) {
                    List list3 = this.f;
                    if (list3 != null && this.g < list3.size()) {
                        this.h = null;
                        while (!z && this.g < this.f.size()) {
                            List list4 = this.f;
                            int i = this.g;
                            this.g = i + 1;
                            cdv cdvVar = (cdv) list4.get(i);
                            File file = this.i;
                            ajp ajpVar2 = this.b;
                            this.h = cdvVar.e(file, ajpVar2.e, ajpVar2.f, ajpVar2.i);
                            if (this.h != null && this.b.u(this.h.c.b()) != null) {
                                this.h.c.f(this.b.o, this);
                                z = true;
                            }
                        }
                        return z;
                    }
                    int i2 = this.d + 1;
                    this.d = i2;
                    if (i2 >= list2.size()) {
                        int i3 = this.c + 1;
                        this.c = i3;
                        if (i3 >= arrayListS.size()) {
                            break;
                        }
                        this.d = 0;
                    }
                    btj btjVar = (btj) arrayListS.get(this.c);
                    Class cls5 = (Class) list2.get(this.d);
                    elc elcVarW = this.b.w(cls5);
                    ajp ajpVar3 = this.b;
                    this.m = new dci(ajpVar3.c.b, btjVar, ajpVar3.n, ajpVar3.e, ajpVar3.f, elcVarW, cls5, ajpVar3.i);
                    File fileW = ajpVar3.h.c().w(this.m);
                    this.i = fileW;
                    if (fileW != null) {
                        this.e = btjVar;
                        this.f = this.b.c.l().p(fileW);
                        this.g = 0;
                    }
                }
            } else if (!File.class.equals(this.b.k)) {
                throw new IllegalStateException("Failed to find any load path from " + this.b.d.getClass() + " to " + this.b.k);
            }
        }
        return false;
    }

    @Override // me.hd.wauxv.obf.aja
    public final void k(Exception exc) {
        this.a.b(this.m, exc, this.h.c, 4);
    }
}
