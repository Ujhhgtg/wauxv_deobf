package me.hd.wauxv.obf;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class lo extends ekc {
    public static final lk Companion = new lk();
    private static final long IDLE_TIMEOUT_MILLIS;
    private static final long IDLE_TIMEOUT_NANOS;
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    private static final Condition condition;
    private static lo head;
    private static final ReentrantLock lock;
    private boolean inQueue;
    private lo next;
    private long timeoutAt;

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        lock = reentrantLock;
        Condition conditionNewCondition = reentrantLock.newCondition();
        throwIfVar1IsNull(conditionNewCondition, "newCondition(...)");
        condition = conditionNewCondition;
        long millis = TimeUnit.SECONDS.toMillis(60L);
        IDLE_TIMEOUT_MILLIS = millis;
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public static final long access$remainingNanos(lo loVar, long j) {
        return loVar.timeoutAt - j;
    }

    public final IOException access$newTimeoutException(IOException iOException) {
        return newTimeoutException(iOException);
    }

    public final void enter() {
        long jTimeoutNanos = timeoutNanos();
        boolean zHasDeadline = hasDeadline();
        if (jTimeoutNanos != 0 || zHasDeadline) {
            lk lkVar = Companion;
            lkVar.getClass();
            lkVar.getClass();
            ReentrantLock reentrantLock = lock;
            reentrantLock.lock();
            try {
                if (this.inQueue) {
                    throw new IllegalStateException("Unbalanced enter/exit");
                }
                this.inQueue = true;
                if (head == null) {
                    head = new lo();
                    ll llVar = new ll("Okio Watchdog");
                    llVar.setDaemon(true);
                    llVar.start();
                }
                long jNanoTime = System.nanoTime();
                if (jTimeoutNanos != 0 && zHasDeadline) {
                    this.timeoutAt = Math.min(jTimeoutNanos, deadlineNanoTime() - jNanoTime) + jNanoTime;
                } else if (jTimeoutNanos != 0) {
                    this.timeoutAt = jTimeoutNanos + jNanoTime;
                } else {
                    if (!zHasDeadline) {
                        throw new AssertionError();
                    }
                    this.timeoutAt = deadlineNanoTime();
                }
                long jAccess$remainingNanos = access$remainingNanos(this, jNanoTime);
                lo loVar = head;
                throwIfVar1IsNull(loVar);
                while (loVar.next != null) {
                    lo loVar2 = loVar.next;
                    throwIfVar1IsNull(loVar2);
                    if (jAccess$remainingNanos < access$remainingNanos(loVar2, jNanoTime)) {
                        break;
                    }
                    loVar = loVar.next;
                    throwIfVar1IsNull(loVar);
                }
                this.next = loVar.next;
                loVar.next = this;
                if (loVar == head) {
                    Companion.getClass();
                    condition.signal();
                }
                reentrantLock.unlock();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    public final boolean exit() {
        lk lkVar = Companion;
        lkVar.getClass();
        lkVar.getClass();
        ReentrantLock reentrantLock = lock;
        reentrantLock.lock();
        try {
            if (!this.inQueue) {
                return false;
            }
            this.inQueue = false;
            for (lo loVar = head; loVar != null; loVar = loVar.next) {
                if (loVar.next == this) {
                    loVar.next = this.next;
                    this.next = null;
                    return false;
                }
            }
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }

    public IOException newTimeoutException(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final dhy sink(dhy dhyVar) {
        throwIfVar1IsNull(dhyVar, "sink");
        return new lm(this, 0, dhyVar);
    }

    public final dlc source(dlc dlcVar) {
        throwIfVar1IsNull(dlcVar, "source");
        return new ln(this, dlcVar);
    }

    public void timedOut() {
    }

    public final <T> T withTimeout(IFunction0 bfuVar) throws IOException {
        throwIfVar1IsNull(bfuVar, "block");
        enter();
        try {
            try {
                T t = (T) bfuVar.invoke();
                if (exit()) {
                    throw access$newTimeoutException(null);
                }
                return t;
            } catch (IOException e) {
                if (exit()) {
                    throw access$newTimeoutException(e);
                }
                throw e;
            }
        } catch (Throwable th) {
            exit();
            throw th;
        }
    }
}
