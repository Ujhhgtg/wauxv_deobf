package me.hd.wauxv.obf;

import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ec {
    public final WeakReference a;

    public ec(Object obj) {
        bzo.q(obj, "v");
        this.a = new WeakReference(obj);
    }

    public final Object b() {
        return this.a.get();
    }
}
