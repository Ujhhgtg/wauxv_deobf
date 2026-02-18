package me.hd.wauxv.obf;

import java.io.IOException;
import java.util.zip.Deflater;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class alr implements dhy {
    public final cyk a;
    public final Deflater b;
    public boolean c;

    public alr(rh rhVar, Deflater deflater) {
        this.a = emc.ag(rhVar);
        this.b = deflater;
    }

    @Override // me.hd.wauxv.obf.dhy, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        Deflater deflater = this.b;
        if (this.c) {
            return;
        }
        deflater.finish();
        d(false);
        th = null;
        try {
            deflater.end();
        } catch (Throwable th) {
            if (th == null) {
                th = th;
            }
        }
        try {
            this.a.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.c = true;
        if (th != null) {
            throw th;
        }
    }

    public final void d(boolean z) throws IOException {
        dfj dfjVarAg;
        int iDeflate;
        cyk cykVar = this.a;
        rh rhVar = cykVar.b;
        while (true) {
            dfjVarAg = rhVar.ag(1);
            byte[] bArr = dfjVarAg.a;
            Deflater deflater = this.b;
            if (z) {
                try {
                    int i = dfjVarAg.c;
                    iDeflate = deflater.deflate(bArr, i, 8192 - i, 2);
                } catch (NullPointerException e) {
                    throw new IOException("Deflater already closed", e);
                }
            } else {
                int i2 = dfjVarAg.c;
                iDeflate = deflater.deflate(bArr, i2, 8192 - i2);
            }
            if (iDeflate > 0) {
                dfjVarAg.c += iDeflate;
                rhVar.b += (long) iDeflate;
                cykVar.j();
            } else if (deflater.needsInput()) {
                break;
            }
        }
        if (dfjVarAg.b == dfjVarAg.c) {
            rhVar.a = dfjVarAg.h();
            dfl.d(dfjVarAg);
        }
    }

    @Override // me.hd.wauxv.obf.dhy, java.io.Flushable
    public final void flush() throws IOException {
        d(true);
        this.a.flush();
    }

    @Override // me.hd.wauxv.obf.dhy
    public final ekc timeout() {
        return this.a.a.timeout();
    }

    public final String toString() {
        return "DeflaterSink(" + this.a + ')';
    }

    @Override // me.hd.wauxv.obf.dhy
    public final void write(rh rhVar, long j) throws IOException {
        bzo.q(rhVar, "source");
        aye.n(rhVar.b, 0L, j);
        while (j > 0) {
            dfj dfjVar = rhVar.a;
            bzo.n(dfjVar);
            int iMin = (int) Math.min(j, dfjVar.c - dfjVar.b);
            this.b.setInput(dfjVar.a, dfjVar.b, iMin);
            d(false);
            long j2 = iMin;
            rhVar.b -= j2;
            int i = dfjVar.b + iMin;
            dfjVar.b = i;
            if (i == dfjVar.c) {
                rhVar.a = dfjVar.h();
                dfl.d(dfjVar);
            }
            j -= j2;
        }
    }
}
