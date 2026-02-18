package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bkv extends eun {
    public final void a(alz alzVar) {
        alz alzVar2 = this.r;
        alzVar2.l.add(alzVar);
        alzVar.m.add(alzVar2);
    }

    @Override // me.hd.wauxv.obf.alx
    public final void c(alx alxVar) {
        nb nbVar = (nb) this.l;
        int i = nbVar.a;
        alz alzVar = this.r;
        Iterator it = alzVar.m.iterator();
        int i2 = 0;
        int i3 = -1;
        while (it.hasNext()) {
            int i4 = ((alz) it.next()).h;
            if (i3 == -1 || i4 < i3) {
                i3 = i4;
            }
            if (i2 < i4) {
                i2 = i4;
            }
        }
        if (i == 0 || i == 2) {
            alzVar.p(i3 + nbVar.c);
        } else {
            alzVar.p(i2 + nbVar.c);
        }
    }

    @Override // me.hd.wauxv.obf.eun
    public final void d() {
        adq adqVar = this.l;
        if (adqVar instanceof nb) {
            alz alzVar = this.r;
            alzVar.b = true;
            ArrayList arrayList = alzVar.m;
            nb nbVar = (nb) adqVar;
            int i = nbVar.a;
            boolean z = nbVar.b;
            int i2 = 0;
            if (i == 0) {
                alzVar.f = 4;
                while (i2 < nbVar.ew) {
                    adq adqVar2 = nbVar.ev[i2];
                    if (z || adqVar2.bq != 8) {
                        alz alzVar2 = adqVar2.n.r;
                        alzVar2.l.add(alzVar);
                        arrayList.add(alzVar2);
                    }
                    i2++;
                }
                a(this.l.n.r);
                a(this.l.n.s);
                return;
            }
            if (i == 1) {
                alzVar.f = 5;
                while (i2 < nbVar.ew) {
                    adq adqVar3 = nbVar.ev[i2];
                    if (z || adqVar3.bq != 8) {
                        alz alzVar3 = adqVar3.n.s;
                        alzVar3.l.add(alzVar);
                        arrayList.add(alzVar3);
                    }
                    i2++;
                }
                a(this.l.n.r);
                a(this.l.n.s);
                return;
            }
            if (i == 2) {
                alzVar.f = 6;
                while (i2 < nbVar.ew) {
                    adq adqVar4 = nbVar.ev[i2];
                    if (z || adqVar4.bq != 8) {
                        alz alzVar4 = adqVar4.o.r;
                        alzVar4.l.add(alzVar);
                        arrayList.add(alzVar4);
                    }
                    i2++;
                }
                a(this.l.o.r);
                a(this.l.o.s);
                return;
            }
            if (i != 3) {
                return;
            }
            alzVar.f = 7;
            while (i2 < nbVar.ew) {
                adq adqVar5 = nbVar.ev[i2];
                if (z || adqVar5.bq != 8) {
                    alz alzVar5 = adqVar5.o.s;
                    alzVar5.l.add(alzVar);
                    arrayList.add(alzVar5);
                }
                i2++;
            }
            a(this.l.o.r);
            a(this.l.o.s);
        }
    }

    @Override // me.hd.wauxv.obf.eun
    public final void e() {
        adq adqVar = this.l;
        if (adqVar instanceof nb) {
            int i = ((nb) adqVar).a;
            alz alzVar = this.r;
            if (i == 0 || i == 1) {
                adqVar.bi = alzVar.h;
            } else {
                adqVar.bj = alzVar.h;
            }
        }
    }

    @Override // me.hd.wauxv.obf.eun
    public final void f() {
        this.m = null;
        this.r.o();
    }

    @Override // me.hd.wauxv.obf.eun
    public final boolean h() {
        return false;
    }
}
