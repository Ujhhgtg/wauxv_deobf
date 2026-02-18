package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class awh implements axw {
    public static final nu a = new nu(28);
    public final awk d;
    public final cuv e;
    public final awi g;
    public final bia h;
    public final bia i;
    public final bia j;
    public awj l;
    public boolean m;
    public boolean n;
    public dcg o;
    public int p;
    public boolean q;
    public bhy r;
    public boolean s;
    public awl t;
    public ajr u;
    public volatile boolean v;
    public boolean w;
    public final awg b = new awg(new ArrayList(2));
    public final dmn c = new dmn();
    public final AtomicInteger k = new AtomicInteger();
    public final nu f = a;

    public awh(bia biaVar, bia biaVar2, bia biaVar3, bia biaVar4, awd awdVar, awd awdVar2, jx jxVar) {
        this.h = biaVar;
        this.i = biaVar2;
        this.j = biaVar4;
        this.g = awdVar;
        this.d = awdVar2;
        this.e = jxVar;
    }

    public final synchronized void aa(int i) {
        awl awlVar;
        cmz.k("Not yet complete!", ab());
        if (this.k.getAndAdd(i) == 0 && (awlVar = this.t) != null) {
            awlVar.k();
        }
    }

    public final boolean ab() {
        return this.s || this.q || this.v;
    }

    public final synchronized void ac() {
        boolean zD;
        if (this.l == null) {
            throw new IllegalArgumentException();
        }
        this.b.a.clear();
        this.l = null;
        this.t = null;
        this.o = null;
        this.s = false;
        this.v = false;
        this.q = false;
        this.w = false;
        ajr ajrVar = this.u;
        ajq ajqVar = ajrVar.j;
        synchronized (ajqVar) {
            ajqVar.a = true;
            zD = ajqVar.d();
        }
        if (zD) {
            ajrVar.as();
        }
        this.u = null;
        this.r = null;
        this.p = 0;
        this.e.l(this);
    }

    public final synchronized void ad(dht dhtVar) {
        try {
            this.c.b();
            this.b.a.remove(new awf(dhtVar, emn.aa));
            if (this.b.a.isEmpty()) {
                y();
                if (this.q || this.s) {
                    if (this.k.get() == 0) {
                        ac();
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // me.hd.wauxv.obf.axw
    public final dmn al() {
        return this.c;
    }

    public final synchronized void x(dht dhtVar, Executor executor) {
        try {
            this.c.b();
            this.b.a.add(new awf(dhtVar, executor));
            if (this.q) {
                aa(1);
                executor.execute(new awe(this, dhtVar, 1));
            } else if (this.s) {
                aa(1);
                executor.execute(new awe(this, dhtVar, 0));
            } else {
                cmz.k("Cannot add callbacks to a cancelled EngineJob", !this.v);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void y() {
        if (ab()) {
            return;
        }
        this.v = true;
        ajr ajrVar = this.u;
        ajrVar.af = true;
        ajd ajdVar = ajrVar.ad;
        if (ajdVar != null) {
            ajdVar.cancel();
        }
        awi awiVar = this.g;
        awj awjVar = this.l;
        awd awdVar = (awd) awiVar;
        synchronized (awdVar) {
            aji ajiVar = awdVar.b;
            ajiVar.getClass();
            HashMap map = ajiVar.b;
            if (equals(map.get(awjVar))) {
                map.remove(awjVar);
            }
        }
    }

    public final void z() {
        awl awlVar;
        synchronized (this) {
            try {
                this.c.b();
                cmz.k("Not yet complete!", ab());
                int iDecrementAndGet = this.k.decrementAndGet();
                cmz.k("Can't decrement below 0", iDecrementAndGet >= 0);
                if (iDecrementAndGet == 0) {
                    awlVar = this.t;
                    ac();
                } else {
                    awlVar = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (awlVar != null) {
            awlVar.l();
        }
    }
}
