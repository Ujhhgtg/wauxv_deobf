package me.hd.wauxv.obf;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ctv extends ae {
    @Override // me.hd.wauxv.obf.cyj
    public final int _bi(int i) {
        return ThreadLocalRandom.current().nextInt(0, i);
    }

    @Override // me.hd.wauxv.obf.ae
    public final Random d() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        bzo.p(threadLocalRandomCurrent, "current(...)");
        return threadLocalRandomCurrent;
    }
}
