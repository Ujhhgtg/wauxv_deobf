package me.hd.wauxv.obf;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class dew extends axe {
    public aho g;

    @Override // me.hd.wauxv.obf.ahj
    public final void i(ahh ahhVar, Runnable runnable) {
        aho ahoVar = this.g;
        AtomicLongFieldUpdater atomicLongFieldUpdater = aho.a;
        ahoVar.m(runnable, false);
    }
}
