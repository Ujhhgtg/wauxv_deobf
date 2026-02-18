package me.hd.wauxv.obf;

import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aiy implements ajd, aja {
    public final List a;
    public final ajp b;
    public final ajc c;
    public int d = -1;
    public btj e;
    public List f;
    public int g;
    public volatile cdu h;
    public File i;

    public aiy(List list, ajp ajpVar, ajc ajcVar) {
        this.a = list;
        this.b = ajpVar;
        this.c = ajcVar;
    }

    @Override // me.hd.wauxv.obf.aja
    public final void _bo(Object obj) {
        this.c.a(this.e, obj, this.h.c, 3, this.e);
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
        while (true) {
            List list = this.f;
            boolean z = false;
            if (list != null && this.g < list.size()) {
                this.h = null;
                while (!z && this.g < this.f.size()) {
                    List list2 = this.f;
                    int i = this.g;
                    this.g = i + 1;
                    cdv cdvVar = (cdv) list2.get(i);
                    File file = this.i;
                    ajp ajpVar = this.b;
                    this.h = cdvVar.e(file, ajpVar.e, ajpVar.f, ajpVar.i);
                    if (this.h != null && this.b.u(this.h.c.b()) != null) {
                        this.h.c.f(this.b.o, this);
                        z = true;
                    }
                }
                return z;
            }
            int i2 = this.d + 1;
            this.d = i2;
            if (i2 >= this.a.size()) {
                return false;
            }
            btj btjVar = (btj) this.a.get(this.d);
            ajp ajpVar2 = this.b;
            File fileW = ajpVar2.h.c().w(new aiz(btjVar, ajpVar2.n));
            this.i = fileW;
            if (fileW != null) {
                this.e = btjVar;
                this.f = this.b.c.l().p(fileW);
                this.g = 0;
            }
        }
    }

    @Override // me.hd.wauxv.obf.aja
    public final void k(Exception exc) {
        this.c.b(this.e, exc, this.h.c, 3);
    }
}
