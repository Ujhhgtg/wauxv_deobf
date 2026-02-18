package me.hd.wauxv.obf;

import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cdt {
    public static final ArrayDeque a;
    public Object b;

    static {
        char[] cArr = eot.a;
        a = new ArrayDeque(0);
    }

    public static cdt c(Object obj) {
        cdt cdtVar;
        ArrayDeque arrayDeque = a;
        synchronized (arrayDeque) {
            cdtVar = (cdt) arrayDeque.poll();
        }
        if (cdtVar == null) {
            cdtVar = new cdt();
        }
        cdtVar.b = obj;
        return cdtVar;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof cdt) && this.b.equals(((cdt) obj).b);
    }

    public final int hashCode() {
        return this.b.hashCode();
    }
}
