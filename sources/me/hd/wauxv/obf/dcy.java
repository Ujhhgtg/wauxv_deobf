package me.hd.wauxv.obf;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dcy implements Serializable {
    public final Object a;

    public static final Throwable b(Object obj) {
        if (obj instanceof dcx) {
            return ((dcx) obj).a;
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof dcy) {
            return bzo.f(this.a, ((dcy) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        Object obj = this.a;
        if (obj instanceof dcx) {
            return ((dcx) obj).toString();
        }
        return "Success(" + obj + ')';
    }
}
