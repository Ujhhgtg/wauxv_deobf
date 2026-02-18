package me.hd.wauxv.obf;

import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cds extends byi {
    @Override // me.hd.wauxv.obf.byi
    public final void f(Object obj, Object obj2) {
        cdt cdtVar = (cdt) obj;
        cdtVar.getClass();
        ArrayDeque arrayDeque = cdt.a;
        synchronized (arrayDeque) {
            arrayDeque.offer(cdtVar);
        }
    }
}
