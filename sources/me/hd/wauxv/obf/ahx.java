package me.hd.wauxv.obf;

import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ahx {
    public final LinkedHashMap c = new LinkedHashMap();

    public abstract Object b(ahw ahwVar);

    public final boolean equals(Object obj) {
        if (obj instanceof ahx) {
            return bzo.f(this.c, ((ahx) obj).c);
        }
        return false;
    }

    public final int hashCode() {
        return this.c.hashCode();
    }

    public final String toString() {
        return "CreationExtras(extras=" + this.c + ')';
    }
}
