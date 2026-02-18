package me.hd.wauxv.obf;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ln implements dlc {
    public final /* synthetic */ int a = 1;
    public final Object b;
    public final Object c;

    public ln(InputStream inputStream, ekc ekcVar) {
        bzo.q(ekcVar, "timeout");
        this.b = inputStream;
        this.c = ekcVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        switch (this.a) {
            case 0:
                lo loVar = (lo) this.b;
                dlc dlcVar = (dlc) this.c;
                loVar.enter();
                try {
                    try {
                        dlcVar.close();
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
                ((InputStream) this.b).close();
                return;
        }
    }

    @Override // me.hd.wauxv.obf.dlc
    public final long read(rh rhVar, long j) throws IOException {
        switch (this.a) {
            case 0:
                bzo.q(rhVar, "sink");
                lo loVar = (lo) this.b;
                dlc dlcVar = (dlc) this.c;
                loVar.enter();
                try {
                    try {
                        long j2 = dlcVar.read(rhVar, j);
                        if (loVar.exit()) {
                            throw loVar.access$newTimeoutException(null);
                        }
                        return j2;
                    } catch (IOException e) {
                        if (loVar.exit()) {
                            throw loVar.access$newTimeoutException(e);
                        }
                        throw e;
                    }
                } catch (Throwable th) {
                    loVar.exit();
                    throw th;
                }
            default:
                bzo.q(rhVar, "sink");
                if (j == 0) {
                    return 0L;
                }
                if (j < 0) {
                    throw new IllegalArgumentException(dts.b(j, "byteCount < 0: ").toString());
                }
                try {
                    ((ekc) this.c).throwIfReached();
                    dfj dfjVarAg = rhVar.ag(1);
                    int i = ((InputStream) this.b).read(dfjVarAg.a, dfjVarAg.c, (int) Math.min(j, 8192 - dfjVarAg.c));
                    if (i == -1) {
                        if (dfjVarAg.b == dfjVarAg.c) {
                            rhVar.a = dfjVarAg.h();
                            dfl.d(dfjVarAg);
                        }
                        return -1L;
                    }
                    dfjVarAg.c += i;
                    long j3 = i;
                    rhVar.b += j3;
                    return j3;
                } catch (AssertionError e2) {
                    if (emc.ar(e2)) {
                        throw new IOException(e2);
                    }
                    throw e2;
                }
        }
    }

    @Override // me.hd.wauxv.obf.dlc
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
                return "AsyncTimeout.source(" + ((dlc) this.c) + ')';
            default:
                return "source(" + ((InputStream) this.b) + ')';
        }
    }

    public ln(lo loVar, dlc dlcVar) {
        this.b = loVar;
        this.c = dlcVar;
    }
}
