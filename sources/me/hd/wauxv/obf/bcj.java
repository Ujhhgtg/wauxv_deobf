package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bcj extends bcz {
    public final /* synthetic */ bcm a;
    public final /* synthetic */ bck b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bcj(bcm bcmVar, bck bckVar, dhy dhyVar) {
        super(dhyVar);
        this.a = bcmVar;
        this.b = bckVar;
    }

    @Override // me.hd.wauxv.obf.bcz, me.hd.wauxv.obf.dhy, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        bcm bcmVar = this.a;
        bck bckVar = this.b;
        synchronized (bcmVar) {
            if (bckVar.d) {
                return;
            }
            bckVar.d = true;
            super.close();
            this.b.a.commit();
        }
    }
}
