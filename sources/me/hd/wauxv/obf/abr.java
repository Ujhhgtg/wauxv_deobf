package me.hd.wauxv.obf;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class abr {
    public static final /* synthetic */ AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(abr.class, "_handled$volatile");
    private volatile /* synthetic */ int _handled$volatile;
    public final Throwable c;

    public abr(Throwable th, boolean z) {
        this.c = th;
        this._handled$volatile = z ? 1 : 0;
    }

    public final String toString() {
        return getClass().getSimpleName() + TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH + this.c + ']';
    }
}
