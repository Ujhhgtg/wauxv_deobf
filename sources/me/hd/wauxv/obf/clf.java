package me.hd.wauxv.obf;

import android.os.SystemClock;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class clf extends bcz {
    public final /* synthetic */ clg a;

    /*
     * JADX WARN: 'super' call moved to the top of the method (can break code
     * semantics)
     */
    public clf(rl rlVar, clg clgVar) {
        super(rlVar);
        this.a = clgVar;
    }

    @Override // me.hd.wauxv.obf.bcz, me.hd.wauxv.obf.dhy
    public final void write(rh rhVar, long j) {
        throwIfVar1IsNull(rhVar, "source");
        super.write(rhVar, j);
        ConcurrentLinkedQueue concurrentLinkedQueue = this.a.b;
        if (concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
            return;
        }
        SystemClock.elapsedRealtime();
        Iterator it = concurrentLinkedQueue.iterator();
        if (it.hasNext()) {
            throw yg.d(it);
        }
    }
}
