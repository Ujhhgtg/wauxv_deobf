package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dhu implements acy {
    public final /* synthetic */ ConnectivityMonitor b;

    public dhu(ConnectivityMonitor connectivityMonitorVar) {
        this.b = connectivityMonitorVar;
    }

    @Override // me.hd.wauxv.obf.acy
    public final void a(boolean z) {
        ArrayList arrayList;
        eot.d();
        synchronized (this.b) {
            arrayList = new ArrayList((HashSet) this.b.e);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((acy) it.next()).a(z);
        }
    }
}
