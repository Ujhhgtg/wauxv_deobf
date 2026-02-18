package me.hd.wauxv.obf;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ada implements dft {
    public final AtomicReference a;

    public ada(dft dftVar) {
        this.a = new AtomicReference(dftVar);
    }

    @Override // me.hd.wauxv.obf.dft
    public final Iterator iterator() {
        dft dftVar = (dft) this.a.getAndSet(null);
        if (dftVar != null) {
            return dftVar.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
