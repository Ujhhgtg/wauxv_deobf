package me.hd.wauxv.obf;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bhz implements ThreadFactory {
    public final dd a;
    public final String b;
    public final arj c;
    public final boolean d;
    public final AtomicInteger e;

    public bhz(dd ddVar, String str, boolean z) {
        arj arjVar = arj.h;
        this.e = new AtomicInteger();
        this.a = ddVar;
        this.b = str;
        this.c = arjVar;
        this.d = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        cs csVar = new cs(this, 6, runnable);
        this.a.getClass();
        ll llVar = new ll(csVar);
        llVar.setName("glide-" + this.b + "-thread-" + this.e.getAndIncrement());
        return llVar;
    }
}
