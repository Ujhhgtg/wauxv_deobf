package me.hd.wauxv.obf;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import net.bytebuddy.implementation.MethodDelegation;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bdb extends ekc {
    public ekc a;

    public bdb(ekc ekcVar) {
        throwIfVar1IsNull(ekcVar, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        this.a = ekcVar;
    }

    @Override // me.hd.wauxv.obf.ekc
    public final ekc clearDeadline() {
        return this.a.clearDeadline();
    }

    @Override // me.hd.wauxv.obf.ekc
    public final ekc clearTimeout() {
        return this.a.clearTimeout();
    }

    @Override // me.hd.wauxv.obf.ekc
    public final long deadlineNanoTime() {
        return this.a.deadlineNanoTime();
    }

    @Override // me.hd.wauxv.obf.ekc
    public final boolean hasDeadline() {
        return this.a.hasDeadline();
    }

    @Override // me.hd.wauxv.obf.ekc
    public final void throwIfReached() throws InterruptedIOException {
        this.a.throwIfReached();
    }

    @Override // me.hd.wauxv.obf.ekc
    public final ekc timeout(long j, TimeUnit timeUnit) {
        throwIfVar1IsNull(timeUnit, "unit");
        return this.a.timeout(j, timeUnit);
    }

    @Override // me.hd.wauxv.obf.ekc
    public final long timeoutNanos() {
        return this.a.timeoutNanos();
    }

    @Override // me.hd.wauxv.obf.ekc
    public final ekc deadlineNanoTime(long j) {
        return this.a.deadlineNanoTime(j);
    }
}
