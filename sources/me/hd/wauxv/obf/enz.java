package me.hd.wauxv.obf;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class enz implements IHasGetValue, Serializable {
    public IFunction0 a;
    public Object b;

    @Override // me.hd.wauxv.obf.btt
    public final Object getValue() {
        if (this.b == arj.n) {
            IFunction0 bfuVar = this.a;
            throwIfVar1IsNull(bfuVar);
            this.b = bfuVar.invoke();
            this.a = null;
        }
        return this.b;
    }

    public final String toString() {
        return this.b != arj.n ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
