package okhttp3.internal.connection;

import java.lang.ref.Reference;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import me.hd.wauxv.obf.akd;
import me.hd.wauxv.obf.bzo;
import me.hd.wauxv.obf.dts;
import me.hd.wauxv.obf.yg;
import okhttp3.Address;
import okhttp3.ConnectionPool;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.platform.Platform;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class RealConnectionPool {
    public static final Companion Companion = new Companion(null);
    private final TaskQueue cleanupQueue;
    private final RealConnectionPool$cleanupTask$1 cleanupTask;
    private final ConcurrentLinkedQueue<RealConnection> connections;
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static final class Companion {
        public /* synthetic */ Companion(akd akdVar) {
            this();
        }

        public final RealConnectionPool get(ConnectionPool connectionPool) {
            bzo.q(connectionPool, "connectionPool");
            return connectionPool.getDelegate$okhttp();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [okhttp3.internal.connection.RealConnectionPool$cleanupTask$1] */
    public RealConnectionPool(TaskRunner taskRunner, int i, long j, TimeUnit timeUnit) {
        bzo.q(taskRunner, "taskRunner");
        bzo.q(timeUnit, "timeUnit");
        this.maxIdleConnections = i;
        this.keepAliveDurationNs = timeUnit.toNanos(j);
        this.cleanupQueue = taskRunner.newQueue();
        final String strO = yg.o(new StringBuilder(), Util.okHttpName, " ConnectionPool");
        this.cleanupTask = new Task(strO) { // from class: okhttp3.internal.connection.RealConnectionPool$cleanupTask$1
            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                return this.this$0.cleanup(System.nanoTime());
            }
        };
        this.connections = new ConcurrentLinkedQueue<>();
        if (j <= 0) {
            throw new IllegalArgumentException(dts.b(j, "keepAliveDuration <= 0: ").toString());
        }
    }

    private final int pruneAndGetAllocationCount(RealConnection realConnection, long j) {
        if (Util.assertionsEnabled && !Thread.holdsLock(realConnection)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + realConnection);
        }
        List<Reference<RealCall>> calls = realConnection.getCalls();
        int i = 0;
        while (i < calls.size()) {
            Reference<RealCall> reference = calls.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                Platform.Companion.get().logCloseableLeak("A connection to " + realConnection.route().address().url() + " was leaked. Did you forget to close a response body?", ((RealCall.CallReference) reference).getCallStackTrace());
                calls.remove(i);
                realConnection.setNoNewExchanges(true);
                if (calls.isEmpty()) {
                    realConnection.setIdleAtNs$okhttp(j - this.keepAliveDurationNs);
                    return 0;
                }
            }
        }
        return calls.size();
    }

    /* JADX WARN: Found duplicated region for block: B:28:0x0033 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:30:0x0039 A[SYNTHETIC] */
    public final boolean callAcquirePooledConnection(Address address, RealCall realCall, List<Route> list, boolean z) {
        bzo.q(address, "address");
        bzo.q(realCall, "call");
        for (RealConnection realConnection : this.connections) {
            bzo.p(realConnection, "connection");
            synchronized (realConnection) {
                if (z) {
                    try {
                        if (!realConnection.isMultiplexed$okhttp()) {
                            continue;
                        } else if (realConnection.isEligible$okhttp(address, list)) {
                            realCall.acquireConnectionNoEvents(realConnection);
                            return true;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                } else if (realConnection.isEligible$okhttp(address, list)) {
                    realCall.acquireConnectionNoEvents(realConnection);
                    return true;
                }
            }
        }
        return false;
    }

    public final long cleanup(long j) {
        int i = 0;
        long j2 = Long.MIN_VALUE;
        RealConnection realConnection = null;
        int i2 = 0;
        for (RealConnection realConnection2 : this.connections) {
            bzo.p(realConnection2, "connection");
            synchronized (realConnection2) {
                if (pruneAndGetAllocationCount(realConnection2, j) > 0) {
                    i2++;
                } else {
                    i++;
                    long idleAtNs$okhttp = j - realConnection2.getIdleAtNs$okhttp();
                    if (idleAtNs$okhttp > j2) {
                        realConnection = realConnection2;
                        j2 = idleAtNs$okhttp;
                    }
                }
            }
        }
        long j3 = this.keepAliveDurationNs;
        if (j2 < j3 && i <= this.maxIdleConnections) {
            if (i > 0) {
                return j3 - j2;
            }
            if (i2 > 0) {
                return j3;
            }
            return -1L;
        }
        bzo.n(realConnection);
        synchronized (realConnection) {
            if (!realConnection.getCalls().isEmpty()) {
                return 0L;
            }
            if (realConnection.getIdleAtNs$okhttp() + j2 != j) {
                return 0L;
            }
            realConnection.setNoNewExchanges(true);
            this.connections.remove(realConnection);
            Util.closeQuietly(realConnection.socket());
            if (this.connections.isEmpty()) {
                this.cleanupQueue.cancelAll();
            }
            return 0L;
        }
    }

    public final boolean connectionBecameIdle(RealConnection realConnection) {
        bzo.q(realConnection, "connection");
        if (Util.assertionsEnabled && !Thread.holdsLock(realConnection)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + realConnection);
        }
        if (!realConnection.getNoNewExchanges() && this.maxIdleConnections != 0) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
            return false;
        }
        realConnection.setNoNewExchanges(true);
        this.connections.remove(realConnection);
        if (this.connections.isEmpty()) {
            this.cleanupQueue.cancelAll();
        }
        return true;
    }

    public final int connectionCount() {
        return this.connections.size();
    }

    public final void evictAll() {
        Socket socket;
        Iterator<RealConnection> it = this.connections.iterator();
        bzo.p(it, "connections.iterator()");
        while (it.hasNext()) {
            RealConnection next = it.next();
            bzo.p(next, "connection");
            synchronized (next) {
                if (next.getCalls().isEmpty()) {
                    it.remove();
                    next.setNoNewExchanges(true);
                    socket = next.socket();
                } else {
                    socket = null;
                }
            }
            if (socket != null) {
                Util.closeQuietly(socket);
            }
        }
        if (this.connections.isEmpty()) {
            this.cleanupQueue.cancelAll();
        }
    }

    public final int idleConnectionCount() {
        boolean zIsEmpty;
        ConcurrentLinkedQueue<RealConnection> concurrentLinkedQueue = this.connections;
        int i = 0;
        if (concurrentLinkedQueue != null && concurrentLinkedQueue.isEmpty()) {
            return 0;
        }
        for (RealConnection realConnection : concurrentLinkedQueue) {
            bzo.p(realConnection, "it");
            synchronized (realConnection) {
                zIsEmpty = realConnection.getCalls().isEmpty();
            }
            if (zIsEmpty && (i = i + 1) < 0) {
                throw new ArithmeticException("Count overflow has happened.");
            }
        }
        return i;
    }

    public final void put(RealConnection realConnection) {
        bzo.q(realConnection, "connection");
        if (!Util.assertionsEnabled || Thread.holdsLock(realConnection)) {
            this.connections.add(realConnection);
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        } else {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + realConnection);
        }
    }
}
