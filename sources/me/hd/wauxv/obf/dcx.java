package me.hd.wauxv.obf;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dcx implements Serializable {
    public final Throwable a;

    public dcx(Throwable th) {
        throwIfVar1IsNull(th, "exception");
        this.a = th;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof dcx) {
            return nullSafeIsEqual(this.a, ((dcx) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "Failure(" + this.a + ')';
    }
}
