package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class Dispatchers$Default extends dew {
    public static final Dispatchers$Default f;

    static {
        int i = dqb.c;
        int i2 = dqb.d;
        long j = dqb.e;
        String str = dqb.a;
        Dispatchers$Default alcVar = new Dispatchers$Default();
        alcVar.g = new aho(i, i2, j, str);
        f = alcVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // me.hd.wauxv.obf.ahj
    public final String toString() {
        return "Dispatchers.Default";
    }
}
