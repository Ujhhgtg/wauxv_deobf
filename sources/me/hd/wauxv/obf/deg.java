package me.hd.wauxv.obf;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class deg implements IHasGetValue, Serializable {
    public static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(deg.class, Object.class,
            "ᛱᛱᛱᛱᛲ");
    public volatile bfu b;
    public volatile Object c;

    @Override // me.hd.wauxv.obf.btt
    public final Object getValue() {
        Object obj = this.c;
        arj arjVar = arj.n;
        if (obj != arjVar) {
            return obj;
        }
        bfu bfuVar = this.b;
        if (bfuVar != null) {
            Object objInvoke = bfuVar.invoke();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, arjVar, objInvoke)) {
                if (atomicReferenceFieldUpdater.get(this) != arjVar) {
                }
            }
            this.b = null;
            return objInvoke;
        }
        return this.c;
    }

    public final String toString() {
        return this.c != arj.n ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
