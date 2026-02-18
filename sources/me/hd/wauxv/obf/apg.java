package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class apg extends p {
    public final /* synthetic */ int h;
    public final pd i;

    public apg(int i) {
        this.h = i;
        switch (i) {
            case 1:
                this.i = new drl();
                break;
            default:
                this.i = new bmr(1);
                break;
        }
    }

    private final void j(CharSequence charSequence) {
    }

    @Override // me.hd.wauxv.obf.p
    public void a(CharSequence charSequence) {
        int i = this.h;
    }

    @Override // me.hd.wauxv.obf.p
    public boolean b(pd pdVar) {
        switch (this.h) {
            case 0:
                return true;
            default:
                return super.b(pdVar);
        }
    }

    @Override // me.hd.wauxv.obf.p
    public final pd d() {
        switch (this.h) {
            case 0:
                return (bmr) this.i;
            default:
                return (drl) this.i;
        }
    }

    @Override // me.hd.wauxv.obf.p
    public boolean e() {
        switch (this.h) {
            case 0:
                return true;
            default:
                return super.e();
        }
    }

    @Override // me.hd.wauxv.obf.p
    public final pf g(aph aphVar) {
        switch (this.h) {
            case 0:
                return pf.d(aphVar.d);
            default:
                return null;
        }
    }
}
