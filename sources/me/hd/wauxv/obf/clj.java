package me.hd.wauxv.obf;

import android.os.SystemClock;
import java.util.concurrent.ConcurrentLinkedQueue;
import okhttp3.MediaType;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class clj extends ResponseBody {
    public final ResponseBody a;
    public final ConcurrentLinkedQueue b;
    public final clc c;
    public final Kotlin$Lazy d;
    public final Kotlin$Lazy e;

    public clj(ResponseBody responseBody, ConcurrentLinkedQueue concurrentLinkedQueue, clc clcVar) {
        this.a = responseBody;
        this.b = concurrentLinkedQueue;
        this.c = clcVar;
        SystemClock.elapsedRealtime();
        this.d = new Kotlin$Lazy(new clh(this, 0));
        this.e = new Kotlin$Lazy(new clh(this, 1));
    }

    @Override // okhttp3.ResponseBody
    public final long contentLength() {
        return ((Number) this.e.getValue()).longValue();
    }

    @Override // okhttp3.ResponseBody
    public final MediaType contentType() {
        return this.a.contentType();
    }

    @Override // okhttp3.ResponseBody
    public final rm source() {
        return (rm) this.d.getValue();
    }
}
