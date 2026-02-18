package me.hd.wauxv.obf;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ekc {
    public static final ekb Companion = new ekb();
    public static final ekc NONE = new eka();
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    public final void awaitSignal(Condition condition) throws InterruptedIOException {
        bzo.q(condition, "condition");
        try {
            boolean zHasDeadline = hasDeadline();
            long jTimeoutNanos = timeoutNanos();
            long jNanoTime = 0;
            if (!zHasDeadline && jTimeoutNanos == 0) {
                condition.await();
                return;
            }
            long jNanoTime2 = System.nanoTime();
            if (zHasDeadline && jTimeoutNanos != 0) {
                jTimeoutNanos = Math.min(jTimeoutNanos, deadlineNanoTime() - jNanoTime2);
            } else if (zHasDeadline) {
                jTimeoutNanos = deadlineNanoTime() - jNanoTime2;
            }
            if (jTimeoutNanos > 0) {
                condition.await(jTimeoutNanos, TimeUnit.NANOSECONDS);
                jNanoTime = System.nanoTime() - jNanoTime2;
            }
            if (jNanoTime >= jTimeoutNanos) {
                throw new InterruptedIOException("timeout");
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }

    public ekc clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    public ekc clearTimeout() {
        this.timeoutNanos = 0L;
        return this;
    }

    public final ekc deadline(long j, TimeUnit timeUnit) {
        bzo.q(timeUnit, "unit");
        if (j <= 0) {
            throw new IllegalArgumentException(dts.b(j, "duration <= 0: ").toString());
        }
        return deadlineNanoTime(timeUnit.toNanos(j) + System.nanoTime());
    }

    public long deadlineNanoTime() {
        if (this.hasDeadline) {
            return this.deadlineNanoTime;
        }
        throw new IllegalStateException("No deadline");
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public final <T> T intersectWith(ekc ekcVar, bfu bfuVar) {
        bzo.q(ekcVar, "other");
        bzo.q(bfuVar, "block");
        long jTimeoutNanos = timeoutNanos();
        ekb ekbVar = Companion;
        long jTimeoutNanos2 = ekcVar.timeoutNanos();
        long jTimeoutNanos3 = timeoutNanos();
        ekbVar.getClass();
        if (jTimeoutNanos2 == 0 || (jTimeoutNanos3 != 0 && jTimeoutNanos2 >= jTimeoutNanos3)) {
            jTimeoutNanos2 = jTimeoutNanos3;
        }
        timeout(jTimeoutNanos2, TimeUnit.NANOSECONDS);
        if (!hasDeadline()) {
            if (ekcVar.hasDeadline()) {
                deadlineNanoTime(ekcVar.deadlineNanoTime());
            }
            try {
                return (T) bfuVar.invoke();
            } finally {
                timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
                if (ekcVar.hasDeadline()) {
                    clearDeadline();
                }
            }
        }
        long jDeadlineNanoTime = deadlineNanoTime();
        if (ekcVar.hasDeadline()) {
            deadlineNanoTime(Math.min(deadlineNanoTime(), ekcVar.deadlineNanoTime()));
        }
        try {
            return (T) bfuVar.invoke();
        } finally {
            timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
            if (ekcVar.hasDeadline()) {
                deadlineNanoTime(jDeadlineNanoTime);
            }
        }
    }

    public void throwIfReached() throws InterruptedIOException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        if (this.hasDeadline && this.deadlineNanoTime - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public ekc timeout(long j, TimeUnit timeUnit) {
        bzo.q(timeUnit, "unit");
        if (j < 0) {
            throw new IllegalArgumentException(dts.b(j, "timeout < 0: ").toString());
        }
        this.timeoutNanos = timeUnit.toNanos(j);
        return this;
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public final void waitUntilNotified(Object obj) throws InterruptedIOException {
        bzo.q(obj, "monitor");
        try {
            boolean zHasDeadline = hasDeadline();
            long jTimeoutNanos = timeoutNanos();
            long jNanoTime = 0;
            if (!zHasDeadline && jTimeoutNanos == 0) {
                obj.wait();
                return;
            }
            long jNanoTime2 = System.nanoTime();
            if (zHasDeadline && jTimeoutNanos != 0) {
                jTimeoutNanos = Math.min(jTimeoutNanos, deadlineNanoTime() - jNanoTime2);
            } else if (zHasDeadline) {
                jTimeoutNanos = deadlineNanoTime() - jNanoTime2;
            }
            if (jTimeoutNanos > 0) {
                long j = jTimeoutNanos / 1000000;
                obj.wait(j, (int) (jTimeoutNanos - (1000000 * j)));
                jNanoTime = System.nanoTime() - jNanoTime2;
            }
            if (jNanoTime >= jTimeoutNanos) {
                throw new InterruptedIOException("timeout");
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }

    public ekc deadlineNanoTime(long j) {
        this.hasDeadline = true;
        this.deadlineNanoTime = j;
        return this;
    }
}
