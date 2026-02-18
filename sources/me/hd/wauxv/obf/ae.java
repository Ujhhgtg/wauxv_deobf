package me.hd.wauxv.obf;

import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ae extends cyj {
    @Override // me.hd.wauxv.obf.cyj
    public final int a(int i) {
        return ((-i) >> 31) & (d().nextInt() >>> (32 - i));
    }

    @Override // me.hd.wauxv.obf.cyj
    public final int b() {
        return d().nextInt();
    }

    @Override // me.hd.wauxv.obf.cyj
    public final int c(int i) {
        return d().nextInt(i);
    }

    public abstract Random d();
}
