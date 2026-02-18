package me.hd.wauxv.obf;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eka extends ekc {
    @Override // me.hd.wauxv.obf.ekc
    public final ekc deadlineNanoTime(long j) {
        return this;
    }

    @Override // me.hd.wauxv.obf.ekc
    public final void throwIfReached() {
    }

    @Override // me.hd.wauxv.obf.ekc
    public final ekc timeout(long j, TimeUnit timeUnit) {
        throwIfVar1IsNull(timeUnit, "unit");
        return this;
    }
}
