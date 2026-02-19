package me.hd.wauxv.obf;

import java.io.Closeable;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;
import net.bytebuddy.asm.Advice;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aho implements Executor, Closeable {
    public static final /* synthetic */ AtomicLongFieldUpdater a = AtomicLongFieldUpdater.newUpdater(aho.class,
            "parkedWorkersStack$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater b = AtomicLongFieldUpdater.newUpdater(aho.class,
            "controlState$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(aho.class,
            "_isTerminated$volatile");
    public static final SpecificEmojiMatcher d = new SpecificEmojiMatcher("NOT_IN_STACK", 1);
    private volatile /* synthetic */ int _isTerminated$volatile;
    private volatile /* synthetic */ long controlState$volatile;
    public final int e;
    public final int f;
    public final long g;
    public final String h;
    public final bif i;
    public final bif j;
    public final dce k;
    private volatile /* synthetic */ long parkedWorkersStack$volatile;

    public aho(int i, int i2, long j, String str) {
        this.e = i;
        this.f = i2;
        this.g = j;
        this.h = str;
        if (i < 1) {
            throw new IllegalArgumentException(yg.f(i, "Core pool size ", " should be at least 1").toString());
        }
        if (i2 < i) {
            throw new IllegalArgumentException(
                    StaticHelpers6.p(i2, "Max pool size ", " should be greater than or equals to core pool size ", i).toString());
        }
        if (i2 > 2097150) {
            throw new IllegalArgumentException(
                    yg.f(i2, "Max pool size ", " should not exceed maximal supported number of threads 2097150")
                            .toString());
        }
        if (j <= 0) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j + " must be positive").toString());
        }
        this.i = new bif();
        this.j = new bif();
        this.k = new dce((i + 1) * 2);
        this.controlState$volatile = ((long) i) << 42;
    }

    /* JADX WARN: Found duplicated region for block: B:39:0x008a */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws InterruptedException {
        int i;
        dpy dpyVarJ;
        if (c.compareAndSet(this, 0, 1)) {
            Thread threadCurrentThread = Thread.currentThread();
            ahm ahmVar = threadCurrentThread instanceof ahm ? (ahm) threadCurrentThread : null;
            if (ahmVar == null || !nullSafeIsEqual(ahmVar.i, this)) {
                ahmVar = null;
            }
            synchronized (this.k) {
                i = (int) (b.get(this) & 2097151);
            }
            if (1 <= i) {
                int i2 = 1;
                while (true) {
                    Object objB = this.k.b(i2);
                    throwIfVar1IsNull(objB);
                    ahm ahmVar2 = (ahm) objB;
                    if (ahmVar2 != ahmVar) {
                        while (ahmVar2.getState() != Thread.State.TERMINATED) {
                            LockSupport.unpark(ahmVar2);
                            ahmVar2.join(10000L);
                        }
                        ewb ewbVar = ahmVar2.b;
                        bif bifVar = this.j;
                        ewbVar.getClass();
                        dpy dpyVar = (dpy) ewb.a.getAndSet(ewbVar, null);
                        if (dpyVar != null) {
                            bifVar.b(dpyVar);
                        }
                        while (true) {
                            dpy dpyVarF = ewbVar.f();
                            if (dpyVarF == null) {
                                break;
                            } else {
                                bifVar.b(dpyVarF);
                            }
                        }
                    }
                    if (i2 == i) {
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            this.j.c();
            this.i.c();
            while (true) {
                if (ahmVar != null) {
                    dpyVarJ = ahmVar.j(true);
                    if (dpyVarJ == null) {
                        dpyVarJ = (dpy) this.i.e();
                        if (dpyVarJ == null) {
                            break;
                            break;
                        }
                    }
                } else {
                    dpyVarJ = (dpy) this.i.e();
                    if (dpyVarJ == null && (dpyVarJ = (dpy) this.j.e()) == null) {
                        break;
                    }
                }
                try {
                    dpyVarJ.run();
                } catch (Throwable th) {
                    Thread threadCurrentThread2 = Thread.currentThread();
                    threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
                }
            }
            if (ahmVar != null) {
                ahmVar.q(ahn.e);
            }
            a.set(this, 0L);
            b.set(this, 0L);
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        m(runnable, false);
    }

    public final int l() {
        synchronized (this.k) {
            try {
                if (c.get(this) == 1) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = b;
                long j = atomicLongFieldUpdater.get(this);
                int i = (int) (j & 2097151);
                int i2 = i - ((int) ((j & 4398044413952L) >> 21));
                if (i2 < 0) {
                    i2 = 0;
                }
                if (i2 >= this.e) {
                    return 0;
                }
                if (i >= this.f) {
                    return 0;
                }
                int i3 = ((int) (atomicLongFieldUpdater.get(this) & 2097151)) + 1;
                if (i3 <= 0 || this.k.b(i3) != null) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                ahm ahmVar = new ahm(this, i3);
                this.k.c(i3, ahmVar);
                if (i3 != ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                int i4 = i2 + 1;
                ahmVar.start();
                return i4;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m(Runnable runnable, boolean z) {
        dpy dpzVar;
        ahn ahnVar;
        dqb.f.getClass();
        long jNanoTime = System.nanoTime();
        if (runnable instanceof dpy) {
            dpzVar = (dpy) runnable;
            dpzVar.ac = jNanoTime;
            dpzVar.ad = z;
        } else {
            dpzVar = new dpz(runnable, jNanoTime, z);
        }
        boolean z2 = dpzVar.ad;
        AtomicLongFieldUpdater atomicLongFieldUpdater = b;
        long jAddAndGet = z2 ? atomicLongFieldUpdater.addAndGet(this, 2097152L) : 0L;
        Thread threadCurrentThread = Thread.currentThread();
        ahm ahmVar = threadCurrentThread instanceof ahm ? (ahm) threadCurrentThread : null;
        if (ahmVar == null || !nullSafeIsEqual(ahmVar.i, this)) {
            ahmVar = null;
        }
        if (ahmVar != null && (ahnVar = ahmVar.d) != ahn.e && (dpzVar.ad || ahnVar != ahn.b)) {
            ahmVar.h = true;
            ewb ewbVar = ahmVar.b;
            ewbVar.getClass();
            dpzVar = (dpy) ewb.a.getAndSet(ewbVar, dpzVar);
            if (dpzVar == null) {
                dpzVar = null;
            } else {
                AtomicReferenceArray atomicReferenceArray = ewbVar.e;
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = ewb.b;
                if (atomicIntegerFieldUpdater.get(ewbVar) - ewb.c.get(ewbVar) != 127) {
                    if (dpzVar.ad) {
                        ewb.d.incrementAndGet(ewbVar);
                    }
                    int i = atomicIntegerFieldUpdater.get(ewbVar) & 127;
                    while (atomicReferenceArray.get(i) != null) {
                        Thread.yield();
                    }
                    atomicReferenceArray.lazySet(i, dpzVar);
                    atomicIntegerFieldUpdater.incrementAndGet(ewbVar);
                    dpzVar = null;
                }
            }
        }
        if (dpzVar != null) {
            if (!(dpzVar.ad ? this.j.b(dpzVar) : this.i.b(dpzVar))) {
                throw new RejectedExecutionException(yg.concatToVar1(new StringBuilder(), this.h, " was terminated"));
            }
        }
        if (z2) {
            if (p() || o(jAddAndGet)) {
                return;
            }
            p();
            return;
        }
        if (p() || o(atomicLongFieldUpdater.get(this))) {
            return;
        }
        p();
    }

    public final void n(ahm ahmVar, int i, int i2) {
        while (true) {
            long j = a.get(this);
            int i3 = (int) (2097151 & j);
            long j2 = (2097152 + j) & (-2097152);
            if (i3 == i) {
                if (i2 == 0) {
                    Object objL = ahmVar.l();
                    while (true) {
                        if (objL == d) {
                            i3 = -1;
                            break;
                        }
                        if (objL == null) {
                            i3 = 0;
                            break;
                        }
                        ahm ahmVar2 = (ahm) objL;
                        int iK = ahmVar2.k();
                        if (iK != 0) {
                            i3 = iK;
                            break;
                        }
                        objL = ahmVar2.l();
                    }
                } else {
                    i3 = i2;
                }
            }
            if (i3 >= 0) {
                if (a.compareAndSet(this, j, ((long) i3) | j2)) {
                    return;
                }
            }
        }
    }

    public final boolean o(long j) {
        int i = ((int) (2097151 & j)) - ((int) ((j & 4398044413952L) >> 21));
        if (i < 0) {
            i = 0;
        }
        int i2 = this.e;
        if (i < i2) {
            int iL = l();
            if (iL == 1 && i2 > 1) {
                l();
            }
            if (iL > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean p() {
        SpecificEmojiMatcher specificEmojiMatcherVar;
        int iK;
        while (true) {
            long j = a.get(this);
            ahm ahmVar = (ahm) this.k.b((int) (2097151 & j));
            if (ahmVar == null) {
                ahmVar = null;
            } else {
                long j2 = (2097152 + j) & (-2097152);
                Object objL = ahmVar.l();
                while (true) {
                    specificEmojiMatcherVar = d;
                    if (objL == specificEmojiMatcherVar) {
                        iK = -1;
                        break;
                    }
                    if (objL == null) {
                        iK = 0;
                        break;
                    }
                    ahm ahmVar2 = (ahm) objL;
                    iK = ahmVar2.k();
                    if (iK != 0) {
                        break;
                    }
                    objL = ahmVar2.l();
                }
                if (iK >= 0) {
                    if (a.compareAndSet(this, j, ((long) iK) | j2)) {
                        ahmVar.p(specificEmojiMatcherVar);
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
            if (ahmVar == null) {
                return false;
            }
            if (ahm.a.compareAndSet(ahmVar, -1, 0)) {
                LockSupport.unpark(ahmVar);
                return true;
            }
        }
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        dce dceVar = this.k;
        int iA = dceVar.a();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 1; i6 < iA; i6++) {
            ahm ahmVar = (ahm) dceVar.b(i6);
            if (ahmVar != null) {
                ewb ewbVar = ahmVar.b;
                ewbVar.getClass();
                int i7 = ewb.a.get(ewbVar) != null ? (ewb.b.get(ewbVar) - ewb.c.get(ewbVar)) + 1
                        : ewb.b.get(ewbVar) - ewb.c.get(ewbVar);
                int iOrdinal = ahmVar.d.ordinal();
                if (iOrdinal == 0) {
                    i++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(i7);
                    sb.append('c');
                    arrayList.add(sb.toString());
                } else if (iOrdinal == 1) {
                    i2++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i7);
                    sb2.append('b');
                    arrayList.add(sb2.toString());
                } else if (iOrdinal == 2) {
                    i3++;
                } else if (iOrdinal == 3) {
                    i4++;
                    if (i7 > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(i7);
                        sb3.append(Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL);
                        arrayList.add(sb3.toString());
                    }
                } else {
                    if (iOrdinal != 4) {
                        throw new QueryDidNotReturnUniqueResultRuntimeException();
                    }
                    i5++;
                }
            }
        }
        long j = b.get(this);
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.h);
        sb4.append('@');
        sb4.append(ajn.toHexHashCode(this));
        sb4.append("[Pool Size {core = ");
        int i8 = this.e;
        sb4.append(i8);
        sb4.append(", max = ");
        sb4.append(this.f);
        sb4.append("}, Worker States {CPU = ");
        sb4.append(i);
        sb4.append(", blocking = ");
        sb4.append(i2);
        sb4.append(", parked = ");
        sb4.append(i3);
        sb4.append(", dormant = ");
        sb4.append(i4);
        sb4.append(", terminated = ");
        sb4.append(i5);
        sb4.append("}, running workers queues = ");
        sb4.append(arrayList);
        sb4.append(", global CPU queue size = ");
        sb4.append(this.i.d());
        sb4.append(", global blocking queue size = ");
        sb4.append(this.j.d());
        sb4.append(", Control State {created workers= ");
        sb4.append((int) (2097151 & j));
        sb4.append(", blocking tasks = ");
        sb4.append((int) ((4398044413952L & j) >> 21));
        sb4.append(", CPUs acquired = ");
        sb4.append(i8 - ((int) ((j & 9223367638808264704L) >> 42)));
        sb4.append("}]");
        return sb4.toString();
    }
}
