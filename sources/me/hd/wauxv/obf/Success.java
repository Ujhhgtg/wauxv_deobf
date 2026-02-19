package me.hd.wauxv.obf;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class Success implements Serializable {
    public final Object value;

    public static final Throwable exceptionOrNull(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).value;
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Success) {
            return nullSafeIsEqual(this.value, ((Success) obj).value);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.value;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        Object obj = this.value;
        if (obj instanceof Failure) {
            return ((Failure) obj).toString();
        }
        return "Success(" + obj + ')';
    }
}
