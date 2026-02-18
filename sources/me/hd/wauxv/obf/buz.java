package me.hd.wauxv.obf;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class buz extends v {
    public final /* synthetic */ pi e;
    public final /* synthetic */ dhs f;
    public final /* synthetic */ csk g;
    public final /* synthetic */ pi h;
    public final /* synthetic */ int i;
    public final /* synthetic */ bvb j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public buz(bvb bvbVar, x xVar, pi piVar, dhs dhsVar, csk cskVar, pi piVar2, int i) {
        super(bvbVar, xVar);
        this.j = bvbVar;
        this.e = piVar;
        this.f = dhsVar;
        this.g = cskVar;
        this.h = piVar2;
        this.i = i;
    }

    @Override // me.hd.wauxv.obf.v
    public final Object c() {
        ReentrantLock reentrantLock = this.e.a;
        reentrantLock.lock();
        try {
            aff affVar = this.j.c;
            int size = affVar.a.size() - 1;
            final dhs dhsVar = this.f;
            final csk cskVar = this.g;
            final pi piVar = this.e;
            final pi piVar2 = this.h;
            affVar.ai(0, size, new afd() { // from class: me.hd.wauxv.obf.buy
                @Override // me.hd.wauxv.obf.afd
                public final void c(int i, afo afoVar, afc afcVar) {
                    int iG = (int) dhsVar.g(afoVar, 0, afoVar.b, cskVar);
                    buz buzVar = this.a;
                    buzVar.j.d();
                    List list = Collections.EMPTY_LIST;
                    int iX = bvb.x();
                    if (!buzVar.d()) {
                        afcVar.b = true;
                        return;
                    }
                    pi piVar3 = piVar;
                    piVar3.l(piVar3.e, iG + iX);
                    pi piVar4 = piVar2;
                    piVar4.l(piVar4.e, iX);
                }
            });
            return null;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // me.hd.wauxv.obf.v
    public final boolean d() {
        return super.d() && this.j.t.get() == this.i;
    }
}
