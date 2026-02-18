package me.hd.wauxv.obf;

import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class nd {
    public final DexKitBridge a;
    public final int b;
    public final int c;

    public nd(DexKitBridge dexKitBridge, int i, int i2) {
        throwIfVar1IsNull(dexKitBridge, "bridge");
        this.a = dexKitBridge;
        this.b = i;
        this.c = i2;
    }

    public static long d(int i, int i2) {
        return ((long) i2) | (((long) i) << 32);
    }
}
