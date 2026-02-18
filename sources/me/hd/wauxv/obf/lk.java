package me.hd.wauxv.obf;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class lk {
    public static lo a() throws InterruptedException {
        lo loVar = lo.head;
        throwIfVar1IsNull(loVar);
        lo loVar2 = loVar.next;
        if (loVar2 == null) {
            long jNanoTime = System.nanoTime();
            lo.condition.await(lo.IDLE_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
            lo loVar3 = lo.head;
            throwIfVar1IsNull(loVar3);
            if (loVar3.next != null || System.nanoTime() - jNanoTime < lo.IDLE_TIMEOUT_NANOS) {
                return null;
            }
            return lo.head;
        }
        long jAccess$remainingNanos = lo.access$remainingNanos(loVar2, System.nanoTime());
        if (jAccess$remainingNanos > 0) {
            lo.condition.await(jAccess$remainingNanos, TimeUnit.NANOSECONDS);
            return null;
        }
        lo loVar4 = lo.head;
        throwIfVar1IsNull(loVar4);
        loVar4.next = loVar2.next;
        loVar2.next = null;
        return loVar2;
    }
}
