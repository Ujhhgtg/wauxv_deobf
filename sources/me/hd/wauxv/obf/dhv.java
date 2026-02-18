package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dhv implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ dhw b;

    public dhv(dhw dhwVar, boolean z) {
        this.b = dhwVar;
        this.a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        eot.d();
        aom aomVar = this.b.a;
        boolean z = aomVar.a;
        boolean z2 = this.a;
        aomVar.a = z2;
        if (z != z2) {
            ((dhu) aomVar.b).a(z2);
        }
    }
}
