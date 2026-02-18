package me.hd.wauxv.obf;

import java.util.Iterator;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aqg implements dft, aqh {
    public final dft a;
    public final int b;

    public aqg(dft dftVar, int i) {
        throwIfVar1IsNull(dftVar, "sequence");
        this.a = dftVar;
        this.b = i;
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i
                + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH).toString());
    }

    @Override // me.hd.wauxv.obf.aqh
    public final dft c(int i) {
        int i2 = this.b + i;
        return i2 < 0 ? new aqg(this, i) : new aqg(this.a, i2);
    }

    @Override // me.hd.wauxv.obf.dft
    public final Iterator iterator() {
        return new aqf(this);
    }
}
