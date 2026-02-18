package me.hd.wauxv.obf;

import java.io.IOException;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.DiskLruCache;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bck implements CacheRequest {
    public final DiskLruCache.Editor a;
    public final dhy b;
    public final bcj c;
    public boolean d;
    public final /* synthetic */ bcm e;

    public bck(bcm bcmVar, DiskLruCache.Editor editor) {
        this.e = bcmVar;
        this.a = editor;
        dhy dhyVarNewSink = editor.newSink(1);
        this.b = dhyVarNewSink;
        this.c = new bcj(bcmVar, this, dhyVarNewSink);
    }

    @Override // okhttp3.internal.cache.CacheRequest
    public final void abort() {
        synchronized (this.e) {
            if (this.d) {
                return;
            }
            this.d = true;
            Util.closeQuietly(this.b);
            try {
                this.a.abort();
            } catch (IOException unused) {
            }
        }
    }

    @Override // okhttp3.internal.cache.CacheRequest
    public final dhy body() {
        return this.c;
    }
}
