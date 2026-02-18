package me.hd.wauxv.obf;

import android.os.Bundle;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class deo {
    public final dep a;
    public final cfx b;
    public boolean e;
    public Bundle f;
    public boolean g;
    public final dop c = new dop(3);
    public final LinkedHashMap d = new LinkedHashMap();
    public boolean h = true;

    public deo(dep depVar, cfx cfxVar) {
        this.a = depVar;
        this.b = cfxVar;
    }

    public final void i() {
        dep depVar = this.a;
        if (depVar.ap().c != buh.b) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        if (this.e) {
            throw new IllegalStateException("SavedStateRegistry was already attached.");
        }
        this.b.invoke();
        depVar.ap().j(new bel(this, 2));
        this.e = true;
    }
}
