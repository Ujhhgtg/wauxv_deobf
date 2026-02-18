package me.hd.wauxv.obf;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eln extends elm {
    public final /* synthetic */ ku a;
    public final /* synthetic */ elo b;

    public eln(elo eloVar, ku kuVar) {
        this.b = eloVar;
        this.a = kuVar;
    }

    @Override // me.hd.wauxv.obf.elm, me.hd.wauxv.obf.elk
    public final void e(ell ellVar) {
        ((ArrayList) this.a.get(this.b.b)).remove(ellVar);
        ellVar.n(this);
    }
}
