package me.hd.wauxv.obf;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class Dispatchers$IO extends axe implements Executor {
    public static final Dispatchers$IO INSTANCE = new Dispatchers$IO();
    public static final Dispatcher g;

    static {
        enw enwVar = enw.f;
        int i = JustAStaticField.availableProcessors;
        if (64 >= i) {
            i = 64;
        }
        g = enwVar.k(ResourcesCompat.af("kotlinx.coroutines.io.parallelism", i, 12));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        i(EmptyCoroutineContext.INSTANCE, runnable);
    }

    @Override // me.hd.wauxv.obf.ahj
    public final void i(ahh ahhVar, Runnable runnable) {
        g.i(ahhVar, runnable);
    }

    @Override // me.hd.wauxv.obf.ahj
    public final String toString() {
        return "Dispatchers.IO";
    }
}
