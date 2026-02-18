package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class chk implements ajb, aja {
    public final ArrayList a;
    public final cuv c;
    public int g;
    public cvq h;
    public aja i;
    public List j;
    public boolean m;

    public chk(ArrayList arrayList, cuv cuvVar) {
        this.c = cuvVar;
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException("Must not be empty.");
        }
        this.a = arrayList;
        this.g = 0;
    }

    @Override // me.hd.wauxv.obf.aja
    public final void _bo(Object obj) {
        if (obj != null) {
            this.i._bo(obj);
        } else {
            n();
        }
    }

    @Override // me.hd.wauxv.obf.ajb
    public final Class b() {
        return ((ajb) this.a.get(0)).b();
    }

    @Override // me.hd.wauxv.obf.ajb
    public final void cancel() {
        this.m = true;
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((ajb) it.next()).cancel();
        }
    }

    @Override // me.hd.wauxv.obf.ajb
    public final void d() {
        List list = this.j;
        if (list != null) {
            this.c.l(list);
        }
        this.j = null;
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((ajb) it.next()).d();
        }
    }

    @Override // me.hd.wauxv.obf.ajb
    public final int e() {
        return ((ajb) this.a.get(0)).e();
    }

    @Override // me.hd.wauxv.obf.ajb
    public final void f(cvq cvqVar, aja ajaVar) {
        this.h = cvqVar;
        this.i = ajaVar;
        this.j = (List) this.c.acquire();
        ((ajb) this.a.get(this.g)).f(cvqVar, this);
        if (this.m) {
            cancel();
        }
    }

    @Override // me.hd.wauxv.obf.aja
    public final void k(Exception exc) {
        List list = this.j;
        cmz.n(list, "Argument must not be null");
        list.add(exc);
        n();
    }

    public final void n() {
        if (this.m) {
            return;
        }
        if (this.g < this.a.size() - 1) {
            this.g++;
            f(this.h, this.i);
        } else {
            cmz.m(this.j);
            this.i.k(new bhy("Fetch failed", new ArrayList(this.j)));
        }
    }
}
