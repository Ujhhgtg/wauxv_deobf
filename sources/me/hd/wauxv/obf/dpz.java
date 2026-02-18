package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dpz extends dpy {
    public final Runnable a;

    public dpz(Runnable runnable, long j, boolean z) {
        super(z, j);
        this.a = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.run();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Task[");
        Runnable runnable = this.a;
        sb.append(runnable.getClass().getSimpleName());
        sb.append('@');
        sb.append(ajn.q(runnable));
        sb.append(", ");
        sb.append(this.ac);
        sb.append(", ");
        return concat(sb, this.ad ? "Blocking" : "Non-blocking", ']');
    }
}
