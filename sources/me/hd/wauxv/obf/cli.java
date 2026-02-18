package me.hd.wauxv.obf;

import android.os.SystemClock;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cli extends bda {
    public final /* synthetic */ clj a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cli(rm rmVar, clj cljVar) {
        super(rmVar);
        this.a = cljVar;
    }

    @Override // me.hd.wauxv.obf.bda, me.hd.wauxv.obf.dlc
    public final long read(rh rhVar, long j) throws Exception {
        clj cljVar = this.a;
        clc clcVar = cljVar.c;
        ConcurrentLinkedQueue concurrentLinkedQueue = cljVar.b;
        bzo.q(rhVar, "sink");
        try {
            long j2 = super.read(rhVar, j);
            if (concurrentLinkedQueue != null && !concurrentLinkedQueue.isEmpty()) {
                SystemClock.elapsedRealtime();
                Iterator it = concurrentLinkedQueue.iterator();
                if (it.hasNext()) {
                    if (it.next() == null) {
                        throw null;
                    }
                    throw new ClassCastException();
                }
            }
            if (j2 == -1 && clcVar != null) {
                clcVar.invoke();
            }
            return j2;
        } catch (Exception e) {
            if (clcVar != null) {
                clcVar.invoke();
            }
            throw e;
        }
    }
}
