package me.hd.wauxv.obf;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dny implements bno {
    public volatile boolean a = false;
    public final ConcurrentHashMap b = new ConcurrentHashMap();
    public final LinkedBlockingQueue c = new LinkedBlockingQueue();

    @Override // me.hd.wauxv.obf.bno
    public final synchronized bxs d() {
        dnx dnxVar;
        dnxVar = (dnx) this.b.get("KavaRef");
        if (dnxVar == null) {
            dnxVar = new dnx(this.c, this.a);
            this.b.put("KavaRef", dnxVar);
        }
        return dnxVar;
    }
}
