package me.hd.wauxv.obf;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bdd extends bdh {
    public final /* synthetic */ bdj a;

    public bdd(bdj bdjVar) {
        this.a = bdjVar;
    }

    @Override // me.hd.wauxv.obf.bdh
    public final void b() {
        bdj bdjVar = this.a;
        ((deo) bdjVar.ck.b).i();
        aye.r(bdjVar);
        Bundle bundle = bdjVar.at;
        bdjVar.ck.aa(bundle != null ? bundle.getBundle("registryState") : null);
    }
}
