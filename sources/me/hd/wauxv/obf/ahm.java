package me.hd.wauxv.obf;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ahm extends Thread {
    public static final /* synthetic */ AtomicIntegerFieldUpdater a = AtomicIntegerFieldUpdater.newUpdater(ahm.class, "workerCtl$volatile");
    public final ewb b;
    public final dai c;
    public ahn d;
    public long e;
    public long f;
    public int g;
    public boolean h;
    public final /* synthetic */ aho i;
    private volatile int indexInArray;
    private volatile Object nextParkedWorker;
    private volatile /* synthetic */ int workerCtl$volatile;

    public ahm(aho ahoVar, int i) {
        this.i = ahoVar;
        setDaemon(true);
        setContextClassLoader(aho.class.getClassLoader());
        this.b = new ewb();
        this.c = new dai();
        this.d = ahn.d;
        this.nextParkedWorker = aho.d;
        int iNanoTime = (int) System.nanoTime();
        this.g = iNanoTime == 0 ? 42 : iNanoTime;
        o(i);
    }

    public final dpy j(boolean z) {
        dpy dpyVarN;
        dpy dpyVarN2;
        long j;
        ahn ahnVar = this.d;
        aho ahoVar = this.i;
        dpy dpyVar = null;
        ewb ewbVar = this.b;
        ahn ahnVar2 = ahn.a;
        if (ahnVar != ahnVar2) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = aho.b;
            do {
                j = atomicLongFieldUpdater.get(ahoVar);
                if (((int) ((9223367638808264704L & j) >> 42)) == 0) {
                    ewbVar.getClass();
                    loop1: while (true) {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ewb.a;
                        dpy dpyVar2 = (dpy) atomicReferenceFieldUpdater.get(ewbVar);
                        if (dpyVar2 == null || !dpyVar2.ad) {
                            int i = ewb.c.get(ewbVar);
                            int i2 = ewb.b.get(ewbVar);
                            while (i != i2 && ewb.d.get(ewbVar) != 0) {
                                i2--;
                                dpy dpyVarG = ewbVar.g(i2, true);
                                if (dpyVarG != null) {
                                    dpyVar = dpyVarG;
                                    break;
                                }
                            }
                            break;
                        }
                        do {
                            if (atomicReferenceFieldUpdater.compareAndSet(ewbVar, dpyVar2, null)) {
                                dpyVar = dpyVar2;
                                break loop1;
                            }
                        } while (atomicReferenceFieldUpdater.get(ewbVar) == dpyVar2);
                    }
                    if (dpyVar != null) {
                        return dpyVar;
                    }
                    dpy dpyVar3 = (dpy) ahoVar.j.e();
                    return dpyVar3 == null ? r(1) : dpyVar3;
                }
            } while (!aho.b.compareAndSet(ahoVar, j, j - 4398046511104L));
            this.d = ahnVar2;
        }
        if (z) {
            boolean z2 = m(ahoVar.e * 2) == 0;
            if (z2 && (dpyVarN2 = n()) != null) {
                return dpyVarN2;
            }
            ewbVar.getClass();
            dpy dpyVarF = (dpy) ewb.a.getAndSet(ewbVar, null);
            if (dpyVarF == null) {
                dpyVarF = ewbVar.f();
            }
            if (dpyVarF != null) {
                return dpyVarF;
            }
            if (!z2 && (dpyVarN = n()) != null) {
                return dpyVarN;
            }
        } else {
            dpy dpyVarN3 = n();
            if (dpyVarN3 != null) {
                return dpyVarN3;
            }
        }
        return r(3);
    }

    public final int k() {
        return this.indexInArray;
    }

    public final Object l() {
        return this.nextParkedWorker;
    }

    public final int m(int i) {
        int i2 = this.g;
        int i3 = i2 ^ (i2 << 13);
        int i4 = i3 ^ (i3 >> 17);
        int i5 = i4 ^ (i4 << 5);
        this.g = i5;
        int i6 = i - 1;
        return (i6 & i) == 0 ? i5 & i6 : (i5 & Integer.MAX_VALUE) % i;
    }

    public final dpy n() {
        int iM = m(2);
        aho ahoVar = this.i;
        if (iM == 0) {
            dpy dpyVar = (dpy) ahoVar.i.e();
            return dpyVar != null ? dpyVar : (dpy) ahoVar.j.e();
        }
        dpy dpyVar2 = (dpy) ahoVar.j.e();
        return dpyVar2 != null ? dpyVar2 : (dpy) ahoVar.i.e();
    }

    public final void o(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.i.h);
        sb.append("-worker-");
        sb.append(i == 0 ? "TERMINATED" : String.valueOf(i));
        setName(sb.toString());
        this.indexInArray = i;
    }

    public final void p(Object obj) {
        this.nextParkedWorker = obj;
    }

    public final boolean q(ahn ahnVar) {
        ahn ahnVar2 = this.d;
        boolean z = ahnVar2 == ahn.a;
        if (z) {
            aho.b.addAndGet(this.i, 4398046511104L);
        }
        if (ahnVar2 != ahnVar) {
            this.d = ahnVar;
        }
        return z;
    }

    public final dpy r(int i) {
        long j;
        dpy dpyVarG;
        long j2;
        long j3;
        dpy dpyVar;
        AtomicLongFieldUpdater atomicLongFieldUpdater = aho.b;
        aho ahoVar = this.i;
        int i2 = (int) (atomicLongFieldUpdater.get(ahoVar) & 2097151);
        dpy dpyVar2 = null;
        if (i2 < 2) {
            return null;
        }
        int iM = m(i2);
        int i3 = 0;
        long jMin = Long.MAX_VALUE;
        while (i3 < i2) {
            iM++;
            if (iM > i2) {
                iM = 1;
            }
            ahm ahmVar = (ahm) ahoVar.k.b(iM);
            if (ahmVar != null && ahmVar != this) {
                ewb ewbVar = ahmVar.b;
                if (i != 3) {
                    ewbVar.getClass();
                    int i4 = ewb.c.get(ewbVar);
                    int i5 = ewb.b.get(ewbVar);
                    boolean z = i == 1;
                    while (true) {
                        if (i4 != i5) {
                            j = 0;
                            if (!z || ewb.d.get(ewbVar) != 0) {
                                int i6 = i4 + 1;
                                dpyVarG = ewbVar.g(i4, z);
                                if (dpyVarG != null) {
                                    break;
                                }
                                i4 = i6;
                            }
                        } else {
                            j = 0;
                        }
                        dpyVarG = dpyVar2;
                        break;
                    }
                } else {
                    dpyVarG = ewbVar.f();
                    j = 0;
                }
                dai daiVar = this.c;
                if (dpyVarG == null) {
                    while (true) {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ewb.a;
                        dpy dpyVar3 = (dpy) atomicReferenceFieldUpdater.get(ewbVar);
                        if (dpyVar3 == null) {
                            j2 = -1;
                        } else {
                            j2 = -1;
                            if (((dpyVar3.ad ? 1 : 2) & i) != 0) {
                                dqb.f.getClass();
                                ewb ewbVar2 = ewbVar;
                                long jNanoTime = System.nanoTime() - dpyVar3.ac;
                                long j4 = dqb.b;
                                if (jNanoTime < j4) {
                                    j3 = j4 - jNanoTime;
                                    dpyVar = null;
                                    break;
                                }
                                do {
                                    dpyVar = null;
                                    if (atomicReferenceFieldUpdater.compareAndSet(ewbVar2, dpyVar3, null)) {
                                        daiVar.a = dpyVar3;
                                        j3 = -1;
                                        break;
                                    }
                                } while (atomicReferenceFieldUpdater.get(ewbVar2) == dpyVar3);
                                ewbVar = ewbVar2;
                                dpyVar2 = null;
                            }
                        }
                        j3 = -2;
                        dpyVar = dpyVar2;
                        break;
                    }
                } else {
                    daiVar.a = dpyVarG;
                    dpyVar = dpyVar2;
                    j3 = -1;
                    j2 = -1;
                }
                if (j3 == j2) {
                    dpy dpyVar4 = (dpy) daiVar.a;
                    daiVar.a = dpyVar;
                    return dpyVar4;
                }
                if (j3 > j) {
                    jMin = Math.min(jMin, j3);
                }
            }
            i3++;
            dpyVar2 = null;
        }
        if (jMin == Long.MAX_VALUE) {
            jMin = 0;
        }
        this.f = jMin;
        return null;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        long j;
        loop0: while (true) {
            boolean z = false;
            while (true) {
                if (aho.c.get(this.i) != 1) {
                    ahn ahnVar = this.d;
                    ahn ahnVar2 = ahn.e;
                    if (ahnVar == ahnVar2) {
                        break loop0;
                    }
                    dpy dpyVarJ = j(this.h);
                    if (dpyVarJ != null) {
                        this.f = 0L;
                        aho ahoVar = this.i;
                        this.e = 0L;
                        if (this.d == ahn.c) {
                            this.d = ahn.b;
                        }
                        if (!dpyVarJ.ad) {
                            try {
                                dpyVarJ.run();
                                break;
                            } catch (Throwable th) {
                                Thread threadCurrentThread = Thread.currentThread();
                                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
                                break;
                            }
                        }
                        if (q(ahn.b) && !ahoVar.p() && !ahoVar.o(aho.b.get(ahoVar))) {
                            ahoVar.p();
                        }
                        try {
                            dpyVarJ.run();
                        } catch (Throwable th2) {
                            Thread threadCurrentThread2 = Thread.currentThread();
                            threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th2);
                        }
                        aho.b.addAndGet(ahoVar, -2097152L);
                        if (this.d == ahnVar2) {
                            break;
                        }
                        this.d = ahn.d;
                        break;
                    }
                    this.h = false;
                    if (this.f == 0) {
                        Object obj = this.nextParkedWorker;
                        auj aujVar = aho.d;
                        if (obj != aujVar) {
                            a.set(this, -1);
                            while (this.nextParkedWorker != aho.d) {
                                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = a;
                                if (atomicIntegerFieldUpdater.get(this) != -1) {
                                    break;
                                }
                                aho ahoVar2 = this.i;
                                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater2 = aho.c;
                                if (atomicIntegerFieldUpdater2.get(ahoVar2) == 1) {
                                    break;
                                }
                                ahn ahnVar3 = this.d;
                                ahn ahnVar4 = ahn.e;
                                if (ahnVar3 == ahnVar4) {
                                    break;
                                }
                                q(ahn.c);
                                Thread.interrupted();
                                if (this.e == 0) {
                                    j = 2097151;
                                    this.e = System.nanoTime() + this.i.g;
                                } else {
                                    j = 2097151;
                                }
                                LockSupport.parkNanos(this.i.g);
                                if (System.nanoTime() - this.e >= 0) {
                                    this.e = 0L;
                                    aho ahoVar3 = this.i;
                                    synchronized (ahoVar3.k) {
                                        try {
                                            if (!(atomicIntegerFieldUpdater2.get(ahoVar3) == 1)) {
                                                AtomicLongFieldUpdater atomicLongFieldUpdater = aho.b;
                                                if (((int) (atomicLongFieldUpdater.get(ahoVar3) & j)) > ahoVar3.e) {
                                                    if (atomicIntegerFieldUpdater.compareAndSet(this, -1, 1)) {
                                                        int i = this.indexInArray;
                                                        o(0);
                                                        ahoVar3.n(this, i, 0);
                                                        int andDecrement = (int) (atomicLongFieldUpdater.getAndDecrement(ahoVar3) & j);
                                                        if (andDecrement != i) {
                                                            Object objB = ahoVar3.k.b(andDecrement);
                                                            bzo.n(objB);
                                                            ahm ahmVar = (ahm) objB;
                                                            ahoVar3.k.c(i, ahmVar);
                                                            ahmVar.o(i);
                                                            ahoVar3.n(ahmVar, andDecrement, i);
                                                        }
                                                        ahoVar3.k.c(andDecrement, null);
                                                        this.d = ahnVar4;
                                                    }
                                                }
                                            }
                                        } catch (Throwable th3) {
                                            throw th3;
                                        }
                                    }
                                }
                            }
                        } else {
                            aho ahoVar4 = this.i;
                            if (this.nextParkedWorker == aujVar) {
                                AtomicLongFieldUpdater atomicLongFieldUpdater2 = aho.a;
                                while (true) {
                                    long j2 = atomicLongFieldUpdater2.get(ahoVar4);
                                    int i2 = this.indexInArray;
                                    this.nextParkedWorker = ahoVar4.k.b((int) (j2 & 2097151));
                                    aho ahoVar5 = ahoVar4;
                                    if (aho.a.compareAndSet(ahoVar5, j2, ((j2 + 2097152) & (-2097152)) | ((long) i2))) {
                                        break;
                                    } else {
                                        ahoVar4 = ahoVar5;
                                    }
                                }
                            }
                        }
                    } else {
                        if (z) {
                            q(ahn.c);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f);
                            this.f = 0L;
                            break;
                        }
                        z = true;
                    }
                } else {
                    break loop0;
                }
            }
        }
        q(ahn.e);
    }
}
