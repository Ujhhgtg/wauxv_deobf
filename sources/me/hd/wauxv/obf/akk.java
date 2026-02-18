package me.hd.wauxv.obf;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class akk extends awu implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;
    public static final akk f;
    public static final long l;

    static {
        Long l2;
        akk akkVar = new akk();
        f = akkVar;
        akkVar.ab(false);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l2 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l2 = 1000L;
        }
        l = timeUnit.toNanos(l2.longValue());
    }

    @Override // me.hd.wauxv.obf.awv
    public final Thread g() {
        Thread thread;
        Thread thread2 = _thread;
        if (thread2 != null) {
            return thread2;
        }
        synchronized (this) {
            thread = _thread;
            if (thread == null) {
                thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
                _thread = thread;
                thread.setContextClassLoader(f.getClass().getClassLoader());
                thread.setDaemon(true);
                thread.start();
            }
        }
        return thread;
    }

    @Override // me.hd.wauxv.obf.awv
    public final void m(long j, aws awsVar) {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // me.hd.wauxv.obf.awu
    public final void n(Runnable runnable) {
        if (debugStatus == 4) {
            throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
        }
        super.n(runnable);
    }

    public final synchronized void o() {
        int i = debugStatus;
        if (i == 2 || i == 3) {
            debugStatus = 3;
            awu.p.set(this, null);
            awu.q.set(this, null);
            notifyAll();
        }
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException
    	at java.base/java.util.Objects.requireNonNull(Objects.java:209)
    	at java.base/java.util.ArrayList.batchRemove(ArrayList.java:816)
    	at java.base/java.util.ArrayList.removeAll(ArrayList.java:791)
    	at jadx.core.dex.visitors.finaly.TryCatchEdgeBlockMap.getAllInScope(TryCatchEdgeBlockMap.java:91)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(MarkFinallyVisitor.java:204)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:119)
     */
    @Override // java.lang.Runnable
    public final void run() {
        dro.a.set(this);
        try {
            synchronized (this) {
                try {
                    int i = debugStatus;
                    if (i == 2 || i == 3) {
                        _thread = null;
                        o();
                        if (u()) {
                            return;
                        }
                        g();
                        return;
                    }
                    debugStatus = 1;
                    notifyAll();
                    long j = Long.MAX_VALUE;
                    while (true) {
                        Thread.interrupted();
                        long jV = v();
                        if (jV == Long.MAX_VALUE) {
                            long jNanoTime = System.nanoTime();
                            if (j == Long.MAX_VALUE) {
                                j = l + jNanoTime;
                            }
                            long j2 = j - jNanoTime;
                            if (j2 <= 0) {
                                _thread = null;
                                o();
                                if (u()) {
                                    return;
                                }
                                g();
                                return;
                            }
                            if (jV > j2) {
                                jV = j2;
                            }
                        } else {
                            j = Long.MAX_VALUE;
                        }
                        if (jV > 0) {
                            int i2 = debugStatus;
                            if (i2 == 2 || i2 == 3) {
                                _thread = null;
                                o();
                                if (u()) {
                                    return;
                                }
                                g();
                                return;
                            }
                            LockSupport.parkNanos(this, jV);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            _thread = null;
            o();
            if (!u()) {
                g();
            }
            throw th2;
        }
    }

    @Override // me.hd.wauxv.obf.awu, me.hd.wauxv.obf.awv
    public final void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    @Override // me.hd.wauxv.obf.ahj
    public final String toString() {
        return "DefaultExecutor";
    }
}
