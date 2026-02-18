package me.hd.wauxv.obf;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bdc extends dt {
    public final /* synthetic */ AtomicReference b;

    public bdc(AtomicReference atomicReference) {
        this.b = atomicReference;
    }

    @Override // me.hd.wauxv.obf.dt
    public final void a(String str) {
        dt dtVar = (dt) this.b.get();
        if (dtVar == null) {
            throw new IllegalStateException("Operation cannot be started before fragment is in created state");
        }
        dtVar.a(str);
    }
}
