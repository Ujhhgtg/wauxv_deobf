package me.hd.wauxv.obf;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class awf {
    public final dht a;
    public final Executor b;

    public awf(dht dhtVar, Executor executor) {
        this.a = dhtVar;
        this.b = executor;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof awf) {
            return this.a.equals(((awf) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
