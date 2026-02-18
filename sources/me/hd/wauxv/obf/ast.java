package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ast implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ asv b;

    public /* synthetic */ ast(asv asvVar, int i) {
        this.a = i;
        this.b = asvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case 0:
                long jCurrentTimeMillis = System.currentTimeMillis();
                asv asvVar = this.b;
                if (jCurrentTimeMillis - asvVar.p >= 3500) {
                    asvVar.a.invalidate();
                }
                break;
            default:
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                asv asvVar2 = this.b;
                if (jCurrentTimeMillis2 - asvVar2.o >= 3000) {
                    asvVar2.a.invalidate();
                }
                break;
        }
    }
}
