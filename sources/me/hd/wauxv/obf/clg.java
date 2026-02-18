package me.hd.wauxv.obf;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.internal.Util;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class clg extends RequestBody {
    public final RequestBody a;
    public final ConcurrentLinkedQueue b;
    public final afc c = new afc();
    public final dov d = new dov(new cle(this, 0));

    public clg(RequestBody requestBody, ConcurrentLinkedQueue concurrentLinkedQueue) {
        this.a = requestBody;
        this.b = concurrentLinkedQueue;
    }

    @Override // okhttp3.RequestBody
    public final long contentLength() {
        return ((Number) this.d.getValue()).longValue();
    }

    @Override // okhttp3.RequestBody
    public final MediaType contentType() {
        return this.a.contentType();
    }

    @Override // okhttp3.RequestBody
    public final void writeTo(rl rlVar) {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        throwIfVar1IsNull(rlVar, "sink");
        boolean z = rlVar instanceof rh;
        RequestBody requestBody = this.a;
        if (z || dnj.ab(rlVar.toString(), "com.android.tools.profiler.support.network.HttpTracker$OutputStreamTracker",
                false)) {
            requestBody.writeTo(rlVar);
            return;
        }
        cyk cykVarAg = emc.ag(new clf(rlVar, this));
        requestBody.writeTo(cykVarAg);
        Util.closeQuietly(cykVarAg);
        if (((Number) this.d.getValue()).longValue() != -1 || (concurrentLinkedQueue = this.b) == null) {
            return;
        }
        Iterator it = concurrentLinkedQueue.iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            this.c.b = true;
            throw null;
        }
    }
}
