package me.hd.wauxv.obf;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class hm implements Executor {
    public final Object a = new Object();
    public final ArrayDeque b = new ArrayDeque();
    public final hn c;
    public Runnable d;

    public hm(hn hnVar) {
        this.c = hnVar;
    }

    public final void e() {
        synchronized (this.a) {
            try {
                Runnable runnable = (Runnable) this.b.poll();
                this.d = runnable;
                if (runnable != null) {
                    this.c.execute(runnable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        synchronized (this.a) {
            try {
                this.b.add(new hl(this, 0, runnable));
                if (this.d == null) {
                    e();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
