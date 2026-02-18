package me.hd.wauxv.obf;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dbz implements acy {
    public final dhx b;
    public final /* synthetic */ dca c;

    public dbz(dca dcaVar, dhx dhxVar) {
        this.c = dcaVar;
        this.b = dhxVar;
    }

    @Override // me.hd.wauxv.obf.acy
    public final void a(boolean z) {
        if (z) {
            synchronized (this.c) {
                dhx dhxVar = this.b;
                for (dbs dbsVar : eot.h((Set) dhxVar.d)) {
                    if (!dbsVar.q() && !dbsVar.m()) {
                        dbsVar.clear();
                        if (dhxVar.c) {
                            ((HashSet) dhxVar.e).add(dbsVar);
                        } else {
                            dbsVar.n();
                        }
                    }
                }
            }
        }
    }
}
