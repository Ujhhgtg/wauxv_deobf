package me.hd.wauxv.obf;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class lm implements dhy {
    public final /* synthetic */ int a;
    public final Object b;
    public final Object c;

    public /* synthetic */ lm(Object obj, int i, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // me.hd.wauxv.obf.dhy, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        switch (this.a) {
            case 0:
                lo loVar = (lo) this.b;
                dhy dhyVar = (dhy) this.c;
                loVar.enter();
                try {
                    try {
                        dhyVar.close();
                        if (loVar.exit()) {
                            throw loVar.access$newTimeoutException(null);
                        }
                        return;
                    } catch (IOException e) {
                        if (!loVar.exit()) {
                            throw e;
                        }
                        throw loVar.access$newTimeoutException(e);
                    }
                } catch (Throwable th) {
                    loVar.exit();
                    throw th;
                }
            default:
                ((OutputStream) this.b).close();
                return;
        }
    }

    @Override // me.hd.wauxv.obf.dhy, java.io.Flushable
    public final void flush() throws IOException {
        switch (this.a) {
            case 0:
                lo loVar = (lo) this.b;
                dhy dhyVar = (dhy) this.c;
                loVar.enter();
                try {
                    try {
                        dhyVar.flush();
                        if (loVar.exit()) {
                            throw loVar.access$newTimeoutException(null);
                        }
                        return;
                    } catch (IOException e) {
                        if (!loVar.exit()) {
                            throw e;
                        }
                        throw loVar.access$newTimeoutException(e);
                    }
                } catch (Throwable th) {
                    loVar.exit();
                    throw th;
                }
            default:
                ((OutputStream) this.b).flush();
                return;
        }
    }

    @Override // me.hd.wauxv.obf.dhy
    public final ekc timeout() {
        switch (this.a) {
            case 0:
                return (lo) this.b;
            default:
                return (ekc) this.c;
        }
    }

    public final String toString() {
        switch (this.a) {
            case 0:
                return "AsyncTimeout.sink(" + ((dhy) this.c) + ')';
            default:
                return "sink(" + ((OutputStream) this.b) + ')';
        }
    }

    /* JADX WARN: Found duplicated region for block: B:25:0x009e A[LOOP:1: B:12:0x0065->B:25:0x009e, LOOP_END] */
    /* JADX WARN: Found duplicated region for block: B:49:0x00a0 A[SYNTHETIC] */
    @Override // me.hd.wauxv.obf.dhy
    public final void write(rh rhVar, long j) throws IOException {
        lo loVar;
        switch (this.a) {
            case 0:
                bzo.q(rhVar, "source");
                aye.n(rhVar.b, 0L, j);
                long j2 = j;
                while (true) {
                    long j3 = 0;
                    if (j2 <= 0) {
                        return;
                    }
                    dfj dfjVar = rhVar.a;
                    bzo.n(dfjVar);
                    try {
                        try {
                            while (j3 < 65536) {
                                j3 += (long) (dfjVar.c - dfjVar.b);
                                if (j3 >= j2) {
                                    j3 = j2;
                                    loVar = (lo) this.b;
                                    dhy dhyVar = (dhy) this.c;
                                    loVar.enter();
                                    dhyVar.write(rhVar, j3);
                                    if (!loVar.exit()) {
                                        throw loVar.access$newTimeoutException(null);
                                    }
                                    j2 -= j3;
                                } else {
                                    dfjVar = dfjVar.f;
                                    bzo.n(dfjVar);
                                }
                            }
                            dhyVar.write(rhVar, j3);
                            if (!loVar.exit()) {
                                throw loVar.access$newTimeoutException(null);
                            }
                            j2 -= j3;
                        } catch (IOException e) {
                            if (!loVar.exit()) {
                                throw e;
                            }
                            throw loVar.access$newTimeoutException(e);
                        }
                    } catch (Throwable th) {
                        loVar.exit();
                        throw th;
                    }
                    loVar = (lo) this.b;
                    dhy dhyVar2 = (dhy) this.c;
                    loVar.enter();
                }
                break;
            default:
                bzo.q(rhVar, "source");
                aye.n(rhVar.b, 0L, j);
                while (j > 0) {
                    ((ekc) this.c).throwIfReached();
                    dfj dfjVar2 = rhVar.a;
                    bzo.n(dfjVar2);
                    int iMin = (int) Math.min(j, dfjVar2.c - dfjVar2.b);
                    ((OutputStream) this.b).write(dfjVar2.a, dfjVar2.b, iMin);
                    int i = dfjVar2.b + iMin;
                    dfjVar2.b = i;
                    long j4 = iMin;
                    j -= j4;
                    rhVar.b -= j4;
                    if (i == dfjVar2.c) {
                        rhVar.a = dfjVar2.h();
                        dfl.d(dfjVar2);
                    }
                }
                return;
        }
    }
}
