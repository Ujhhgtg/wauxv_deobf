package me.hd.wauxv.obf;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aok implements Callable {
    public final /* synthetic */ aoo a;

    public aok(aoo aooVar) {
        this.a = aooVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        synchronized (this.a) {
            try {
                aoo aooVar = this.a;
                if (aooVar.i == null) {
                    return null;
                }
                aooVar.ab();
                if (this.a.w()) {
                    this.a.aa();
                    this.a.k = 0;
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
