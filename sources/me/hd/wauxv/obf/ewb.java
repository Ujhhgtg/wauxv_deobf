package me.hd.wauxv.obf;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ewb {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(ewb.class, Object.class, "lastScheduledTask$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(ewb.class, "producerIndex$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(ewb.class, "consumerIndex$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater d = AtomicIntegerFieldUpdater.newUpdater(ewb.class, "blockingTasksInBuffer$volatile");
    private volatile /* synthetic */ int blockingTasksInBuffer$volatile;
    private volatile /* synthetic */ int consumerIndex$volatile;
    public final AtomicReferenceArray e = new AtomicReferenceArray(128);
    private volatile /* synthetic */ Object lastScheduledTask$volatile;
    private volatile /* synthetic */ int producerIndex$volatile;

    public final dpy f() {
        dpy dpyVar;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = c;
            int i = atomicIntegerFieldUpdater.get(this);
            if (i - b.get(this) == 0) {
                return null;
            }
            int i2 = i & 127;
            if (atomicIntegerFieldUpdater.compareAndSet(this, i, i + 1) && (dpyVar = (dpy) this.e.getAndSet(i2, null)) != null) {
                if (dpyVar.ad) {
                    d.decrementAndGet(this);
                }
                return dpyVar;
            }
        }
    }

    public final dpy g(int i, boolean z) {
        int i2 = i & 127;
        AtomicReferenceArray atomicReferenceArray = this.e;
        dpy dpyVar = (dpy) atomicReferenceArray.get(i2);
        if (dpyVar != null && dpyVar.ad == z) {
            while (!atomicReferenceArray.compareAndSet(i2, dpyVar, null)) {
                if (atomicReferenceArray.get(i2) != dpyVar) {
                }
            }
            if (z) {
                d.decrementAndGet(this);
            }
            return dpyVar;
        }
        return null;
    }
}
