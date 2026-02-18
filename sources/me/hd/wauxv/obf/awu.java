package me.hd.wauxv.obf;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class awu extends awv implements als {
    public static final /* synthetic */ AtomicReferenceFieldUpdater p = AtomicReferenceFieldUpdater.newUpdater(awu.class, Object.class, "_queue$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater q = AtomicReferenceFieldUpdater.newUpdater(awu.class, Object.class, "_delayed$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater r = AtomicIntegerFieldUpdater.newUpdater(awu.class, "_isCompleted$volatile");
    private volatile /* synthetic */ Object _delayed$volatile;
    private volatile /* synthetic */ int _isCompleted$volatile;
    private volatile /* synthetic */ Object _queue$volatile;

    @Override // me.hd.wauxv.obf.als
    public final void _av(long j, tc tcVar) {
        long j2 = j > 0 ? j >= 9223372036854L ? Long.MAX_VALUE : 1000000 * j : 0L;
        if (j2 < 4611686018427387903L) {
            long jNanoTime = System.nanoTime();
            awr awrVar = new awr(this, j2 + jNanoTime, tcVar);
            w(jNanoTime, awrVar);
            bhv.ad(tcVar, new sz(awrVar, 1));
        }
    }

    @Override // me.hd.wauxv.obf.ahj
    public final void i(ahh ahhVar, Runnable runnable) {
        n(runnable);
    }

    public void n(Runnable runnable) {
        s();
        if (!t(runnable)) {
            akk.f.n(runnable);
            return;
        }
        Thread threadG = g();
        if (Thread.currentThread() != threadG) {
            LockSupport.unpark(threadG);
        }
    }

    public final void s() {
        aws awsVarE;
        awt awtVar = (awt) q.get(this);
        if (awtVar == null || drp.b.get(awtVar) == 0) {
            return;
        }
        long jNanoTime = System.nanoTime();
        do {
            synchronized (awtVar) {
                try {
                    aws[] awsVarArr = awtVar.c;
                    aws awsVar = awsVarArr != null ? awsVarArr[0] : null;
                    if (awsVar != null) {
                        awsVarE = ((jNanoTime - awsVar.c) > 0L ? 1 : ((jNanoTime - awsVar.c) == 0L ? 0 : -1)) >= 0 ? t(awsVar) : false ? awtVar.e(0) : null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } while (awsVarE != null);
    }

    @Override // me.hd.wauxv.obf.awv
    public void shutdown() {
        aws awsVarE;
        dro.a.set(null);
        r.set(this, 1);
        auj aujVar = emc.u;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = p;
        loop0: while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                do {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, null, aujVar)) {
                        break loop0;
                    }
                } while (atomicReferenceFieldUpdater.get(this) == null);
            } else if (obj instanceof bxo) {
                ((bxo) obj).i();
                break;
            } else {
                if (obj == aujVar) {
                    break;
                }
                bxo bxoVar = new bxo(8, true);
                bxoVar.h((Runnable) obj);
                do {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj, bxoVar)) {
                        break loop0;
                    }
                } while (atomicReferenceFieldUpdater.get(this) == obj);
            }
        }
        while (v() <= 0) {
        }
        long jNanoTime = System.nanoTime();
        while (true) {
            awt awtVar = (awt) q.get(this);
            if (awtVar == null) {
                return;
            }
            synchronized (awtVar) {
                awsVarE = drp.b.get(awtVar) > 0 ? awtVar.e(0) : null;
            }
            if (awsVarE == null) {
                return;
            } else {
                m(jNanoTime, awsVarE);
            }
        }
    }

    public final boolean t(Runnable runnable) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = p;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (r.get(this) == 1) {
                return false;
            }
            if (obj == null) {
                while (!atomicReferenceFieldUpdater.compareAndSet(this, null, runnable)) {
                    if (atomicReferenceFieldUpdater.get(this) != null) {
                    }
                }
                return true;
            }
            if (!(obj instanceof bxo)) {
                if (obj == emc.u) {
                    return false;
                }
                bxo bxoVar = new bxo(8, true);
                bxoVar.h((Runnable) obj);
                bxoVar.h(runnable);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, bxoVar)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                    }
                }
                return true;
            }
            bxo bxoVar2 = (bxo) obj;
            int iH = bxoVar2.h(runnable);
            if (iH == 0) {
                return true;
            }
            if (iH == 1) {
                bxo bxoVarJ = bxoVar2.j();
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, bxoVarJ) && atomicReferenceFieldUpdater.get(this) == obj) {
                }
            } else if (iH == 2) {
                return false;
            }
        }
    }

    /* JADX WARN: Found duplicated region for block: B:17:0x0027  */
    /* JADX WARN: Found duplicated region for block: B:20:0x0030  */
    /* JADX WARN: Found duplicated region for block: B:22:0x0034  */
    /* JADX WARN: Found duplicated region for block: B:24:0x004d A[RETURN] */
    /* JADX WARN: Found duplicated region for block: B:25:0x004e A[RETURN] */
    /* JADX WARN: Found duplicated region for block: B:26:0x004f  */
    public final boolean u() {
        Object obj;
        km kmVar = this.z;
        if (kmVar != null ? kmVar.isEmpty() : true) {
            awt awtVar = (awt) q.get(this);
            if (awtVar == null) {
                obj = p.get(this);
                if (obj != null) {
                    if (obj instanceof bxo) {
                        long j = bxo.b.get((bxo) obj);
                        return ((int) (1073741823 & j)) == ((int) ((j & 1152921503533105152L) >> 30));
                    }
                    if (obj == emc.u) {
                    }
                }
                return true;
            }
            if (drp.b.get(awtVar) == 0) {
                obj = p.get(this);
                if (obj != null) {
                    if (obj instanceof bxo) {
                        long j2 = bxo.b.get((bxo) obj);
                        if (((int) (1073741823 & j2)) == ((int) ((j2 & 1152921503533105152L) >> 30))) {
                        }
                    }
                    if (obj == emc.u) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final long v() {
        Runnable runnable;
        aws awsVar;
        auj aujVar = emc.u;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = p;
        if (!ac()) {
            s();
            loop0: while (true) {
                Object obj = atomicReferenceFieldUpdater.get(this);
                if (obj != null) {
                    if (obj instanceof bxo) {
                        bxo bxoVar = (bxo) obj;
                        Object objK = bxoVar.k();
                        if (objK != bxo.c) {
                            runnable = (Runnable) objK;
                            break;
                        }
                        bxo bxoVarJ = bxoVar.j();
                        while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, bxoVarJ) && atomicReferenceFieldUpdater.get(this) == obj) {
                        }
                    } else if (obj != aujVar) {
                        do {
                            if (atomicReferenceFieldUpdater.compareAndSet(this, obj, null)) {
                                runnable = (Runnable) obj;
                                break loop0;
                            }
                        } while (atomicReferenceFieldUpdater.get(this) == obj);
                    }
                }
                runnable = null;
                break;
            }
            if (runnable != null) {
                runnable.run();
                return 0L;
            }
            km kmVar = this.z;
            if (((kmVar == null || kmVar.isEmpty()) ? Long.MAX_VALUE : 0L) != 0) {
                Object obj2 = atomicReferenceFieldUpdater.get(this);
                if (obj2 != null) {
                    if (obj2 instanceof bxo) {
                        long j = bxo.b.get((bxo) obj2);
                        if (((int) (1073741823 & j)) != ((int) ((j & 1152921503533105152L) >> 30))) {
                            return 0L;
                        }
                    } else if (obj2 == aujVar) {
                        return Long.MAX_VALUE;
                    }
                }
                awt awtVar = (awt) q.get(this);
                if (awtVar != null) {
                    synchronized (awtVar) {
                        aws[] awsVarArr = awtVar.c;
                        awsVar = awsVarArr != null ? awsVarArr[0] : null;
                    }
                    if (awsVar != null) {
                        long jNanoTime = awsVar.c - System.nanoTime();
                        if (jNanoTime >= 0) {
                            return jNanoTime;
                        }
                    }
                }
                return Long.MAX_VALUE;
            }
        }
        return 0L;
    }

    public final void w(long j, aws awsVar) {
        int iF;
        Thread threadG;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = q;
        if (r.get(this) == 1) {
            iF = 1;
        } else {
            awt awtVar = (awt) atomicReferenceFieldUpdater.get(this);
            if (awtVar == null) {
                awt awtVar2 = new awt();
                awtVar2.a = j;
                while (!atomicReferenceFieldUpdater.compareAndSet(this, null, awtVar2) && atomicReferenceFieldUpdater.get(this) == null) {
                }
                Object obj = atomicReferenceFieldUpdater.get(this);
                bzo.n(obj);
                awtVar = (awt) obj;
            }
            iF = awsVar.f(j, awtVar, this);
        }
        if (iF != 0) {
            if (iF == 1) {
                m(j, awsVar);
                return;
            } else {
                if (iF != 2) {
                    throw new IllegalStateException("unexpected result");
                }
                return;
            }
        }
        awt awtVar3 = (awt) atomicReferenceFieldUpdater.get(this);
        if (awtVar3 != null) {
            synchronized (awtVar3) {
                aws[] awsVarArr = awtVar3.c;
                awsVar = awsVarArr != null ? awsVarArr[0] : null;
            }
        }
        if (awsVar != awsVar || Thread.currentThread() == (threadG = g())) {
            return;
        }
        LockSupport.unpark(threadG);
    }
}
