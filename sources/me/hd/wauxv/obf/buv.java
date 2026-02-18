package me.hd.wauxv.obf;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class buv implements Executor {
    public hl a;
    public hl b;

    public final synchronized void c() {
        hl hlVar = this.b;
        this.a = hlVar;
        this.b = null;
        if (hlVar != null) {
            aye.s().execute(this.a);
        }
    }

    @Override // java.util.concurrent.Executor
    public final synchronized void execute(Runnable runnable) {
        try {
            if (this.a == null) {
                this.a = new hl(this, 6, runnable);
                aye.s().execute(this.a);
            } else if (this.b == null) {
                this.b = new hl(this, 6, runnable);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
