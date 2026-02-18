package me.hd.wauxv.obf;

import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aya extends ae {
    public final axz e = new axz(0);

    @Override // me.hd.wauxv.obf.ae
    public final Random d() {
        Object obj = this.e.get();
        bzo.p(obj, "get(...)");
        return (Random) obj;
    }
}
