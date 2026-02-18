package me.hd.wauxv.obf;

import java.io.EOFException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class pc implements dhy {
    @Override // me.hd.wauxv.obf.dhy, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // me.hd.wauxv.obf.dhy, java.io.Flushable
    public final void flush() {
    }

    @Override // me.hd.wauxv.obf.dhy
    public final ekc timeout() {
        return ekc.NONE;
    }

    @Override // me.hd.wauxv.obf.dhy
    public final void write(rh rhVar, long j) throws EOFException {
        bzo.q(rhVar, "source");
        rhVar.skip(j);
    }
}
