package me.hd.wauxv.obf;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bpd implements dlc {
    public final cyl a;
    public final Inflater b;
    public int c;
    public boolean d;

    public bpd(cyl cylVar, Inflater inflater) {
        this.a = cylVar;
        this.b = inflater;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.d) {
            return;
        }
        this.b.end();
        this.d = true;
        this.a.close();
    }

    public final long e(rh rhVar, long j) throws IOException {
        Inflater inflater = this.b;
        throwIfVar1IsNull(rhVar, "sink");
        if (j < 0) {
            throw new IllegalArgumentException(dts.b(j, "byteCount < 0: ").toString());
        }
        if (this.d) {
            throw new IllegalStateException("closed");
        }
        if (j != 0) {
            try {
                dfj dfjVarAg = rhVar.ag(1);
                int iMin = (int) Math.min(j, 8192 - dfjVarAg.c);
                boolean zNeedsInput = inflater.needsInput();
                cyl cylVar = this.a;
                if (zNeedsInput && !cylVar.i()) {
                    dfj dfjVar = cylVar.b.a;
                    throwIfVar1IsNull(dfjVar);
                    int i = dfjVar.c;
                    int i2 = dfjVar.b;
                    int i3 = i - i2;
                    this.c = i3;
                    inflater.setInput(dfjVar.a, i2, i3);
                }
                int iInflate = inflater.inflate(dfjVarAg.a, dfjVarAg.c, iMin);
                int i4 = this.c;
                if (i4 != 0) {
                    int remaining = i4 - inflater.getRemaining();
                    this.c -= remaining;
                    cylVar.skip(remaining);
                }
                if (iInflate > 0) {
                    dfjVarAg.c += iInflate;
                    long j2 = iInflate;
                    rhVar.b += j2;
                    return j2;
                }
                if (dfjVarAg.b == dfjVarAg.c) {
                    rhVar.a = dfjVarAg.h();
                    dfl.d(dfjVarAg);
                }
            } catch (DataFormatException e) {
                throw new IOException(e);
            }
        }
        return 0L;
    }

    @Override // me.hd.wauxv.obf.dlc
    public final long read(rh rhVar, long j) throws IOException {
        throwIfVar1IsNull(rhVar, "sink");
        do {
            long jE = e(rhVar, j);
            if (jE > 0) {
                return jE;
            }
            Inflater inflater = this.b;
            if (inflater.finished() || inflater.needsDictionary()) {
                return -1L;
            }
        } while (!this.a.i());
        throw new EOFException("source exhausted prematurely");
    }

    @Override // me.hd.wauxv.obf.dlc
    public final ekc timeout() {
        return this.a.a.timeout();
    }
}
