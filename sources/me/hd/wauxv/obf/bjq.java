package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bjq extends eun {
    public final void a(alz alzVar) {
        alz alzVar2 = this.r;
        alzVar2.l.add(alzVar);
        alzVar.m.add(alzVar2);
    }

    @Override // me.hd.wauxv.obf.alx
    public final void c(alx alxVar) {
        alz alzVar = this.r;
        if (alzVar.d && !alzVar.k) {
            alzVar.p((int) ((((alz) alzVar.m.get(0)).h * ((bjp) this.l).a) + 0.5f));
        }
    }

    @Override // me.hd.wauxv.obf.eun
    public final void d() {
        adq adqVar = this.l;
        bjp bjpVar = (bjp) adqVar;
        int i = bjpVar.b;
        int i2 = bjpVar.c;
        int i3 = bjpVar.i;
        alz alzVar = this.r;
        if (i3 == 1) {
            if (i != -1) {
                alzVar.m.add(adqVar.bd.n.r);
                this.l.bd.n.r.l.add(alzVar);
                alzVar.g = i;
            } else if (i2 != -1) {
                alzVar.m.add(adqVar.bd.n.s);
                this.l.bd.n.s.l.add(alzVar);
                alzVar.g = -i2;
            } else {
                alzVar.b = true;
                alzVar.m.add(adqVar.bd.n.s);
                this.l.bd.n.s.l.add(alzVar);
            }
            a(this.l.n.r);
            a(this.l.n.s);
            return;
        }
        if (i != -1) {
            alzVar.m.add(adqVar.bd.o.r);
            this.l.bd.o.r.l.add(alzVar);
            alzVar.g = i;
        } else if (i2 != -1) {
            alzVar.m.add(adqVar.bd.o.s);
            this.l.bd.o.s.l.add(alzVar);
            alzVar.g = -i2;
        } else {
            alzVar.b = true;
            alzVar.m.add(adqVar.bd.o.s);
            this.l.bd.o.s.l.add(alzVar);
        }
        a(this.l.o.r);
        a(this.l.o.s);
    }

    @Override // me.hd.wauxv.obf.eun
    public final void e() {
        adq adqVar = this.l;
        int i = ((bjp) adqVar).i;
        alz alzVar = this.r;
        if (i == 1) {
            adqVar.bi = alzVar.h;
        } else {
            adqVar.bj = alzVar.h;
        }
    }

    @Override // me.hd.wauxv.obf.eun
    public final void f() {
        this.r.o();
    }

    @Override // me.hd.wauxv.obf.eun
    public final boolean h() {
        return false;
    }
}
