package me.hd.wauxv.obf;

import android.view.WindowInsets;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class evc extends evg {
    public final WindowInsets.Builder a;

    public evc() {
        this.a = dql.j();
    }

    @Override // me.hd.wauxv.obf.evg
    public void b(bps bpsVar) {
        this.a.setMandatorySystemGestureInsets(bpsVar.i());
    }

    @Override // me.hd.wauxv.obf.evg
    public void c(bps bpsVar) {
        this.a.setSystemGestureInsets(bpsVar.i());
    }

    @Override // me.hd.wauxv.obf.evg
    public void d(bps bpsVar) {
        this.a.setTappableElementInsets(bpsVar.i());
    }

    @Override // me.hd.wauxv.obf.evg
    public evr g() {
        l();
        evr evrVarD = evr.d(null, this.a.build());
        evrVarD.b.s(this.k);
        return evrVarD;
    }

    @Override // me.hd.wauxv.obf.evg
    public void h(bps bpsVar) {
        this.a.setStableInsets(bpsVar.i());
    }

    @Override // me.hd.wauxv.obf.evg
    public void i(bps bpsVar) {
        this.a.setSystemWindowInsets(bpsVar.i());
    }

    public evc(evr evrVar) {
        WindowInsets.Builder builderJ;
        super(evrVar);
        WindowInsets windowInsetsI = evrVar.i();
        if (windowInsetsI != null) {
            builderJ = dql.k(windowInsetsI);
        } else {
            builderJ = dql.j();
        }
        this.a = builderJ;
    }
}
