package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class v implements Runnable {
    public final x a;
    public final /* synthetic */ y b;

    public v(y yVar, x xVar) {
        this.b = yVar;
        this.a = xVar;
    }

    public abstract Object c();

    public boolean d() {
        return this.b.b != null;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (d()) {
            this.a.f(c());
        } else {
            x xVar = this.a;
            synchronized (xVar) {
                xVar.e++;
                xVar.f(null);
            }
        }
    }
}
