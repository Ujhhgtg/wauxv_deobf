package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eks extends StaticHelpers7 {
    public final /* synthetic */ int a;
    public boolean b;
    public int c;
    public final /* synthetic */ Object g;

    public eks(ekt ektVar, int i) {
        this.a = 0;
        this.g = ektVar;
        this.c = i;
        this.b = false;
    }

    @Override // me.hd.wauxv.obf.emn, me.hd.wauxv.obf.esi
    public void d() {
        switch (this.a) {
            case 0:
                this.b = true;
                break;
        }
    }

    @Override // me.hd.wauxv.obf.emn, me.hd.wauxv.obf.esi
    public final void e() {
        switch (this.a) {
            case 0:
                ((ekt) this.g).a.setVisibility(0);
                break;
            default:
                if (!this.b) {
                    this.b = true;
                    esi esiVar = ((esh) this.g).d;
                    if (esiVar != null) {
                        esiVar.e();
                    }
                    break;
                }
                break;
        }
    }

    @Override // me.hd.wauxv.obf.esi
    public final void f() {
        switch (this.a) {
            case 0:
                if (!this.b) {
                    ((ekt) this.g).a.setVisibility(this.c);
                }
                break;
            default:
                int i = this.c + 1;
                this.c = i;
                esh eshVar = (esh) this.g;
                if (i == eshVar.a.size()) {
                    esi esiVar = eshVar.d;
                    if (esiVar != null) {
                        esiVar.f();
                    }
                    this.c = 0;
                    this.b = false;
                    eshVar.e = false;
                }
                break;
        }
    }

    public eks(esh eshVar) {
        this.a = 1;
        this.g = eshVar;
        this.b = false;
        this.c = 0;
    }
}
