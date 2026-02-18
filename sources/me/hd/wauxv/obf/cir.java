package me.hd.wauxv.obf;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cir {
    public final xe a;

    public cir(cio cioVar) {
        this.a = new xe(cioVar, cioVar.b.g.a);
    }

    public cir(Bundle bundle) {
        bzo.q(bundle, "state");
        bundle.setClassLoader(cir.class.getClassLoader());
        this.a = new xe(bundle);
    }
}
