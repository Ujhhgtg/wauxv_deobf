package me.hd.wauxv.obf;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class buw extends ahj implements als {
    public static final /* synthetic */ AtomicIntegerFieldUpdater f = AtomicIntegerFieldUpdater.newUpdater(buw.class, "runningWorkers$volatile");
    public final /* synthetic */ als g;
    public final ahj l;
    public final int m;
    public final bxm n;
    public final Object o;
    private volatile /* synthetic */ int runningWorkers$volatile;

    /* JADX WARN: Multi-variable type inference failed */
    public buw(ahj ahjVar, int i) {
        als alsVar = ahjVar instanceof als ? (als) ahjVar : null;
        this.g = alsVar == null ? akl.a : alsVar;
        this.l = ahjVar;
        this.m = i;
        this.n = new bxm();
        this.o = new Object();
    }

    @Override // me.hd.wauxv.obf.als
    public final void _av(long j, tc tcVar) {
        this.g._av(j, tcVar);
    }

    @Override // me.hd.wauxv.obf.ahj
    public final void i(ahh ahhVar, Runnable runnable) {
        this.n.b(runnable);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f;
        if (atomicIntegerFieldUpdater.get(this) < this.m) {
            synchronized (this.o) {
                if (atomicIntegerFieldUpdater.get(this) >= this.m) {
                    return;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
                Runnable runnableP = p();
                if (runnableP == null) {
                    return;
                }
                try {
                    cnf.bl(this.l, this, new cs(this, 8, runnableP));
                } catch (Throwable th) {
                    f.decrementAndGet(this);
                    throw th;
                }
            }
        }
    }

    public final Runnable p() {
        while (true) {
            Runnable runnable = (Runnable) this.n.e();
            if (runnable != null) {
                return runnable;
            }
            synchronized (this.o) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.n.d() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }

    @Override // me.hd.wauxv.obf.ahj
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.l);
        sb.append(".limitedParallelism(");
        return dkz.v(sb, this.m, ')');
    }
}
