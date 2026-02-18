package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ccq implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ ccu b;

    public /* synthetic */ ccq(ccu ccuVar, int i) {
        this.a = i;
        this.b = ccuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case 0:
                cct cctVar = this.b.bl;
                if (cctVar != null) {
                    cctVar.r();
                }
                break;
            default:
                cct cctVar2 = this.b.bl;
                if (cctVar2 != null) {
                    cctVar2.p(cctVar2.c);
                    break;
                }
                break;
        }
    }
}
