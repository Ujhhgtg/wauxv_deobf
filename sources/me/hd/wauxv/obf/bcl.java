package me.hd.wauxv.obf;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.Util;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bcl implements dlc {
    public boolean a;
    public final /* synthetic */ rm b;
    public final /* synthetic */ bck c;
    public final /* synthetic */ cyk d;

    public bcl(rm rmVar, bck bckVar, cyk cykVar) {
        this.b = rmVar;
        this.c = bckVar;
        this.d = cykVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (!this.a && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
            this.a = true;
            this.c.abort();
        }
        this.b.close();
    }

    @Override // me.hd.wauxv.obf.dlc
    public final long read(rh rhVar, long j) throws IOException {
        throwIfVar1IsNull(rhVar, "sink");
        try {
            long j2 = this.b.read(rhVar, j);
            cyk cykVar = this.d;
            if (j2 == -1) {
                if (!this.a) {
                    this.a = true;
                    cykVar.close();
                }
                return -1L;
            }
            rhVar.l(rhVar.b - j2, cykVar.b, j2);
            cykVar.j();
            return j2;
        } catch (IOException e) {
            if (this.a) {
                throw e;
            }
            this.a = true;
            this.c.abort();
            throw e;
        }
    }

    @Override // me.hd.wauxv.obf.dlc
    public final ekc timeout() {
        return this.b.timeout();
    }
}
