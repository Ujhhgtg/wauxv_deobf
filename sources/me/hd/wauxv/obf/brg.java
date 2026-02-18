package me.hd.wauxv.obf;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class brg extends CancellationException {
    public final transient brm a;

    public brg(String str, Throwable th, brm brmVar) {
        super(str);
        this.a = brmVar;
        if (th != null) {
            initCause(th);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof brg)) {
            return false;
        }
        brg brgVar = (brg) obj;
        if (!nullSafeIsEqual(brgVar.getMessage(), getMessage())) {
            return false;
        }
        Object obj2 = brgVar.a;
        if (obj2 == null) {
            obj2 = com.f;
        }
        Object obj3 = this.a;
        if (obj3 == null) {
            obj3 = com.f;
        }
        return nullSafeIsEqual(obj2, obj3) && nullSafeIsEqual(brgVar.getCause(), getCause());
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public final int hashCode() {
        String message = getMessage();
        throwIfVar1IsNull(message);
        int iHashCode = message.hashCode() * 31;
        Object obj = this.a;
        if (obj == null) {
            obj = com.f;
        }
        int iHashCode2 = (iHashCode + (obj != null ? obj.hashCode() : 0)) * 31;
        Throwable cause = getCause();
        return iHashCode2 + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("; job=");
        Object obj = this.a;
        if (obj == null) {
            obj = com.f;
        }
        sb.append(obj);
        return sb.toString();
    }
}
