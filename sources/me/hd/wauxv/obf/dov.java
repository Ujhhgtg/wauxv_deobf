package me.hd.wauxv.obf;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dov implements btt, Serializable {
    public bfu a;
    public volatile Object b = arj.n;
    public final Object c = this;

    public dov(bfu bfuVar) {
        this.a = bfuVar;
    }

    @Override // me.hd.wauxv.obf.btt
    public final Object getValue() {
        Object objInvoke;
        Object obj = this.b;
        arj arjVar = arj.n;
        if (obj != arjVar) {
            return obj;
        }
        synchronized (this.c) {
            objInvoke = this.b;
            if (objInvoke == arjVar) {
                bfu bfuVar = this.a;
                throwIfVar1IsNull(bfuVar);
                objInvoke = bfuVar.invoke();
                this.b = objInvoke;
                this.a = null;
            }
        }
        return objInvoke;
    }

    public final String toString() {
        return this.b != arj.n ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
