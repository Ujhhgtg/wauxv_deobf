package me.hd.wauxv.obf;

import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class tt extends elm {
    public boolean a = false;
    public final ViewGroup b;

    public tt(ViewGroup viewGroup) {
        this.b = viewGroup;
    }

    @Override // me.hd.wauxv.obf.elm, me.hd.wauxv.obf.elk
    public final void c(ell ellVar) {
        dqc.tryGetClassByName(this.b, false);
        this.a = true;
    }

    @Override // me.hd.wauxv.obf.elm, me.hd.wauxv.obf.elk
    public final void d() {
        dqc.tryGetClassByName(this.b, false);
    }

    @Override // me.hd.wauxv.obf.elm, me.hd.wauxv.obf.elk
    public final void e(ell ellVar) {
        if (!this.a) {
            dqc.tryGetClassByName(this.b, false);
        }
        ellVar.n(this);
    }

    @Override // me.hd.wauxv.obf.elm, me.hd.wauxv.obf.elk
    public final void f() {
        dqc.tryGetClassByName(this.b, true);
    }
}
