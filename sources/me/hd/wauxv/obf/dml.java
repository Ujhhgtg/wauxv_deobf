package me.hd.wauxv.obf;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dml extends emn implements chy {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(dml.class, Object.class, "_state$volatile");
    private volatile /* synthetic */ Object _state$volatile;
    public int b;

    public dml(Object obj) {
        this._state$volatile = obj;
    }

    public final Object c() {
        auj aujVar = cnb.j;
        Object obj = a.get(this);
        if (obj == aujVar) {
            return null;
        }
        return obj;
    }

    public final void g(Object obj) {
        int i;
        if (obj == null) {
            obj = cnb.j;
        }
        synchronized (this) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
            if (bzo.f(atomicReferenceFieldUpdater.get(this), obj)) {
                return;
            }
            atomicReferenceFieldUpdater.set(this, obj);
            int i2 = this.b;
            if ((i2 & 1) != 0) {
                this.b = i2 + 2;
                return;
            }
            int i3 = i2 + 1;
            this.b = i3;
            while (true) {
                synchronized (this) {
                    i = this.b;
                    if (i == i3) {
                        this.b = i3 + 1;
                        return;
                    }
                }
                i3 = i;
            }
        }
    }
}
